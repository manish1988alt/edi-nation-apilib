package com.edination.api.preAuthorisation.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "PhysicalTherapyResponse")
public class PhysicalTherapyResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String physicalTherapyRequestCategory;
    private String physicalTherapyCertificationType;
    private String physicalTherapyServiceType;
    private String physicalTherapyLevelOfService;
    private String physicalTherapyVisit;
    private String physicalTherapyUnit;
    private String physicalTherapyCertificationAction;
    private String physicalTherapyRejectionReason;
    private String physicalTherapyRejectionReasonMSG;
    private String physicalTherapyProviderFirstName;
    private String physicalTherapyPoviderLastName;
    private String physicalTherapyProviderMiddleName;
    private String physicalTherapyProviderSuffix;
    private String physicalTherapyProviderPrefix;
    private LocalDate physicalTherapyResponseServiceDateFrom;
    private LocalDate physicalTherapyResponseServiceDateTo;
    private int physicalTherapyRevenueCode;
    private String mrnNumber;
    private String physicalTherapyProviderType;
    private String physicalTherapyProviderIdentificationNumber;
    private String physicalTherapyProviderIdentificationNumberType;
    private String physicalTherapyProviderSupplimentalId;
    private String physicalTherapyProviderIdNumberType;
    private String physicalTherapyProviderRejectionReason;
    private String physicalTherapyProviderFollowUpActionDescription;
    private String physicalTherapyProviderAddress;
    private String physicalTherapyProviderCity;
    private String physicalTherapyProviderState;
    private String physicalTherapyProviderPostalCode;
    private String physicalTherapyProviderCountryCode;
    private String physicalTherapyProviderFullName;
    private String physicalTherapyDetailStatus;
    private String physicalTherapyAuthorizationIdNo;
    private LocalDate physicalTherapyEffectiveDateFrom;
    private LocalDate physicalTherapyEffectiveDateTo;
    private LocalDate physicalTherapyExpirationDate;
    private boolean physicalTherapySelected;
    public PhysicalTherapyResponse() {
    }


    public PhysicalTherapyResponse(String physicalTherapyRequestCategory, String physicalTherapyCertificationType, String physicalTherapyServiceType, String physicalTherapyLevelOfService, String physicalTherapyVisit, String physicalTherapyUnit, String physicalTherapyCertificationAction, String physicalTherapyRejectionReason, String physicalTherapyRejectionReasonMSG, String physicalTherapyProviderFirstName, String physicalTherapyPoviderLastName, String physicalTherapyProviderMiddleName, String physicalTherapyProviderSuffix, String physicalTherapyProviderPrefix, LocalDate physicalTherapyResponseServiceDateFrom, LocalDate physicalTherapyResponseServiceDateTo, int physicalTherapyRevenueCode, String mrnNumber, String physicalTherapyProviderType, String physicalTherapyProviderIdentificationNumber, String physicalTherapyProviderIdentificationNumberType, String physicalTherapyProviderSupplimentalId, String physicalTherapyProviderIdNumberType, String physicalTherapyProviderRejectionReason, String physicalTherapyProviderFollowUpActionDescription, String physicalTherapyProviderAddress, String physicalTherapyProviderCity, String physicalTherapyProviderState, String physicalTherapyProviderPostalCode, String physicalTherapyProviderCountryCode, String physicalTherapyProviderFullName, String physicalTherapyDetailStatus, String physicalTherapyAuthorizationIdNo, LocalDate physicalTherapyEffectiveDateFrom, LocalDate physicalTherapyEffectiveDateTo, LocalDate physicalTherapyExpirationDate, boolean physicalTherapySelected) {
        this.physicalTherapyRequestCategory = physicalTherapyRequestCategory;
        this.physicalTherapyCertificationType = physicalTherapyCertificationType;
        this.physicalTherapyServiceType = physicalTherapyServiceType;
        this.physicalTherapyLevelOfService = physicalTherapyLevelOfService;
        this.physicalTherapyVisit = physicalTherapyVisit;
        this.physicalTherapyUnit = physicalTherapyUnit;
        this.physicalTherapyCertificationAction = physicalTherapyCertificationAction;
        this.physicalTherapyRejectionReason = physicalTherapyRejectionReason;
        this.physicalTherapyRejectionReasonMSG = physicalTherapyRejectionReasonMSG;
        this.physicalTherapyProviderFirstName = physicalTherapyProviderFirstName;
        this.physicalTherapyPoviderLastName = physicalTherapyPoviderLastName;
        this.physicalTherapyProviderMiddleName = physicalTherapyProviderMiddleName;
        this.physicalTherapyProviderSuffix = physicalTherapyProviderSuffix;
        this.physicalTherapyProviderPrefix = physicalTherapyProviderPrefix;
        this.physicalTherapyResponseServiceDateFrom = physicalTherapyResponseServiceDateFrom;
        this.physicalTherapyResponseServiceDateTo = physicalTherapyResponseServiceDateTo;
        this.physicalTherapyRevenueCode = physicalTherapyRevenueCode;
        this.mrnNumber = mrnNumber;
        this.physicalTherapyProviderType = physicalTherapyProviderType;
        this.physicalTherapyProviderIdentificationNumber = physicalTherapyProviderIdentificationNumber;
        this.physicalTherapyProviderIdentificationNumberType = physicalTherapyProviderIdentificationNumberType;
        this.physicalTherapyProviderSupplimentalId = physicalTherapyProviderSupplimentalId;
        this.physicalTherapyProviderIdNumberType = physicalTherapyProviderIdNumberType;
        this.physicalTherapyProviderRejectionReason = physicalTherapyProviderRejectionReason;
        this.physicalTherapyProviderFollowUpActionDescription = physicalTherapyProviderFollowUpActionDescription;
        this.physicalTherapyProviderAddress = physicalTherapyProviderAddress;
        this.physicalTherapyProviderCity = physicalTherapyProviderCity;
        this.physicalTherapyProviderState = physicalTherapyProviderState;
        this.physicalTherapyProviderPostalCode = physicalTherapyProviderPostalCode;
        this.physicalTherapyProviderCountryCode = physicalTherapyProviderCountryCode;
        this.physicalTherapyProviderFullName = physicalTherapyProviderFullName;
        this.physicalTherapyDetailStatus = physicalTherapyDetailStatus;
        this.physicalTherapyAuthorizationIdNo = physicalTherapyAuthorizationIdNo;
        this.physicalTherapyEffectiveDateFrom = physicalTherapyEffectiveDateFrom;
        this.physicalTherapyEffectiveDateTo = physicalTherapyEffectiveDateTo;
        this.physicalTherapyExpirationDate = physicalTherapyExpirationDate;
        this.physicalTherapySelected = physicalTherapySelected;
    }

    public String getPhysicalTherapyAuthorizationIdNo() {
        return physicalTherapyAuthorizationIdNo;
    }

    public void setPhysicalTherapyAuthorizationIdNo(String physicalTherapyAuthorizationIdNo) {
        this.physicalTherapyAuthorizationIdNo = physicalTherapyAuthorizationIdNo;
    }

    public LocalDate getPhysicalTherapyEffectiveDateFrom() {
        return physicalTherapyEffectiveDateFrom;
    }

    public void setPhysicalTherapyEffectiveDateFrom(LocalDate physicalTherapyEffectiveDateFrom) {
        this.physicalTherapyEffectiveDateFrom = physicalTherapyEffectiveDateFrom;
    }

    public LocalDate getPhysicalTherapyEffectiveDateTo() {
        return physicalTherapyEffectiveDateTo;
    }

    public void setPhysicalTherapyEffectiveDateTo(LocalDate physicalTherapyEffectiveDateTo) {
        this.physicalTherapyEffectiveDateTo = physicalTherapyEffectiveDateTo;
    }

    public LocalDate getPhysicalTherapyExpirationDate() {
        return physicalTherapyExpirationDate;
    }

    public void setPhysicalTherapyExpirationDate(LocalDate physicalTherapyExpirationDate) {
        this.physicalTherapyExpirationDate = physicalTherapyExpirationDate;
    }

    public boolean getPhysicalTherapySelected() {
        return physicalTherapySelected;
    }

    public void setPhysicalTherapySelected(boolean physicalTherapySelected) {
        this.physicalTherapySelected = physicalTherapySelected;
    }

    public String getPhysicalTherapyProviderSuffix() {
        return physicalTherapyProviderSuffix;
    }

    public void setPhysicalTherapyProviderSuffix(String physicalTherapyProviderSuffix) {
        this.physicalTherapyProviderSuffix = physicalTherapyProviderSuffix;
    }

    public String getPhysicalTherapyProviderPrefix() {
        return physicalTherapyProviderPrefix;
    }

    public void setPhysicalTherapyProviderPrefix(String physicalTherapyProviderPrefix) {
        this.physicalTherapyProviderPrefix = physicalTherapyProviderPrefix;
    }

    public LocalDate getPhysicalTherapyResponseServiceDateFrom() {
        return physicalTherapyResponseServiceDateFrom;
    }

    public void setPhysicalTherapyResponseServiceDateFrom(LocalDate physicalTherapyResponseServiceDateFrom) {
        this.physicalTherapyResponseServiceDateFrom = physicalTherapyResponseServiceDateFrom;
    }

    public LocalDate getPhysicalTherapyResponseServiceDateTo() {
        return physicalTherapyResponseServiceDateTo;
    }

    public void setPhysicalTherapyResponseServiceDateTo(LocalDate physicalTherapyResponseServiceDateTo) {
        this.physicalTherapyResponseServiceDateTo = physicalTherapyResponseServiceDateTo;
    }

    public int getPhysicalTherapyRevenueCode() {
        return physicalTherapyRevenueCode;
    }

    public void setPhysicalTherapyRevenueCode(int physicalTherapyRevenueCode) {
        this.physicalTherapyRevenueCode = physicalTherapyRevenueCode;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhysicalTherapyRequestCategory() {
        return physicalTherapyRequestCategory;
    }

    public void setPhysicalTherapyRequestCategory(String physicalTherapyRequestCategory) {
        this.physicalTherapyRequestCategory = physicalTherapyRequestCategory;
    }

    public String getPhysicalTherapyCertificationType() {
        return physicalTherapyCertificationType;
    }

    public void setPhysicalTherapyCertificationType(String physicalTherapyCertificationType) {
        this.physicalTherapyCertificationType = physicalTherapyCertificationType;
    }

    public String getPhysicalTherapyServiceType() {
        return physicalTherapyServiceType;
    }

    public void setPhysicalTherapyServiceType(String physicalTherapyServiceType) {
        this.physicalTherapyServiceType = physicalTherapyServiceType;
    }

    public String getPhysicalTherapyLevelOfService() {
        return physicalTherapyLevelOfService;
    }

    public void setPhysicalTherapyLevelOfService(String physicalTherapyLevelOfService) {
        this.physicalTherapyLevelOfService = physicalTherapyLevelOfService;
    }

    public String getPhysicalTherapyVisit() {
        return physicalTherapyVisit;
    }

    public void setPhysicalTherapyVisit(String physicalTherapyVisit) {
        this.physicalTherapyVisit = physicalTherapyVisit;
    }

    public String getPhysicalTherapyUnit() {
        return physicalTherapyUnit;
    }

    public void setPhysicalTherapyUnit(String physicalTherapyUnit) {
        this.physicalTherapyUnit = physicalTherapyUnit;
    }

    public String getPhysicalTherapyCertificationAction() {
        return physicalTherapyCertificationAction;
    }

    public void setPhysicalTherapyCertificationAction(String physicalTherapyCertificationAction) {
        this.physicalTherapyCertificationAction = physicalTherapyCertificationAction;
    }

    public String getPhysicalTherapyRejectionReason() {
        return physicalTherapyRejectionReason;
    }

    public void setPhysicalTherapyRejectionReason(String physicalTherapyRejectionReason) {
        this.physicalTherapyRejectionReason = physicalTherapyRejectionReason;
    }

    public String getPhysicalTherapyRejectionReasonMSG() {
        return physicalTherapyRejectionReasonMSG;
    }

    public void setPhysicalTherapyRejectionReasonMSG(String physicalTherapyRejectionReasonMSG) {
        this.physicalTherapyRejectionReasonMSG = physicalTherapyRejectionReasonMSG;
    }

    public String getPhysicalTherapyProviderFirstName() {
        return physicalTherapyProviderFirstName;
    }

    public void setPhysicalTherapyProviderFirstName(String physicalTherapyProviderFirstName) {
        this.physicalTherapyProviderFirstName = physicalTherapyProviderFirstName;
    }

    public String getPhysicalTherapyPoviderLastName() {
        return physicalTherapyPoviderLastName;
    }

    public void setPhysicalTherapyPoviderLastName(String physicalTherapyPoviderLastName) {
        this.physicalTherapyPoviderLastName = physicalTherapyPoviderLastName;
    }

    public String getPhysicalTherapyProviderMiddleName() {
        return physicalTherapyProviderMiddleName;
    }

    public void setPhysicalTherapyProviderMiddleName(String physicalTherapyProviderMiddleName) {
        this.physicalTherapyProviderMiddleName = physicalTherapyProviderMiddleName;
    }

    public String getPhysicalTherapyProviderType() {
        return physicalTherapyProviderType;
    }

    public void setPhysicalTherapyProviderType(String physicalTherapyProviderType) {
        this.physicalTherapyProviderType = physicalTherapyProviderType;
    }

    public String getPhysicalTherapyProviderIdentificationNumber() {
        return physicalTherapyProviderIdentificationNumber;
    }

    public void setPhysicalTherapyProviderIdentificationNumber(String physicalTherapyProviderIdentificationNumber) {
        this.physicalTherapyProviderIdentificationNumber = physicalTherapyProviderIdentificationNumber;
    }

    public String getPhysicalTherapyProviderIdentificationNumberType() {
        return physicalTherapyProviderIdentificationNumberType;
    }

    public void setPhysicalTherapyProviderIdentificationNumberType(String physicalTherapyProviderIdentificationNumberType) {
        this.physicalTherapyProviderIdentificationNumberType = physicalTherapyProviderIdentificationNumberType;
    }

    public String getPhysicalTherapyProviderSupplimentalId() {
        return physicalTherapyProviderSupplimentalId;
    }

    public void setPhysicalTherapyProviderSupplimentalId(String physicalTherapyProviderSupplimentalId) {
        this.physicalTherapyProviderSupplimentalId = physicalTherapyProviderSupplimentalId;
    }

    public String getPhysicalTherapyProviderIdNumberType() {
        return physicalTherapyProviderIdNumberType;
    }

    public void setPhysicalTherapyProviderIdNumberType(String physicalTherapyProviderIdNumberType) {
        this.physicalTherapyProviderIdNumberType = physicalTherapyProviderIdNumberType;
    }

    public String getPhysicalTherapyProviderRejectionReason() {
        return physicalTherapyProviderRejectionReason;
    }

    public void setPhysicalTherapyProviderRejectionReason(String physicalTherapyProviderRejectionReason) {
        this.physicalTherapyProviderRejectionReason = physicalTherapyProviderRejectionReason;
    }

    public String getPhysicalTherapyProviderFollowUpActionDescription() {
        return physicalTherapyProviderFollowUpActionDescription;
    }

    public void setPhysicalTherapyProviderFollowUpActionDescription(String physicalTherapyProviderFollowUpActionDescription) {
        this.physicalTherapyProviderFollowUpActionDescription = physicalTherapyProviderFollowUpActionDescription;
    }

    public String getPhysicalTherapyProviderAddress() {
        return physicalTherapyProviderAddress;
    }

    public void setPhysicalTherapyProviderAddress(String physicalTherapyProviderAddress) {
        this.physicalTherapyProviderAddress = physicalTherapyProviderAddress;
    }

    public String getPhysicalTherapyProviderCity() {
        return physicalTherapyProviderCity;
    }

    public void setPhysicalTherapyProviderCity(String physicalTherapyProviderCity) {
        this.physicalTherapyProviderCity = physicalTherapyProviderCity;
    }

    public String getPhysicalTherapyProviderState() {
        return physicalTherapyProviderState;
    }

    public void setPhysicalTherapyProviderState(String physicalTherapyProviderState) {
        this.physicalTherapyProviderState = physicalTherapyProviderState;
    }

    public String getPhysicalTherapyProviderPostalCode() {
        return physicalTherapyProviderPostalCode;
    }

    public void setPhysicalTherapyProviderPostalCode(String physicalTherapyProviderPostalCode) {
        this.physicalTherapyProviderPostalCode = physicalTherapyProviderPostalCode;
    }

    public String getPhysicalTherapyProviderCountryCode() {
        return physicalTherapyProviderCountryCode;
    }

    public void setPhysicalTherapyProviderCountryCode(String physicalTherapyProviderCountryCode) {
        this.physicalTherapyProviderCountryCode = physicalTherapyProviderCountryCode;
    }

    public String getPhysicalTherapyProviderFullName() {
        return physicalTherapyProviderFullName;
    }

    public void setPhysicalTherapyProviderFullName(String physicalTherapyProviderFullName) {
        this.physicalTherapyProviderFullName = physicalTherapyProviderFullName;
    }

    public String getPhysicalTherapyDetailStatus() {
        return physicalTherapyDetailStatus;
    }

    public void setPhysicalTherapyDetailStatus(String physicalTherapyDetailStatus) {
        this.physicalTherapyDetailStatus = physicalTherapyDetailStatus;
    }

    @Override
    public String toString() {
        return "PhysicalTherapyResponse{" +
                "id=" + id +
                ", physicalTherapyRequestCategory='" + physicalTherapyRequestCategory + '\'' +
                ", physicalTherapyCertificationType='" + physicalTherapyCertificationType + '\'' +
                ", physicalTherapyServiceType='" + physicalTherapyServiceType + '\'' +
                ", physicalTherapyLevelOfService='" + physicalTherapyLevelOfService + '\'' +
                ", physicalTherapyVisit='" + physicalTherapyVisit + '\'' +
                ", physicalTherapyUnit='" + physicalTherapyUnit + '\'' +
                ", physicalTherapyCertificationAction='" + physicalTherapyCertificationAction + '\'' +
                ", physicalTherapyRejectionReason='" + physicalTherapyRejectionReason + '\'' +
                ", physicalTherapyRejectionReasonMSG='" + physicalTherapyRejectionReasonMSG + '\'' +
                ", physicalTherapyProviderFirstName='" + physicalTherapyProviderFirstName + '\'' +
                ", physicalTherapyPoviderLastName='" + physicalTherapyPoviderLastName + '\'' +
                ", physicalTherapyProviderMiddleName='" + physicalTherapyProviderMiddleName + '\'' +
                ", physicalTherapyProviderSuffix='" + physicalTherapyProviderSuffix + '\'' +
                ", physicalTherapyProviderPrefix='" + physicalTherapyProviderPrefix + '\'' +
                ", physicalTherapyResponseServiceDateFrom=" + physicalTherapyResponseServiceDateFrom +
                ", physicalTherapyResponseServiceDateTo=" + physicalTherapyResponseServiceDateTo +
                ", physicalTherapyRevenueCode=" + physicalTherapyRevenueCode +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", physicalTherapyProviderType='" + physicalTherapyProviderType + '\'' +
                ", physicalTherapyProviderIdentificationNumber='" + physicalTherapyProviderIdentificationNumber + '\'' +
                ", physicalTherapyProviderIdentificationNumberType='" + physicalTherapyProviderIdentificationNumberType + '\'' +
                ", physicalTherapyProviderSupplimentalId='" + physicalTherapyProviderSupplimentalId + '\'' +
                ", physicalTherapyProviderIdNumberType='" + physicalTherapyProviderIdNumberType + '\'' +
                ", physicalTherapyProviderRejectionReason='" + physicalTherapyProviderRejectionReason + '\'' +
                ", physicalTherapyProviderFollowUpActionDescription='" + physicalTherapyProviderFollowUpActionDescription + '\'' +
                ", physicalTherapyProviderAddress='" + physicalTherapyProviderAddress + '\'' +
                ", physicalTherapyProviderCity='" + physicalTherapyProviderCity + '\'' +
                ", physicalTherapyProviderState='" + physicalTherapyProviderState + '\'' +
                ", physicalTherapyProviderPostalCode='" + physicalTherapyProviderPostalCode + '\'' +
                ", physicalTherapyProviderCountryCode='" + physicalTherapyProviderCountryCode + '\'' +
                ", physicalTherapyProviderFullName='" + physicalTherapyProviderFullName + '\'' +
                ", physicalTherapyDetailStatus='" + physicalTherapyDetailStatus + '\'' +
                ", physicalTherapyAuthorizationIdNo='" + physicalTherapyAuthorizationIdNo + '\'' +
                ", physicalTherapyEffectiveDateFrom='" + physicalTherapyEffectiveDateFrom + '\'' +
                ", physicalTherapyEffectiveDateTo='" + physicalTherapyEffectiveDateTo + '\'' +
                ", physicalTherapyExpirationDate='" + physicalTherapyExpirationDate + '\'' +
                ", physicalTherapySelected=" + physicalTherapySelected +
                '}';
    }
}
