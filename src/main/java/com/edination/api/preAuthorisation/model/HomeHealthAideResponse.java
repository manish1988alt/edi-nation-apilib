package com.edination.api.preAuthorisation.model;

import javax.persistence.*;


@Entity
@Table(name = "HomeHealthAideResponse")
public class HomeHealthAideResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String HomeHealthAideRequestCategory;
    private String HomeHealthAideCertificationType;
    private String HomeHealthAideServiceType;
    private String HomeHealthAideLevelOfService;
    private String HomeHealthAideVisit;
    private String HomeHealthAideUnit;
    private String HomeHealthAideCertificationAction;
    private String HomeHealthAideRejectionReason;
    private String HomeHealthAideRejectionReasonMSG;
    private String HomeHealthAideProviderFirstName;
    private String HomeHealthAidePoviderLastName;
    private String HomeHealthAideProviderMiddleName;
    private String HomeHealthAideProviderType;
    private String HomeHealthAideProviderIdentificationNumber;
    private String HomeHealthAideProviderIdentificationNumberType;
    private String HomeHealthAideProviderSupplimentalId;
    private String HomeHealthAideProviderIdNumberType;
    private String HomeHealthAideProviderRejectionReason;
    private String HomeHealthAideProviderFollowUpActionDescription;
    private String HomeHealthAideProviderAddress;
    private String HomeHealthAideProviderCity;
    private String HomeHealthAideProviderState;
    private String HomeHealthAideProviderPostalCode;
    private String HomeHealthAideProviderCountryCode;
    private String HomeHealthAideProviderFullName;
    private String HomeHealthAideDetailStatus;
    public HomeHealthAideResponse() {
    }

    public HomeHealthAideResponse(String homeHealthAideRequestCategory, String homeHealthAideCertificationType, String homeHealthAideServiceType, String homeHealthAideLevelOfService, String homeHealthAideVisit, String homeHealthAideUnit, String homeHealthAideCertificationAction, String homeHealthAideRejectionReason, String homeHealthAideRejectionReasonMSG, String homeHealthAideProviderFirstName, String homeHealthAidePoviderLastName, String homeHealthAideProviderMiddleName, String homeHealthAideProviderType, String homeHealthAideProviderIdentificationNumber, String homeHealthAideProviderIdentificationNumberType, String homeHealthAideProviderSupplimentalId, String homeHealthAideProviderIdNumberType, String homeHealthAideProviderRejectionReason, String homeHealthAideProviderFollowUpActionDescription, String homeHealthAideProviderAddress, String homeHealthAideProviderCity, String homeHealthAideProviderState, String homeHealthAideProviderPostalCode, String homeHealthAideProviderCountryCode, String homeHealthAideProviderFullName, String homeHealthAideDetailStatus) {
        HomeHealthAideRequestCategory = homeHealthAideRequestCategory;
        HomeHealthAideCertificationType = homeHealthAideCertificationType;
        HomeHealthAideServiceType = homeHealthAideServiceType;
        HomeHealthAideLevelOfService = homeHealthAideLevelOfService;
        HomeHealthAideVisit = homeHealthAideVisit;
        HomeHealthAideUnit = homeHealthAideUnit;
        HomeHealthAideCertificationAction = homeHealthAideCertificationAction;
        HomeHealthAideRejectionReason = homeHealthAideRejectionReason;
        HomeHealthAideRejectionReasonMSG = homeHealthAideRejectionReasonMSG;
        HomeHealthAideProviderFirstName = homeHealthAideProviderFirstName;
        HomeHealthAidePoviderLastName = homeHealthAidePoviderLastName;
        HomeHealthAideProviderMiddleName = homeHealthAideProviderMiddleName;
        HomeHealthAideProviderType = homeHealthAideProviderType;
        HomeHealthAideProviderIdentificationNumber = homeHealthAideProviderIdentificationNumber;
        HomeHealthAideProviderIdentificationNumberType = homeHealthAideProviderIdentificationNumberType;
        HomeHealthAideProviderSupplimentalId = homeHealthAideProviderSupplimentalId;
        HomeHealthAideProviderIdNumberType = homeHealthAideProviderIdNumberType;
        HomeHealthAideProviderRejectionReason = homeHealthAideProviderRejectionReason;
        HomeHealthAideProviderFollowUpActionDescription = homeHealthAideProviderFollowUpActionDescription;
        HomeHealthAideProviderAddress = homeHealthAideProviderAddress;
        HomeHealthAideProviderCity = homeHealthAideProviderCity;
        HomeHealthAideProviderState = homeHealthAideProviderState;
        HomeHealthAideProviderPostalCode = homeHealthAideProviderPostalCode;
        HomeHealthAideProviderCountryCode = homeHealthAideProviderCountryCode;
        HomeHealthAideProviderFullName = homeHealthAideProviderFullName;
        HomeHealthAideDetailStatus = homeHealthAideDetailStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHomeHealthAideRequestCategory() {
        return HomeHealthAideRequestCategory;
    }

    public void setHomeHealthAideRequestCategory(String homeHealthAideRequestCategory) {
        HomeHealthAideRequestCategory = homeHealthAideRequestCategory;
    }

    public String getHomeHealthAideCertificationType() {
        return HomeHealthAideCertificationType;
    }

    public void setHomeHealthAideCertificationType(String homeHealthAideCertificationType) {
        HomeHealthAideCertificationType = homeHealthAideCertificationType;
    }

    public String getHomeHealthAideServiceType() {
        return HomeHealthAideServiceType;
    }

    public void setHomeHealthAideServiceType(String homeHealthAideServiceType) {
        HomeHealthAideServiceType = homeHealthAideServiceType;
    }

    public String getHomeHealthAideLevelOfService() {
        return HomeHealthAideLevelOfService;
    }

    public void setHomeHealthAideLevelOfService(String homeHealthAideLevelOfService) {
        HomeHealthAideLevelOfService = homeHealthAideLevelOfService;
    }

    public String getHomeHealthAideVisit() {
        return HomeHealthAideVisit;
    }

    public void setHomeHealthAideVisit(String homeHealthAideVisit) {
        HomeHealthAideVisit = homeHealthAideVisit;
    }

    public String getHomeHealthAideUnit() {
        return HomeHealthAideUnit;
    }

    public void setHomeHealthAideUnit(String homeHealthAideUnit) {
        HomeHealthAideUnit = homeHealthAideUnit;
    }

    public String getHomeHealthAideCertificationAction() {
        return HomeHealthAideCertificationAction;
    }

    public void setHomeHealthAideCertificationAction(String homeHealthAideCertificationAction) {
        HomeHealthAideCertificationAction = homeHealthAideCertificationAction;
    }

    public String getHomeHealthAideRejectionReason() {
        return HomeHealthAideRejectionReason;
    }

    public void setHomeHealthAideRejectionReason(String homeHealthAideRejectionReason) {
        HomeHealthAideRejectionReason = homeHealthAideRejectionReason;
    }

    public String getHomeHealthAideRejectionReasonMSG() {
        return HomeHealthAideRejectionReasonMSG;
    }

    public void setHomeHealthAideRejectionReasonMSG(String homeHealthAideRejectionReasonMSG) {
        HomeHealthAideRejectionReasonMSG = homeHealthAideRejectionReasonMSG;
    }

    public String getHomeHealthAideProviderFirstName() {
        return HomeHealthAideProviderFirstName;
    }

    public void setHomeHealthAideProviderFirstName(String homeHealthAideProviderFirstName) {
        HomeHealthAideProviderFirstName = homeHealthAideProviderFirstName;
    }

    public String getHomeHealthAidePoviderLastName() {
        return HomeHealthAidePoviderLastName;
    }

    public void setHomeHealthAidePoviderLastName(String homeHealthAidePoviderLastName) {
        HomeHealthAidePoviderLastName = homeHealthAidePoviderLastName;
    }

    public String getHomeHealthAideProviderMiddleName() {
        return HomeHealthAideProviderMiddleName;
    }

    public void setHomeHealthAideProviderMiddleName(String homeHealthAideProviderMiddleName) {
        HomeHealthAideProviderMiddleName = homeHealthAideProviderMiddleName;
    }

    public String getHomeHealthAideProviderType() {
        return HomeHealthAideProviderType;
    }

    public void setHomeHealthAideProviderType(String homeHealthAideProviderType) {
        HomeHealthAideProviderType = homeHealthAideProviderType;
    }

    public String getHomeHealthAideProviderIdentificationNumber() {
        return HomeHealthAideProviderIdentificationNumber;
    }

    public void setHomeHealthAideProviderIdentificationNumber(String homeHealthAideProviderIdentificationNumber) {
        HomeHealthAideProviderIdentificationNumber = homeHealthAideProviderIdentificationNumber;
    }

    public String getHomeHealthAideProviderIdentificationNumberType() {
        return HomeHealthAideProviderIdentificationNumberType;
    }

    public void setHomeHealthAideProviderIdentificationNumberType(String homeHealthAideProviderIdentificationNumberType) {
        HomeHealthAideProviderIdentificationNumberType = homeHealthAideProviderIdentificationNumberType;
    }

    public String getHomeHealthAideProviderSupplimentalId() {
        return HomeHealthAideProviderSupplimentalId;
    }

    public void setHomeHealthAideProviderSupplimentalId(String homeHealthAideProviderSupplimentalId) {
        HomeHealthAideProviderSupplimentalId = homeHealthAideProviderSupplimentalId;
    }

    public String getHomeHealthAideProviderIdNumberType() {
        return HomeHealthAideProviderIdNumberType;
    }

    public void setHomeHealthAideProviderIdNumberType(String homeHealthAideProviderIdNumberType) {
        HomeHealthAideProviderIdNumberType = homeHealthAideProviderIdNumberType;
    }

    public String getHomeHealthAideProviderRejectionReason() {
        return HomeHealthAideProviderRejectionReason;
    }

    public void setHomeHealthAideProviderRejectionReason(String homeHealthAideProviderRejectionReason) {
        HomeHealthAideProviderRejectionReason = homeHealthAideProviderRejectionReason;
    }

    public String getHomeHealthAideProviderFollowUpActionDescription() {
        return HomeHealthAideProviderFollowUpActionDescription;
    }

    public void setHomeHealthAideProviderFollowUpActionDescription(String homeHealthAideProviderFollowUpActionDescription) {
        HomeHealthAideProviderFollowUpActionDescription = homeHealthAideProviderFollowUpActionDescription;
    }

    public String getHomeHealthAideProviderAddress() {
        return HomeHealthAideProviderAddress;
    }

    public void setHomeHealthAideProviderAddress(String homeHealthAideProviderAddress) {
        HomeHealthAideProviderAddress = homeHealthAideProviderAddress;
    }

    public String getHomeHealthAideProviderCity() {
        return HomeHealthAideProviderCity;
    }

    public void setHomeHealthAideProviderCity(String homeHealthAideProviderCity) {
        HomeHealthAideProviderCity = homeHealthAideProviderCity;
    }

    public String getHomeHealthAideProviderState() {
        return HomeHealthAideProviderState;
    }

    public void setHomeHealthAideProviderState(String homeHealthAideProviderState) {
        HomeHealthAideProviderState = homeHealthAideProviderState;
    }

    public String getHomeHealthAideProviderPostalCode() {
        return HomeHealthAideProviderPostalCode;
    }

    public void setHomeHealthAideProviderPostalCode(String homeHealthAideProviderPostalCode) {
        HomeHealthAideProviderPostalCode = homeHealthAideProviderPostalCode;
    }

    public String getHomeHealthAideProviderCountryCode() {
        return HomeHealthAideProviderCountryCode;
    }

    public void setHomeHealthAideProviderCountryCode(String homeHealthAideProviderCountryCode) {
        HomeHealthAideProviderCountryCode = homeHealthAideProviderCountryCode;
    }

    public String getHomeHealthAideProviderFullName() {
        return HomeHealthAideProviderFullName;
    }

    public void setHomeHealthAideProviderFullName(String homeHealthAideProviderFullName) {
        HomeHealthAideProviderFullName = homeHealthAideProviderFullName;
    }

    public String getHomeHealthAideDetailStatus() {
        return HomeHealthAideDetailStatus;
    }

    public void setHomeHealthAideDetailStatus(String homeHealthAideDetailStatus) {
        HomeHealthAideDetailStatus = homeHealthAideDetailStatus;
    }

    @Override
    public String toString() {
        return "HomeHealthAideResponse{" +
                "id=" + id +
                ", HomeHealthAideRequestCategory='" + HomeHealthAideRequestCategory + '\'' +
                ", HomeHealthAideCertificationType='" + HomeHealthAideCertificationType + '\'' +
                ", HomeHealthAideServiceType='" + HomeHealthAideServiceType + '\'' +
                ", HomeHealthAideLevelOfService='" + HomeHealthAideLevelOfService + '\'' +
                ", HomeHealthAideVisit='" + HomeHealthAideVisit + '\'' +
                ", HomeHealthAideUnit='" + HomeHealthAideUnit + '\'' +
                ", HomeHealthAideCertificationAction='" + HomeHealthAideCertificationAction + '\'' +
                ", HomeHealthAideRejectionReason='" + HomeHealthAideRejectionReason + '\'' +
                ", HomeHealthAideRejectionReasonMSG='" + HomeHealthAideRejectionReasonMSG + '\'' +
                ", HomeHealthAideProviderFirstName='" + HomeHealthAideProviderFirstName + '\'' +
                ", HomeHealthAidePoviderLastName='" + HomeHealthAidePoviderLastName + '\'' +
                ", HomeHealthAideProviderMiddleName='" + HomeHealthAideProviderMiddleName + '\'' +
                ", HomeHealthAideProviderType='" + HomeHealthAideProviderType + '\'' +
                ", HomeHealthAideProviderIdentificationNumber='" + HomeHealthAideProviderIdentificationNumber + '\'' +
                ", HomeHealthAideProviderIdentificationNumberType='" + HomeHealthAideProviderIdentificationNumberType + '\'' +
                ", HomeHealthAideProviderSupplimentalId='" + HomeHealthAideProviderSupplimentalId + '\'' +
                ", HomeHealthAideProviderIdNumberType='" + HomeHealthAideProviderIdNumberType + '\'' +
                ", HomeHealthAideProviderRejectionReason='" + HomeHealthAideProviderRejectionReason + '\'' +
                ", HomeHealthAideProviderFollowUpActionDescription='" + HomeHealthAideProviderFollowUpActionDescription + '\'' +
                ", HomeHealthAideProviderAddress='" + HomeHealthAideProviderAddress + '\'' +
                ", HomeHealthAideProviderCity='" + HomeHealthAideProviderCity + '\'' +
                ", HomeHealthAideProviderState='" + HomeHealthAideProviderState + '\'' +
                ", HomeHealthAideProviderPostalCode='" + HomeHealthAideProviderPostalCode + '\'' +
                ", HomeHealthAideProviderCountryCode='" + HomeHealthAideProviderCountryCode + '\'' +
                ", HomeHealthAideProviderFullName='" + HomeHealthAideProviderFullName + '\'' +
                ", HomeHealthAideDetailStatus='" + HomeHealthAideDetailStatus + '\'' +
                '}';
    }
}
