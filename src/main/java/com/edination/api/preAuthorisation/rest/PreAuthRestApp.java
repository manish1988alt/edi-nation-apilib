package com.edination.api.preAuthorisation.rest;

import com.edination.api.Dao.*;
import com.edination.api.eligibility.EDIFile.SFTPFILE;
import com.edination.api.eligibility.model.*;
import com.edination.api.preAuthorisation.EDI.EDIFileGeneration;
import com.edination.api.preAuthorisation.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.*;

@RestController
@RequestMapping("preAuthorization")
public class PreAuthRestApp implements Serializable {
    @Autowired
    PreAuthService preAuthService;
    @Autowired
    PreAuthRepository preAuthRepository;
    @Autowired
    RequestServiceRepository requestServiceRepository;
    @Autowired
    PreAuthDemographicService preAuthDemographicService;
    @Autowired
    PreAuthDemographicsRepository preAuthDemographicsRepository;
    @Autowired
    HomeHealthPreAuthFormService homeHealthPreAuthFormService;
    @Autowired
    HomeHealthPreAuthFormRepository homeHealthPreAuthFormRepository;

    @Autowired
    PreAuthorizationResponseRepository preAuthorizationResponseRepository;
    @GetMapping("/preAuthList")
    public List<PreAuthDetail> preAuthList()  throws Throwable
    {
        List<PreAuthDetail> list=new ArrayList<>();
        List<PreAuthDemographics> authDemographicsList=preAuthDemographicService.listAll();

        Set<String> setmrn=new HashSet<>();

        for(PreAuthDemographics preAuthDemographics:authDemographicsList)
        {
            setmrn.add(preAuthDemographics.getMrnNumber());
        }
        for(String mrn:setmrn)
        {
            list.addAll(preAuthRepository.findByID(mrn));
        }
  // List<PreAuthDetail> list=preAuthService.listAll();

        return   list;
    }

    @PostMapping("/preauthview")
    public List<HomeHealthPreAuthorizationForm> preAuthView(@RequestBody  HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm)  throws Throwable
    {
    // List<HomeHealthPreAuthorizationForm> list=  homeHealthPreAuthFormRepository.findByMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
        List<HomeHealthPreAuthorizationForm> list=   homeHealthPreAuthFormRepository.findByID(homeHealthPreAuthorizationForm.getMrnNumber());
    return list;
    }

    @PostMapping("/preauthSave")
    public ResponseEntity<?> preAuthSave(@RequestBody  HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm)  throws Throwable
    {
        String ackn="false";
        ackn=this.saveOperation(homeHealthPreAuthorizationForm);

        PreAuthDetail preAuthDetail=new PreAuthDetail();
        List<PreAuthDetail> list= preAuthRepository.findByMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
        PreAuthDemographics demographics1=new PreAuthDemographics();
        Episode episode=new Episode();
        for(PreAuthDetail pre:list) {
            demographics1.setMrnNumber(pre.getPreAuthDemographics().getMrnNumber());
            demographics1.setFirstName(pre.getPreAuthDemographics().getFirstName());
            demographics1.setLastName(pre.getPreAuthDemographics().getLastName());
            demographics1.setMiddleName(pre.getPreAuthDemographics().getMiddleName());
            demographics1.setSuffix(pre.getPreAuthDemographics().getSuffix());
            demographics1.setDob(pre.getPreAuthDemographics().getDob());
            demographics1.setGender(pre.getPreAuthDemographics().getGender());
            demographics1.setSsn(pre.getPreAuthDemographics().getSsn());

            episode.setAdmissionDate(homeHealthPreAuthorizationForm.getAdmissionDetail().getAdmissionDate());
            episode.setAdmissionStatus(pre.getEpisode().getAdmissionStatus());
            episode.setEpisodeType(pre.getEpisode().getEpisodeType());
            episode.setMrnNumber(pre.getEpisode().getMrnNumber());
            episode.setPreauthFormStatus("Saved As Draft");
            episode.setPreAuthorisationStatus(pre.getEpisode().getPreAuthorisationStatus());
            episode.setPayorType(pre.getEpisode().getPayorType());
            episode.setFormSentDate(homeHealthPreAuthorizationForm.getCurrenttimdate());
            preAuthDetail.setPreAuthDemographics(demographics1);
            preAuthDetail.setEpisode(episode);
            preAuthDetail.setMrnNumber(pre.getMrnNumber());
        }
        preAuthService.save(preAuthDetail);
        if(ackn.equals("true")) {
            return generateSuccessObject("true",
                    " ");
        }
        else
        {
            return generateSuccessObject("false",
                    "Save failed ");
        }


    }

