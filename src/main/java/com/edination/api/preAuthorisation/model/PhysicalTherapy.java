package com.edination.api.preAuthorisation.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PhysicalTherapy")
public class PhysicalTherapy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String  mrnNumber;
    private int     physicalTherapyrevenueCode;
    private boolean physicalTherapySelected;
    private Date   physicalTherapyRequestServiceDateFrom;
    private Date   physicalTherapyRequestServiceDateTo;
    private int    physicalTherapyVisit;
    private int    physicalTherapyUnit;
    private String physicalTherapyRequestCategory;
    private String physicalTherapyCertificationType;
    private String physicalTherapyServiceType;
    private String physicalTherapyLevelOfService;
    private String  physicalTherapyProviderFullName;
    private String physicalTherapyProviderFirstName;
    private String physicalTherapyPoviderLastName;
    private String physicalTherapyProviderMiddleName;
    private String physicalTherapyProviderSuffix;
    private String physicalTherapyProviderPrefix;
    private String physicalTherapyProviderType;
    private String physicalTherapyProviderAddress;
    private String physicalTherapyProviderCity;
    private String physicalTherapyProviderState;
    private String physicalTherapyProviderPostalCode;
    private String physicalTherapyProviderCountryCode;
    private String physicalTherapyProviderIdentificationNumber;
    private String physicalTherapyProviderIdentificationNumberType;
    private String physicalTherapyProviderSupplimentalId;
    private String physicalTherapyProviderIdNumberType;



    public PhysicalTherapy() {
    }

    public PhysicalTherapy(String mrnNumber, int physicalTherapyrevenueCode, boolean physicalTherapySelected, Date physicalTherapyRequestServiceDateFrom, Date physicalTherapyRequestServiceDateTo, int physicalTherapyVisit, int physicalTherapyUnit, String physicalTherapyRequestCategory, String physicalTherapyCertificationType, String physicalTherapyServiceType, String physicalTherapyLevelOfService, String physicalTherapyProviderFullName, String physicalTherapyProviderFirstName, String physicalTherapyPoviderLastName, String physicalTherapyProviderMiddleName, String physicalTherapyProviderSuffix, String physicalTherapyProviderPrefix, String physicalTherapyProviderType, String physicalTherapyProviderAddress, String physicalTherapyProviderCity, String physicalTherapyProviderState, String physicalTherapyProviderPostalCode, String physicalTherapyProviderCountryCode, String physicalTherapyProviderIdentificationNumber, String physicalTherapyProviderIdentificationNumberType, String physicalTherapyProviderSupplimentalId, String physicalTherapyProviderIdNumberType) {
        this.mrnNumber = mrnNumber;
        this.physicalTherapyrevenueCode = physicalTherapyrevenueCode;
        this.physicalTherapySelected = physicalTherapySelected;
        this.physicalTherapyRequestServiceDateFrom = physicalTherapyRequestServiceDateFrom;
        this.physicalTherapyRequestServiceDateTo = physicalTherapyRequestServiceDateTo;
        this.physicalTherapyVisit = physicalTherapyVisit;
        this.physicalTherapyUnit = physicalTherapyUnit;
        this.physicalTherapyRequestCategory = physicalTherapyRequestCategory;
        this.physicalTherapyCertificationType = physicalTherapyCertificationType;
        this.physicalTherapyServiceType = physicalTherapyServiceType;
        this.physicalTherapyLevelOfService = physicalTherapyLevelOfService;
        this.physicalTherapyProviderFullName = physicalTherapyProviderFullName;
        this.physicalTherapyProviderFirstName = physicalTherapyProviderFirstName;
        this.physicalTherapyPoviderLastName = physicalTherapyPoviderLastName;
        this.physicalTherapyProviderMiddleName = physicalTherapyProviderMiddleName;
        this.physicalTherapyProviderSuffix = physicalTherapyProviderSuffix;
        this.physicalTherapyProviderPrefix = physicalTherapyProviderPrefix;
        this.physicalTherapyProviderType = physicalTherapyProviderType;
        this.physicalTherapyProviderAddress = physicalTherapyProviderAddress;
        this.physicalTherapyProviderCity = physicalTherapyProviderCity;
        this.physicalTherapyProviderState = physicalTherapyProviderState;
        this.physicalTherapyProviderPostalCode = physicalTherapyProviderPostalCode;
        this.physicalTherapyProviderCountryCode = physicalTherapyProviderCountryCode;
        this.physicalTherapyProviderIdentificationNumber = physicalTherapyProviderIdentificationNumber;
        this.physicalTherapyProviderIdentificationNumberType = physicalTherapyProviderIdentificationNumberType;
        this.physicalTherapyProviderSupplimentalId = physicalTherapyProviderSupplimentalId;
        this.physicalTherapyProviderIdNumberType = physicalTherapyProviderIdNumberType;
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

    public int getPhysicalTherapyrevenueCode() {
        return physicalTherapyrevenueCode;
    }

    public void setPhysicalTherapyrevenueCode(int physicalTherapyrevenueCode) {
        this.physicalTherapyrevenueCode = physicalTherapyrevenueCode;
    }

    public boolean getPhysicalTherapySelected() {
        return physicalTherapySelected;
    }

    public void setPhysicalTherapySelected(boolean physicalTherapySelected) {
        this.physicalTherapySelected = physicalTherapySelected;
    }

    public Date getPhysicalTherapyRequestServiceDateFrom() {
        return physicalTherapyRequestServiceDateFrom;
    }

    public void setPhysicalTherapyRequestServiceDateFrom(Date physicalTherapyRequestServiceDateFrom) {
        this.physicalTherapyRequestServiceDateFrom = physicalTherapyRequestServiceDateFrom;
    }

    public Date getPhysicalTherapyRequestServiceDateTo() {
        return physicalTherapyRequestServiceDateTo;
    }

    public void setPhysicalTherapyRequestServiceDateTo(Date physicalTherapyRequestServiceDateTo) {
        this.physicalTherapyRequestServiceDateTo = physicalTherapyRequestServiceDateTo;
    }

    public int getPhysicalTherapyVisit() {
        return physicalTherapyVisit;
    }

    public void setPhysicalTherapyVisit(int physicalTherapyVisit) {
        this.physicalTherapyVisit = physicalTherapyVisit;
    }

    public int getPhysicalTherapyUnit() {
        return physicalTherapyUnit;
    }

    public void setPhysicalTherapyUnit(int physicalTherapyUnit) {
        this.physicalTherapyUnit = physicalTherapyUnit;
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

    public String getPhysicalTherapyProviderFullName() {
        return physicalTherapyProviderFullName;
    }

    public void setPhysicalTherapyProviderFullName(String physicalTherapyProviderFullName) {
        this.physicalTherapyProviderFullName = physicalTherapyProviderFullName;
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

    @Override
    public String toString() {
        return "PhysicalTherapy{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", physicalTherapyrevenueCode=" + physicalTherapyrevenueCode +
                ", physicalTherapySelected=" + physicalTherapySelected +
                ", physicalTherapyRequestServiceDateFrom=" + physicalTherapyRequestServiceDateFrom +
                ", physicalTherapyRequestServiceDateTo=" + physicalTherapyRequestServiceDateTo +
                ", physicalTherapyVisit=" + physicalTherapyVisit +
                ", physicalTherapyUnit=" + physicalTherapyUnit +
                ", physicalTherapyRequestCategory='" + physicalTherapyRequestCategory + '\'' +
                ", physicalTherapyCertificationType='" + physicalTherapyCertificationType + '\'' +
                ", physicalTherapyServiceType='" + physicalTherapyServiceType + '\'' +
                ", physicalTherapyLevelOfService='" + physicalTherapyLevelOfService + '\'' +
                ", physicalTherapyProviderFullName='" + physicalTherapyProviderFullName + '\'' +
                ", physicalTherapyProviderFirstName='" + physicalTherapyProviderFirstName + '\'' +
                ", physicalTherapyPoviderLastName='" + physicalTherapyPoviderLastName + '\'' +
                ", physicalTherapyProviderMiddleName='" + physicalTherapyProviderMiddleName + '\'' +
                ", physicalTherapyProviderSuffix='" + physicalTherapyProviderSuffix + '\'' +
                ", physicalTherapyProviderPrefix='" + physicalTherapyProviderPrefix + '\'' +
                ", physicalTherapyProviderType='" + physicalTherapyProviderType + '\'' +
                ", physicalTherapyProviderAddress='" + physicalTherapyProviderAddress + '\'' +
                ", physicalTherapyProviderCity='" + physicalTherapyProviderCity + '\'' +
                ", physicalTherapyProviderState='" + physicalTherapyProviderState + '\'' +
                ", physicalTherapyProviderPostalCode='" + physicalTherapyProviderPostalCode + '\'' +
                ", physicalTherapyProviderCountryCode='" + physicalTherapyProviderCountryCode + '\'' +
                ", physicalTherapyProviderIdentificationNumber='" + physicalTherapyProviderIdentificationNumber + '\'' +
                ", physicalTherapyProviderIdentificationNumberType='" + physicalTherapyProviderIdentificationNumberType + '\'' +
                ", physicalTherapyProviderSupplimentalId='" + physicalTherapyProviderSupplimentalId + '\'' +
                ", physicalTherapyProviderIdNumberType='" + physicalTherapyProviderIdNumberType + '\'' +
                '}';
    }
}
