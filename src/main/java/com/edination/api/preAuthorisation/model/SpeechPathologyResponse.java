package com.edination.api.preAuthorisation.model;

import javax.persistence.*;


@Entity
@Table(name = "SpeechPathologyResponse")
public class SpeechPathologyResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String SpeechPathologyRequestCategory;
    private String SpeechPathologyCertificationType;
    private String SpeechPathologyServiceType;
    private String SpeechPathologyLevelOfService;
    private String SpeechPathologyVisit;
    private String SpeechPathologyUnit;
    private String SpeechPathologyCertificationAction;
    private String SpeechPathologyRejectionReason;
    private String SpeechPathologyRejectionReasonMSG;
    private String SpeechPathologyProviderFirstName;
    private String SpeechPathologyPoviderLastName;
    private String SpeechPathologyProviderMiddleName;
    private String SpeechPathologyProviderType;
    private String SpeechPathologyProviderIdentificationNumber;
    private String SpeechPathologyProviderIdentificationNumberType;
    private String SpeechPathologyProviderSupplimentalId;
    private String SpeechPathologyProviderIdNumberType;
    private String SpeechPathologyProviderRejectionReason;
    private String SpeechPathologyProviderFollowUpActionDescription;
    private String SpeechPathologyProviderAddress;
    private String SpeechPathologyProviderCity;
    private String SpeechPathologyProviderState;
    private String SpeechPathologyProviderPostalCode;
    private String SpeechPathologyProviderCountryCode;
    private String SpeechPathologyProviderFullName;
    private String SpeechPathologyDetailStatus;
    public SpeechPathologyResponse() {
    }

    public SpeechPathologyResponse(String speechPathologyRequestCategory, String speechPathologyCertificationType, String speechPathologyServiceType, String speechPathologyLevelOfService, String speechPathologyVisit, String speechPathologyUnit, String speechPathologyCertificationAction, String speechPathologyRejectionReason, String speechPathologyRejectionReasonMSG, String speechPathologyProviderFirstName, String speechPathologyPoviderLastName, String speechPathologyProviderMiddleName, String speechPathologyProviderType, String speechPathologyProviderIdentificationNumber, String speechPathologyProviderIdentificationNumberType, String speechPathologyProviderSupplimentalId, String speechPathologyProviderIdNumberType, String speechPathologyProviderRejectionReason, String speechPathologyProviderFollowUpActionDescription, String speechPathologyProviderAddress, String speechPathologyProviderCity, String speechPathologyProviderState, String speechPathologyProviderPostalCode, String speechPathologyProviderCountryCode, String speechPathologyProviderFullName, String speechPathologyDetailStatus) {
        SpeechPathologyRequestCategory = speechPathologyRequestCategory;
        SpeechPathologyCertificationType = speechPathologyCertificationType;
        SpeechPathologyServiceType = speechPathologyServiceType;
        SpeechPathologyLevelOfService = speechPathologyLevelOfService;
        SpeechPathologyVisit = speechPathologyVisit;
        SpeechPathologyUnit = speechPathologyUnit;
        SpeechPathologyCertificationAction = speechPathologyCertificationAction;
        SpeechPathologyRejectionReason = speechPathologyRejectionReason;
        SpeechPathologyRejectionReasonMSG = speechPathologyRejectionReasonMSG;
        SpeechPathologyProviderFirstName = speechPathologyProviderFirstName;
        SpeechPathologyPoviderLastName = speechPathologyPoviderLastName;
        SpeechPathologyProviderMiddleName = speechPathologyProviderMiddleName;
        SpeechPathologyProviderType = speechPathologyProviderType;
        SpeechPathologyProviderIdentificationNumber = speechPathologyProviderIdentificationNumber;
        SpeechPathologyProviderIdentificationNumberType = speechPathologyProviderIdentificationNumberType;
        SpeechPathologyProviderSupplimentalId = speechPathologyProviderSupplimentalId;
        SpeechPathologyProviderIdNumberType = speechPathologyProviderIdNumberType;
        SpeechPathologyProviderRejectionReason = speechPathologyProviderRejectionReason;
        SpeechPathologyProviderFollowUpActionDescription = speechPathologyProviderFollowUpActionDescription;
        SpeechPathologyProviderAddress = speechPathologyProviderAddress;
        SpeechPathologyProviderCity = speechPathologyProviderCity;
        SpeechPathologyProviderState = speechPathologyProviderState;
        SpeechPathologyProviderPostalCode = speechPathologyProviderPostalCode;
        SpeechPathologyProviderCountryCode = speechPathologyProviderCountryCode;
        SpeechPathologyProviderFullName = speechPathologyProviderFullName;
        SpeechPathologyDetailStatus = speechPathologyDetailStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpeechPathologyRequestCategory() {
        return SpeechPathologyRequestCategory;
    }

    public void setSpeechPathologyRequestCategory(String speechPathologyRequestCategory) {
        SpeechPathologyRequestCategory = speechPathologyRequestCategory;
    }

    public String getSpeechPathologyCertificationType() {
        return SpeechPathologyCertificationType;
    }

    public void setSpeechPathologyCertificationType(String speechPathologyCertificationType) {
        SpeechPathologyCertificationType = speechPathologyCertificationType;
    }

    public String getSpeechPathologyServiceType() {
        return SpeechPathologyServiceType;
    }

    public void setSpeechPathologyServiceType(String speechPathologyServiceType) {
        SpeechPathologyServiceType = speechPathologyServiceType;
    }

    public String getSpeechPathologyLevelOfService() {
        return SpeechPathologyLevelOfService;
    }

    public void setSpeechPathologyLevelOfService(String speechPathologyLevelOfService) {
        SpeechPathologyLevelOfService = speechPathologyLevelOfService;
    }

    public String getSpeechPathologyVisit() {
        return SpeechPathologyVisit;
    }

    public void setSpeechPathologyVisit(String speechPathologyVisit) {
        SpeechPathologyVisit = speechPathologyVisit;
    }

    public String getSpeechPathologyUnit() {
        return SpeechPathologyUnit;
    }

    public void setSpeechPathologyUnit(String speechPathologyUnit) {
        SpeechPathologyUnit = speechPathologyUnit;
    }

    public String getSpeechPathologyCertificationAction() {
        return SpeechPathologyCertificationAction;
    }

    public void setSpeechPathologyCertificationAction(String speechPathologyCertificationAction) {
        SpeechPathologyCertificationAction = speechPathologyCertificationAction;
    }

    public String getSpeechPathologyRejectionReason() {
        return SpeechPathologyRejectionReason;
    }

    public void setSpeechPathologyRejectionReason(String speechPathologyRejectionReason) {
        SpeechPathologyRejectionReason = speechPathologyRejectionReason;
    }

    public String getSpeechPathologyRejectionReasonMSG() {
        return SpeechPathologyRejectionReasonMSG;
    }

    public void setSpeechPathologyRejectionReasonMSG(String speechPathologyRejectionReasonMSG) {
        SpeechPathologyRejectionReasonMSG = speechPathologyRejectionReasonMSG;
    }

    public String getSpeechPathologyProviderFirstName() {
        return SpeechPathologyProviderFirstName;
    }

    public void setSpeechPathologyProviderFirstName(String speechPathologyProviderFirstName) {
        SpeechPathologyProviderFirstName = speechPathologyProviderFirstName;
    }

    public String getSpeechPathologyPoviderLastName() {
        return SpeechPathologyPoviderLastName;
    }

    public void setSpeechPathologyPoviderLastName(String speechPathologyPoviderLastName) {
        SpeechPathologyPoviderLastName = speechPathologyPoviderLastName;
    }

    public String getSpeechPathologyProviderMiddleName() {
        return SpeechPathologyProviderMiddleName;
    }

    public void setSpeechPathologyProviderMiddleName(String speechPathologyProviderMiddleName) {
        SpeechPathologyProviderMiddleName = speechPathologyProviderMiddleName;
    }

    public String getSpeechPathologyProviderType() {
        return SpeechPathologyProviderType;
    }

    public void setSpeechPathologyProviderType(String speechPathologyProviderType) {
        SpeechPathologyProviderType = speechPathologyProviderType;
    }

    public String getSpeechPathologyProviderIdentificationNumber() {
        return SpeechPathologyProviderIdentificationNumber;
    }

    public void setSpeechPathologyProviderIdentificationNumber(String speechPathologyProviderIdentificationNumber) {
        SpeechPathologyProviderIdentificationNumber = speechPathologyProviderIdentificationNumber;
    }

    public String getSpeechPathologyProviderIdentificationNumberType() {
        return SpeechPathologyProviderIdentificationNumberType;
    }

    public void setSpeechPathologyProviderIdentificationNumberType(String speechPathologyProviderIdentificationNumberType) {
        SpeechPathologyProviderIdentificationNumberType = speechPathologyProviderIdentificationNumberType;
    }

    public String getSpeechPathologyProviderSupplimentalId() {
        return SpeechPathologyProviderSupplimentalId;
    }

    public void setSpeechPathologyProviderSupplimentalId(String speechPathologyProviderSupplimentalId) {
        SpeechPathologyProviderSupplimentalId = speechPathologyProviderSupplimentalId;
    }

    public String getSpeechPathologyProviderIdNumberType() {
        return SpeechPathologyProviderIdNumberType;
    }

    public void setSpeechPathologyProviderIdNumberType(String speechPathologyProviderIdNumberType) {
        SpeechPathologyProviderIdNumberType = speechPathologyProviderIdNumberType;
    }

    public String getSpeechPathologyProviderRejectionReason() {
        return SpeechPathologyProviderRejectionReason;
    }

    public void setSpeechPathologyProviderRejectionReason(String speechPathologyProviderRejectionReason) {
        SpeechPathologyProviderRejectionReason = speechPathologyProviderRejectionReason;
    }

    public String getSpeechPathologyProviderFollowUpActionDescription() {
        return SpeechPathologyProviderFollowUpActionDescription;
    }

    public void setSpeechPathologyProviderFollowUpActionDescription(String speechPathologyProviderFollowUpActionDescription) {
        SpeechPathologyProviderFollowUpActionDescription = speechPathologyProviderFollowUpActionDescription;
    }

    public String getSpeechPathologyProviderAddress() {
        return SpeechPathologyProviderAddress;
    }

    public void setSpeechPathologyProviderAddress(String speechPathologyProviderAddress) {
        SpeechPathologyProviderAddress = speechPathologyProviderAddress;
    }

    public String getSpeechPathologyProviderCity() {
        return SpeechPathologyProviderCity;
    }

    public void setSpeechPathologyProviderCity(String speechPathologyProviderCity) {
        SpeechPathologyProviderCity = speechPathologyProviderCity;
    }

    public String getSpeechPathologyProviderState() {
        return SpeechPathologyProviderState;
    }

    public void setSpeechPathologyProviderState(String speechPathologyProviderState) {
        SpeechPathologyProviderState = speechPathologyProviderState;
    }

    public String getSpeechPathologyProviderPostalCode() {
        return SpeechPathologyProviderPostalCode;
    }

    public void setSpeechPathologyProviderPostalCode(String speechPathologyProviderPostalCode) {
        SpeechPathologyProviderPostalCode = speechPathologyProviderPostalCode;
    }

    public String getSpeechPathologyProviderCountryCode() {
        return SpeechPathologyProviderCountryCode;
    }

    public void setSpeechPathologyProviderCountryCode(String speechPathologyProviderCountryCode) {
        SpeechPathologyProviderCountryCode = speechPathologyProviderCountryCode;
    }

    public String getSpeechPathologyProviderFullName() {
        return SpeechPathologyProviderFullName;
    }

    public void setSpeechPathologyProviderFullName(String speechPathologyProviderFullName) {
        SpeechPathologyProviderFullName = speechPathologyProviderFullName;
    }

    public String getSpeechPathologyDetailStatus() {
        return SpeechPathologyDetailStatus;
    }

    public void setSpeechPathologyDetailStatus(String speechPathologyDetailStatus) {
        SpeechPathologyDetailStatus = speechPathologyDetailStatus;
    }

    @Override
    public String toString() {
        return "SpeechPathologyResponse{" +
                "id=" + id +
                ", SpeechPathologyRequestCategory='" + SpeechPathologyRequestCategory + '\'' +
                ", SpeechPathologyCertificationType='" + SpeechPathologyCertificationType + '\'' +
                ", SpeechPathologyServiceType='" + SpeechPathologyServiceType + '\'' +
                ", SpeechPathologyLevelOfService='" + SpeechPathologyLevelOfService + '\'' +
                ", SpeechPathologyVisit='" + SpeechPathologyVisit + '\'' +
                ", SpeechPathologyUnit='" + SpeechPathologyUnit + '\'' +
                ", SpeechPathologyCertificationAction='" + SpeechPathologyCertificationAction + '\'' +
                ", SpeechPathologyRejectionReason='" + SpeechPathologyRejectionReason + '\'' +
                ", SpeechPathologyRejectionReasonMSG='" + SpeechPathologyRejectionReasonMSG + '\'' +
                ", SpeechPathologyProviderFirstName='" + SpeechPathologyProviderFirstName + '\'' +
                ", SpeechPathologyPoviderLastName='" + SpeechPathologyPoviderLastName + '\'' +
                ", SpeechPathologyProviderMiddleName='" + SpeechPathologyProviderMiddleName + '\'' +
                ", SpeechPathologyProviderType='" + SpeechPathologyProviderType + '\'' +
                ", SpeechPathologyProviderIdentificationNumber='" + SpeechPathologyProviderIdentificationNumber + '\'' +
                ", SpeechPathologyProviderIdentificationNumberType='" + SpeechPathologyProviderIdentificationNumberType + '\'' +
                ", SpeechPathologyProviderSupplimentalId='" + SpeechPathologyProviderSupplimentalId + '\'' +
                ", SpeechPathologyProviderIdNumberType='" + SpeechPathologyProviderIdNumberType + '\'' +
                ", SpeechPathologyProviderRejectionReason='" + SpeechPathologyProviderRejectionReason + '\'' +
                ", SpeechPathologyProviderFollowUpActionDescription='" + SpeechPathologyProviderFollowUpActionDescription + '\'' +
                ", SpeechPathologyProviderAddress='" + SpeechPathologyProviderAddress + '\'' +
                ", SpeechPathologyProviderCity='" + SpeechPathologyProviderCity + '\'' +
                ", SpeechPathologyProviderState='" + SpeechPathologyProviderState + '\'' +
                ", SpeechPathologyProviderPostalCode='" + SpeechPathologyProviderPostalCode + '\'' +
                ", SpeechPathologyProviderCountryCode='" + SpeechPathologyProviderCountryCode + '\'' +
                ", SpeechPathologyProviderFullName='" + SpeechPathologyProviderFullName + '\'' +
                ", SpeechPathologyDetailStatus='" + SpeechPathologyDetailStatus + '\'' +
                '}';
    }
}
