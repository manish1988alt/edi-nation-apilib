package com.edination.api.preAuthorisation.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "MedicalSocialWork")
public class MedicalSocialWork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mrnNumber;
    private int     medicalSocialWorkRevenueCode;
    private boolean medicalSocialWorkSelected;
    private Date medicalSocialWorkRequestServiceDateFrom;
    private Date   medicalSocialWorkRequestServiceDateTo;
    private int    medicalSocialWorkVisit;
    private int    medicalSocialWorkUnit;
    private String medicalSocialWorkRequestCategory;
    private String medicalSocialWorkCertificationType;
    private String medicalSocialWorkServiceType;
    private String medicalSocialWorkLevelOfService;
    private String  medicalSocialWorkProviderFullName;
    private String medicalSocialWorkProviderFirstName;
    private String medicalSocialWorkPoviderLastName;
    private String medicalSocialWorkProviderMiddleName;
    private String medicalSocialWorkProviderType;
    private String medicalSocialWorkProviderAddress;
    private String medicalSocialWorkProviderCity;
    private String medicalSocialWorkProviderState;
    private String medicalSocialWorkProviderPostalCode;
    private String medicalSocialWorkProviderCountryCode;
    private String medicalSocialWorkProviderIdentificationNumber;
    private String medicalSocialWorkProviderIdentificationNumberType;
    private String medicalSocialWorkProviderSupplimentalId;
    private String medicalSocialWorkProviderIdNumberType;

    public MedicalSocialWork() {
    }

    public MedicalSocialWork(String mrnNumber, int medicalSocialWorkRevenueCode, boolean medicalSocialWorkSelected, Date medicalSocialWorkRequestServiceDateFrom, Date medicalSocialWorkRequestServiceDateTo, int medicalSocialWorkVisit, int medicalSocialWorkUnit, String medicalSocialWorkRequestCategory, String medicalSocialWorkCertificationType, String medicalSocialWorkServiceType, String medicalSocialWorkLevelOfService, String medicalSocialWorkProviderFullName, String medicalSocialWorkProviderFirstName, String medicalSocialWorkPoviderLastName, String medicalSocialWorkProviderMiddleName, String medicalSocialWorkProviderType, String medicalSocialWorkProviderAddress, String medicalSocialWorkProviderCity, String medicalSocialWorkProviderState, String medicalSocialWorkProviderPostalCode, String medicalSocialWorkProviderCountryCode, String medicalSocialWorkProviderIdentificationNumber, String medicalSocialWorkProviderIdentificationNumberType, String medicalSocialWorkProviderSupplimentalId, String medicalSocialWorkProviderIdNumberType) {
        this.mrnNumber = mrnNumber;
        this.medicalSocialWorkRevenueCode = medicalSocialWorkRevenueCode;
        this.medicalSocialWorkSelected = medicalSocialWorkSelected;
        this.medicalSocialWorkRequestServiceDateFrom = medicalSocialWorkRequestServiceDateFrom;
        this.medicalSocialWorkRequestServiceDateTo = medicalSocialWorkRequestServiceDateTo;
        this.medicalSocialWorkVisit = medicalSocialWorkVisit;
        this.medicalSocialWorkUnit = medicalSocialWorkUnit;
        this.medicalSocialWorkRequestCategory = medicalSocialWorkRequestCategory;
        this.medicalSocialWorkCertificationType = medicalSocialWorkCertificationType;
        this.medicalSocialWorkServiceType = medicalSocialWorkServiceType;
        this.medicalSocialWorkLevelOfService = medicalSocialWorkLevelOfService;
        this.medicalSocialWorkProviderFullName = medicalSocialWorkProviderFullName;
        this.medicalSocialWorkProviderFirstName = medicalSocialWorkProviderFirstName;
        this.medicalSocialWorkPoviderLastName = medicalSocialWorkPoviderLastName;
        this.medicalSocialWorkProviderMiddleName = medicalSocialWorkProviderMiddleName;
        this.medicalSocialWorkProviderType = medicalSocialWorkProviderType;
        this.medicalSocialWorkProviderAddress = medicalSocialWorkProviderAddress;
        this.medicalSocialWorkProviderCity = medicalSocialWorkProviderCity;
        this.medicalSocialWorkProviderState = medicalSocialWorkProviderState;
        this.medicalSocialWorkProviderPostalCode = medicalSocialWorkProviderPostalCode;
        this.medicalSocialWorkProviderCountryCode = medicalSocialWorkProviderCountryCode;
        this.medicalSocialWorkProviderIdentificationNumber = medicalSocialWorkProviderIdentificationNumber;
        this.medicalSocialWorkProviderIdentificationNumberType = medicalSocialWorkProviderIdentificationNumberType;
        this.medicalSocialWorkProviderSupplimentalId = medicalSocialWorkProviderSupplimentalId;
        this.medicalSocialWorkProviderIdNumberType = medicalSocialWorkProviderIdNumberType;
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

    public int getMedicalSocialWorkRevenueCode() {
        return medicalSocialWorkRevenueCode;
    }

    public void setMedicalSocialWorkRevenueCode(int medicalSocialWorkRevenueCode) {
        this.medicalSocialWorkRevenueCode = medicalSocialWorkRevenueCode;
    }

    public boolean getMedicalSocialWorkSelected() {
        return medicalSocialWorkSelected;
    }

    public void setMedicalSocialWorkSelected(boolean medicalSocialWorkSelected) {
        this.medicalSocialWorkSelected = medicalSocialWorkSelected;
    }

    public Date getMedicalSocialWorkRequestServiceDateFrom() {
        return medicalSocialWorkRequestServiceDateFrom;
    }

    public void setMedicalSocialWorkRequestServiceDateFrom(Date medicalSocialWorkRequestServiceDateFrom) {
        this.medicalSocialWorkRequestServiceDateFrom = medicalSocialWorkRequestServiceDateFrom;
    }

    public Date getMedicalSocialWorkRequestServiceDateTo() {
        return medicalSocialWorkRequestServiceDateTo;
    }

    public void setMedicalSocialWorkRequestServiceDateTo(Date medicalSocialWorkRequestServiceDateTo) {
        this.medicalSocialWorkRequestServiceDateTo = medicalSocialWorkRequestServiceDateTo;
    }

    public int getMedicalSocialWorkVisit() {
        return medicalSocialWorkVisit;
    }

    public void setMedicalSocialWorkVisit(int medicalSocialWorkVisit) {
        this.medicalSocialWorkVisit = medicalSocialWorkVisit;
    }

    public int getMedicalSocialWorkUnit() {
        return medicalSocialWorkUnit;
    }

    public void setMedicalSocialWorkUnit(int medicalSocialWorkUnit) {
        this.medicalSocialWorkUnit = medicalSocialWorkUnit;
    }

    public String getMedicalSocialWorkRequestCategory() {
        return medicalSocialWorkRequestCategory;
    }

    public void setMedicalSocialWorkRequestCategory(String medicalSocialWorkRequestCategory) {
        this.medicalSocialWorkRequestCategory = medicalSocialWorkRequestCategory;
    }

    public String getMedicalSocialWorkCertificationType() {
        return medicalSocialWorkCertificationType;
    }

    public void setMedicalSocialWorkCertificationType(String medicalSocialWorkCertificationType) {
        this.medicalSocialWorkCertificationType = medicalSocialWorkCertificationType;
    }

    public String getMedicalSocialWorkServiceType() {
        return medicalSocialWorkServiceType;
    }

    public void setMedicalSocialWorkServiceType(String medicalSocialWorkServiceType) {
        this.medicalSocialWorkServiceType = medicalSocialWorkServiceType;
    }

    public String getMedicalSocialWorkLevelOfService() {
        return medicalSocialWorkLevelOfService;
    }

    public void setMedicalSocialWorkLevelOfService(String medicalSocialWorkLevelOfService) {
        this.medicalSocialWorkLevelOfService = medicalSocialWorkLevelOfService;
    }

    public String getMedicalSocialWorkProviderFullName() {
        return medicalSocialWorkProviderFullName;
    }

    public void setMedicalSocialWorkProviderFullName(String medicalSocialWorkProviderFullName) {
        this.medicalSocialWorkProviderFullName = medicalSocialWorkProviderFullName;
    }

    public String getMedicalSocialWorkProviderFirstName() {
        return medicalSocialWorkProviderFirstName;
    }

    public void setMedicalSocialWorkProviderFirstName(String medicalSocialWorkProviderFirstName) {
        this.medicalSocialWorkProviderFirstName = medicalSocialWorkProviderFirstName;
    }

    public String getMedicalSocialWorkPoviderLastName() {
        return medicalSocialWorkPoviderLastName;
    }

    public void setMedicalSocialWorkPoviderLastName(String medicalSocialWorkPoviderLastName) {
        this.medicalSocialWorkPoviderLastName = medicalSocialWorkPoviderLastName;
    }

    public String getMedicalSocialWorkProviderMiddleName() {
        return medicalSocialWorkProviderMiddleName;
    }

    public void setMedicalSocialWorkProviderMiddleName(String medicalSocialWorkProviderMiddleName) {
        this.medicalSocialWorkProviderMiddleName = medicalSocialWorkProviderMiddleName;
    }

    public String getMedicalSocialWorkProviderType() {
        return medicalSocialWorkProviderType;
    }

    public void setMedicalSocialWorkProviderType(String medicalSocialWorkProviderType) {
        this.medicalSocialWorkProviderType = medicalSocialWorkProviderType;
    }

    public String getMedicalSocialWorkProviderAddress() {
        return medicalSocialWorkProviderAddress;
    }

    public void setMedicalSocialWorkProviderAddress(String medicalSocialWorkProviderAddress) {
        this.medicalSocialWorkProviderAddress = medicalSocialWorkProviderAddress;
    }

    public String getMedicalSocialWorkProviderCity() {
        return medicalSocialWorkProviderCity;
    }

    public void setMedicalSocialWorkProviderCity(String medicalSocialWorkProviderCity) {
        this.medicalSocialWorkProviderCity = medicalSocialWorkProviderCity;
    }

    public String getMedicalSocialWorkProviderState() {
        return medicalSocialWorkProviderState;
    }

    public void setMedicalSocialWorkProviderState(String medicalSocialWorkProviderState) {
        this.medicalSocialWorkProviderState = medicalSocialWorkProviderState;
    }

    public String getMedicalSocialWorkProviderPostalCode() {
        return medicalSocialWorkProviderPostalCode;
    }

    public void setMedicalSocialWorkProviderPostalCode(String medicalSocialWorkProviderPostalCode) {
        this.medicalSocialWorkProviderPostalCode = medicalSocialWorkProviderPostalCode;
    }

    public String getMedicalSocialWorkProviderCountryCode() {
        return medicalSocialWorkProviderCountryCode;
    }

    public void setMedicalSocialWorkProviderCountryCode(String medicalSocialWorkProviderCountryCode) {
        this.medicalSocialWorkProviderCountryCode = medicalSocialWorkProviderCountryCode;
    }

    public String getMedicalSocialWorkProviderIdentificationNumber() {
        return medicalSocialWorkProviderIdentificationNumber;
    }

    public void setMedicalSocialWorkProviderIdentificationNumber(String medicalSocialWorkProviderIdentificationNumber) {
        this.medicalSocialWorkProviderIdentificationNumber = medicalSocialWorkProviderIdentificationNumber;
    }

    public String getMedicalSocialWorkProviderIdentificationNumberType() {
        return medicalSocialWorkProviderIdentificationNumberType;
    }

    public void setMedicalSocialWorkProviderIdentificationNumberType(String medicalSocialWorkProviderIdentificationNumberType) {
        this.medicalSocialWorkProviderIdentificationNumberType = medicalSocialWorkProviderIdentificationNumberType;
    }

    public String getMedicalSocialWorkProviderSupplimentalId() {
        return medicalSocialWorkProviderSupplimentalId;
    }

    public void setMedicalSocialWorkProviderSupplimentalId(String medicalSocialWorkProviderSupplimentalId) {
        this.medicalSocialWorkProviderSupplimentalId = medicalSocialWorkProviderSupplimentalId;
    }

    public String getMedicalSocialWorkProviderIdNumberType() {
        return medicalSocialWorkProviderIdNumberType;
    }

    public void setMedicalSocialWorkProviderIdNumberType(String medicalSocialWorkProviderIdNumberType) {
        this.medicalSocialWorkProviderIdNumberType = medicalSocialWorkProviderIdNumberType;
    }

    @Override
    public String toString() {
        return "MedicalSocialWork{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", medicalSocialWorkRevenueCode=" + medicalSocialWorkRevenueCode +
                ", medicalSocialWorkSelected=" + medicalSocialWorkSelected +
                ", medicalSocialWorkRequestServiceDateFrom=" + medicalSocialWorkRequestServiceDateFrom +
                ", medicalSocialWorkRequestServiceDateTo=" + medicalSocialWorkRequestServiceDateTo +
                ", medicalSocialWorkVisit=" + medicalSocialWorkVisit +
                ", medicalSocialWorkUnit=" + medicalSocialWorkUnit +
                ", medicalSocialWorkRequestCategory='" + medicalSocialWorkRequestCategory + '\'' +
                ", medicalSocialWorkCertificationType='" + medicalSocialWorkCertificationType + '\'' +
                ", medicalSocialWorkServiceType='" + medicalSocialWorkServiceType + '\'' +
                ", medicalSocialWorkLevelOfService='" + medicalSocialWorkLevelOfService + '\'' +
                ", medicalSocialWorkProviderFullName='" + medicalSocialWorkProviderFullName + '\'' +
                ", medicalSocialWorkProviderFirstName='" + medicalSocialWorkProviderFirstName + '\'' +
                ", medicalSocialWorkPoviderLastName='" + medicalSocialWorkPoviderLastName + '\'' +
                ", medicalSocialWorkProviderMiddleName='" + medicalSocialWorkProviderMiddleName + '\'' +
                ", medicalSocialWorkProviderType='" + medicalSocialWorkProviderType + '\'' +
                ", medicalSocialWorkProviderAddress='" + medicalSocialWorkProviderAddress + '\'' +
                ", medicalSocialWorkProviderCity='" + medicalSocialWorkProviderCity + '\'' +
                ", medicalSocialWorkProviderState='" + medicalSocialWorkProviderState + '\'' +
                ", medicalSocialWorkProviderPostalCode='" + medicalSocialWorkProviderPostalCode + '\'' +
                ", medicalSocialWorkProviderCountryCode='" + medicalSocialWorkProviderCountryCode + '\'' +
                ", medicalSocialWorkProviderIdentificationNumber='" + medicalSocialWorkProviderIdentificationNumber + '\'' +
                ", medicalSocialWorkProviderIdentificationNumberType='" + medicalSocialWorkProviderIdentificationNumberType + '\'' +
                ", medicalSocialWorkProviderSupplimentalId='" + medicalSocialWorkProviderSupplimentalId + '\'' +
                ", medicalSocialWorkProviderIdNumberType='" + medicalSocialWorkProviderIdNumberType + '\'' +
                '}';
    }
}
