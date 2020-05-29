package com.edination.api.preAuthorisation.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PreAuthorizationResponse")
public class PreAuthorizationResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String enquiryId;
    private Date processDateAndTime;
    private Date serviceDateFrom;
    private Date serviceDateTo;
    private Date effectiveDateTo;
    private Date effectiveDateFrom;
    private Date expirationeDateTo;
    private Date admitDate;
    private Date dischargeDate;
    private String certificationIdentificationNumber;
    private String preAuthorizationStatus;
    private String enquiryDetailStatus;

    private String mrnNumber;
    private String memberfirstName;
    private String memberlastName;
    private String membermiddleName;
    private String membersuffix;
    private String membergender;
    private Date memberdob;
    private String memberPrefix;
    private String memberRelationshipToSubscriber;
    private String memberDetailStatus;

    private String  organizationName;
    private String orgIdentificationCode;
    private String orgIdentificationCodeType;
    private String orgRejectionReason;
    private String orgFollowUpActionDescription;
    private String orgDetailStatus;

    private String reqProviderFullName;
    private String reqProviderFirstName;
    private String reqProviderLastName;
    //private String reqProviderMiddleName;
    private String reqProviderType;
    private String reqProviderIdentificationNumber;
    private String reqProviderIdentificationNumberType;
    private String reqProviderSupplimentalId;
    private String reqProviderIdNumberType;
    private String reqProviderRejectionReason;
    private String reqProviderFollowUpActionDescription;
    private String reqProviderDetailStatus;

    private String subscriberFirstName;
    private String subscriberLastName;
    private String  subscriberMiddleName;
    private String subscriberSuffix;
    private String subscriberGender;
    private Date subscriberDob;
    private String subscriberPrefix;
    private String subscriberSupplementalId;
    private String subscriberIdentificationNumberType;
    private String subscriberRejectionReason;
    private String subscriberFollowUpActionDescription;
    private String subscriberDetailStatus;

    private String dependentFirstName;
    private String dependentLastName;
    private String dependentMiddleName;
    private String dependentSuffix;
    private String dependentGender;
    private Date dependentDob;
   // private String dependentPrefix;
    private String dependentReletionship;

    private String servicingProviderFullName;
    private String servicingProviderFirstName;
    private String servicingProviderLastName;
    //private String servicingProviderMiddleName;
    private String servicingProviderType;
    private String servicingProviderAddress;
    private String servicingProviderCity;
    private String servicingProviderState;
    private String servicingProviderPostalCode;
    private String servicingProviderCountryCode;
    private String servicingProviderIdentificationNumber;
    private String servicingProviderIdentificationNumberType;
    private String servicingProviderSupplimentId;
    private String servicingProviderIdNumberType;
    private String servicingProviderRejectionReason;
    private String servicingProviderFollowUpActionDescription;
    private String servicingProviderDetailStatus;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "HHAId")
    private HomeHealthAideResponse homeHealthAideResponse;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "OTId")
    private OccupationalTherapyResponse occupationalTherapyResponse;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "MSWId")
    private MedicalSocialWorkResponse medicalSocialWorkResponse;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "PTId")
    private PhysicalTherapyResponse physicalTherapyResponse;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SNId")
    private SkilledNursingResponse skilledNursingResponse;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STId")
    private SpeechPathologyResponse speechPathologyResponse;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "authorizationId")
    private AuthorizationDetail authorizationDetail;

    public PreAuthorizationResponse()
    {
    }

    public PreAuthorizationResponse(String enquiryId, Date processDateAndTime, Date serviceDateFrom, Date serviceDateTo, Date effectiveDateTo, Date effectiveDateFrom, Date expirationeDateTo, Date admitDate, Date dischargeDate, String certificationIdentificationNumber, String preAuthorizationStatus, String enquiryDetailStatus, String mrnNumber, String memberfirstName, String memberlastName, String membermiddleName, String membersuffix, String membergender, Date memberdob, String memberPrefix, String memberRelationshipToSubscriber, String memberDetailStatus, String organizationName, String orgIdentificationCode, String orgIdentificationCodeType, String orgRejectionReason, String orgFollowUpActionDescription, String orgDetailStatus, String reqProviderFullName, String reqProviderFirstName, String reqProviderLastName,  String reqProviderType, String reqProviderIdentificationNumber, String reqProviderIdentificationNumberType, String reqProviderSupplimentalId, String reqProviderIdNumberType, String reqProviderRejectionReason, String reqProviderFollowUpActionDescription, String reqProviderDetailStatus, String subscriberFirstName, String subscriberLastName, String subscriberMiddleName, String subscriberSuffix, String subscriberGender, Date subscriberDob, String subscriberPrefix, String subscriberSupplementalId, String subscriberIdentificationNumberType, String subscriberRejectionReason, String subscriberFollowUpActionDescription, String subscriberDetailStatus, String dependentFirstName, String dependentLastName, String dependentMiddleName, String dependentSuffix, String dependentGender, Date dependentDob, String dependentReletionship, String servicingProviderFullName, String servicingProviderFirstName, String servicingProviderLastName, String servicingProviderType, String servicingProviderAddress, String servicingProviderCity, String servicingProviderState, String servicingProviderPostalCode, String servicingProviderCountryCode, String servicingProviderIdentificationNumber, String servicingProviderIdentificationNumberType, String servicingProviderSupplimentId, String servicingProviderIdNumberType, String servicingProviderRejectionReason, String servicingProviderFollowUpActionDescription, String servicingProviderDetailStatus, HomeHealthAideResponse homeHealthAideResponse, OccupationalTherapyResponse occupationalTherapyResponse, MedicalSocialWorkResponse medicalSocialWorkResponse, PhysicalTherapyResponse physicalTherapyResponse, SkilledNursingResponse skilledNursingResponse, SpeechPathologyResponse speechPathologyResponse) {

        this.enquiryId = enquiryId;
        this.processDateAndTime = processDateAndTime;
        this.serviceDateFrom = serviceDateFrom;
        this.serviceDateTo = serviceDateTo;
        this.effectiveDateTo = effectiveDateTo;
        this.effectiveDateFrom = effectiveDateFrom;
        this.expirationeDateTo = expirationeDateTo;
        this.admitDate = admitDate;
        this.dischargeDate = dischargeDate;
        this.certificationIdentificationNumber = certificationIdentificationNumber;
        this.preAuthorizationStatus = preAuthorizationStatus;
        this.enquiryDetailStatus = enquiryDetailStatus;
        this.mrnNumber = mrnNumber;
        this.memberfirstName = memberfirstName;
        this.memberlastName = memberlastName;
        this.membermiddleName = membermiddleName;
        this.membersuffix = membersuffix;
        this.membergender = membergender;
        this.memberdob = memberdob;
        this.memberPrefix = memberPrefix;
        this.memberRelationshipToSubscriber = memberRelationshipToSubscriber;
        this.memberDetailStatus = memberDetailStatus;
        this.organizationName = organizationName;
        this.orgIdentificationCode = orgIdentificationCode;
        this.orgIdentificationCodeType = orgIdentificationCodeType;
        this.orgRejectionReason = orgRejectionReason;
        this.orgFollowUpActionDescription = orgFollowUpActionDescription;
        this.orgDetailStatus = orgDetailStatus;
        this.reqProviderFullName = reqProviderFullName;
        this.reqProviderFirstName = reqProviderFirstName;
        this.reqProviderLastName = reqProviderLastName;
        this.reqProviderType = reqProviderType;
        this.reqProviderIdentificationNumber = reqProviderIdentificationNumber;
        this.reqProviderIdentificationNumberType = reqProviderIdentificationNumberType;
        this.reqProviderSupplimentalId = reqProviderSupplimentalId;
        this.reqProviderIdNumberType = reqProviderIdNumberType;
        this.reqProviderRejectionReason = reqProviderRejectionReason;
        this.reqProviderFollowUpActionDescription = reqProviderFollowUpActionDescription;
        this.reqProviderDetailStatus = reqProviderDetailStatus;
        this.subscriberFirstName = subscriberFirstName;
        this.subscriberLastName = subscriberLastName;
        this.subscriberMiddleName = subscriberMiddleName;
        this.subscriberSuffix = subscriberSuffix;
        this.subscriberGender = subscriberGender;
        this.subscriberDob = subscriberDob;
        this.subscriberPrefix = subscriberPrefix;
        this.subscriberSupplementalId = subscriberSupplementalId;
        this.subscriberIdentificationNumberType = subscriberIdentificationNumberType;
        this.subscriberRejectionReason = subscriberRejectionReason;
        this.subscriberFollowUpActionDescription = subscriberFollowUpActionDescription;
        this.subscriberDetailStatus = subscriberDetailStatus;
        this.dependentFirstName = dependentFirstName;
        this.dependentLastName = dependentLastName;
        this.dependentMiddleName = dependentMiddleName;
        this.dependentSuffix = dependentSuffix;
        this.dependentGender = dependentGender;
        this.dependentDob = dependentDob;
        this.dependentReletionship = dependentReletionship;
        this.servicingProviderFullName = servicingProviderFullName;
        this.servicingProviderFirstName = servicingProviderFirstName;
        this.servicingProviderLastName = servicingProviderLastName;
        this.servicingProviderType = servicingProviderType;
        this.servicingProviderAddress = servicingProviderAddress;
        this.servicingProviderCity = servicingProviderCity;
        this.servicingProviderState = servicingProviderState;
        this.servicingProviderPostalCode = servicingProviderPostalCode;
        this.servicingProviderCountryCode = servicingProviderCountryCode;
        this.servicingProviderIdentificationNumber = servicingProviderIdentificationNumber;
        this.servicingProviderIdentificationNumberType = servicingProviderIdentificationNumberType;
        this.servicingProviderSupplimentId = servicingProviderSupplimentId;
        this.servicingProviderIdNumberType = servicingProviderIdNumberType;
        this.servicingProviderRejectionReason = servicingProviderRejectionReason;
        this.servicingProviderFollowUpActionDescription = servicingProviderFollowUpActionDescription;
        this.servicingProviderDetailStatus = servicingProviderDetailStatus;
        this.homeHealthAideResponse = homeHealthAideResponse;
        this.occupationalTherapyResponse = occupationalTherapyResponse;
        this.medicalSocialWorkResponse = medicalSocialWorkResponse;
        this.physicalTherapyResponse = physicalTherapyResponse;
        this.skilledNursingResponse = skilledNursingResponse;
        this.speechPathologyResponse = speechPathologyResponse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(String enquiryId) {
        this.enquiryId = enquiryId;
    }

    public Date getProcessDateAndTime() {
        return processDateAndTime;
    }

    public void setProcessDateAndTime(Date processDateAndTime) {
        this.processDateAndTime = processDateAndTime;
    }

    public Date getServiceDateFrom() {
        return serviceDateFrom;
    }

    public void setServiceDateFrom(Date serviceDateFrom) {
        this.serviceDateFrom = serviceDateFrom;
    }

    public Date getServiceDateTo() {
        return serviceDateTo;
    }

    public void setServiceDateTo(Date serviceDateTo) {
        this.serviceDateTo = serviceDateTo;
    }

    public Date getEffectiveDateTo() {
        return effectiveDateTo;
    }

    public void setEffectiveDateTo(Date effectiveDateTo) {
        this.effectiveDateTo = effectiveDateTo;
    }

    public Date getEffectiveDateFrom() {
        return effectiveDateFrom;
    }

    public void setEffectiveDateFrom(Date effectiveDateFrom) {
        this.effectiveDateFrom = effectiveDateFrom;
    }

    public Date getExpirationeDateTo() {
        return expirationeDateTo;
    }

    public void setExpirationeDateTo(Date expirationeDateTo) {
        this.expirationeDateTo = expirationeDateTo;
    }

    public Date getAdmitDate() {
        return admitDate;
    }

    public void setAdmitDate(Date admitDate) {
        this.admitDate = admitDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getCertificationIdentificationNumber() {
        return certificationIdentificationNumber;
    }

    public void setCertificationIdentificationNumber(String certificationIdentificationNumber) {
        this.certificationIdentificationNumber = certificationIdentificationNumber;
    }

    public String getPreAuthorizationStatus() {
        return preAuthorizationStatus;
    }

    public void setPreAuthorizationStatus(String preAuthorizationStatus) {
        this.preAuthorizationStatus = preAuthorizationStatus;
    }

    public String getEnquiryDetailStatus() {
        return enquiryDetailStatus;
    }

    public void setEnquiryDetailStatus(String enquiryDetailStatus) {
        this.enquiryDetailStatus = enquiryDetailStatus;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public String getMemberfirstName() {
        return memberfirstName;
    }

    public void setMemberfirstName(String memberfirstName) {
        this.memberfirstName = memberfirstName;
    }

    public String getMemberlastName() {
        return memberlastName;
    }

    public void setMemberlastName(String memberlastName) {
        this.memberlastName = memberlastName;
    }

    public String getMembermiddleName() {
        return membermiddleName;
    }

    public void setMembermiddleName(String membermiddleName) {
        this.membermiddleName = membermiddleName;
    }

    public String getMembersuffix() {
        return membersuffix;
    }

    public void setMembersuffix(String membersuffix) {
        this.membersuffix = membersuffix;
    }

    public String getMembergender() {
        return membergender;
    }

    public void setMembergender(String membergender) {
        this.membergender = membergender;
    }

    public Date getMemberdob() {
        return memberdob;
    }

    public void setMemberdob(Date memberdob) {
        this.memberdob = memberdob;
    }

    public String getMemberPrefix() {
        return memberPrefix;
    }

    public void setMemberPrefix(String memberPrefix) {
        this.memberPrefix = memberPrefix;
    }

    public String getMemberRelationshipToSubscriber() {
        return memberRelationshipToSubscriber;
    }

    public void setMemberRelationshipToSubscriber(String memberRelationshipToSubscriber) {
        this.memberRelationshipToSubscriber = memberRelationshipToSubscriber;
    }

    public String getMemberDetailStatus() {
        return memberDetailStatus;
    }

    public void setMemberDetailStatus(String memberDetailStatus) {
        this.memberDetailStatus = memberDetailStatus;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrgIdentificationCode() {
        return orgIdentificationCode;
    }

    public void setOrgIdentificationCode(String orgIdentificationCode) {
        this.orgIdentificationCode = orgIdentificationCode;
    }

    public String getOrgIdentificationCodeType() {
        return orgIdentificationCodeType;
    }

    public void setOrgIdentificationCodeType(String orgIdentificationCodeType) {
        this.orgIdentificationCodeType = orgIdentificationCodeType;
    }

    public String getOrgRejectionReason() {
        return orgRejectionReason;
    }

    public void setOrgRejectionReason(String orgRejectionReason) {
        this.orgRejectionReason = orgRejectionReason;
    }

    public String getOrgFollowUpActionDescription() {
        return orgFollowUpActionDescription;
    }

    public void setOrgFollowUpActionDescription(String orgFollowUpActionDescription) {
        this.orgFollowUpActionDescription = orgFollowUpActionDescription;
    }

    public String getOrgDetailStatus() {
        return orgDetailStatus;
    }

    public void setOrgDetailStatus(String orgDetailStatus) {
        this.orgDetailStatus = orgDetailStatus;
    }

    public String getReqProviderFullName() {
        return reqProviderFullName;
    }

    public void setReqProviderFullName(String reqProviderFullName) {
        this.reqProviderFullName = reqProviderFullName;
    }

    public String getReqProviderFirstName() {
        return reqProviderFirstName;
    }

    public void setReqProviderFirstName(String reqProviderFirstName) {
        this.reqProviderFirstName = reqProviderFirstName;
    }

    public String getReqProviderLastName() {
        return reqProviderLastName;
    }

    public void setReqProviderLastName(String reqProviderLastName) {
        this.reqProviderLastName = reqProviderLastName;
    }



    public String getReqProviderType() {
        return reqProviderType;
    }

    public void setReqProviderType(String reqProviderType) {
        this.reqProviderType = reqProviderType;
    }

    public String getReqProviderIdentificationNumber() {
        return reqProviderIdentificationNumber;
    }

    public void setReqProviderIdentificationNumber(String reqProviderIdentificationNumber) {
        this.reqProviderIdentificationNumber = reqProviderIdentificationNumber;
    }

    public String getReqProviderIdentificationNumberType() {
        return reqProviderIdentificationNumberType;
    }

    public void setReqProviderIdentificationNumberType(String reqProviderIdentificationNumberType) {
        this.reqProviderIdentificationNumberType = reqProviderIdentificationNumberType;
    }

    public String getReqProviderSupplimentalId() {
        return reqProviderSupplimentalId;
    }

    public void setReqProviderSupplimentalId(String reqProviderSupplimentalId) {
        this.reqProviderSupplimentalId = reqProviderSupplimentalId;
    }

    public String getReqProviderIdNumberType() {
        return reqProviderIdNumberType;
    }

    public void setReqProviderIdNumberType(String reqProviderIdNumberType) {
        this.reqProviderIdNumberType = reqProviderIdNumberType;
    }

    public String getReqProviderRejectionReason() {
        return reqProviderRejectionReason;
    }

    public void setReqProviderRejectionReason(String reqProviderRejectionReason) {
        this.reqProviderRejectionReason = reqProviderRejectionReason;
    }

    public String getReqProviderFollowUpActionDescription() {
        return reqProviderFollowUpActionDescription;
    }

    public void setReqProviderFollowUpActionDescription(String reqProviderFollowUpActionDescription) {
        this.reqProviderFollowUpActionDescription = reqProviderFollowUpActionDescription;
    }

    public String getReqProviderDetailStatus() {
        return reqProviderDetailStatus;
    }

    public void setReqProviderDetailStatus(String reqProviderDetailStatus) {
        this.reqProviderDetailStatus = reqProviderDetailStatus;
    }

    public String getSubscriberFirstName() {
        return subscriberFirstName;
    }

    public void setSubscriberFirstName(String subscriberFirstName) {
        this.subscriberFirstName = subscriberFirstName;
    }

    public String getSubscriberLastName() {
        return subscriberLastName;
    }

    public void setSubscriberLastName(String subscriberLastName) {
        this.subscriberLastName = subscriberLastName;
    }

    public String getSubscriberMiddleName() {
        return subscriberMiddleName;
    }

    public void setSubscriberMiddleName(String subscriberMiddleName) {
        this.subscriberMiddleName = subscriberMiddleName;
    }

    public String getSubscriberSuffix() {
        return subscriberSuffix;
    }

    public void setSubscriberSuffix(String subscriberSuffix) {
        this.subscriberSuffix = subscriberSuffix;
    }

    public String getSubscriberGender() {
        return subscriberGender;
    }

    public void setSubscriberGender(String subscriberGender) {
        this.subscriberGender = subscriberGender;
    }

    public Date getSubscriberDob() {
        return subscriberDob;
    }

    public void setSubscriberDob(Date subscriberDob) {
        this.subscriberDob = subscriberDob;
    }

    public String getSubscriberPrefix() {
        return subscriberPrefix;
    }

    public void setSubscriberPrefix(String subscriberPrefix) {
        this.subscriberPrefix = subscriberPrefix;
    }

    public String getSubscriberSupplementalId() {
        return subscriberSupplementalId;
    }

    public void setSubscriberSupplementalId(String subscriberSupplementalId) {
        this.subscriberSupplementalId = subscriberSupplementalId;
    }

    public String getSubscriberIdentificationNumberType() {
        return subscriberIdentificationNumberType;
    }

    public void setSubscriberIdentificationNumberType(String subscriberIdentificationNumberType) {
        this.subscriberIdentificationNumberType = subscriberIdentificationNumberType;
    }

    public String getSubscriberRejectionReason() {
        return subscriberRejectionReason;
    }

    public void setSubscriberRejectionReason(String subscriberRejectionReason) {
        this.subscriberRejectionReason = subscriberRejectionReason;
    }

    public String getSubscriberFollowUpActionDescription() {
        return subscriberFollowUpActionDescription;
    }

    public void setSubscriberFollowUpActionDescription(String subscriberFollowUpActionDescription) {
        this.subscriberFollowUpActionDescription = subscriberFollowUpActionDescription;
    }

    public String getSubscriberDetailStatus() {
        return subscriberDetailStatus;
    }

    public void setSubscriberDetailStatus(String subscriberDetailStatus) {
        this.subscriberDetailStatus = subscriberDetailStatus;
    }

    public String getDependentFirstName() {
        return dependentFirstName;
    }

    public void setDependentFirstName(String dependentFirstName) {
        this.dependentFirstName = dependentFirstName;
    }

    public String getDependentLastName() {
        return dependentLastName;
    }

    public void setDependentLastName(String dependentLastName) {
        this.dependentLastName = dependentLastName;
    }

    public String getDependentMiddleName() {
        return dependentMiddleName;
    }

    public void setDependentMiddleName(String dependentMiddleName) {
        this.dependentMiddleName = dependentMiddleName;
    }

    public String getDependentSuffix() {
        return dependentSuffix;
    }

    public void setDependentSuffix(String dependentSuffix) {
        this.dependentSuffix = dependentSuffix;
    }

    public String getDependentGender() {
        return dependentGender;
    }

    public void setDependentGender(String dependentGender) {
        this.dependentGender = dependentGender;
    }

    public Date getDependentDob() {
        return dependentDob;
    }

    public void setDependentDob(Date dependentDob) {
        this.dependentDob = dependentDob;
    }

   /* public String getDependentPrefix() {
        return dependentPrefix;
    }

    public void setDependentPrefix(String dependentPrefix) {
        this.dependentPrefix = dependentPrefix;
    }*/

    public String getDependentReletionship() {
        return dependentReletionship;
    }

    public void setDependentReletionship(String dependentReletionship) {
        this.dependentReletionship = dependentReletionship;
    }

    public String getServicingProviderFullName() {
        return servicingProviderFullName;
    }

    public void setServicingProviderFullName(String servicingProviderFullName) {
        this.servicingProviderFullName = servicingProviderFullName;
    }

    public String getServicingProviderFirstName() {
        return servicingProviderFirstName;
    }

    public void setServicingProviderFirstName(String servicingProviderFirstName) {
        this.servicingProviderFirstName = servicingProviderFirstName;
    }

    public String getServicingProviderLastName() {
        return servicingProviderLastName;
    }

    public void setServicingProviderLastName(String servicingProviderLastName) {
        this.servicingProviderLastName = servicingProviderLastName;
    }



    public String getServicingProviderType() {
        return servicingProviderType;
    }

    public void setServicingProviderType(String servicingProviderType) {
        this.servicingProviderType = servicingProviderType;
    }

    public String getServicingProviderAddress() {
        return servicingProviderAddress;
    }

    public void setServicingProviderAddress(String servicingProviderAddress) {
        this.servicingProviderAddress = servicingProviderAddress;
    }

    public String getServicingProviderCity() {
        return servicingProviderCity;
    }

    public void setServicingProviderCity(String servicingProviderCity) {
        this.servicingProviderCity = servicingProviderCity;
    }

    public String getServicingProviderState() {
        return servicingProviderState;
    }

    public void setServicingProviderState(String servicingProviderState) {
        this.servicingProviderState = servicingProviderState;
    }

    public String getServicingProviderPostalCode() {
        return servicingProviderPostalCode;
    }

    public void setServicingProviderPostalCode(String servicingProviderPostalCode) {
        this.servicingProviderPostalCode = servicingProviderPostalCode;
    }

    public String getServicingProviderCountryCode() {
        return servicingProviderCountryCode;
    }

    public void setServicingProviderCountryCode(String servicingProviderCountryCode) {
        this.servicingProviderCountryCode = servicingProviderCountryCode;
    }

    public String getServicingProviderIdentificationNumber() {
        return servicingProviderIdentificationNumber;
    }

    public void setServicingProviderIdentificationNumber(String servicingProviderIdentificationNumber) {
        this.servicingProviderIdentificationNumber = servicingProviderIdentificationNumber;
    }

    public String getServicingProviderIdentificationNumberType() {
        return servicingProviderIdentificationNumberType;
    }

    public void setServicingProviderIdentificationNumberType(String servicingProviderIdentificationNumberType) {
        this.servicingProviderIdentificationNumberType = servicingProviderIdentificationNumberType;
    }

    public String getServicingProviderSupplimentId() {
        return servicingProviderSupplimentId;
    }

    public void setServicingProviderSupplimentId(String servicingProviderSupplimentId) {
        this.servicingProviderSupplimentId = servicingProviderSupplimentId;
    }

    public String getServicingProviderIdNumberType() {
        return servicingProviderIdNumberType;
    }

    public void setServicingProviderIdNumberType(String servicingProviderIdNumberType) {
        this.servicingProviderIdNumberType = servicingProviderIdNumberType;
    }

    public String getServicingProviderRejectionReason() {
        return servicingProviderRejectionReason;
    }

    public void setServicingProviderRejectionReason(String servicingProviderRejectionReason) {
        this.servicingProviderRejectionReason = servicingProviderRejectionReason;
    }

    public String getServicingProviderFollowUpActionDescription() {
        return servicingProviderFollowUpActionDescription;
    }

    public void setServicingProviderFollowUpActionDescription(String servicingProviderFollowUpActionDescription) {
        this.servicingProviderFollowUpActionDescription = servicingProviderFollowUpActionDescription;
    }

    public String getServicingProviderDetailStatus() {
        return servicingProviderDetailStatus;
    }

    public void setServicingProviderDetailStatus(String servicingProviderDetailStatus) {
        this.servicingProviderDetailStatus = servicingProviderDetailStatus;
    }

    public HomeHealthAideResponse getHomeHealthAideResponse() {
        return homeHealthAideResponse;
    }

    public void setHomeHealthAideResponse(HomeHealthAideResponse homeHealthAideResponse) {
        this.homeHealthAideResponse = homeHealthAideResponse;
    }

    public OccupationalTherapyResponse getOccupationalTherapyResponse() {
        return occupationalTherapyResponse;
    }

    public void setOccupationalTherapyResponse(OccupationalTherapyResponse occupationalTherapyResponse) {
        this.occupationalTherapyResponse = occupationalTherapyResponse;
    }

    public MedicalSocialWorkResponse getMedicalSocialWorkResponse() {
        return medicalSocialWorkResponse;
    }

    public void setMedicalSocialWorkResponse(MedicalSocialWorkResponse medicalSocialWorkResponse) {
        this.medicalSocialWorkResponse = medicalSocialWorkResponse;
    }

    public PhysicalTherapyResponse getPhysicalTherapyResponse() {
        return physicalTherapyResponse;
    }

    public void setPhysicalTherapyResponse(PhysicalTherapyResponse physicalTherapyResponse) {
        this.physicalTherapyResponse = physicalTherapyResponse;
    }

    public SkilledNursingResponse getSkilledNursingResponse() {
        return skilledNursingResponse;
    }

    public void setSkilledNursingResponse(SkilledNursingResponse skilledNursingResponse) {
        this.skilledNursingResponse = skilledNursingResponse;
    }

    public SpeechPathologyResponse getSpeechPathologyResponse() {
        return speechPathologyResponse;
    }

    public void setSpeechPathologyResponse(SpeechPathologyResponse speechPathologyResponse) {
        this.speechPathologyResponse = speechPathologyResponse;
    }

    public AuthorizationDetail getAuthorizationDetail() {
        return authorizationDetail;
    }

    public void setAuthorizationDetail(AuthorizationDetail authorizationDetail) {
        this.authorizationDetail = authorizationDetail;
    }

    @Override
    public String toString() {
        return "PreAuthorizationResponse{" +
                "id=" + id +
                ", enquiryId='" + enquiryId + '\'' +
                ", processDateAndTime=" + processDateAndTime +
                ", serviceDateFrom=" + serviceDateFrom +
                ", serviceDateTo=" + serviceDateTo +
                ", effectiveDateTo=" + effectiveDateTo +
                ", effectiveDateFrom=" + effectiveDateFrom +
                ", expirationeDateTo=" + expirationeDateTo +
                ", admitDate=" + admitDate +
                ", dischargeDate=" + dischargeDate +
                ", certificationIdentificationNumber='" + certificationIdentificationNumber + '\'' +
                ", preAuthorizationStatus='" + preAuthorizationStatus + '\'' +
                ", enquiryDetailStatus='" + enquiryDetailStatus + '\'' +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", memberfirstName='" + memberfirstName + '\'' +
                ", memberlastName='" + memberlastName + '\'' +
                ", membermiddleName='" + membermiddleName + '\'' +
                ", membersuffix='" + membersuffix + '\'' +
                ", membergender='" + membergender + '\'' +
                ", memberdob=" + memberdob +
                ", memberPrefix='" + memberPrefix + '\'' +
                ", memberRelationshipToSubscriber='" + memberRelationshipToSubscriber + '\'' +
                ", memberDetailStatus='" + memberDetailStatus + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", orgIdentificationCode='" + orgIdentificationCode + '\'' +
                ", orgIdentificationCodeType='" + orgIdentificationCodeType + '\'' +
                ", orgRejectionReason='" + orgRejectionReason + '\'' +
                ", orgFollowUpActionDescription='" + orgFollowUpActionDescription + '\'' +
                ", orgDetailStatus='" + orgDetailStatus + '\'' +
                ", reqProviderFullName='" + reqProviderFullName + '\'' +
                ", reqProviderFirstName='" + reqProviderFirstName + '\'' +
                ", reqProviderLastName='" + reqProviderLastName + '\'' +
                ", reqProviderType='" + reqProviderType + '\'' +
                ", reqProviderIdentificationNumber='" + reqProviderIdentificationNumber + '\'' +
                ", reqProviderIdentificationNumberType='" + reqProviderIdentificationNumberType + '\'' +
                ", reqProviderSupplimentalId='" + reqProviderSupplimentalId + '\'' +
                ", reqProviderIdNumberType='" + reqProviderIdNumberType + '\'' +
                ", reqProviderRejectionReason='" + reqProviderRejectionReason + '\'' +
                ", reqProviderFollowUpActionDescription='" + reqProviderFollowUpActionDescription + '\'' +
                ", reqProviderDetailStatus='" + reqProviderDetailStatus + '\'' +
                ", subscriberFirstName='" + subscriberFirstName + '\'' +
                ", subscriberLastName='" + subscriberLastName + '\'' +
                ", subscriberMiddleName='" + subscriberMiddleName + '\'' +
                ", subscriberSuffix='" + subscriberSuffix + '\'' +
                ", subscriberGender='" + subscriberGender + '\'' +
                ", subscriberDob=" + subscriberDob +
                ", subscriberPrefix='" + subscriberPrefix + '\'' +
                ", subscriberSupplementalId='" + subscriberSupplementalId + '\'' +
                ", subscriberIdentificationNumberType='" + subscriberIdentificationNumberType + '\'' +
                ", subscriberRejectionReason='" + subscriberRejectionReason + '\'' +
                ", subscriberFollowUpActionDescription='" + subscriberFollowUpActionDescription + '\'' +
                ", subscriberDetailStatus='" + subscriberDetailStatus + '\'' +
                ", dependentFirstName='" + dependentFirstName + '\'' +
                ", dependentLastName='" + dependentLastName + '\'' +
                ", dependentMiddleName='" + dependentMiddleName + '\'' +
                ", dependentSuffix='" + dependentSuffix + '\'' +
                ", dependentGender='" + dependentGender + '\'' +
                ", dependentDob=" + dependentDob +
                ", dependentReletionship='" + dependentReletionship + '\'' +
                ", servicingProviderFullName='" + servicingProviderFullName + '\'' +
                ", servicingProviderFirstName='" + servicingProviderFirstName + '\'' +
                ", servicingProviderLastName='" + servicingProviderLastName + '\'' +
                ", servicingProviderType='" + servicingProviderType + '\'' +
                ", servicingProviderAddress='" + servicingProviderAddress + '\'' +
                ", servicingProviderCity='" + servicingProviderCity + '\'' +
                ", servicingProviderState='" + servicingProviderState + '\'' +
                ", servicingProviderPostalCode='" + servicingProviderPostalCode + '\'' +
                ", servicingProviderCountryCode='" + servicingProviderCountryCode + '\'' +
                ", servicingProviderIdentificationNumber='" + servicingProviderIdentificationNumber + '\'' +
                ", servicingProviderIdentificationNumberType='" + servicingProviderIdentificationNumberType + '\'' +
                ", servicingProviderSupplimentId='" + servicingProviderSupplimentId + '\'' +
                ", servicingProviderIdNumberType='" + servicingProviderIdNumberType + '\'' +
                ", servicingProviderRejectionReason='" + servicingProviderRejectionReason + '\'' +
                ", servicingProviderFollowUpActionDescription='" + servicingProviderFollowUpActionDescription + '\'' +
                ", servicingProviderDetailStatus='" + servicingProviderDetailStatus + '\'' +
                ", homeHealthAideResponse=" + homeHealthAideResponse +
                ", occupationalTherapyResponse=" + occupationalTherapyResponse +
                ", medicalSocialWorkResponse=" + medicalSocialWorkResponse +
                ", physicalTherapyResponse=" + physicalTherapyResponse +
                ", skilledNursingResponse=" + skilledNursingResponse +
                ", speechPathologyResponse=" + speechPathologyResponse +
                ", authorizationDetail=" + authorizationDetail +
                '}';
    }
}
