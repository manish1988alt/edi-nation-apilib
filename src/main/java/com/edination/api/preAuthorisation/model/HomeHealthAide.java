package com.edination.api.preAuthorisation.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HomeHealthAide")
public class HomeHealthAide {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String mrnNumber;
    private int     homeHealthAideRevenueCode;
    private boolean homeHealthAideSelected;
    private Date homeHealthAideRequestServiceDateFrom;
    private Date   homeHealthAideRequestServiceDateTo;
    private int    homeHealthAideVisit;
    private int    homeHealthAideUnit;
    private String homeHealthAideRequestCategory;
    private String homeHealthAideCertificationType;
    private String homeHealthAideServiceType;
    private String homeHealthAideLevelOfService;
    private String  homeHealthAideProviderFullName;
    private String homeHealthAideProviderFirstName;
    private String homeHealthAidePoviderLastName;
    private String homeHealthAideProviderMiddleName;
    private String homeHealthAideProviderType;
    private String homeHealthAideProviderAddress;
    private String homeHealthAideProviderCity;
    private String homeHealthAideProviderState;
    private String homeHealthAideProviderPostalCode;
    private String homeHealthAideProviderCountryCode;
    private String homeHealthAideProviderIdentificationNumber;
    private String homeHealthAideProviderIdentificationNumberType;
    private String homeHealthAideProviderSupplimentalId;
    private String homeHealthAideProviderIdNumberType;

    public HomeHealthAide() {
    }

