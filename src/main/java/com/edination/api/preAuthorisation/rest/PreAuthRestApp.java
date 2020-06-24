package com.edination.api.preAuthorisation.rest;

import com.edination.api.Dao.*;
import com.edination.api.eligibility.EDIFile.SFTPFILE;
import com.edination.api.eligibility.model.*;
import com.edination.api.preAuthorisation.EDI.EDIFileGeneration;
import com.edination.api.preAuthorisation.MasterCode.preauthComparator;
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
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
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
    @Autowired
    PreAuthorizationResponseService preAuthorizationResponseService;
    @Autowired
    PreAuthorizationResponseHistoryService preAuthorizationResponseHistoryService;

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
     Collections.sort(list,new preauthComparator());
        List<PreAuthDetail> shortList=list;
        List<PreAuthDetail> list1=new ArrayList<>();
        List<Episode> episodeList=new ArrayList<>();
        List<PreAuthDemographics> preAuthDemographicsList=new ArrayList<>();
        for(PreAuthDetail prauthlist:shortList) {
            //PreAuthDetail preAuthDetail = new PreAuthDetail();

            episodeList.add(prauthlist.getEpisode());
            //preAuthDemographicsList.add(prauthlist.getPreAuthDemographics());
        }
        System.out.println(episodeList);
        System.out.println(preAuthDemographicsList);
        for(Episode episode:episodeList) {
            PreAuthDetail preAuthDetail = new PreAuthDetail();
                String currentDate = java.time.LocalDate.now().toString();
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String admissionDate = formatter.format(episode.getAdmissionDate());
                LocalDate admissionDateBefore = LocalDate.parse(admissionDate);
                LocalDate currentdateAfter = LocalDate.parse(currentDate);

                //calculating number of days in between
                long visitdays = ChronoUnit.DAYS.between(admissionDateBefore, currentdateAfter);
                if (visitdays <= 365) {

                   // preAuthDetail.setPreAuthId(preAuthDemographicsVal.getId());
                    preAuthDetail.setMrnNumber(episode.getMrnNumber());
                    preAuthDetail.setPreAuthDemographics(preAuthDemographicsRepository.findByMrnNumber(episode.getMrnNumber()));
                    preAuthDetail.setEpisode(episode);
                    list1.add(preAuthDetail);

                }

            }




        System.out.println("Final list :"+list1);
        return   list1;
    }

    @PostMapping("/preauthview")
    public List<HomeHealthPreAuthorizationForm> preAuthView(@RequestBody  HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm)  throws Throwable
    {
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
    @PostMapping("/preAuthManualResponseSave")
    public ResponseEntity<?>  preAuthManualResponseSave(@RequestBody  PreAuthorizationResponse preAuthorizationResponse)  throws Throwable
    {
       String ackn= this.preAuthResponseSaveOperation(preAuthorizationResponse);
        if(ackn.equals("true")) {
            PreAuthorizationResponseHistory preAuthorizationResponseHistory=new PreAuthorizationResponseHistory();
            preAuthorizationResponseHistory.setEnquiryId(preAuthorizationResponse.getEnquiryId());
            preAuthorizationResponseHistory.setFirstName(preAuthorizationResponse.getMemberfirstName());
            preAuthorizationResponseHistory.setLastName(preAuthorizationResponse.getMemberlastName());
            preAuthorizationResponseHistory.setMiddleName(preAuthorizationResponse.getMembermiddleName());
            preAuthorizationResponseHistory.setPrefix(preAuthorizationResponse.getMemberPrefix());
            preAuthorizationResponseHistory.setSuffix(preAuthorizationResponse.getMembersuffix());
            String currentDate = java.time.LocalDate.now().toString();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date processDate = formatter.parse(currentDate);

            String EffectiveDateTo = formatter.format(preAuthorizationResponse.getAuthorizationDetail().getEffectiveDateTo());
            LocalDate EffectiveDateToBefore = LocalDate.parse(EffectiveDateTo);
            LocalDate currentdateAfter = LocalDate.parse(currentDate);

            //calculating number of days in between
            long visitdays = ChronoUnit.DAYS.between(currentdateAfter,EffectiveDateToBefore);

        if(visitdays>=0)
           {
             preAuthorizationResponseHistory.setAuthorizationEffectiveNess("Active");
            }
           else
           {
             preAuthorizationResponseHistory.setAuthorizationEffectiveNess("Archived");
           }
            preAuthorizationResponseHistory.setAuthorizationStatus(preAuthorizationResponse.getAuthorizationDetail().getPreAuthorizationStatus());
            preAuthorizationResponseHistory.setMrnNumber(preAuthorizationResponse.getMrnNumber());
            List<PreAuthDetail> list= preAuthRepository.findByID(preAuthorizationResponse.getMrnNumber());
            for(PreAuthDetail pre:list) {
                preAuthorizationResponseHistory.setRequestSentDate(pre.getEpisode().getFormSentDate());
            }
            preAuthorizationResponseHistory.setResponseReceiveDate(processDate);
            preAuthorizationResponseHistory.setResponseType("Manual");

            preAuthorizationResponseHistoryService.save(preAuthorizationResponseHistory);
            return generateSuccessObject("true", " ");
        }
        else
        {
            return generateSuccessObject("false",
                    "Save failed ");
        }
    }
    public String preAuthResponseSaveOperation(PreAuthorizationResponse preAuthorizationResponse1) throws Throwable
    {
       // SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        PreAuthorizationResponse preAuthorizationResponse=new PreAuthorizationResponse();
        preAuthorizationResponse.setEnquiryId(preAuthorizationResponse1.getEnquiryId());
        preAuthorizationResponse.setMemberDetailStatus(preAuthorizationResponse1.getMemberDetailStatus());
        preAuthorizationResponse.setMemberfirstName(preAuthorizationResponse1.getMemberfirstName());
        preAuthorizationResponse.setMemberlastName(preAuthorizationResponse1.getMemberlastName());
        preAuthorizationResponse.setMembermiddleName(preAuthorizationResponse1.getMembermiddleName());
        preAuthorizationResponse.setMembersuffix(preAuthorizationResponse1.getMembersuffix());
        preAuthorizationResponse.setMemberPrefix(preAuthorizationResponse1.getMemberPrefix());
       // Date d=formatter.parse("2020-03-23");
        preAuthorizationResponse.setMemberdob(preAuthorizationResponse1.getMemberdob());
        preAuthorizationResponse.setMembergender(preAuthorizationResponse1.getMembergender());
        preAuthorizationResponse.setMemberRelationshipToSubscriber(preAuthorizationResponse1.getMemberRelationshipToSubscriber());
        preAuthorizationResponse.setMrnNumber(preAuthorizationResponse1.getMrnNumber());

        //String orgName=preAuthorizationResponse1.+" "+insurMap.get("ResponseContactFirstName_04")+" "+insurMap.get("ResponseContactMiddleName_05")+" "+insurMap.get("ResponseContactNameSuffix_07");
        preAuthorizationResponse.setOrganizationName(preAuthorizationResponse1.getOrganizationName());
        preAuthorizationResponse.setOrgDetailStatus(preAuthorizationResponse1.getOrgDetailStatus());
        preAuthorizationResponse.setOrgFollowUpActionDescription(preAuthorizationResponse1.getOrgFollowUpActionDescription());
        preAuthorizationResponse.setOrgIdentificationCode(preAuthorizationResponse1.getOrgIdentificationCode());
        preAuthorizationResponse.setOrgIdentificationCodeType(preAuthorizationResponse1.getOrgIdentificationCodeType());
        preAuthorizationResponse.setOrgRejectionReason(preAuthorizationResponse1.getOrgRejectionReason());
        preAuthorizationResponse.setOrgCommunicationExt(preAuthorizationResponse1.getOrgCommunicationExt());
        preAuthorizationResponse.setOrgCommunicationTypeTelephone(preAuthorizationResponse1.getOrgCommunicationTypeTelephone());
        preAuthorizationResponse.setOrgCommunicationTypeEMail(preAuthorizationResponse1.getOrgCommunicationTypeEMail());
        preAuthorizationResponse.setOrgCommunicationTypeFacsimile(preAuthorizationResponse1.getOrgCommunicationTypeFacsimile());

        RequesterResponseInformation requesterResponseInformation=new RequesterResponseInformation();
        requesterResponseInformation.setReqProviderDetailStatus(preAuthorizationResponse1.getRequesterResponseInformation().getReqProviderDetailStatus());
        requesterResponseInformation.setReqProviderFirstName(preAuthorizationResponse1.getRequesterResponseInformation().getReqProviderFirstName());
        requesterResponseInformation.setReqProviderLastName(preAuthorizationResponse1.getRequesterResponseInformation().getReqProviderLastName());
        requesterResponseInformation.setReqProviderMiddleName(preAuthorizationResponse1.getRequesterResponseInformation().getReqProviderMiddleName());
        String reqproviderfullname=preAuthorizationResponse1.getRequesterResponseInformation().getReqProviderLastName()+" "+preAuthorizationResponse1.getRequesterResponseInformation().getReqProviderFirstName()+" "+preAuthorizationResponse1.getRequesterResponseInformation().getReqProviderMiddleName()+" "+preAuthorizationResponse1.getRequesterResponseInformation().getReqProviderPrefix()+" "+preAuthorizationResponse1.getRequesterResponseInformation().getReqProviderSuffix();
        requesterResponseInformation.setReqProviderFullName(reqproviderfullname);
        requesterResponseInformation.setReqProviderPrefix(preAuthorizationResponse1.getRequesterResponseInformation().getReqProviderPrefix());
        requesterResponseInformation.setReqProviderSuffix(preAuthorizationResponse1.getRequesterResponseInformation().getReqProviderSuffix());
        requesterResponseInformation.setAdmitDate(preAuthorizationResponse1.getRequesterResponseInformation().getAdmitDate());
        requesterResponseInformation.setDischargeDate(preAuthorizationResponse1.getRequesterResponseInformation().getDischargeDate());
        requesterResponseInformation.setCertificationType(preAuthorizationResponse1.getRequesterResponseInformation().getCertificationType());
        requesterResponseInformation.setServiceType(preAuthorizationResponse1.getRequesterResponseInformation().getServiceType());
        requesterResponseInformation.setServiceDateFrom(preAuthorizationResponse1.getRequesterResponseInformation().getServiceDateFrom());
        requesterResponseInformation.setServiceDateTo(preAuthorizationResponse1.getRequesterResponseInformation().getServiceDateTo());
        requesterResponseInformation.setRequestCategory(preAuthorizationResponse1.getRequesterResponseInformation().getRequestCategory());
        requesterResponseInformation.setReqProviderSupplimentalId(preAuthorizationResponse1.getRequesterResponseInformation().getReqProviderSupplimentalId());
        requesterResponseInformation.setReqProviderIdentificationNumber(preAuthorizationResponse1.getRequesterResponseInformation().getReqProviderIdentificationNumber());
        requesterResponseInformation.setReqProviderIdentificationNumberType(preAuthorizationResponse1.getRequesterResponseInformation().getReqProviderIdentificationNumberType());
        requesterResponseInformation.setReqProviderIdNumberType(preAuthorizationResponse1.getRequesterResponseInformation().getReqProviderIdNumberType());
        requesterResponseInformation.setReqProviderType(preAuthorizationResponse1.getRequesterResponseInformation().getReqProviderType());
        requesterResponseInformation.setReqProviderFollowUpActionDescription(preAuthorizationResponse1.getRequesterResponseInformation().getReqProviderFollowUpActionDescription());
        requesterResponseInformation.setReqProviderRejectionReason(preAuthorizationResponse1.getRequesterResponseInformation().getReqProviderRejectionReason());
        preAuthorizationResponse.setRequesterResponseInformation(requesterResponseInformation);

        preAuthorizationResponse.setSubscriberDetailStatus(preAuthorizationResponse1.getSubscriberDetailStatus());
        preAuthorizationResponse.setSubscriberFirstName(preAuthorizationResponse1.getSubscriberFirstName());
        preAuthorizationResponse.setSubscriberLastName(preAuthorizationResponse1.getSubscriberLastName());
        preAuthorizationResponse.setSubscriberMiddleName(preAuthorizationResponse1.getSubscriberMiddleName());
        preAuthorizationResponse.setSubscriberSuffix(preAuthorizationResponse1.getSubscriberSuffix());
        preAuthorizationResponse.setSubscriberPrefix(preAuthorizationResponse1.getSubscriberPrefix());
        preAuthorizationResponse.setSubscriberDob(preAuthorizationResponse1.getSubscriberDob());
        preAuthorizationResponse.setSubscriberGender(preAuthorizationResponse1.getSubscriberGender());
        preAuthorizationResponse.setSubscriberIdentificationNumberType(preAuthorizationResponse1.getSubscriberIdentificationNumberType());
        preAuthorizationResponse.setSubscriberSupplementalId(preAuthorizationResponse1.getSubscriberSupplementalId());
        preAuthorizationResponse.setSubscriberFollowUpActionDescription(preAuthorizationResponse1.getSubscriberFollowUpActionDescription());
        preAuthorizationResponse.setSubscriberRejectionReason(preAuthorizationResponse1.getSubscriberRejectionReason());
        preAuthorizationResponse.setSubscriberRelToInsured(preAuthorizationResponse1.getSubscriberRelToInsured());
        preAuthorizationResponse.setSubscriberIdentificationCode(preAuthorizationResponse1.getSubscriberIdentificationCode());
        preAuthorizationResponse.setSubscriberIdNumberType(preAuthorizationResponse1.getSubscriberIdNumberType());

        DependentDetailResponse dependentDetailResponse=new DependentDetailResponse();
        dependentDetailResponse.setDependentFirstName(preAuthorizationResponse1.getDependentDetailResponse().getDependentFirstName());
        dependentDetailResponse.setDependentLastName(preAuthorizationResponse1.getDependentDetailResponse().getDependentLastName());
        dependentDetailResponse.setDependentMiddleName(preAuthorizationResponse1.getDependentDetailResponse().getDependentMiddleName());
        dependentDetailResponse.setDependentSuffix(preAuthorizationResponse1.getDependentDetailResponse().getDependentSuffix());
        dependentDetailResponse.setDependentDob(preAuthorizationResponse1.getDependentDetailResponse().getDependentDob());
        dependentDetailResponse.setDependentGender(preAuthorizationResponse1.getDependentDetailResponse().getDependentGender());
        dependentDetailResponse.setDependentReletionship(preAuthorizationResponse1.getDependentDetailResponse().getDependentReletionship());
        dependentDetailResponse.setDependentPrefix(preAuthorizationResponse1.getDependentDetailResponse().getDependentPrefix());
        dependentDetailResponse.setDependentSubscriberIdentificationCode(preAuthorizationResponse1.getDependentDetailResponse().getDependentSubscriberIdentificationCode());
        dependentDetailResponse.setDependentSubscriberIdNumberType(preAuthorizationResponse1.getDependentDetailResponse().getDependentSubscriberIdNumberType());
        dependentDetailResponse.setDependentDetailStatus(preAuthorizationResponse1.getDependentDetailResponse().getDependentDetailStatus());
        dependentDetailResponse.setDependentFollowUpActionDescription(preAuthorizationResponse1.getDependentDetailResponse().getDependentFollowUpActionDescription());
        dependentDetailResponse.setDependentRejectionReaso(preAuthorizationResponse1.getDependentDetailResponse().getDependentRejectionReaso());
        dependentDetailResponse.setDependentSupplementalId(preAuthorizationResponse1.getDependentDetailResponse().getDependentSupplementalId());
        dependentDetailResponse.setDependentIdentificationNumberType(preAuthorizationResponse1.getDependentDetailResponse().getDependentIdentificationNumberType());
        preAuthorizationResponse.setDependentDetailResponse(dependentDetailResponse);

        preAuthorizationResponse.setServicingProviderFirstName(preAuthorizationResponse1.getServicingProviderFirstName());
        preAuthorizationResponse.setServicingProviderLastName(preAuthorizationResponse1.getServicingProviderLastName());
        preAuthorizationResponse.setServicingProviderMiddleName(preAuthorizationResponse1.getServicingProviderMiddleName());
        String ServiceProviderFullName=preAuthorizationResponse1.getServicingProviderLastName()+" "+preAuthorizationResponse1.getServicingProviderFirstName()+" "+preAuthorizationResponse1.getServicingProviderMiddleName();
        preAuthorizationResponse.setServicingProviderFullName(ServiceProviderFullName);
        preAuthorizationResponse.setServicingProviderSupplimentId(preAuthorizationResponse1.getServicingProviderSupplimentId());
        preAuthorizationResponse.setServicingProviderDetailStatus(preAuthorizationResponse1.getServicingProviderDetailStatus());
        preAuthorizationResponse.setServicingProviderAddress(preAuthorizationResponse1.getServicingProviderAddress());
        preAuthorizationResponse.setServicingProviderCity(preAuthorizationResponse1.getServicingProviderCity());
        preAuthorizationResponse.setServicingProviderState(preAuthorizationResponse1.getServicingProviderState());
        preAuthorizationResponse.setServicingProviderCountryCode(preAuthorizationResponse1.getServicingProviderCountryCode());
        preAuthorizationResponse.setServicingProviderPostalCode(preAuthorizationResponse1.getServicingProviderPostalCode());
        preAuthorizationResponse.setServicingProviderType(preAuthorizationResponse1.getServicingProviderType());
        preAuthorizationResponse.setServicingProviderIdNumberType(preAuthorizationResponse1.getServicingProviderIdNumberType());
        preAuthorizationResponse.setServicingProviderIdentificationNumber(preAuthorizationResponse1.getServicingProviderIdentificationNumber());
        preAuthorizationResponse.setServicingProviderIdentificationNumberType(preAuthorizationResponse1.getServicingProviderIdentificationNumberType());
        preAuthorizationResponse.setServicingProviderFollowUpActionDescription(preAuthorizationResponse1.getServicingProviderFollowUpActionDescription());
        preAuthorizationResponse.setServicingProviderRejectionReason(preAuthorizationResponse1.getServicingProviderRejectionReason());

        AuthorizationDetail authorizationDetail=new AuthorizationDetail();
        authorizationDetail.setProcessDateAndTime(preAuthorizationResponse1.getAuthorizationDetail().getProcessDateAndTime());
        authorizationDetail.setCertificationIdentificationNumber(preAuthorizationResponse1.getAuthorizationDetail().getCertificationIdentificationNumber());
        authorizationDetail.setEnquiryId(preAuthorizationResponse1.getAuthorizationDetail().getEnquiryId());
        authorizationDetail.setEnquiryDetailStatus(preAuthorizationResponse1.getAuthorizationDetail().getEnquiryDetailStatus());
        authorizationDetail.setAdmitDate(preAuthorizationResponse1.getAuthorizationDetail().getAdmitDate());
        authorizationDetail.setDischargeDate(preAuthorizationResponse1.getAuthorizationDetail().getDischargeDate());
        authorizationDetail.setEffectiveDateFrom(preAuthorizationResponse1.getAuthorizationDetail().getEffectiveDateFrom());
        authorizationDetail.setEffectiveDateTo(preAuthorizationResponse1.getAuthorizationDetail().getEffectiveDateTo());
        authorizationDetail.setExpirationeDateTo(preAuthorizationResponse1.getAuthorizationDetail().getExpirationeDateTo());
        authorizationDetail.setServiceDateFrom(preAuthorizationResponse1.getAuthorizationDetail().getServiceDateFrom());
        authorizationDetail.setServiceDateTo(preAuthorizationResponse1.getAuthorizationDetail().getServiceDateTo());
        authorizationDetail.setTotalUnitsApproved(preAuthorizationResponse1.getAuthorizationDetail().getTotalUnitsApproved());
        authorizationDetail.setNoOfUnitsTobeUsed(preAuthorizationResponse1.getAuthorizationDetail().getNoOfUnitsTobeUsed());
        authorizationDetail.setRemainingUnits(preAuthorizationResponse1.getAuthorizationDetail().getRemainingUnits());
        authorizationDetail.setTotalUnitsConsumed(preAuthorizationResponse1.getAuthorizationDetail().getTotalUnitsConsumed());
        authorizationDetail.setUnitsForNoOfUnitsTobeUsed(preAuthorizationResponse1.getAuthorizationDetail().getUnitsForNoOfUnitsTobeUsed());
        preAuthorizationResponse.setAuthorizationDetail(authorizationDetail);


    HomeHealthAideResponse homeHealthAideResponse = new HomeHealthAideResponse();
    homeHealthAideResponse.setHomeHealthAideSelected(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideSelected());
    homeHealthAideResponse.setHomeHealthAideAuthorizationIdNo(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideAuthorizationIdNo());
    homeHealthAideResponse.setHomeHealthAideEffectiveDateFrom(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideEffectiveDateFrom());
    homeHealthAideResponse.setHomeHealthAideEffectiveDateTo(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideEffectiveDateTo());
    homeHealthAideResponse.setHomeHealthAideExpirationDate(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideExpirationDate());
    homeHealthAideResponse.setHomeHealthAideCertificationAction(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideCertificationAction());
    homeHealthAideResponse.setHomeHealthAideCertificationType(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideCertificationType());
    homeHealthAideResponse.setHomeHealthAideDetailStatus(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideDetailStatus());
    homeHealthAideResponse.setHomeHealthAideLevelOfService(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideLevelOfService());
    homeHealthAideResponse.setHomeHealthAidePoviderLastName(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAidePoviderLastName());
    homeHealthAideResponse.setHomeHealthAideProviderFirstName(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideProviderFirstName());
    homeHealthAideResponse.setHomeHealthAideProviderMiddleName(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideProviderMiddleName());
    String providerfullName = preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAidePoviderLastName() + " " + preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideProviderFirstName() + " " + preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideProviderMiddleName() + " " + preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideProviderPrefix() + " " + preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideProviderSuffix();
    homeHealthAideResponse.setHomeHealthAideProviderFullName(providerfullName);
    homeHealthAideResponse.setHomeHealthAideProviderAddress(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideProviderAddress());
    homeHealthAideResponse.setHomeHealthAideProviderCity(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideProviderCity());
    homeHealthAideResponse.setHomeHealthAideProviderState(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideProviderState());
    homeHealthAideResponse.setHomeHealthAideProviderCountryCode(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideProviderCountryCode());
    homeHealthAideResponse.setHomeHealthAideProviderPostalCode(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideProviderPostalCode());
    homeHealthAideResponse.setHomeHealthAideProviderSupplimentalId(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideProviderSupplimentalId());
    homeHealthAideResponse.setHomeHealthAideProviderIdentificationNumber(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideProviderIdentificationNumber());
    homeHealthAideResponse.setHomeHealthAideProviderIdentificationNumberType(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideProviderIdentificationNumberType());
    homeHealthAideResponse.setHomeHealthAideProviderIdNumberType(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideProviderIdNumberType());
    homeHealthAideResponse.setHomeHealthAideProviderType(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideProviderType());
    homeHealthAideResponse.setHomeHealthAideRequestCategory(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideRequestCategory());
    homeHealthAideResponse.setHomeHealthAideServiceType(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideServiceType());
    homeHealthAideResponse.setHomeHealthAideVisit(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideVisit());
    homeHealthAideResponse.setHomeHealthAideUnit(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideUnit());
    homeHealthAideResponse.setHomeHealthAideProviderFollowUpActionDescription(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideProviderFollowUpActionDescription());
    homeHealthAideResponse.setHomeHealthAideRejectionReason(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideRejectionReason());
    homeHealthAideResponse.setHomeHealthAideRejectionReasonMSG(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideRejectionReasonMSG());
    homeHealthAideResponse.setHomeHealthAideProviderRejectionReason(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideProviderRejectionReason());
    homeHealthAideResponse.setHomeHealthAideProviderPrefix(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideProviderPrefix());
    homeHealthAideResponse.setHomeHealthAideProviderSuffix(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideProviderSuffix());
    homeHealthAideResponse.setHomeHealthAideResponseServiceDateFrom(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideResponseServiceDateFrom());
    homeHealthAideResponse.setHomeHealthAideResponseServiceDateTo(preAuthorizationResponse1.getHomeHealthAideResponse().getHomeHealthAideResponseServiceDateTo());
    homeHealthAideResponse.setMrnNumber(preAuthorizationResponse1.getHomeHealthAideResponse().getMrnNumber());
    homeHealthAideResponse.setHomeHealthAideRevenueCode(570);
    preAuthorizationResponse.setHomeHealthAideResponse(homeHealthAideResponse);

            OccupationalTherapyResponse occupationalTherapyResponse = new OccupationalTherapyResponse();
            occupationalTherapyResponse.setOccupationalTherapySelected(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapySelected());
            occupationalTherapyResponse.setOccupationalTherapyAuthorizationIdNo(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyAuthorizationIdNo());
            occupationalTherapyResponse.setOccupationalTherapyEffectiveDateFrom(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyEffectiveDateFrom());
            occupationalTherapyResponse.setOccupationalTherapyEffectiveDateTo(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyEffectiveDateTo());
            occupationalTherapyResponse.setOccupationalTherapyExpirationDate(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyExpirationDate());
            occupationalTherapyResponse.setOccupationalTherapyCertificationAction(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyCertificationAction());
            occupationalTherapyResponse.setOccupationalTherapyCertificationType(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyCertificationType());
            occupationalTherapyResponse.setOccupationalTherapyDetailStatus(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyDetailStatus());
            occupationalTherapyResponse.setOccupationalTherapyLevelOfService(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyLevelOfService());
            occupationalTherapyResponse.setOccupationalTherapyProviderLastName(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyProviderLastName());
            occupationalTherapyResponse.setOccupationalTherapyProviderFirstName(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyProviderFirstName());
            occupationalTherapyResponse.setOccupationalTherapyProviderMiddleName(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyProviderMiddleName());
            String OccupationalTherapyProviderFullName = preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyProviderLastName() + " " + preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyProviderFirstName() + " " + preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyProviderMiddleName() + " " + preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyProviderPrefix() + " " + preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyProviderSuffix();
            occupationalTherapyResponse.setOccupationalTherapyProviderFullName(OccupationalTherapyProviderFullName);
            occupationalTherapyResponse.setOccupationalTherapyAddress(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyAddress());
            occupationalTherapyResponse.setOccupationalTherapyCity(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyCity());
            occupationalTherapyResponse.setOccupationalTherapyState(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyState());
            occupationalTherapyResponse.setOccupationalTherapyCountryCode(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyCountryCode());
            occupationalTherapyResponse.setOccupationalTherapyPostalCode(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyPostalCode());
            occupationalTherapyResponse.setOccupationalTherapyProviderSupplimentalId(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyProviderSupplimentalId());
            occupationalTherapyResponse.setOccupationalTherapyProviderIdentificationNumber(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyProviderIdentificationNumber());
            occupationalTherapyResponse.setOccupationalProviderIdentificationNumberType(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyProviderIdNumberType());
            occupationalTherapyResponse.setOccupationalTherapyProviderIdNumberType(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyProviderIdNumberType());
            occupationalTherapyResponse.setOccupationalTherapyProviderType(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyProviderType());
            occupationalTherapyResponse.setOccupationalTherapyRequestCategory(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyRequestCategory());
            occupationalTherapyResponse.setOccupationalTherapyServiceType(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyServiceType());
            occupationalTherapyResponse.setOccupationalTherapyVisit(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyVisit());
            occupationalTherapyResponse.setOccupationalTherapyUnit(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyUnit());
            occupationalTherapyResponse.setOccupationalTherapyProviderFollowUpActionDescription(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyProviderFollowUpActionDescription());
            occupationalTherapyResponse.setOccupationalTherapyRejectionReason(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyRejectionReason());
            occupationalTherapyResponse.setOccupationalTherapyRejectionReasonMSG(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyRejectionReasonMSG());
            occupationalTherapyResponse.setOccupationalTherapyProviderRejectionReason(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyProviderRejectionReason());
            occupationalTherapyResponse.setOccupationalTherapyProviderPrefix(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyProviderPrefix());
            occupationalTherapyResponse.setOccupationalTherapyProviderSuffix(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyProviderSuffix());
            occupationalTherapyResponse.setOccupationalTherapyResponseServiceDateFrom(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyResponseServiceDateFrom());
            occupationalTherapyResponse.setOccupationalTherapyResponseServiceDateTo(preAuthorizationResponse1.getOccupationalTherapyResponse().getOccupationalTherapyResponseServiceDateTo());
            occupationalTherapyResponse.setMrnNumber(preAuthorizationResponse1.getOccupationalTherapyResponse().getMrnNumber());
            occupationalTherapyResponse.setOccupationalTherapyRevenueCode(430);
            preAuthorizationResponse.setOccupationalTherapyResponse(occupationalTherapyResponse);

            PhysicalTherapyResponse physicalTherapyResponse = new PhysicalTherapyResponse();
            physicalTherapyResponse.setPhysicalTherapySelected(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapySelected());
            physicalTherapyResponse.setPhysicalTherapyAuthorizationIdNo(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyAuthorizationIdNo());
            physicalTherapyResponse.setPhysicalTherapyEffectiveDateFrom(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyEffectiveDateFrom());
            physicalTherapyResponse.setPhysicalTherapyEffectiveDateTo(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyEffectiveDateTo());
            physicalTherapyResponse.setPhysicalTherapyExpirationDate(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyExpirationDate());
            physicalTherapyResponse.setPhysicalTherapyCertificationAction(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyCertificationAction());
            physicalTherapyResponse.setPhysicalTherapyCertificationType(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyCertificationType());
            physicalTherapyResponse.setPhysicalTherapyDetailStatus(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyDetailStatus());
            physicalTherapyResponse.setPhysicalTherapyLevelOfService(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyLevelOfService());
            physicalTherapyResponse.setPhysicalTherapyPoviderLastName(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyPoviderLastName());
            physicalTherapyResponse.setPhysicalTherapyProviderFirstName(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyProviderFirstName());
            physicalTherapyResponse.setPhysicalTherapyProviderMiddleName(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyProviderMiddleName());
            String PhysicalTherapyResponseFullName = preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyPoviderLastName() + " " + preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyProviderFirstName() + " " + preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyProviderMiddleName() + " " + preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyProviderPrefix() + " " + preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyProviderSuffix();
            physicalTherapyResponse.setPhysicalTherapyProviderFullName(PhysicalTherapyResponseFullName);
            physicalTherapyResponse.setPhysicalTherapyProviderAddress(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyProviderAddress());
            physicalTherapyResponse.setPhysicalTherapyProviderCity(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyProviderCity());
            physicalTherapyResponse.setPhysicalTherapyProviderState(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyProviderState());
            physicalTherapyResponse.setPhysicalTherapyProviderCountryCode(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyProviderCountryCode());
            physicalTherapyResponse.setPhysicalTherapyProviderPostalCode(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyProviderPostalCode());
            physicalTherapyResponse.setPhysicalTherapyProviderSupplimentalId(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyProviderSupplimentalId());
            physicalTherapyResponse.setPhysicalTherapyProviderIdentificationNumber(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyProviderIdentificationNumber());
            physicalTherapyResponse.setPhysicalTherapyProviderIdentificationNumberType(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyProviderIdentificationNumberType());
            physicalTherapyResponse.setPhysicalTherapyProviderIdNumberType(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyProviderIdNumberType());
            physicalTherapyResponse.setPhysicalTherapyProviderType(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyProviderType());
            physicalTherapyResponse.setPhysicalTherapyRequestCategory(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyRequestCategory());
            physicalTherapyResponse.setPhysicalTherapyServiceType(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyServiceType());
            physicalTherapyResponse.setPhysicalTherapyVisit(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyVisit());
            physicalTherapyResponse.setPhysicalTherapyUnit(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyUnit());
            physicalTherapyResponse.setPhysicalTherapyProviderFollowUpActionDescription(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyProviderFollowUpActionDescription());
            physicalTherapyResponse.setPhysicalTherapyRejectionReason(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyRejectionReason());
            physicalTherapyResponse.setPhysicalTherapyRejectionReasonMSG(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyRejectionReasonMSG());
            physicalTherapyResponse.setPhysicalTherapyProviderRejectionReason(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyProviderRejectionReason());
            physicalTherapyResponse.setPhysicalTherapyProviderPrefix(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyProviderPrefix());
            physicalTherapyResponse.setPhysicalTherapyProviderSuffix(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyProviderSuffix());
            physicalTherapyResponse.setPhysicalTherapyResponseServiceDateFrom(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyResponseServiceDateFrom());
            physicalTherapyResponse.setPhysicalTherapyResponseServiceDateTo(preAuthorizationResponse1.getPhysicalTherapyResponse().getPhysicalTherapyResponseServiceDateTo());
            physicalTherapyResponse.setMrnNumber(preAuthorizationResponse1.getPhysicalTherapyResponse().getMrnNumber());
            physicalTherapyResponse.setPhysicalTherapyRevenueCode(420);
            preAuthorizationResponse.setPhysicalTherapyResponse(physicalTherapyResponse);

            MedicalSocialWorkResponse medicalSocialWorkResponse = new MedicalSocialWorkResponse();
            medicalSocialWorkResponse.setMedicalSocialWorkSelected(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkSelected());
            medicalSocialWorkResponse.setMedicalSocialWorkAuthorizationIdNo(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkAuthorizationIdNo());
            medicalSocialWorkResponse.setMedicalSocialWorkEffectiveDateFrom(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkEffectiveDateFrom());
            medicalSocialWorkResponse.setMedicalSocialWorkEffectiveDateTo(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkEffectiveDateTo());
            medicalSocialWorkResponse.setMedicalSocialWorkExpirationDate(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkExpirationDate());
            medicalSocialWorkResponse.setMedicalSocialWorkCertificationAction(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkCertificationAction());
            medicalSocialWorkResponse.setMedicalSocialWorkCertificationType(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkCertificationType());
            medicalSocialWorkResponse.setMedicalSocialWorkDetailStatus(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkDetailStatus());
            medicalSocialWorkResponse.setMedicalSocialWorkLevelOfService(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkLevelOfService());
            medicalSocialWorkResponse.setMedicalSocialWorkPoviderLastName(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkPoviderLastName());
            medicalSocialWorkResponse.setMedicalSocialWorkProviderFirstName(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkProviderFirstName());
            medicalSocialWorkResponse.setMedicalSocialWorkProviderMiddleName(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkProviderMiddleName());
            String MedicalSocialWorkfullName = preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkPoviderLastName() + " " + preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkProviderFirstName() + " " + preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkProviderMiddleName() + " " + preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkProviderPrefix() + " " + preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkProviderSuffix();
            medicalSocialWorkResponse.setMedicalSocialWorkProviderFullName(MedicalSocialWorkfullName);
            medicalSocialWorkResponse.setMedicalSocialWorkProviderAddress(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkProviderAddress());
            medicalSocialWorkResponse.setMedicalSocialWorkProviderCity(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkProviderCity());
            medicalSocialWorkResponse.setMedicalSocialWorkProviderState(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkProviderState());
            medicalSocialWorkResponse.setMedicalSocialWorkProviderCountryCode(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkProviderCountryCode());
            medicalSocialWorkResponse.setMedicalSocialWorkProviderPostalCode(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkProviderPostalCode());
            medicalSocialWorkResponse.setMedicalSocialWorkProviderSupplimentalId(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkProviderSupplimentalId());
            medicalSocialWorkResponse.setMedicalSocialWorkProviderIdentificationNumber(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkProviderIdentificationNumber());
            medicalSocialWorkResponse.setMedicalSocialWorkProviderIdentificationNumberType(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkProviderIdentificationNumberType());
            medicalSocialWorkResponse.setMedicalSocialWorkProviderIdNumberType(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkProviderIdNumberType());
            medicalSocialWorkResponse.setMedicalSocialWorkProviderType(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkProviderType());
            medicalSocialWorkResponse.setMedicalSocialWorkRequestCategory(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkRequestCategory());
            medicalSocialWorkResponse.setMedicalSocialWorkServiceType(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkServiceType());
            medicalSocialWorkResponse.setMedicalSocialWorkVisit(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkVisit());
            medicalSocialWorkResponse.setMedicalSocialWorkUnit(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkUnit());
            medicalSocialWorkResponse.setMedicalSocialWorkProviderFollowUpActionDescription(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkProviderFollowUpActionDescription());
            medicalSocialWorkResponse.setMedicalSocialWorkRejectionReason(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkRejectionReason());
            medicalSocialWorkResponse.setMedicalSocialWorkRejectionReasonMSG(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkRejectionReasonMSG());
            medicalSocialWorkResponse.setMedicalSocialWorkProviderRejectionReason(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkProviderRejectionReason());
            medicalSocialWorkResponse.setMedicalSocialWorkProviderPrefix(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkProviderPrefix());
            medicalSocialWorkResponse.setMedicalSocialWorkProviderSuffix(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkProviderSuffix());
            medicalSocialWorkResponse.setMedicalSocialWorkResponseServiceDateFrom(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkResponseServiceDateFrom());
            medicalSocialWorkResponse.setMedicalSocialWorkResponseServiceDateTo(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMedicalSocialWorkResponseServiceDateTo());
            medicalSocialWorkResponse.setMrnNumber(preAuthorizationResponse1.getMedicalSocialWorkResponse().getMrnNumber());
            medicalSocialWorkResponse.setMedicalSocialWorkRevenueCode(560);
            preAuthorizationResponse.setMedicalSocialWorkResponse(medicalSocialWorkResponse);


            SpeechPathologyResponse speechPathologyResponse = new SpeechPathologyResponse();
            speechPathologyResponse.setspeechPathologySelected(preAuthorizationResponse1.getSpeechPathologyResponse().getspeechPathologySelected());
            speechPathologyResponse.setspeechPathologyAuthorizationIdNo(preAuthorizationResponse1.getSpeechPathologyResponse().getspeechPathologyAuthorizationIdNo());
            speechPathologyResponse.setspeechPathologyEffectiveDateFrom(preAuthorizationResponse1.getSpeechPathologyResponse().getspeechPathologyEffectiveDateFrom());
            speechPathologyResponse.setspeechPathologyEffectiveDateTo(preAuthorizationResponse1.getSpeechPathologyResponse().getspeechPathologyEffectiveDateTo());
            speechPathologyResponse.setspeechPathologyExpirationDate(preAuthorizationResponse1.getSpeechPathologyResponse().getspeechPathologyExpirationDate());
            speechPathologyResponse.setSpeechPathologyCertificationAction(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyCertificationAction());
            speechPathologyResponse.setSpeechPathologyCertificationType(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyCertificationType());
            speechPathologyResponse.setSpeechPathologyDetailStatus(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyDetailStatus());
            speechPathologyResponse.setSpeechPathologyLevelOfService(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyLevelOfService());
            speechPathologyResponse.setSpeechPathologyPoviderLastName(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyPoviderLastName());
            speechPathologyResponse.setSpeechPathologyProviderFirstName(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyProviderFirstName());
            speechPathologyResponse.setSpeechPathologyProviderMiddleName(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyProviderMiddleName());
            String SpeechPathologyfullName = preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyPoviderLastName() + " " + preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyProviderFirstName() + " " + preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyProviderMiddleName() + " " + preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyProviderPrefix() + " " + preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyProviderSuffix();
            speechPathologyResponse.setSpeechPathologyProviderFullName(SpeechPathologyfullName);
            speechPathologyResponse.setSpeechPathologyProviderAddress(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyProviderAddress());
            speechPathologyResponse.setSpeechPathologyProviderCity(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyProviderCity());
            speechPathologyResponse.setSpeechPathologyProviderState(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyProviderState());
            speechPathologyResponse.setSpeechPathologyProviderCountryCode(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyProviderCountryCode());
            speechPathologyResponse.setSpeechPathologyProviderPostalCode(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyProviderPostalCode());
            speechPathologyResponse.setSpeechPathologyProviderSupplimentalId(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyProviderSupplimentalId());
            speechPathologyResponse.setSpeechPathologyProviderIdentificationNumber(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyProviderIdentificationNumber());
            speechPathologyResponse.setSpeechPathologyProviderIdentificationNumberType(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyProviderIdentificationNumberType());
            speechPathologyResponse.setSpeechPathologyProviderIdNumberType(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyProviderIdNumberType());
            speechPathologyResponse.setSpeechPathologyProviderType(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyProviderType());
            speechPathologyResponse.setSpeechPathologyRequestCategory(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyRequestCategory());
            speechPathologyResponse.setSpeechPathologyServiceType(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyServiceType());
            speechPathologyResponse.setSpeechPathologyVisit(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyVisit());
            speechPathologyResponse.setSpeechPathologyUnit(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyUnit());
            speechPathologyResponse.setSpeechPathologyProviderFollowUpActionDescription(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyProviderFollowUpActionDescription());
            speechPathologyResponse.setSpeechPathologyRejectionReason(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyRejectionReason());
            speechPathologyResponse.setSpeechPathologyRejectionReasonMSG(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyRejectionReasonMSG());
            speechPathologyResponse.setSpeechPathologyProviderRejectionReason(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyProviderRejectionReason());
            speechPathologyResponse.setSpeechPathologyProviderPrefix(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyProviderPrefix());
            speechPathologyResponse.setSpeechPathologyProviderSuffix(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyProviderSuffix());
            speechPathologyResponse.setSpeechPathologyResponseServiceDateFrom(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyResponseServiceDateFrom());
            speechPathologyResponse.setSpeechPathologyResponseServiceDateTo(preAuthorizationResponse1.getSpeechPathologyResponse().getSpeechPathologyResponseServiceDateTo());
            speechPathologyResponse.setMrnNumber(preAuthorizationResponse1.getSpeechPathologyResponse().getMrnNumber());
            speechPathologyResponse.setSpeechPathologyRevenueCode(440);
            preAuthorizationResponse.setSpeechPathologyResponse(speechPathologyResponse);

            SkilledNursingResponse skilledNursingResponse = new SkilledNursingResponse();
            skilledNursingResponse.setSkilledNursingSelected(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingSelected());
            skilledNursingResponse.setSkilledNursingAuthorizationIdNo(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingAuthorizationIdNo());
            skilledNursingResponse.setSkilledNursingEffectiveDateFrom(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingEffectiveDateFrom());
            skilledNursingResponse.setSkilledNursingEffectiveDateTo(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingEffectiveDateTo());
            skilledNursingResponse.setSkilledNursingExpirationDate(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingExpirationDate());
            skilledNursingResponse.setSkilledNursingCertificationAction(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingCertificationAction());
            skilledNursingResponse.setSkilledNursingCertificationType(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingCertificationType());
            skilledNursingResponse.setSkilledNursingDetailStatus(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingDetailStatus());
            skilledNursingResponse.setSkilledNursingLevelOfService(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingLevelOfService());
            skilledNursingResponse.setSkilledNursingPoviderLastName(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingPoviderLastName());
            skilledNursingResponse.setSkilledNursingProviderFirstName(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingProviderFirstName());
            skilledNursingResponse.setSkilledNursingProviderMiddleName(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingProviderMiddleName());
            String SkilledNursingproviderfullName = preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingPoviderLastName() + " " + preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingProviderFirstName() + " " + preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingProviderMiddleName() + " " + preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingProviderPrefix() + " " + preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingProviderSuffix();
            skilledNursingResponse.setSkilledNursingProviderFullName(SkilledNursingproviderfullName);
            skilledNursingResponse.setSkilledNursingProviderAddress(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingProviderAddress());
            skilledNursingResponse.setSkilledNursingProviderCity(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingProviderCity());
            skilledNursingResponse.setSkilledNursingProviderState(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingProviderState());
            skilledNursingResponse.setSkilledNursingProviderCountryCode(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingProviderCountryCode());
            skilledNursingResponse.setSkilledNursingProviderPostalCode(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingProviderPostalCode());
            skilledNursingResponse.setSkilledNursingProviderSupplimentalId(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingProviderSupplimentalId());
            skilledNursingResponse.setSkilledNursingProviderIdentificationNumber(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingProviderIdentificationNumber());
            skilledNursingResponse.setSkilledNursingProviderIdentificationNumberType(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingProviderIdentificationNumberType());
            skilledNursingResponse.setSkilledNursingProviderIdNumberType(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingProviderIdNumberType());
            skilledNursingResponse.setSkilledNursingProviderType(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingProviderType());
            skilledNursingResponse.setSkilledNursingRequestCategory(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingRequestCategory());
            skilledNursingResponse.setSkilledNursingServiceType(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingServiceType());
            skilledNursingResponse.setSkilledNursingVisit(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingVisit());
            skilledNursingResponse.setSkilledNursingUnit(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingUnit());
            skilledNursingResponse.setSkilledNursingProviderFollowUpActionDescription(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingProviderFollowUpActionDescription());
            skilledNursingResponse.setSkilledNursingRejectionReason(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingRejectionReason());
            skilledNursingResponse.setSkilledNursingRejectionReasonMSG(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingRejectionReasonMSG());
            skilledNursingResponse.setSkilledNursingProviderRejectionReason(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingProviderRejectionReason());
            skilledNursingResponse.setSkilledNursingProviderPrefix(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingProviderPrefix());
            skilledNursingResponse.setSkilledNursingProviderSuffix(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingProviderSuffix());
            skilledNursingResponse.setSkilledNursingResponseServiceDateFrom(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingResponseServiceDateFrom());
            skilledNursingResponse.setSkilledNursingResponseServiceDateTo(preAuthorizationResponse1.getSkilledNursingResponse().getSkilledNursingResponseServiceDateTo());
            skilledNursingResponse.setMrnNumber(preAuthorizationResponse1.getSkilledNursingResponse().getMrnNumber());
            skilledNursingResponse.setSkilledNursingRevenueCode(550);
            preAuthorizationResponse.setSkilledNursingResponse(skilledNursingResponse);

        preAuthorizationResponseService.save(preAuthorizationResponse);

        return "true";
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
