package com.edination.api.preAuthorisation.model;

import javax.persistence.*;


@Entity
@Table(name = "SkilledNursingResponse")
public class SkilledNursingResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String SkilledNursingRequestCategory;
    private String SkilledNursingCertificationType;
    private String SkilledNursingServiceType;
    private String SkilledNursingLevelOfService;
    private String SkilledNursingVisit;
    private String SkilledNursingUnit;
    private String SkilledNursingCertificationAction;
    private String SkilledNursingRejectionReason;
    private String SkilledNursingRejectionReasonMSG;
    private String SkilledNursingProviderFirstName;
    private String SkilledNursingPoviderLastName;
    private String SkilledNursingProviderMiddleName;
    private String SkilledNursingProviderType;
    private String SkilledNursingProviderIdentificationNumber;
    private String SkilledNursingProviderIdentificationNumberType;
    private String SkilledNursingProviderSupplimentalId;
    private String SkilledNursingProviderIdNumberType;
    private String SkilledNursingProviderRejectionReason;
    private String SkilledNursingProviderFollowUpActionDescription;
    private String SkilledNursingProviderAddress;
    private String SkilledNursingProviderCity;
    private String SkilledNursingProviderState;
    private String SkilledNursingProviderPostalCode;
    private String SkilledNursingProviderCountryCode;
    private String SkilledNursingProviderFullName;
    private String SkilledNursingDetailStatus;
    public SkilledNursingResponse() {
    }

    public SkilledNursingResponse(String skilledNursingRequestCategory, String skilledNursingCertificationType, String skilledNursingServiceType, String skilledNursingLevelOfService, String skilledNursingVisit, String skilledNursingUnit, String skilledNursingCertificationAction, String skilledNursingRejectionReason, String skilledNursingRejectionReasonMSG, String skilledNursingProviderFirstName, String skilledNursingPoviderLastName, String skilledNursingProviderMiddleName, String skilledNursingProviderType, String skilledNursingProviderIdentificationNumber, String skilledNursingProviderIdentificationNumberType, String skilledNursingProviderSupplimentalId, String skilledNursingProviderIdNumberType, String skilledNursingProviderRejectionReason, String skilledNursingProviderFollowUpActionDescription, String skilledNursingProviderAddress, String skilledNursingProviderCity, String skilledNursingProviderState, String skilledNursingProviderPostalCode, String skilledNursingProviderCountryCode, String skilledNursingProviderFullName, String skilledNursingDetailStatus) {
        SkilledNursingRequestCategory = skilledNursingRequestCategory;
        SkilledNursingCertificationType = skilledNursingCertificationType;
        SkilledNursingServiceType = skilledNursingServiceType;
        SkilledNursingLevelOfService = skilledNursingLevelOfService;
        SkilledNursingVisit = skilledNursingVisit;
        SkilledNursingUnit = skilledNursingUnit;
        SkilledNursingCertificationAction = skilledNursingCertificationAction;
        SkilledNursingRejectionReason = skilledNursingRejectionReason;
        SkilledNursingRejectionReasonMSG = skilledNursingRejectionReasonMSG;
        SkilledNursingProviderFirstName = skilledNursingProviderFirstName;
        SkilledNursingPoviderLastName = skilledNursingPoviderLastName;
        SkilledNursingProviderMiddleName = skilledNursingProviderMiddleName;
        SkilledNursingProviderType = skilledNursingProviderType;
        SkilledNursingProviderIdentificationNumber = skilledNursingProviderIdentificationNumber;
        SkilledNursingProviderIdentificationNumberType = skilledNursingProviderIdentificationNumberType;
        SkilledNursingProviderSupplimentalId = skilledNursingProviderSupplimentalId;
        SkilledNursingProviderIdNumberType = skilledNursingProviderIdNumberType;
        SkilledNursingProviderRejectionReason = skilledNursingProviderRejectionReason;
        SkilledNursingProviderFollowUpActionDescription = skilledNursingProviderFollowUpActionDescription;
        SkilledNursingProviderAddress = skilledNursingProviderAddress;
        SkilledNursingProviderCity = skilledNursingProviderCity;
        SkilledNursingProviderState = skilledNursingProviderState;
        SkilledNursingProviderPostalCode = skilledNursingProviderPostalCode;
        SkilledNursingProviderCountryCode = skilledNursingProviderCountryCode;
        SkilledNursingProviderFullName = skilledNursingProviderFullName;
        SkilledNursingDetailStatus = skilledNursingDetailStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSkilledNursingRequestCategory() {
        return SkilledNursingRequestCategory;
    }

    public void setSkilledNursingRequestCategory(String skilledNursingRequestCategory) {
        SkilledNursingRequestCategory = skilledNursingRequestCategory;
    }

    public String getSkilledNursingCertificationType() {
        return SkilledNursingCertificationType;
    }

    public void setSkilledNursingCertificationType(String skilledNursingCertificationType) {
        SkilledNursingCertificationType = skilledNursingCertificationType;
    }

    public String getSkilledNursingServiceType() {
        return SkilledNursingServiceType;
    }

    public void setSkilledNursingServiceType(String skilledNursingServiceType) {
        SkilledNursingServiceType = skilledNursingServiceType;
    }

    public String getSkilledNursingLevelOfService() {
        return SkilledNursingLevelOfService;
    }

    public void setSkilledNursingLevelOfService(String skilledNursingLevelOfService) {
        SkilledNursingLevelOfService = skilledNursingLevelOfService;
    }

    public String getSkilledNursingVisit() {
        return SkilledNursingVisit;
    }

    public void setSkilledNursingVisit(String skilledNursingVisit) {
        SkilledNursingVisit = skilledNursingVisit;
    }

    public String getSkilledNursingUnit() {
        return SkilledNursingUnit;
    }

    public void setSkilledNursingUnit(String skilledNursingUnit) {
        SkilledNursingUnit = skilledNursingUnit;
    }

    public String getSkilledNursingCertificationAction() {
        return SkilledNursingCertificationAction;
    }

    public void setSkilledNursingCertificationAction(String skilledNursingCertificationAction) {
        SkilledNursingCertificationAction = skilledNursingCertificationAction;
    }

    public String getSkilledNursingRejectionReason() {
        return SkilledNursingRejectionReason;
    }

    public void setSkilledNursingRejectionReason(String skilledNursingRejectionReason) {
        SkilledNursingRejectionReason = skilledNursingRejectionReason;
    }

    public String getSkilledNursingRejectionReasonMSG() {
        return SkilledNursingRejectionReasonMSG;
    }

    public void setSkilledNursingRejectionReasonMSG(String skilledNursingRejectionReasonMSG) {
        SkilledNursingRejectionReasonMSG = skilledNursingRejectionReasonMSG;
    }

    public String getSkilledNursingProviderFirstName() {
        return SkilledNursingProviderFirstName;
    }

    public void setSkilledNursingProviderFirstName(String skilledNursingProviderFirstName) {
        SkilledNursingProviderFirstName = skilledNursingProviderFirstName;
    }

    public String getSkilledNursingPoviderLastName() {
        return SkilledNursingPoviderLastName;
    }

    public void setSkilledNursingPoviderLastName(String skilledNursingPoviderLastName) {
        SkilledNursingPoviderLastName = skilledNursingPoviderLastName;
    }

    public String getSkilledNursingProviderMiddleName() {
        return SkilledNursingProviderMiddleName;
    }

    public void setSkilledNursingProviderMiddleName(String skilledNursingProviderMiddleName) {
        SkilledNursingProviderMiddleName = skilledNursingProviderMiddleName;
    }

    public String getSkilledNursingProviderType() {
        return SkilledNursingProviderType;
    }

    public void setSkilledNursingProviderType(String skilledNursingProviderType) {
        SkilledNursingProviderType = skilledNursingProviderType;
    }

    public String getSkilledNursingProviderIdentificationNumber() {
        return SkilledNursingProviderIdentificationNumber;
    }

    public void setSkilledNursingProviderIdentificationNumber(String skilledNursingProviderIdentificationNumber) {
        SkilledNursingProviderIdentificationNumber = skilledNursingProviderIdentificationNumber;
    }

    public String getSkilledNursingProviderIdentificationNumberType() {
        return SkilledNursingProviderIdentificationNumberType;
    }

    public void setSkilledNursingProviderIdentificationNumberType(String skilledNursingProviderIdentificationNumberType) {
        SkilledNursingProviderIdentificationNumberType = skilledNursingProviderIdentificationNumberType;
    }

    public String getSkilledNursingProviderSupplimentalId() {
        return SkilledNursingProviderSupplimentalId;
    }

    public void setSkilledNursingProviderSupplimentalId(String skilledNursingProviderSupplimentalId) {
        SkilledNursingProviderSupplimentalId = skilledNursingProviderSupplimentalId;
    }

    public String getSkilledNursingProviderIdNumberType() {
        return SkilledNursingProviderIdNumberType;
    }

    public void setSkilledNursingProviderIdNumberType(String skilledNursingProviderIdNumberType) {
        SkilledNursingProviderIdNumberType = skilledNursingProviderIdNumberType;
    }

    public String getSkilledNursingProviderRejectionReason() {
        return SkilledNursingProviderRejectionReason;
    }

    public void setSkilledNursingProviderRejectionReason(String skilledNursingProviderRejectionReason) {
        SkilledNursingProviderRejectionReason = skilledNursingProviderRejectionReason;
    }

    public String getSkilledNursingProviderFollowUpActionDescription() {
        return SkilledNursingProviderFollowUpActionDescription;
    }

    public void setSkilledNursingProviderFollowUpActionDescription(String skilledNursingProviderFollowUpActionDescription) {
        SkilledNursingProviderFollowUpActionDescription = skilledNursingProviderFollowUpActionDescription;
    }

    public String getSkilledNursingProviderAddress() {
        return SkilledNursingProviderAddress;
    }

    public void setSkilledNursingProviderAddress(String skilledNursingProviderAddress) {
        SkilledNursingProviderAddress = skilledNursingProviderAddress;
    }

    public String getSkilledNursingProviderCity() {
        return SkilledNursingProviderCity;
    }

    public void setSkilledNursingProviderCity(String skilledNursingProviderCity) {
        SkilledNursingProviderCity = skilledNursingProviderCity;
    }

    public String getSkilledNursingProviderState() {
        return SkilledNursingProviderState;
    }

    public void setSkilledNursingProviderState(String skilledNursingProviderState) {
        SkilledNursingProviderState = skilledNursingProviderState;
    }

    public String getSkilledNursingProviderPostalCode() {
        return SkilledNursingProviderPostalCode;
    }

    public void setSkilledNursingProviderPostalCode(String skilledNursingProviderPostalCode) {
        SkilledNursingProviderPostalCode = skilledNursingProviderPostalCode;
    }

    public String getSkilledNursingProviderCountryCode() {
        return SkilledNursingProviderCountryCode;
    }

    public void setSkilledNursingProviderCountryCode(String skilledNursingProviderCountryCode) {
        SkilledNursingProviderCountryCode = skilledNursingProviderCountryCode;
    }

    public String getSkilledNursingProviderFullName() {
        return SkilledNursingProviderFullName;
    }

    public void setSkilledNursingProviderFullName(String skilledNursingProviderFullName) {
        SkilledNursingProviderFullName = skilledNursingProviderFullName;
    }

    public String getSkilledNursingDetailStatus() {
        return SkilledNursingDetailStatus;
    }

    public void setSkilledNursingDetailStatus(String skilledNursingDetailStatus) {
        SkilledNursingDetailStatus = skilledNursingDetailStatus;
    }

    @Override
    public String toString() {
        return "SkilledNursingResponse{" +
                "id=" + id +
                ", SkilledNursingRequestCategory='" + SkilledNursingRequestCategory + '\'' +
                ", SkilledNursingCertificationType='" + SkilledNursingCertificationType + '\'' +
                ", SkilledNursingServiceType='" + SkilledNursingServiceType + '\'' +
                ", SkilledNursingLevelOfService='" + SkilledNursingLevelOfService + '\'' +
                ", SkilledNursingVisit='" + SkilledNursingVisit + '\'' +
                ", SkilledNursingUnit='" + SkilledNursingUnit + '\'' +
                ", SkilledNursingCertificationAction='" + SkilledNursingCertificationAction + '\'' +
                ", SkilledNursingRejectionReason='" + SkilledNursingRejectionReason + '\'' +
                ", SkilledNursingRejectionReasonMSG='" + SkilledNursingRejectionReasonMSG + '\'' +
                ", SkilledNursingProviderFirstName='" + SkilledNursingProviderFirstName + '\'' +
                ", SkilledNursingPoviderLastName='" + SkilledNursingPoviderLastName + '\'' +
                ", SkilledNursingProviderMiddleName='" + SkilledNursingProviderMiddleName + '\'' +
                ", SkilledNursingProviderType='" + SkilledNursingProviderType + '\'' +
                ", SkilledNursingProviderIdentificationNumber='" + SkilledNursingProviderIdentificationNumber + '\'' +
                ", SkilledNursingProviderIdentificationNumberType='" + SkilledNursingProviderIdentificationNumberType + '\'' +
                ", SkilledNursingProviderSupplimentalId='" + SkilledNursingProviderSupplimentalId + '\'' +
                ", SkilledNursingProviderIdNumberType='" + SkilledNursingProviderIdNumberType + '\'' +
                ", SkilledNursingProviderRejectionReason='" + SkilledNursingProviderRejectionReason + '\'' +
                ", SkilledNursingProviderFollowUpActionDescription='" + SkilledNursingProviderFollowUpActionDescription + '\'' +
                ", SkilledNursingProviderAddress='" + SkilledNursingProviderAddress + '\'' +
                ", SkilledNursingProviderCity='" + SkilledNursingProviderCity + '\'' +
                ", SkilledNursingProviderState='" + SkilledNursingProviderState + '\'' +
                ", SkilledNursingProviderPostalCode='" + SkilledNursingProviderPostalCode + '\'' +
                ", SkilledNursingProviderCountryCode='" + SkilledNursingProviderCountryCode + '\'' +
                ", SkilledNursingProviderFullName='" + SkilledNursingProviderFullName + '\'' +
                ", SkilledNursingDetailStatus='" + SkilledNursingDetailStatus + '\'' +
                '}';
    }
}