    @PostMapping("/preauthSendRequest")
    public ResponseEntity<?> preAuthSendRequest(@RequestBody  HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm)  throws Throwable {
        File file = new File("Hipaa-5010-278-GenericRequest.txt");
        String ackn="false";
        generateFile(homeHealthPreAuthorizationForm, file);
      new SFTPFILE().fileUpload(file, homeHealthPreAuthorizationForm.getMrnNumber() + "_" + file.getName());

       this.saveOperation(homeHealthPreAuthorizationForm);
        PreAuthDetail preAuthDetail=new PreAuthDetail();
        List<PreAuthDetail> list= preAuthRepository.findByMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
        PreAuthDemographics demographics1=new PreAuthDemographics();
        Episode episode=new Episode();
        for(PreAuthDetail pre:list) {
            demographics1.setMrnNumber(pre.getPreAuthDemographics().getMrnNumber());
            demographics1.setFirstName(pre.getPreAuthDemographics().getFirstName());
            demographics1.setLastName(pre.getPreAuthDemographics().getLastName());
            demographics1.setMiddleName(pre.getPreAuthDemographics().getMiddleName());
            demographics1.setSuffix(pre.getPreAuthDemographics().getSuffix());
            demographics1.setDob(pre.getPreAuthDemographics().getDob());
            demographics1.setGender(pre.getPreAuthDemographics().getGender());
            demographics1.setSsn(pre.getPreAuthDemographics().getSsn());

            episode.setAdmissionDate(homeHealthPreAuthorizationForm.getAdmissionDetail().getAdmissionDate());
            episode.setAdmissionStatus(pre.getEpisode().getAdmissionStatus());
            episode.setEpisodeType(pre.getEpisode().getEpisodeType());
            episode.setMrnNumber(pre.getEpisode().getMrnNumber());
            episode.setPreauthFormStatus("Sent For Approval");
            episode.setPreAuthorisationStatus(pre.getEpisode().getPreAuthorisationStatus());
            episode.setPayorType(pre.getEpisode().getPayorType());
            episode.setFormSentDate(homeHealthPreAuthorizationForm.getCurrenttimdate());
            preAuthDetail.setPreAuthDemographics(demographics1);
            preAuthDetail.setEpisode(episode);
            preAuthDetail.setMrnNumber(pre.getMrnNumber());
        }
        preAuthService.save(preAuthDetail);
        ackn="true";
        if(ackn.equals("true")) {
            return generateSuccessObject("true",
                    " ");
        }
        else
        {
            return generateSuccessObject("false",
                    "Sent failed ");
        }


    }

    @PostMapping("/preAuthResponse")
    public List<PreAuthorizationResponse> preAuthResponse(@RequestBody  HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm)  throws Throwable
    {

        return preAuthorizationResponseRepository.findByID(homeHealthPreAuthorizationForm.getMrnNumber());
    }


