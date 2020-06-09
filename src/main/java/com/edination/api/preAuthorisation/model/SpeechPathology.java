package com.edination.api.preAuthorisation.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SpeechPathology")
public class SpeechPathology {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mrnNumber;
    private int     speechPathologyRevenueCode;
    private boolean speechPathologySelected;
    private Date speechPathologyRequestServiceDateFrom;
    private Date   speechPathologyRequestServiceDateTo;
    private int    speechPathologyVisit;
    private int    speechPathologyUnit;
    private String speechPathologyRequestCategory;
    private String speechPathologyCertificationType;
    private String speechPathologyServiceType;
    private String speechPathologyLevelOfService;
    private String  speechPathologyProviderFullName;
    private String speechPathologyProviderFirstName;
    private String speechPathologyPoviderLastName;
    private String speechPathologyProviderMiddleName;
    private String speechPathologyProviderSuffix;
    private String speechPathologyProviderPrefix;
    private String speechPathologyProviderType;
    private String speechPathologyProviderAddress;
    private String speechPathologyProviderCity;
    private String speechPathologyProviderState;
    private String speechPathologyProviderPostalCode;
    private String speechPathologyProviderCountryCode;
    private String speechPathologyProviderIdentificationNumber;
    private String speechPathologyProviderIdentificationNumberType;
    private String speechPathologyProviderSupplimentalId;
    private String speechPathologyProviderIdNumberType;

    public SpeechPathology() {
    }

