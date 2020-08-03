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
import com.edination.api.rap.Dao.*;
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
    EpisodeDetailService episodeDetailService;
    @Autowired
    RapRequestFormService rapRequestFormService;

    @Autowired
    InsuranceDetailByPolicyServiceRepository insuranceDetailByPolicyServiceRepository;


    @Autowired
    AddressDetailService addressDetailService;
    @Autowired
    AdmissionSourceService admissionSourceService;
    @Autowired
    GuarenterDetailsService guarenterDetailsService;

    @Autowired
    SecondDaignosisCodeRepository secondDaignosisCodeRepository;

@Autowired
OtherProviderDetailRepository otherProviderDetailRepository;
@Autowired
CountOfAddedValueInRapService countOfAddedValueInRapService;



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

        Date serviceStartDateParse = formatter.parse(addPatientModel.getAddressDetail().getServiceStartDate().toString());
        Date serviceEndDateParse = formatter.parse(addPatientModel.getAddressDetail().getServiceEndDate().toString());
        Demographics demographics=new Demographics();
       demographics.setMrnNumber(mrnNumber);
       demographics.setFirstName(addPatientModel.getDemographics().getFirstName());
       demographics.setLastName(addPatientModel.getDemographics().getLastName());
        demographics.setMiddleName(addPatientModel.getDemographics().getMiddleName());
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
       primaryInsuranceDetail.setStartDate(serviceStartDateParse);
       primaryInsuranceDetail.setZipcode(addPatientModel.getPrimaryInsuranceDetail().getZipcode());
       primaryInsuranceDetail.setEndDate(serviceEndDateParse);
       primaryInsuranceDetail.setInsurancePlanType(addPatientModel.getPrimaryInsuranceDetail().getInsurancePlanType());
       primaryInsuranceDetail.setInsurancePlanName(addPatientModel.getPrimaryInsuranceDetail().getInsurancePlanName());
       primaryInsuranceDetail.setGroup_name(addPatientModel.getPrimaryInsuranceDetail().getGroup_name());
       primaryInsuranceDetail.setInsuranceAddress(addPatientModel.getPrimaryInsuranceDetail().getInsuranceAddress());
       primaryInsuranceDetail.setSsn(addPatientModel.getPrimaryInsuranceDetail().getSsn());
       primaryInsuranceDetail.setCity(addPatientModel.getPrimaryInsuranceDetail().getCity());
       primaryInsuranceDetail.setState(addPatientModel.getPrimaryInsuranceDetail().getState());
       primaryInsuranceDetail.setMop(addPatientModel.getPrimaryInsuranceDetail().getMop());
       primaryInsuranceDetail.setPolicyNumber(addPatientModel.getPrimaryInsuranceDetail().getPolicyNumber());
       primaryInsuranceDetail.setEligibility("eligible");
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
       int otherproviderCount=0;
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
    otherproviderCount++;
}
       //String serviceStartDate = formatter.format(addPatientModel.getAddressDetail().getServiceStartDate());
       //Date serviceStartDateParse=new Date(serviceStartDate);

       //String serviceEndDate = formatter.format(addPatientModel.getAddressDetail().getServiceEndDate());
       //Date serviceEndDateParse=new Date(serviceEndDate);
       // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

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
        Date dob = formatter.parse(addPatientModel.getDemographics().getDob().toString());
       preAuthDemographics.setDob(dob);
       preAuthDemographics.setSsn(addPatientModel.getPrimaryInsuranceDetail().getSsn());
       preAuthDemographics.setRelationshipToSubscriber(addPatientModel.getPrimaryInsuranceDetail().getPatientRelationInsured());

       Date defaultDate=formatter.parse("1970-01-01");
       String default_date = "1970-01-01";
       LocalDate default_date1=LocalDate.parse(default_date);
       Episode episode=new Episode();
       episode.setMrnNumber(mrnNumber);
        Date episodeStartDateParse = formatter.parse(addPatientModel.getAddressDetail().getEpisodeStartDate().toString());
      /* Date episodeStartDateParse=new Date(EpisodeStartDate);*/

        Date episodeEndDateParse = formatter.parse(addPatientModel.getAddressDetail().getEpisodeEndDate().toString());
       //Date episodeEndDateParse=new Date(EpisodeEndDate);

       episode.setAdmissionDate(episodeStartDateParse);
       episode.setAdmissionStatus("Admitted");
       episode.setEpisodeType("Start Of Care");
       episode.setPayorType("");
       episode.setPreauthFormStatus("No Action Taken");
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

        PreAuthDemographics preAuthDemographics1=new PreAuthDemographics();
        preAuthDemographics1.setMrnNumber(mrnNumber);
        preAuthDemographics1.setFirstName(addPatientModel.getDemographics().getFirstName());
        preAuthDemographics1.setLastName(addPatientModel.getDemographics().getLastName());
        preAuthDemographics1.setMiddleName(addPatientModel.getDemographics().getMiddleName());
        preAuthDemographics1.setPrefix("");
        preAuthDemographics1.setSuffix(addPatientModel.getDemographics().getSuffix());
        preAuthDemographics1.setGender(addPatientModel.getDemographics().getGender());
        Date dobs = formatter.parse(addPatientModel.getDemographics().getDob().toString());
        preAuthDemographics1.setDob(dobs);
        preAuthDemographics1.setSsn(addPatientModel.getPrimaryInsuranceDetail().getSsn());
        preAuthDemographics1.setRelationshipToSubscriber(addPatientModel.getPrimaryInsuranceDetail().getPatientRelationInsured());

       HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm=new HomeHealthPreAuthorizationForm();
       OrganizationInformation organizationInformation=new OrganizationInformation();
        organizationInformation.setMrnNumber(mrnNumber);
       DependentDetails dependentDetails=new DependentDetails();
        dependentDetails.setMrnNumber(mrnNumber);
       SubscriberDetails subscriberDetails =new SubscriberDetails();
        subscriberDetails.setMrnNumber(mrnNumber);
       homeHealthPreAuthorizationForm.setMrnNumber(mrnNumber);
       homeHealthPreAuthorizationForm.setRequestService(requestService);
       homeHealthPreAuthorizationForm.setPreAuthDemographics(preAuthDemographics1);
       homeHealthPreAuthorizationForm.setEnquiryDeatils(enquiryDeatils);
       homeHealthPreAuthorizationForm.setProviderDetail(requesterDetails);
        homeHealthPreAuthorizationForm.setOrganizationInformation(organizationInformation);
        homeHealthPreAuthorizationForm.setSubscriberDetails(subscriberDetails);
        homeHealthPreAuthorizationForm.setDependentDetails(dependentDetails);

       homeHealthPreAuthFormService.save(homeHealthPreAuthorizationForm);
        EpisodeDetail episode1=new EpisodeDetail();
        episode1.setFirstName(addPatientModel.getDemographics().getFirstName());
        episode1.setLastName(addPatientModel.getDemographics().getLastName());
        episode1.setMiddleName(addPatientModel.getDemographics().getFirstName());
        episode1.setDob(dob);
        episode1.setEpisodeStartDate(episodeStartDateParse);
        episode1.setEpisodeEndDate(episodeEndDateParse);
        episode1.setEpisodeId("1");
        episode1.setEpisodeType("Start Of Care");
        episode1.setGender(addPatientModel.getDemographics().getGender());
        episode1.setMrnNumber(mrnNumber);
        episode1.setNumberOrVisits("");
        episode1.setSuffix(addPatientModel.getDemographics().getSuffix());
        episodeDetailService.save(episode1);
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

       RapRequestForm rapRequestForm=new RapRequestForm();
        rapRequestForm.setStatementCoveredPeriodDateFrom(addPatientModel.getAddressDetail().getEpisodeStartDate());
        rapRequestForm.setServicingProviderType("");
        rapRequestForm.setTypeOfVisit("");
        rapRequestForm.setTypeOfBill("");
        rapRequestForm.setStatementCoveredPeriodDateTo(addPatientModel.getAddressDetail().getEpisodeEndDate());
        rapRequestForm.setRemarks("");
        rapRequestForm.setSourceOfReferral(addPatientModel.getAdmissionSource().getSouceOfAdmission());
        rapRequestForm.setPatientDischargeStatus("");
        rapRequestForm.setDischargeHour("");
        rapRequestForm.setDischargeDate(addPatientModel.getAddressDetail().getEpisodeEndDate());
        rapRequestForm.setBillingProviderType("");
        rapRequestForm.setBillingProviderName("");
        rapRequestForm.setAttendingProviderName("");
        rapRequestForm.setAdmissionDate(addPatientModel.getAddressDetail().getEpisodeStartDate());
        rapRequestForm.setAdmissionHour("");
        rapRequestForm.setServicingProviderName("");
        rapRequestForm.setAccidentState(addPatientModel.getAddressDetail().getEpisodeStartDate().toString());
        rapRequestForm.setAccidentDate(addPatientModel.getAddressDetail().getEpisodeStartDate());
        rapRequestForm.setRemarks("");
        rapRequestForm.setPatientMrn(mrnNumber);
        Patientdetail patientdetail=new Patientdetail();
        patientdetail.setName(addPatientModel.getDemographics().getLastName()+" "+addPatientModel.getDemographics().getFirstName()+" "+addPatientModel.getDemographics().getMiddleName()+" "+addPatientModel.getDemographics().getSuffix());
        patientdetail.setLastName(addPatientModel.getDemographics().getLastName());
        patientdetail.setFirstName(addPatientModel.getDemographics().getFirstName());
        patientdetail.setPrefix("");
        patientdetail.setSuffix(addPatientModel.getDemographics().getSuffix());
        patientdetail.setMiddleName(addPatientModel.getDemographics().getMiddleName());
        patientdetail.setGender(addPatientModel.getDemographics().getGender());
        patientdetail.setDob(addPatientModel.getDemographics().getDob());
        patientdetail.setAddressLine(addPatientModel.getPrimaryInsuranceDetail().getInsuranceAddress());
        patientdetail.setCity(addPatientModel.getPrimaryInsuranceDetail().getCity());
        patientdetail.setState(addPatientModel.getPrimaryInsuranceDetail().getState());
        patientdetail.setZipCode(String.valueOf(addPatientModel.getPrimaryInsuranceDetail().getZipcode()));
        patientdetail.setPatientNameIdentifier(mrnNumber);
        rapRequestForm.setPatientDetail(patientdetail);
        rapRequestFormService.save(rapRequestForm);

        CountOfAddedValueInRap countOfAddedValueInRap=new CountOfAddedValueInRap();
        countOfAddedValueInRap.setMrnNumber(mrnNumber);
        countOfAddedValueInRap.setOtherProviderCount(otherproviderCount);
        countOfAddedValueInRap.setTreatmentAuthorizationCount(0);
        countOfAddedValueInRap.setValueCodeCount(0);
        countOfAddedValueInRap.setOccuranceCodeCount(0);
        countOfAddedValueInRap.setConditionCodeCount(0);
        countOfAddedValueInRapService.save(countOfAddedValueInRap);

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

    @PostMapping("/savePatient")
    public ResponseEntity<?>  savePatient(@RequestBody AddPatientModel addPatientModel) throws Throwable {
        String ackn="false";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date serviceStartDateParse = formatter.parse(addPatientModel.getAddressDetail().getServiceStartDate().toString());
        Date serviceEndDateParse = formatter.parse(addPatientModel.getAddressDetail().getServiceEndDate().toString());
        Random rand = new Random();
        int Number = rand.nextInt(1000);
        String mrnNumber="P"+Number;
        Demographics demographics=new Demographics();
        demographics.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
        demographics.setMiddleName(addPatientModel.getDemographics().getMiddleName());
        demographics.setFirstName(addPatientModel.getDemographics().getFirstName());
        demographics.setLastName(addPatientModel.getDemographics().getLastName());
        demographics.setSuffix(addPatientModel.getDemographics().getSuffix());
        demographics.setDob(addPatientModel.getDemographics().getDob());
        demographics.setGender(addPatientModel.getDemographics().getGender());
        demographics.setRace(addPatientModel.getDemographics().getRace());
        demographics.setGuarenter(addPatientModel.getDemographics().isGuarenter());
        demographics.setEthnicity(addPatientModel.getDemographics().getEthnicity());
        PrimaryInsuranceDetail primaryInsuranceDetail=new PrimaryInsuranceDetail();
        primaryInsuranceDetail.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
        primaryInsuranceDetail.setInsuredfirstName(addPatientModel.getPrimaryInsuranceDetail().getInsuredfirstName());
        primaryInsuranceDetail.setInsuredlastName(addPatientModel.getPrimaryInsuranceDetail().getInsuredlastName());
        primaryInsuranceDetail.setInsuredmiddleName(addPatientModel.getPrimaryInsuranceDetail().getInsuredmiddleName());
        primaryInsuranceDetail.setInsuredsex(addPatientModel.getPrimaryInsuranceDetail().getInsuredsex());
        primaryInsuranceDetail.setInsureddob(addPatientModel.getPrimaryInsuranceDetail().getInsureddob());
        primaryInsuranceDetail.setPatientRelationInsured(addPatientModel.getPrimaryInsuranceDetail().getPatientRelationInsured());
        primaryInsuranceDetail.setStartDate(serviceStartDateParse);
        primaryInsuranceDetail.setZipcode(addPatientModel.getPrimaryInsuranceDetail().getZipcode());
        primaryInsuranceDetail.setEndDate(serviceEndDateParse);
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

        Demographics demographicsdetail=demographicsService.get(addPatientModel.getDemographics().getMrnNumber());
        InsuranceDetailByPolicy insuranceDetailByPolicy=new InsuranceDetailByPolicy();
       insuranceDetailByPolicy.setPolicyId(demographicsdetail.getInsuranceDetailByPolicy().getPolicyId());
        insuranceDetailByPolicy.setPrimaryInsuranceDetail(primaryInsuranceDetail);
        demographics.setInsuranceDetailByPolicy(insuranceDetailByPolicy);
        demographicsService.save(demographics);

        AddressDetail addressDetail=new AddressDetail();
        addressDetail.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
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
        admissionSource.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
        admissionSource.setReferralDate(addPatientModel.getAdmissionSource().getReferralDate());
        admissionSource.setSouceOfAdmission(addPatientModel.getAdmissionSource().getSouceOfAdmission());
        admissionSourceService.save(admissionSource);

        PrimaryDiagnosisCode primaryDiagnosisCode=new PrimaryDiagnosisCode();
        primaryDiagnosisCode.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
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
                secondDiagnosisCode.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
                secondDiagnosisCodeService.save(secondDiagnosisCode);
            }

        }

        GuarenterDetails guarenterDetails=new GuarenterDetails();
        guarenterDetails.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
        guarenterDetails.setFirstName(addPatientModel.getGuarenterDetails().getFirstName());
        guarenterDetails.setLastName(addPatientModel.getGuarenterDetails().getLastName());
        guarenterDetails.setMiddleName(addPatientModel.getGuarenterDetails().getMiddleName());
        guarenterDetails.setAddress(addPatientModel.getGuarenterDetails().getAddress());
        guarenterDetails.setRelationshipToPatient(addPatientModel.getGuarenterDetails().getRelationshipToPatient());
        guarenterDetailsService.save(guarenterDetails);
        int otherproviderCount=0;
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
            otherProviderDetail.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
            otherProviderDetailforRequest=otherProviderDetail;
            otherProviderDetailService.save(otherProviderDetail);
        }
        CountOfAddedValueInRap countOfAddedValueInRap=new CountOfAddedValueInRap();
        countOfAddedValueInRap.setMrnNumber(mrnNumber);
        countOfAddedValueInRap.setOtherProviderCount(otherproviderCount);
        countOfAddedValueInRap.setTreatmentAuthorizationCount(0);
        countOfAddedValueInRap.setValueCodeCount(0);
        countOfAddedValueInRap.setOccuranceCodeCount(0);
        countOfAddedValueInRap.setConditionCodeCount(0);
        countOfAddedValueInRapService.save(countOfAddedValueInRap);

        HomeHealthAide homeHealthAide=new HomeHealthAide();
        homeHealthAide.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
        homeHealthAide.setHomeHealthAideVisit(addPatientModel.getHomeHealthAide().getHomeHealthAideVisit());
        homeHealthAide.setHomeHealthAideUnit(addPatientModel.getHomeHealthAide().getHomeHealthAideUnit());
        homeHealthAide.setHomeHealthAideSelected(addPatientModel.getHomeHealthAide().getHomeHealthAideSelected());
        homeHealthAide.setHomeHealthAideRequestServiceDateTo(serviceEndDateParse);
        homeHealthAide.setHomeHealthAideRequestServiceDateFrom(serviceStartDateParse);

        OccupationTherapy occupationTherapy=new OccupationTherapy();
        occupationTherapy.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
        occupationTherapy.setOccupationTherapyVisit(addPatientModel.getOccupationTherapy().getOccupationTherapyVisit());
        occupationTherapy.setOccupationTherapyUnit(addPatientModel.getOccupationTherapy().getOccupationTherapyUnit());
        occupationTherapy.setOccupationTherapySelected(addPatientModel.getOccupationTherapy().getOccupationTherapySelected());
        occupationTherapy.setOccupationTherapyRequestServiceDateFrom(serviceStartDateParse);
        occupationTherapy.setOccupationTherapyRequestServiceDateTo(serviceEndDateParse);

        PhysicalTherapy physicalTherapy=new PhysicalTherapy();
        physicalTherapy.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
        physicalTherapy.setPhysicalTherapyVisit(addPatientModel.getPhysicalTherapy().getPhysicalTherapyVisit());
        physicalTherapy.setPhysicalTherapyUnit(addPatientModel.getPhysicalTherapy().getPhysicalTherapyUnit());
        physicalTherapy.setPhysicalTherapySelected(addPatientModel.getPhysicalTherapy().getPhysicalTherapySelected());
        physicalTherapy.setPhysicalTherapyRequestServiceDateFrom(serviceStartDateParse);
        physicalTherapy.setPhysicalTherapyRequestServiceDateTo(serviceEndDateParse);

        MedicalSocialWork medicalSocialWork=new MedicalSocialWork();
        medicalSocialWork.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
        medicalSocialWork.setMedicalSocialWorkVisit(addPatientModel.getMedicalSocialWork().getMedicalSocialWorkVisit());
        medicalSocialWork.setMedicalSocialWorkUnit(addPatientModel.getMedicalSocialWork().getMedicalSocialWorkUnit());
        medicalSocialWork.setMedicalSocialWorkSelected(addPatientModel.getMedicalSocialWork().getMedicalSocialWorkSelected());
        medicalSocialWork.setMedicalSocialWorkRequestServiceDateFrom(serviceStartDateParse);
        medicalSocialWork.setMedicalSocialWorkRequestServiceDateTo(serviceEndDateParse);

        SkilledNursing skilledNursing=new SkilledNursing();
        skilledNursing.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
        skilledNursing.setSkilledNursingVisit(addPatientModel.getSkilledNursing().getSkilledNursingVisit());
        skilledNursing.setSkilledNursingUnit(addPatientModel.getSkilledNursing().getSkilledNursingUnit());
        skilledNursing.setSkilledNursingSelected(addPatientModel.getSkilledNursing().getSkilledNursingSelected());
        skilledNursing.setSkilledNursingRequestServiceDateFrom(serviceStartDateParse);
        skilledNursing.setSkilledNursingRequestServiceDateTo(serviceEndDateParse);

        SpeechPathology speechPathology=new SpeechPathology();
        speechPathology.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
        speechPathology.setSpeechPathologyVisit(addPatientModel.getSpeechPathology().getSpeechPathologyVisit());
        speechPathology.setSpeechPathologyUnit(addPatientModel.getSpeechPathology().getSpeechPathologyUnit());
        speechPathology.setSpeechPathologySelected(addPatientModel.getSpeechPathology().getSpeechPathologySelected());
        speechPathology.setSpeechPathologyRequestServiceDateFrom(serviceStartDateParse);
        speechPathology.setSpeechPathologyRequestServiceDateTo(serviceEndDateParse);

        RequestService requestService=new RequestService();
        requestService.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
        requestService.setHomeHealthAide(homeHealthAide);
        requestService.setOccupationTherapy(occupationTherapy);
        requestService.setMedicalSocialWork(medicalSocialWork);
        requestService.setSkilledNursing(skilledNursing);
        requestService.setPhysicalTherapy(physicalTherapy);
        requestService.setSpeechPathology(speechPathology);

        EnquiryDeatils enquiryDeatils=new EnquiryDeatils();
        enquiryDeatils.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
        enquiryDeatils.setEnquiryId(Number);
        String currentDate = java.time.LocalDate.now().toString();
        LocalDate currentDateF=LocalDate.parse(currentDate);
        enquiryDeatils.setPreauthReqSentDate(currentDateF);
        PreAuthDemographics preAuthDemographics=new PreAuthDemographics();
        preAuthDemographics.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
        preAuthDemographics.setFirstName(addPatientModel.getDemographics().getFirstName());
        preAuthDemographics.setLastName(addPatientModel.getDemographics().getLastName());
        preAuthDemographics.setMiddleName(addPatientModel.getDemographics().getMiddleName());
        preAuthDemographics.setPrefix("");
        preAuthDemographics.setSuffix(addPatientModel.getDemographics().getSuffix());
        preAuthDemographics.setGender(addPatientModel.getDemographics().getGender());

        Date dob_date = formatter.parse(addPatientModel.getDemographics().getDob().toString());
      //  Date dob_date=new Date(dob);
        preAuthDemographics.setDob(dob_date);
        preAuthDemographics.setSsn(addPatientModel.getPrimaryInsuranceDetail().getSsn());
        preAuthDemographics.setRelationshipToSubscriber(addPatientModel.getPrimaryInsuranceDetail().getPatientRelationInsured());

        Date defaultDate=formatter.parse("1970-01-01");
        String default_date = "1970-01-01";
        LocalDate default_date1=LocalDate.parse(default_date);
        Episode episode=new Episode();
        episode.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
        Date episodeStartDateParse = formatter.parse(addPatientModel.getAddressDetail().getEpisodeStartDate().toString());
        //Date episodeStartDateParse=new Date(EpisodeStartDate);

        Date episodeEndDateParse = formatter.parse(addPatientModel.getAddressDetail().getEpisodeEndDate().toString());
      //  Date episodeEndDateParse=new Date(EpisodeEndDate);

        episode.setAdmissionDate(episodeStartDateParse);
        episode.setAdmissionStatus("");
        episode.setEpisodeType("Start Of Care");
        episode.setPayorType("");
        episode.setPreauthFormStatus("Save As Draft");
        episode.setPreAuthorisationStatus("");
        episode.setFormReceivedDate(defaultDate);
        episode.setFormSentDate(default_date1);
        PreAuthDetail preAuthDetail=new PreAuthDetail();
        preAuthDetail.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
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
        requesterDetails.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
        requesterDetails.setReqProviderIdNumberType("");
        requesterDetails.setReqProviderIdentificationNumberType("");
        requesterDetails.setCertificationType("");
        requesterDetails.setLevelOfService("");
        requesterDetails.setAdmitDate(episodeStartDateParse);

        PreAuthDemographics preAuthDemographics1=new PreAuthDemographics();
        preAuthDemographics1.setMrnNumber(mrnNumber);
        preAuthDemographics1.setFirstName(addPatientModel.getDemographics().getFirstName());
        preAuthDemographics1.setLastName(addPatientModel.getDemographics().getLastName());
        preAuthDemographics1.setMiddleName(addPatientModel.getDemographics().getMiddleName());
        preAuthDemographics1.setPrefix("");
        preAuthDemographics1.setSuffix(addPatientModel.getDemographics().getSuffix());
        preAuthDemographics1.setGender(addPatientModel.getDemographics().getGender());
        HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm=new HomeHealthPreAuthorizationForm();
        OrganizationInformation organizationInformation=new OrganizationInformation();
        organizationInformation.setMrnNumber(mrnNumber);
        DependentDetails dependentDetails=new DependentDetails();
        dependentDetails.setMrnNumber(mrnNumber);
        SubscriberDetails subscriberDetails =new SubscriberDetails();
        subscriberDetails.setMrnNumber(mrnNumber);
        homeHealthPreAuthorizationForm.setMrnNumber(addPatientModel.getDemographics().getMrnNumber());
        homeHealthPreAuthorizationForm.setRequestService(requestService);
        homeHealthPreAuthorizationForm.setPreAuthDemographics(preAuthDemographics1);
        homeHealthPreAuthorizationForm.setEnquiryDeatils(enquiryDeatils);
        homeHealthPreAuthorizationForm.setProviderDetail(requesterDetails);
        homeHealthPreAuthorizationForm.setDependentDetails(dependentDetails);
        homeHealthPreAuthorizationForm.setSubscriberDetails(subscriberDetails);
        homeHealthPreAuthorizationForm.setOrganizationInformation(organizationInformation);
        homeHealthPreAuthFormService.save(homeHealthPreAuthorizationForm);

        EpisodeDetail episode1=new EpisodeDetail();
        episode1.setFirstName(addPatientModel.getDemographics().getFirstName());
        episode1.setLastName(addPatientModel.getDemographics().getLastName());
        episode1.setMiddleName(addPatientModel.getDemographics().getFirstName());
        episode1.setDob(dob_date);
        episode1.setEpisodeStartDate(episodeStartDateParse);
        episode1.setEpisodeEndDate(episodeEndDateParse);
        episode1.setEpisodeId("1");
        episode1.setEpisodeType("Start Of Care");
        episode1.setGender(addPatientModel.getDemographics().getGender());
        episode1.setMrnNumber(mrnNumber);
        episode1.setNumberOrVisits("");
        episode1.setSuffix(addPatientModel.getDemographics().getSuffix());
        episodeDetailService.save(episode1);

        PDGMRapListing pdgmRapListingList= pdgmRapListService.get(addPatientModel.getDemographics().getMrnNumber());
        PDGMRapListing pdgmRapListing=new PDGMRapListing();
        pdgmRapListing.setFirstName(pdgmRapListingList.getFirstName());
        pdgmRapListing.setLastName(pdgmRapListingList.getLastName());
        pdgmRapListing.setMiddleName(pdgmRapListingList.getMiddleName());
        pdgmRapListing.setSuffix(pdgmRapListingList.getSuffix());
        pdgmRapListing.setEpisodeStartDates(pdgmRapListingList.getEpisodeStartDates());
        pdgmRapListing.setEpisodeEndDates(pdgmRapListingList.getEpisodeEndDates());
        pdgmRapListing.setPrimaryDiagnosisCode(pdgmRapListingList.getPrimaryDiagnosisCode());
        pdgmRapListing.setEpisodeId(pdgmRapListingList.getEpisodeId());
        pdgmRapListing.setOasisType(pdgmRapListingList.getOasisType());
        pdgmRapListing.setOasisKey(pdgmRapListingList.getOasisKey());
        pdgmRapListing.setClaimType(pdgmRapListingList.getClaimType());
        pdgmRapListing.setBillableVisit(pdgmRapListingList.getBillableVisit());
        pdgmRapListing.setAging(pdgmRapListingList.getAging());
        pdgmRapListing.setHippsCode(pdgmRapListingList.getHippsCode());
        //LocalDate hippsCodeGenerationDate=LocalDate.parse("1970-01-01");
        pdgmRapListing.setHippsCodeGeneratedDate(pdgmRapListingList.getHippsCodeGeneratedDate());
        pdgmRapListing.setMrnNumber(pdgmRapListingList.getMrnNumber());
        pdgmRapListing.setRapsSentDate(pdgmRapListingList.getRapsSentDate());
        pdgmRapListing.setRapsType(pdgmRapListingList.getRapsType());
        pdgmRapListing.setRapsFormStatus(pdgmRapListingList.getRapsFormStatus());
        pdgmRapListing.setAction(pdgmRapListingList.getAction());
        pdgmRapListService.save(pdgmRapListing);
        ackn="true";
        RapRequestForm rapRequestForm=new RapRequestForm();
        rapRequestForm.setStatementCoveredPeriodDateFrom(addPatientModel.getAddressDetail().getEpisodeStartDate());
        rapRequestForm.setServicingProviderType("");
        rapRequestForm.setTypeOfVisit("");
        rapRequestForm.setTypeOfBill("");
        rapRequestForm.setStatementCoveredPeriodDateTo(addPatientModel.getAddressDetail().getEpisodeEndDate());
        rapRequestForm.setRemarks("");
        rapRequestForm.setSourceOfReferral(addPatientModel.getAdmissionSource().getSouceOfAdmission());
        rapRequestForm.setPatientDischargeStatus("");
        rapRequestForm.setDischargeHour("");
        rapRequestForm.setDischargeDate(addPatientModel.getAddressDetail().getEpisodeEndDate());
        rapRequestForm.setBillingProviderType("");
        rapRequestForm.setBillingProviderName("");
        rapRequestForm.setAttendingProviderName("");
        rapRequestForm.setAdmissionDate(addPatientModel.getAddressDetail().getEpisodeStartDate());
        rapRequestForm.setAdmissionHour("");
        rapRequestForm.setServicingProviderName("");
        rapRequestForm.setAccidentState(addPatientModel.getAddressDetail().getEpisodeStartDate().toString());
        rapRequestForm.setAccidentDate(addPatientModel.getAddressDetail().getEpisodeStartDate());
        rapRequestForm.setRemarks("");
        rapRequestForm.setPatientMrn(mrnNumber);
        Patientdetail patientdetail=new Patientdetail();
        patientdetail.setName(addPatientModel.getDemographics().getLastName()+" "+addPatientModel.getDemographics().getFirstName()+" "+addPatientModel.getDemographics().getMiddleName()+" "+addPatientModel.getDemographics().getSuffix());
        patientdetail.setLastName(addPatientModel.getDemographics().getLastName());
        patientdetail.setFirstName(addPatientModel.getDemographics().getFirstName());
        patientdetail.setPrefix("");
        patientdetail.setSuffix(addPatientModel.getDemographics().getSuffix());
        patientdetail.setMiddleName(addPatientModel.getDemographics().getMiddleName());
        patientdetail.setGender(addPatientModel.getDemographics().getGender());
        patientdetail.setDob(addPatientModel.getDemographics().getDob());
        patientdetail.setAddressLine(addPatientModel.getPrimaryInsuranceDetail().getInsuranceAddress());
        patientdetail.setCity(addPatientModel.getPrimaryInsuranceDetail().getCity());
        patientdetail.setState(addPatientModel.getPrimaryInsuranceDetail().getState());
        patientdetail.setZipCode(String.valueOf(addPatientModel.getPrimaryInsuranceDetail().getZipcode()));
        patientdetail.setPatientNameIdentifier(mrnNumber);
        rapRequestForm.setPatientDetail(patientdetail);
        rapRequestFormService.save(rapRequestForm);
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
    public AddPatientModel editPatient(@RequestBody IntakeList intakeList) throws Throwable {
        AddPatientModel addPatientModel1=new AddPatientModel();

         Demographics demographics=demographicsService.get(intakeList.getPatientMRN());
         Demographics demographics1=new Demographics();
        demographics1.setEthnicity(demographics.getEthnicity());
        demographics.setMiddleName(demographics.getMiddleName());
        demographics1.setGuarenter(demographics.isGuarenter());
        demographics1.setRace(demographics.getRace());
        demographics1.setGender(demographics.getGender());
        demographics1.setDob(demographics.getDob());
        demographics1.setSuffix(demographics.getSuffix());
        demographics1.setLastName(demographics.getLastName());
        demographics1.setFirstName(demographics.getFirstName());
        demographics1.setMrnNumber(demographics.getMrnNumber());
      //  CountOfAddedValueInRap countOfAddedValueInRap=countOfAddedValueInRapService.get(intakeList.getPatientMRN());
         AddressDetail addressDetail=addressDetailService.get(intakeList.getPatientMRN());
         AdmissionSource admissionSource=admissionSourceService.get(intakeList.getPatientMRN());
         List<OtherProviderDetail> otherProviderDetailList=otherProviderDetailRepository.findOtherProviderDetailByMrnNumber(intakeList.getPatientMRN(),1);
         PrimaryInsuranceDetail primaryInsuranceDetail=demographics.getInsuranceDetailByPolicy().getPrimaryInsuranceDetail();
         PrimaryDiagnosisCode primaryDiagnosisCode=primaryDiagnosisCodeService.get(intakeList.getPatientMRN());
         List<SecondDiagnosisCode> secondDiagnosisCodeList=secondDaignosisCodeRepository.findSecondDiagnosisListCodeByMrn(intakeList.getPatientMRN());
         RequestService requestService=requestServiceRepository.findRequestServiceByMrn(intakeList.getPatientMRN());
         /*
        SkilledNursing skilledNursing=requestServiceRepository.findSkilledNursingByMrn(addPatientModel.getDemographics().getMrnNumber());
        HomeHealthAide homeHealthAide=requestServiceRepository.findHomeHealthAideByMrn(addPatientModel.getDemographics().getMrnNumber());
        MedicalSocialWork medicalSocialWork=requestServiceRepository.findMedicalSocialWorkByMrn(addPatientModel.getDemographics().getMrnNumber());
        PhysicalTherapy physicalTherapy=requestServiceRepository.findPhysicalTherapyByMrn(addPatientModel.getDemographics().getMrnNumber());
        SpeechPathology speechPathology=requestServiceRepository.findSpeechPathologyByMrn(addPatientModel.getDemographics().getMrnNumber());
        OccupationTherapy occupationTherapy=requestServiceRepository.findOccupationTherapyByMrn(addPatientModel.getDemographics().getMrnNumber());*/
        GuarenterDetails guarenterDetails=guarenterDetailsService.get(intakeList.getPatientMRN());
        addPatientModel1.setDemographics(demographics1);
        addPatientModel1.setPrimaryInsuranceDetail(primaryInsuranceDetail);
       addPatientModel1.setAddressDetail(addressDetail);
        addPatientModel1.setAdmissionSource(admissionSource);
        addPatientModel1.setGuarenterDetails(guarenterDetails);
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