    public String saveOperation(HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm)
{
    String ackn="false";
    HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm1=new HomeHealthPreAuthorizationForm();
    homeHealthPreAuthorizationForm1.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
    homeHealthPreAuthorizationForm1.setCurrenttimdate(homeHealthPreAuthorizationForm.getCurrenttimdate());

    InsuranceDetailPreAuth insuranceDetailPreAuth=new InsuranceDetailPreAuth();
    insuranceDetailPreAuth.setMrnNumber(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getMrnNumber());
    //if((homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getInsuranceTypeSelcted()).equals("Primary Insurance"))
    /*if("Primary Insurance".equals(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getInsuranceTypeSelcted()))
    {*/
        insuranceDetailPreAuth.setInsuranceTypeSelcted(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getInsuranceTypeSelcted());
        PrimaryInsuranceDetail primary=new PrimaryInsuranceDetail();
        primary.setInsuredfirstName(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getInsuredfirstName());
        primary.setInsuredlastName(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getInsuredlastName());
        primary.setInsuredmiddleName(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getInsuredmiddleName());
        primary.setInsureddob(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getInsureddob());
        primary.setInsuredsex(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getInsuredsex());
        primary.setMrnNumber(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getMrnNumber());
        primary.setSsn(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getSsn());
        primary.setInsuranceAddress(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getInsuranceAddress());
        primary.setCity(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getCity());
        primary.setState(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getState());
        primary.setZipcode(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getZipcode());
        primary.setMop(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getMop());
        primary.setPolicyNumber(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getPolicyNumber());
        primary.setGroup_name(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getGroup_name());
        primary.setInsurancePlanName(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getInsurancePlanName());
        primary.setInsurancePlanType(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getInsurancePlanType());
        primary.setPatientRelationInsured(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getPatientRelationInsured());
        primary.setEligibility(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getEligibility());
        primary.setEligibilityCheckSelected(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getEligibilityCheckSelected());
        primary.setStartDate(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getStartDate());
        primary.setEndDate(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getEndDate());
        primary.setStatusVerifiedDate(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getStatusVerifiedDate());

        insuranceDetailPreAuth.setPrimaryInsuranceDetail(primary);
    //}

    //if((homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail()).equals("Secondary Insurance"))
    /*if("Secondary Insurance".equals(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getInsuranceTypeSelcted()))
    {*/

        insuranceDetailPreAuth.setInsuranceTypeSelcted(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getInsuranceTypeSelcted());
        SecondaryInsuranceDetail secondary=new SecondaryInsuranceDetail();
        secondary.setInsuredfirstName(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getInsuredfirstName());
        secondary.setInsuredlastName(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getInsuredlastName());
        secondary.setInsuredmiddleName(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getInsuredmiddleName());
        secondary.setInsureddob(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getInsureddob());
        secondary.setInsuredsex(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getInsuredsex());
        secondary.setMrnNumber(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getMrnNumber());
        secondary.setSsn(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getSsn());
        secondary.setInsuranceAddress(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getInsuranceAddress());
        secondary.setCity(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getCity());
        secondary.setState(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getState());
        secondary.setZipcode(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getZipcode());
        secondary.setMop(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getMop());
        secondary.setPolicyNumber(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getPolicyNumber());
        secondary.setGroup_name(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getGroup_name());
        secondary.setInsurancePlanName(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getInsurancePlanName());
        secondary.setInsurancePlanType(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getInsurancePlanType());
        secondary.setPatientRelationInsured(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getPatientRelationInsured());
        secondary.setEligibility(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getEligibility());
        secondary.setEligibilityCheckSelected(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getEligibilityCheckSelected());
        secondary.setStartDate(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getStartDate());
        secondary.setEndDate(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getEndDate());
        secondary.setStatusVerifiedDate(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getStatusVerifiedDate());
        insuranceDetailPreAuth.setSecondaryInsuranceDetail(secondary);

    //}
    //if((homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail()).equals("Tertiary Insurance"))
    /*if("Tertiary Insurance".equals(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getInsuranceTypeSelcted()))
    {*/
        insuranceDetailPreAuth.setInsuranceTypeSelcted(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getInsuranceTypeSelcted());
        TertiaryInsuranceDetail tertiary=new  TertiaryInsuranceDetail();

        tertiary.setInsuredfirstName(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getInsuredfirstName());
        tertiary.setInsuredlastName(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getInsuredlastName());
        tertiary.setInsuredmiddleName(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getInsuredmiddleName());
        tertiary.setInsureddob(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getInsureddob());
        tertiary.setInsuredsex(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getInsuredsex());
        tertiary.setMrnNumber(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getMrnNumber());
        tertiary.setSsn(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getSsn());
        tertiary.setInsuranceAddress(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getInsuranceAddress());
        tertiary.setCity(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getCity());
        tertiary.setState(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getState());
        tertiary.setZipcode(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getZipcode());
        tertiary.setMop(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getMop());
        tertiary.setPolicyNumber(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getPolicyNumber());
        tertiary.setGroup_name(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getGroup_name());
        tertiary.setInsurancePlanName(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getInsurancePlanName());
        tertiary.setInsurancePlanType(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getInsurancePlanType());
        tertiary.setPatientRelationInsured(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getPatientRelationInsured());
        tertiary.setEligibility(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getEligibility());
        tertiary.setEligibilityCheckSelected(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getEligibilityCheckSelected());
        tertiary.setStartDate(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getStartDate());
        tertiary.setEndDate(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getEndDate());
        tertiary.setStatusVerifiedDate(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getStatusVerifiedDate());
        insuranceDetailPreAuth.setTertiaryInsuranceDetail(tertiary);
   // }
    homeHealthPreAuthorizationForm1.setInsuranceDetailPreAuth(insuranceDetailPreAuth);

    ProviderDetail providerDetail=new ProviderDetail();
    providerDetail.setProviderName(homeHealthPreAuthorizationForm.getProviderDetail().getProviderName());
    providerDetail.setPhoneNumber(homeHealthPreAuthorizationForm.getProviderDetail().getPhoneNumber());
    providerDetail.setExtension(homeHealthPreAuthorizationForm.getProviderDetail().getExtension());
    providerDetail.setFaxNumber(homeHealthPreAuthorizationForm.getProviderDetail().getFaxNumber());
    providerDetail.setRequestingAgency(homeHealthPreAuthorizationForm.getProviderDetail().getRequestingAgency());
    providerDetail.setRequestingProviderIDNumber(homeHealthPreAuthorizationForm.getProviderDetail().getRequestingProviderIDNumber());
    providerDetail.setProviderTaxIDNumber(homeHealthPreAuthorizationForm.getProviderDetail().getProviderTaxIDNumber());
    homeHealthPreAuthorizationForm1.setProviderDetail(providerDetail);

    AdmissionDetail admissionDetail=new AdmissionDetail();
    admissionDetail.setMrnNumber(homeHealthPreAuthorizationForm.getAdmissionDetail().getMrnNumber());
    admissionDetail.setAdmissionDate(homeHealthPreAuthorizationForm.getAdmissionDetail().getAdmissionDate());
    admissionDetail.setDischargeDate(homeHealthPreAuthorizationForm.getAdmissionDetail().getDischargeDate());
    admissionDetail.setPrimaryDiagnosis(homeHealthPreAuthorizationForm.getAdmissionDetail().getPrimaryDiagnosis());
    admissionDetail.setPrimaryDiagnosisDescription(homeHealthPreAuthorizationForm.getAdmissionDetail().getPrimaryDiagnosisDescription());
    admissionDetail.setReferringPhysician(homeHealthPreAuthorizationForm.getAdmissionDetail().getReferringPhysician());
    admissionDetail.setRequestType(homeHealthPreAuthorizationForm.getAdmissionDetail().getRequestType());
    homeHealthPreAuthorizationForm1.setAdmissionDetail(admissionDetail);

    RequestFor requestFor=new RequestFor();
    requestFor.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
    requestFor.setNewadmissionService(homeHealthPreAuthorizationForm.getRequestFor().getNewadmissionService());
    //if(homeHealthPreAuthorizationForm.getRequestFor().getAdditionalServices().getServiceflag())
   // {
        AdditionalServices ad=new AdditionalServices();
        ad.setServiceflag(homeHealthPreAuthorizationForm.getRequestFor().getAdditionalServices().getServiceflag());
        ad.setNumberOfServiceCompletedTillDate(homeHealthPreAuthorizationForm.getRequestFor().getAdditionalServices().getNumberOfServiceCompletedTillDate());
        ad.setPreviousAuthorizationNumber(homeHealthPreAuthorizationForm.getRequestFor().getAdditionalServices().getPreviousAuthorizationNumber());
        ad.setFromDate(homeHealthPreAuthorizationForm.getRequestFor().getAdditionalServices().getFromDate());
        ad.setToDate(homeHealthPreAuthorizationForm.getRequestFor().getAdditionalServices().getToDate());
        requestFor.setAdditionalServices(ad);
  //  }
  /* else
    {
        AdditionalServices ad=new AdditionalServices();
        ad.setServiceflag(homeHealthPreAuthorizationForm.getRequestFor().getAdditionalServices().getServiceflag());
        requestFor.setAdditionalServices(ad);
    }*/
  //  if(homeHealthPreAuthorizationForm.getRequestFor().getExtension().getServiceflag())
  //  {
        Extension  ext=new Extension();
        ext.setServiceflag(homeHealthPreAuthorizationForm.getRequestFor().getExtension().getServiceflag());
        ext.setPreviousAuthorizationNumber(homeHealthPreAuthorizationForm.getRequestFor().getExtension().getPreviousAuthorizationNumber());
        ext.setFromDate(homeHealthPreAuthorizationForm.getRequestFor().getExtension().getFromDate());
        ext.setToDate(homeHealthPreAuthorizationForm.getRequestFor().getExtension().getToDate());
        requestFor.setExtension(ext);
  //  }
  /*  else
    {
        Extension  ext=new Extension();
        ext.setServiceflag(homeHealthPreAuthorizationForm.getRequestFor().getExtension().getServiceflag());
        requestFor.setExtension(ext);
    }*/
    homeHealthPreAuthorizationForm1.setRequestFor(requestFor);

    RequestService requestService =new RequestService();
    requestService.setMrnNumber(homeHealthPreAuthorizationForm.getRequestService().getMrnNumber());
    if(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAide())
    {
        HomeHealthAide hha=new   HomeHealthAide();
        hha.setMrnNumber(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getMrnNumber());
        hha.setHomeHealthAide(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAide());
        hha.setRevenueCode(570);
        hha.setUnits(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getUnits());
        hha.setVisits(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getVisits());
        requestService.setHomeHealthAide(hha);

    }
    else
    {
        HomeHealthAide hha=new   HomeHealthAide();
        hha.setMrnNumber(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getMrnNumber());
        hha.setHomeHealthAide(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAide());
        hha.setRevenueCode(570);
        hha.setUnits(0);
        hha.setVisits(0);
        requestService.setHomeHealthAide(hha);
    }
    if(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapy())
    {
        OccupationTherapy oct=new OccupationTherapy();
        oct.setMrnNumber(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getMrnNumber());
        oct.setOccupationTherapy(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapy());
        oct.setRevenueCode(430);
        oct.setUnits(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getUnits());
        oct.setVisits(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getVisits());
        requestService.setOccupationTherapy(oct);
    }
    else
    {
        OccupationTherapy oct=new OccupationTherapy();
        oct.setMrnNumber(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getMrnNumber());
        oct.setOccupationTherapy(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapy());
        oct.setRevenueCode(430);
        oct.setUnits(0);
        oct.setVisits(0);
        requestService.setOccupationTherapy(oct);
    }
    if(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapy())
    {
        PhysicalTherapy pt=new PhysicalTherapy();
        pt.setMrnNumber(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getMrnNumber());
        pt.setPhysicalTherapy(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapy());
        pt.setRevenueCode(420);
        pt.setUnits(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getUnits());
        pt.setVisits(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getVisits());
        requestService.setPhysicalTherapy(pt);
    }
    else
    {
        PhysicalTherapy pt=new PhysicalTherapy();
        pt.setMrnNumber(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getMrnNumber());
        pt.setPhysicalTherapy(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapy());
        pt.setRevenueCode(420);
        pt.setUnits(0);
        pt.setVisits(0);
        requestService.setPhysicalTherapy(pt);
    }
    if(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathology())
    {
        SpeechPathology sp=new SpeechPathology();
        sp.setMrnNumber(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getMrnNumber());
        sp.setSpeechPathology(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathology());
        sp.setRevenueCode(440);
        sp.setUnits(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getUnits());
        sp.setVisits(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getVisits());
        requestService.setSpeechPathology(sp);
    }
    else
    {
        SpeechPathology sp=new SpeechPathology();
        sp.setMrnNumber(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getMrnNumber());
        sp.setSpeechPathology(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathology());
        sp.setRevenueCode(440);
        sp.setUnits(0);
        sp.setVisits(0);
        requestService.setSpeechPathology(sp);
    }
    if(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWork())
    {
        MedicalSocialWork msw=new MedicalSocialWork();
        msw.setMrnNumber(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMrnNumber());
        msw.setMedicalSocialWork(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWork());
        msw.setRevenueCode(560);
        msw.setUnits(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getUnits());
        msw.setVisits(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getVisits());
        requestService.setMedicalSocialWork(msw);
    }
    else
    {
        MedicalSocialWork msw=new MedicalSocialWork();
        msw.setMrnNumber(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMrnNumber());
        msw.setMedicalSocialWork(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWork());
        msw.setRevenueCode(560);
        msw.setUnits(0);
        msw.setVisits(0);
        requestService.setMedicalSocialWork(msw);
    }
    if(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursing())
    {
        SkilledNursing sn=new SkilledNursing();
        sn.setMrnNumber(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getMrnNumber());
        sn.setSkilledNursing(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursing());
        sn.setRevenueCode(550);
        sn.setUnits(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getUnits());
        sn.setVisits(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getVisits());
        requestService.setSkilledNursing(sn);
    }
    else
    {
        SkilledNursing sn=new SkilledNursing();
        sn.setMrnNumber(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getMrnNumber());
        sn.setSkilledNursing(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursing());
        sn.setRevenueCode(550);
        sn.setUnits(0);
        sn.setVisits(0);
        requestService.setSkilledNursing(sn);
    }

    homeHealthPreAuthorizationForm1.setRequestService(requestService);

    PreAuthDemographics demographics=new PreAuthDemographics();
    demographics.setMrnNumber(homeHealthPreAuthorizationForm.getPreAuthDemographics().getMrnNumber());
    demographics.setFirstName(homeHealthPreAuthorizationForm.getPreAuthDemographics().getFirstName());
    demographics.setLastName(homeHealthPreAuthorizationForm.getPreAuthDemographics().getLastName());
    demographics.setMiddleName(homeHealthPreAuthorizationForm.getPreAuthDemographics().getMiddleName());
    demographics.setSuffix(homeHealthPreAuthorizationForm.getPreAuthDemographics().getSuffix());
    demographics.setDob(homeHealthPreAuthorizationForm.getPreAuthDemographics().getDob());
    demographics.setGender(homeHealthPreAuthorizationForm.getPreAuthDemographics().getGender());
    demographics.setSsn(homeHealthPreAuthorizationForm.getPreAuthDemographics().getSsn());
    homeHealthPreAuthorizationForm1.setPreAuthDemographics(demographics);

    homeHealthPreAuthFormService.save(homeHealthPreAuthorizationForm1);




     ackn="true";
    return  ackn;
}



    public void generateFile(HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm,File file)
    {
        String data=new EDIFileGeneration().generateFile(homeHealthPreAuthorizationForm);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
            System.out.println("File generated successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    protected ResponseEntity<?> generateSuccessObject(String key, String errorBuilder){
        Response.ResponseBuilder builder = null;

        ResponseEntity responseEntity;

        try{
            Map<String, Object> responseObj = new HashMap<String, Object>();
            responseObj.put("ackn",key);
            responseEntity= new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);
        }catch (Exception e) {
            Map<String, Object> responseObj1 = new HashMap<String, Object>();
            responseObj1.put("Error",HttpStatus.BAD_REQUEST);
            responseEntity= new ResponseEntity<>(responseObj1,HttpStatus.EXPECTATION_FAILED);
        }
        return  responseEntity;
    }

}
