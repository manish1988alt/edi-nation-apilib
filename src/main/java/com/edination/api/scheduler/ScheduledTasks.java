package com.edination.api.scheduler;

import com.edination.api.Dao.*;
import com.edination.api.controllers.X12Controller;
import com.edination.api.eligibility.EDIFile.SFTPFILE;
import com.edination.api.eligibility.model.*;
import com.edination.api.eligibility.rest.RestApp;
import com.edination.api.models.*;
import com.edination.api.preAuthorisation.model.*;
import com.edination.api.preAuthorisation.rest.PreAuthRestApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class ScheduledTasks {
    @Autowired
    PreAuthDemographicsRepository preAuthDemographicsRepository;
    @Autowired
    DemographicsService service;
    @Autowired
    MemberInsuranceService memberInsuranceService;
    @Autowired
    MemberInsuranceRepository memberInsuranceRepository;
    @Autowired
    DemographicRepository demographicRepository;
    @Autowired
    EDI271Repository edi271Repository;
    @Autowired
    EDI271Service edi271Service;
    @Autowired
    PrimaryInsuranceDetailRepository primaryInsuranceDetailRepository;
    @Autowired
    SecondaryInsuranceDetailRepository secondaryInsuranceDetailRepository;
    @Autowired
    TertiaryInsuranceDetailRepository tertiaryInsuranceDetailRepository;
    @Autowired
    VerifyFlagService verifyFlagService;
    @Autowired
    PreAuthorizationResponseRepository preAuthorizationResponseRepository;

    @Autowired
    PreAuthorizationResponseService preAuthorizationResponseService;

    EdiDataElement271 ediDataElement271=new EdiDataElement271();
    EdiDataElement271 ediDataElement272=new EdiDataElement271();


   // @Scheduled(cron = "0 16 16 * * ?")   //   0 * * * * ?  0 0 19 * * ?
   /* public void scheduleTaskWithCronExpressionAuthorization() throws Exception{
        List<PreAuthDemographics> preAuthDemographicsList=preAuthDemographicsRepository.uniqueDemographics();
        PreAuthDetail preAuthDetail=new PreAuthDetail();
        PreAuthDemographics demographics=new PreAuthDemographics();
        Episode episode=new Episode();
        List<X12Interchange> list =new ArrayList<X12Interchange>();
        File f1 = new File("Hipaa-5010-278-GenericResponse.txt");
        //List<PreAuthDemographics> preAuthDemographicsList=preAuthDemographicsRepository.uniqueDemographics();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        PreAuthorizationResponse preAuthorizationResponse=new PreAuthorizationResponse();
        DependentDetailResponse dependentDetailResponse=new DependentDetailResponse();
        RequesterResponseInformation requesterResponseInformation=new RequesterResponseInformation();
        HomeHealthAideResponse homeHealthAideResponse=new HomeHealthAideResponse();
        OccupationalTherapyResponse occupationalTherapyResponse=new OccupationalTherapyResponse();
        PhysicalTherapyResponse physicalTherapyResponse=new PhysicalTherapyResponse();
        MedicalSocialWorkResponse medicalSocialWorkResponse=new MedicalSocialWorkResponse();
        SkilledNursingResponse skilledNursingResponse=new SkilledNursingResponse();
        SpeechPathologyResponse speechPathologyResponse=new SpeechPathologyResponse();

        AuthorizationDetail authorizationDetail=new AuthorizationDetail();
        Set<String> setmrn=new HashSet<>();

        for(PreAuthDemographics preAuthDemographics:preAuthDemographicsList)
        {
            setmrn.add(preAuthDemographics.getMrnNumber());
        }
        Map<String,String> insurenceRejectionMap=new HashMap<>();
        Map<String,String> requesterRejectionMap=new HashMap<>();
        Map<String,String> subscriberRejectionMap=new HashMap<>();
        Map<String,String> PATIENTEVENTRejectionMap=new HashMap<>();
        Map<String,String> ServiceLevelRejectionMap=new HashMap<>();
        Map<String,String> ServiceLevel2RejectionMap=new HashMap<>();
        Map<String,String> serviceproviderrejectionmap=new HashMap<>();
        Map<String,String> serviceprovider2rejectionmap=new HashMap<>();
        Map<String,String> insurMap=new HashMap<>();
        Map<String,String> requesterMap=new HashMap<>();
        Map<String,String> subscriberMap=new HashMap<>();
        Map<String,String> TRN_PATIENTEVENTTRACKINGNUMBER =new HashMap<>();
        Map<String,String> AAA_PATIENTEVENTREQUESTVALIDATION =new HashMap<>();
        Map<String,String> UM_HEALTHCARESERVICESREVIEWINFORMATION =new HashMap<>();
        Map<String,String> HCR_HealthCareServicesReview  =new HashMap<>();
        Map<String,String> REF_AdministrativeReferenceNumber  =new HashMap<>();
        Map<String,String> DTP_PATIENTEVENT  =new HashMap<>();
        Map<String,String> HI_PATIENTDiagonosis  =new HashMap<>();
        Map<String,String> HSD_HealthCareServicesDelivery  =new HashMap<>();
        Map<String,String> CL1_InstitutionalClaimCode  =new HashMap<>();
        Map<String,String> CR1  =new HashMap<>();
        Map<String,String> PWK_PATIENTEVENT  =new HashMap<>();
        Map<String,String> MSG_MessageText  =new HashMap<>();
        Map<String,String> TRN_ServiceLevel =new HashMap<>();
        Map<String,String> AAA_ServiceRequestValidation_ServiceLevel =new HashMap<>();
        Map<String,String> UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel =new HashMap<>();
        Map<String,String> HCR_HealthCareServicesReview_ServiceLevel  =new HashMap<>();
        Map<String,String> REF_AdministrativeReferenceNumber_ServiceLevel  =new HashMap<>();
        Map<String,String> DTP_ServiceLevel  =new HashMap<>();
        Map<String,String> HI_ServiceLevel  =new HashMap<>();
        Map<String,String> HSD_HealthCareServicesDelivery_ServiceLevel  =new HashMap<>();
        Map<String,String> SV_InstitutionalClaimCode_ServiceLevel  =new HashMap<>();
        Map<String,String> PWK_ServiceLevel  =new HashMap<>();
        Map<String,String> MSG_MessageText_ServiceLevel  =new HashMap<>();
        Map<String,String> NM1_ServiceProviderName=new HashMap<>();
        Map<String,String> REF_ServiceProviderSupplementalIdentification=new HashMap<>();
        Map<String,String> n3_ServiceProviderAddress=new HashMap<>();
        Map<String,String> N4_ServiceProviderCity_State_ZIPCode=new HashMap<>();
        Map<String,String> PER_ServiceProviderContactInformation=new HashMap<>();

        Map<String,String> TRN_ServiceLevel2=new HashMap<>();
        Map<String,String> UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2=new HashMap<>();
        Map<String,String> HCR_HealthCareServicesReview_ServiceLevel2=new HashMap<>();
        Map<String,String> REF_AdministrativeReferenceNumber_ServiceLevel2=new HashMap<>();
        Map<String,String> DTP_ServiceLevel2=new HashMap<>();
        Map<String,String> HI_ServiceLevel2=new HashMap<>();
        Map<String,String> SV_InstitutionalClaimCode_ServiceLevel2=new HashMap<>();
        Map<String,String> HSD_HealthCareServicesDelivery_ServiceLevel2=new HashMap<>();
        Map<String,String> PWK_ServiceLevel2=new HashMap<>();
        Map<String,String> MSG_MessageText_ServiceLevel2=new HashMap<>();

        Map<String,String> NM1_ServiceProviderName2=new HashMap();
        Map<String,String> REF_ServiceProviderSupplementalIdentification2=new HashMap();
        Map<String,String> n3_ServiceProviderAddress2=new HashMap();
        Map<String,String> N4_ServiceProviderCity_State_ZIPCode2=new HashMap();
        Map<String,String> PER_ServiceProviderContactInformation2=new HashMap();
        Map<String,String> AAA_ServiceProvider=new HashMap();
        Map<String,String> PRV_ServiceProvider=new HashMap();
        Map<String,String> dependentmap=new HashMap<>();
        Map<String,String> dependentRejectionmap=new HashMap<>();
        int j=2;
        *//*for(String setm:setmrn)
        {*//*
            //System.out.println(setm);
            new SFTPFILE().downloadFile(f1, "P100" + "_" + f1.getName());
            X12Controller x12=new X12Controller();
            try {
                //list = x12.read(f1, false, false, " ", " ");
            }
            catch(Throwable t)
            {
                t.printStackTrace();
            }
            String ackn="";
            for(X12Interchange l:list)
            {

              //  System.out.println(l.getISA().getAcknowledgementRequested14()+" "+l.getISA().getSenderIDQualifier5()+" "+l.getISA().getSecurityInformationQualifier3()+" "+l.getISA().getSecurityInformation4()+" "+l.getISA().getReceiverIDQualifier7()+" "+l.getISA().getAuthorizationInformationQualifier1()+" "+l.getISA().getAuthorizationInformation2()+" "+l.getISA().getInterchangeControlNumber13());
               for(X12Group gs:l.getGroups()) {
                  // System.out.println(gs.getGS().getCodeIdentifyingInformationType1()+" "+gs.getGS().getVersionAndRelease8()+" "+gs.getGS().getTransactionTypeCode7()+" "+gs.getGS().getTime5()+" "+gs.getGS().getSenderIDCode2()+" "+gs.getGS().getReceiverIDCode3()+" "+gs.getGS().getGroupControlNumber6()+" "+gs.getGS().getDate4()+" "+gs.getGS().getCodeIdentifyingInformationType1());
                *//*  for(Object ob:gs.getTransactions())

                  *//*

                List<Object> ls=gs.getTransactions();
                Object    ss=ls.get(0);
                   String st=ss.toString();
                   System.out.println("All Value: "+st);
                 // String charArr[]=st.split(",");split("[, ?.@]+");
                   String charArr[]=st.split("[{,=}]+");
                   boolean insuranceFlag=false;
                   boolean requesterFlag=false;
                   boolean subscriberFlag=false;
                   boolean dependentFlag=false;
                   boolean patientEventrFlag=false;
                   boolean serviceLevelFlag=false;
                   boolean serviceProviderFlag=false;
                   boolean serviceLevel2Flag=false;
                   boolean serviceProvider2Flag=false;

                  for(int i=0;i<charArr.length;i++)
                  {
                      System.out.println(charArr[i]);

                              if ("Loop2010A".equals(charArr[i].trim())&& !("Loop2000B".equals(charArr[i].trim())) && !("AAA_UtilizationManagementOrganization_UMO_RequestValidation".equals(charArr[i].trim()))) {
                                 if("NM1_UtilizationManagementOrganization_UMO_Name".equals(charArr[i+1].trim()))
                                  {
                                      insurMap.put(charArr[i + 2], charArr[i + 3]);
                                      insurMap.put(charArr[i + 4], charArr[i + 5]);
                                      insurMap.put(charArr[i + 6], charArr[i + 7]);
                                      insurMap.put(charArr[i + 8], charArr[i + 9]);
                                      insurMap.put(charArr[i+ 10],charArr[i + 11]);
                                      insurMap.put(charArr[i + 12], charArr[i+ 13]);
                                      insurMap.put(charArr[i+ 14], charArr[i+ 15]);
                                      insurMap.put(charArr[i + 16], charArr[i + 17]);
                                      insurMap.put(charArr[i + 18], charArr[i + 19]);
                                      insurMap.put(charArr[i + 20], charArr[i + 21]);
                                      insurMap.put(charArr[i + 22], charArr[i + 23]);
                                      insurMap.put(charArr[i + 24], charArr[i + 25]);
                                      insurMap.put(charArr[i + 27], charArr[i + 28]);
                                      insurMap.put(charArr[i + 29], charArr[i + 30]);
                                      insurMap.put(charArr[i + 31], charArr[i + 32]);
                                      insurMap.put(charArr[i + 33], charArr[i + 34]);
                                      insurMap.put(charArr[i + 35], charArr[i + 36]);
                                      insurMap.put(charArr[i + 37], charArr[i + 38]);
                                      insurMap.put(charArr[i + 39], charArr[i + 40]);
                                      insurMap.put(charArr[i + 41], charArr[i + 42]);
                                      insurMap.put(charArr[i + 43], charArr[i + 44]);
                                      insurMap.put(charArr[i + 45], charArr[i + 46]);

                                      String orgName=charArr[i + 7]+" "+charArr[i + 9]+" "+charArr[i + 11]+" "+charArr[i + 13]+" "+charArr[i + 15];
                                      preAuthorizationResponse.setOrganizationName(orgName);
                                      preAuthorizationResponse.setOrgDetailStatus("Approved");
                                      preAuthorizationResponse.setOrgFollowUpActionDescription("");
                                      String OrgIdentificationCode=preAuthorizationResponseRepository.findEntityIdentifierCode((charArr[i + 3]));
                                      String OrgIdentificationCodeType=preAuthorizationResponseRepository.findEntityTypeQualifierMaster(String.valueOf(charArr[i + 5]));
                                      preAuthorizationResponse.setOrgIdentificationCode(OrgIdentificationCode);
                                      preAuthorizationResponse.setOrgIdentificationCodeType(OrgIdentificationCodeType);
                                      preAuthorizationResponse.setOrgRejectionReason(" ");
                                      preAuthorizationResponse.setOrgCommunicationExt(charArr[i + 38]);
                                      preAuthorizationResponse.setOrgCommunicationTypeTelephone(charArr[i + 34]);
                                      preAuthorizationResponse.setOrgCommunicationTypeEMail("");
                                      preAuthorizationResponse.setOrgCommunicationTypeFacsimile(charArr[i + 42]);
                                      insuranceFlag=true;
                                  }
                                  }

                                  if(!(insuranceFlag) && "AAA_UtilizationManagementOrganization_UMO_RequestValidation".equals(charArr[i].trim()) && !("null".equals(charArr[i+1].trim())) && !("Loop2000B".equals(charArr[i].trim()))) {
                                      System.out.println("Value of ins: "+j);
                                      insurenceRejectionMap.put(charArr[i+2], charArr[i+3]);
                                      insurenceRejectionMap.put(charArr[i+4], charArr[i+5]);
                                      insurenceRejectionMap.put(charArr[i+6], charArr[i+7]);
                                      insurenceRejectionMap.put(charArr[i+8], charArr[i+9]);
                                      preAuthorizationResponse.setOrgDetailStatus("Rejected");
                                      preAuthorizationResponse.setOrgFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 9]));
                                      preAuthorizationResponse.setOrgRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 7]));



                                  }


                      if ("Loop2010B".equals(charArr[i].trim())&& !("Loop2000C".equals(charArr[i].trim())) && !("AAA_UtilizationManagementOrganization_UMO_RequestValidation".equals(charArr[i].trim()))) {
                          if("NM1_RequesterName".equals(charArr[i+2].trim()))
                          {
                              requesterMap.put(charArr[i + 3], charArr[i + 4]);
                              requesterMap.put(charArr[i + 5], charArr[i + 6]);
                              requesterMap.put(charArr[i + 7], charArr[i + 8]);
                              requesterMap.put(charArr[i + 9], charArr[i + 10]);
                              requesterMap.put(charArr[i+ 11],charArr[i + 12]);
                              requesterMap.put(charArr[i + 13], charArr[i+ 14]);
                              requesterMap.put(charArr[i+ 15], charArr[i+ 16]);
                              requesterMap.put(charArr[i + 17], charArr[i + 18]);
                              requesterMap.put(charArr[i + 19], charArr[i + 20]);
                              requesterMap.put(charArr[i + 21], charArr[i + 22]);
                              requesterMap.put(charArr[i + 23], charArr[i + 24]);
                              requesterMap.put(charArr[i + 25], charArr[i + 26]);
                              requesterMap.put(charArr[i + 29], charArr[i + 30]);
                              requesterMap.put(charArr[i + 31], charArr[i + 32]);
                              requesterMap.put(charArr[i + 33], charArr[i + 34]);
                              requesterMap.put(charArr[i + 35], charArr[i + 36]);
                              requesterMap.put(charArr[i + 38], charArr[i + 39]);
                              requesterMap.put(charArr[i + 40], charArr[i + 41]);


                              requesterResponseInformation.setReqProviderDetailStatus("Approved");
                              requesterResponseInformation.setReqProviderFirstName(charArr[i + 10]);
                              requesterResponseInformation.setReqProviderLastName(charArr[i + 8]);
                              requesterResponseInformation.setReqProviderMiddleName(charArr[i + 12]);
                              String reqproviderfullname=charArr[i + 8]+" "+charArr[i + 10]+" "+charArr[i + 12]+" "+charArr[i + 14]+" "+charArr[i + 16];
                              requesterResponseInformation.setReqProviderFullName(reqproviderfullname);
                              requesterResponseInformation.setReqProviderPrefix(charArr[i + 14]);
                              requesterResponseInformation.setReqProviderSuffix(charArr[i + 16]);

                              //if(!("".equals(DTP_PATIENTEVENT.get("DTP_AdmissionDate")))) {
                                  Date AdmissionDate = formatter.parse("2020-01-22");
                                  requesterResponseInformation.setAdmitDate(AdmissionDate);
                              //}
                              //if(!("".equals(DTP_PATIENTEVENT.get("DTP_DischargeDate")))) {
                                  Date DischargeDate = formatter.parse("2020-02-22");
                                  requesterResponseInformation.setDischargeDate(DischargeDate);
                              //}

                              requesterResponseInformation.setReqProviderSupplimentalId(charArr[i + 32]);
                              requesterResponseInformation.setReqProviderIdentificationNumber(preAuthorizationResponseRepository.findEntityIdentifierCode(charArr[i + 4]));
                              requesterResponseInformation.setReqProviderIdentificationNumberType(preAuthorizationResponseRepository.findIdentificationCodeQualifier(charArr[i + 18]));
                              requesterResponseInformation.setReqProviderIdNumberType(preAuthorizationResponseRepository.findReferenceIdentificationQualifier(charArr[i + 30]));
                              requesterResponseInformation.setReqProviderType(charArr[i + 36]);
                              requesterResponseInformation.setReqProviderFollowUpActionDescription("");
                              requesterResponseInformation.setReqProviderRejectionReason("");
                              requesterFlag=true;
                          }
                      }

                          if (!(requesterFlag) && "AAA_UtilizationManagementOrganization_UMO_RequestValidation".equals(charArr[i].trim()) && !("null".equals(charArr[i + 1].trim())) && !("Loop2000C".equals(charArr[i].trim()))) {
                              System.out.println("Value of req: "+j);
                              if(!(insuranceFlag)) {
                                  requesterRejectionMap.put(charArr[i + 11], charArr[i + 12]);
                                  requesterRejectionMap.put(charArr[i + 13], charArr[i + 14]);
                                  requesterRejectionMap.put(charArr[i + 15], charArr[i + 16]);
                                  requesterRejectionMap.put(charArr[i + 17], charArr[i + 18]);
                                  requesterResponseInformation.setReqProviderDetailStatus("Rejected");
                                  requesterResponseInformation.setReqProviderFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 18]));
                                  requesterResponseInformation.setReqProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 16]));
                              }
                              else
                              {
                                  requesterRejectionMap.put(charArr[i + 2], charArr[i + 3]);
                                  requesterRejectionMap.put(charArr[i + 4], charArr[i + 5]);
                                  requesterRejectionMap.put(charArr[i + 6], charArr[i + 7]);
                                  requesterRejectionMap.put(charArr[i + 8], charArr[i + 9]);
                                  requesterResponseInformation.setReqProviderDetailStatus("Rejected");
                                  requesterResponseInformation.setReqProviderFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 9]));
                                  requesterResponseInformation.setReqProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 7]));
                              }


                          }

                      if ("Loop2010C".equals(charArr[i].trim())&& !("Loop2000E".equals(charArr[i].trim())) && !("AAA_UtilizationManagementOrganization_UMO_RequestValidation".equals(charArr[i].trim()))) {
                          if("NM1_SubscriberName".equals(charArr[i+1].trim()))
                          {
                              subscriberMap.put(charArr[i + 2], charArr[i + 3]);
                              subscriberMap.put(charArr[i + 4], charArr[i + 5]);
                              subscriberMap.put(charArr[i + 6], charArr[i + 7]);
                              subscriberMap.put(charArr[i + 8], charArr[i + 9]);
                              subscriberMap.put(charArr[i+ 10],charArr[i + 11]);
                              subscriberMap.put(charArr[i + 12], charArr[i+ 13]);
                              subscriberMap.put(charArr[i+ 14], charArr[i+ 15]);
                              subscriberMap.put(charArr[i + 16], charArr[i + 17]);
                              subscriberMap.put(charArr[i + 18], charArr[i + 19]);
                              subscriberMap.put(charArr[i + 20], charArr[i + 21]);
                              subscriberMap.put(charArr[i + 22], charArr[i + 23]);
                              subscriberMap.put(charArr[i + 24], charArr[i + 25]);
                              subscriberMap.put(charArr[i + 28], charArr[i + 29]);
                              subscriberMap.put(charArr[i + 30], charArr[i + 31]);
                              subscriberMap.put(charArr[i + 32], charArr[i + 33]);
                              subscriberMap.put(charArr[i + 34], charArr[i + 35]);
                              subscriberMap.put(charArr[i + 38], charArr[i + 39]);
                              subscriberMap.put(charArr[i + 40], charArr[i + 41]);
                              subscriberMap.put(charArr[i + 43], charArr[i + 44]);
                              subscriberMap.put(charArr[i + 45], charArr[i + 46]);
                              subscriberMap.put(charArr[i + 47], charArr[i + 48]);
                              subscriberMap.put(charArr[i + 49], charArr[i + 50]);
                              subscriberMap.put(charArr[i + 51], charArr[i + 52]);
                              subscriberMap.put(charArr[i + 53], charArr[i + 54]);
                              subscriberMap.put(charArr[i + 55], charArr[i + 56]);
                              subscriberMap.put(charArr[i + 57], charArr[i + 58]);
                              subscriberMap.put(charArr[i + 60], charArr[i + 61]);
                              subscriberMap.put(charArr[i + 62], charArr[i + 63]);
                              subscriberMap.put(charArr[i + 64], charArr[i + 65]);
                              subscriberMap.put(charArr[i + 66], charArr[i + 67]);
                              subscriberMap.put(charArr[i + 68], charArr[i + 69]);
                              subscriberMap.put(charArr[i + 70], charArr[i + 71]);
                              subscriberMap.put(charArr[i + 72], charArr[i + 73]);
                              subscriberMap.put(charArr[i + 74], charArr[i + 75]);
                              subscriberMap.put(charArr[i + 76], charArr[i + 77]);
                              subscriberMap.put(charArr[i + 78], charArr[i + 79]);
                              subscriberMap.put(charArr[i + 80], charArr[i + 81]);

                              subscriberMap.put(charArr[i + 83], charArr[i + 84]);
                              subscriberMap.put(charArr[i + 85], charArr[i + 86]);
                              subscriberMap.put(charArr[i + 87], charArr[i + 88]);
                              subscriberMap.put(charArr[i + 89], charArr[i + 90]);
                              subscriberMap.put(charArr[i + 91], charArr[i + 92]);
                              subscriberMap.put(charArr[i + 93], charArr[i + 94]);
                              subscriberMap.put(charArr[i + 95], charArr[i + 96]);
                              subscriberMap.put(charArr[i + 97], charArr[i + 98]);
                              subscriberMap.put(charArr[i + 99], charArr[i + 100]);

                              subscriberMap.put(charArr[i + 101], charArr[i + 102]);
                              subscriberMap.put(charArr[i + 103], charArr[i + 104]);
                              subscriberMap.put(charArr[i + 105], charArr[i + 106]);
                              subscriberMap.put(charArr[i + 107], charArr[i + 108]);
                              subscriberMap.put(charArr[i + 109], charArr[i + 110]);
                              subscriberMap.put(charArr[i + 111], charArr[i + 112]);
                              subscriberMap.put(charArr[i + 113], charArr[i + 114]);
                              subscriberMap.put(charArr[i + 115], charArr[i + 116]);
                              subscriberFlag=true;


                               preAuthorizationResponse.setMemberDetailStatus("Approved");
                              preAuthorizationResponse.setMemberfirstName(charArr[i + 9]);
                              preAuthorizationResponse.setMemberlastName(charArr[i + 7]);
                              preAuthorizationResponse.setMembermiddleName(charArr[i + 11]);
                              preAuthorizationResponse.setMembersuffix(charArr[i + 15]);
                              preAuthorizationResponse.setMemberPrefix(charArr[i + 13]);
                              Date subDOB=new Date(charArr[i + 63]);
                              preAuthorizationResponse.setMemberdob(subDOB);
                              preAuthorizationResponse.setMembergender( preAuthorizationResponseRepository.findGenderCode(charArr[i + 65]));//subscriberMap.get(" ")

                              preAuthorizationResponse.setMemberRelationshipToSubscriber(charArr[i + 84]);
                              preAuthorizationResponse.setMrnNumber("P100");
                              preAuthorizationResponse.setSubscriberDetailStatus("Approved");
                              preAuthorizationResponse.setSubscriberFirstName(charArr[i + 9]);
                              preAuthorizationResponse.setSubscriberLastName(charArr[i + 7]);
                              preAuthorizationResponse.setSubscriberMiddleName(charArr[i + 11]);
                              preAuthorizationResponse.setSubscriberSuffix(charArr[i + 15]);
                              preAuthorizationResponse.setSubscriberPrefix(charArr[i + 13]);

                              preAuthorizationResponse.setSubscriberDob(subDOB);
                              preAuthorizationResponse.setSubscriberGender( preAuthorizationResponseRepository.findGenderCode(charArr[i + 65]));
                              preAuthorizationResponse.setSubscriberIdentificationNumberType(preAuthorizationResponseRepository.findEntityIdentifierCode(String.valueOf(charArr[i + 3])));
                              preAuthorizationResponse.setSubscriberSupplementalId(charArr[i + 19]);
                              preAuthorizationResponse.setSubscriberFollowUpActionDescription(" ");
                              preAuthorizationResponse.setSubscriberRejectionReason(" ");
                              preAuthorizationResponse.setSubscriberRelToInsured(preAuthorizationResponseRepository.findReletionship(charArr[i + 86]));
                              preAuthorizationResponse.setSubscriberIdentificationCode(preAuthorizationResponseRepository.findEntityTypeQualifierMaster(charArr[i + 5]));
                              preAuthorizationResponse.setSubscriberIdNumberType(preAuthorizationResponseRepository.findIdentificationCodeQualifier(String.valueOf(charArr[i + 17])));

                          }
                      }

                          if (!(subscriberFlag) && "AAA_UtilizationManagementOrganization_UMO_RequestValidation".equals(charArr[i].trim()) && !("null".equals(charArr[i + 1].trim())) && !("Loop2000E".equals(charArr[i].trim()))) {
                              *//*subscriberRejectionMap.put(charArr[i + 2], charArr[i + 3]);
                              subscriberRejectionMap.put(charArr[i + 4], charArr[i + 5]);
                              subscriberRejectionMap.put(charArr[i + 6], charArr[i + 7]);
                              subscriberRejectionMap.put(charArr[i + 8], charArr[i + 9]);*//*
                              System.out.println("Value of sub: "+j);
                              if(!(insuranceFlag) && !(requesterFlag) ) {
                                  subscriberRejectionMap.put(charArr[i + 20], charArr[i + 21]);
                                  subscriberRejectionMap.put(charArr[i +22], charArr[i + 23]);
                                  subscriberRejectionMap.put(charArr[i + 24], charArr[i + 25]);
                                  subscriberRejectionMap.put(charArr[i + 26], charArr[i + 27]);
                                  preAuthorizationResponse.setSubscriberDetailStatus("Rejected");
                                  preAuthorizationResponse.setSubscriberFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 27]));
                                  preAuthorizationResponse.setSubscriberRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 25]));

                              }
                            else  if(!(insuranceFlag)|| !(requesterFlag)) {
                                  subscriberRejectionMap.put(charArr[i + 11], charArr[i + 12]);
                                  subscriberRejectionMap.put(charArr[i + 13], charArr[i + 14]);
                                  subscriberRejectionMap.put(charArr[i + 15], charArr[i + 16]);
                                  subscriberRejectionMap.put(charArr[i + 17], charArr[i + 18]);
                                  preAuthorizationResponse.setSubscriberDetailStatus("Rejected");
                                  preAuthorizationResponse.setSubscriberFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 18]));
                                  preAuthorizationResponse.setSubscriberRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 16]));
                              }
                              else
                              {
                                  subscriberRejectionMap.put(charArr[i + 2], charArr[i + 3]);
                                  subscriberRejectionMap.put(charArr[i + 4], charArr[i + 5]);
                                  subscriberRejectionMap.put(charArr[i + 6], charArr[i + 7]);
                                  subscriberRejectionMap.put(charArr[i + 8], charArr[i + 9]);
                                  preAuthorizationResponse.setSubscriberDetailStatus("Rejected");
                                  preAuthorizationResponse.setSubscriberFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 9]));
                                  preAuthorizationResponse.setSubscriberRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 7]));
                              }

                          }

                      if ("Loop2010D".equals(charArr[i].trim())&& !("Loop2000E".equals(charArr[i].trim())) && !("AAA_UtilizationManagementOrganization_UMO_RequestValidation".equals(charArr[i].trim())))
                      {

                          if ("NM1_DependentName".equals(charArr[i + 1].trim())) {
                              dependentmap.put(charArr[i + 2], charArr[i + 3]);
                              dependentmap.put(charArr[i + 4], charArr[i + 5]);
                              dependentmap.put(charArr[i + 6], charArr[i + 7]);
                              dependentmap.put(charArr[i + 8], charArr[i + 9]);
                              dependentmap.put(charArr[i+ 10],charArr[i + 11]);
                              dependentmap.put(charArr[i + 12], charArr[i+ 13]);
                              dependentmap.put(charArr[i+ 14], charArr[i+ 15]);
                              dependentmap.put(charArr[i + 16], charArr[i + 17]);
                              dependentmap.put(charArr[i + 18], charArr[i + 19]);
                              dependentmap.put(charArr[i + 20], charArr[i + 21]);
                              dependentmap.put(charArr[i + 22], charArr[i + 23]);
                              dependentmap.put(charArr[i + 24], charArr[i + 25]);
                              dependentmap.put(charArr[i + 28], charArr[i + 29]);
                              dependentmap.put(charArr[i + 30], charArr[i + 31]);
                              dependentmap.put(charArr[i + 32], charArr[i + 33]);
                              dependentmap.put(charArr[i + 35], charArr[i + 36]);
                              dependentmap.put(charArr[i + 37], charArr[i + 38]);
                              dependentmap.put(charArr[i + 39], charArr[i + 40]);
                              dependentmap.put(charArr[i + 41], charArr[i + 42]);
                              dependentmap.put(charArr[i + 43], charArr[i + 44]);
                              dependentmap.put(charArr[i + 45], charArr[i + 46]);
                              dependentmap.put(charArr[i + 47], charArr[i + 48]);
                              dependentmap.put(charArr[i + 49], charArr[i + 50]);
                              dependentmap.put(charArr[i + 51], charArr[i + 52]);
                              dependentmap.put(charArr[i + 53], charArr[i + 54]);
                              dependentmap.put(charArr[i + 55], charArr[i + 56]);
                              dependentmap.put(charArr[i + 57], charArr[i + 58]);


                              dependentDetailResponse.setDependentDetailStatus("Approved");
                              dependentDetailResponse.setDependentFirstName(charArr[i + 9]);
                              dependentDetailResponse.setDependentLastName(charArr[i + 7]);
                              dependentDetailResponse.setDependentMiddleName(charArr[i + 11]);
                              Date d=new Date(charArr[i + 38]);
                              dependentDetailResponse.setDependentSuffix(charArr[i + 15]);
                              dependentDetailResponse.setDependentDob(d);
                              dependentDetailResponse.setDependentGender(preAuthorizationResponseRepository.findGenderCode(charArr[i + 40]));
                              dependentDetailResponse.setDependentReletionship(charArr[i + 58]);
                              dependentDetailResponse.setDependentPrefix(charArr[i + 13]);
                              dependentDetailResponse.setDependentSubscriberIdentificationCode(charArr[i + 17]);
                              dependentDetailResponse.setDependentIdentificationNumberType(preAuthorizationResponseRepository.findEntityIdentifierCode(charArr[i + 3]));
                              dependentDetailResponse.setDependentSubscriberIdNumberType(preAuthorizationResponseRepository.findEntityTypeQualifierMaster(charArr[i + 5]));
                              dependentDetailResponse.setDependentSupplementalId(charArr[i + 17]);
                              dependentDetailResponse.setDependentFollowUpActionDescription("");
                              dependentDetailResponse.setDependentRejectionReaso("");
                              dependentFlag=true;
                          }
                      }

                          if (!(dependentFlag) &&"AAA_UtilizationManagementOrganization_UMO_RequestValidation".equals(charArr[i].trim()) && !("null".equals(charArr[i + 1].trim())) && !("Loop2000E".equals(charArr[i].trim()))) {
                              System.out.println("Value of dep : "+j);
                              if(!(insuranceFlag) && !(requesterFlag) && !(subscriberFlag) ) {
                                  dependentRejectionmap.put(charArr[i + 29], charArr[i + 30]);
                                  dependentRejectionmap.put(charArr[i +31], charArr[i + 32]);
                                  dependentRejectionmap.put(charArr[i + 33], charArr[i + 34]);
                                  dependentRejectionmap.put(charArr[i + 35], charArr[i + 36]);
                                  dependentDetailResponse.setDependentDetailStatus("Rejected");
                                  dependentDetailResponse.setDependentFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 36]));
                                  dependentDetailResponse.setDependentRejectionReaso(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 34]));
                              }
                              else  if(!(insuranceFlag)|| !(requesterFlag) || !(subscriberFlag)) {
                                  dependentRejectionmap.put(charArr[i + 11], charArr[i + 12]);
                                  dependentRejectionmap.put(charArr[i + 13], charArr[i + 14]);
                                  dependentRejectionmap.put(charArr[i + 15], charArr[i + 16]);
                                  dependentRejectionmap.put(charArr[i + 17], charArr[i + 18]);
                                  dependentDetailResponse.setDependentDetailStatus("Rejected");
                                  dependentDetailResponse.setDependentFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 18]));
                                  dependentDetailResponse.setDependentRejectionReaso(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 16]));
                              }
                              else
                              {
                                  dependentRejectionmap.put(charArr[i + 2], charArr[i + 3]);
                                  dependentRejectionmap.put(charArr[i + 4], charArr[i + 5]);
                                  dependentRejectionmap.put(charArr[i + 6], charArr[i + 7]);
                                  dependentRejectionmap.put(charArr[i + 8], charArr[i + 9]);
                                  dependentDetailResponse.setDependentDetailStatus("Rejected");
                                  dependentDetailResponse.setDependentFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 9]));
                                  dependentDetailResponse.setDependentRejectionReaso(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 7]));
                              }

                          }
                      if ("Loop2000E".equals(charArr[i].trim())&& !("".equals(charArr[i+1].trim()))&& !("Loop2010EA".equals(charArr[i].trim()))  && !("AAA_UtilizationManagementOrganization_UMO_RequestValidation".equals(charArr[i].trim()))) {
                          if ("TRN_PatientEventTrackingNumber".equals(charArr[i + 11].trim())) {
                              TRN_PATIENTEVENTTRACKINGNUMBER.put(charArr[i + 13], charArr[i + 14]);
                              TRN_PATIENTEVENTTRACKINGNUMBER.put(charArr[i + 15], charArr[i + 16]);
                              TRN_PATIENTEVENTTRACKINGNUMBER.put(charArr[i + 17], charArr[i + 18]);
                              TRN_PATIENTEVENTTRACKINGNUMBER.put(charArr[i + 19], charArr[i + 20]);
                              AAA_PATIENTEVENTREQUESTVALIDATION.put(charArr[i + 22], charArr[i + 23]);
                          }
                          if ("UM_HealthCareServicesReviewInformation".equals(charArr[i + 24].trim())) {
                              UM_HEALTHCARESERVICESREVIEWINFORMATION.put(charArr[i + 25], charArr[i + 26]);
                              UM_HEALTHCARESERVICESREVIEWINFORMATION.put(charArr[i + 27], charArr[i + 28]);
                              UM_HEALTHCARESERVICESREVIEWINFORMATION.put(charArr[i + 29], charArr[i + 30]);
                          }
                          if ("ValuesEntered_04".equals(charArr[i + 31].trim())) {
                              UM_HEALTHCARESERVICESREVIEWINFORMATION.put(charArr[i + 32], charArr[i + 33]);
                              UM_HEALTHCARESERVICESREVIEWINFORMATION.put(charArr[i + 34], charArr[i + 35]);
                              UM_HEALTHCARESERVICESREVIEWINFORMATION.put(charArr[i + 36], charArr[i + 37]);
                              UM_HEALTHCARESERVICESREVIEWINFORMATION.put(charArr[i + 38], charArr[i + 39]);
                              UM_HEALTHCARESERVICESREVIEWINFORMATION.put(charArr[i + 40], charArr[i + 41]);
                              UM_HEALTHCARESERVICESREVIEWINFORMATION.put(charArr[i + 42], charArr[i + 43]);
                              UM_HEALTHCARESERVICESREVIEWINFORMATION.put(charArr[i + 44], charArr[i + 45]);
                              UM_HEALTHCARESERVICESREVIEWINFORMATION.put(charArr[i + 46], charArr[i + 47]);
                              UM_HEALTHCARESERVICESREVIEWINFORMATION.put(charArr[i + 48], charArr[i + 49]);
                          }
                          if ("HCR_HealthCareServicesReview".equals(charArr[i + 50].trim())) {
                              HCR_HealthCareServicesReview.put(charArr[i + 51], charArr[i + 52]);
                              HCR_HealthCareServicesReview.put(charArr[i + 53], charArr[i + 54]);
                              HCR_HealthCareServicesReview.put(charArr[i + 55], charArr[i + 56]);
                              HCR_HealthCareServicesReview.put(charArr[i + 57], charArr[i + 58]);
                              HCR_HealthCareServicesReview.put(charArr[i + 59], charArr[i + 60]);
                          }

                          if ("REF_AdministrativeReferenceNumber".equals(charArr[i + 62].trim())) {
                              REF_AdministrativeReferenceNumber.put(charArr[i + 63], charArr[i + 64]);
                              REF_AdministrativeReferenceNumber.put(charArr[i + 65], charArr[i + 66]);
                              REF_AdministrativeReferenceNumber.put(charArr[i + 67], charArr[i + 68]);
                              REF_AdministrativeReferenceNumber.put(charArr[i + 69], charArr[i + 70]);
                              REF_AdministrativeReferenceNumber.put(charArr[i + 72], charArr[i + 73]);
                              REF_AdministrativeReferenceNumber.put(charArr[i + 74], charArr[i + 75]);
                              REF_AdministrativeReferenceNumber.put(charArr[i + 76], charArr[i + 77]);
                              REF_AdministrativeReferenceNumber.put(charArr[i + 78], charArr[i + 79]);
                          }
                          if ("AllDTP".equals(charArr[i + 80].trim())) {
                              DTP_PATIENTEVENT.put(charArr[i + 82], charArr[i + 83]);
                              DTP_PATIENTEVENT.put(charArr[i + 84], charArr[i + 85]);
                              DTP_PATIENTEVENT.put(charArr[i + 86], charArr[i + 87]);

                              DTP_PATIENTEVENT.put(charArr[i + 89], charArr[i + 90]);
                              DTP_PATIENTEVENT.put(charArr[i + 91], charArr[i + 92]);
                              DTP_PATIENTEVENT.put(charArr[i + 93], charArr[i + 94]);

                              DTP_PATIENTEVENT.put(charArr[i + 96], charArr[i + 97]);
                              DTP_PATIENTEVENT.put(charArr[i + 98], charArr[i + 99]);
                              DTP_PATIENTEVENT.put(charArr[i + 100], charArr[i + 101]);

                              DTP_PATIENTEVENT.put(charArr[i + 103], charArr[i + 104]);
                              DTP_PATIENTEVENT.put(charArr[i + 105], charArr[i + 106]);
                              DTP_PATIENTEVENT.put(charArr[i + 107], charArr[i + 108]);
                              DTP_PATIENTEVENT.put(charArr[i + 109], charArr[i + 110]);
                              DTP_PATIENTEVENT.put(charArr[i + 112], charArr[i + 113]);
                              DTP_PATIENTEVENT.put(charArr[i + 114], charArr[i + 115]);
                              DTP_PATIENTEVENT.put(charArr[i + 116], charArr[i + 117]);
                              DTP_PATIENTEVENT.put(charArr[i + 119], charArr[i + 120]);
                              DTP_PATIENTEVENT.put(charArr[i + 121], charArr[i + 122]);
                              DTP_PATIENTEVENT.put(charArr[i + 123], charArr[i + 124]);

                              DTP_PATIENTEVENT.put(charArr[i + 126], charArr[i + 127]);
                              DTP_PATIENTEVENT.put(charArr[i + 128], charArr[i + 129]);
                              DTP_PATIENTEVENT.put(charArr[i + 130], charArr[i + 131]);

                              DTP_PATIENTEVENT.put(charArr[i + 133], charArr[i + 134]);
                              DTP_PATIENTEVENT.put(charArr[i + 135], charArr[i + 136]);
                              DTP_PATIENTEVENT.put(charArr[i + 137], charArr[i + 138]);

                              DTP_PATIENTEVENT.put(charArr[i + 140], charArr[i + 141]);
                              DTP_PATIENTEVENT.put(charArr[i + 142], charArr[i + 143]);
                              DTP_PATIENTEVENT.put(charArr[i + 144], charArr[i + 145]);
                          }
                          //diagonosis comman map
                          HI_PATIENTDiagonosis.put(charArr[i + 146], charArr[i + 147]);

                          //HealthCareServicesDelivery
                          HSD_HealthCareServicesDelivery.put(charArr[i + 149], charArr[i + 150]);
                          HSD_HealthCareServicesDelivery.put(charArr[i + 151], charArr[i + 152]);
                          HSD_HealthCareServicesDelivery.put(charArr[i + 153], charArr[i + 154]);
                          HSD_HealthCareServicesDelivery.put(charArr[i + 155], charArr[i + 156]);
                          HSD_HealthCareServicesDelivery.put(charArr[i + 157], charArr[i + 158]);
                          HSD_HealthCareServicesDelivery.put(charArr[i + 159], charArr[i + 160]);
                          HSD_HealthCareServicesDelivery.put(charArr[i + 161], charArr[i + 162]);
                          HSD_HealthCareServicesDelivery.put(charArr[i + 163], charArr[i + 164]);
                         // InstitutionalClaimCode
                          CL1_InstitutionalClaimCode.put(charArr[i + 166], charArr[i + 167]);
                          CL1_InstitutionalClaimCode.put(charArr[i + 168], charArr[i + 169]);
                          CL1_InstitutionalClaimCode.put(charArr[i + 170], charArr[i + 171]);
                          CL1_InstitutionalClaimCode.put(charArr[i + 172], charArr[i + 173]);


                          //CR1
                          CR1.put(charArr[i + 175], charArr[i + 176]);
                          CR1.put(charArr[i + 177], charArr[i + 178]);
                          CR1.put(charArr[i + 179], charArr[i + 180]);
                          CR1.put(charArr[i + 181], charArr[i + 182]);
                          CR1.put(charArr[i + 183], charArr[i + 184]);
                          CR1.put(charArr[i + 185], charArr[i + 186]);
                          CR1.put(charArr[i + 187], charArr[i + 188]);
                          CR1.put(charArr[i + 189], charArr[i + 190]);
                          CR1.put(charArr[i + 191], charArr[i + 192]);
                          CR1.put(charArr[i + 193], charArr[i + 194]);

                          CR1.put(charArr[i + 196], charArr[i + 197]);
                          CR1.put(charArr[i + 198], charArr[i + 199]);
                          CR1.put(charArr[i + 200], charArr[i + 201]);
                          CR1.put(charArr[i + 202], charArr[i + 203]);
                          CR1.put(charArr[i + 204], charArr[i + 205]);
                          CR1.put(charArr[i + 206], charArr[i + 207]);
                          CR1.put(charArr[i + 208], charArr[i + 209]);
                          CR1.put(charArr[i + 210], charArr[i + 211]);
                          CR1.put(charArr[i + 212], charArr[i + 213]);
                          CR1.put(charArr[i + 214], charArr[i + 215]);
                          CR1.put(charArr[i + 216], charArr[i + 217]);
                          CR1.put(charArr[i + 218], charArr[i + 219]);
                          CR1.put(charArr[i + 221], charArr[i + 222]);
                          CR1.put(charArr[i + 223], charArr[i + 224]);
                          CR1.put(charArr[i + 225], charArr[i + 226]);
                          CR1.put(charArr[i + 227], charArr[i + 228]);
                          CR1.put(charArr[i + 229], charArr[i + 230]);
                          CR1.put(charArr[i + 231], charArr[i + 232]);
                          CR1.put(charArr[i + 233], charArr[i + 234]);
                          CR1.put(charArr[i + 235], charArr[i + 236]);
                          CR1.put(charArr[i + 237], charArr[i + 238]);
                          CR1.put(charArr[i + 239], charArr[i + 240]);
                          CR1.put(charArr[i + 241], charArr[i + 242]);
                          CR1.put(charArr[i + 243], charArr[i + 244]);
                          CR1.put(charArr[i + 245], charArr[i + 246]);
                          CR1.put(charArr[i + 247], charArr[i + 248]);
                          CR1.put(charArr[i + 249], charArr[i + 250]);
                          CR1.put(charArr[i + 251], charArr[i + 252]);
                          CR1.put(charArr[i + 253], charArr[i + 254]);
                          CR1.put(charArr[i + 255], charArr[i + 256]);

                          CR1.put(charArr[i + 258], charArr[i + 259]);
                          CR1.put(charArr[i + 260], charArr[i + 261]);
                          CR1.put(charArr[i + 262], charArr[i + 263]);
                          CR1.put(charArr[i + 264], charArr[i + 265]);
                          CR1.put(charArr[i + 266], charArr[i + 267]);
                          CR1.put(charArr[i + 268], charArr[i + 269]);
                          CR1.put(charArr[i + 270], charArr[i + 271]);
                          CR1.put(charArr[i + 272], charArr[i + 273]);
                          CR1.put(charArr[i + 274], charArr[i + 275]);
                          CR1.put(charArr[i + 276], charArr[i + 277]);
                          CR1.put(charArr[i + 278], charArr[i + 279]);
                          CR1.put(charArr[i + 280], charArr[i + 281]);
                          CR1.put(charArr[i + 282], charArr[i + 283]);
                          CR1.put(charArr[i + 284], charArr[i + 285]);
                          CR1.put(charArr[i + 286], charArr[i + 287]);
                          CR1.put(charArr[i + 288], charArr[i + 289]);
                          CR1.put(charArr[i + 290], charArr[i + 291]);
                          CR1.put(charArr[i + 292], charArr[i + 293]);
                          CR1.put(charArr[i + 294], charArr[i + 295]);
                          CR1.put(charArr[i + 296], charArr[i + 297]);
                          CR1.put(charArr[i + 298], charArr[i + 299]);

                          PWK_PATIENTEVENT.put(charArr[i + 300], charArr[i + 301]);
                          MSG_MessageText.put(charArr[i + 303], charArr[i + 304]);
                          MSG_MessageText.put(charArr[i + 306], charArr[i + 307]);
                          MSG_MessageText.put(charArr[i + 308], charArr[i + 309]);

                          preAuthorizationResponse.setEnquiryId(charArr[i + 16]);
                          authorizationDetail.setPreAuthorizationStatus(preAuthorizationResponseRepository.findCertificationActionTypeCodeMaster(charArr[i + 52]));
                          if(!("".equals(DTP_PATIENTEVENT.get("DTP_EventDate")))) {
                              Date EventDate = formatter.parse("2020-04-22");
                              authorizationDetail.setProcessDateAndTime(EventDate);
                          }
                          authorizationDetail.setCertificationIdentificationNumber(charArr[i + 54]);
                          authorizationDetail.setEnquiryId(charArr[i + 16]);
                          authorizationDetail.setEnquiryDetailStatus("Approved");
                          if(!("".equals(charArr[i + 117]))) {
                              Date AdmissionDate = formatter.parse(charArr[i + 117]);
                              authorizationDetail.setAdmitDate(AdmissionDate);
                          }
                          if(!("".equals(charArr[i + 124]))) {
                              Date DischargeDate = formatter.parse(charArr[i + 124]);
                              authorizationDetail.setDischargeDate(DischargeDate);
                          }
                          if(!("".equals(charArr[i + 131]))) {
                              Date CertificationIssueDate = formatter.parse(charArr[i + 131]);
                              authorizationDetail.setEffectiveDateFrom(CertificationIssueDate);
                          }
                          if(!("".equals(charArr[i + 145]))) {
                              Date CertificationEffectiveDate = formatter.parse(charArr[i + 145]);
                              authorizationDetail.setEffectiveDateTo(CertificationEffectiveDate);
                          }
                          if(!("".equals(charArr[i + 138]))) {
                              Date CertificationExpirationDate = formatter.parse(charArr[i + 138]);
                              authorizationDetail.setExpirationeDateTo(CertificationExpirationDate);
                          }
                          Date ServiceDateFrom = formatter.parse("2020-03-12");
                          Date ServiceDateto = formatter.parse("2020-03-30");
                          authorizationDetail.setServiceDateFrom(ServiceDateFrom);
                          authorizationDetail.setServiceDateTo(ServiceDateto);
                          //int TotalUnitsApproved=Integer.parseInt(charArr[i + 60]);
                          // int NoOfUnitsTobeUsed=Integer.parseInt(charArr[i + 52]);
                          int TotalUnitsApproved=6;
                          int NoOfUnitsTobeUsed=2;
                          authorizationDetail.setTotalUnitsApproved(TotalUnitsApproved);
                          authorizationDetail.setNoOfUnitsTobeUsed(NoOfUnitsTobeUsed);
                          authorizationDetail.setRemainingUnits(TotalUnitsApproved-NoOfUnitsTobeUsed);
                          //int TotalUnitsConsumed=Integer.parseInt(charArr[i + 56]);
                          int TotalUnitsConsumed=4;
                          authorizationDetail.setTotalUnitsConsumed(TotalUnitsConsumed);
                          authorizationDetail.setUnitsForNoOfUnitsTobeUsed(preAuthorizationResponseRepository.findUnitOrBasisForMeasurementCodeMaster(String.valueOf(charArr[i + 54])));
                          Date ServiceDateFrom1 = formatter.parse("2020-03-12");
                          Date ServiceDateto1 = formatter.parse("2020-03-30");
                          requesterResponseInformation.setCertificationType(preAuthorizationResponseRepository.findCertificatioType(charArr[i+ 28]));
                          requesterResponseInformation.setServiceType(preAuthorizationResponseRepository.findServiceTypeCodeMaster(charArr[i+ 30]));
                          requesterResponseInformation.setServiceDateFrom(ServiceDateFrom1);
                          requesterResponseInformation.setServiceDateTo(ServiceDateto1);
                          requesterResponseInformation.setRequestCategory(preAuthorizationResponseRepository.findRequestCategory(charArr[i+ 26]));
                          patientEventrFlag=true;
                      }

                          if (!(patientEventrFlag) && "AAA_UtilizationManagementOrganization_UMO_RequestValidation".equals(charArr[i].trim()) && !("null".equals(charArr[i + 1].trim())) && !("Loop2010EA".equals(charArr[i].trim()))) {
                              System.out.println("Value of patient: "+j);


                              if(!(insuranceFlag) && !(requesterFlag) && !(subscriberFlag) && !(dependentFlag)) {
                                  PATIENTEVENTRejectionMap.put(charArr[i + 38], charArr[i + 39]);
                                  PATIENTEVENTRejectionMap.put(charArr[i +40], charArr[i + 41]);
                                  PATIENTEVENTRejectionMap.put(charArr[i + 42], charArr[i + 43]);
                                  PATIENTEVENTRejectionMap.put(charArr[i + 44], charArr[i + 45]);

                                  authorizationDetail.setPreAuthorizationStatus("Rejected");
                                  authorizationDetail.setEnquiryDetailStatus("Rejected");
                                  //authorizationDetail.setEnquiryDetailStatus(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 45]));
                                  //authorizationDetail.setPreAuthorizationStatus(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 43]));
                              }
                              else  if(!(insuranceFlag)|| !(requesterFlag) || !(subscriberFlag) || !(dependentFlag)) {
                                  PATIENTEVENTRejectionMap.put(charArr[i + 11], charArr[i + 12]);
                                  PATIENTEVENTRejectionMap.put(charArr[i + 13], charArr[i + 14]);
                                  PATIENTEVENTRejectionMap.put(charArr[i + 15], charArr[i + 16]);
                                  PATIENTEVENTRejectionMap.put(charArr[i + 17], charArr[i + 18]);

                                  //authorizationDetail.setEnquiryDetailStatus(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 18]));
                                  //authorizationDetail.setPreAuthorizationStatus(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 16]));
                                  authorizationDetail.setPreAuthorizationStatus("Rejected");
                                  authorizationDetail.setEnquiryDetailStatus("Rejected");
                              }
                              else
                              {
                                  PATIENTEVENTRejectionMap.put(charArr[i + 2], charArr[i + 3]);
                                  PATIENTEVENTRejectionMap.put(charArr[i + 4], charArr[i + 5]);
                                  PATIENTEVENTRejectionMap.put(charArr[i + 6], charArr[i + 7]);
                                  PATIENTEVENTRejectionMap.put(charArr[i + 8], charArr[i + 9]);
                                  authorizationDetail.setPreAuthorizationStatus("Rejected");
                                  authorizationDetail.setEnquiryDetailStatus("Rejected");
                                  //authorizationDetail.setEnquiryDetailStatus(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 9]));
                                  //authorizationDetail.setPreAuthorizationStatus(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 7]));
                              }


                          }

                      if ("Loop2000F".equals(charArr[i].trim())&& !("Loop2010FA".equals(charArr[i].trim()))  && !("AAA_UtilizationManagementOrganization_UMO_RequestValidation".equals(charArr[i].trim()))) {
                          if ("HL_ServiceLevel".equals(charArr[i + 2].trim())) {
                              TRN_ServiceLevel.put(charArr[i + 13], charArr[i + 14]);
                              TRN_ServiceLevel.put(charArr[i + 15], charArr[i + 16]);
                              TRN_ServiceLevel.put(charArr[i + 17], charArr[i + 18]);
                              TRN_ServiceLevel.put(charArr[i + 19], charArr[i + 20]);
                              AAA_ServiceRequestValidation_ServiceLevel.put(charArr[i + 22], charArr[i + 23]);

                          }

                          UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel.put(charArr[i + 24], charArr[i + 25]);
                          HCR_HealthCareServicesReview_ServiceLevel.put(charArr[i + 26], charArr[i + 27]);



                        *//*  if ("HCR_HealthCareServicesReview_ServiceLevel".equals(charArr[i + 50].trim())) {
                              HCR_HealthCareServicesReview.put(charArr[i + 51], charArr[i + 52]);
                              HCR_HealthCareServicesReview.put(charArr[i + 53], charArr[i + 54]);
                              HCR_HealthCareServicesReview.put(charArr[i + 55], charArr[i + 56]);
                              HCR_HealthCareServicesReview.put(charArr[i + 57], charArr[i + 58]);
                              HCR_HealthCareServicesReview.put(charArr[i + 59], charArr[i + 60]);
                          }*//*

                          REF_AdministrativeReferenceNumber_ServiceLevel.put(charArr[i + 29], charArr[i + 30]);
                          REF_AdministrativeReferenceNumber_ServiceLevel.put(charArr[i + 31], charArr[i + 32]);
                      *//*    if ("REF_AdministrativeReferenceNumber".equals(charArr[i + 62].trim())) {
                              REF_AdministrativeReferenceNumber.put(charArr[i + 63], charArr[i + 64]);
                              REF_AdministrativeReferenceNumber.put(charArr[i + 65], charArr[i + 66]);
                              REF_AdministrativeReferenceNumber.put(charArr[i + 67], charArr[i + 68]);
                              REF_AdministrativeReferenceNumber.put(charArr[i + 69], charArr[i + 70]);
                              REF_AdministrativeReferenceNumber.put(charArr[i + 71], charArr[i + 72]);
                          }*//*
                          if ("DTP_ServiceDate".equals(charArr[i + 34].trim())) {
                              DTP_ServiceLevel.put(charArr[i + 35], charArr[i + 36]);
                              DTP_ServiceLevel.put(charArr[i + 37], charArr[i + 38]);
                              DTP_ServiceLevel.put(charArr[i + 39], charArr[i + 40]);

                              DTP_ServiceLevel.put(charArr[i + 42], charArr[i + 43]);
                              DTP_ServiceLevel.put(charArr[i + 44], charArr[i + 45]);
                              DTP_ServiceLevel.put(charArr[i + 46], charArr[i + 47]);

                              DTP_ServiceLevel.put(charArr[i + 49], charArr[i + 50]);
                              DTP_ServiceLevel.put(charArr[i + 51], charArr[i + 52]);
                              DTP_ServiceLevel.put(charArr[i + 53], charArr[i + 54]);

                              DTP_ServiceLevel.put(charArr[i + 56], charArr[i + 57]);
                              DTP_ServiceLevel.put(charArr[i + 58], charArr[i + 59]);
                              DTP_ServiceLevel.put(charArr[i + 60], charArr[i + 61]);

                          }
                          //diagonosis comman map
                          HI_ServiceLevel.put(charArr[i + 62], charArr[i + 63]);

                          // InstitutionalClaimCode
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 66], charArr[i + 67]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 68], charArr[i + 69]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 70], charArr[i + 71]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 72], charArr[i + 73]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 74], charArr[i + 75]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 76], charArr[i + 77]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 78], charArr[i + 79]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 80], charArr[i + 81]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 82], charArr[i + 83]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 84], charArr[i + 85]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 86], charArr[i + 87]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 88], charArr[i + 89]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 90], charArr[i + 91]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 92], charArr[i + 93]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 94], charArr[i + 95]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 96], charArr[i + 97]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 98], charArr[i + 99]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 100], charArr[i + 101]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 102], charArr[i + 103]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 104], charArr[i + 105]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 106], charArr[i + 107]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 108], charArr[i + 109]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 110], charArr[i + 111]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 112], charArr[i + 113]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 114], charArr[i + 115]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 116], charArr[i + 117]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 118], charArr[i + 119]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 120], charArr[i + 121]);

                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 123], charArr[i + 124]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 125], charArr[i + 126]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 127], charArr[i + 128]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 129], charArr[i + 130]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 131], charArr[i + 132]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 133], charArr[i + 134]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 135], charArr[i + 136]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 137], charArr[i + 138]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 139], charArr[i + 140]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 141], charArr[i + 142]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 143], charArr[i + 144]);
                          SV_InstitutionalClaimCode_ServiceLevel.put(charArr[i + 145], charArr[i + 146]);




                          //HealthCareServicesDelivery
                          HSD_HealthCareServicesDelivery_ServiceLevel.put(charArr[i + 148], charArr[i + 149]);
                          HSD_HealthCareServicesDelivery_ServiceLevel.put(charArr[i + 150], charArr[i + 151]);
                          HSD_HealthCareServicesDelivery_ServiceLevel.put(charArr[i + 152], charArr[i + 153]);
                          HSD_HealthCareServicesDelivery_ServiceLevel.put(charArr[i + 154], charArr[i + 155]);
                          HSD_HealthCareServicesDelivery_ServiceLevel.put(charArr[i + 156], charArr[i + 157]);
                          HSD_HealthCareServicesDelivery_ServiceLevel.put(charArr[i + 158], charArr[i + 159]);
                          HSD_HealthCareServicesDelivery_ServiceLevel.put(charArr[i + 160], charArr[i + 161]);
                          HSD_HealthCareServicesDelivery_ServiceLevel.put(charArr[i + 162], charArr[i + 163]);


                              PWK_ServiceLevel.put(charArr[i + 164], charArr[i + 165]);
                              MSG_MessageText_ServiceLevel.put(charArr[i + 166], charArr[i + 167]);
                              serviceLevelFlag=true;
                          }
                      if ( !(serviceLevelFlag) && "AAA_UtilizationManagementOrganization_UMO_RequestValidation".equals(charArr[i].trim()) && !("null".equals(charArr[i + 1].trim())) && !("Loop2000FA".equals(charArr[i].trim()))) {
                          System.out.println("Value of serl1: "+j);
                          if(!(insuranceFlag) && !(requesterFlag) && !(subscriberFlag) && !(dependentFlag) && !(patientEventrFlag) ) {
                              ServiceLevelRejectionMap.put(charArr[i + 47], charArr[i + 48]);
                              ServiceLevelRejectionMap.put(charArr[i +49], charArr[i + 50]);
                              ServiceLevelRejectionMap.put(charArr[i + 51], charArr[i + 52]);
                              ServiceLevelRejectionMap.put(charArr[i + 53], charArr[i + 54]);
                          }
                          else  if(!(insuranceFlag)|| !(requesterFlag) || !(subscriberFlag) || !(dependentFlag) || !(patientEventrFlag)) {
                              ServiceLevelRejectionMap.put(charArr[i + 11], charArr[i + 12]);
                              ServiceLevelRejectionMap.put(charArr[i + 13], charArr[i + 14]);
                              ServiceLevelRejectionMap.put(charArr[i + 15], charArr[i + 16]);
                              ServiceLevelRejectionMap.put(charArr[i + 17], charArr[i + 18]);
                          }
                          else
                          {
                              ServiceLevelRejectionMap.put(charArr[i + 2], charArr[i + 3]);
                              ServiceLevelRejectionMap.put(charArr[i + 4], charArr[i + 5]);
                              ServiceLevelRejectionMap.put(charArr[i + 6], charArr[i + 7]);
                              ServiceLevelRejectionMap.put(charArr[i + 8], charArr[i + 9]);
                          }

                          }

                      if ("Loop2010FA".equals(charArr[i].trim())&& !("Loop2010FB".equals(charArr[i].trim())) && !("AAA_UtilizationManagementOrganization_UMO_RequestValidation".equals(charArr[i].trim()))) {
                          if("NM1_ServiceProviderName".equals(charArr[i+2].trim())) {
                              NM1_ServiceProviderName.put(charArr[i + 3], charArr[i + 4]);
                              NM1_ServiceProviderName.put(charArr[i + 5], charArr[i + 6]);
                              NM1_ServiceProviderName.put(charArr[i + 7], charArr[i + 8]);
                              NM1_ServiceProviderName.put(charArr[i + 9], charArr[i + 10]);
                              NM1_ServiceProviderName.put(charArr[i + 11], charArr[i + 12]);
                              NM1_ServiceProviderName.put(charArr[i + 13], charArr[i + 14]);
                              NM1_ServiceProviderName.put(charArr[i + 15], charArr[i + 16]);
                              NM1_ServiceProviderName.put(charArr[i + 17], charArr[i + 18]);
                              NM1_ServiceProviderName.put(charArr[i + 19], charArr[i + 20]);
                              NM1_ServiceProviderName.put(charArr[i + 21], charArr[i + 22]);
                              NM1_ServiceProviderName.put(charArr[i + 23], charArr[i + 24]);
                              NM1_ServiceProviderName.put(charArr[i + 25], charArr[i + 26]);
                          }
                          if("REF_ServiceProviderSupplementalIdentification".equals(charArr[i+27].trim()))
                          {
                              REF_ServiceProviderSupplementalIdentification.put(charArr[i + 29], charArr[i + 30]);
                              REF_ServiceProviderSupplementalIdentification.put(charArr[i + 31], charArr[i + 32]);
                              REF_ServiceProviderSupplementalIdentification.put(charArr[i + 33], charArr[i + 34]);
                              REF_ServiceProviderSupplementalIdentification.put(charArr[i + 35], charArr[i + 36]);
                          }

                         //n3 ServiceProviderAddress
                          n3_ServiceProviderAddress.put(charArr[i + 39], charArr[i + 40]);
                          n3_ServiceProviderAddress.put(charArr[i + 41], charArr[i + 42]);

                          //N4_ServiceProviderCity_State_ZIPCode
                          N4_ServiceProviderCity_State_ZIPCode.put(charArr[i + 44], charArr[i + 45]);
                          N4_ServiceProviderCity_State_ZIPCode.put(charArr[i + 46], charArr[i + 47]);
                          N4_ServiceProviderCity_State_ZIPCode.put(charArr[i + 48], charArr[i + 49]);
                          N4_ServiceProviderCity_State_ZIPCode.put(charArr[i + 50], charArr[i + 51]);
                          N4_ServiceProviderCity_State_ZIPCode.put(charArr[i + 52], charArr[i + 53]);
                          N4_ServiceProviderCity_State_ZIPCode.put(charArr[i + 54], charArr[i + 55]);
                          N4_ServiceProviderCity_State_ZIPCode.put(charArr[i + 56], charArr[i + 57]);

                          if("PER_ServiceProviderContactInformation".equals(charArr[i+58].trim()))
                          {
                              PER_ServiceProviderContactInformation.put(charArr[i + 59], charArr[i + 60]);
                              PER_ServiceProviderContactInformation.put(charArr[i + 61], charArr[i + 62]);
                              PER_ServiceProviderContactInformation.put(charArr[i + 63], charArr[i + 64]);
                              PER_ServiceProviderContactInformation.put(charArr[i + 65], charArr[i + 66]);
                              PER_ServiceProviderContactInformation.put(charArr[i + 67], charArr[i + 68]);
                              PER_ServiceProviderContactInformation.put(charArr[i + 69], charArr[i + 70]);
                              PER_ServiceProviderContactInformation.put(charArr[i + 71], charArr[i + 72]);
                              PER_ServiceProviderContactInformation.put(charArr[i + 73], charArr[i + 74]);
                              PER_ServiceProviderContactInformation.put(charArr[i + 75], charArr[i + 76]);
                              PER_ServiceProviderContactInformation.put(charArr[i + 77], charArr[i + 78]);
                              PER_ServiceProviderContactInformation.put(charArr[i + 79], charArr[i + 80]);

                          }

                             preAuthorizationResponse.setServicingProviderFirstName(charArr[i + 10]);
                              preAuthorizationResponse.setServicingProviderLastName(charArr[i + 8]);
                              preAuthorizationResponse.setServicingProviderMiddleName(charArr[i + 12]);
                              String ServiceProviderFullName=charArr[i + 8]+" "+charArr[i + 10]+" "+charArr[i + 12]+" "+charArr[i + 14]+" "+charArr[i + 16];
                              preAuthorizationResponse.setServicingProviderFullName(ServiceProviderFullName);
                              preAuthorizationResponse.setServicingProviderSupplimentId(charArr[i + 32]);
                              preAuthorizationResponse.setServicingProviderDetailStatus("Approved");
                              preAuthorizationResponse.setServicingProviderAddress(charArr[i + 40]);
                              preAuthorizationResponse.setServicingProviderCity(charArr[i + 45]);
                              preAuthorizationResponse.setServicingProviderState(charArr[i + 47]);
                              preAuthorizationResponse.setServicingProviderCountryCode(charArr[i + 51]);
                              preAuthorizationResponse.setServicingProviderPostalCode(charArr[i + 49]);
                              preAuthorizationResponse.setServicingProviderType(preAuthorizationResponseRepository.findEntityIdentifierCode(charArr[i + 4]));
                              preAuthorizationResponse.setServicingProviderIdNumberType(preAuthorizationResponseRepository.findEntityTypeQualifierMaster(charArr[i + 6]));
                              preAuthorizationResponse.setServicingProviderIdentificationNumber(charArr[i + 32]);
                              preAuthorizationResponse.setServicingProviderIdentificationNumberType(preAuthorizationResponseRepository.findIdentificationCodeQualifier(charArr[i + 18]));
                              preAuthorizationResponse.setServicingProviderFollowUpActionDescription("");
                              preAuthorizationResponse.setServicingProviderRejectionReason("");
                              serviceProviderFlag=true;
                      }

                          if (!(serviceProviderFlag) && "AAA_UtilizationManagementOrganization_UMO_RequestValidation".equals(charArr[i].trim()) && !("null".equals(charArr[i + 1].trim())) && !("Loop2010FB".equals(charArr[i].trim()))) {
                              System.out.println("Value of serp1: "+j);
                              if(!(insuranceFlag) && !(requesterFlag) && !(subscriberFlag) && !(dependentFlag) && !(patientEventrFlag) && !(serviceLevelFlag)) {
                                  serviceproviderrejectionmap.put(charArr[i + 55], charArr[i + 56]);
                                  serviceproviderrejectionmap.put(charArr[i +57], charArr[i + 58]);
                                  serviceproviderrejectionmap.put(charArr[i + 59], charArr[i + 60]);
                                  serviceproviderrejectionmap.put(charArr[i + 61], charArr[i + 62]);
                                  preAuthorizationResponse.setServicingProviderDetailStatus("Rejected");
                                  preAuthorizationResponse.setServicingProviderFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 62]));
                                  preAuthorizationResponse.setServicingProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 60]));

                              }
                              else  if(!(insuranceFlag)|| !(requesterFlag) || !(subscriberFlag) || !(dependentFlag) || !(patientEventrFlag) || !(serviceLevelFlag)) {
                                  serviceproviderrejectionmap.put(charArr[i + 11], charArr[i + 12]);
                                  serviceproviderrejectionmap.put(charArr[i + 13], charArr[i + 14]);
                                  serviceproviderrejectionmap.put(charArr[i + 15], charArr[i + 16]);
                                  serviceproviderrejectionmap.put(charArr[i + 17], charArr[i + 18]);
                                  preAuthorizationResponse.setServicingProviderDetailStatus("Rejected");
                                  preAuthorizationResponse.setSubscriberFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 18]));
                                  preAuthorizationResponse.setServicingProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 16]));

                              }
                              else
                              {
                                  preAuthorizationResponse.setServicingProviderDetailStatus("Rejected");
                                  serviceproviderrejectionmap.put(charArr[i + 2], charArr[i + 3]);
                                  serviceproviderrejectionmap.put(charArr[i + 4], charArr[i + 5]);
                                  serviceproviderrejectionmap.put(charArr[i + 6], charArr[i + 7]);
                                  serviceproviderrejectionmap.put(charArr[i + 8], charArr[i + 9]);
                                  preAuthorizationResponse.setServicingProviderFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 9]));
                                  preAuthorizationResponse.setServicingProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 7]));

                              }

                          }


                      if ("HL_ServiceLevel".equals(charArr[i].trim()) && !("Loop2010FA".equals(charArr[i].trim())) && !("AAA_UtilizationManagementOrganization_UMO_RequestValidation".equals(charArr[i].trim()))) {

                          TRN_ServiceLevel2.put(charArr[i + 11], charArr[i + 12]);
                          TRN_ServiceLevel2.put(charArr[i + 13], charArr[i + 14]);
                          TRN_ServiceLevel2.put(charArr[i + 15], charArr[i + 16]);
                          TRN_ServiceLevel2.put(charArr[i + 17], charArr[i + 18]);
                          AAA_ServiceRequestValidation_ServiceLevel.put(charArr[i + 20], charArr[i + 21]);
                          UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.put(charArr[i + 22], charArr[i + 23]);
                          HCR_HealthCareServicesReview_ServiceLevel2.put(charArr[i + 24], charArr[i + 25]);
                          REF_AdministrativeReferenceNumber_ServiceLevel2.put(charArr[i + 27], charArr[i + 28]);

                          REF_AdministrativeReferenceNumber_ServiceLevel2.put(charArr[i + 29], charArr[i + 30]);

                          if ("DTP_ServiceDate".equals(charArr[i+32].trim())) {
                              DTP_ServiceLevel2.put(charArr[i + 33], charArr[i + 34]);
                              DTP_ServiceLevel2.put(charArr[i + 35], charArr[i + 36]);
                              DTP_ServiceLevel2.put(charArr[i + 37], charArr[i + 38]);

                              DTP_ServiceLevel2.put(charArr[i + 40], charArr[i + 41]);
                              DTP_ServiceLevel2.put(charArr[i + 42], charArr[i + 43]);
                              DTP_ServiceLevel2.put(charArr[i + 44], charArr[i + 45]);

                              DTP_ServiceLevel2.put(charArr[i + 47], charArr[i + 48]);
                              DTP_ServiceLevel2.put(charArr[i + 49], charArr[i + 50]);
                              DTP_ServiceLevel2.put(charArr[i + 51], charArr[i + 52]);

                              DTP_ServiceLevel2.put(charArr[i + 54], charArr[i + 55]);
                              DTP_ServiceLevel2.put(charArr[i + 56], charArr[i + 57]);
                              DTP_ServiceLevel2.put(charArr[i + 58], charArr[i + 59]);

                              //diagonosis comman map
                              HI_ServiceLevel2.put(charArr[i + 60], charArr[i + 61]);

                              // InstitutionalClaimCode
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 64], charArr[i + 65]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 66], charArr[i + 67]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 68], charArr[i + 69]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 70], charArr[i + 71]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 72], charArr[i + 73]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 74], charArr[i + 75]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 76], charArr[i + 77]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 78], charArr[i + 79]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 80], charArr[i + 81]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 82], charArr[i + 83]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 84], charArr[i + 85]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 86], charArr[i + 87]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 88], charArr[i + 89]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 90], charArr[i + 91]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 92], charArr[i + 93]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 94], charArr[i + 95]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 96], charArr[i + 97]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 98], charArr[i + 99]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 100], charArr[i + 101]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 102], charArr[i + 103]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 104], charArr[i + 105]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 106], charArr[i + 107]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 108], charArr[i + 109]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 110], charArr[i + 111]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 112], charArr[i + 113]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 114], charArr[i + 115]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 116], charArr[i + 117]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 118], charArr[i + 119]);

                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 121], charArr[i + 122]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 123], charArr[i + 124]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 125], charArr[i + 126]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 127], charArr[i + 128]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 129], charArr[i + 130]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 131], charArr[i + 132]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 133], charArr[i + 134]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 135], charArr[i + 136]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 137], charArr[i + 138]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 139], charArr[i + 140]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 141], charArr[i + 142]);
                              SV_InstitutionalClaimCode_ServiceLevel2.put(charArr[i + 143], charArr[i + 144]);

                          }

                          //HealthCareServicesDelivery
                          if ("HSD_HealthCareServicesDelivery".equals(charArr[i+145].trim())) {
                              HSD_HealthCareServicesDelivery_ServiceLevel2.put(charArr[i + 146], charArr[i + 147]);
                              HSD_HealthCareServicesDelivery_ServiceLevel2.put(charArr[i + 148], charArr[i + 149]);
                              HSD_HealthCareServicesDelivery_ServiceLevel2.put(charArr[i + 149], charArr[i + 150]);
                              HSD_HealthCareServicesDelivery_ServiceLevel2.put(charArr[i + 151], charArr[i + 152]);
                              HSD_HealthCareServicesDelivery_ServiceLevel2.put(charArr[i + 153], charArr[i + 154]);
                              HSD_HealthCareServicesDelivery_ServiceLevel2.put(charArr[i + 155], charArr[i + 157]);
                              HSD_HealthCareServicesDelivery_ServiceLevel2.put(charArr[i + 158], charArr[i + 159]);
                              HSD_HealthCareServicesDelivery_ServiceLevel2.put(charArr[i + 160], charArr[i + 161]);
                              PWK_ServiceLevel2.put(charArr[i + 162], charArr[i + 163]);
                              MSG_MessageText_ServiceLevel2.put(charArr[i + 164], charArr[i + 165]);
                          }
                          //CR1.put(charArr[i + 106], charArr[i + 107]);
                       *//*   if ("PWK_AdditionalServiceInformation".equals(charArr[i].trim())) {
                              PWK_ServiceLevel2.put(charArr[i + 2], charArr[i + 3]);
                              PWK_ServiceLevel2.put(charArr[i + 4], charArr[i + 5]);
                              PWK_ServiceLevel2.put(charArr[i + 6], charArr[i + 7]);
                              PWK_ServiceLevel2.put(charArr[i + 8], charArr[i + 9]);
                              PWK_ServiceLevel2.put(charArr[i + 10], charArr[i + 11]);
                              PWK_ServiceLevel2.put(charArr[i + 12], charArr[i + 13]);
                              PWK_ServiceLevel2.put(charArr[i + 14], charArr[i + 15]);
                              PWK_ServiceLevel2.put(charArr[i + 16], charArr[i + 17]);
                              PWK_ServiceLevel2.put(charArr[i + 18], charArr[i + 19]);
                              MSG_MessageText_ServiceLevel2.put(charArr[i + 21], charArr[i + 22]);
                          }*//*
                      serviceLevel2Flag=true;
                      }

                          if (!(serviceLevel2Flag) && "AAA_UtilizationManagementOrganization_UMO_RequestValidation".equals(charArr[i].trim()) && !("null".equals(charArr[i + 1].trim())) && !("Loop2010FA".equals(charArr[i].trim()))) {
                              System.out.println("Value of serl2: "+j);
                              if(!(insuranceFlag) && !(requesterFlag) && !(subscriberFlag) && !(dependentFlag) && !(patientEventrFlag) && !(serviceLevelFlag) && !(serviceProviderFlag)) {
                                  ServiceLevel2RejectionMap.put(charArr[i + 64], charArr[i + 65]);
                                  ServiceLevel2RejectionMap.put(charArr[i +66], charArr[i + 67]);
                                  ServiceLevel2RejectionMap.put(charArr[i + 68], charArr[i + 69]);
                                  ServiceLevel2RejectionMap.put(charArr[i + 70], charArr[i + 71]);

                                  if("HHA".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      homeHealthAideResponse.setHomeHealthAideDetailStatus("Rejected");
                                      homeHealthAideResponse.setHomeHealthAideRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 69]));
                                      homeHealthAideResponse.setHomeHealthAideRejectionReasonMSG(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 71]));
                                  }
                                  if("MSW".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      medicalSocialWorkResponse.setMedicalSocialWorkDetailStatus("Rejected");
                                      medicalSocialWorkResponse.setMedicalSocialWorkRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 69]));
                                      medicalSocialWorkResponse.setMedicalSocialWorkRejectionReasonMSG(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 71]));

                                  }
                                  if("PT".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      physicalTherapyResponse.setPhysicalTherapyDetailStatus("Rejected");
                                      physicalTherapyResponse.setPhysicalTherapyRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 69]));
                                      physicalTherapyResponse.setPhysicalTherapyRejectionReasonMSG(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 71]));

                                  }
                                  if("AD".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      occupationalTherapyResponse.setOccupationalTherapyDetailStatus("Rejected");
                                      occupationalTherapyResponse.setOccupationalTherapyRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 69]));
                                      occupationalTherapyResponse.setOccupationalTherapyRejectionReasonMSG(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 71]));

                                  }
                                  if("AG".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      skilledNursingResponse.setSkilledNursingDetailStatus("Rejected");
                                      skilledNursingResponse.setSkilledNursingRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 69]));
                                      skilledNursingResponse.setSkilledNursingRejectionReasonMSG(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 71]));

                                  }
                                  if("AF".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      speechPathologyResponse.setSpeechPathologyDetailStatus("Rejected");
                                      speechPathologyResponse.setSpeechPathologyRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 69]));
                                      speechPathologyResponse.setSpeechPathologyRejectionReasonMSG(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 71]));

                                  }
                                 // preAuthorizationResponse.setServicingProviderDetailStatus("Rejected");
                              }
                              else  if(!(insuranceFlag)|| !(requesterFlag) || !(subscriberFlag) || !(dependentFlag) || !(patientEventrFlag) || !(serviceLevelFlag) || !(serviceProviderFlag)) {
                                  ServiceLevel2RejectionMap.put(charArr[i + 11], charArr[i + 12]);
                                  ServiceLevel2RejectionMap.put(charArr[i + 13], charArr[i + 14]);
                                  ServiceLevel2RejectionMap.put(charArr[i + 15], charArr[i + 16]);
                                  ServiceLevel2RejectionMap.put(charArr[i + 17], charArr[i + 18]);

                                  if("HHA".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      homeHealthAideResponse.setHomeHealthAideDetailStatus("Rejected");
                                      homeHealthAideResponse.setHomeHealthAideRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 16]));
                                      homeHealthAideResponse.setHomeHealthAideRejectionReasonMSG(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 18]));
                                  }
                                  if("MSW".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      medicalSocialWorkResponse.setMedicalSocialWorkDetailStatus("Rejected");
                                      medicalSocialWorkResponse.setMedicalSocialWorkRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 16]));
                                      medicalSocialWorkResponse.setMedicalSocialWorkRejectionReasonMSG(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 18]));

                                  }
                                  if("PT".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      physicalTherapyResponse.setPhysicalTherapyDetailStatus("Rejected");
                                      physicalTherapyResponse.setPhysicalTherapyRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 16]));
                                      physicalTherapyResponse.setPhysicalTherapyRejectionReasonMSG(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 18]));

                                  }
                                  if("AD".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      occupationalTherapyResponse.setOccupationalTherapyDetailStatus("Rejected");
                                      occupationalTherapyResponse.setOccupationalTherapyRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 16]));
                                      occupationalTherapyResponse.setOccupationalTherapyRejectionReasonMSG(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 18]));

                                  }
                                  if("AG".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      skilledNursingResponse.setSkilledNursingDetailStatus("Rejected");
                                      skilledNursingResponse.setSkilledNursingRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 16]));
                                      skilledNursingResponse.setSkilledNursingRejectionReasonMSG(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 18]));

                                  }
                                  if("AF".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      speechPathologyResponse.setSpeechPathologyDetailStatus("Rejected");
                                      speechPathologyResponse.setSpeechPathologyRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 69]));
                                      speechPathologyResponse.setSpeechPathologyRejectionReasonMSG(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 71]));

                                  }
                              }
                              else
                              {
                                  ServiceLevel2RejectionMap.put(charArr[i + 2], charArr[i + 3]);
                                  ServiceLevel2RejectionMap.put(charArr[i + 4], charArr[i + 5]);
                                  ServiceLevel2RejectionMap.put(charArr[i + 6], charArr[i + 7]);
                                  ServiceLevel2RejectionMap.put(charArr[i + 8], charArr[i + 9]);

                                  if("HHA".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      homeHealthAideResponse.setHomeHealthAideDetailStatus("Rejected");
                                      homeHealthAideResponse.setHomeHealthAideRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 7]));
                                      homeHealthAideResponse.setHomeHealthAideRejectionReasonMSG(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 9]));
                                  }
                                  if("MSW".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      medicalSocialWorkResponse.setMedicalSocialWorkDetailStatus("Rejected");
                                      medicalSocialWorkResponse.setMedicalSocialWorkRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 7]));
                                      medicalSocialWorkResponse.setMedicalSocialWorkRejectionReasonMSG(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 9]));

                                  }
                                  if("PT".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      physicalTherapyResponse.setPhysicalTherapyDetailStatus("Rejected");
                                      physicalTherapyResponse.setPhysicalTherapyRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 7]));
                                      physicalTherapyResponse.setPhysicalTherapyRejectionReasonMSG(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 9]));

                                  }
                                  if("AD".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      occupationalTherapyResponse.setOccupationalTherapyDetailStatus("Rejected");
                                      occupationalTherapyResponse.setOccupationalTherapyRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 7]));
                                      occupationalTherapyResponse.setOccupationalTherapyRejectionReasonMSG(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 9]));

                                  }
                                  if("AG".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      skilledNursingResponse.setSkilledNursingDetailStatus("Rejected");
                                      skilledNursingResponse.setSkilledNursingRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 7]));
                                      skilledNursingResponse.setSkilledNursingRejectionReasonMSG(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 9]));

                                  }
                                  if("AF".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      speechPathologyResponse.setSpeechPathologyDetailStatus("Rejected");
                                      speechPathologyResponse.setSpeechPathologyRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 7]));
                                      speechPathologyResponse.setSpeechPathologyRejectionReasonMSG(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 9]));

                                  }
                              }

                          }
                      if ("Loop2010FA".equals(charArr[i].trim())&& !("Loop2010FB".equals(charArr[i].trim())) && !("AAA_UtilizationManagementOrganization_UMO_RequestValidation".equals(charArr[i].trim()))) {
                          if("NM1_ServiceProviderName".equals(charArr[i+2].trim())) {
                              NM1_ServiceProviderName2.put(charArr[i + 3], charArr[i + 4]);
                              NM1_ServiceProviderName2.put(charArr[i + 5], charArr[i + 6]);
                              NM1_ServiceProviderName2.put(charArr[i + 7], charArr[i + 8]);
                              NM1_ServiceProviderName2.put(charArr[i + 9], charArr[i + 10]);
                              NM1_ServiceProviderName2.put(charArr[i + 11], charArr[i + 12]);
                              NM1_ServiceProviderName2.put(charArr[i + 13], charArr[i + 14]);
                              NM1_ServiceProviderName2.put(charArr[i + 15], charArr[i + 16]);
                              NM1_ServiceProviderName2.put(charArr[i + 17], charArr[i + 18]);
                              NM1_ServiceProviderName2.put(charArr[i + 19], charArr[i + 20]);
                              NM1_ServiceProviderName2.put(charArr[i + 21], charArr[i + 22]);
                              NM1_ServiceProviderName2.put(charArr[i + 23], charArr[i + 24]);
                              NM1_ServiceProviderName2.put(charArr[i + 25], charArr[i + 26]);
                          }
                          if("REF_ServiceProviderSupplementalIdentification".equals(charArr[i+27].trim()))
                          {
                              REF_ServiceProviderSupplementalIdentification2.put(charArr[i + 29], charArr[i + 30]);
                              REF_ServiceProviderSupplementalIdentification2.put(charArr[i + 31], charArr[i + 32]);
                              REF_ServiceProviderSupplementalIdentification2.put(charArr[i + 33], charArr[i + 34]);
                              REF_ServiceProviderSupplementalIdentification2.put(charArr[i + 35], charArr[i + 36]);
                          }

                          //n3 ServiceProviderAddress
                          n3_ServiceProviderAddress2.put(charArr[i + 39], charArr[i + 40]);
                          n3_ServiceProviderAddress2.put(charArr[i + 41], charArr[i + 42]);

                          //N4_ServiceProviderCity_State_ZIPCode
                          N4_ServiceProviderCity_State_ZIPCode2.put(charArr[i + 44], charArr[i + 45]);
                          N4_ServiceProviderCity_State_ZIPCode2.put(charArr[i + 46], charArr[i + 47]);
                          N4_ServiceProviderCity_State_ZIPCode2.put(charArr[i + 48], charArr[i + 49]);
                          N4_ServiceProviderCity_State_ZIPCode2.put(charArr[i + 50], charArr[i + 51]);
                          N4_ServiceProviderCity_State_ZIPCode2.put(charArr[i + 52], charArr[i + 53]);
                          N4_ServiceProviderCity_State_ZIPCode2.put(charArr[i + 54], charArr[i + 55]);
                          N4_ServiceProviderCity_State_ZIPCode2.put(charArr[i + 56], charArr[i + 57]);

                          //PER_ServiceProvider
                          PER_ServiceProviderContactInformation2.put(charArr[i + 59], charArr[i + 60]);
                          PER_ServiceProviderContactInformation2.put(charArr[i + 61], charArr[i + 62]);
                          PER_ServiceProviderContactInformation2.put(charArr[i + 63], charArr[i + 64]);
                          PER_ServiceProviderContactInformation2.put(charArr[i + 65], charArr[i + 66]);
                          PER_ServiceProviderContactInformation2.put(charArr[i + 67], charArr[i + 68]);
                          PER_ServiceProviderContactInformation2.put(charArr[i + 69], charArr[i + 70]);
                          PER_ServiceProviderContactInformation2.put(charArr[i + 71], charArr[i + 72]);
                          PER_ServiceProviderContactInformation2.put(charArr[i + 73], charArr[i + 74]);
                          PER_ServiceProviderContactInformation2.put(charArr[i + 75], charArr[i + 76]);

                          //AAA_ServiceProvider
                          AAA_ServiceProvider.put(charArr[i + 77], charArr[i + 78]);

                          //PRV_ServiceProvider
                          PRV_ServiceProvider.put(charArr[i + 79], charArr[i + 80]);
                          serviceProvider2Flag=true;
                      }

                          if (!(serviceProvider2Flag) && "AAA_UtilizationManagementOrganization_UMO_RequestValidation".equals(charArr[i].trim()) && !("null".equals(charArr[i + 1].trim())) && !("Loop2010FB".equals(charArr[i].trim()))) {
                              System.out.println("Value of serp2: "+j);
                              if(!(insuranceFlag) && !(requesterFlag) && !(subscriberFlag) && !(dependentFlag) && !(patientEventrFlag) && !(serviceLevelFlag) && !(serviceProviderFlag) && !(serviceLevel2Flag)) {
                                  serviceprovider2rejectionmap.put(charArr[i + 73], charArr[i + 74]);
                                  serviceprovider2rejectionmap.put(charArr[i +75], charArr[i + 76]);
                                  serviceprovider2rejectionmap.put(charArr[i + 77], charArr[i + 78]);
                                  serviceprovider2rejectionmap.put(charArr[i + 79], charArr[i + 80]);
                                  if("HHA".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {

                                      homeHealthAideResponse.setHomeHealthAideProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 78]));
                                      homeHealthAideResponse.setHomeHealthAideProviderFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 80]));
                                  }
                                  if("MSW".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      medicalSocialWorkResponse.setMedicalSocialWorkProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 78]));
                                      medicalSocialWorkResponse.setMedicalSocialWorkProviderFollowUpActionDescription (preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 80]));

                                  }
                                  if("PT".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                     physicalTherapyResponse.setPhysicalTherapyProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 78]));
                                      physicalTherapyResponse.setPhysicalTherapyProviderFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 80]));

                                  }
                                  if("AD".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                     occupationalTherapyResponse.setOccupationalTherapyProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 78]));
                                      occupationalTherapyResponse.setOccupationalTherapyProviderFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 80]));

                                  }
                                  if("AG".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                    skilledNursingResponse.setSkilledNursingProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 78]));
                                    skilledNursingResponse.setSkilledNursingProviderFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 80]));

                                  }
                                  if("AF".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      speechPathologyResponse.setSpeechPathologyProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 78]));
                                      speechPathologyResponse.setSpeechPathologyProviderFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 80]));

                                  }
                              }
                              else  if(!(insuranceFlag)|| !(requesterFlag) || !(subscriberFlag) || !(dependentFlag) || !(patientEventrFlag) || !(serviceLevelFlag) || !(serviceProviderFlag) || !(serviceLevel2Flag)) {
                                  serviceprovider2rejectionmap.put(charArr[i + 11], charArr[i + 12]);
                                  serviceprovider2rejectionmap.put(charArr[i + 13], charArr[i + 14]);
                                  serviceprovider2rejectionmap.put(charArr[i + 15], charArr[i + 16]);
                                  serviceprovider2rejectionmap.put(charArr[i + 17], charArr[i + 18]);

                                  if("HHA".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {

                                      homeHealthAideResponse.setHomeHealthAideProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 16]));
                                      homeHealthAideResponse.setHomeHealthAideProviderFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 18]));
                                  }
                                  if("MSW".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      medicalSocialWorkResponse.setMedicalSocialWorkProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 16]));
                                      medicalSocialWorkResponse.setMedicalSocialWorkProviderFollowUpActionDescription (preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 18]));

                                  }
                                  if("PT".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      physicalTherapyResponse.setPhysicalTherapyProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 16]));
                                      physicalTherapyResponse.setPhysicalTherapyProviderFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 18]));

                                  }
                                  if("AD".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      occupationalTherapyResponse.setOccupationalTherapyProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 16]));
                                      occupationalTherapyResponse.setOccupationalTherapyProviderFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 18]));

                                  }
                                  if("AG".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      skilledNursingResponse.setSkilledNursingProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 16]));
                                      skilledNursingResponse.setSkilledNursingProviderFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 18]));

                                  }
                                  if("AF".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      speechPathologyResponse.setSpeechPathologyProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 16]));
                                      speechPathologyResponse.setSpeechPathologyProviderFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 18]));

                                  }
                              }
                              else
                              {
                                  serviceprovider2rejectionmap.put(charArr[i + 2], charArr[i + 3]);
                                  serviceprovider2rejectionmap.put(charArr[i + 4], charArr[i + 5]);
                                  serviceprovider2rejectionmap.put(charArr[i + 6], charArr[i + 7]);
                                  serviceprovider2rejectionmap.put(charArr[i + 8], charArr[i + 9]);


                                  if("HHA".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {

                                      homeHealthAideResponse.setHomeHealthAideProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 7]));
                                      homeHealthAideResponse.setHomeHealthAideProviderFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 9]));
                                  }
                                  if("MSW".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      medicalSocialWorkResponse.setMedicalSocialWorkProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 7]));
                                      medicalSocialWorkResponse.setMedicalSocialWorkProviderFollowUpActionDescription (preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 9]));

                                  }
                                  if("PT".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      physicalTherapyResponse.setPhysicalTherapyProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 7]));
                                      physicalTherapyResponse.setPhysicalTherapyProviderFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 9]));

                                  }
                                  if("AD".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      occupationalTherapyResponse.setOccupationalTherapyProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 7]));
                                      occupationalTherapyResponse.setOccupationalTherapyProviderFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 9]));

                                  }
                                  if("AG".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      skilledNursingResponse.setSkilledNursingProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 7]));
                                      skilledNursingResponse.setSkilledNursingProviderFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 9]));

                                  }
                                  if("AF".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
                                  {
                                      speechPathologyResponse.setSpeechPathologyProviderRejectionReason(preAuthorizationResponseRepository.findServiceTypeRejectionResion(charArr[i + 7]));
                                      speechPathologyResponse.setSpeechPathologyProviderFollowUpActionDescription(preAuthorizationResponseRepository.findServiceFollowUpAction(charArr[i + 9]));

                                  }
                              }

                          }

                      }




                          }
                      }

                  // System.out.println(gs.getGETrailers());

          *//*      System.out.println(l.getResult().getStatus());
              for(OperationDetail op:l.getResult().getDetails())
              {
                  System.out.println(op.getIndex()+" "+op.getTransactionIndex()+" "+op.getValue()+" "+op.getTransactionRef()+" "+op.getStatus()+" "+op.getMessage()+" "+op.getSegmentId());
              }

                 System.out.println(l.getIEATrailers());

                System.out.println(l.getTA1());*//*

        System.out.println("insurMap: "+insurMap);
        System.out.println("requesterMap: "+requesterMap);
        System.out.println("subscriberMap: "+subscriberMap);
        System.out.println("TRN_PATIENTEVENTTRACKINGNUMBER: "+TRN_PATIENTEVENTTRACKINGNUMBER);
        System.out.println("AAA_PATIENTEVENTREQUESTVALIDATION: "+AAA_PATIENTEVENTREQUESTVALIDATION);
        System.out.println("UM_HEALTHCARESERVICESREVIEWINFORMATION: "+UM_HEALTHCARESERVICESREVIEWINFORMATION);
        System.out.println("HCR_HealthCareServicesReview: "+HCR_HealthCareServicesReview);
        System.out.println("REF_AdministrativeReferenceNumber: "+REF_AdministrativeReferenceNumber);
        System.out.println("DTP_PATIENTEVENT: "+DTP_PATIENTEVENT);
        System.out.println("HI_PATIENTDiagonosis: "+HI_PATIENTDiagonosis);
        System.out.println("HSD_HealthCareServicesDelivery: "+HSD_HealthCareServicesDelivery);
        System.out.println("CL1_InstitutionalClaimCode: "+CL1_InstitutionalClaimCode);
        System.out.println("CR1: "+CR1);
        System.out.println("PWK_PATIENTEVENT: "+PWK_PATIENTEVENT);
        System.out.println("MSG_MessageText: "+MSG_MessageText);
        System.out.println("TRN_ServiceLevel: "+TRN_ServiceLevel);
        System.out.println("AAA_ServiceRequestValidation_ServiceLevel: "+AAA_ServiceRequestValidation_ServiceLevel);
        System.out.println("UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel: "+UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel);
        System.out.println("HCR_HealthCareServicesReview_ServiceLevel: "+HCR_HealthCareServicesReview_ServiceLevel);
        System.out.println("REF_AdministrativeReferenceNumber_ServiceLevel: "+REF_AdministrativeReferenceNumber_ServiceLevel);
        System.out.println("DTP_ServiceLevel: "+DTP_ServiceLevel);
        System.out.println("HI_ServiceLevel: "+HI_ServiceLevel);
        System.out.println("HSD_HealthCareServicesDelivery_ServiceLevel: "+HSD_HealthCareServicesDelivery_ServiceLevel);
        System.out.println("SV_InstitutionalClaimCode_ServiceLevel: "+SV_InstitutionalClaimCode_ServiceLevel);
        System.out.println("PWK_ServiceLevel: "+PWK_ServiceLevel);
        System.out.println("MSG_MessageText_ServiceLevel: "+MSG_MessageText_ServiceLevel);
        System.out.println("NM1_ServiceProviderName: "+NM1_ServiceProviderName);
        System.out.println("REF_ServiceProviderSupplementalIdentification: "+REF_ServiceProviderSupplementalIdentification);
        System.out.println("n3_ServiceProviderAddress: "+n3_ServiceProviderAddress);
        System.out.println("N4_ServiceProviderCity_State_ZIPCode: "+N4_ServiceProviderCity_State_ZIPCode);
        System.out.println("PER_ServiceProviderContactInformation: "+PER_ServiceProviderContactInformation);
        System.out.println("TRN_ServiceLevel2: "+TRN_ServiceLevel2);
        System.out.println("UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2: "+UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2);
        System.out.println("HCR_HealthCareServicesReview_ServiceLevel2: "+HCR_HealthCareServicesReview_ServiceLevel2);
        System.out.println("REF_AdministrativeReferenceNumber_ServiceLevel2: "+REF_AdministrativeReferenceNumber_ServiceLevel2);
        System.out.println("DTP_ServiceLevel2: "+DTP_ServiceLevel2);
        System.out.println("HI_ServiceLevel2: "+HI_ServiceLevel2);
        System.out.println("SV_InstitutionalClaimCode_ServiceLevel2: "+SV_InstitutionalClaimCode_ServiceLevel2);
        System.out.println("HSD_HealthCareServicesDelivery_ServiceLevel2: "+HSD_HealthCareServicesDelivery_ServiceLevel2);
        System.out.println("PWK_ServiceLevel2: "+PWK_ServiceLevel2);
        System.out.println("MSG_MessageText_ServiceLevel2: "+MSG_MessageText_ServiceLevel2);
        System.out.println("NM1_ServiceProviderName2: "+NM1_ServiceProviderName2);
        System.out.println("REF_ServiceProviderSupplementalIdentification2: "+REF_ServiceProviderSupplementalIdentification2);
        System.out.println("n3_ServiceProviderAddress2: "+n3_ServiceProviderAddress2);
        System.out.println("N4_ServiceProviderCity_State_ZIPCode2: "+N4_ServiceProviderCity_State_ZIPCode2);
        System.out.println("PER_ServiceProviderContactInformation2: "+PER_ServiceProviderContactInformation2);
        System.out.println("AAA_ServiceProvider: "+AAA_ServiceProvider);
        System.out.println("PRV_ServiceProvider: "+PRV_ServiceProvider);
        System.out.println("dependentmap: "+dependentmap);
        System.out.println("insurenceRejectionMap: "+insurenceRejectionMap);
        System.out.println("requesterRejectionMap: "+requesterRejectionMap);
        System.out.println("subscriberRejectionMap: "+subscriberRejectionMap);
        System.out.println("PATIENTEVENTRejectionMap: "+PATIENTEVENTRejectionMap);
        System.out.println("ServiceLevelRejectionMap: "+ServiceLevelRejectionMap);
        System.out.println("ServiceLevel2RejectionMap: "+ServiceLevel2RejectionMap);
        System.out.println("serviceproviderrejectionmap: "+serviceproviderrejectionmap);
        System.out.println("serviceprovider2rejectionmap: "+serviceprovider2rejectionmap);
        System.out.println("dependentRejectionmap: "+dependentRejectionmap);
        System.out.println("PreAuth Response updated successfully");




            //List<PreAuthDetail> list=preAuthService.listAll();
            //List<PreAuthDetail> preauthlist= preAuthRepository.findByMrnNumber(preAuthDemographics.getMrnNumber());


           *//*for(PreAuthDetail pre:preauthlist) {

               demographics.setMrnNumber(pre.getPreAuthDemographics().getMrnNumber());
               demographics.setFirstName(pre.getPreAuthDemographics().getFirstName());
               demographics.setLastName(pre.getPreAuthDemographics().getLastName());
               demographics.setMiddleName(pre.getPreAuthDemographics().getMiddleName());
               demographics.setSuffix(pre.getPreAuthDemographics().getSuffix());
               demographics.setDob(pre.getPreAuthDemographics().getDob());
               demographics.setGender(pre.getPreAuthDemographics().getGender());
               demographics.setSsn(pre.getPreAuthDemographics().getSsn());
               episode.setAdmissionDate(pre.getEpisode().getAdmissionDate());
               episode.setAdmissionStatus(pre.getEpisode().getAdmissionStatus());
               episode.setEpisodeType(pre.getEpisode().getEpisodeType());
               episode.setMrnNumber(pre.getEpisode().getMrnNumber());
               episode.setPreauthFormStatus("Response received");
               if(ackn.equals("")) {
                   episode.setPreAuthorisationStatus("Approved");
               }
               else
               {
                   episode.setPreAuthorisationStatus("Rejected");
               }
               episode.setPayorType(pre.getEpisode().getPayorType());
               episode.setFormSentDate(pre.getEpisode().getFormSentDate());
           }
           preAuthDetail.setMrnNumber(preAuthDemographics.getMrnNumber());
           preAuthDetail.setPreAuthDemographics(demographics);
           preAuthDetail.setEpisode(episode);
*//*
        //}
      *//*  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        PreAuthorizationResponse preAuthorizationResponse=new PreAuthorizationResponse();
        preAuthorizationResponse.setMemberDetailStatus(subscriberMap.get("AAA_SubscriberRequestValidation"));
        preAuthorizationResponse.setMemberfirstName(subscriberMap.get("ResponseContactFirstName_04"));
        preAuthorizationResponse.setMemberlastName(subscriberMap.get("ResponseContactLastorOrganizationName_03"));
        preAuthorizationResponse.setMembermiddleName(subscriberMap.get("ResponseContactMiddleName_05"));
        preAuthorizationResponse.setMembersuffix(subscriberMap.get("ResponseContactNameSuffix_07"));
        preAuthorizationResponse.setMemberPrefix(subscriberMap.get("NamePrefix_06"));
        Date d=formatter.parse("2020-03-23");
        preAuthorizationResponse.setMemberdob(d);
        preAuthorizationResponse.setMembergender("Male");//subscriberMap.get(" ")
        preAuthorizationResponse.setMemberRelationshipToSubscriber(subscriberMap.get("INS_SubscriberRelationship"));
        preAuthorizationResponse.setMrnNumber("P100");

        String orgName=insurMap.get("ResponseContactLastorOrganizationName_03")+" "+insurMap.get("ResponseContactFirstName_04")+" "+insurMap.get("ResponseContactMiddleName_05")+" "+insurMap.get("ResponseContactNameSuffix_07");
        preAuthorizationResponse.setOrganizationName(orgName);
        preAuthorizationResponse.setOrgDetailStatus(insurMap.get("AAA_UtilizationManagementOrganization_UMO_RequestValidation"));
        preAuthorizationResponse.setOrgFollowUpActionDescription("");
        String OrgIdentificationCode=preAuthorizationResponseRepository.findEntityIdentifierCode((insurMap.get("EntityIdentifierCode_01")));
        String OrgIdentificationCodeType=preAuthorizationResponseRepository.findIdentificationCodeQualifier(String.valueOf(insurMap.get("IdentificationCodeQualifier_08")));
        preAuthorizationResponse.setOrgIdentificationCode(OrgIdentificationCode);
        preAuthorizationResponse.setOrgIdentificationCodeType(OrgIdentificationCodeType);
        preAuthorizationResponse.setOrgRejectionReason(" ");
        preAuthorizationResponse.setOrgCommunicationExt("");
        preAuthorizationResponse.setOrgCommunicationTypeTelephone("");
        preAuthorizationResponse.setOrgCommunicationTypeEMail("");
        preAuthorizationResponse.setOrgCommunicationTypeFacsimile("");

        RequesterResponseInformation requesterResponseInformation=new RequesterResponseInformation();
        requesterResponseInformation.setReqProviderDetailStatus(requesterMap.get("AAA_RequesterRequestValidation"));
        requesterResponseInformation.setReqProviderFirstName(requesterMap.get("ResponseContactFirstName_04"));
        requesterResponseInformation.setReqProviderLastName(requesterMap.get("ResponseContactLastorOrganizationName_03"));
        requesterResponseInformation.setReqProviderMiddleName(requesterMap.get("ResponseContactMiddleName_05"));
        String reqproviderfullname=requesterMap.get("ResponseContactLastorOrganizationName_03")+" "+requesterMap.get("ResponseContactFirstName_04")+" "+requesterMap.get("ResponseContactMiddleName_05");
        requesterResponseInformation.setReqProviderFullName(reqproviderfullname);
        requesterResponseInformation.setReqProviderPrefix(" ");
        requesterResponseInformation.setReqProviderSuffix(" ");

        if(!("".equals(DTP_PATIENTEVENT.get("DTP_AdmissionDate")))) {
            Date AdmissionDate = formatter.parse("2020-01-22");
            requesterResponseInformation.setAdmitDate(AdmissionDate);
        }
        if(!("".equals(DTP_PATIENTEVENT.get("DTP_DischargeDate")))) {
            Date DischargeDate = formatter.parse("2020-02-22");
            requesterResponseInformation.setDischargeDate(DischargeDate);
        }

        Date ServiceDateFrom1 = formatter.parse("2020-03-12");
        Date ServiceDateto1 = formatter.parse("2020-03-30");


        requesterResponseInformation.setCertificationType(REF_AdministrativeReferenceNumber.get("REF_PreviousReviewAuthorizationNumber"));
        requesterResponseInformation.setServiceType("");
        requesterResponseInformation.setServiceDateFrom(ServiceDateFrom1);
        requesterResponseInformation.setServiceDateTo(ServiceDateto1);
        requesterResponseInformation.setRequestCategory("");
        requesterResponseInformation.setReqProviderSupplimentalId(requesterMap.get("MemberGrouporPolicyNumber_02"));
        requesterResponseInformation.setReqProviderIdentificationNumber(preAuthorizationResponseRepository.findEntityIdentifierCode(String.valueOf(requesterMap.get("EntityIdentifierCode_01"))));
        requesterResponseInformation.setReqProviderIdentificationNumberType(preAuthorizationResponseRepository.findIdentificationCodeQualifier(String.valueOf(requesterMap.get("IdentificationCodeQualifier_08"))));
        requesterResponseInformation.setReqProviderIdNumberType(preAuthorizationResponseRepository.findReferenceIdentificationQualifier(String.valueOf(requesterMap.get("ReferenceIdentificationQualifier_01"))));
        requesterResponseInformation.setReqProviderType(requesterMap.get("ReferenceIdentifier_04"));
        requesterResponseInformation.setReqProviderFollowUpActionDescription(requesterMap.get("Description_03"));
        requesterResponseInformation.setReqProviderRejectionReason("");
        preAuthorizationResponse.setRequesterResponseInformation(requesterResponseInformation);

        preAuthorizationResponse.setSubscriberDetailStatus(subscriberMap.get("AAA_SubscriberRequestValidation"));
        preAuthorizationResponse.setSubscriberFirstName(subscriberMap.get("ResponseContactFirstName_04"));
        preAuthorizationResponse.setSubscriberLastName(subscriberMap.get("ResponseContactLastorOrganizationName_03"));
        preAuthorizationResponse.setSubscriberMiddleName(subscriberMap.get("ResponseContactMiddleName_05"));
        preAuthorizationResponse.setSubscriberSuffix(subscriberMap.get("ResponseContactNameSuffix_07"));
        preAuthorizationResponse.setSubscriberPrefix(subscriberMap.get("NamePrefix_06"));
        preAuthorizationResponse.setSubscriberDob(d);
        preAuthorizationResponse.setSubscriberGender("Male");
        preAuthorizationResponse.setSubscriberIdentificationNumberType(preAuthorizationResponseRepository.findEntityIdentifierCode(String.valueOf(subscriberMap.get("EntityIdentifierCode_01"))));
        preAuthorizationResponse.setSubscriberSupplementalId(subscriberMap.get("REF_SubscriberSupplementalIdentification"));
        preAuthorizationResponse.setSubscriberFollowUpActionDescription(" ");
        preAuthorizationResponse.setSubscriberRejectionReason(" ");
        preAuthorizationResponse.setSubscriberRelToInsured("");
        preAuthorizationResponse.setSubscriberIdentificationCode("");
        preAuthorizationResponse.setSubscriberIdNumberType("");

        DependentDetailResponse dependentDetailResponse=new DependentDetailResponse();
        dependentDetailResponse.setDependentFirstName("");
        dependentDetailResponse.setDependentLastName("");
        dependentDetailResponse.setDependentMiddleName("");
        dependentDetailResponse.setDependentSuffix("");
        dependentDetailResponse.setDependentDob(d);
        dependentDetailResponse.setDependentGender("");
        dependentDetailResponse.setDependentReletionship("");
        dependentDetailResponse.setDependentPrefix("");
        dependentDetailResponse.setDependentSubscriberIdentificationCode("");
        dependentDetailResponse.setDependentSubscriberIdNumberType("");
        dependentDetailResponse.setDependentDetailStatus("");
        dependentDetailResponse.setDependentFollowUpActionDescription("");
        dependentDetailResponse.setDependentRejectionReaso("");
        dependentDetailResponse.setDependentSupplementalId("");
        dependentDetailResponse.setDependentIdentificationNumberType("");
        preAuthorizationResponse.setDependentDetailResponse(dependentDetailResponse);

        preAuthorizationResponse.setServicingProviderFirstName(NM1_ServiceProviderName.get("ResponseContactFirstName_04"));
        preAuthorizationResponse.setServicingProviderLastName(NM1_ServiceProviderName.get("ResponseContactLastorOrganizationName_03"));
        preAuthorizationResponse.setServicingProviderMiddleName(NM1_ServiceProviderName.get("ResponseContactMiddleName_05"));
        String ServiceProviderFullName=NM1_ServiceProviderName.get("ResponseContactLastorOrganizationName_03")+" "+NM1_ServiceProviderName.get("ResponseContactFirstName_04")+" "+NM1_ServiceProviderName.get("ResponseContactMiddleName_05");
        preAuthorizationResponse.setServicingProviderFullName(ServiceProviderFullName);
        preAuthorizationResponse.setServicingProviderSupplimentId(REF_ServiceProviderSupplementalIdentification.get("MemberGrouporPolicyNumber_02"));
        preAuthorizationResponse.setServicingProviderDetailStatus(AAA_ServiceProvider.get("AAA_ServiceProviderRequestValidation"));
        preAuthorizationResponse.setServicingProviderAddress(n3_ServiceProviderAddress.get("N3_ServiceProviderAddress"));
        preAuthorizationResponse.setServicingProviderCity(N4_ServiceProviderCity_State_ZIPCode.get("N4_ServiceProviderCity_State_ZIPCode"));
        preAuthorizationResponse.setServicingProviderState("");
        preAuthorizationResponse.setServicingProviderCountryCode("");
        preAuthorizationResponse.setServicingProviderPostalCode("");
        preAuthorizationResponse.setServicingProviderType(REF_ServiceProviderSupplementalIdentification.get("ReferenceIdentifier_04"));
        preAuthorizationResponse.setServicingProviderIdNumberType(REF_ServiceProviderSupplementalIdentification.get("ReferenceIdentificationQualifier_01"));
        preAuthorizationResponse.setServicingProviderIdentificationNumber(NM1_ServiceProviderName.get("EntityIdentifierCode_01"));
        preAuthorizationResponse.setServicingProviderIdentificationNumberType(NM1_ServiceProviderName.get("IdentificationCodeQualifier_08"));
        preAuthorizationResponse.setServicingProviderFollowUpActionDescription("");
        preAuthorizationResponse.setServicingProviderRejectionReason("");
        preAuthorizationResponse.setEnquiryId(TRN_PATIENTEVENTTRACKINGNUMBER.get("CurrentTransactionTraceNumber_02"));*//*
        *//*AuthorizationDetail authorizationDetail=new AuthorizationDetail();
        authorizationDetail.setPreAuthorizationStatus(HCR_HealthCareServicesReview.get("ActionCode_01"));
        if(!("".equals(DTP_PATIENTEVENT.get("DTP_EventDate")))) {
            Date EventDate = formatter.parse("2020-04-22");
            authorizationDetail.setProcessDateAndTime(EventDate);
        }
        authorizationDetail.setCertificationIdentificationNumber(REF_AdministrativeReferenceNumber.get("REF_PreviousReviewAuthorizationNumber"));
        authorizationDetail.setEnquiryId(TRN_PATIENTEVENTTRACKINGNUMBER.get("CurrentTransactionTraceNumber_02"));
        authorizationDetail.setEnquiryDetailStatus(AAA_PATIENTEVENTREQUESTVALIDATION.get("AAA_PatientEventRequestValidation"));
        if(!("".equals(DTP_PATIENTEVENT.get("DTP_AdmissionDate")))) {
            Date AdmissionDate = formatter.parse("2020-01-22");
            authorizationDetail.setAdmitDate(AdmissionDate);
        }
        if(!("".equals(DTP_PATIENTEVENT.get("DTP_DischargeDate")))) {
            Date DischargeDate = formatter.parse("2020-03-22");
            authorizationDetail.setDischargeDate(DischargeDate);
        }
        if(!("".equals(DTP_PATIENTEVENT.get("DTP_CertificationIssueDate")))) {
            Date CertificationIssueDate = formatter.parse("2020-01-21");
            authorizationDetail.setEffectiveDateFrom(CertificationIssueDate);
        }
        if(!("".equals(DTP_PATIENTEVENT.get("DTP_CertificationEffectiveDate")))) {
            Date CertificationEffectiveDate = formatter.parse("2020-01-25");
            authorizationDetail.setEffectiveDateTo(CertificationEffectiveDate);
        }
        if(!("".equals(DTP_PATIENTEVENT.get("DTP_CertificationExpirationDate")))) {
            Date CertificationExpirationDate = formatter.parse("2021-01-20");
            authorizationDetail.setExpirationeDateTo(CertificationExpirationDate);
        }
        Date ServiceDateFrom = formatter.parse("2020-03-12");
        Date ServiceDateto = formatter.parse("2020-03-30");
        authorizationDetail.setServiceDateFrom(ServiceDateFrom);
        authorizationDetail.setServiceDateTo(ServiceDateFrom);
        //int TotalUnitsApproved=Integer.parseInt(HSD_HealthCareServicesDelivery_ServiceLevel2.get("PeriodCount_06").trim());
       // int NoOfUnitsTobeUsed=Integer.parseInt(HSD_HealthCareServicesDelivery_ServiceLevel2.get("BenefitQuantity_02").trim());
        int TotalUnitsApproved=6;
        int NoOfUnitsTobeUsed=2;
        authorizationDetail.setTotalUnitsApproved(TotalUnitsApproved);
        authorizationDetail.setNoOfUnitsTobeUsed(NoOfUnitsTobeUsed);
        authorizationDetail.setRemainingUnits(TotalUnitsApproved-NoOfUnitsTobeUsed);
        //int TotalUnitsConsumed=Integer.parseInt(HSD_HealthCareServicesDelivery_ServiceLevel2.get("SampleSelectionModulus_04").trim());
        int TotalUnitsConsumed=4;
        authorizationDetail.setTotalUnitsConsumed(TotalUnitsConsumed);
        authorizationDetail.setUnitsForNoOfUnitsTobeUsed(preAuthorizationResponseRepository.findUnitOrBasisForMeasurementCodeMaster(String.valueOf(HSD_HealthCareServicesDelivery_ServiceLevel2.get("UnitorBasisforMeasurementCode_03"))));
        preAuthorizationResponse.setAuthorizationDetail(authorizationDetail);
*//*

        preAuthorizationResponse.setDependentDetailResponse(dependentDetailResponse);
        preAuthorizationResponse.setRequesterResponseInformation(requesterResponseInformation);
        preAuthorizationResponse.setAuthorizationDetail(authorizationDetail);
        if("HHA".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
        {

            homeHealthAideResponse.setHomeHealthAideCertificationAction(PWK_ServiceLevel2.get("ActionsIndicated_08"));
            homeHealthAideResponse.setHomeHealthAideCertificationType(preAuthorizationResponseRepository.findCertificationTypeCodeMaster(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("CertificationTypeCode_02")));
            homeHealthAideResponse.setHomeHealthAideDetailStatus("Approved");
            homeHealthAideResponse.setHomeHealthAideLevelOfService(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("LevelofServiceCode_06"));
            homeHealthAideResponse.setHomeHealthAidePoviderLastName(NM1_ServiceProviderName2.get("ResponseContactLastorOrganizationName_03"));
            homeHealthAideResponse.setHomeHealthAideProviderFirstName(NM1_ServiceProviderName2.get("ResponseContactFirstName_04"));
            homeHealthAideResponse.setHomeHealthAideProviderMiddleName(NM1_ServiceProviderName2.get("ResponseContactMiddleName_05"));
            String providerfullName=NM1_ServiceProviderName2.get("ResponseContactLastorOrganizationName_03")+" "+NM1_ServiceProviderName2.get("ResponseContactFirstName_04")+" "+NM1_ServiceProviderName2.get("ResponseContactMiddleName_05");
            homeHealthAideResponse.setHomeHealthAideProviderFullName(providerfullName);
            homeHealthAideResponse.setHomeHealthAideProviderAddress(n3_ServiceProviderAddress2.get("N3_ServiceProviderAddress"));
            homeHealthAideResponse.setHomeHealthAideProviderCity("");
            homeHealthAideResponse.setHomeHealthAideProviderState(N4_ServiceProviderCity_State_ZIPCode2.get("N4_ServiceProviderCity_State_ZIPCode"));
            homeHealthAideResponse.setHomeHealthAideProviderCountryCode("");
            homeHealthAideResponse.setHomeHealthAideProviderPostalCode("");
            homeHealthAideResponse.setHomeHealthAideProviderSupplimentalId(REF_ServiceProviderSupplementalIdentification2.get("MemberGrouporPolicyNumber_02"));
            homeHealthAideResponse.setHomeHealthAideProviderIdentificationNumber(REF_ServiceProviderSupplementalIdentification2.get("ReferenceIdentifier_04"));
            homeHealthAideResponse.setHomeHealthAideProviderIdentificationNumberType(preAuthorizationResponseRepository.findIdentificationCodeQualifier(PWK_ServiceLevel2.get("IdentificationCodeQualifier_05")));
            homeHealthAideResponse.setHomeHealthAideProviderIdNumberType(NM1_ServiceProviderName2.get("EntityIdentifierCode_01"));
            homeHealthAideResponse.setHomeHealthAideProviderType(preAuthorizationResponseRepository.findEntityTypeQualifierMaster(NM1_ServiceProviderName2.get("EntityTypeQualifier_02")));
            homeHealthAideResponse.setHomeHealthAideRequestCategory(PWK_ServiceLevel2.get("RequestCategoryCode_09"));
            homeHealthAideResponse.setHomeHealthAideServiceType(preAuthorizationResponseRepository.findServiceTypeCodeMaster(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")));
            homeHealthAideResponse.setHomeHealthAideVisit(HSD_HealthCareServicesDelivery_ServiceLevel2.get("BenefitQuantity_02").trim());
            homeHealthAideResponse.setHomeHealthAideUnit(HSD_HealthCareServicesDelivery_ServiceLevel2.get("SampleSelectionModulus_04").trim());
            homeHealthAideResponse.setHomeHealthAideProviderFollowUpActionDescription("");
            homeHealthAideResponse.setHomeHealthAideRejectionReason("");
            homeHealthAideResponse.setHomeHealthAideRejectionReasonMSG(MSG_MessageText_ServiceLevel2.get("MSG_MessageText"));
            homeHealthAideResponse.setHomeHealthAideProviderRejectionReason("");
            homeHealthAideResponse.setHomeHealthAideProviderPrefix("");
            homeHealthAideResponse.setHomeHealthAideProviderSuffix("");
            Date HomeHealthAideResponseServiceDateFrom=formatter.parse("2020-03-05");
            Date HealthAideResponseServiceDateTo=formatter.parse("2020-03-12");
            homeHealthAideResponse.setHomeHealthAideResponseServiceDateFrom(HomeHealthAideResponseServiceDateFrom);
            homeHealthAideResponse.setHomeHealthAideResponseServiceDateTo(HealthAideResponseServiceDateTo);
            homeHealthAideResponse.setMrnNumber(preAuthorizationResponse.getMrnNumber());
            homeHealthAideResponse.setHomeHealthAideRevenueCode(570);
            homeHealthAideResponse.setHomeHealthAideAuthorizationIdNo(REF_AdministrativeReferenceNumber.get("REF_PreviousReviewAuthorizationNumber"));
            Date HomeHealthAideEffectiveDateTo=formatter.parse("2020-03-05");
            Date HomeHealthAideEffectiveDateFrom=formatter.parse("2020-03-12");
            Date HomeHealthAideExpirationDate=formatter.parse("2021-03-12");
            homeHealthAideResponse.setHomeHealthAideEffectiveDateTo(HomeHealthAideEffectiveDateTo.toString());
            homeHealthAideResponse.setHomeHealthAideEffectiveDateFrom(HomeHealthAideEffectiveDateFrom.toString());
            homeHealthAideResponse.setHomeHealthAideExpirationDate(HomeHealthAideExpirationDate.toString());
            homeHealthAideResponse.setHomeHealthAideSelected(true);

        }
        if("AD".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
        {

            occupationalTherapyResponse.setOccupationalTherapyCertificationAction(PWK_ServiceLevel2.get("ActionsIndicated_08"));
            occupationalTherapyResponse.setOccupationalTherapyCertificationType(preAuthorizationResponseRepository.findCertificationTypeCodeMaster(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("CertificationTypeCode_02")));
            occupationalTherapyResponse.setOccupationalTherapyDetailStatus("Approved");
            occupationalTherapyResponse.setOccupationalTherapyLevelOfService(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("LevelofServiceCode_06"));
            occupationalTherapyResponse.setOccupationalTherapyProviderLastName(NM1_ServiceProviderName2.get("ResponseContactLastorOrganizationName_03"));
            occupationalTherapyResponse.setOccupationalTherapyProviderFirstName(NM1_ServiceProviderName2.get("ResponseContactFirstName_04"));
            occupationalTherapyResponse.setOccupationalTherapyProviderMiddleName(NM1_ServiceProviderName2.get("ResponseContactMiddleName_05"));
            String providerfullName=NM1_ServiceProviderName2.get("ResponseContactLastorOrganizationName_03")+" "+NM1_ServiceProviderName2.get("ResponseContactFirstName_04")+" "+NM1_ServiceProviderName2.get("ResponseContactMiddleName_05");
            occupationalTherapyResponse.setOccupationalTherapyProviderFullName(providerfullName);
            occupationalTherapyResponse.setOccupationalTherapyAddress(n3_ServiceProviderAddress2.get("N3_ServiceProviderAddress"));
            occupationalTherapyResponse.setOccupationalTherapyCity("");
            occupationalTherapyResponse.setOccupationalTherapyState(N4_ServiceProviderCity_State_ZIPCode2.get("N4_ServiceProviderCity_State_ZIPCode"));
            occupationalTherapyResponse.setOccupationalTherapyCountryCode("");
            occupationalTherapyResponse.setOccupationalTherapyPostalCode("");
            occupationalTherapyResponse.setOccupationalTherapyProviderSupplimentalId(REF_ServiceProviderSupplementalIdentification2.get("MemberGrouporPolicyNumber_02"));
            occupationalTherapyResponse.setOccupationalTherapyProviderIdentificationNumber(REF_ServiceProviderSupplementalIdentification2.get("ReferenceIdentifier_04"));
            occupationalTherapyResponse.setOccupationalProviderIdentificationNumberType(preAuthorizationResponseRepository.findIdentificationCodeQualifier(PWK_ServiceLevel2.get("IdentificationCodeQualifier_05")));
            occupationalTherapyResponse.setOccupationalTherapyProviderIdNumberType(NM1_ServiceProviderName2.get("EntityIdentifierCode_01"));
            occupationalTherapyResponse.setOccupationalTherapyProviderType(preAuthorizationResponseRepository.findEntityTypeQualifierMaster(NM1_ServiceProviderName2.get("EntityTypeQualifier_02")));
            occupationalTherapyResponse.setOccupationalTherapyRequestCategory(PWK_ServiceLevel2.get("RequestCategoryCode_09"));
            occupationalTherapyResponse.setOccupationalTherapyServiceType(preAuthorizationResponseRepository.findServiceTypeCodeMaster(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")));
            occupationalTherapyResponse.setOccupationalTherapyVisit(HSD_HealthCareServicesDelivery_ServiceLevel2.get("BenefitQuantity_02").trim());
            occupationalTherapyResponse.setOccupationalTherapyUnit(HSD_HealthCareServicesDelivery_ServiceLevel2.get("SampleSelectionModulus_04").trim());
            occupationalTherapyResponse.setOccupationalTherapyProviderFollowUpActionDescription("");
            occupationalTherapyResponse.setOccupationalTherapyRejectionReason("");
            occupationalTherapyResponse.setOccupationalTherapyRejectionReasonMSG(MSG_MessageText_ServiceLevel2.get("MSG_MessageText"));
            occupationalTherapyResponse.setOccupationalTherapyProviderRejectionReason("");
            occupationalTherapyResponse.setOccupationalTherapyProviderPrefix("");
            occupationalTherapyResponse.setOccupationalTherapyProviderSuffix("");
            Date HomeHealthAideResponseServiceDateFrom=formatter.parse("2020-02-08");
            Date HealthAideResponseServiceDateTo=formatter.parse("2020-02-12");
            occupationalTherapyResponse.setOccupationalTherapyResponseServiceDateFrom(HomeHealthAideResponseServiceDateFrom);
            occupationalTherapyResponse.setOccupationalTherapyResponseServiceDateTo(HealthAideResponseServiceDateTo);
            occupationalTherapyResponse.setMrnNumber(preAuthorizationResponse.getMrnNumber());
            occupationalTherapyResponse.setOccupationalTherapyRevenueCode(430);

            occupationalTherapyResponse.setOccupationalTherapyAuthorizationIdNo(REF_AdministrativeReferenceNumber.get("REF_PreviousReviewAuthorizationNumber"));
            Date HomeHealthAideEffectiveDateTo=formatter.parse("2020-03-05");
            Date HomeHealthAideEffectiveDateFrom=formatter.parse("2020-03-12");
            Date HomeHealthAideExpirationDate=formatter.parse("2021-03-12");
            occupationalTherapyResponse.setOccupationalTherapyEffectiveDateTo(HomeHealthAideEffectiveDateTo.toString());
            occupationalTherapyResponse.setOccupationalTherapyEffectiveDateFrom(HomeHealthAideEffectiveDateFrom.toString());
            occupationalTherapyResponse.setOccupationalTherapyExpirationDate(HomeHealthAideExpirationDate.toString());
            occupationalTherapyResponse.setOccupationalTherapySelected(true);

        }
        if("PT".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")))
        {

            physicalTherapyResponse.setPhysicalTherapyCertificationAction(PWK_ServiceLevel2.get("ActionsIndicated_08"));
            physicalTherapyResponse.setPhysicalTherapyCertificationType(preAuthorizationResponseRepository.findCertificationTypeCodeMaster(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("CertificationTypeCode_02")));
            physicalTherapyResponse.setPhysicalTherapyDetailStatus("Approved");
            physicalTherapyResponse.setPhysicalTherapyLevelOfService(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("LevelofServiceCode_06"));
            physicalTherapyResponse.setPhysicalTherapyPoviderLastName(NM1_ServiceProviderName2.get("ResponseContactLastorOrganizationName_03"));
            physicalTherapyResponse.setPhysicalTherapyProviderFirstName(NM1_ServiceProviderName2.get("ResponseContactFirstName_04"));
            physicalTherapyResponse.setPhysicalTherapyProviderMiddleName(NM1_ServiceProviderName2.get("ResponseContactMiddleName_05"));
            String providerfullName=NM1_ServiceProviderName2.get("ResponseContactLastorOrganizationName_03")+" "+NM1_ServiceProviderName2.get("ResponseContactFirstName_04")+" "+NM1_ServiceProviderName2.get("ResponseContactMiddleName_05");
            physicalTherapyResponse.setPhysicalTherapyProviderFullName(providerfullName);
            physicalTherapyResponse.setPhysicalTherapyProviderAddress(n3_ServiceProviderAddress2.get("N3_ServiceProviderAddress"));
            physicalTherapyResponse.setPhysicalTherapyProviderCity("");
            physicalTherapyResponse.setPhysicalTherapyProviderState(N4_ServiceProviderCity_State_ZIPCode2.get("N4_ServiceProviderCity_State_ZIPCode"));
            physicalTherapyResponse.setPhysicalTherapyProviderCountryCode("");
            physicalTherapyResponse.setPhysicalTherapyProviderPostalCode("");
            physicalTherapyResponse.setPhysicalTherapyProviderSupplimentalId(REF_ServiceProviderSupplementalIdentification2.get("MemberGrouporPolicyNumber_02"));
            physicalTherapyResponse.setPhysicalTherapyProviderIdentificationNumber(REF_ServiceProviderSupplementalIdentification2.get("ReferenceIdentifier_04"));
            physicalTherapyResponse.setPhysicalTherapyProviderIdentificationNumberType(preAuthorizationResponseRepository.findIdentificationCodeQualifier(PWK_ServiceLevel2.get("IdentificationCodeQualifier_05")));
            physicalTherapyResponse.setPhysicalTherapyProviderIdNumberType(NM1_ServiceProviderName2.get("EntityIdentifierCode_01"));
            physicalTherapyResponse.setPhysicalTherapyProviderType(preAuthorizationResponseRepository.findEntityTypeQualifierMaster(NM1_ServiceProviderName2.get("EntityTypeQualifier_02")));
            physicalTherapyResponse.setPhysicalTherapyRequestCategory(PWK_ServiceLevel2.get("RequestCategoryCode_09"));
            physicalTherapyResponse.setPhysicalTherapyServiceType(preAuthorizationResponseRepository.findServiceTypeCodeMaster(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")));
            physicalTherapyResponse.setPhysicalTherapyVisit(HSD_HealthCareServicesDelivery_ServiceLevel2.get("BenefitQuantity_02").trim());
            physicalTherapyResponse.setPhysicalTherapyUnit(HSD_HealthCareServicesDelivery_ServiceLevel2.get("SampleSelectionModulus_04").trim());
            physicalTherapyResponse.setPhysicalTherapyProviderFollowUpActionDescription("");
            physicalTherapyResponse.setPhysicalTherapyRejectionReason("");
            physicalTherapyResponse.setPhysicalTherapyRejectionReasonMSG(MSG_MessageText_ServiceLevel2.get("MSG_MessageText"));
            physicalTherapyResponse.setPhysicalTherapyProviderRejectionReason("");
            physicalTherapyResponse.setPhysicalTherapyProviderPrefix("");
            physicalTherapyResponse.setPhysicalTherapyProviderSuffix("");
            Date HomeHealthAideResponseServiceDateFrom=formatter.parse("2020-04-12");
            Date HealthAideResponseServiceDateTo=formatter.parse("2020-04-16");
            physicalTherapyResponse.setPhysicalTherapyResponseServiceDateFrom(HomeHealthAideResponseServiceDateFrom);
            physicalTherapyResponse.setPhysicalTherapyResponseServiceDateTo(HealthAideResponseServiceDateTo);
            physicalTherapyResponse.setMrnNumber(preAuthorizationResponse.getMrnNumber());
            physicalTherapyResponse.setPhysicalTherapyRevenueCode(420);

            physicalTherapyResponse.setPhysicalTherapyAuthorizationIdNo(REF_AdministrativeReferenceNumber.get("REF_PreviousReviewAuthorizationNumber"));
            Date HomeHealthAideEffectiveDateTo=formatter.parse("2020-03-05");
            Date HomeHealthAideEffectiveDateFrom=formatter.parse("2020-03-12");
            Date HomeHealthAideExpirationDate=formatter.parse("2021-03-12");
            physicalTherapyResponse.setPhysicalTherapyEffectiveDateTo(HomeHealthAideEffectiveDateTo.toString());
            physicalTherapyResponse.setPhysicalTherapyEffectiveDateFrom(HomeHealthAideEffectiveDateFrom.toString());
            physicalTherapyResponse.setPhysicalTherapyExpirationDate(HomeHealthAideExpirationDate.toString());
            physicalTherapyResponse.setPhysicalTherapySelected(true);

        }
        if("MSW".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03"))) {

            medicalSocialWorkResponse.setMedicalSocialWorkCertificationAction(PWK_ServiceLevel2.get("ActionsIndicated_08"));
            medicalSocialWorkResponse.setMedicalSocialWorkCertificationType(preAuthorizationResponseRepository.findCertificationTypeCodeMaster(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("CertificationTypeCode_02")));
            medicalSocialWorkResponse.setMedicalSocialWorkDetailStatus("Approved");
            medicalSocialWorkResponse.setMedicalSocialWorkLevelOfService(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("LevelofServiceCode_06"));
            medicalSocialWorkResponse.setMedicalSocialWorkPoviderLastName(NM1_ServiceProviderName2.get("ResponseContactLastorOrganizationName_03"));
            medicalSocialWorkResponse.setMedicalSocialWorkProviderFirstName(NM1_ServiceProviderName2.get("ResponseContactFirstName_04"));
            medicalSocialWorkResponse.setMedicalSocialWorkProviderMiddleName(NM1_ServiceProviderName2.get("ResponseContactMiddleName_05"));
            String providerfullName=NM1_ServiceProviderName2.get("ResponseContactLastorOrganizationName_03")+" "+NM1_ServiceProviderName2.get("ResponseContactFirstName_04")+" "+NM1_ServiceProviderName2.get("ResponseContactMiddleName_05");
            medicalSocialWorkResponse.setMedicalSocialWorkProviderFullName(providerfullName);
            medicalSocialWorkResponse.setMedicalSocialWorkProviderAddress(n3_ServiceProviderAddress2.get("N3_ServiceProviderAddress"));
            medicalSocialWorkResponse.setMedicalSocialWorkProviderCity("");
            medicalSocialWorkResponse.setMedicalSocialWorkProviderState(N4_ServiceProviderCity_State_ZIPCode2.get("N4_ServiceProviderCity_State_ZIPCode"));
            medicalSocialWorkResponse.setMedicalSocialWorkProviderCountryCode("");
            medicalSocialWorkResponse.setMedicalSocialWorkProviderPostalCode("");
            medicalSocialWorkResponse.setMedicalSocialWorkProviderSupplimentalId(REF_ServiceProviderSupplementalIdentification2.get("MemberGrouporPolicyNumber_02"));
            medicalSocialWorkResponse.setMedicalSocialWorkProviderIdentificationNumber(REF_ServiceProviderSupplementalIdentification2.get("ReferenceIdentifier_04"));
            medicalSocialWorkResponse.setMedicalSocialWorkProviderIdentificationNumberType(preAuthorizationResponseRepository.findIdentificationCodeQualifier(PWK_ServiceLevel2.get("IdentificationCodeQualifier_05")));
            medicalSocialWorkResponse.setMedicalSocialWorkProviderIdNumberType(NM1_ServiceProviderName2.get("EntityIdentifierCode_01"));
            medicalSocialWorkResponse.setMedicalSocialWorkProviderType(preAuthorizationResponseRepository.findEntityTypeQualifierMaster(NM1_ServiceProviderName2.get("EntityTypeQualifier_02")));
            medicalSocialWorkResponse.setMedicalSocialWorkRequestCategory(PWK_ServiceLevel2.get("RequestCategoryCode_09"));
            medicalSocialWorkResponse.setMedicalSocialWorkServiceType(preAuthorizationResponseRepository.findServiceTypeCodeMaster(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")));
            medicalSocialWorkResponse.setMedicalSocialWorkVisit(HSD_HealthCareServicesDelivery_ServiceLevel2.get("BenefitQuantity_02").trim());
            medicalSocialWorkResponse.setMedicalSocialWorkUnit(HSD_HealthCareServicesDelivery_ServiceLevel2.get("SampleSelectionModulus_04").trim());
            medicalSocialWorkResponse.setMedicalSocialWorkProviderFollowUpActionDescription("");
            medicalSocialWorkResponse.setMedicalSocialWorkRejectionReason("");
            medicalSocialWorkResponse.setMedicalSocialWorkRejectionReasonMSG(MSG_MessageText_ServiceLevel2.get("MSG_MessageText"));
            medicalSocialWorkResponse.setMedicalSocialWorkProviderRejectionReason("");
            medicalSocialWorkResponse.setMedicalSocialWorkProviderPrefix("");
            medicalSocialWorkResponse.setMedicalSocialWorkProviderSuffix("");
            Date HomeHealthAideResponseServiceDateFrom=formatter.parse("2020-04-15");
            Date HealthAideResponseServiceDateTo=formatter.parse("2020-04-21");
            medicalSocialWorkResponse.setMedicalSocialWorkResponseServiceDateFrom(HomeHealthAideResponseServiceDateFrom);
            medicalSocialWorkResponse.setMedicalSocialWorkResponseServiceDateTo(HealthAideResponseServiceDateTo);
            medicalSocialWorkResponse.setMrnNumber(preAuthorizationResponse.getMrnNumber());
            medicalSocialWorkResponse.setMedicalSocialWorkRevenueCode(560);

            medicalSocialWorkResponse.setMedicalSocialWorkAuthorizationIdNo(REF_AdministrativeReferenceNumber.get("REF_PreviousReviewAuthorizationNumber"));
            Date HomeHealthAideEffectiveDateTo=formatter.parse("2020-03-05");
            Date HomeHealthAideEffectiveDateFrom=formatter.parse("2020-03-12");
            Date HomeHealthAideExpirationDate=formatter.parse("2021-03-12");
            medicalSocialWorkResponse.setMedicalSocialWorkEffectiveDateTo(HomeHealthAideEffectiveDateTo.toString());
            medicalSocialWorkResponse.setMedicalSocialWorkEffectiveDateFrom(HomeHealthAideEffectiveDateFrom.toString());
            medicalSocialWorkResponse.setMedicalSocialWorkExpirationDate(HomeHealthAideExpirationDate.toString());
            medicalSocialWorkResponse.setMedicalSocialWorkSelected(true);

        }
        if("AF".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03"))) {

            speechPathologyResponse.setSpeechPathologyCertificationAction(PWK_ServiceLevel2.get("ActionsIndicated_08"));
            speechPathologyResponse.setSpeechPathologyCertificationType(preAuthorizationResponseRepository.findCertificationTypeCodeMaster(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("CertificationTypeCode_02")));
            speechPathologyResponse.setSpeechPathologyDetailStatus("Approved");
            speechPathologyResponse.setSpeechPathologyLevelOfService(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("LevelofServiceCode_06"));
            speechPathologyResponse.setSpeechPathologyPoviderLastName(NM1_ServiceProviderName2.get("ResponseContactLastorOrganizationName_03"));
            speechPathologyResponse.setSpeechPathologyProviderFirstName(NM1_ServiceProviderName2.get("ResponseContactFirstName_04"));
            speechPathologyResponse.setSpeechPathologyProviderMiddleName(NM1_ServiceProviderName2.get("ResponseContactMiddleName_05"));
            String providerfullName=NM1_ServiceProviderName2.get("ResponseContactLastorOrganizationName_03")+" "+NM1_ServiceProviderName2.get("ResponseContactFirstName_04")+" "+NM1_ServiceProviderName2.get("ResponseContactMiddleName_05");
            speechPathologyResponse.setSpeechPathologyProviderFullName(providerfullName);
            speechPathologyResponse.setSpeechPathologyProviderAddress(n3_ServiceProviderAddress2.get("N3_ServiceProviderAddress"));
            speechPathologyResponse.setSpeechPathologyProviderCity("");
            speechPathologyResponse.setSpeechPathologyProviderState(N4_ServiceProviderCity_State_ZIPCode2.get("N4_ServiceProviderCity_State_ZIPCode"));
            speechPathologyResponse.setSpeechPathologyProviderCountryCode("");
            speechPathologyResponse.setSpeechPathologyProviderPostalCode("");
            speechPathologyResponse.setSpeechPathologyProviderSupplimentalId(REF_ServiceProviderSupplementalIdentification2.get("MemberGrouporPolicyNumber_02"));
            speechPathologyResponse.setSpeechPathologyProviderIdentificationNumber(REF_ServiceProviderSupplementalIdentification2.get("ReferenceIdentifier_04"));
            speechPathologyResponse.setSpeechPathologyProviderIdentificationNumberType(preAuthorizationResponseRepository.findIdentificationCodeQualifier(PWK_ServiceLevel2.get("IdentificationCodeQualifier_05")));
            speechPathologyResponse.setSpeechPathologyProviderIdNumberType(NM1_ServiceProviderName2.get("EntityIdentifierCode_01"));
            speechPathologyResponse.setSpeechPathologyProviderType(preAuthorizationResponseRepository.findEntityTypeQualifierMaster(NM1_ServiceProviderName2.get("EntityTypeQualifier_02")));
            speechPathologyResponse.setSpeechPathologyRequestCategory(PWK_ServiceLevel2.get("RequestCategoryCode_09"));
            speechPathologyResponse.setSpeechPathologyServiceType(preAuthorizationResponseRepository.findServiceTypeCodeMaster(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")));
            speechPathologyResponse.setSpeechPathologyVisit(HSD_HealthCareServicesDelivery_ServiceLevel2.get("BenefitQuantity_02").trim());
            speechPathologyResponse.setSpeechPathologyUnit(HSD_HealthCareServicesDelivery_ServiceLevel2.get("SampleSelectionModulus_04").trim());
            speechPathologyResponse.setSpeechPathologyProviderFollowUpActionDescription("");
            speechPathologyResponse.setSpeechPathologyRejectionReason("");
            speechPathologyResponse.setSpeechPathologyRejectionReasonMSG(MSG_MessageText_ServiceLevel2.get("MSG_MessageText"));
            speechPathologyResponse.setSpeechPathologyProviderRejectionReason("");
            speechPathologyResponse.setSpeechPathologyProviderPrefix("");
            speechPathologyResponse.setSpeechPathologyProviderSuffix("");
            Date HomeHealthAideResponseServiceDateFrom=formatter.parse("2020-05-12");
            Date HealthAideResponseServiceDateTo=formatter.parse("2020-05-17");
            speechPathologyResponse.setSpeechPathologyResponseServiceDateFrom(HomeHealthAideResponseServiceDateFrom);
            speechPathologyResponse.setSpeechPathologyResponseServiceDateTo(HealthAideResponseServiceDateTo);
            speechPathologyResponse.setMrnNumber(preAuthorizationResponse.getMrnNumber());
            speechPathologyResponse.setSpeechPathologyRevenueCode(440);
            speechPathologyResponse.setspeechPathologyAuthorizationIdNo(REF_AdministrativeReferenceNumber.get("REF_PreviousReviewAuthorizationNumber"));
            Date HomeHealthAideEffectiveDateTo=formatter.parse("2020-03-05");
            Date HomeHealthAideEffectiveDateFrom=formatter.parse("2020-03-12");
            Date HomeHealthAideExpirationDate=formatter.parse("2021-03-12");
            speechPathologyResponse.setspeechPathologyEffectiveDateTo(HomeHealthAideEffectiveDateTo.toString());
            speechPathologyResponse.setspeechPathologyEffectiveDateFrom(HomeHealthAideEffectiveDateFrom.toString());
            speechPathologyResponse.setspeechPathologyExpirationDate(HomeHealthAideExpirationDate.toString());
            speechPathologyResponse.setspeechPathologySelected(true);

        }
        if("AG".equals(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03"))) {

            skilledNursingResponse.setSkilledNursingCertificationAction(PWK_ServiceLevel2.get("ActionsIndicated_08"));
            skilledNursingResponse.setSkilledNursingCertificationType(preAuthorizationResponseRepository.findCertificationTypeCodeMaster(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("CertificationTypeCode_02")));
            skilledNursingResponse.setSkilledNursingDetailStatus("Approved");
            skilledNursingResponse.setSkilledNursingLevelOfService(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("LevelofServiceCode_06"));
            skilledNursingResponse.setSkilledNursingPoviderLastName(NM1_ServiceProviderName2.get("ResponseContactLastorOrganizationName_03"));
            skilledNursingResponse.setSkilledNursingProviderFirstName(NM1_ServiceProviderName2.get("ResponseContactFirstName_04"));
            skilledNursingResponse.setSkilledNursingProviderMiddleName(NM1_ServiceProviderName2.get("ResponseContactMiddleName_05"));
            String providerfullName=NM1_ServiceProviderName2.get("ResponseContactLastorOrganizationName_03")+" "+NM1_ServiceProviderName2.get("ResponseContactFirstName_04")+" "+NM1_ServiceProviderName2.get("ResponseContactMiddleName_05");
            skilledNursingResponse.setSkilledNursingProviderFullName(providerfullName);
            skilledNursingResponse.setSkilledNursingProviderAddress(n3_ServiceProviderAddress2.get("N3_ServiceProviderAddress"));
            skilledNursingResponse.setSkilledNursingProviderCity("");
            skilledNursingResponse.setSkilledNursingProviderState(N4_ServiceProviderCity_State_ZIPCode2.get("N4_ServiceProviderCity_State_ZIPCode"));
            skilledNursingResponse.setSkilledNursingProviderCountryCode("");
            skilledNursingResponse.setSkilledNursingProviderPostalCode("");
            skilledNursingResponse.setSkilledNursingProviderSupplimentalId(REF_ServiceProviderSupplementalIdentification2.get("MemberGrouporPolicyNumber_02"));
            skilledNursingResponse.setSkilledNursingProviderIdentificationNumber(REF_ServiceProviderSupplementalIdentification2.get("ReferenceIdentifier_04"));
            skilledNursingResponse.setSkilledNursingProviderIdentificationNumberType(preAuthorizationResponseRepository.findIdentificationCodeQualifier(PWK_ServiceLevel2.get("IdentificationCodeQualifier_05")));
            skilledNursingResponse.setSkilledNursingProviderIdNumberType(NM1_ServiceProviderName2.get("EntityIdentifierCode_01"));
            skilledNursingResponse.setSkilledNursingProviderType(preAuthorizationResponseRepository.findEntityTypeQualifierMaster(NM1_ServiceProviderName2.get("EntityTypeQualifier_02")));
            skilledNursingResponse.setSkilledNursingRequestCategory(PWK_ServiceLevel2.get("RequestCategoryCode_09"));
            skilledNursingResponse.setSkilledNursingServiceType(preAuthorizationResponseRepository.findServiceTypeCodeMaster(UM_HEALTHCARESERVICESREVIEWINFORMATION_ServiceLevel2.get("ServiceTypeCode_03")));
            skilledNursingResponse.setSkilledNursingVisit(HSD_HealthCareServicesDelivery_ServiceLevel2.get("BenefitQuantity_02").trim());
            skilledNursingResponse.setSkilledNursingUnit(HSD_HealthCareServicesDelivery_ServiceLevel2.get("SampleSelectionModulus_04").trim());
            skilledNursingResponse.setSkilledNursingProviderFollowUpActionDescription("");
            skilledNursingResponse.setSkilledNursingRejectionReason("");
            skilledNursingResponse.setSkilledNursingRejectionReasonMSG(MSG_MessageText_ServiceLevel2.get("MSG_MessageText"));
            skilledNursingResponse.setSkilledNursingProviderRejectionReason("");
            skilledNursingResponse.setSkilledNursingProviderPrefix("");
            skilledNursingResponse.setSkilledNursingProviderSuffix("");
            Date HomeHealthAideResponseServiceDateFrom=formatter.parse("2020-05-18");
            Date HealthAideResponseServiceDateTo=formatter.parse("2020-05-22");
            skilledNursingResponse.setSkilledNursingResponseServiceDateFrom(HomeHealthAideResponseServiceDateFrom);
            skilledNursingResponse.setSkilledNursingResponseServiceDateTo(HealthAideResponseServiceDateTo);
            skilledNursingResponse.setMrnNumber("");
            skilledNursingResponse.setSkilledNursingRevenueCode(550);

            skilledNursingResponse.setSkilledNursingAuthorizationIdNo(REF_AdministrativeReferenceNumber.get("REF_PreviousReviewAuthorizationNumber"));
            Date HomeHealthAideEffectiveDateTo=formatter.parse("2020-03-05");
            Date HomeHealthAideEffectiveDateFrom=formatter.parse("2020-03-12");
            Date HomeHealthAideExpirationDate=formatter.parse("2021-03-12");
            skilledNursingResponse.setSkilledNursingEffectiveDateTo(HomeHealthAideEffectiveDateTo.toString());
            skilledNursingResponse.setSkilledNursingEffectiveDateFrom(HomeHealthAideEffectiveDateFrom.toString());
            skilledNursingResponse.setSkilledNursingExpirationDate(HomeHealthAideExpirationDate.toString());
            skilledNursingResponse.setSkilledNursingSelected(true);

        }
        preAuthorizationResponse.setHomeHealthAideResponse(homeHealthAideResponse);
        preAuthorizationResponse.setOccupationalTherapyResponse(occupationalTherapyResponse);
        preAuthorizationResponse.setPhysicalTherapyResponse(physicalTherapyResponse);
        preAuthorizationResponse.setMedicalSocialWorkResponse(medicalSocialWorkResponse);
        preAuthorizationResponse.setSpeechPathologyResponse(speechPathologyResponse);
        preAuthorizationResponse.setSkilledNursingResponse(skilledNursingResponse);
       // preAuthorizationResponseService.save(preAuthorizationResponse);
    }*/

   //@Scheduled(cron = "* */5 * * * ?")
   /* public void scheduleTaskWithCronExpressionForEligibility()
    {
        String eligibility = "";
        List<X12Interchange> list =new ArrayList<X12Interchange>();
         *//*   List<Demographics> demographicslist=service.listAll();

            for(Demographics demographics :demographicslist) {
                Optional<Demographics> optionalDemographics = Optional.ofNullable(demographics);
                File f1 = new File("Hipaa-5010-271-GenericResponse.txt");
                if (optionalDemographics.isPresent()) {
                    new SFTPFILE().downloadFile(f1, demographics.getMrnNumber() + "_" + f1.getName());
                    //  List<X12Interchange> list1 = x12.read(f1, false, false, " ", " ");
                    System.out.println("Insertion method called");
                }
            }*//*
        List<Demographics> demographicslist=service.listAll();
        File f1 = new File("Hipaa-5010-271-GenericResponse.txt");
        for(Demographics demographics :demographicslist) {
            Optional<Demographics> optionalDemographics = Optional.ofNullable(demographics);

            if (optionalDemographics.isPresent()) {
                new SFTPFILE().downloadFile(f1, demographics.getMrnNumber()+ "_" + f1.getName());
                ediDataElement272.setMrnNumber(demographics.getMrnNumber());
            }


        X12Controller x12=new X12Controller();
        try {
           // list = x12.read(f1, false, false, " ", " ");
        }
        catch(Throwable t)
        {
            t.printStackTrace();
        }
        String ackn="";
        String charArr[]=new String[]{};
        for(X12Interchange l:list) {

            //  System.out.println(l.getISA().getAcknowledgementRequested14()+" "+l.getISA().getSenderIDQualifier5()+" "+l.getISA().getSecurityInformationQualifier3()+" "+l.getISA().getSecurityInformation4()+" "+l.getISA().getReceiverIDQualifier7()+" "+l.getISA().getAuthorizationInformationQualifier1()+" "+l.getISA().getAuthorizationInformation2()+" "+l.getISA().getInterchangeControlNumber13());
            for (X12Group gs : l.getGroups()) {
                // System.out.println(gs.getGS().getCodeIdentifyingInformationType1()+" "+gs.getGS().getVersionAndRelease8()+" "+gs.getGS().getTransactionTypeCode7()+" "+gs.getGS().getTime5()+" "+gs.getGS().getSenderIDCode2()+" "+gs.getGS().getReceiverIDCode3()+" "+gs.getGS().getGroupControlNumber6()+" "+gs.getGS().getDate4()+" "+gs.getGS().getCodeIdentifyingInformationType1());
                *//*  for(Object ob:gs.getTransactions())

                 *//*

                List<Object> ls = gs.getTransactions();
                Object ss = ls.get(0);
                String st = ss.toString();
                System.out.println("All Value: " + st);
                // String charArr[]=st.split(",");split("[, ?.@]+");
                 charArr = st.split("[{,=}]+");
            }
        }
        for(int i=0;i<charArr.length;i++) {
            System.out.println(charArr[i]);


            if ("Loop2100A".equals(charArr[i].trim()) && !("Loop2000B".equals(charArr[i].trim()))) {
                if ("NM1_InformationSourceName".equals(charArr[i + 1].trim())) {

                }
            }

            if ("Loop2100B".equals(charArr[i].trim()) && !("Loop2000C".equals(charArr[i].trim()))) {
                if ("NM1_InformationReceiverName".equals(charArr[i + 1].trim())) {

                }
            }
            if ("Loop2000C".equals(charArr[i].trim()) && !("Loop2100C".equals(charArr[i].trim()))) {
                if ("HL_SubscriberLevel".equals(charArr[i + 2].trim())) {
                   ediDataElement272.setTraceTypeCode(charArr[i + 14]);
                }
            }

            if ("Loop2100C".equals(charArr[i].trim()) && !("Loop2110C".equals(charArr[i].trim()))) {
                if ("NM1_SubscriberName".equals(charArr[i + 1].trim())) {
                    ediDataElement272.setEntityIdentifierCode(charArr[i + 3]);
                    ediDataElement272.setEntityTypeQualifier(charArr[i + 5]);
                    ediDataElement272.setSubscriberLastName(charArr[i + 7]);
                    ediDataElement272.setSubscriberFirstName(charArr[i + 9]);
                    ediDataElement272.setSubscriberNameSuffix(charArr[i + 15]);
                    ediDataElement272.setIdentificationCodeQualifier(charArr[i + 17]);
                    ediDataElement272.setSubscriberAddressLine(charArr[i + 30]+" "+charArr[i + 32]);
                    ediDataElement272.setSubscriberCityName(charArr[i + 35]);
                    ediDataElement272.setSubscriberZipCode(charArr[i + 39]);
                    ediDataElement272.setSubscriberStateCode(charArr[i + 37]);
                    ediDataElement272.setSubscriberSupplementalIdentifier(charArr[i + 19]);
                    ediDataElement272.setSubscriberPrimaryIdentifier(charArr[i + 19]);
                    ediDataElement272.setServiceIDQualifier(charArr[i + 19]);
                    ediDataElement272.setReferenceIdentificationQualifier(charArr[i + 56]);
                    ediDataElement272.setDateTimeQualifier(charArr[i + 82]);
                    ediDataElement272.setBenefitDateTimePeriod(charArr[i + 86]);
                }
            }

            if ("Loop2110C".equals(charArr[i].trim()) && !("Loop2115C".equals(charArr[i].trim()))) {
                if ("EB_SubscriberEligibilityorBenefitInformation".equals(charArr[i + 2].trim())) {
                    if("1".equals(charArr[i + 4])) {
                        ediDataElement272.setEligibilityorBenefitInformation("eligible");
                        ediDataElement272.setInsuranceTypeCode(charArr[i + 19]);
                        ediDataElement272.setTimePeriodQualifier(charArr[i + 23]);
                        ediDataElement272.setBenefitAmount(charArr[i + 25]);
                        ediDataElement272.setQuantityQualifier(charArr[i + 29]);
                        ediDataElement272.setQuantity(charArr[i + 31]);
                        ediDataElement272.setCompositeMedicalProcedureIdentifier(charArr[i + 37]);
                        ediDataElement272.setProcedureModifier("");
                        ediDataElement272.setProcedureCode("");
                        ediDataElement272.setServiceTypeCode(charArr[i + 41]);
                        ediDataElement272.setFreeFormMessageText(charArr[i + 51]);
                    }
                    else
                    {
                        ediDataElement272.setEligibilityorBenefitInformation("Not Eligible");
                        ediDataElement272.setInsuranceTypeCode("");
                        ediDataElement272.setTimePeriodQualifier("");
                        ediDataElement272.setBenefitAmount("");
                        ediDataElement272.setQuantityQualifier("");
                        ediDataElement272.setQuantity("");
                        ediDataElement272.setCompositeMedicalProcedureIdentifier("");
                        ediDataElement272.setProcedureModifier("");
                        ediDataElement272.setProcedureCode("");
                        ediDataElement272.setServiceTypeCode("");
                        ediDataElement272.setFreeFormMessageText("");
                    }






                }
            }
            if ("Loop2120C".equals(charArr[i].trim()) && !("Loop2000D".equals(charArr[i].trim()))) {
                if ("NM1_SubscriberBenefitRelatedEntityName".equals(charArr[i + 2].trim())) {
                    ediDataElement272.setBenefitRelatedEntityIdentifier(charArr[i + 6]);
                    ediDataElement272.setBenefitRelatedEntityLast(charArr[i + 8]+" "+charArr[i + 10]+" "+charArr[i + 12]+" "+charArr[i + 16]+" "+charArr[i + 14]);
                    ediDataElement272.setBenefitRelatedEntityAddressLine(charArr[i + 29]+charArr[i + 31]);
                    ediDataElement272.setBenefitRelatedEntityCityName(charArr[i + 34]);
                    ediDataElement272.setBenefitRelatedEntityStateCode(charArr[i + 36]);
                    ediDataElement272.setBenefitRelatedEntityZipCode(charArr[i + 38]);



                }
            }
        }           // ediDataElement272 = new exampleParseX12FileOne().insertOpertion271(f1, ediDataElement271, "P100");
                    edi271Service.save(ediDataElement272);
                   List<EdiDataElement271> list2 = edi271Repository.findByMrnNumber(demographics.getMrnNumber());

                    for (EdiDataElement271 edi271 : list2) {
                        eligibility = edi271.getEligibilityorBenefitInformation();
                    }

                    PrimaryInsuranceDetail Priinsurancedetail = null;
                    SecondaryInsuranceDetail secondaryInsuranceDetail = null;
                    TertiaryInsuranceDetail tertiaryInsuranceDetail = null;

                    VerifyFlag flagList = verifyFlagService.get(demographics.getMrnNumber());

                    if (flagList.getPrimaryflag()) {
                        List<PrimaryInsuranceDetail> plist = primaryInsuranceDetailRepository.findByMrnNumber(demographics.getMrnNumber());
                        for (PrimaryInsuranceDetail pl : plist) {
                            Priinsurancedetail = new PrimaryInsuranceDetail(pl.getPolicyNumber(), pl.getGroup_name(), pl.getInsurancePlanName(), pl.getInsurancePlanType(), pl.getInsuranceAddress(), pl.getStartDate(), pl.getEndDate(), pl.getMrnNumber(), pl.getCity(), pl.getState(), pl.getZipcode(), pl.getInsuredlastName(), pl.getInsuredfirstName(), pl.getInsuredmiddleName(), pl.getInsureddob(), pl.getInsuredsex(), pl.getStatusVerifiedDate(), eligibility, pl.getEligibilityCheckSelected(), pl.getSsn(), pl.getMop(), pl.getPatientRelationInsured());

                        }
                        primaryInsuranceDetailRepository.save(Priinsurancedetail);
                    }
                    if (flagList.getSecondaryFlag()) {
                        List<SecondaryInsuranceDetail> slist = secondaryInsuranceDetailRepository.findByMrnNumber(demographics.getMrnNumber());
                        for (SecondaryInsuranceDetail sl : slist) {
                            secondaryInsuranceDetail = new SecondaryInsuranceDetail(sl.getPolicyNumber(), sl.getGroup_name(), sl.getInsurancePlanName(), sl.getInsurancePlanType(), sl.getInsuranceAddress(), sl.getStartDate(), sl.getEndDate(), sl.getMrnNumber(), sl.getCity(), sl.getState(), sl.getZipcode(), sl.getInsuredlastName(), sl.getInsuredfirstName(), sl.getInsuredmiddleName(), sl.getInsureddob(), sl.getInsuredsex(), sl.getStatusVerifiedDate(), eligibility, sl.getEligibilityCheckSelected(), sl.getSsn(), sl.getMop(), sl.getPatientRelationInsured());

                        }
                        secondaryInsuranceDetailRepository.save(secondaryInsuranceDetail);
                    }
                    if (flagList.getTertiaryFlag()) {
                        List<TertiaryInsuranceDetail> tlist = tertiaryInsuranceDetailRepository.findByMrnNumber(demographics.getMrnNumber());
                        for (TertiaryInsuranceDetail tl : tlist) {
                            tertiaryInsuranceDetail = new TertiaryInsuranceDetail(tl.getPolicyNumber(), tl.getGroup_name(), tl.getInsurancePlanName(), tl.getInsurancePlanType(), tl.getInsuranceAddress(), tl.getStartDate(), tl.getEndDate(), tl.getMrnNumber(), tl.getCity(), tl.getState(), tl.getZipcode(), tl.getInsuredlastName(), tl.getInsuredfirstName(), tl.getInsuredmiddleName(), tl.getInsureddob(), tl.getInsuredsex(), tl.getStatusVerifiedDate(), eligibility, tl.getEligibilityCheckSelected(), tl.getSsn(), tl.getMop(), tl.getPatientRelationInsured());

                        }
                        tertiaryInsuranceDetailRepository.save(tertiaryInsuranceDetail);
                    }
            System.out.println("Eligibility Response updated successfully");
                }
            }


*/

}
