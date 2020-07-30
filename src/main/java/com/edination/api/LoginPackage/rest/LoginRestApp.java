package com.edination.api.LoginPackage.rest;

import com.edination.api.Dao.*;
import com.edination.api.LoginPackage.dao.AddressDetailService;
import com.edination.api.LoginPackage.dao.AdmissionSourceService;
import com.edination.api.LoginPackage.dao.GuarenterDetailsService;
import com.edination.api.LoginPackage.dao.LoginService;
import com.edination.api.LoginPackage.model.*;
import com.edination.api.PDGM.dao.*;
import com.edination.api.PDGM.model.*;
import com.edination.api.eligibility.model.Demographics;
import com.edination.api.eligibility.model.InsuranceDetailByPolicy;
import com.edination.api.eligibility.model.PrimaryInsuranceDetail;
import com.edination.api.preAuthorisation.model.*;
import com.edination.api.rap.Dao.OtherProviderDetailRepository;
import com.edination.api.rap.Dao.OtherProviderDetailService;
import com.edination.api.rap.Dao.PrimaryDiagnosisCodeService;
import com.edination.api.rap.Dao.RapRequestFormRepository;
import com.edination.api.rap.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("nalashaa")
public class LoginRestApp implements Serializable {
    @Autowired
    LoginService loginService;
    @Autowired
    DemographicsService demographicsService;
    @Autowired
    PDGMRapListRepository pdgmRapListRepository;
    @Autowired
    PrimaryDiagnosisCodeService primaryDiagnosisCodeService;
    @Autowired
    EpisodeRepository episodeRepository;
    @Autowired
    SecondDiagnosisCodeService secondDiagnosisCodeService;
    @Autowired
    OtherProviderDetailService otherProviderDetailService;
    @Autowired
    PreAuthService preAuthService;
    @Autowired
    RapRequestFormRepository rapRequestFormRepository;
    @Autowired
    HomeHealthPreAuthFormService homeHealthPreAuthFormService;
    @Autowired
    PDGMRapListService pdgmRapListService;
    @Autowired
    RequestServiceRepository requestServiceRepository;


    @Autowired
    AddressDetailService addressDetailService;
    @Autowired
    AdmissionSourceService admissionSourceService;
    @Autowired
    GuarenterDetailsService guarenterDetailsService;

    @Autowired
    SecondDaignosisCodeRepository secondDaignosisCodeRepository;






    @PostMapping("/login")
    public ResponseEntity<?>  loginCall(@RequestBody Login login) throws Throwable {
    String ackn="false";
        List<Login> loginList= loginService.listAll();
        for(Login login1:loginList)
        {
            if(login.getPassword().equals(login1.getPassword()) && login.getUserName().equals(login1.getUserName()))
            {
                ackn= "true";
                break;
            }
            else
            {
                ackn="false";
            }
        }
        if(ackn.equals("true")) {
            return generateSuccessObject("Success",
                    " ");
        }
        else
        {
            return generateSuccessObject("Fail",
                    "Sent failed ");
        }

    }
    @GetMapping("/intakeList")
    public List<IntakeList> intakeListing() throws Throwable {
        List<IntakeList> intakeListList=new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<Demographics> demographicsList=demographicsService.listAll();
        for(Demographics demographics:demographicsList) {
            IntakeList  intakelist=new IntakeList();
            intakelist.setPatientMRN(demographics.getMrnNumber());
            intakelist.setFirstName(demographics.getFirstName());
            intakelist.setLastName(demographics.getLastName());
            intakelist.setMiddleName(demographics.getMiddleName());
            intakelist.setPrefix("");
            intakelist.setSuffix(demographics.getSuffix());
            intakelist.setDob(demographics.getDob());
            intakelist.setGender(demographics.getGender());
            List<Episode> episodeDetailList=episodeRepository.findByMrnNumberEpisode(demographics.getMrnNumber());
            for(Episode episodeDetail:episodeDetailList)
            {

                String episodeStartDate = formatter.format(episodeDetail.getAdmissionDate());
                LocalDate episodestartDate=LocalDate.parse(episodeStartDate);
                LocalDate episodeEndDate=LocalDate.parse("2020-08-27");
                intakelist.setEpisodeStartDate(episodestartDate);
                intakelist.setEpisodeType(episodeDetail.getEpisodeType());
                intakelist.setAddmissionStatus(episodeDetail.getAdmissionStatus());
                intakelist.setEpisodeEndDate(episodeEndDate);
            }
            intakelist.setOasisStatus("");
           AdmissionSource admissionSourceList=pdgmRapListRepository.findAdmissionSourceByMrn(demographics.getMrnNumber());
            String refferalDate = formatter.format(admissionSourceList.getReferralDate());
                LocalDate refferDate=LocalDate.parse(refferalDate);
                intakelist.setRefferDate(refferDate);
            intakeListList.add(intakelist);

        }

        return intakeListList;
    }

