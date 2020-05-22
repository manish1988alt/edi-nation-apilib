package com.edination.api.preAuthorisation.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PrAuthorizationResponse")
public class PreAuthorizationResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String enquiryId;
    private Date processDateAndTime;
    private String preAuthorizationNumber;
    private String mrnNumber;
    private String memberfirstName;
    private String memberlastName;
    private String membermiddleName;
    private String membersuffix;
    private String membergender;
    private Date memberdob;
    private String memberPrefix;

    private String  organizationName;
    private String orgIdentificationCode;
    private String orgIdentificationCodeType;
    private boolean orgRequestValidationAccepted;
    private boolean orgTransactionRejected;
    private String orgRejectionReason;
    private boolean orgFollowUpActionRequired;
    private String orgFollowUpActionDescription;

    private String providerName;
    private String providerType;
    private String providerIdentificationNumber;
    private String providerIdentificationNumberType;
    private String providerSupplimentalId;
    private String providerIdNumberType;
    private boolean providerRequestValidationAccepted;
    private boolean providerTransactionRejected;
    private String providerRejectionReason;
    private boolean providerFollowUpActionRequired;
    private String providerFollowUpActionDescription;


    private String subscriberFirstName;
    private String subscriberLastName;
    private String  subscriberMiddleName;
    private String subscriberSuffix;
    private String subscriberGender;
    private Date subscriberDob;
    private String subscriberPrefix;
    private String subscriberSupplementalId;
    private String subscriberIdentificationNumberType;
    private boolean subscriberRequestValidationAccepted;
    private boolean subscriberTransactionRejected;
    private String subscriberRejectionReason;
    private boolean subscriberFollowUpActionRequired;
    private String subscriberFollowUpActionDescription;

    private String dependentFirstName;
    private String dependentLastName;
    private String dependentMiddleName;
    private String dependentSuffix;
    private String dependentGender;
    private Date dependentDob;
    private String dependentPrefix;
    private String dependentReletionship;

    public PreAuthorizationResponse() {
    }

    public PreAuthorizationResponse(String enquiryId, Date processDateAndTime, String preAuthorizationNumber, String mrnNumber, String memberfirstName, String memberlastName, String membermiddleName, String membersuffix, String membergender, Date memberdob, String memberPrefix, String organizationName, String orgIdentificationCode, String orgIdentificationCodeType, boolean orgRequestValidationAccepted, boolean orgTransactionRejected, String orgRejectionReason, boolean orgFollowUpActionRequired, String orgFollowUpActionDescription, String providerName, String providerType, String providerIdentificationNumber, String providerIdentificationNumberType, String providerSupplimentalId, String providerIdNumberType, boolean providerRequestValidationAccepted, boolean providerTransactionRejected, String providerRejectionReason, boolean providerFollowUpActionRequired, String providerFollowUpActionDescription, String subscriberFirstName, String subscriberLastName, String subscriberMiddleName, String subscriberSuffix, String subscriberGender, Date subscriberDob, String subscriberPrefix, String subscriberSupplementalId, String subscriberIdentificationNumberType, boolean subscriberRequestValidationAccepted, boolean subscriberTransactionRejected, String subscriberRejectionReason, boolean subscriberFollowUpActionRequired, String subscriberFollowUpActionDescription, String dependentFirstName, String dependentLastName, String dependentMiddleName, String dependentSuffix, String dependentGender, Date dependentDob, String dependentPrefix, String dependentReletionship) {
        this.enquiryId = enquiryId;
        this.processDateAndTime = processDateAndTime;
        this.preAuthorizationNumber = preAuthorizationNumber;
        this.mrnNumber = mrnNumber;
        this.memberfirstName = memberfirstName;
        this.memberlastName = memberlastName;
        this.membermiddleName = membermiddleName;
        this.membersuffix = membersuffix;
        this.membergender = membergender;
        this.memberdob = memberdob;
        this.memberPrefix = memberPrefix;
        this.organizationName = organizationName;
        this.orgIdentificationCode = orgIdentificationCode;
        this.orgIdentificationCodeType = orgIdentificationCodeType;
        this.orgRequestValidationAccepted = orgRequestValidationAccepted;
        this.orgTransactionRejected = orgTransactionRejected;
        this.orgRejectionReason = orgRejectionReason;
        this.orgFollowUpActionRequired = orgFollowUpActionRequired;
        this.orgFollowUpActionDescription = orgFollowUpActionDescription;
        this.providerName = providerName;
        this.providerType = providerType;
        this.providerIdentificationNumber = providerIdentificationNumber;
        this.providerIdentificationNumberType = providerIdentificationNumberType;
        this.providerSupplimentalId = providerSupplimentalId;
        this.providerIdNumberType = providerIdNumberType;
        this.providerRequestValidationAccepted = providerRequestValidationAccepted;
        this.providerTransactionRejected = providerTransactionRejected;
        this.providerRejectionReason = providerRejectionReason;
        this.providerFollowUpActionRequired = providerFollowUpActionRequired;
        this.providerFollowUpActionDescription = providerFollowUpActionDescription;
        this.subscriberFirstName = subscriberFirstName;
        this.subscriberLastName = subscriberLastName;
        this.subscriberMiddleName = subscriberMiddleName;
        this.subscriberSuffix = subscriberSuffix;
        this.subscriberGender = subscriberGender;
        this.subscriberDob = subscriberDob;
        this.subscriberPrefix = subscriberPrefix;
        this.subscriberSupplementalId = subscriberSupplementalId;
        this.subscriberIdentificationNumberType = subscriberIdentificationNumberType;
        this.subscriberRequestValidationAccepted = subscriberRequestValidationAccepted;
        this.subscriberTransactionRejected = subscriberTransactionRejected;
        this.subscriberRejectionReason = subscriberRejectionReason;
        this.subscriberFollowUpActionRequired = subscriberFollowUpActionRequired;
        this.subscriberFollowUpActionDescription = subscriberFollowUpActionDescription;
        this.dependentFirstName = dependentFirstName;
        this.dependentLastName = dependentLastName;
        this.dependentMiddleName = dependentMiddleName;
        this.dependentSuffix = dependentSuffix;
        this.dependentGender = dependentGender;
        this.dependentDob = dependentDob;
        this.dependentPrefix = dependentPrefix;
        this.dependentReletionship = dependentReletionship;
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

    public String getPreAuthorizationNumber() {
        return preAuthorizationNumber;
    }

    public void setPreAuthorizationNumber(String preAuthorizationNumber) {
        this.preAuthorizationNumber = preAuthorizationNumber;
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

    public boolean isOrgRequestValidationAccepted() {
        return orgRequestValidationAccepted;
    }

    public void setOrgRequestValidationAccepted(boolean orgRequestValidationAccepted) {
        this.orgRequestValidationAccepted = orgRequestValidationAccepted;
    }

    public boolean isOrgTransactionRejected() {
        return orgTransactionRejected;
    }

    public void setOrgTransactionRejected(boolean orgTransactionRejected) {
        this.orgTransactionRejected = orgTransactionRejected;
    }

    public String getOrgRejectionReason() {
        return orgRejectionReason;
    }

    public void setOrgRejectionReason(String orgRejectionReason) {
        this.orgRejectionReason = orgRejectionReason;
    }

    public boolean isOrgFollowUpActionRequired() {
        return orgFollowUpActionRequired;
    }

    public void setOrgFollowUpActionRequired(boolean orgFollowUpActionRequired) {
        this.orgFollowUpActionRequired = orgFollowUpActionRequired;
    }

    public String getOrgFollowUpActionDescription() {
        return orgFollowUpActionDescription;
    }

    public void setOrgFollowUpActionDescription(String orgFollowUpActionDescription) {
        this.orgFollowUpActionDescription = orgFollowUpActionDescription;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getProviderType() {
        return providerType;
    }

    public void setProviderType(String providerType) {
        this.providerType = providerType;
    }

    public String getProviderIdentificationNumber() {
        return providerIdentificationNumber;
    }

    public void setProviderIdentificationNumber(String providerIdentificationNumber) {
        this.providerIdentificationNumber = providerIdentificationNumber;
    }

    public String getProviderIdentificationNumberType() {
        return providerIdentificationNumberType;
    }

    public void setProviderIdentificationNumberType(String providerIdentificationNumberType) {
        this.providerIdentificationNumberType = providerIdentificationNumberType;
    }

    public String getProviderSupplimentalId() {
        return providerSupplimentalId;
    }

    public void setProviderSupplimentalId(String providerSupplimentalId) {
        this.providerSupplimentalId = providerSupplimentalId;
    }

    public String getProviderIdNumberType() {
        return providerIdNumberType;
    }

    public void setProviderIdNumberType(String providerIdNumberType) {
        this.providerIdNumberType = providerIdNumberType;
    }

    public boolean isProviderRequestValidationAccepted() {
        return providerRequestValidationAccepted;
    }

    public void setProviderRequestValidationAccepted(boolean providerRequestValidationAccepted) {
        this.providerRequestValidationAccepted = providerRequestValidationAccepted;
    }

    public boolean isProviderTransactionRejected() {
        return providerTransactionRejected;
    }

    public void setProviderTransactionRejected(boolean providerTransactionRejected) {
        this.providerTransactionRejected = providerTransactionRejected;
    }

    public String getProviderRejectionReason() {
        return providerRejectionReason;
    }

    public void setProviderRejectionReason(String providerRejectionReason) {
        this.providerRejectionReason = providerRejectionReason;
    }

    public boolean isProviderFollowUpActionRequired() {
        return providerFollowUpActionRequired;
    }

    public void setProviderFollowUpActionRequired(boolean providerFollowUpActionRequired) {
        this.providerFollowUpActionRequired = providerFollowUpActionRequired;
    }

    public String getProviderFollowUpActionDescription() {
        return providerFollowUpActionDescription;
    }

    public void setProviderFollowUpActionDescription(String providerFollowUpActionDescription) {
        this.providerFollowUpActionDescription = providerFollowUpActionDescription;
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

    public boolean isSubscriberRequestValidationAccepted() {
        return subscriberRequestValidationAccepted;
    }

    public void setSubscriberRequestValidationAccepted(boolean subscriberRequestValidationAccepted) {
        this.subscriberRequestValidationAccepted = subscriberRequestValidationAccepted;
    }

    public boolean isSubscriberTransactionRejected() {
        return subscriberTransactionRejected;
    }

    public void setSubscriberTransactionRejected(boolean subscriberTransactionRejected) {
        this.subscriberTransactionRejected = subscriberTransactionRejected;
    }

    public String getSubscriberRejectionReason() {
        return subscriberRejectionReason;
    }

    public void setSubscriberRejectionReason(String subscriberRejectionReason) {
        this.subscriberRejectionReason = subscriberRejectionReason;
    }

    public boolean isSubscriberFollowUpActionRequired() {
        return subscriberFollowUpActionRequired;
    }

    public void setSubscriberFollowUpActionRequired(boolean subscriberFollowUpActionRequired) {
        this.subscriberFollowUpActionRequired = subscriberFollowUpActionRequired;
    }

    public String getSubscriberFollowUpActionDescription() {
        return subscriberFollowUpActionDescription;
    }

    public void setSubscriberFollowUpActionDescription(String subscriberFollowUpActionDescription) {
        this.subscriberFollowUpActionDescription = subscriberFollowUpActionDescription;
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

    public String getDependentPrefix() {
        return dependentPrefix;
    }

    public void setDependentPrefix(String dependentPrefix) {
        this.dependentPrefix = dependentPrefix;
    }

    public String getDependentReletionship() {
        return dependentReletionship;
    }

    public void setDependentReletionship(String dependentReletionship) {
        this.dependentReletionship = dependentReletionship;
    }

    @Override
    public String toString() {
        return "PrAuthorizationResponse{" +
                "id=" + id +
                ", enquiryId='" + enquiryId + '\'' +
                ", processDateAndTime=" + processDateAndTime +
                ", preAuthorizationNumber='" + preAuthorizationNumber + '\'' +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", memberfirstName='" + memberfirstName + '\'' +
                ", memberlastName='" + memberlastName + '\'' +
                ", membermiddleName='" + membermiddleName + '\'' +
                ", membersuffix='" + membersuffix + '\'' +
                ", membergender='" + membergender + '\'' +
                ", memberdob=" + memberdob +
                ", memberPrefix='" + memberPrefix + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", orgIdentificationCode='" + orgIdentificationCode + '\'' +
                ", orgIdentificationCodeType='" + orgIdentificationCodeType + '\'' +
                ", orgRequestValidationAccepted=" + orgRequestValidationAccepted +
                ", orgTransactionRejected=" + orgTransactionRejected +
                ", orgRejectionReason='" + orgRejectionReason + '\'' +
                ", orgFollowUpActionRequired=" + orgFollowUpActionRequired +
                ", orgFollowUpActionDescription='" + orgFollowUpActionDescription + '\'' +
                ", providerName='" + providerName + '\'' +
                ", providerType='" + providerType + '\'' +
                ", providerIdentificationNumber='" + providerIdentificationNumber + '\'' +
                ", providerIdentificationNumberType='" + providerIdentificationNumberType + '\'' +
                ", providerSupplimentalId='" + providerSupplimentalId + '\'' +
                ", providerIdNumberType='" + providerIdNumberType + '\'' +
                ", providerRequestValidationAccepted=" + providerRequestValidationAccepted +
                ", providerTransactionRejected=" + providerTransactionRejected +
                ", providerRejectionReason='" + providerRejectionReason + '\'' +
                ", providerFollowUpActionRequired=" + providerFollowUpActionRequired +
                ", providerFollowUpActionDescription='" + providerFollowUpActionDescription + '\'' +
                ", subscriberFirstName='" + subscriberFirstName + '\'' +
                ", subscriberLastName='" + subscriberLastName + '\'' +
                ", subscriberMiddleName='" + subscriberMiddleName + '\'' +
                ", subscriberSuffix='" + subscriberSuffix + '\'' +
                ", subscriberGender='" + subscriberGender + '\'' +
                ", subscriberDob=" + subscriberDob +
                ", subscriberPrefix='" + subscriberPrefix + '\'' +
                ", subscriberSupplementalId='" + subscriberSupplementalId + '\'' +
                ", subscriberIdentificationNumberType='" + subscriberIdentificationNumberType + '\'' +
                ", subscriberRequestValidationAccepted=" + subscriberRequestValidationAccepted +
                ", subscriberTransactionRejected=" + subscriberTransactionRejected +
                ", subscriberRejectionReason='" + subscriberRejectionReason + '\'' +
                ", subscriberFollowUpActionRequired=" + subscriberFollowUpActionRequired +
                ", subscriberFollowUpActionDescription='" + subscriberFollowUpActionDescription + '\'' +
                ", dependentFirstName='" + dependentFirstName + '\'' +
                ", dependentLastName='" + dependentLastName + '\'' +
                ", dependentMiddleName='" + dependentMiddleName + '\'' +
                ", dependentSuffix='" + dependentSuffix + '\'' +
                ", dependentGender='" + dependentGender + '\'' +
                ", dependentDob=" + dependentDob +
                ", dependentPrefix='" + dependentPrefix + '\'' +
                ", dependentReletionship='" + dependentReletionship + '\'' +
                '}';
    }
}
