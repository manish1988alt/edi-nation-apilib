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
import java.text.SimpleDateFormat;
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
    PreAuthorizationResponseHistoryRepository preAuthorizationResponseHistoryRepository;
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
        List<PreAuthDetail> list= preAuthRepository.findByID(homeHealthPreAuthorizationForm.getMrnNumber());
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
            demographics1.setPrefix(pre.getPreAuthDemographics().getPrefix());
            demographics1.setRelationshipToSubscriber(pre.getPreAuthDemographics().getRelationshipToSubscriber());
            episode.setAdmissionDate(pre.getEpisode().getAdmissionDate());
            episode.setAdmissionStatus(pre.getEpisode().getAdmissionStatus());
            episode.setEpisodeType(pre.getEpisode().getEpisodeType());
            episode.setMrnNumber(pre.getEpisode().getMrnNumber());
            episode.setPreauthFormStatus("Saved As Draft");
            episode.setPreAuthorisationStatus(pre.getEpisode().getPreAuthorisationStatus());
            episode.setPayorType(pre.getEpisode().getPayorType());
            episode.setFormSentDate(homeHealthPreAuthorizationForm.getEnquiryDeatils().getPreauthReqSentDate());
            episode.setFormReceivedDate(pre.getEpisode().getFormReceivedDate());
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
        List<PreAuthDetail> list= preAuthRepository.findByID(homeHealthPreAuthorizationForm.getMrnNumber());
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

            episode.setAdmissionDate(pre.getEpisode().getAdmissionDate());
            episode.setAdmissionStatus(pre.getEpisode().getAdmissionStatus());
            episode.setEpisodeType(pre.getEpisode().getEpisodeType());
            episode.setMrnNumber(pre.getEpisode().getMrnNumber());
            episode.setPreauthFormStatus("Sent For Approval");
            episode.setPreAuthorisationStatus(pre.getEpisode().getPreAuthorisationStatus());
            episode.setPayorType(pre.getEpisode().getPayorType());
            episode.setFormSentDate(homeHealthPreAuthorizationForm.getEnquiryDeatils().getPreauthReqSentDate());
            episode.setFormReceivedDate(pre.getEpisode().getFormReceivedDate());
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


    @PostMapping("/preAuthResponseHistoryList")
    public List<PreAuthorizationResponseHistory> preAuthResponseHistoryList(@RequestBody  PreAuthDetail preAuthDetail)  throws Throwable
    {
        return preAuthorizationResponseHistoryRepository.findByMrnNumber(preAuthDetail.getMrnNumber());
    }

    @PostMapping("/preAuthResponseHistoryView")
    public List<PreAuthorizationResponse> preAuthResponseHistoryView(@RequestBody  PreAuthorizationResponseHistory preAuthorizationResponseHistory)  throws Throwable
    {
        return preAuthorizationResponseRepository.findByMrnNumberHistoryView(preAuthorizationResponseHistory.getMrnNumber(),preAuthorizationResponseHistory.getEnquiryId());
    }

    @PostMapping("/preAuthRequestEdit")
    public List<HomeHealthPreAuthorizationForm>   preAuthRequestEdit(@RequestBody  HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm)  throws Throwable
    {
        List<HomeHealthPreAuthorizationForm> homeHealthPreAuthorizationFormList=new ArrayList<>();
        EnquiryDeatils enquiryDeatils=new EnquiryDeatils();
        String preauthformStatus="";
        List<PreAuthDetail> preAuthDetailList= preAuthRepository.findByID(homeHealthPreAuthorizationForm.getMrnNumber());
        for(PreAuthDetail preAuthDetail:preAuthDetailList)
        {
            preauthformStatus=preAuthDetail.getEpisode().getPreauthFormStatus();
        }


        List<HomeHealthPreAuthorizationForm> list=   homeHealthPreAuthFormRepository.findByID(homeHealthPreAuthorizationForm.getMrnNumber());

        HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm1=new HomeHealthPreAuthorizationForm();



        for(HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm2:list)
        {
            homeHealthPreAuthorizationForm1.setMrnNumber(homeHealthPreAuthorizationForm2.getMrnNumber());
            if("Sent For Approval".equals(preauthformStatus))
            {
                int enquiryId=homeHealthPreAuthorizationForm2.getEnquiryDeatils().getEnquiryId();
                enquiryDeatils.setEnquiryId(enquiryId+1);
                String currentDate = java.time.LocalDate.now().toString();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date currentDateF = formatter.parse(currentDate);
                enquiryDeatils.setPreauthReqSentDate(currentDateF);
            }
            else
            {
                enquiryDeatils.setEnquiryId(homeHealthPreAuthorizationForm2.getEnquiryDeatils().getEnquiryId());
                enquiryDeatils.setPreauthReqSentDate(homeHealthPreAuthorizationForm2.getEnquiryDeatils().getPreauthReqSentDate());
            }
            enquiryDeatils.setMrnNumber(homeHealthPreAuthorizationForm2.getMrnNumber());
            homeHealthPreAuthorizationForm1.setEnquiryDeatils(enquiryDeatils);
            homeHealthPreAuthorizationForm1.setPreAuthDemographics(homeHealthPreAuthorizationForm2.getPreAuthDemographics());
            homeHealthPreAuthorizationForm1.setOrganizationInformation(homeHealthPreAuthorizationForm2.getOrganizationInformation());
            homeHealthPreAuthorizationForm1.setSubscriberDetails(homeHealthPreAuthorizationForm2.getSubscriberDetails());
            homeHealthPreAuthorizationForm1.setDependentDetails(homeHealthPreAuthorizationForm2.getDependentDetails());
            homeHealthPreAuthorizationForm1.setRequestService(homeHealthPreAuthorizationForm2.getRequestService());
            homeHealthPreAuthorizationForm1.setProviderDetail(homeHealthPreAuthorizationForm2.getProviderDetail());

        }
        homeHealthPreAuthorizationFormList.add(homeHealthPreAuthorizationForm1);
        return homeHealthPreAuthorizationFormList;

    }


    public String saveOperation(HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm)
{
    String ackn="false";
    HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm1=new HomeHealthPreAuthorizationForm();
    homeHealthPreAuthorizationForm1.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
    EnquiryDeatils enquiryDeatils=new EnquiryDeatils();
    enquiryDeatils.setEnquiryId(homeHealthPreAuthorizationForm.getEnquiryDeatils().getEnquiryId());
    enquiryDeatils.setPreauthReqSentDate(homeHealthPreAuthorizationForm.getEnquiryDeatils().getPreauthReqSentDate());
    enquiryDeatils.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
    homeHealthPreAuthorizationForm1.setEnquiryDeatils(enquiryDeatils);

    OrganizationInformation organizationInformation=new OrganizationInformation();
    organizationInformation.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
    organizationInformation.setOrganizationName(homeHealthPreAuthorizationForm.getOrganizationInformation().getOrganizationName());
    organizationInformation.setOrgIdentificationCode(homeHealthPreAuthorizationForm.getOrganizationInformation().getOrgIdentificationCode());
    organizationInformation.setOrgIdentificationCodeType(homeHealthPreAuthorizationForm.getOrganizationInformation().getOrgIdentificationCodeType());
    organizationInformation.setOrgCommunicationTypeTelephone(homeHealthPreAuthorizationForm.getOrganizationInformation().getOrgCommunicationTypeTelephone());
    organizationInformation.setOrgCommunicationTypeEMail(homeHealthPreAuthorizationForm.getOrganizationInformation().getOrgCommunicationTypeEMail());
    organizationInformation.setOrgCommunicationTypeFacsimile(homeHealthPreAuthorizationForm.getOrganizationInformation().getOrgCommunicationTypeFacsimile());
    organizationInformation.setOrgCommunicationExt(homeHealthPreAuthorizationForm.getOrganizationInformation().getOrgCommunicationExt());
    homeHealthPreAuthorizationForm1.setOrganizationInformation(organizationInformation);

    RequesterDetails providerDetail=new RequesterDetails();
    providerDetail.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
    providerDetail.setReqProviderFullName(homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderLastName()+" "+homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderFirstName()+" "+homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderMiddleName()+" "+homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderSuffix()+" "+homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderPrefix());
    providerDetail.setReqProviderFirstName(homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderFirstName());
    providerDetail.setReqProviderLastName(homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderLastName());
    providerDetail.setReqProviderMiddleName(homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderMiddleName());
    providerDetail.setReqProviderSuffix(homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderSuffix());
    providerDetail.setReqProviderPrefix(homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderPrefix());
    providerDetail.setAdmitDate(homeHealthPreAuthorizationForm.getProviderDetail().getAdmitDate());
    providerDetail.setDischargeDate(homeHealthPreAuthorizationForm.getProviderDetail().getDischargeDate());
    providerDetail.setCertificationType(homeHealthPreAuthorizationForm.getProviderDetail().getCertificationType());
    providerDetail.setReqProviderIdentificationNumber(homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderIdentificationNumber());
    providerDetail.setReqProviderIdentificationNumberType(homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderIdentificationNumberType());
    providerDetail.setLevelOfService(homeHealthPreAuthorizationForm.getProviderDetail().getLevelOfService());
    providerDetail.setReqProviderIdNumberType(homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderIdNumberType());
    providerDetail.setReqProviderSupplimentalId(homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderSupplimentalId());
    providerDetail.setReqProviderType(homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderType());
    providerDetail.setRequestCategory(homeHealthPreAuthorizationForm.getProviderDetail().getRequestCategory());
    providerDetail.setServiceDateFrom(homeHealthPreAuthorizationForm.getProviderDetail().getServiceDateFrom());
    providerDetail.setServiceDateTo(homeHealthPreAuthorizationForm.getProviderDetail().getServiceDateTo());
    providerDetail.setServiceType(homeHealthPreAuthorizationForm.getProviderDetail().getServiceType());
    homeHealthPreAuthorizationForm1.setProviderDetail(providerDetail);

    RequestService requestService =new RequestService();
    requestService.setMrnNumber(homeHealthPreAuthorizationForm.getRequestService().getMrnNumber());
    if(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideSelected())
    {
        HomeHealthAide hha=new   HomeHealthAide();
        hha.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
        hha.setHomeHealthAideSelected(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideSelected());
        hha.setHomeHealthAideRevenueCode(570);
        hha.setHomeHealthAideUnit(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideUnit());
        hha.setHomeHealthAideVisit(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideVisit());
        hha.setHomeHealthAideCertificationType(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideCertificationType());
        hha.setHomeHealthAideLevelOfService(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideLevelOfService());
        hha.setHomeHealthAideProviderFirstName(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderFirstName());
        hha.setHomeHealthAidePoviderLastName(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAidePoviderLastName());
        hha.setHomeHealthAideProviderMiddleName(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderMiddleName());
        hha.setHomeHealthAideProviderSuffix(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderSuffix());
        hha.setHomeHealthAideProviderPrefix(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderPrefix());
        hha.setHomeHealthAideProviderFullName(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAidePoviderLastName()+" "+homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderFirstName()+" "+homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderMiddleName()+" "+homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderSuffix()+" "+homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderPrefix());
        hha.setHomeHealthAideProviderAddress(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderAddress());
        hha.setHomeHealthAideProviderCity(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderCity());
        hha.setHomeHealthAideProviderState(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderState());
        hha.setHomeHealthAideProviderCountryCode(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderCountryCode());
        hha.setHomeHealthAideProviderPostalCode(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderPostalCode());
        hha.setHomeHealthAideProviderIdentificationNumber(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderIdentificationNumber());
        hha.setHomeHealthAideProviderIdentificationNumberType(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderIdentificationNumberType());
        hha.setHomeHealthAideProviderIdNumberType(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderIdNumberType());
        hha.setHomeHealthAideProviderSupplimentalId(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderSupplimentalId());
        hha.setHomeHealthAideProviderType(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderType());
        hha.setHomeHealthAideRequestServiceDateFrom(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideRequestServiceDateFrom());
        hha.setHomeHealthAideRequestServiceDateTo(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideRequestServiceDateTo());
        hha.setHomeHealthAideServiceType(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideServiceType());
        hha.setHomeHealthAideRequestCategory(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideRequestCategory());
        requestService.setHomeHealthAide(hha);
    }
    else
    {
        HomeHealthAide hha=new   HomeHealthAide();
        hha.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
        hha.setHomeHealthAideSelected(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideSelected());
        hha.setHomeHealthAideRevenueCode(570);
        hha.setHomeHealthAideUnit(0);
        hha.setHomeHealthAideVisit(0);
        hha.setHomeHealthAideCertificationType(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideCertificationType());
        hha.setHomeHealthAideLevelOfService(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideLevelOfService());
        hha.setHomeHealthAideProviderFirstName(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderFirstName());
        hha.setHomeHealthAidePoviderLastName(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAidePoviderLastName());
        hha.setHomeHealthAideProviderMiddleName(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderMiddleName());
        hha.setHomeHealthAideProviderSuffix(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderSuffix());
        hha.setHomeHealthAideProviderPrefix(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderPrefix());
        hha.setHomeHealthAideProviderFullName(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAidePoviderLastName()+" "+homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderFirstName()+" "+homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderMiddleName()+" "+homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderSuffix()+" "+homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderPrefix());
        hha.setHomeHealthAideProviderAddress(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderAddress());
        hha.setHomeHealthAideProviderCity(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderCity());
        hha.setHomeHealthAideProviderState(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderState());
        hha.setHomeHealthAideProviderCountryCode(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderCountryCode());
        hha.setHomeHealthAideProviderPostalCode(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderPostalCode());
        hha.setHomeHealthAideProviderIdentificationNumber(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderIdentificationNumber());
        hha.setHomeHealthAideProviderIdentificationNumberType(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderIdentificationNumberType());
        hha.setHomeHealthAideProviderIdNumberType(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderIdNumberType());
        hha.setHomeHealthAideProviderSupplimentalId(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderSupplimentalId());
        hha.setHomeHealthAideProviderType(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderType());
        hha.setHomeHealthAideRequestServiceDateFrom(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideRequestServiceDateFrom());
        hha.setHomeHealthAideRequestServiceDateTo(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideRequestServiceDateTo());
        hha.setHomeHealthAideServiceType(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideServiceType());
        hha.setHomeHealthAideRequestCategory(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideRequestCategory());
        requestService.setHomeHealthAide(hha);
    }
    if(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapySelected())
    {
        OccupationTherapy oct=new OccupationTherapy();
        oct.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
        oct.setOccupationTherapySelected(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapySelected());
        oct.setOccupationTherapyRevenueCode(430);
        oct.setOccupationTherapyUnit(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyUnit());
        oct.setOccupationTherapyVisit(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyVisit());
        oct.setOccupationTherapyCertificationType(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyCertificationType());
        oct.setOccupationTherapyLevelOfService(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyLevelOfService());
        oct.setOccupationTherapyProviderFirstName(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderFirstName());
        oct.setOccupationTherapyPoviderLastName(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyPoviderLastName());
        oct.setOccupationTherapyProviderMiddleName(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderMiddleName());
        oct.setOccupationTherapyProviderPrefix(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderPrefix());
        oct.setOccupationTherapyProviderSuffix(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderSuffix());
        oct.setOccupationTherapyProviderFullName(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyPoviderLastName()+" "+homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderFirstName()+" "+homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderMiddleName()+" "+homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderSuffix()+" "+homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderPrefix());
        oct.setOccupationTherapyProviderAddress(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderAddress());
        oct.setOccupationTherapyProviderCity(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderCity());
        oct.setOccupationTherapyProviderState(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderState());
        oct.setOccupationTherapyProviderCountryCode(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderCountryCode());
        oct.setOccupationTherapyProviderPostalCode(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderPostalCode());
        oct.setOccupationTherapyProviderIdentificationNumber(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderIdentificationNumber());
        oct.setOccupationTherapyProviderIdentificationNumberType(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderIdentificationNumberType());
        oct.setOccupationTherapyProviderIdNumberType(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderIdNumberType());
        oct.setOccupationTherapyProviderSupplimentalId(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderSupplimentalId());
        oct.setOccupationTherapyProviderType(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderType());
        oct.setOccupationTherapyRequestServiceDateFrom(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyRequestServiceDateFrom());
        oct.setOccupationTherapyRequestServiceDateTo(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyRequestServiceDateTo());
        oct.setOccupationTherapyServiceType(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyServiceType());
        oct.setOccupationTherapyRequestCategory(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyRequestCategory());
        requestService.setOccupationTherapy(oct);
    }
    else
    {
        OccupationTherapy oct=new OccupationTherapy();
        oct.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
        oct.setOccupationTherapySelected(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapySelected());
        oct.setOccupationTherapyRevenueCode(430);
        oct.setOccupationTherapyUnit(0);
        oct.setOccupationTherapyVisit(0);
        oct.setOccupationTherapyCertificationType(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyCertificationType());
        oct.setOccupationTherapyLevelOfService(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyLevelOfService());
        oct.setOccupationTherapyProviderFirstName(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderFirstName());
        oct.setOccupationTherapyPoviderLastName(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyPoviderLastName());
        oct.setOccupationTherapyProviderMiddleName(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderMiddleName());
        oct.setOccupationTherapyProviderMiddleName(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderMiddleName());
        oct.setOccupationTherapyProviderPrefix(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderPrefix());
        oct.setOccupationTherapyProviderSuffix(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderSuffix());
        oct.setOccupationTherapyProviderFullName(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyPoviderLastName()+" "+homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderFirstName()+" "+homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderMiddleName()+" "+homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderSuffix()+" "+homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderPrefix());
        oct.setOccupationTherapyProviderAddress(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderAddress());
        oct.setOccupationTherapyProviderCity(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderCity());
        oct.setOccupationTherapyProviderState(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderState());
        oct.setOccupationTherapyProviderCountryCode(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderCountryCode());
        oct.setOccupationTherapyProviderPostalCode(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderPostalCode());
        oct.setOccupationTherapyProviderIdentificationNumber(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderIdentificationNumber());
        oct.setOccupationTherapyProviderIdentificationNumberType(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderIdentificationNumberType());
        oct.setOccupationTherapyProviderIdNumberType(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderIdNumberType());
        oct.setOccupationTherapyProviderSupplimentalId(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderSupplimentalId());
        oct.setOccupationTherapyProviderType(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderType());
        oct.setOccupationTherapyRequestServiceDateFrom(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyRequestServiceDateFrom());
        oct.setOccupationTherapyRequestServiceDateTo(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyRequestServiceDateTo());
        oct.setOccupationTherapyServiceType(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyServiceType());
        oct.setOccupationTherapyRequestCategory(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyRequestCategory());
        requestService.setOccupationTherapy(oct);
    }
    if(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapySelected())
    {
        PhysicalTherapy pt=new PhysicalTherapy();
        pt.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
        pt.setPhysicalTherapySelected(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapySelected());
        pt.setPhysicalTherapyrevenueCode(420);
        pt.setPhysicalTherapyUnit(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyUnit());
        pt.setPhysicalTherapyVisit(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyVisit());
        pt.setPhysicalTherapyCertificationType(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyCertificationType());
        pt.setPhysicalTherapyLevelOfService(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyLevelOfService());
        pt.setPhysicalTherapyProviderFirstName(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderFirstName());
        pt.setPhysicalTherapyPoviderLastName(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyPoviderLastName());
        pt.setPhysicalTherapyProviderMiddleName(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderMiddleName());
        pt.setPhysicalTherapyProviderPrefix(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderPrefix());
        pt.setPhysicalTherapyProviderSuffix(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderSuffix());
        pt.setPhysicalTherapyProviderFullName(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyPoviderLastName()+" "+homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderFirstName()+" "+homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderMiddleName()+" "+homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderSuffix()+" "+homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderPrefix());
        pt.setPhysicalTherapyProviderAddress(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderAddress());
        pt.setPhysicalTherapyProviderCity(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderCity());
        pt.setPhysicalTherapyProviderState(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderState());
        pt.setPhysicalTherapyProviderCountryCode(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderCountryCode());
        pt.setPhysicalTherapyProviderPostalCode(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderPostalCode());
        pt.setPhysicalTherapyProviderIdentificationNumber(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderIdentificationNumber());
        pt.setPhysicalTherapyProviderIdentificationNumberType(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderIdentificationNumberType());
        pt.setPhysicalTherapyProviderIdNumberType(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderIdNumberType());
        pt.setPhysicalTherapyProviderSupplimentalId(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderSupplimentalId());
        pt.setPhysicalTherapyProviderType(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderType());
        pt.setPhysicalTherapyRequestServiceDateFrom(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyRequestServiceDateFrom());
        pt.setPhysicalTherapyRequestServiceDateTo(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyRequestServiceDateTo());
        pt.setPhysicalTherapyServiceType(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyServiceType());
        pt.setPhysicalTherapyRequestCategory(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyRequestCategory());
        requestService.setPhysicalTherapy(pt);
    }
    else
    {
        PhysicalTherapy pt=new PhysicalTherapy();
        pt.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
        pt.setPhysicalTherapySelected(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapySelected());
        pt.setPhysicalTherapyrevenueCode(420);
        pt.setPhysicalTherapyUnit(0);
        pt.setPhysicalTherapyVisit(0);
        pt.setPhysicalTherapyCertificationType(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyCertificationType());
        pt.setPhysicalTherapyLevelOfService(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyLevelOfService());
        pt.setPhysicalTherapyProviderFirstName(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderFirstName());
        pt.setPhysicalTherapyPoviderLastName(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyPoviderLastName());
        pt.setPhysicalTherapyProviderMiddleName(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderMiddleName());
        pt.setPhysicalTherapyProviderPrefix(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderPrefix());
        pt.setPhysicalTherapyProviderSuffix(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderSuffix());
        pt.setPhysicalTherapyProviderFullName(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyPoviderLastName()+" "+homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderFirstName()+" "+homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderMiddleName()+" "+homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderSuffix()+" "+homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderPrefix());
        pt.setPhysicalTherapyProviderAddress(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderAddress());
        pt.setPhysicalTherapyProviderCity(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderCity());
        pt.setPhysicalTherapyProviderState(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderState());
        pt.setPhysicalTherapyProviderCountryCode(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderCountryCode());
        pt.setPhysicalTherapyProviderPostalCode(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderPostalCode());
        pt.setPhysicalTherapyProviderIdentificationNumber(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderIdentificationNumber());
        pt.setPhysicalTherapyProviderIdentificationNumberType(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderIdentificationNumberType());
        pt.setPhysicalTherapyProviderIdNumberType(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderIdNumberType());
        pt.setPhysicalTherapyProviderSupplimentalId(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderSupplimentalId());
        pt.setPhysicalTherapyProviderType(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderType());
        pt.setPhysicalTherapyRequestServiceDateFrom(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyRequestServiceDateFrom());
        pt.setPhysicalTherapyRequestServiceDateTo(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyRequestServiceDateTo());
        pt.setPhysicalTherapyServiceType(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyServiceType());
        pt.setPhysicalTherapyRequestCategory(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyRequestCategory());
        requestService.setPhysicalTherapy(pt);
    }
    if(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologySelected())
    {
        SpeechPathology sp=new SpeechPathology();
        sp.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
        sp.setSpeechPathologySelected(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologySelected());
        sp.setSpeechPathologyRevenueCode(440);
        sp.setSpeechPathologyUnit(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyUnit());
        sp.setSpeechPathologyVisit(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyVisit());
        sp.setSpeechPathologyCertificationType(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyCertificationType());
        sp.setSpeechPathologyLevelOfService(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyLevelOfService());
        sp.setSpeechPathologyProviderFirstName(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderFirstName());
        sp.setSpeechPathologyPoviderLastName(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyPoviderLastName());
        sp.setSpeechPathologyProviderMiddleName(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderMiddleName());
        sp.setSpeechPathologyProviderSuffix(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderSuffix());
        sp.setSpeechPathologyProviderPrefix(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderPrefix());
        sp.setSpeechPathologyProviderFullName(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyPoviderLastName()+" "+homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderFirstName()+" "+homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderMiddleName()+" "+homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderSuffix()+" "+homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderPrefix());
        sp.setSpeechPathologyProviderAddress(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderAddress());
        sp.setSpeechPathologyProviderCity(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderCity());
        sp.setSpeechPathologyProviderState(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderState());
        sp.setSpeechPathologyProviderCountryCode(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderCountryCode());
        sp.setSpeechPathologyProviderPostalCode(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderPostalCode());
        sp.setSpeechPathologyProviderIdentificationNumber(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderIdentificationNumber());
        sp.setSpeechPathologyProviderIdentificationNumberType(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderIdentificationNumberType());
        sp.setSpeechPathologyProviderIdNumberType(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderIdNumberType());
        sp.setSpeechPathologyProviderSupplimentalId(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderSupplimentalId());
        sp.setSpeechPathologyProviderType(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderType());
        sp.setSpeechPathologyRequestServiceDateFrom(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyRequestServiceDateFrom());
        sp.setSpeechPathologyRequestServiceDateTo(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyRequestServiceDateTo());
        sp.setSpeechPathologyServiceType(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyServiceType());
        sp.setSpeechPathologyRequestCategory(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyRequestCategory());
        requestService.setSpeechPathology(sp);
    }
    else
    {
        SpeechPathology sp=new SpeechPathology();
        sp.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
        sp.setSpeechPathologySelected(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologySelected());
        sp.setSpeechPathologyRevenueCode(440);
        sp.setSpeechPathologyUnit(0);
        sp.setSpeechPathologyVisit(0);
        sp.setSpeechPathologyCertificationType(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyCertificationType());
        sp.setSpeechPathologyLevelOfService(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyLevelOfService());
        sp.setSpeechPathologyProviderFirstName(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderFirstName());
        sp.setSpeechPathologyPoviderLastName(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyPoviderLastName());
        sp.setSpeechPathologyProviderMiddleName(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderMiddleName());
        sp.setSpeechPathologyProviderSuffix(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderSuffix());
        sp.setSpeechPathologyProviderPrefix(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderPrefix());
        sp.setSpeechPathologyProviderFullName(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyPoviderLastName()+" "+homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderFirstName()+" "+homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderMiddleName()+" "+homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderSuffix()+" "+homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderPrefix());
        sp.setSpeechPathologyProviderAddress(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderAddress());
        sp.setSpeechPathologyProviderCity(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderCity());
        sp.setSpeechPathologyProviderState(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderState());
        sp.setSpeechPathologyProviderCountryCode(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderCountryCode());
        sp.setSpeechPathologyProviderPostalCode(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderPostalCode());
        sp.setSpeechPathologyProviderIdentificationNumber(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderIdentificationNumber());
        sp.setSpeechPathologyProviderIdentificationNumberType(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderIdentificationNumberType());
        sp.setSpeechPathologyProviderIdNumberType(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderIdNumberType());
        sp.setSpeechPathologyProviderSupplimentalId(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderSupplimentalId());
        sp.setSpeechPathologyProviderType(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderType());
        sp.setSpeechPathologyRequestServiceDateFrom(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyRequestServiceDateFrom());
        sp.setSpeechPathologyRequestServiceDateTo(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyRequestServiceDateTo());
        sp.setSpeechPathologyServiceType(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyServiceType());
        sp.setSpeechPathologyRequestCategory(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyRequestCategory());
        requestService.setSpeechPathology(sp);
    }
    if(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkSelected())
    {
        MedicalSocialWork msw=new MedicalSocialWork();
        msw.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
        msw.setMedicalSocialWorkSelected(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkSelected());
        msw.setMedicalSocialWorkRevenueCode(560);
        msw.setMedicalSocialWorkUnit(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkUnit());
        msw.setMedicalSocialWorkVisit(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkVisit());
        msw.setMedicalSocialWorkCertificationType(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkCertificationType());
        msw.setMedicalSocialWorkLevelOfService(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkLevelOfService());
        msw.setMedicalSocialWorkProviderFirstName(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderFirstName());
        msw.setMedicalSocialWorkPoviderLastName(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkPoviderLastName());
        msw.setMedicalSocialWorkProviderMiddleName(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderMiddleName());
        msw.setMedicalSocialWorkProviderSuffix(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderSuffix());
        msw.setMedicalSocialWorkProviderPrefix(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderPrefix());
        msw.setMedicalSocialWorkProviderFullName(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkPoviderLastName()+" "+homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderFirstName()+" "+homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderMiddleName()+" "+homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderSuffix()+" "+homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderPrefix());
        msw.setMedicalSocialWorkProviderAddress(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderAddress());
        msw.setMedicalSocialWorkProviderCity(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderCity());
        msw.setMedicalSocialWorkProviderState(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderState());
        msw.setMedicalSocialWorkProviderCountryCode(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderCountryCode());
        msw.setMedicalSocialWorkProviderPostalCode(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderPostalCode());
        msw.setMedicalSocialWorkProviderIdentificationNumber(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderIdentificationNumber());
        msw.setMedicalSocialWorkProviderIdentificationNumberType(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderIdentificationNumberType());
        msw.setMedicalSocialWorkProviderIdNumberType(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderIdNumberType());
        msw.setMedicalSocialWorkProviderSupplimentalId(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderSupplimentalId());
        msw.setMedicalSocialWorkProviderType(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderType());
        msw.setMedicalSocialWorkRequestServiceDateFrom(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkRequestServiceDateFrom());
        msw.setMedicalSocialWorkRequestServiceDateTo(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyRequestServiceDateTo());
        msw.setMedicalSocialWorkServiceType(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkServiceType());
        msw.setMedicalSocialWorkRequestCategory(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkRequestCategory());
        requestService.setMedicalSocialWork(msw);
    }
    else
    {
        MedicalSocialWork msw=new MedicalSocialWork();
        msw.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
        msw.setMedicalSocialWorkSelected(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkSelected());
        msw.setMedicalSocialWorkRevenueCode(560);
        msw.setMedicalSocialWorkUnit(0);
        msw.setMedicalSocialWorkVisit(0);
        msw.setMedicalSocialWorkCertificationType(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkCertificationType());
        msw.setMedicalSocialWorkLevelOfService(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkLevelOfService());
        msw.setMedicalSocialWorkProviderFirstName(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderFirstName());
        msw.setMedicalSocialWorkPoviderLastName(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkPoviderLastName());
        msw.setMedicalSocialWorkProviderMiddleName(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderMiddleName());
        msw.setMedicalSocialWorkProviderSuffix(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderSuffix());
        msw.setMedicalSocialWorkProviderPrefix(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderPrefix());
        msw.setMedicalSocialWorkProviderFullName(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkPoviderLastName()+" "+homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderFirstName()+" "+homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderMiddleName()+" "+homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderSuffix()+" "+homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderPrefix());
        msw.setMedicalSocialWorkProviderAddress(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderAddress());
        msw.setMedicalSocialWorkProviderCity(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderCity());
        msw.setMedicalSocialWorkProviderState(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderState());
        msw.setMedicalSocialWorkProviderCountryCode(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderCountryCode());
        msw.setMedicalSocialWorkProviderPostalCode(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderPostalCode());
        msw.setMedicalSocialWorkProviderIdentificationNumber(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderIdentificationNumber());
        msw.setMedicalSocialWorkProviderIdentificationNumberType(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderIdentificationNumberType());
        msw.setMedicalSocialWorkProviderIdNumberType(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderIdNumberType());
        msw.setMedicalSocialWorkProviderSupplimentalId(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderSupplimentalId());
        msw.setMedicalSocialWorkProviderType(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderType());
        msw.setMedicalSocialWorkRequestServiceDateFrom(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkRequestServiceDateFrom());
        msw.setMedicalSocialWorkRequestServiceDateTo(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyRequestServiceDateTo());
        msw.setMedicalSocialWorkServiceType(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkServiceType());
        msw.setMedicalSocialWorkRequestCategory(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkRequestCategory());
        requestService.setMedicalSocialWork(msw);
    }
    if(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingSelected())
    {
        SkilledNursing sn=new SkilledNursing();
        sn.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
        sn.setSkilledNursingSelected(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingSelected());
        sn.setSkilledNursingRevenueCode(550);
        sn.setSkilledNursingUnit(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingUnit());
        sn.setSkilledNursingVisit(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingVisit());
        sn.setSkilledNursingCertificationType(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingCertificationType());
        sn.setSkilledNursingLevelOfService(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingLevelOfService());
        sn.setSkilledNursingProviderFirstName(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderFirstName());
        sn.setSkilledNursingPoviderLastName(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingPoviderLastName());
        sn.setSkilledNursingProviderMiddleName(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderMiddleName());
        sn.setSkilledNursingProviderSuffix(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderSuffix());
        sn.setSkilledNursingProviderPrefix(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderPrefix());
        sn.setSkilledNursingProviderFullName(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingPoviderLastName()+" "+homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderFirstName()+" "+homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderMiddleName()+" "+homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderSuffix()+" "+homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderPrefix());
        sn.setSkilledNursingProviderAddress(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderAddress());
        sn.setSkilledNursingProviderCity(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderCity());
        sn.setSkilledNursingProviderState(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderState());
        sn.setSkilledNursingProviderCountryCode(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderCountryCode());
        sn.setSkilledNursingProviderPostalCode(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderPostalCode());
        sn.setSkilledNursingProviderIdentificationNumber(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderIdentificationNumber());
        sn.setSkilledNursingProviderIdentificationNumberType(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderIdentificationNumberType());
        sn.setSkilledNursingProviderIdNumberType(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderIdNumberType());
        sn.setSkilledNursingProviderSupplimentalId(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderSupplimentalId());
        sn.setSkilledNursingProviderType(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderType());
        sn.setSkilledNursingRequestServiceDateFrom(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingRequestServiceDateFrom());
        sn.setSkilledNursingRequestServiceDateTo(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingRequestServiceDateTo());
        sn.setSkilledNursingServiceType(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingServiceType());
        sn.setSkilledNursingRequestCategory(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingRequestCategory());
        requestService.setSkilledNursing(sn);
    }
    else
    {
        SkilledNursing sn=new SkilledNursing();
        sn.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
        sn.setSkilledNursingSelected(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingSelected());
        sn.setSkilledNursingRevenueCode(550);
        sn.setSkilledNursingUnit(0);
        sn.setSkilledNursingVisit(0);
        sn.setSkilledNursingCertificationType(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingCertificationType());
        sn.setSkilledNursingLevelOfService(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingLevelOfService());
        sn.setSkilledNursingProviderFirstName(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderFirstName());
        sn.setSkilledNursingPoviderLastName(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingPoviderLastName());
        sn.setSkilledNursingProviderMiddleName(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderMiddleName());
        sn.setSkilledNursingProviderSuffix(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderSuffix());
        sn.setSkilledNursingProviderPrefix(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderPrefix());
        sn.setSkilledNursingProviderFullName(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingPoviderLastName()+" "+homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderFirstName()+" "+homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderMiddleName()+" "+homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderSuffix()+" "+homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderPrefix());
        sn.setSkilledNursingProviderAddress(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderAddress());
        sn.setSkilledNursingProviderCity(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderCity());
        sn.setSkilledNursingProviderState(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderState());
        sn.setSkilledNursingProviderCountryCode(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderCountryCode());
        sn.setSkilledNursingProviderPostalCode(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderPostalCode());
        sn.setSkilledNursingProviderIdentificationNumber(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderIdentificationNumber());
        sn.setSkilledNursingProviderIdentificationNumberType(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderIdentificationNumberType());
        sn.setSkilledNursingProviderIdNumberType(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderIdNumberType());
        sn.setSkilledNursingProviderSupplimentalId(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderSupplimentalId());
        sn.setSkilledNursingProviderType(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderType());
        sn.setSkilledNursingRequestServiceDateFrom(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingRequestServiceDateFrom());
        sn.setSkilledNursingRequestServiceDateTo(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingRequestServiceDateTo());
        sn.setSkilledNursingServiceType(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingServiceType());
        sn.setSkilledNursingRequestCategory(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingRequestCategory());
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
    demographics.setPrefix(homeHealthPreAuthorizationForm.getPreAuthDemographics().getPrefix());
    demographics.setRelationshipToSubscriber(homeHealthPreAuthorizationForm.getPreAuthDemographics().getRelationshipToSubscriber());
    homeHealthPreAuthorizationForm1.setPreAuthDemographics(demographics);

    SubscriberDetails subscriberDetail=new SubscriberDetails();
    subscriberDetail.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
    subscriberDetail.setSubscriberFirstName(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberFirstName());
    subscriberDetail.setSubscriberLastName(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberLastName());
    subscriberDetail.setSubscriberMiddleName(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberMiddleName());
    subscriberDetail.setSubscriberDob(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberDob());
    subscriberDetail.setSubscriberGender(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberGender());
    subscriberDetail.setSubscriberSuffix(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberSuffix());
    subscriberDetail.setSubscriberPrefix(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberPrefix());
    subscriberDetail.setSubscriberIdentificationCode(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberIdentificationCode());
    subscriberDetail.setSubscriberIdNumberType(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberIdNumberType());
    subscriberDetail.setSubscriberRelToInsured(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberRelToInsured());
    subscriberDetail.setSubscriberSupplementalId(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberSupplementalId());
    subscriberDetail.setSubscriberIdentificationNumberType(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberIdentificationNumberType());
    homeHealthPreAuthorizationForm1.setSubscriberDetails(subscriberDetail);

    DependentDetails dependentDetails =new DependentDetails();
    dependentDetails.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
    dependentDetails.setDependentFirstName(homeHealthPreAuthorizationForm.getDependentDetails().getDependentFirstName());
    dependentDetails.setDependentLastName(homeHealthPreAuthorizationForm.getDependentDetails().getDependentLastName());
    dependentDetails.setDependentMiddleName(homeHealthPreAuthorizationForm.getDependentDetails().getDependentMiddleName());
    dependentDetails.setDependentPrefix(homeHealthPreAuthorizationForm.getDependentDetails().getDependentPrefix());
    dependentDetails.setDependentSuffix(homeHealthPreAuthorizationForm.getDependentDetails().getDependentSuffix());
    dependentDetails.setDependentDob(homeHealthPreAuthorizationForm.getDependentDetails().getDependentDob());
    dependentDetails.setDependentGender(homeHealthPreAuthorizationForm.getDependentDetails().getDependentGender());
    dependentDetails.setDependentRelToSubscriber(homeHealthPreAuthorizationForm.getDependentDetails().getDependentRelToSubscriber());
    dependentDetails.setDependentSubscriberIdentificationCode(homeHealthPreAuthorizationForm.getDependentDetails().getDependentSubscriberIdentificationCode());
    dependentDetails.setDependentSubscriberIdentificationNumberType(homeHealthPreAuthorizationForm.getDependentDetails().getDependentSubscriberIdentificationNumberType());
    dependentDetails.setDependentSubscriberIdNumberType(homeHealthPreAuthorizationForm.getDependentDetails().getDependentSubscriberIdNumberType());
    dependentDetails.setDependentSubscriberSupplementalId(homeHealthPreAuthorizationForm.getDependentDetails().getDependentSubscriberSupplementalId());
    homeHealthPreAuthorizationForm1.setDependentDetails(dependentDetails);

    homeHealthPreAuthFormService.save(homeHealthPreAuthorizationForm1);




     ackn="true";
    return  ackn;
}



    public void generateFile(HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm,File file) throws Exception
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