    @PostMapping("/addPatient")
    public ResponseEntity<?>  addPatient(@RequestBody AddPatientModel addPatientModel) throws Throwable {
        String ackn="false";
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
       Random rand = new Random();
       int Number = rand.nextInt(1000);
       String mrnNumber="P"+Number;
        Demographics demographics=new Demographics();
       demographics.setMrnNumber(mrnNumber);
       demographics.setFirstName(addPatientModel.getDemographics().getFirstName());
       demographics.setLastName(addPatientModel.getDemographics().getLastName());
       demographics.setSuffix(addPatientModel.getDemographics().getSuffix());
       demographics.setDob(addPatientModel.getDemographics().getDob());
       demographics.setGender(addPatientModel.getDemographics().getGender());
        demographics.setRace(addPatientModel.getDemographics().getRace());
        demographics.setGuarenter(addPatientModel.getDemographics().isGuarenter());
        demographics.setEthnicity(addPatientModel.getDemographics().getEthnicity());
       PrimaryInsuranceDetail primaryInsuranceDetail=new PrimaryInsuranceDetail();
       primaryInsuranceDetail.setMrnNumber(mrnNumber);
       primaryInsuranceDetail.setInsuredfirstName(addPatientModel.getPrimaryInsuranceDetail().getInsuredfirstName());
       primaryInsuranceDetail.setInsuredlastName(addPatientModel.getPrimaryInsuranceDetail().getInsuredlastName());
       primaryInsuranceDetail.setInsuredmiddleName(addPatientModel.getPrimaryInsuranceDetail().getInsuredmiddleName());
       primaryInsuranceDetail.setInsuredsex(addPatientModel.getPrimaryInsuranceDetail().getInsuredsex());
       primaryInsuranceDetail.setInsureddob(addPatientModel.getPrimaryInsuranceDetail().getInsureddob());
       primaryInsuranceDetail.setPatientRelationInsured(addPatientModel.getPrimaryInsuranceDetail().getPatientRelationInsured());
       primaryInsuranceDetail.setStartDate(addPatientModel.getPrimaryInsuranceDetail().getInsureddob());
       primaryInsuranceDetail.setZipcode(addPatientModel.getPrimaryInsuranceDetail().getZipcode());
       primaryInsuranceDetail.setEndDate(addPatientModel.getPrimaryInsuranceDetail().getEndDate());
       primaryInsuranceDetail.setInsurancePlanType(addPatientModel.getPrimaryInsuranceDetail().getInsurancePlanType());
       primaryInsuranceDetail.setInsurancePlanName(addPatientModel.getPrimaryInsuranceDetail().getInsurancePlanName());
       primaryInsuranceDetail.setGroup_name(addPatientModel.getPrimaryInsuranceDetail().getGroup_name());
       primaryInsuranceDetail.setInsuranceAddress(addPatientModel.getPrimaryInsuranceDetail().getInsuranceAddress());
       primaryInsuranceDetail.setSsn(addPatientModel.getPrimaryInsuranceDetail().getSsn());
       primaryInsuranceDetail.setCity(addPatientModel.getPrimaryInsuranceDetail().getCity());
       primaryInsuranceDetail.setState(addPatientModel.getPrimaryInsuranceDetail().getState());
       primaryInsuranceDetail.setMop(addPatientModel.getPrimaryInsuranceDetail().getMop());
       primaryInsuranceDetail.setPolicyNumber(addPatientModel.getPrimaryInsuranceDetail().getPolicyNumber());
       primaryInsuranceDetail.setEligibility(addPatientModel.getPrimaryInsuranceDetail().getEligibility());
       primaryInsuranceDetail.setEligibilityCheckSelected(addPatientModel.getPrimaryInsuranceDetail().getEligibilityCheckSelected());
       primaryInsuranceDetail.setStatusVerifiedDate(addPatientModel.getPrimaryInsuranceDetail().getStatusVerifiedDate());

       InsuranceDetailByPolicy insuranceDetailByPolicy=new InsuranceDetailByPolicy();
       insuranceDetailByPolicy.setPolicyId("R"+Number);
       insuranceDetailByPolicy.setPrimaryInsuranceDetail(primaryInsuranceDetail);
       demographics.setInsuranceDetailByPolicy(insuranceDetailByPolicy);
       demographicsService.save(demographics);

       AddressDetail addressDetail=new AddressDetail();
       addressDetail.setMrnNumber(mrnNumber);
       addressDetail.setAddress1(addPatientModel.getAddressDetail().getAddress1());
       addressDetail.setAddress2(addPatientModel.getAddressDetail().getAddress2());
       addressDetail.setCity(addPatientModel.getAddressDetail().getCity());
       addressDetail.setState(addPatientModel.getAddressDetail().getState());
       addressDetail.setZipCode(addPatientModel.getAddressDetail().getZipCode());
       addressDetail.setHomePhone(addPatientModel.getAddressDetail().getHomePhone());
       addressDetail.setMobile(addPatientModel.getAddressDetail().getMobile());
       addressDetail.setEmail(addPatientModel.getAddressDetail().getEmail());
       addressDetail.setEpisodeStartDate(addPatientModel.getAddressDetail().getEpisodeStartDate());
       addressDetail.setEpisodeEndDate(addPatientModel.getAddressDetail().getEpisodeEndDate());
       addressDetail.setPreferableCommunicationMethod(addPatientModel.getAddressDetail().getPreferableCommunicationMethod());
       addressDetail.setServiceStartDate(addPatientModel.getAddressDetail().getServiceStartDate());
       addressDetail.setServiceEndDate(addPatientModel.getAddressDetail().getServiceEndDate());
       addressDetailService.save(addressDetail);

       AdmissionSource admissionSource=new AdmissionSource();
       admissionSource.setMrnNumber(mrnNumber);
       admissionSource.setReferralDate(addPatientModel.getAdmissionSource().getReferralDate());
       admissionSource.setSouceOfAdmission(addPatientModel.getAdmissionSource().getSouceOfAdmission());
       admissionSourceService.save(admissionSource);

       PrimaryDiagnosisCode primaryDiagnosisCode=new PrimaryDiagnosisCode();
       primaryDiagnosisCode.setMrnNumber(mrnNumber);
       primaryDiagnosisCode.setPrimaryDiagnosisCode(addPatientModel.getPrimaryDiagnosisCode().getPrimaryDiagnosisCode());
       primaryDiagnosisCode.setDiscription(addPatientModel.getPrimaryDiagnosisCode().getDiscription());
       primaryDiagnosisCode.setiCDQualifier("ICD-10");
       primaryDiagnosisCodeService.save(primaryDiagnosisCode);

       List<SecondDiagnosisCode> secondDiagnosisCodeList=addPatientModel.getSecondDiagnosisCodeList();
       for(SecondDiagnosisCode diagnosisCodes:secondDiagnosisCodeList)
       {
          List<ClinicalGroupingPrimaryDiagnosis> clinicalGroupingPrimaryDiagnosisList=pdgmRapListRepository.findClinicalGroupingPrimaryDiagnosis(diagnosisCodes.getSecondDiagnosisCode());
           for(ClinicalGroupingPrimaryDiagnosis clinicalGroupingPrimaryDiagnosis:clinicalGroupingPrimaryDiagnosisList)
           {
             SecondDiagnosisCode secondDiagnosisCode = new SecondDiagnosisCode();
             secondDiagnosisCode.setiCDQualifier("ICD-10");
             secondDiagnosisCode.setSecondDiagnosisCode(clinicalGroupingPrimaryDiagnosis.getPrimaryDiagnosisCode());
             secondDiagnosisCode.setClinicalGroup(clinicalGroupingPrimaryDiagnosis.getClinicalGroup());
             secondDiagnosisCode.setComorbiditySubGroup(clinicalGroupingPrimaryDiagnosis.getComorbiditySubGroup());
             secondDiagnosisCode.setDiscription(clinicalGroupingPrimaryDiagnosis.getDiscription());
             secondDiagnosisCode.setMrnNumber(mrnNumber);
             secondDiagnosisCodeService.save(secondDiagnosisCode);
           }

       }

       GuarenterDetails guarenterDetails=new GuarenterDetails();
       guarenterDetails.setMrnNumber(mrnNumber);
       guarenterDetails.setFirstName(addPatientModel.getGuarenterDetails().getFirstName());
       guarenterDetails.setLastName(addPatientModel.getGuarenterDetails().getLastName());
       guarenterDetails.setMiddleName(addPatientModel.getGuarenterDetails().getMiddleName());
       guarenterDetails.setAddress(addPatientModel.getGuarenterDetails().getAddress());
       guarenterDetails.setRelationshipToPatient(addPatientModel.getGuarenterDetails().getRelationshipToPatient());
       guarenterDetailsService.save(guarenterDetails);
       OtherProviderDetail otherProviderDetailforRequest=new OtherProviderDetail();
for(OtherProviderDetail otherProviderDetail1:addPatientModel.getOtherProviderDetail()) {
    OtherProviderList otherProviderDetailList = rapRequestFormRepository.OtherProviderDetailList(otherProviderDetail1.getProviderType(),otherProviderDetail1.getProviderName());
    OtherProviderDetail otherProviderDetail = new OtherProviderDetail();
    otherProviderDetail.setFirstName(otherProviderDetailList.getFirstName());
    otherProviderDetail.setLastName(otherProviderDetailList.getLastName());
    otherProviderDetail.setMiddleName(otherProviderDetailList.getMiddleName());
    otherProviderDetail.setPrefix(otherProviderDetailList.getPrefix());
    otherProviderDetail.setSuffix(otherProviderDetailList.getSuffix());
    otherProviderDetail.setDob(otherProviderDetailList.getDob());
    otherProviderDetail.setGender(otherProviderDetailList.getGender());
    otherProviderDetail.setAddressLine(otherProviderDetailList.getAddressLine());
    otherProviderDetail.setCity(otherProviderDetailList.getCity());
    otherProviderDetail.setState(otherProviderDetailList.getState());
    otherProviderDetail.setZipCode(otherProviderDetailList.getZipCode());
    otherProviderDetail.setProviderType(otherProviderDetailList.getProviderType());
    otherProviderDetail.setProviderName(otherProviderDetailList.getProviderName());
    otherProviderDetail.setMrnNumber(mrnNumber);
    otherProviderDetailforRequest=otherProviderDetail;
    otherProviderDetailService.save(otherProviderDetail);
}
       String serviceStartDate = formatter.format(addPatientModel.getAddressDetail().getServiceStartDate());
       Date serviceStartDateParse=new Date(serviceStartDate);

       String serviceEndDate = formatter.format(addPatientModel.getAddressDetail().getServiceEndDate());
       Date serviceEndDateParse=new Date(serviceEndDate);

       HomeHealthAide homeHealthAide=new HomeHealthAide();
       homeHealthAide.setMrnNumber(mrnNumber);
       homeHealthAide.setHomeHealthAideVisit(addPatientModel.getHomeHealthAide().getHomeHealthAideVisit());
       homeHealthAide.setHomeHealthAideUnit(addPatientModel.getHomeHealthAide().getHomeHealthAideUnit());
       homeHealthAide.setHomeHealthAideSelected(addPatientModel.getHomeHealthAide().getHomeHealthAideSelected());
       homeHealthAide.setHomeHealthAideRequestServiceDateTo(serviceEndDateParse);
       homeHealthAide.setHomeHealthAideRequestServiceDateFrom(serviceStartDateParse);

       OccupationTherapy occupationTherapy=new OccupationTherapy();
       occupationTherapy.setMrnNumber(mrnNumber);
       occupationTherapy.setOccupationTherapyVisit(addPatientModel.getOccupationTherapy().getOccupationTherapyVisit());
       occupationTherapy.setOccupationTherapyUnit(addPatientModel.getOccupationTherapy().getOccupationTherapyUnit());
       occupationTherapy.setOccupationTherapySelected(addPatientModel.getOccupationTherapy().getOccupationTherapySelected());
       occupationTherapy.setOccupationTherapyRequestServiceDateFrom(serviceStartDateParse);
       occupationTherapy.setOccupationTherapyRequestServiceDateTo(serviceEndDateParse);

       PhysicalTherapy physicalTherapy=new PhysicalTherapy();
       physicalTherapy.setMrnNumber(mrnNumber);
       physicalTherapy.setPhysicalTherapyVisit(addPatientModel.getPhysicalTherapy().getPhysicalTherapyVisit());
       physicalTherapy.setPhysicalTherapyUnit(addPatientModel.getPhysicalTherapy().getPhysicalTherapyUnit());
       physicalTherapy.setPhysicalTherapySelected(addPatientModel.getPhysicalTherapy().getPhysicalTherapySelected());
       physicalTherapy.setPhysicalTherapyRequestServiceDateFrom(serviceStartDateParse);
       physicalTherapy.setPhysicalTherapyRequestServiceDateTo(serviceEndDateParse);

       MedicalSocialWork medicalSocialWork=new MedicalSocialWork();
       medicalSocialWork.setMrnNumber(mrnNumber);
       medicalSocialWork.setMedicalSocialWorkVisit(addPatientModel.getMedicalSocialWork().getMedicalSocialWorkVisit());
       medicalSocialWork.setMedicalSocialWorkUnit(addPatientModel.getMedicalSocialWork().getMedicalSocialWorkUnit());
       medicalSocialWork.setMedicalSocialWorkSelected(addPatientModel.getMedicalSocialWork().getMedicalSocialWorkSelected());
       medicalSocialWork.setMedicalSocialWorkRequestServiceDateFrom(serviceStartDateParse);
       medicalSocialWork.setMedicalSocialWorkRequestServiceDateTo(serviceEndDateParse);

       SkilledNursing skilledNursing=new SkilledNursing();
       skilledNursing.setMrnNumber(mrnNumber);
       skilledNursing.setSkilledNursingVisit(addPatientModel.getSkilledNursing().getSkilledNursingVisit());
       skilledNursing.setSkilledNursingUnit(addPatientModel.getSkilledNursing().getSkilledNursingUnit());
       skilledNursing.setSkilledNursingSelected(addPatientModel.getSkilledNursing().getSkilledNursingSelected());
       skilledNursing.setSkilledNursingRequestServiceDateFrom(serviceStartDateParse);
       skilledNursing.setSkilledNursingRequestServiceDateTo(serviceEndDateParse);

       SpeechPathology speechPathology=new SpeechPathology();
       speechPathology.setMrnNumber(mrnNumber);
       speechPathology.setSpeechPathologyVisit(addPatientModel.getSpeechPathology().getSpeechPathologyVisit());
       speechPathology.setSpeechPathologyUnit(addPatientModel.getSpeechPathology().getSpeechPathologyUnit());
       speechPathology.setSpeechPathologySelected(addPatientModel.getSpeechPathology().getSpeechPathologySelected());
       speechPathology.setSpeechPathologyRequestServiceDateFrom(serviceStartDateParse);
       speechPathology.setSpeechPathologyRequestServiceDateTo(serviceEndDateParse);

       RequestService requestService=new RequestService();
       requestService.setMrnNumber(mrnNumber);
       requestService.setHomeHealthAide(homeHealthAide);
       requestService.setOccupationTherapy(occupationTherapy);
       requestService.setMedicalSocialWork(medicalSocialWork);
       requestService.setSkilledNursing(skilledNursing);
       requestService.setPhysicalTherapy(physicalTherapy);
       requestService.setSpeechPathology(speechPathology);

       EnquiryDeatils enquiryDeatils=new EnquiryDeatils();
       enquiryDeatils.setMrnNumber(mrnNumber);
       enquiryDeatils.setEnquiryId(Number);
       String currentDate = java.time.LocalDate.now().toString();
       LocalDate currentDateF=LocalDate.parse(currentDate);
       enquiryDeatils.setPreauthReqSentDate(currentDateF);
       PreAuthDemographics preAuthDemographics=new PreAuthDemographics();
       preAuthDemographics.setMrnNumber(mrnNumber);
       preAuthDemographics.setFirstName(addPatientModel.getDemographics().getFirstName());
       preAuthDemographics.setLastName(addPatientModel.getDemographics().getLastName());
       preAuthDemographics.setMiddleName(addPatientModel.getDemographics().getMiddleName());
       preAuthDemographics.setPrefix("");
       preAuthDemographics.setSuffix(addPatientModel.getDemographics().getSuffix());
       preAuthDemographics.setGender(addPatientModel.getDemographics().getGender());

       String dob = formatter.format(addPatientModel.getDemographics().getDob());
        Date dob_date=new Date(dob);
       preAuthDemographics.setDob(dob_date);
       preAuthDemographics.setSsn(addPatientModel.getPrimaryInsuranceDetail().getSsn());
       preAuthDemographics.setRelationshipToSubscriber(addPatientModel.getPrimaryInsuranceDetail().getPatientRelationInsured());

       Date defaultDate=new Date("1970-01-01");
       String default_date = "1970-01-01";
       LocalDate default_date1=LocalDate.parse(default_date);
       Episode episode=new Episode();
       episode.setMrnNumber(mrnNumber);
       String EpisodeStartDate = formatter.format(addPatientModel.getAddressDetail().getEpisodeStartDate());
       Date episodeStartDateParse=new Date(EpisodeStartDate);

       String EpisodeEndDate = formatter.format(addPatientModel.getAddressDetail().getEpisodeEndDate());
       Date episodeEndDateParse=new Date(EpisodeEndDate);

       episode.setAdmissionDate(episodeStartDateParse);
       episode.setAdmissionStatus("");
       episode.setEpisodeType("");
       episode.setPayorType("");
       episode.setPreauthFormStatus("");
       episode.setPreAuthorisationStatus("");
       episode.setFormReceivedDate(defaultDate);
       episode.setFormSentDate(default_date1);
       PreAuthDetail preAuthDetail=new PreAuthDetail();
       preAuthDetail.setMrnNumber(mrnNumber);
       preAuthDetail.setPreAuthDemographics(preAuthDemographics);
       preAuthDetail.setEpisode(episode);
       preAuthService.save(preAuthDetail);

       RequesterDetails requesterDetails=new RequesterDetails();
       requesterDetails.setReqProviderLastName(otherProviderDetailforRequest.getLastName());
       requesterDetails.setReqProviderFirstName(otherProviderDetailforRequest.getFirstName());
       requesterDetails.setReqProviderMiddleName(otherProviderDetailforRequest.getMiddleName());
       requesterDetails.setReqProviderPrefix(otherProviderDetailforRequest.getPrefix());
       requesterDetails.setReqProviderSuffix(otherProviderDetailforRequest.getSuffix());
       requesterDetails.setServiceDateFrom(serviceStartDateParse);
       requesterDetails.setServiceDateTo(serviceEndDateParse);
       requesterDetails.setServiceType("");
       requesterDetails.setReqProviderType(otherProviderDetailforRequest.getProviderType());
       requesterDetails.setRequestCategory("");
       requesterDetails.setReqProviderSupplimentalId("");
       requesterDetails.setDischargeDate(episodeEndDateParse);
       requesterDetails.setReqProviderFullName(otherProviderDetailforRequest.getProviderName());
       requesterDetails.setMrnNumber(mrnNumber);
       requesterDetails.setReqProviderIdNumberType("");
       requesterDetails.setReqProviderIdentificationNumberType("");
       requesterDetails.setCertificationType("");
       requesterDetails.setLevelOfService("");
       requesterDetails.setAdmitDate(episodeStartDateParse);

       HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm=new HomeHealthPreAuthorizationForm();
       homeHealthPreAuthorizationForm.setMrnNumber(mrnNumber);
       homeHealthPreAuthorizationForm.setRequestService(requestService);
       homeHealthPreAuthorizationForm.setPreAuthDemographics(preAuthDemographics);
       homeHealthPreAuthorizationForm.setEnquiryDeatils(enquiryDeatils);
       homeHealthPreAuthorizationForm.setProviderDetail(requesterDetails);
       homeHealthPreAuthFormService.save(homeHealthPreAuthorizationForm);

       PDGMRapListing pdgmRapListing=new PDGMRapListing();
       pdgmRapListing.setFirstName(addPatientModel.getDemographics().getFirstName());
       pdgmRapListing.setLastName(addPatientModel.getDemographics().getLastName());
       pdgmRapListing.setMiddleName(addPatientModel.getDemographics().getMiddleName());
       pdgmRapListing.setSuffix(addPatientModel.getDemographics().getSuffix());
       pdgmRapListing.setEpisodeStartDates(episodeStartDateParse);
       pdgmRapListing.setEpisodeEndDates(episodeEndDateParse);
       pdgmRapListing.setPrimaryDiagnosisCode(addPatientModel.getPrimaryDiagnosisCode().getPrimaryDiagnosisCode());
       pdgmRapListing.setEpisodeId("1");
       pdgmRapListing.setOasisType("");
       pdgmRapListing.setOasisKey("");
       pdgmRapListing.setClaimType("");
       pdgmRapListing.setBillableVisit("");
       pdgmRapListing.setAging("");
       pdgmRapListing.setHippsCode("");
       LocalDate hippsCodeGenerationDate=LocalDate.parse("1970-01-01");
       pdgmRapListing.setHippsCodeGeneratedDate(hippsCodeGenerationDate);
       pdgmRapListing.setMrnNumber(mrnNumber);
       pdgmRapListing.setRapsSentDate("No Value");
       pdgmRapListing.setRapsType("");
       pdgmRapListing.setRapsFormStatus("NA");
       pdgmRapListing.setAction("");
       pdgmRapListService.save(pdgmRapListing);
       ackn="true";

       if(ackn.equals("true")) {
           return generateSuccessObject("Success",
                   " ");
       }
       else
       {
           return generateSuccessObject("Fail",
                   "Sent failed ");
       }

   }
    @PostMapping("/editPatient")
    public AddPatientModel editPatient(@RequestBody AddPatientModel addPatientModel) throws Throwable {
        AddPatientModel addPatientModel1=new AddPatientModel();

         Demographics demographics=demographicsService.get(addPatientModel.getDemographics().getMrnNumber());
         //AddressDetail addressDetail=addressDetailService.get(addPatientModel.getDemographics().getMrnNumber());
         AdmissionSource admissionSource=admissionSourceService.get(addPatientModel.getDemographics().getMrnNumber());
         List<OtherProviderDetail> otherProviderDetailList=rapRequestFormRepository.findOtherProviderDetailByMrnNumber(addPatientModel.getDemographics().getMrnNumber());
         PrimaryInsuranceDetail primaryInsuranceDetail=demographics.getInsuranceDetailByPolicy().getPrimaryInsuranceDetail();
         PrimaryDiagnosisCode primaryDiagnosisCode=primaryDiagnosisCodeService.get(addPatientModel.getDemographics().getMrnNumber());
         List<SecondDiagnosisCode> secondDiagnosisCodeList=secondDaignosisCodeRepository.findSecondDiagnosisListCodeByMrn(addPatientModel.getDemographics().getMrnNumber());
         RequestService requestService=requestServiceRepository.findRequestServiceByMrn(addPatientModel.getDemographics().getMrnNumber());
         /*
        SkilledNursing skilledNursing=requestServiceRepository.findSkilledNursingByMrn(addPatientModel.getDemographics().getMrnNumber());
        HomeHealthAide homeHealthAide=requestServiceRepository.findHomeHealthAideByMrn(addPatientModel.getDemographics().getMrnNumber());
        MedicalSocialWork medicalSocialWork=requestServiceRepository.findMedicalSocialWorkByMrn(addPatientModel.getDemographics().getMrnNumber());
        PhysicalTherapy physicalTherapy=requestServiceRepository.findPhysicalTherapyByMrn(addPatientModel.getDemographics().getMrnNumber());
        SpeechPathology speechPathology=requestServiceRepository.findSpeechPathologyByMrn(addPatientModel.getDemographics().getMrnNumber());
        OccupationTherapy occupationTherapy=requestServiceRepository.findOccupationTherapyByMrn(addPatientModel.getDemographics().getMrnNumber());*/
       // GuarenterDetails guarenterDetails=guarenterDetailsService.get(addPatientModel.getDemographics().getMrnNumber());
        addPatientModel1.setDemographics(demographics);
        addPatientModel1.setPrimaryInsuranceDetail(primaryInsuranceDetail);
     //   addPatientModel1.setAddressDetail(addressDetail);
        addPatientModel1.setAdmissionSource(admissionSource);
        //addPatientModel1.setGuarenterDetails(guarenterDetails);
        addPatientModel1.setPrimaryDiagnosisCode(primaryDiagnosisCode);
        addPatientModel1.setSecondDiagnosisCodeList(secondDiagnosisCodeList);
      /*  for(OtherProviderDetail otherProviderDetail:otherProviderDetailList)
        {
            addPatientModel1.setOtherProviderDetail(otherProviderDetail);
        }*/

        addPatientModel1.setOtherProviderDetail(otherProviderDetailList);
        addPatientModel1.setHomeHealthAide(requestService.getHomeHealthAide());
        addPatientModel1.setOccupationTherapy(requestService.getOccupationTherapy());
        addPatientModel1.setPhysicalTherapy(requestService.getPhysicalTherapy());
        addPatientModel1.setMedicalSocialWork(requestService.getMedicalSocialWork());
        addPatientModel1.setSkilledNursing(requestService.getSkilledNursing());
        addPatientModel1.setSpeechPathology(requestService.getSpeechPathology());

       return addPatientModel1;



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