    public SpeechPathology(String mrnNumber, int speechPathologyRevenueCode, boolean speechPathologySelected, Date speechPathologyRequestServiceDateFrom, Date speechPathologyRequestServiceDateTo, int speechPathologyVisit, int speechPathologyUnit, String speechPathologyRequestCategory, String speechPathologyCertificationType, String speechPathologyServiceType, String speechPathologyLevelOfService, String speechPathologyProviderFullName, String speechPathologyProviderFirstName, String speechPathologyPoviderLastName, String speechPathologyProviderMiddleName, String speechPathologyProviderSuffix, String speechPathologyProviderPrefix, String speechPathologyProviderType, String speechPathologyProviderAddress, String speechPathologyProviderCity, String speechPathologyProviderState, String speechPathologyProviderPostalCode, String speechPathologyProviderCountryCode, String speechPathologyProviderIdentificationNumber, String speechPathologyProviderIdentificationNumberType, String speechPathologyProviderSupplimentalId, String speechPathologyProviderIdNumberType) {
        this.mrnNumber = mrnNumber;
        this.speechPathologyRevenueCode = speechPathologyRevenueCode;
        this.speechPathologySelected = speechPathologySelected;
        this.speechPathologyRequestServiceDateFrom = speechPathologyRequestServiceDateFrom;
        this.speechPathologyRequestServiceDateTo = speechPathologyRequestServiceDateTo;
        this.speechPathologyVisit = speechPathologyVisit;
        this.speechPathologyUnit = speechPathologyUnit;
        this.speechPathologyRequestCategory = speechPathologyRequestCategory;
        this.speechPathologyCertificationType = speechPathologyCertificationType;
        this.speechPathologyServiceType = speechPathologyServiceType;
        this.speechPathologyLevelOfService = speechPathologyLevelOfService;
        this.speechPathologyProviderFullName = speechPathologyProviderFullName;
        this.speechPathologyProviderFirstName = speechPathologyProviderFirstName;
        this.speechPathologyPoviderLastName = speechPathologyPoviderLastName;
        this.speechPathologyProviderMiddleName = speechPathologyProviderMiddleName;
        this.speechPathologyProviderSuffix = speechPathologyProviderSuffix;
        this.speechPathologyProviderPrefix = speechPathologyProviderPrefix;
        this.speechPathologyProviderType = speechPathologyProviderType;
        this.speechPathologyProviderAddress = speechPathologyProviderAddress;
        this.speechPathologyProviderCity = speechPathologyProviderCity;
        this.speechPathologyProviderState = speechPathologyProviderState;
        this.speechPathologyProviderPostalCode = speechPathologyProviderPostalCode;
        this.speechPathologyProviderCountryCode = speechPathologyProviderCountryCode;
        this.speechPathologyProviderIdentificationNumber = speechPathologyProviderIdentificationNumber;
        this.speechPathologyProviderIdentificationNumberType = speechPathologyProviderIdentificationNumberType;
        this.speechPathologyProviderSupplimentalId = speechPathologyProviderSupplimentalId;
        this.speechPathologyProviderIdNumberType = speechPathologyProviderIdNumberType;
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

    public String getSpeechPathologyProviderSuffix() {
        return speechPathologyProviderSuffix;
    }

    public void setSpeechPathologyProviderSuffix(String speechPathologyProviderSuffix) {
        this.speechPathologyProviderSuffix = speechPathologyProviderSuffix;
    }

    public String getSpeechPathologyProviderPrefix() {
        return speechPathologyProviderPrefix;
    }

    public void setSpeechPathologyProviderPrefix(String speechPathologyProviderPrefix) {
        this.speechPathologyProviderPrefix = speechPathologyProviderPrefix;
    }

    public int getSpeechPathologyRevenueCode() {
        return speechPathologyRevenueCode;
    }

    public void setSpeechPathologyRevenueCode(int speechPathologyRevenueCode) {
        this.speechPathologyRevenueCode = speechPathologyRevenueCode;
    }

    public boolean getSpeechPathologySelected() {
        return speechPathologySelected;
    }

    public void setSpeechPathologySelected(boolean speechPathologySelected) {
        this.speechPathologySelected = speechPathologySelected;
    }

    public Date getSpeechPathologyRequestServiceDateFrom() {
        return speechPathologyRequestServiceDateFrom;
    }

    public void setSpeechPathologyRequestServiceDateFrom(Date speechPathologyRequestServiceDateFrom) {
        this.speechPathologyRequestServiceDateFrom = speechPathologyRequestServiceDateFrom;
    }

    public Date getSpeechPathologyRequestServiceDateTo() {
        return speechPathologyRequestServiceDateTo;
    }

    public void setSpeechPathologyRequestServiceDateTo(Date speechPathologyRequestServiceDateTo) {
        this.speechPathologyRequestServiceDateTo = speechPathologyRequestServiceDateTo;
    }

    public int getSpeechPathologyVisit() {
        return speechPathologyVisit;
    }

    public void setSpeechPathologyVisit(int speechPathologyVisit) {
        this.speechPathologyVisit = speechPathologyVisit;
    }

    public int getSpeechPathologyUnit() {
        return speechPathologyUnit;
    }

    public void setSpeechPathologyUnit(int speechPathologyUnit) {
        this.speechPathologyUnit = speechPathologyUnit;
    }

    public String getSpeechPathologyRequestCategory() {
        return speechPathologyRequestCategory;
    }

    public void setSpeechPathologyRequestCategory(String speechPathologyRequestCategory) {
        this.speechPathologyRequestCategory = speechPathologyRequestCategory;
    }

    public String getSpeechPathologyCertificationType() {
        return speechPathologyCertificationType;
    }

    public void setSpeechPathologyCertificationType(String speechPathologyCertificationType) {
        this.speechPathologyCertificationType = speechPathologyCertificationType;
    }

    public String getSpeechPathologyServiceType() {
        return speechPathologyServiceType;
    }

    public void setSpeechPathologyServiceType(String speechPathologyServiceType) {
        this.speechPathologyServiceType = speechPathologyServiceType;
    }

    public String getSpeechPathologyLevelOfService() {
        return speechPathologyLevelOfService;
    }

    public void setSpeechPathologyLevelOfService(String speechPathologyLevelOfService) {
        this.speechPathologyLevelOfService = speechPathologyLevelOfService;
    }

    public String getSpeechPathologyProviderFullName() {
        return speechPathologyProviderFullName;
    }

    public void setSpeechPathologyProviderFullName(String speechPathologyProviderFullName) {
        this.speechPathologyProviderFullName = speechPathologyProviderFullName;
    }

    public String getSpeechPathologyProviderFirstName() {
        return speechPathologyProviderFirstName;
    }

    public void setSpeechPathologyProviderFirstName(String speechPathologyProviderFirstName) {
        this.speechPathologyProviderFirstName = speechPathologyProviderFirstName;
    }

    public String getSpeechPathologyPoviderLastName() {
        return speechPathologyPoviderLastName;
    }

    public void setSpeechPathologyPoviderLastName(String speechPathologyPoviderLastName) {
        this.speechPathologyPoviderLastName = speechPathologyPoviderLastName;
    }

    public String getSpeechPathologyProviderMiddleName() {
        return speechPathologyProviderMiddleName;
    }

    public void setSpeechPathologyProviderMiddleName(String speechPathologyProviderMiddleName) {
        this.speechPathologyProviderMiddleName = speechPathologyProviderMiddleName;
    }

    public String getSpeechPathologyProviderType() {
        return speechPathologyProviderType;
    }

    public void setSpeechPathologyProviderType(String speechPathologyProviderType) {
        this.speechPathologyProviderType = speechPathologyProviderType;
    }

    public String getSpeechPathologyProviderAddress() {
        return speechPathologyProviderAddress;
    }

    public void setSpeechPathologyProviderAddress(String speechPathologyProviderAddress) {
        this.speechPathologyProviderAddress = speechPathologyProviderAddress;
    }

    public String getSpeechPathologyProviderCity() {
        return speechPathologyProviderCity;
    }

    public void setSpeechPathologyProviderCity(String speechPathologyProviderCity) {
        this.speechPathologyProviderCity = speechPathologyProviderCity;
    }

    public String getSpeechPathologyProviderState() {
        return speechPathologyProviderState;
    }

    public void setSpeechPathologyProviderState(String speechPathologyProviderState) {
        this.speechPathologyProviderState = speechPathologyProviderState;
    }

    public String getSpeechPathologyProviderPostalCode() {
        return speechPathologyProviderPostalCode;
    }

    public void setSpeechPathologyProviderPostalCode(String speechPathologyProviderPostalCode) {
        this.speechPathologyProviderPostalCode = speechPathologyProviderPostalCode;
    }

    public String getSpeechPathologyProviderCountryCode() {
        return speechPathologyProviderCountryCode;
    }

    public void setSpeechPathologyProviderCountryCode(String speechPathologyProviderCountryCode) {
        this.speechPathologyProviderCountryCode = speechPathologyProviderCountryCode;
    }

    public String getSpeechPathologyProviderIdentificationNumber() {
        return speechPathologyProviderIdentificationNumber;
    }

    public void setSpeechPathologyProviderIdentificationNumber(String speechPathologyProviderIdentificationNumber) {
        this.speechPathologyProviderIdentificationNumber = speechPathologyProviderIdentificationNumber;
    }

    public String getSpeechPathologyProviderIdentificationNumberType() {
        return speechPathologyProviderIdentificationNumberType;
    }

    public void setSpeechPathologyProviderIdentificationNumberType(String speechPathologyProviderIdentificationNumberType) {
        this.speechPathologyProviderIdentificationNumberType = speechPathologyProviderIdentificationNumberType;
    }

    public String getSpeechPathologyProviderSupplimentalId() {
        return speechPathologyProviderSupplimentalId;
    }

    public void setSpeechPathologyProviderSupplimentalId(String speechPathologyProviderSupplimentalId) {
        this.speechPathologyProviderSupplimentalId = speechPathologyProviderSupplimentalId;
    }

    public String getSpeechPathologyProviderIdNumberType() {
        return speechPathologyProviderIdNumberType;
    }

    public void setSpeechPathologyProviderIdNumberType(String speechPathologyProviderIdNumberType) {
        this.speechPathologyProviderIdNumberType = speechPathologyProviderIdNumberType;
    }

    @Override
    public String toString() {
        return "SpeechPathology{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", speechPathologyRevenueCode=" + speechPathologyRevenueCode +
                ", speechPathologySelected=" + speechPathologySelected +
                ", speechPathologyRequestServiceDateFrom=" + speechPathologyRequestServiceDateFrom +
                ", speechPathologyRequestServiceDateTo=" + speechPathologyRequestServiceDateTo +
                ", speechPathologyVisit=" + speechPathologyVisit +
                ", speechPathologyUnit=" + speechPathologyUnit +
                ", speechPathologyRequestCategory='" + speechPathologyRequestCategory + '\'' +
                ", speechPathologyCertificationType='" + speechPathologyCertificationType + '\'' +
                ", speechPathologyServiceType='" + speechPathologyServiceType + '\'' +
                ", speechPathologyLevelOfService='" + speechPathologyLevelOfService + '\'' +
                ", speechPathologyProviderFullName='" + speechPathologyProviderFullName + '\'' +
                ", speechPathologyProviderFirstName='" + speechPathologyProviderFirstName + '\'' +
                ", speechPathologyPoviderLastName='" + speechPathologyPoviderLastName + '\'' +
                ", speechPathologyProviderMiddleName='" + speechPathologyProviderMiddleName + '\'' +
                ", speechPathologyProviderSuffix='" + speechPathologyProviderSuffix + '\'' +
                ", speechPathologyProviderPrefix='" + speechPathologyProviderPrefix + '\'' +
                ", speechPathologyProviderType='" + speechPathologyProviderType + '\'' +
                ", speechPathologyProviderAddress='" + speechPathologyProviderAddress + '\'' +
                ", speechPathologyProviderCity='" + speechPathologyProviderCity + '\'' +
                ", speechPathologyProviderState='" + speechPathologyProviderState + '\'' +
                ", speechPathologyProviderPostalCode='" + speechPathologyProviderPostalCode + '\'' +
                ", speechPathologyProviderCountryCode='" + speechPathologyProviderCountryCode + '\'' +
                ", speechPathologyProviderIdentificationNumber='" + speechPathologyProviderIdentificationNumber + '\'' +
                ", speechPathologyProviderIdentificationNumberType='" + speechPathologyProviderIdentificationNumberType + '\'' +
                ", speechPathologyProviderSupplimentalId='" + speechPathologyProviderSupplimentalId + '\'' +
                ", speechPathologyProviderIdNumberType='" + speechPathologyProviderIdNumberType + '\'' +
                '}';
    }
}
