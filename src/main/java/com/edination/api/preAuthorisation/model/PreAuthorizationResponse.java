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
    private String orgCommunicationTypeTelephone;
    private String orgCommunicationTypeFacsimile;
    private String orgCommunicationTypeEMail;
    private String orgCommunicationExt;
    private String orgRejectionReason;
    private String orgFollowUpActionDescription;
    private String orgDetailStatus;

    private String subscriberFirstName;
    private String subscriberLastName;
    private String  subscriberMiddleName;
    private String subscriberSuffix;
    private String subscriberGender;
    private Date subscriberDob;
    private String subscriberPrefix;
    private String subscriberSupplementalId;
    private String subscriberIdentificationNumberType;
    private String subscriberRelToInsured;
    private String subscriberIdentificationCode;
    private String subscriberIdNumberType;
    private String subscriberRejectionReason;
    private String subscriberFollowUpActionDescription;
    private String subscriberDetailStatus;



    private String servicingProviderFullName;
    private String servicingProviderFirstName;
    private String servicingProviderLastName;
    private String servicingProviderMiddleName;
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "requesterId")
    private RequesterResponseInformation requesterResponseInformation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dependentId")
    private DependentDetailResponse dependentDetailResponse;


    public PreAuthorizationResponse()
    {
    }

    public PreAuthorizationResponse(String enquiryId, String mrnNumber, String memberfirstName, String memberlastName, String membermiddleName, String membersuffix, String membergender, Date memberdob, String memberPrefix, String memberRelationshipToSubscriber, String memberDetailStatus, String organizationName, String orgIdentificationCode, String orgIdentificationCodeType, String orgCommunicationTypeTelephone, String orgCommunicationTypeFacsimile, String orgCommunicationTypeEMail, String orgCommunicationExt, String orgRejectionReason, String orgFollowUpActionDescription, String orgDetailStatus, String subscriberFirstName, String subscriberLastName, String subscriberMiddleName, String subscriberSuffix, String subscriberGender, Date subscriberDob, String subscriberPrefix, String subscriberSupplementalId, String subscriberIdentificationNumberType, String subscriberRelToInsured, String subscriberIdentificationCode, String subscriberIdNumberType, String subscriberRejectionReason, String subscriberFollowUpActionDescription, String subscriberDetailStatus, String servicingProviderFullName, String servicingProviderFirstName, String servicingProviderLastName, String servicingProviderMiddleName, String servicingProviderType, String servicingProviderAddress, String servicingProviderCity, String servicingProviderState, String servicingProviderPostalCode, String servicingProviderCountryCode, String servicingProviderIdentificationNumber, String servicingProviderIdentificationNumberType, String servicingProviderSupplimentId, String servicingProviderIdNumberType, String servicingProviderRejectionReason, String servicingProviderFollowUpActionDescription, String servicingProviderDetailStatus, HomeHealthAideResponse homeHealthAideResponse, OccupationalTherapyResponse occupationalTherapyResponse, MedicalSocialWorkResponse medicalSocialWorkResponse, PhysicalTherapyResponse physicalTherapyResponse, SkilledNursingResponse skilledNursingResponse, SpeechPathologyResponse speechPathologyResponse, AuthorizationDetail authorizationDetail, RequesterResponseInformation requesterResponseInformation) {
        this.enquiryId = enquiryId;
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
        this.orgCommunicationTypeTelephone = orgCommunicationTypeTelephone;
        this.orgCommunicationTypeFacsimile = orgCommunicationTypeFacsimile;
        this.orgCommunicationTypeEMail = orgCommunicationTypeEMail;
        this.orgCommunicationExt = orgCommunicationExt;
        this.orgRejectionReason = orgRejectionReason;
        this.orgFollowUpActionDescription = orgFollowUpActionDescription;
        this.orgDetailStatus = orgDetailStatus;
        this.subscriberFirstName = subscriberFirstName;
        this.subscriberLastName = subscriberLastName;
        this.subscriberMiddleName = subscriberMiddleName;
        this.subscriberSuffix = subscriberSuffix;
        this.subscriberGender = subscriberGender;
        this.subscriberDob = subscriberDob;
        this.subscriberPrefix = subscriberPrefix;
        this.subscriberSupplementalId = subscriberSupplementalId;
        this.subscriberIdentificationNumberType = subscriberIdentificationNumberType;
        this.subscriberRelToInsured = subscriberRelToInsured;
        this.subscriberIdentificationCode = subscriberIdentificationCode;
        this.subscriberIdNumberType = subscriberIdNumberType;
        this.subscriberRejectionReason = subscriberRejectionReason;
        this.subscriberFollowUpActionDescription = subscriberFollowUpActionDescription;
        this.subscriberDetailStatus = subscriberDetailStatus;
        this.servicingProviderFullName = servicingProviderFullName;
        this.servicingProviderFirstName = servicingProviderFirstName;
        this.servicingProviderLastName = servicingProviderLastName;
        this.servicingProviderMiddleName = servicingProviderMiddleName;
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
        this.authorizationDetail = authorizationDetail;
        this.requesterResponseInformation = requesterResponseInformation;
    }

    public DependentDetailResponse getDependentDetailResponse() {
        return dependentDetailResponse;
    }

    public void setDependentDetailResponse(DependentDetailResponse dependentDetailResponse) {
        this.dependentDetailResponse = dependentDetailResponse;
    }

    public RequesterResponseInformation getRequesterResponseInformation() {
        return requesterResponseInformation;
    }

    public void setRequesterResponseInformation(RequesterResponseInformation requesterResponseInformation) {
        this.requesterResponseInformation = requesterResponseInformation;
    }

    public String getOrgCommunicationTypeTelephone() {
        return orgCommunicationTypeTelephone;
    }

    public void setOrgCommunicationTypeTelephone(String orgCommunicationTypeTelephone) {
        this.orgCommunicationTypeTelephone = orgCommunicationTypeTelephone;
    }

    public String getOrgCommunicationTypeFacsimile() {
        return orgCommunicationTypeFacsimile;
    }

    public void setOrgCommunicationTypeFacsimile(String orgCommunicationTypeFacsimile) {
        this.orgCommunicationTypeFacsimile = orgCommunicationTypeFacsimile;
    }

    public String getOrgCommunicationTypeEMail() {
        return orgCommunicationTypeEMail;
    }

    public void setOrgCommunicationTypeEMail(String orgCommunicationTypeEMail) {
        this.orgCommunicationTypeEMail = orgCommunicationTypeEMail;
    }

    public String getOrgCommunicationExt() {
        return orgCommunicationExt;
    }

    public void setOrgCommunicationExt(String orgCommunicationExt) {
        this.orgCommunicationExt = orgCommunicationExt;
    }

    public String getSubscriberRelToInsured() {
        return subscriberRelToInsured;
    }

    public void setSubscriberRelToInsured(String subscriberRelToInsured) {
        this.subscriberRelToInsured = subscriberRelToInsured;
    }

    public String getSubscriberIdentificationCode() {
        return subscriberIdentificationCode;
    }

    public void setSubscriberIdentificationCode(String subscriberIdentificationCode) {
        this.subscriberIdentificationCode = subscriberIdentificationCode;
    }

    public String getSubscriberIdNumberType() {
        return subscriberIdNumberType;
    }

    public void setSubscriberIdNumberType(String subscriberIdNumberType) {
        this.subscriberIdNumberType = subscriberIdNumberType;
    }

    public String getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(String enquiryId) {
        this.enquiryId = enquiryId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getServicingProviderMiddleName() {
        return servicingProviderMiddleName;
    }

    public void setServicingProviderMiddleName(String servicingProviderMiddleName) {
        this.servicingProviderMiddleName = servicingProviderMiddleName;
    }

    @Override
    public String toString() {
        return "PreAuthorizationResponse{" +
                "id=" + id +
                ", enquiryId='" + enquiryId + '\'' +
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
                ", orgCommunicationTypeTelephone='" + orgCommunicationTypeTelephone + '\'' +
                ", orgCommunicationTypeFacsimile='" + orgCommunicationTypeFacsimile + '\'' +
                ", orgCommunicationTypeEMail='" + orgCommunicationTypeEMail + '\'' +
                ", orgCommunicationExt='" + orgCommunicationExt + '\'' +
                ", orgRejectionReason='" + orgRejectionReason + '\'' +
                ", orgFollowUpActionDescription='" + orgFollowUpActionDescription + '\'' +
                ", orgDetailStatus='" + orgDetailStatus + '\'' +
                ", subscriberFirstName='" + subscriberFirstName + '\'' +
                ", subscriberLastName='" + subscriberLastName + '\'' +
                ", subscriberMiddleName='" + subscriberMiddleName + '\'' +
                ", subscriberSuffix='" + subscriberSuffix + '\'' +
                ", subscriberGender='" + subscriberGender + '\'' +
                ", subscriberDob=" + subscriberDob +
                ", subscriberPrefix='" + subscriberPrefix + '\'' +
                ", subscriberSupplementalId='" + subscriberSupplementalId + '\'' +
                ", subscriberIdentificationNumberType='" + subscriberIdentificationNumberType + '\'' +
                ", subscriberRelToInsured='" + subscriberRelToInsured + '\'' +
                ", subscriberIdentificationCode='" + subscriberIdentificationCode + '\'' +
                ", subscriberIdNumberType='" + subscriberIdNumberType + '\'' +
                ", subscriberRejectionReason='" + subscriberRejectionReason + '\'' +
                ", subscriberFollowUpActionDescription='" + subscriberFollowUpActionDescription + '\'' +
                ", subscriberDetailStatus='" + subscriberDetailStatus + '\'' +
                ", servicingProviderFullName='" + servicingProviderFullName + '\'' +
                ", servicingProviderFirstName='" + servicingProviderFirstName + '\'' +
                ", servicingProviderLastName='" + servicingProviderLastName + '\'' +
                ", servicingProviderMiddleName='" + servicingProviderMiddleName + '\'' +
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
                ", requesterResponseInformation=" + requesterResponseInformation +
                ", dependentDetailResponse=" + dependentDetailResponse +
                '}';
    }
}
