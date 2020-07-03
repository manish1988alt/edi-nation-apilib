package com.edination.api.preAuthorisation.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;


@Entity
@Table(name = "MedicalSocialWorkResponse")
public class MedicalSocialWorkResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String MedicalSocialWorkRequestCategory;
    private String MedicalSocialWorkCertificationType;
    private String MedicalSocialWorkServiceType;
    private String MedicalSocialWorkLevelOfService;
    private String MedicalSocialWorkVisit;
    private String MedicalSocialWorkUnit;
    private String MedicalSocialWorkCertificationAction;
    private String MedicalSocialWorkRejectionReason;
    private String MedicalSocialWorkRejectionReasonMSG;
    private String MedicalSocialWorkProviderFirstName;
    private String MedicalSocialWorkPoviderLastName;
    private String MedicalSocialWorkProviderMiddleName;
    private String medicalSocialWorkProviderSuffix;
    private String medicalSocialWorkProviderPrefix;
    private LocalDate medicalSocialWorkResponseServiceDateFrom;
    private LocalDate medicalSocialWorkResponseServiceDateTo;
    private int medicalSocialWorkRevenueCode;
    private String mrnNumber;
    private String MedicalSocialWorkProviderType;
    private String MedicalSocialWorkProviderIdentificationNumber;
    private String MedicalSocialWorkProviderIdentificationNumberType;
    private String MedicalSocialWorkProviderSupplimentalId;
    private String MedicalSocialWorkProviderIdNumberType;
    private String MedicalSocialWorkProviderRejectionReason;
    private String MedicalSocialWorkProviderFollowUpActionDescription;
    private String MedicalSocialWorkProviderAddress;
    private String MedicalSocialWorkProviderCity;
    private String MedicalSocialWorkProviderState;
    private String MedicalSocialWorkProviderPostalCode;
    private String MedicalSocialWorkProviderCountryCode;
    private String MedicalSocialWorkProviderFullName;
    private String MedicalSocialWorkDetailStatus;

    private String medicalSocialWorkAuthorizationIdNo;
    private LocalDate medicalSocialWorkEffectiveDateFrom;
    private LocalDate medicalSocialWorkEffectiveDateTo;
    private LocalDate medicalSocialWorkExpirationDate;
    private boolean medicalSocialWorkSelected;

    public MedicalSocialWorkResponse() {
    }

    public MedicalSocialWorkResponse(String medicalSocialWorkRequestCategory, String medicalSocialWorkCertificationType, String medicalSocialWorkServiceType, String medicalSocialWorkLevelOfService, String medicalSocialWorkVisit, String medicalSocialWorkUnit, String medicalSocialWorkCertificationAction, String medicalSocialWorkRejectionReason, String medicalSocialWorkRejectionReasonMSG, String medicalSocialWorkProviderFirstName, String medicalSocialWorkPoviderLastName, String medicalSocialWorkProviderMiddleName, String medicalSocialWorkProviderSuffix, String medicalSocialWorkProviderPrefix, LocalDate medicalSocialWorkResponseServiceDateFrom, LocalDate medicalSocialWorkResponseServiceDateTo, int medicalSocialWorkRevenueCode, String mrnNumber, String medicalSocialWorkProviderType, String medicalSocialWorkProviderIdentificationNumber, String medicalSocialWorkProviderIdentificationNumberType, String medicalSocialWorkProviderSupplimentalId, String medicalSocialWorkProviderIdNumberType, String medicalSocialWorkProviderRejectionReason, String medicalSocialWorkProviderFollowUpActionDescription, String medicalSocialWorkProviderAddress, String medicalSocialWorkProviderCity, String medicalSocialWorkProviderState, String medicalSocialWorkProviderPostalCode, String medicalSocialWorkProviderCountryCode, String medicalSocialWorkProviderFullName, String medicalSocialWorkDetailStatus, String medicalSocialWorkAuthorizationIdNo, LocalDate medicalSocialWorkEffectiveDateFrom, LocalDate medicalSocialWorkEffectiveDateTo, LocalDate medicalSocialWorkExpirationDate, boolean medicalSocialWorkSelected) {
        MedicalSocialWorkRequestCategory = medicalSocialWorkRequestCategory;
        MedicalSocialWorkCertificationType = medicalSocialWorkCertificationType;
        MedicalSocialWorkServiceType = medicalSocialWorkServiceType;
        MedicalSocialWorkLevelOfService = medicalSocialWorkLevelOfService;
        MedicalSocialWorkVisit = medicalSocialWorkVisit;
        MedicalSocialWorkUnit = medicalSocialWorkUnit;
        MedicalSocialWorkCertificationAction = medicalSocialWorkCertificationAction;
        MedicalSocialWorkRejectionReason = medicalSocialWorkRejectionReason;
        MedicalSocialWorkRejectionReasonMSG = medicalSocialWorkRejectionReasonMSG;
        MedicalSocialWorkProviderFirstName = medicalSocialWorkProviderFirstName;
        MedicalSocialWorkPoviderLastName = medicalSocialWorkPoviderLastName;
        MedicalSocialWorkProviderMiddleName = medicalSocialWorkProviderMiddleName;
        this.medicalSocialWorkProviderSuffix = medicalSocialWorkProviderSuffix;
        this.medicalSocialWorkProviderPrefix = medicalSocialWorkProviderPrefix;
        this.medicalSocialWorkResponseServiceDateFrom = medicalSocialWorkResponseServiceDateFrom;
        this.medicalSocialWorkResponseServiceDateTo = medicalSocialWorkResponseServiceDateTo;
        this.medicalSocialWorkRevenueCode = medicalSocialWorkRevenueCode;
        this.mrnNumber = mrnNumber;
        MedicalSocialWorkProviderType = medicalSocialWorkProviderType;
        MedicalSocialWorkProviderIdentificationNumber = medicalSocialWorkProviderIdentificationNumber;
        MedicalSocialWorkProviderIdentificationNumberType = medicalSocialWorkProviderIdentificationNumberType;
        MedicalSocialWorkProviderSupplimentalId = medicalSocialWorkProviderSupplimentalId;
        MedicalSocialWorkProviderIdNumberType = medicalSocialWorkProviderIdNumberType;
        MedicalSocialWorkProviderRejectionReason = medicalSocialWorkProviderRejectionReason;
        MedicalSocialWorkProviderFollowUpActionDescription = medicalSocialWorkProviderFollowUpActionDescription;
        MedicalSocialWorkProviderAddress = medicalSocialWorkProviderAddress;
        MedicalSocialWorkProviderCity = medicalSocialWorkProviderCity;
        MedicalSocialWorkProviderState = medicalSocialWorkProviderState;
        MedicalSocialWorkProviderPostalCode = medicalSocialWorkProviderPostalCode;
        MedicalSocialWorkProviderCountryCode = medicalSocialWorkProviderCountryCode;
        MedicalSocialWorkProviderFullName = medicalSocialWorkProviderFullName;
        MedicalSocialWorkDetailStatus = medicalSocialWorkDetailStatus;
        this.medicalSocialWorkAuthorizationIdNo = medicalSocialWorkAuthorizationIdNo;
        this.medicalSocialWorkEffectiveDateFrom = medicalSocialWorkEffectiveDateFrom;
        this.medicalSocialWorkEffectiveDateTo = medicalSocialWorkEffectiveDateTo;
        this.medicalSocialWorkExpirationDate = medicalSocialWorkExpirationDate;
        this.medicalSocialWorkSelected = medicalSocialWorkSelected;
    }

    public String getMedicalSocialWorkAuthorizationIdNo() {
        return medicalSocialWorkAuthorizationIdNo;
    }

    public void setMedicalSocialWorkAuthorizationIdNo(String medicalSocialWorkAuthorizationIdNo) {
        this.medicalSocialWorkAuthorizationIdNo = medicalSocialWorkAuthorizationIdNo;
    }

    public LocalDate getMedicalSocialWorkEffectiveDateFrom() {
        return medicalSocialWorkEffectiveDateFrom;
    }

    public void setMedicalSocialWorkEffectiveDateFrom(LocalDate medicalSocialWorkEffectiveDateFrom) {
        this.medicalSocialWorkEffectiveDateFrom = medicalSocialWorkEffectiveDateFrom;
    }

    public LocalDate getMedicalSocialWorkEffectiveDateTo() {
        return medicalSocialWorkEffectiveDateTo;
    }

    public void setMedicalSocialWorkEffectiveDateTo(LocalDate medicalSocialWorkEffectiveDateTo) {
        this.medicalSocialWorkEffectiveDateTo = medicalSocialWorkEffectiveDateTo;
    }

    public LocalDate getMedicalSocialWorkExpirationDate() {
        return medicalSocialWorkExpirationDate;
    }

    public void setMedicalSocialWorkExpirationDate(LocalDate medicalSocialWorkExpirationDate) {
        this.medicalSocialWorkExpirationDate = medicalSocialWorkExpirationDate;
    }

    public boolean getMedicalSocialWorkSelected() {
        return medicalSocialWorkSelected;
    }

    public void setMedicalSocialWorkSelected(boolean medicalSocialWorkSelected) {
        this.medicalSocialWorkSelected = medicalSocialWorkSelected;
    }

    public String getMedicalSocialWorkProviderSuffix() {
        return medicalSocialWorkProviderSuffix;
    }

    public void setMedicalSocialWorkProviderSuffix(String medicalSocialWorkProviderSuffix) {
        this.medicalSocialWorkProviderSuffix = medicalSocialWorkProviderSuffix;
    }

    public String getMedicalSocialWorkProviderPrefix() {
        return medicalSocialWorkProviderPrefix;
    }

    public void setMedicalSocialWorkProviderPrefix(String medicalSocialWorkProviderPrefix) {
        this.medicalSocialWorkProviderPrefix = medicalSocialWorkProviderPrefix;
    }

    public LocalDate getMedicalSocialWorkResponseServiceDateFrom() {
        return medicalSocialWorkResponseServiceDateFrom;
    }

    public void setMedicalSocialWorkResponseServiceDateFrom(LocalDate medicalSocialWorkResponseServiceDateFrom) {
        this.medicalSocialWorkResponseServiceDateFrom = medicalSocialWorkResponseServiceDateFrom;
    }

    public LocalDate getMedicalSocialWorkResponseServiceDateTo() {
        return medicalSocialWorkResponseServiceDateTo;
    }

    public void setMedicalSocialWorkResponseServiceDateTo(LocalDate medicalSocialWorkResponseServiceDateTo) {
        this.medicalSocialWorkResponseServiceDateTo = medicalSocialWorkResponseServiceDateTo;
    }

    public int getMedicalSocialWorkRevenueCode() {
        return medicalSocialWorkRevenueCode;
    }

    public void setMedicalSocialWorkRevenueCode(int medicalSocialWorkRevenueCode) {
        this.medicalSocialWorkRevenueCode = medicalSocialWorkRevenueCode;
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

    public String getMedicalSocialWorkRequestCategory() {
        return MedicalSocialWorkRequestCategory;
    }

    public void setMedicalSocialWorkRequestCategory(String medicalSocialWorkRequestCategory) {
        MedicalSocialWorkRequestCategory = medicalSocialWorkRequestCategory;
    }

    public String getMedicalSocialWorkCertificationType() {
        return MedicalSocialWorkCertificationType;
    }

    public void setMedicalSocialWorkCertificationType(String medicalSocialWorkCertificationType) {
        MedicalSocialWorkCertificationType = medicalSocialWorkCertificationType;
    }

    public String getMedicalSocialWorkServiceType() {
        return MedicalSocialWorkServiceType;
    }

    public void setMedicalSocialWorkServiceType(String medicalSocialWorkServiceType) {
        MedicalSocialWorkServiceType = medicalSocialWorkServiceType;
    }

    public String getMedicalSocialWorkLevelOfService() {
        return MedicalSocialWorkLevelOfService;
    }

    public void setMedicalSocialWorkLevelOfService(String medicalSocialWorkLevelOfService) {
        MedicalSocialWorkLevelOfService = medicalSocialWorkLevelOfService;
    }

    public String getMedicalSocialWorkVisit() {
        return MedicalSocialWorkVisit;
    }

    public void setMedicalSocialWorkVisit(String medicalSocialWorkVisit) {
        MedicalSocialWorkVisit = medicalSocialWorkVisit;
    }

    public String getMedicalSocialWorkUnit() {
        return MedicalSocialWorkUnit;
    }

    public void setMedicalSocialWorkUnit(String medicalSocialWorkUnit) {
        MedicalSocialWorkUnit = medicalSocialWorkUnit;
    }

    public String getMedicalSocialWorkCertificationAction() {
        return MedicalSocialWorkCertificationAction;
    }

    public void setMedicalSocialWorkCertificationAction(String medicalSocialWorkCertificationAction) {
        MedicalSocialWorkCertificationAction = medicalSocialWorkCertificationAction;
    }

    public String getMedicalSocialWorkRejectionReason() {
        return MedicalSocialWorkRejectionReason;
    }

    public void setMedicalSocialWorkRejectionReason(String medicalSocialWorkRejectionReason) {
        MedicalSocialWorkRejectionReason = medicalSocialWorkRejectionReason;
    }

    public String getMedicalSocialWorkRejectionReasonMSG() {
        return MedicalSocialWorkRejectionReasonMSG;
    }

    public void setMedicalSocialWorkRejectionReasonMSG(String medicalSocialWorkRejectionReasonMSG) {
        MedicalSocialWorkRejectionReasonMSG = medicalSocialWorkRejectionReasonMSG;
    }

    public String getMedicalSocialWorkProviderFirstName() {
        return MedicalSocialWorkProviderFirstName;
    }

    public void setMedicalSocialWorkProviderFirstName(String medicalSocialWorkProviderFirstName) {
        MedicalSocialWorkProviderFirstName = medicalSocialWorkProviderFirstName;
    }

    public String getMedicalSocialWorkPoviderLastName() {
        return MedicalSocialWorkPoviderLastName;
    }

    public void setMedicalSocialWorkPoviderLastName(String medicalSocialWorkPoviderLastName) {
        MedicalSocialWorkPoviderLastName = medicalSocialWorkPoviderLastName;
    }

    public String getMedicalSocialWorkProviderMiddleName() {
        return MedicalSocialWorkProviderMiddleName;
    }

    public void setMedicalSocialWorkProviderMiddleName(String medicalSocialWorkProviderMiddleName) {
        MedicalSocialWorkProviderMiddleName = medicalSocialWorkProviderMiddleName;
    }

    public String getMedicalSocialWorkProviderType() {
        return MedicalSocialWorkProviderType;
    }

    public void setMedicalSocialWorkProviderType(String medicalSocialWorkProviderType) {
        MedicalSocialWorkProviderType = medicalSocialWorkProviderType;
    }

    public String getMedicalSocialWorkProviderIdentificationNumber() {
        return MedicalSocialWorkProviderIdentificationNumber;
    }

    public void setMedicalSocialWorkProviderIdentificationNumber(String medicalSocialWorkProviderIdentificationNumber) {
        MedicalSocialWorkProviderIdentificationNumber = medicalSocialWorkProviderIdentificationNumber;
    }

    public String getMedicalSocialWorkProviderIdentificationNumberType() {
        return MedicalSocialWorkProviderIdentificationNumberType;
    }

    public void setMedicalSocialWorkProviderIdentificationNumberType(String medicalSocialWorkProviderIdentificationNumberType) {
        MedicalSocialWorkProviderIdentificationNumberType = medicalSocialWorkProviderIdentificationNumberType;
    }

    public String getMedicalSocialWorkProviderSupplimentalId() {
        return MedicalSocialWorkProviderSupplimentalId;
    }

    public void setMedicalSocialWorkProviderSupplimentalId(String medicalSocialWorkProviderSupplimentalId) {
        MedicalSocialWorkProviderSupplimentalId = medicalSocialWorkProviderSupplimentalId;
    }

    public String getMedicalSocialWorkProviderIdNumberType() {
        return MedicalSocialWorkProviderIdNumberType;
    }

    public void setMedicalSocialWorkProviderIdNumberType(String medicalSocialWorkProviderIdNumberType) {
        MedicalSocialWorkProviderIdNumberType = medicalSocialWorkProviderIdNumberType;
    }

    public String getMedicalSocialWorkProviderRejectionReason() {
        return MedicalSocialWorkProviderRejectionReason;
    }

    public void setMedicalSocialWorkProviderRejectionReason(String medicalSocialWorkProviderRejectionReason) {
        MedicalSocialWorkProviderRejectionReason = medicalSocialWorkProviderRejectionReason;
    }

    public String getMedicalSocialWorkProviderFollowUpActionDescription() {
        return MedicalSocialWorkProviderFollowUpActionDescription;
    }

    public void setMedicalSocialWorkProviderFollowUpActionDescription(String medicalSocialWorkProviderFollowUpActionDescription) {
        MedicalSocialWorkProviderFollowUpActionDescription = medicalSocialWorkProviderFollowUpActionDescription;
    }

    public String getMedicalSocialWorkProviderAddress() {
        return MedicalSocialWorkProviderAddress;
    }

    public void setMedicalSocialWorkProviderAddress(String medicalSocialWorkProviderAddress) {
        MedicalSocialWorkProviderAddress = medicalSocialWorkProviderAddress;
    }

    public String getMedicalSocialWorkProviderCity() {
        return MedicalSocialWorkProviderCity;
    }

    public void setMedicalSocialWorkProviderCity(String medicalSocialWorkProviderCity) {
        MedicalSocialWorkProviderCity = medicalSocialWorkProviderCity;
    }

    public String getMedicalSocialWorkProviderState() {
        return MedicalSocialWorkProviderState;
    }

    public void setMedicalSocialWorkProviderState(String medicalSocialWorkProviderState) {
        MedicalSocialWorkProviderState = medicalSocialWorkProviderState;
    }

    public String getMedicalSocialWorkProviderPostalCode() {
        return MedicalSocialWorkProviderPostalCode;
    }

    public void setMedicalSocialWorkProviderPostalCode(String medicalSocialWorkProviderPostalCode) {
        MedicalSocialWorkProviderPostalCode = medicalSocialWorkProviderPostalCode;
    }

    public String getMedicalSocialWorkProviderCountryCode() {
        return MedicalSocialWorkProviderCountryCode;
    }

    public void setMedicalSocialWorkProviderCountryCode(String medicalSocialWorkProviderCountryCode) {
        MedicalSocialWorkProviderCountryCode = medicalSocialWorkProviderCountryCode;
    }

    public String getMedicalSocialWorkProviderFullName() {
        return MedicalSocialWorkProviderFullName;
    }

    public void setMedicalSocialWorkProviderFullName(String medicalSocialWorkProviderFullName) {
        MedicalSocialWorkProviderFullName = medicalSocialWorkProviderFullName;
    }

    public String getMedicalSocialWorkDetailStatus() {
        return MedicalSocialWorkDetailStatus;
    }

    public void setMedicalSocialWorkDetailStatus(String medicalSocialWorkDetailStatus) {
        MedicalSocialWorkDetailStatus = medicalSocialWorkDetailStatus;
    }

    @Override
    public String toString() {
        return "MedicalSocialWorkResponse{" +
                "id=" + id +
                ", MedicalSocialWorkRequestCategory='" + MedicalSocialWorkRequestCategory + '\'' +
                ", MedicalSocialWorkCertificationType='" + MedicalSocialWorkCertificationType + '\'' +
                ", MedicalSocialWorkServiceType='" + MedicalSocialWorkServiceType + '\'' +
                ", MedicalSocialWorkLevelOfService='" + MedicalSocialWorkLevelOfService + '\'' +
                ", MedicalSocialWorkVisit='" + MedicalSocialWorkVisit + '\'' +
                ", MedicalSocialWorkUnit='" + MedicalSocialWorkUnit + '\'' +
                ", MedicalSocialWorkCertificationAction='" + MedicalSocialWorkCertificationAction + '\'' +
                ", MedicalSocialWorkRejectionReason='" + MedicalSocialWorkRejectionReason + '\'' +
                ", MedicalSocialWorkRejectionReasonMSG='" + MedicalSocialWorkRejectionReasonMSG + '\'' +
                ", MedicalSocialWorkProviderFirstName='" + MedicalSocialWorkProviderFirstName + '\'' +
                ", MedicalSocialWorkPoviderLastName='" + MedicalSocialWorkPoviderLastName + '\'' +
                ", MedicalSocialWorkProviderMiddleName='" + MedicalSocialWorkProviderMiddleName + '\'' +
                ", medicalSocialWorkProviderSuffix='" + medicalSocialWorkProviderSuffix + '\'' +
                ", medicalSocialWorkProviderPrefix='" + medicalSocialWorkProviderPrefix + '\'' +
                ", medicalSocialWorkResponseServiceDateFrom=" + medicalSocialWorkResponseServiceDateFrom +
                ", medicalSocialWorkResponseServiceDateTo=" + medicalSocialWorkResponseServiceDateTo +
                ", medicalSocialWorkRevenueCode=" + medicalSocialWorkRevenueCode +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", MedicalSocialWorkProviderType='" + MedicalSocialWorkProviderType + '\'' +
                ", MedicalSocialWorkProviderIdentificationNumber='" + MedicalSocialWorkProviderIdentificationNumber + '\'' +
                ", MedicalSocialWorkProviderIdentificationNumberType='" + MedicalSocialWorkProviderIdentificationNumberType + '\'' +
                ", MedicalSocialWorkProviderSupplimentalId='" + MedicalSocialWorkProviderSupplimentalId + '\'' +
                ", MedicalSocialWorkProviderIdNumberType='" + MedicalSocialWorkProviderIdNumberType + '\'' +
                ", MedicalSocialWorkProviderRejectionReason='" + MedicalSocialWorkProviderRejectionReason + '\'' +
                ", MedicalSocialWorkProviderFollowUpActionDescription='" + MedicalSocialWorkProviderFollowUpActionDescription + '\'' +
                ", MedicalSocialWorkProviderAddress='" + MedicalSocialWorkProviderAddress + '\'' +
                ", MedicalSocialWorkProviderCity='" + MedicalSocialWorkProviderCity + '\'' +
                ", MedicalSocialWorkProviderState='" + MedicalSocialWorkProviderState + '\'' +
                ", MedicalSocialWorkProviderPostalCode='" + MedicalSocialWorkProviderPostalCode + '\'' +
                ", MedicalSocialWorkProviderCountryCode='" + MedicalSocialWorkProviderCountryCode + '\'' +
                ", MedicalSocialWorkProviderFullName='" + MedicalSocialWorkProviderFullName + '\'' +
                ", MedicalSocialWorkDetailStatus='" + MedicalSocialWorkDetailStatus + '\'' +
                ", medicalSocialWorkAuthorizationIdNo='" + medicalSocialWorkAuthorizationIdNo + '\'' +
                ", medicalSocialWorkEffectiveDateFrom='" + medicalSocialWorkEffectiveDateFrom + '\'' +
                ", medicalSocialWorkEffectiveDateTo='" + medicalSocialWorkEffectiveDateTo + '\'' +
                ", medicalSocialWorkExpirationDate='" + medicalSocialWorkExpirationDate + '\'' +
                ", medicalSocialWorkSelected=" + medicalSocialWorkSelected +
                '}';
    }
}