    public HomeHealthAide(String mrnNumber, int homeHealthAideRevenueCode, boolean homeHealthAideSelected, Date homeHealthAideRequestServiceDateFrom, Date homeHealthAideRequestServiceDateTo, int homeHealthAideVisit, int homeHealthAideUnit, String homeHealthAideRequestCategory, String homeHealthAideCertificationType, String homeHealthAideServiceType, String homeHealthAideLevelOfService, String homeHealthAideProviderFullName, String homeHealthAideProviderFirstName, String homeHealthAidePoviderLastName, String homeHealthAideProviderMiddleName, String homeHealthAideProviderType, String homeHealthAideProviderAddress, String homeHealthAideProviderCity, String homeHealthAideProviderState, String homeHealthAideProviderPostalCode, String homeHealthAideProviderCountryCode, String homeHealthAideProviderIdentificationNumber, String homeHealthAideProviderIdentificationNumberType, String homeHealthAideProviderSupplimentalId, String homeHealthAideProviderIdNumberType) {
        this.mrnNumber = mrnNumber;
        this.homeHealthAideRevenueCode = homeHealthAideRevenueCode;
        this.homeHealthAideSelected = homeHealthAideSelected;
        this.homeHealthAideRequestServiceDateFrom = homeHealthAideRequestServiceDateFrom;
        this.homeHealthAideRequestServiceDateTo = homeHealthAideRequestServiceDateTo;
        this.homeHealthAideVisit = homeHealthAideVisit;
        this.homeHealthAideUnit = homeHealthAideUnit;
        this.homeHealthAideRequestCategory = homeHealthAideRequestCategory;
        this.homeHealthAideCertificationType = homeHealthAideCertificationType;
        this.homeHealthAideServiceType = homeHealthAideServiceType;
        this.homeHealthAideLevelOfService = homeHealthAideLevelOfService;
        this.homeHealthAideProviderFullName = homeHealthAideProviderFullName;
        this.homeHealthAideProviderFirstName = homeHealthAideProviderFirstName;
        this.homeHealthAidePoviderLastName = homeHealthAidePoviderLastName;
        this.homeHealthAideProviderMiddleName = homeHealthAideProviderMiddleName;
        this.homeHealthAideProviderType = homeHealthAideProviderType;
        this.homeHealthAideProviderAddress = homeHealthAideProviderAddress;
        this.homeHealthAideProviderCity = homeHealthAideProviderCity;
        this.homeHealthAideProviderState = homeHealthAideProviderState;
        this.homeHealthAideProviderPostalCode = homeHealthAideProviderPostalCode;
        this.homeHealthAideProviderCountryCode = homeHealthAideProviderCountryCode;
        this.homeHealthAideProviderIdentificationNumber = homeHealthAideProviderIdentificationNumber;
        this.homeHealthAideProviderIdentificationNumberType = homeHealthAideProviderIdentificationNumberType;
        this.homeHealthAideProviderSupplimentalId = homeHealthAideProviderSupplimentalId;
        this.homeHealthAideProviderIdNumberType = homeHealthAideProviderIdNumberType;
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

    public int getHomeHealthAideRevenueCode() {
        return homeHealthAideRevenueCode;
    }

    public void setHomeHealthAideRevenueCode(int homeHealthAideRevenueCode) {
        this.homeHealthAideRevenueCode = homeHealthAideRevenueCode;
    }

    public boolean getHomeHealthAideSelected() {
        return homeHealthAideSelected;
    }

    public void setHomeHealthAideSelected(boolean homeHealthAideSelected) {
        this.homeHealthAideSelected = homeHealthAideSelected;
    }

    public Date getHomeHealthAideRequestServiceDateFrom() {
        return homeHealthAideRequestServiceDateFrom;
    }

    public void setHomeHealthAideRequestServiceDateFrom(Date homeHealthAideRequestServiceDateFrom) {
        this.homeHealthAideRequestServiceDateFrom = homeHealthAideRequestServiceDateFrom;
    }

    public Date getHomeHealthAideRequestServiceDateTo() {
        return homeHealthAideRequestServiceDateTo;
    }

    public void setHomeHealthAideRequestServiceDateTo(Date homeHealthAideRequestServiceDateTo) {
        this.homeHealthAideRequestServiceDateTo = homeHealthAideRequestServiceDateTo;
    }

    public int getHomeHealthAideVisit() {
        return homeHealthAideVisit;
    }

    public void setHomeHealthAideVisit(int homeHealthAideVisit) {
        this.homeHealthAideVisit = homeHealthAideVisit;
    }

    public int getHomeHealthAideUnit() {
        return homeHealthAideUnit;
    }

    public void setHomeHealthAideUnit(int homeHealthAideUnit) {
        this.homeHealthAideUnit = homeHealthAideUnit;
    }

    public String getHomeHealthAideRequestCategory() {
        return homeHealthAideRequestCategory;
    }

    public void setHomeHealthAideRequestCategory(String homeHealthAideRequestCategory) {
        this.homeHealthAideRequestCategory = homeHealthAideRequestCategory;
    }

    public String getHomeHealthAideCertificationType() {
        return homeHealthAideCertificationType;
    }

    public void setHomeHealthAideCertificationType(String homeHealthAideCertificationType) {
        this.homeHealthAideCertificationType = homeHealthAideCertificationType;
    }

    public String getHomeHealthAideServiceType() {
        return homeHealthAideServiceType;
    }

    public void setHomeHealthAideServiceType(String homeHealthAideServiceType) {
        this.homeHealthAideServiceType = homeHealthAideServiceType;
    }

    public String getHomeHealthAideLevelOfService() {
        return homeHealthAideLevelOfService;
    }

    public void setHomeHealthAideLevelOfService(String homeHealthAideLevelOfService) {
        this.homeHealthAideLevelOfService = homeHealthAideLevelOfService;
    }

    public String getHomeHealthAideProviderFullName() {
        return homeHealthAideProviderFullName;
    }

    public void setHomeHealthAideProviderFullName(String homeHealthAideProviderFullName) {
        this.homeHealthAideProviderFullName = homeHealthAideProviderFullName;
    }

    public String getHomeHealthAideProviderFirstName() {
        return homeHealthAideProviderFirstName;
    }

    public void setHomeHealthAideProviderFirstName(String homeHealthAideProviderFirstName) {
        this.homeHealthAideProviderFirstName = homeHealthAideProviderFirstName;
    }

    public String getHomeHealthAidePoviderLastName() {
        return homeHealthAidePoviderLastName;
    }

    public void setHomeHealthAidePoviderLastName(String homeHealthAidePoviderLastName) {
        this.homeHealthAidePoviderLastName = homeHealthAidePoviderLastName;
    }

    public String getHomeHealthAideProviderMiddleName() {
        return homeHealthAideProviderMiddleName;
    }

    public void setHomeHealthAideProviderMiddleName(String homeHealthAideProviderMiddleName) {
        this.homeHealthAideProviderMiddleName = homeHealthAideProviderMiddleName;
    }

    public String getHomeHealthAideProviderType() {
        return homeHealthAideProviderType;
    }

    public void setHomeHealthAideProviderType(String homeHealthAideProviderType) {
        this.homeHealthAideProviderType = homeHealthAideProviderType;
    }

    public String getHomeHealthAideProviderAddress() {
        return homeHealthAideProviderAddress;
    }

    public void setHomeHealthAideProviderAddress(String homeHealthAideProviderAddress) {
        this.homeHealthAideProviderAddress = homeHealthAideProviderAddress;
    }

    public String getHomeHealthAideProviderCity() {
        return homeHealthAideProviderCity;
    }

    public void setHomeHealthAideProviderCity(String homeHealthAideProviderCity) {
        this.homeHealthAideProviderCity = homeHealthAideProviderCity;
    }

    public String getHomeHealthAideProviderState() {
        return homeHealthAideProviderState;
    }

    public void setHomeHealthAideProviderState(String homeHealthAideProviderState) {
        this.homeHealthAideProviderState = homeHealthAideProviderState;
    }

    public String getHomeHealthAideProviderPostalCode() {
        return homeHealthAideProviderPostalCode;
    }

    public void setHomeHealthAideProviderPostalCode(String homeHealthAideProviderPostalCode) {
        this.homeHealthAideProviderPostalCode = homeHealthAideProviderPostalCode;
    }

    public String getHomeHealthAideProviderCountryCode() {
        return homeHealthAideProviderCountryCode;
    }

    public void setHomeHealthAideProviderCountryCode(String homeHealthAideProviderCountryCode) {
        this.homeHealthAideProviderCountryCode = homeHealthAideProviderCountryCode;
    }

    public String getHomeHealthAideProviderIdentificationNumber() {
        return homeHealthAideProviderIdentificationNumber;
    }

    public void setHomeHealthAideProviderIdentificationNumber(String homeHealthAideProviderIdentificationNumber) {
        this.homeHealthAideProviderIdentificationNumber = homeHealthAideProviderIdentificationNumber;
    }

    public String getHomeHealthAideProviderIdentificationNumberType() {
        return homeHealthAideProviderIdentificationNumberType;
    }

    public void setHomeHealthAideProviderIdentificationNumberType(String homeHealthAideProviderIdentificationNumberType) {
        this.homeHealthAideProviderIdentificationNumberType = homeHealthAideProviderIdentificationNumberType;
    }

    public String getHomeHealthAideProviderSupplimentalId() {
        return homeHealthAideProviderSupplimentalId;
    }

    public void setHomeHealthAideProviderSupplimentalId(String homeHealthAideProviderSupplimentalId) {
        this.homeHealthAideProviderSupplimentalId = homeHealthAideProviderSupplimentalId;
    }

    public String getHomeHealthAideProviderIdNumberType() {
        return homeHealthAideProviderIdNumberType;
    }

    public void setHomeHealthAideProviderIdNumberType(String homeHealthAideProviderIdNumberType) {
        this.homeHealthAideProviderIdNumberType = homeHealthAideProviderIdNumberType;
    }

    @Override
    public String toString() {
        return "HomeHealthAide{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", homeHealthAideRevenueCode=" + homeHealthAideRevenueCode +
                ", homeHealthAideSelected=" + homeHealthAideSelected +
                ", homeHealthAideRequestServiceDateFrom=" + homeHealthAideRequestServiceDateFrom +
                ", homeHealthAideRequestServiceDateTo=" + homeHealthAideRequestServiceDateTo +
                ", homeHealthAideVisit=" + homeHealthAideVisit +
                ", homeHealthAideUnit=" + homeHealthAideUnit +
                ", homeHealthAideRequestCategory='" + homeHealthAideRequestCategory + '\'' +
                ", homeHealthAideCertificationType='" + homeHealthAideCertificationType + '\'' +
                ", homeHealthAideServiceType='" + homeHealthAideServiceType + '\'' +
                ", homeHealthAideLevelOfService='" + homeHealthAideLevelOfService + '\'' +
                ", homeHealthAideProviderFullName='" + homeHealthAideProviderFullName + '\'' +
                ", homeHealthAideProviderFirstName='" + homeHealthAideProviderFirstName + '\'' +
                ", homeHealthAidePoviderLastName='" + homeHealthAidePoviderLastName + '\'' +
                ", homeHealthAideProviderMiddleName='" + homeHealthAideProviderMiddleName + '\'' +
                ", homeHealthAideProviderType='" + homeHealthAideProviderType + '\'' +
                ", homeHealthAideProviderAddress='" + homeHealthAideProviderAddress + '\'' +
                ", homeHealthAideProviderCity='" + homeHealthAideProviderCity + '\'' +
                ", homeHealthAideProviderState='" + homeHealthAideProviderState + '\'' +
                ", homeHealthAideProviderPostalCode='" + homeHealthAideProviderPostalCode + '\'' +
                ", homeHealthAideProviderCountryCode='" + homeHealthAideProviderCountryCode + '\'' +
                ", homeHealthAideProviderIdentificationNumber='" + homeHealthAideProviderIdentificationNumber + '\'' +
                ", homeHealthAideProviderIdentificationNumberType='" + homeHealthAideProviderIdentificationNumberType + '\'' +
                ", homeHealthAideProviderSupplimentalId='" + homeHealthAideProviderSupplimentalId + '\'' +
                ", homeHealthAideProviderIdNumberType='" + homeHealthAideProviderIdNumberType + '\'' +
                '}';
    }
}
