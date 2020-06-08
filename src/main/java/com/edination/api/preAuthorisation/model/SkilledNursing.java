package com.edination.api.preAuthorisation.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SkilledNursing")
public class SkilledNursing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String mrnNumber;
    private int     skilledNursingRevenueCode;
    private boolean skilledNursingSelected;
    private Date skilledNursingRequestServiceDateFrom;
    private Date   skilledNursingRequestServiceDateTo;
    private int    skilledNursingVisit;
    private int    skilledNursingUnit;
    private String skilledNursingRequestCategory;
    private String skilledNursingCertificationType;
    private String skilledNursingServiceType;
    private String skilledNursingLevelOfService;
    private String  skilledNursingProviderFullName;
    private String skilledNursingProviderFirstName;
    private String skilledNursingPoviderLastName;
    private String skilledNursingProviderMiddleName;
    private String skilledNursingProviderType;
    private String skilledNursingProviderAddress;
    private String skilledNursingProviderCity;
    private String skilledNursingProviderState;
    private String skilledNursingProviderPostalCode;
    private String skilledNursingProviderCountryCode;
    private String skilledNursingProviderIdentificationNumber;
    private String skilledNursingProviderIdentificationNumberType;
    private String skilledNursingProviderSupplimentalId;
    private String skilledNursingProviderIdNumberType;

    public SkilledNursing() {
    }

    public SkilledNursing(String mrnNumber, int skilledNursingRevenueCode, boolean skilledNursingSelected, Date skilledNursingRequestServiceDateFrom, Date skilledNursingRequestServiceDateTo, int skilledNursingVisit, int skilledNursingUnit, String skilledNursingRequestCategory, String skilledNursingCertificationType, String skilledNursingServiceType, String skilledNursingLevelOfService, String skilledNursingProviderFullName, String skilledNursingProviderFirstName, String skilledNursingPoviderLastName, String skilledNursingProviderMiddleName, String skilledNursingProviderType, String skilledNursingProviderAddress, String skilledNursingProviderCity, String skilledNursingProviderState, String skilledNursingProviderPostalCode, String skilledNursingProviderCountryCode, String skilledNursingProviderIdentificationNumber, String skilledNursingProviderIdentificationNumberType, String skilledNursingProviderSupplimentalId, String skilledNursingProviderIdNumberType) {
        this.mrnNumber = mrnNumber;
        this.skilledNursingRevenueCode = skilledNursingRevenueCode;
        this.skilledNursingSelected = skilledNursingSelected;
        this.skilledNursingRequestServiceDateFrom = skilledNursingRequestServiceDateFrom;
        this.skilledNursingRequestServiceDateTo = skilledNursingRequestServiceDateTo;
        this.skilledNursingVisit = skilledNursingVisit;
        this.skilledNursingUnit = skilledNursingUnit;
        this.skilledNursingRequestCategory = skilledNursingRequestCategory;
        this.skilledNursingCertificationType = skilledNursingCertificationType;
        this.skilledNursingServiceType = skilledNursingServiceType;
        this.skilledNursingLevelOfService = skilledNursingLevelOfService;
        this.skilledNursingProviderFullName = skilledNursingProviderFullName;
        this.skilledNursingProviderFirstName = skilledNursingProviderFirstName;
        this.skilledNursingPoviderLastName = skilledNursingPoviderLastName;
        this.skilledNursingProviderMiddleName = skilledNursingProviderMiddleName;
        this.skilledNursingProviderType = skilledNursingProviderType;
        this.skilledNursingProviderAddress = skilledNursingProviderAddress;
        this.skilledNursingProviderCity = skilledNursingProviderCity;
        this.skilledNursingProviderState = skilledNursingProviderState;
        this.skilledNursingProviderPostalCode = skilledNursingProviderPostalCode;
        this.skilledNursingProviderCountryCode = skilledNursingProviderCountryCode;
        this.skilledNursingProviderIdentificationNumber = skilledNursingProviderIdentificationNumber;
        this.skilledNursingProviderIdentificationNumberType = skilledNursingProviderIdentificationNumberType;
        this.skilledNursingProviderSupplimentalId = skilledNursingProviderSupplimentalId;
        this.skilledNursingProviderIdNumberType = skilledNursingProviderIdNumberType;
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

    public int getSkilledNursingRevenueCode() {
        return skilledNursingRevenueCode;
    }

    public void setSkilledNursingRevenueCode(int skilledNursingRevenueCode) {
        this.skilledNursingRevenueCode = skilledNursingRevenueCode;
    }

    public boolean getSkilledNursingSelected() {
        return skilledNursingSelected;
    }

    public void setSkilledNursingSelected(boolean skilledNursingSelected) {
        this.skilledNursingSelected = skilledNursingSelected;
    }

    public Date getSkilledNursingRequestServiceDateFrom() {
        return skilledNursingRequestServiceDateFrom;
    }

    public void setSkilledNursingRequestServiceDateFrom(Date skilledNursingRequestServiceDateFrom) {
        this.skilledNursingRequestServiceDateFrom = skilledNursingRequestServiceDateFrom;
    }

    public Date getSkilledNursingRequestServiceDateTo() {
        return skilledNursingRequestServiceDateTo;
    }

    public void setSkilledNursingRequestServiceDateTo(Date skilledNursingRequestServiceDateTo) {
        this.skilledNursingRequestServiceDateTo = skilledNursingRequestServiceDateTo;
    }

    public int getSkilledNursingVisit() {
        return skilledNursingVisit;
    }

    public void setSkilledNursingVisit(int skilledNursingVisit) {
        this.skilledNursingVisit = skilledNursingVisit;
    }

    public int getSkilledNursingUnit() {
        return skilledNursingUnit;
    }

    public void setSkilledNursingUnit(int skilledNursingUnit) {
        this.skilledNursingUnit = skilledNursingUnit;
    }

    public String getSkilledNursingRequestCategory() {
        return skilledNursingRequestCategory;
    }

    public void setSkilledNursingRequestCategory(String skilledNursingRequestCategory) {
        this.skilledNursingRequestCategory = skilledNursingRequestCategory;
    }

    public String getSkilledNursingCertificationType() {
        return skilledNursingCertificationType;
    }

    public void setSkilledNursingCertificationType(String skilledNursingCertificationType) {
        this.skilledNursingCertificationType = skilledNursingCertificationType;
    }

    public String getSkilledNursingServiceType() {
        return skilledNursingServiceType;
    }

    public void setSkilledNursingServiceType(String skilledNursingServiceType) {
        this.skilledNursingServiceType = skilledNursingServiceType;
    }

    public String getSkilledNursingLevelOfService() {
        return skilledNursingLevelOfService;
    }

    public void setSkilledNursingLevelOfService(String skilledNursingLevelOfService) {
        this.skilledNursingLevelOfService = skilledNursingLevelOfService;
    }

    public String getSkilledNursingProviderFullName() {
        return skilledNursingProviderFullName;
    }

    public void setSkilledNursingProviderFullName(String skilledNursingProviderFullName) {
        this.skilledNursingProviderFullName = skilledNursingProviderFullName;
    }

    public String getSkilledNursingProviderFirstName() {
        return skilledNursingProviderFirstName;
    }

    public void setSkilledNursingProviderFirstName(String skilledNursingProviderFirstName) {
        this.skilledNursingProviderFirstName = skilledNursingProviderFirstName;
    }

    public String getSkilledNursingPoviderLastName() {
        return skilledNursingPoviderLastName;
    }

    public void setSkilledNursingPoviderLastName(String skilledNursingPoviderLastName) {
        this.skilledNursingPoviderLastName = skilledNursingPoviderLastName;
    }

    public String getSkilledNursingProviderMiddleName() {
        return skilledNursingProviderMiddleName;
    }

    public void setSkilledNursingProviderMiddleName(String skilledNursingProviderMiddleName) {
        this.skilledNursingProviderMiddleName = skilledNursingProviderMiddleName;
    }

    public String getSkilledNursingProviderType() {
        return skilledNursingProviderType;
    }

    public void setSkilledNursingProviderType(String skilledNursingProviderType) {
        this.skilledNursingProviderType = skilledNursingProviderType;
    }

    public String getSkilledNursingProviderAddress() {
        return skilledNursingProviderAddress;
    }

    public void setSkilledNursingProviderAddress(String skilledNursingProviderAddress) {
        this.skilledNursingProviderAddress = skilledNursingProviderAddress;
    }

    public String getSkilledNursingProviderCity() {
        return skilledNursingProviderCity;
    }

    public void setSkilledNursingProviderCity(String skilledNursingProviderCity) {
        this.skilledNursingProviderCity = skilledNursingProviderCity;
    }

    public String getSkilledNursingProviderState() {
        return skilledNursingProviderState;
    }

    public void setSkilledNursingProviderState(String skilledNursingProviderState) {
        this.skilledNursingProviderState = skilledNursingProviderState;
    }

    public String getSkilledNursingProviderPostalCode() {
        return skilledNursingProviderPostalCode;
    }

    public void setSkilledNursingProviderPostalCode(String skilledNursingProviderPostalCode) {
        this.skilledNursingProviderPostalCode = skilledNursingProviderPostalCode;
    }

    public String getSkilledNursingProviderCountryCode() {
        return skilledNursingProviderCountryCode;
    }

    public void setSkilledNursingProviderCountryCode(String skilledNursingProviderCountryCode) {
        this.skilledNursingProviderCountryCode = skilledNursingProviderCountryCode;
    }

    public String getSkilledNursingProviderIdentificationNumber() {
        return skilledNursingProviderIdentificationNumber;
    }

    public void setSkilledNursingProviderIdentificationNumber(String skilledNursingProviderIdentificationNumber) {
        this.skilledNursingProviderIdentificationNumber = skilledNursingProviderIdentificationNumber;
    }

    public String getSkilledNursingProviderIdentificationNumberType() {
        return skilledNursingProviderIdentificationNumberType;
    }

    public void setSkilledNursingProviderIdentificationNumberType(String skilledNursingProviderIdentificationNumberType) {
        this.skilledNursingProviderIdentificationNumberType = skilledNursingProviderIdentificationNumberType;
    }

    public String getSkilledNursingProviderSupplimentalId() {
        return skilledNursingProviderSupplimentalId;
    }

    public void setSkilledNursingProviderSupplimentalId(String skilledNursingProviderSupplimentalId) {
        this.skilledNursingProviderSupplimentalId = skilledNursingProviderSupplimentalId;
    }

    public String getSkilledNursingProviderIdNumberType() {
        return skilledNursingProviderIdNumberType;
    }

    public void setSkilledNursingProviderIdNumberType(String skilledNursingProviderIdNumberType) {
        this.skilledNursingProviderIdNumberType = skilledNursingProviderIdNumberType;
    }

    @Override
    public String toString() {
        return "SkilledNursing{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", skilledNursingRevenueCode=" + skilledNursingRevenueCode +
                ", skilledNursingSelected=" + skilledNursingSelected +
                ", skilledNursingRequestServiceDateFrom=" + skilledNursingRequestServiceDateFrom +
                ", skilledNursingRequestServiceDateTo=" + skilledNursingRequestServiceDateTo +
                ", skilledNursingVisit=" + skilledNursingVisit +
                ", skilledNursingUnit=" + skilledNursingUnit +
                ", skilledNursingRequestCategory='" + skilledNursingRequestCategory + '\'' +
                ", skilledNursingCertificationType='" + skilledNursingCertificationType + '\'' +
                ", skilledNursingServiceType='" + skilledNursingServiceType + '\'' +
                ", skilledNursingLevelOfService='" + skilledNursingLevelOfService + '\'' +
                ", skilledNursingProviderFullName='" + skilledNursingProviderFullName + '\'' +
                ", skilledNursingProviderFirstName='" + skilledNursingProviderFirstName + '\'' +
                ", skilledNursingPoviderLastName='" + skilledNursingPoviderLastName + '\'' +
                ", skilledNursingProviderMiddleName='" + skilledNursingProviderMiddleName + '\'' +
                ", skilledNursingProviderType='" + skilledNursingProviderType + '\'' +
                ", skilledNursingProviderAddress='" + skilledNursingProviderAddress + '\'' +
                ", skilledNursingProviderCity='" + skilledNursingProviderCity + '\'' +
                ", skilledNursingProviderState='" + skilledNursingProviderState + '\'' +
                ", skilledNursingProviderPostalCode='" + skilledNursingProviderPostalCode + '\'' +
                ", skilledNursingProviderCountryCode='" + skilledNursingProviderCountryCode + '\'' +
                ", skilledNursingProviderIdentificationNumber='" + skilledNursingProviderIdentificationNumber + '\'' +
                ", skilledNursingProviderIdentificationNumberType='" + skilledNursingProviderIdentificationNumberType + '\'' +
                ", skilledNursingProviderSupplimentalId='" + skilledNursingProviderSupplimentalId + '\'' +
                ", skilledNursingProviderIdNumberType='" + skilledNursingProviderIdNumberType + '\'' +
                '}';
    }
}
