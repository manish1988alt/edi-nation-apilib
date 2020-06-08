package com.edination.api.preAuthorisation.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "OccupationTherapy")
public class OccupationTherapy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mrnNumber;
    private int     occupationTherapyRevenueCode;
    private boolean occupationTherapySelected;
    private Date occupationTherapyRequestServiceDateFrom;
    private Date   occupationTherapyRequestServiceDateTo;
    private int    occupationTherapyVisit;
    private int    occupationTherapyUnit;
    private String occupationTherapyRequestCategory;
    private String occupationTherapyCertificationType;
    private String occupationTherapyServiceType;
    private String occupationTherapyLevelOfService;
    private String  occupationTherapyProviderFullName;
    private String occupationTherapyProviderFirstName;
    private String occupationTherapyPoviderLastName;
    private String occupationTherapyProviderMiddleName;
    private String occupationTherapyProviderType;
    private String occupationTherapyProviderAddress;
    private String occupationTherapyProviderCity;
    private String occupationTherapyProviderState;
    private String occupationTherapyProviderPostalCode;
    private String occupationTherapyProviderCountryCode;
    private String occupationTherapyProviderIdentificationNumber;
    private String occupationTherapyProviderIdentificationNumberType;
    private String occupationTherapyProviderSupplimentalId;
    private String occupationTherapyProviderIdNumberType;

    public OccupationTherapy() {
    }

    public OccupationTherapy(String mrnNumber, int occupationTherapyRevenueCode, boolean occupationTherapySelected, Date occupationTherapyRequestServiceDateFrom, Date occupationTherapyRequestServiceDateTo, int occupationTherapyVisit, int occupationTherapyUnit, String occupationTherapyRequestCategory, String occupationTherapyCertificationType, String occupationTherapyServiceType, String occupationTherapyLevelOfService, String occupationTherapyProviderFullName, String occupationTherapyProviderFirstName, String occupationTherapyPoviderLastName, String occupationTherapyProviderMiddleName, String occupationTherapyProviderType, String occupationTherapyProviderAddress, String occupationTherapyProviderCity, String occupationTherapyProviderState, String occupationTherapyProviderPostalCode, String occupationTherapyProviderCountryCode, String occupationTherapyProviderIdentificationNumber, String occupationTherapyProviderIdentificationNumberType, String occupationTherapyProviderSupplimentalId, String occupationTherapyProviderIdNumberType) {
        this.mrnNumber = mrnNumber;
        this.occupationTherapyRevenueCode = occupationTherapyRevenueCode;
        this.occupationTherapySelected = occupationTherapySelected;
        this.occupationTherapyRequestServiceDateFrom = occupationTherapyRequestServiceDateFrom;
        this.occupationTherapyRequestServiceDateTo = occupationTherapyRequestServiceDateTo;
        this.occupationTherapyVisit = occupationTherapyVisit;
        this.occupationTherapyUnit = occupationTherapyUnit;
        this.occupationTherapyRequestCategory = occupationTherapyRequestCategory;
        this.occupationTherapyCertificationType = occupationTherapyCertificationType;
        this.occupationTherapyServiceType = occupationTherapyServiceType;
        this.occupationTherapyLevelOfService = occupationTherapyLevelOfService;
        this.occupationTherapyProviderFullName = occupationTherapyProviderFullName;
        this.occupationTherapyProviderFirstName = occupationTherapyProviderFirstName;
        this.occupationTherapyPoviderLastName = occupationTherapyPoviderLastName;
        this.occupationTherapyProviderMiddleName = occupationTherapyProviderMiddleName;
        this.occupationTherapyProviderType = occupationTherapyProviderType;
        this.occupationTherapyProviderAddress = occupationTherapyProviderAddress;
        this.occupationTherapyProviderCity = occupationTherapyProviderCity;
        this.occupationTherapyProviderState = occupationTherapyProviderState;
        this.occupationTherapyProviderPostalCode = occupationTherapyProviderPostalCode;
        this.occupationTherapyProviderCountryCode = occupationTherapyProviderCountryCode;
        this.occupationTherapyProviderIdentificationNumber = occupationTherapyProviderIdentificationNumber;
        this.occupationTherapyProviderIdentificationNumberType = occupationTherapyProviderIdentificationNumberType;
        this.occupationTherapyProviderSupplimentalId = occupationTherapyProviderSupplimentalId;
        this.occupationTherapyProviderIdNumberType = occupationTherapyProviderIdNumberType;
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

    public int getOccupationTherapyRevenueCode() {
        return occupationTherapyRevenueCode;
    }

    public void setOccupationTherapyRevenueCode(int occupationTherapyRevenueCode) {
        this.occupationTherapyRevenueCode = occupationTherapyRevenueCode;
    }

    public boolean getOccupationTherapySelected() {
        return occupationTherapySelected;
    }

    public void setOccupationTherapySelected(boolean occupationTherapySelected) {
        this.occupationTherapySelected = occupationTherapySelected;
    }

    public Date getOccupationTherapyRequestServiceDateFrom() {
        return occupationTherapyRequestServiceDateFrom;
    }

    public void setOccupationTherapyRequestServiceDateFrom(Date occupationTherapyRequestServiceDateFrom) {
        this.occupationTherapyRequestServiceDateFrom = occupationTherapyRequestServiceDateFrom;
    }

    public Date getOccupationTherapyRequestServiceDateTo() {
        return occupationTherapyRequestServiceDateTo;
    }

    public void setOccupationTherapyRequestServiceDateTo(Date occupationTherapyRequestServiceDateTo) {
        this.occupationTherapyRequestServiceDateTo = occupationTherapyRequestServiceDateTo;
    }

    public int getOccupationTherapyVisit() {
        return occupationTherapyVisit;
    }

    public void setOccupationTherapyVisit(int occupationTherapyVisit) {
        this.occupationTherapyVisit = occupationTherapyVisit;
    }

    public int getOccupationTherapyUnit() {
        return occupationTherapyUnit;
    }

    public void setOccupationTherapyUnit(int occupationTherapyUnit) {
        this.occupationTherapyUnit = occupationTherapyUnit;
    }

    public String getOccupationTherapyRequestCategory() {
        return occupationTherapyRequestCategory;
    }

    public void setOccupationTherapyRequestCategory(String occupationTherapyRequestCategory) {
        this.occupationTherapyRequestCategory = occupationTherapyRequestCategory;
    }

    public String getOccupationTherapyCertificationType() {
        return occupationTherapyCertificationType;
    }

    public void setOccupationTherapyCertificationType(String occupationTherapyCertificationType) {
        this.occupationTherapyCertificationType = occupationTherapyCertificationType;
    }

    public String getOccupationTherapyServiceType() {
        return occupationTherapyServiceType;
    }

    public void setOccupationTherapyServiceType(String occupationTherapyServiceType) {
        this.occupationTherapyServiceType = occupationTherapyServiceType;
    }

    public String getOccupationTherapyLevelOfService() {
        return occupationTherapyLevelOfService;
    }

    public void setOccupationTherapyLevelOfService(String occupationTherapyLevelOfService) {
        this.occupationTherapyLevelOfService = occupationTherapyLevelOfService;
    }

    public String getOccupationTherapyProviderFullName() {
        return occupationTherapyProviderFullName;
    }

    public void setOccupationTherapyProviderFullName(String occupationTherapyProviderFullName) {
        this.occupationTherapyProviderFullName = occupationTherapyProviderFullName;
    }

    public String getOccupationTherapyProviderFirstName() {
        return occupationTherapyProviderFirstName;
    }

    public void setOccupationTherapyProviderFirstName(String occupationTherapyProviderFirstName) {
        this.occupationTherapyProviderFirstName = occupationTherapyProviderFirstName;
    }

    public String getOccupationTherapyPoviderLastName() {
        return occupationTherapyPoviderLastName;
    }

    public void setOccupationTherapyPoviderLastName(String occupationTherapyPoviderLastName) {
        this.occupationTherapyPoviderLastName = occupationTherapyPoviderLastName;
    }

    public String getOccupationTherapyProviderMiddleName() {
        return occupationTherapyProviderMiddleName;
    }

    public void setOccupationTherapyProviderMiddleName(String occupationTherapyProviderMiddleName) {
        this.occupationTherapyProviderMiddleName = occupationTherapyProviderMiddleName;
    }

    public String getOccupationTherapyProviderType() {
        return occupationTherapyProviderType;
    }

    public void setOccupationTherapyProviderType(String occupationTherapyProviderType) {
        this.occupationTherapyProviderType = occupationTherapyProviderType;
    }

    public String getOccupationTherapyProviderAddress() {
        return occupationTherapyProviderAddress;
    }

    public void setOccupationTherapyProviderAddress(String occupationTherapyProviderAddress) {
        this.occupationTherapyProviderAddress = occupationTherapyProviderAddress;
    }

    public String getOccupationTherapyProviderCity() {
        return occupationTherapyProviderCity;
    }

    public void setOccupationTherapyProviderCity(String occupationTherapyProviderCity) {
        this.occupationTherapyProviderCity = occupationTherapyProviderCity;
    }

    public String getOccupationTherapyProviderState() {
        return occupationTherapyProviderState;
    }

    public void setOccupationTherapyProviderState(String occupationTherapyProviderState) {
        this.occupationTherapyProviderState = occupationTherapyProviderState;
    }

    public String getOccupationTherapyProviderPostalCode() {
        return occupationTherapyProviderPostalCode;
    }

    public void setOccupationTherapyProviderPostalCode(String occupationTherapyProviderPostalCode) {
        this.occupationTherapyProviderPostalCode = occupationTherapyProviderPostalCode;
    }

    public String getOccupationTherapyProviderCountryCode() {
        return occupationTherapyProviderCountryCode;
    }

    public void setOccupationTherapyProviderCountryCode(String occupationTherapyProviderCountryCode) {
        this.occupationTherapyProviderCountryCode = occupationTherapyProviderCountryCode;
    }

    public String getOccupationTherapyProviderIdentificationNumber() {
        return occupationTherapyProviderIdentificationNumber;
    }

    public void setOccupationTherapyProviderIdentificationNumber(String occupationTherapyProviderIdentificationNumber) {
        this.occupationTherapyProviderIdentificationNumber = occupationTherapyProviderIdentificationNumber;
    }

    public String getOccupationTherapyProviderIdentificationNumberType() {
        return occupationTherapyProviderIdentificationNumberType;
    }

    public void setOccupationTherapyProviderIdentificationNumberType(String occupationTherapyProviderIdentificationNumberType) {
        this.occupationTherapyProviderIdentificationNumberType = occupationTherapyProviderIdentificationNumberType;
    }

    public String getOccupationTherapyProviderSupplimentalId() {
        return occupationTherapyProviderSupplimentalId;
    }

    public void setOccupationTherapyProviderSupplimentalId(String occupationTherapyProviderSupplimentalId) {
        this.occupationTherapyProviderSupplimentalId = occupationTherapyProviderSupplimentalId;
    }

    public String getOccupationTherapyProviderIdNumberType() {
        return occupationTherapyProviderIdNumberType;
    }

    public void setOccupationTherapyProviderIdNumberType(String occupationTherapyProviderIdNumberType) {
        this.occupationTherapyProviderIdNumberType = occupationTherapyProviderIdNumberType;
    }

    @Override
    public String toString() {
        return "OccupationTherapy{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", occupationTherapyRevenueCode=" + occupationTherapyRevenueCode +
                ", occupationTherapySelected=" + occupationTherapySelected +
                ", occupationTherapyRequestServiceDateFrom=" + occupationTherapyRequestServiceDateFrom +
                ", occupationTherapyRequestServiceDateTo=" + occupationTherapyRequestServiceDateTo +
                ", occupationTherapyVisit=" + occupationTherapyVisit +
                ", occupationTherapyUnit=" + occupationTherapyUnit +
                ", occupationTherapyRequestCategory='" + occupationTherapyRequestCategory + '\'' +
                ", occupationTherapyCertificationType='" + occupationTherapyCertificationType + '\'' +
                ", occupationTherapyServiceType='" + occupationTherapyServiceType + '\'' +
                ", occupationTherapyLevelOfService='" + occupationTherapyLevelOfService + '\'' +
                ", occupationTherapyProviderFullName='" + occupationTherapyProviderFullName + '\'' +
                ", occupationTherapyProviderFirstName='" + occupationTherapyProviderFirstName + '\'' +
                ", occupationTherapyPoviderLastName='" + occupationTherapyPoviderLastName + '\'' +
                ", occupationTherapyProviderMiddleName='" + occupationTherapyProviderMiddleName + '\'' +
                ", occupationTherapyProviderType='" + occupationTherapyProviderType + '\'' +
                ", occupationTherapyProviderAddress='" + occupationTherapyProviderAddress + '\'' +
                ", occupationTherapyProviderCity='" + occupationTherapyProviderCity + '\'' +
                ", occupationTherapyProviderState='" + occupationTherapyProviderState + '\'' +
                ", occupationTherapyProviderPostalCode='" + occupationTherapyProviderPostalCode + '\'' +
                ", occupationTherapyProviderCountryCode='" + occupationTherapyProviderCountryCode + '\'' +
                ", occupationTherapyProviderIdentificationNumber='" + occupationTherapyProviderIdentificationNumber + '\'' +
                ", occupationTherapyProviderIdentificationNumberType='" + occupationTherapyProviderIdentificationNumberType + '\'' +
                ", occupationTherapyProviderSupplimentalId='" + occupationTherapyProviderSupplimentalId + '\'' +
                ", occupationTherapyProviderIdNumberType='" + occupationTherapyProviderIdNumberType + '\'' +
                '}';
    }
}
