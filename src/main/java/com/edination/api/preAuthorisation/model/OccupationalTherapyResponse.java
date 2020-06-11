package com.edination.api.preAuthorisation.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "OccupationalTherapyResponse")
public class OccupationalTherapyResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String OccupationalTherapyRequestCategory;
    private String OccupationalTherapyCertificationType;
    private String OccupationalTherapyServiceType;
    private String OccupationalTherapyLevelOfService;
    private String OccupationalTherapyVisit;
    private String OccupationalTherapyUnit;
    private String OccupationalTherapyCertificationAction;
    private String OccupationalTherapyRejectionReason;
    private String OccupationalTherapyRejectionReasonMSG;
    private String OccupationalTherapyProviderFirstName;
    private String OccupationalTherapyProviderLastName;
    private String OccupationalTherapyProviderMiddleName;
    private String occupationalTherapyProviderSuffix;
    private String occupationalTherapyProviderPrefix;
    private Date occupationalTherapyResponseServiceDateFrom;
    private Date occupationalTherapyResponseServiceDateTo;
    private int occupationalTherapyRevenueCode;
    private String mrnNumber;
    private String OccupationalTherapyProviderType;
    private String OccupationalTherapyProviderIdentificationNumber;
    private String OccupationalProviderIdentificationNumberType;
    private String OccupationalTherapyProviderSupplimentalId;
    private String OccupationalTherapyProviderIdNumberType;
    private String OccupationalTherapyProviderRejectionReason;
    private String OccupationalTherapyProviderFollowUpActionDescription;
    private String OccupationalTherapyAddress;
    private String OccupationalTherapyCity;
    private String OccupationalTherapyState;
    private String OccupationalTherapyPostalCode;
    private String OccupationalTherapyCountryCode;
    private String OccupationalTherapyProviderFullName;
    private String OccupationalTherapyDetailStatus;
    public OccupationalTherapyResponse() {
    }

    public OccupationalTherapyResponse(String occupationalTherapyRequestCategory, String occupationalTherapyCertificationType, String occupationalTherapyServiceType, String occupationalTherapyLevelOfService, String occupationalTherapyVisit, String occupationalTherapyUnit, String occupationalTherapyCertificationAction, String occupationalTherapyRejectionReason, String occupationalTherapyRejectionReasonMSG, String occupationalTherapyProviderFirstName, String occupationalTherapyProviderLastName, String occupationalTherapyProviderMiddleName, String occupationalTherapyProviderSuffix, String occupationalTherapyProviderPrefix, Date occupationalTherapyResponseServiceDateFrom, Date occupationalTherapyResponseServiceDateTo, int occupationalTherapyRevenueCode, String mrnNumber, String occupationalTherapyProviderType, String occupationalTherapyProviderIdentificationNumber, String occupationalProviderIdentificationNumberType, String occupationalTherapyProviderSupplimentalId, String occupationalTherapyProviderIdNumberType, String occupationalTherapyProviderRejectionReason, String occupationalTherapyProviderFollowUpActionDescription, String occupationalTherapyAddress, String occupationalTherapyCity, String occupationalTherapyState, String occupationalTherapyPostalCode, String occupationalTherapyCountryCode, String occupationalTherapyProviderFullName, String occupationalTherapyDetailStatus) {
        OccupationalTherapyRequestCategory = occupationalTherapyRequestCategory;
        OccupationalTherapyCertificationType = occupationalTherapyCertificationType;
        OccupationalTherapyServiceType = occupationalTherapyServiceType;
        OccupationalTherapyLevelOfService = occupationalTherapyLevelOfService;
        OccupationalTherapyVisit = occupationalTherapyVisit;
        OccupationalTherapyUnit = occupationalTherapyUnit;
        OccupationalTherapyCertificationAction = occupationalTherapyCertificationAction;
        OccupationalTherapyRejectionReason = occupationalTherapyRejectionReason;
        OccupationalTherapyRejectionReasonMSG = occupationalTherapyRejectionReasonMSG;
        OccupationalTherapyProviderFirstName = occupationalTherapyProviderFirstName;
        OccupationalTherapyProviderLastName = occupationalTherapyProviderLastName;
        OccupationalTherapyProviderMiddleName = occupationalTherapyProviderMiddleName;
        this.occupationalTherapyProviderSuffix = occupationalTherapyProviderSuffix;
        this.occupationalTherapyProviderPrefix = occupationalTherapyProviderPrefix;
        this.occupationalTherapyResponseServiceDateFrom = occupationalTherapyResponseServiceDateFrom;
        this.occupationalTherapyResponseServiceDateTo = occupationalTherapyResponseServiceDateTo;
        this.occupationalTherapyRevenueCode = occupationalTherapyRevenueCode;
        this.mrnNumber = mrnNumber;
        OccupationalTherapyProviderType = occupationalTherapyProviderType;
        OccupationalTherapyProviderIdentificationNumber = occupationalTherapyProviderIdentificationNumber;
        OccupationalProviderIdentificationNumberType = occupationalProviderIdentificationNumberType;
        OccupationalTherapyProviderSupplimentalId = occupationalTherapyProviderSupplimentalId;
        OccupationalTherapyProviderIdNumberType = occupationalTherapyProviderIdNumberType;
        OccupationalTherapyProviderRejectionReason = occupationalTherapyProviderRejectionReason;
        OccupationalTherapyProviderFollowUpActionDescription = occupationalTherapyProviderFollowUpActionDescription;
        OccupationalTherapyAddress = occupationalTherapyAddress;
        OccupationalTherapyCity = occupationalTherapyCity;
        OccupationalTherapyState = occupationalTherapyState;
        OccupationalTherapyPostalCode = occupationalTherapyPostalCode;
        OccupationalTherapyCountryCode = occupationalTherapyCountryCode;
        OccupationalTherapyProviderFullName = occupationalTherapyProviderFullName;
        OccupationalTherapyDetailStatus = occupationalTherapyDetailStatus;
    }

    public String getOccupationalTherapyProviderSuffix() {
        return occupationalTherapyProviderSuffix;
    }

    public void setOccupationalTherapyProviderSuffix(String occupationalTherapyProviderSuffix) {
        this.occupationalTherapyProviderSuffix = occupationalTherapyProviderSuffix;
    }

    public String getOccupationalTherapyProviderPrefix() {
        return occupationalTherapyProviderPrefix;
    }

    public void setOccupationalTherapyProviderPrefix(String occupationalTherapyProviderPrefix) {
        this.occupationalTherapyProviderPrefix = occupationalTherapyProviderPrefix;
    }

    public Date getOccupationalTherapyResponseServiceDateFrom() {
        return occupationalTherapyResponseServiceDateFrom;
    }

    public void setOccupationalTherapyResponseServiceDateFrom(Date occupationalTherapyResponseServiceDateFrom) {
        this.occupationalTherapyResponseServiceDateFrom = occupationalTherapyResponseServiceDateFrom;
    }

    public Date getOccupationalTherapyResponseServiceDateTo() {
        return occupationalTherapyResponseServiceDateTo;
    }

    public void setOccupationalTherapyResponseServiceDateTo(Date occupationalTherapyResponseServiceDateTo) {
        this.occupationalTherapyResponseServiceDateTo = occupationalTherapyResponseServiceDateTo;
    }

    public int getOccupationalTherapyRevenueCode() {
        return occupationalTherapyRevenueCode;
    }

    public void setOccupationalTherapyRevenueCode(int occupationalTherapyRevenueCode) {
        this.occupationalTherapyRevenueCode = occupationalTherapyRevenueCode;
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

    public String getOccupationalTherapyRequestCategory() {
        return OccupationalTherapyRequestCategory;
    }

    public void setOccupationalTherapyRequestCategory(String occupationalTherapyRequestCategory) {
        OccupationalTherapyRequestCategory = occupationalTherapyRequestCategory;
    }

    public String getOccupationalTherapyCertificationType() {
        return OccupationalTherapyCertificationType;
    }

    public void setOccupationalTherapyCertificationType(String occupationalTherapyCertificationType) {
        OccupationalTherapyCertificationType = occupationalTherapyCertificationType;
    }

    public String getOccupationalTherapyServiceType() {
        return OccupationalTherapyServiceType;
    }

    public void setOccupationalTherapyServiceType(String occupationalTherapyServiceType) {
        OccupationalTherapyServiceType = occupationalTherapyServiceType;
    }

    public String getOccupationalTherapyLevelOfService() {
        return OccupationalTherapyLevelOfService;
    }

    public void setOccupationalTherapyLevelOfService(String occupationalTherapyLevelOfService) {
        OccupationalTherapyLevelOfService = occupationalTherapyLevelOfService;
    }

    public String getOccupationalTherapyVisit() {
        return OccupationalTherapyVisit;
    }

    public void setOccupationalTherapyVisit(String occupationalTherapyVisit) {
        OccupationalTherapyVisit = occupationalTherapyVisit;
    }

    public String getOccupationalTherapyUnit() {
        return OccupationalTherapyUnit;
    }

    public void setOccupationalTherapyUnit(String occupationalTherapyUnit) {
        OccupationalTherapyUnit = occupationalTherapyUnit;
    }

    public String getOccupationalTherapyCertificationAction() {
        return OccupationalTherapyCertificationAction;
    }

    public void setOccupationalTherapyCertificationAction(String occupationalTherapyCertificationAction) {
        OccupationalTherapyCertificationAction = occupationalTherapyCertificationAction;
    }

    public String getOccupationalTherapyRejectionReason() {
        return OccupationalTherapyRejectionReason;
    }

    public void setOccupationalTherapyRejectionReason(String occupationalTherapyRejectionReason) {
        OccupationalTherapyRejectionReason = occupationalTherapyRejectionReason;
    }

    public String getOccupationalTherapyRejectionReasonMSG() {
        return OccupationalTherapyRejectionReasonMSG;
    }

    public void setOccupationalTherapyRejectionReasonMSG(String occupationalTherapyRejectionReasonMSG) {
        OccupationalTherapyRejectionReasonMSG = occupationalTherapyRejectionReasonMSG;
    }

    public String getOccupationalTherapyProviderFirstName() {
        return OccupationalTherapyProviderFirstName;
    }

    public void setOccupationalTherapyProviderFirstName(String occupationalTherapyProviderFirstName) {
        OccupationalTherapyProviderFirstName = occupationalTherapyProviderFirstName;
    }

    public String getOccupationalTherapyProviderLastName() {
        return OccupationalTherapyProviderLastName;
    }

    public void setOccupationalTherapyProviderLastName(String occupationalTherapyProviderLastName) {
        OccupationalTherapyProviderLastName = occupationalTherapyProviderLastName;
    }

    public String getOccupationalTherapyProviderMiddleName() {
        return OccupationalTherapyProviderMiddleName;
    }

    public void setOccupationalTherapyProviderMiddleName(String occupationalTherapyProviderMiddleName) {
        OccupationalTherapyProviderMiddleName = occupationalTherapyProviderMiddleName;
    }

    public String getOccupationalTherapyProviderType() {
        return OccupationalTherapyProviderType;
    }

    public void setOccupationalTherapyProviderType(String occupationalTherapyProviderType) {
        OccupationalTherapyProviderType = occupationalTherapyProviderType;
    }

    public String getOccupationalTherapyProviderIdentificationNumber() {
        return OccupationalTherapyProviderIdentificationNumber;
    }

    public void setOccupationalTherapyProviderIdentificationNumber(String occupationalTherapyProviderIdentificationNumber) {
        OccupationalTherapyProviderIdentificationNumber = occupationalTherapyProviderIdentificationNumber;
    }

    public String getOccupationalProviderIdentificationNumberType() {
        return OccupationalProviderIdentificationNumberType;
    }

    public void setOccupationalProviderIdentificationNumberType(String occupationalProviderIdentificationNumberType) {
        OccupationalProviderIdentificationNumberType = occupationalProviderIdentificationNumberType;
    }

    public String getOccupationalTherapyProviderSupplimentalId() {
        return OccupationalTherapyProviderSupplimentalId;
    }

    public void setOccupationalTherapyProviderSupplimentalId(String occupationalTherapyProviderSupplimentalId) {
        OccupationalTherapyProviderSupplimentalId = occupationalTherapyProviderSupplimentalId;
    }

    public String getOccupationalTherapyProviderIdNumberType() {
        return OccupationalTherapyProviderIdNumberType;
    }

    public void setOccupationalTherapyProviderIdNumberType(String occupationalTherapyProviderIdNumberType) {
        OccupationalTherapyProviderIdNumberType = occupationalTherapyProviderIdNumberType;
    }

    public String getOccupationalTherapyProviderRejectionReason() {
        return OccupationalTherapyProviderRejectionReason;
    }

    public void setOccupationalTherapyProviderRejectionReason(String occupationalTherapyProviderRejectionReason) {
        OccupationalTherapyProviderRejectionReason = occupationalTherapyProviderRejectionReason;
    }

    public String getOccupationalTherapyProviderFollowUpActionDescription() {
        return OccupationalTherapyProviderFollowUpActionDescription;
    }

    public void setOccupationalTherapyProviderFollowUpActionDescription(String occupationalTherapyProviderFollowUpActionDescription) {
        OccupationalTherapyProviderFollowUpActionDescription = occupationalTherapyProviderFollowUpActionDescription;
    }

    public String getOccupationalTherapyAddress() {
        return OccupationalTherapyAddress;
    }

    public void setOccupationalTherapyAddress(String occupationalTherapyAddress) {
        OccupationalTherapyAddress = occupationalTherapyAddress;
    }

    public String getOccupationalTherapyCity() {
        return OccupationalTherapyCity;
    }

    public void setOccupationalTherapyCity(String occupationalTherapyCity) {
        OccupationalTherapyCity = occupationalTherapyCity;
    }

    public String getOccupationalTherapyState() {
        return OccupationalTherapyState;
    }

    public void setOccupationalTherapyState(String occupationalTherapyState) {
        OccupationalTherapyState = occupationalTherapyState;
    }

    public String getOccupationalTherapyPostalCode() {
        return OccupationalTherapyPostalCode;
    }

    public void setOccupationalTherapyPostalCode(String occupationalTherapyPostalCode) {
        OccupationalTherapyPostalCode = occupationalTherapyPostalCode;
    }

    public String getOccupationalTherapyCountryCode() {
        return OccupationalTherapyCountryCode;
    }

    public void setOccupationalTherapyCountryCode(String occupationalTherapyCountryCode) {
        OccupationalTherapyCountryCode = occupationalTherapyCountryCode;
    }

    public String getOccupationalTherapyProviderFullName() {
        return OccupationalTherapyProviderFullName;
    }

    public void setOccupationalTherapyProviderFullName(String occupationalTherapyProviderFullName) {
        OccupationalTherapyProviderFullName = occupationalTherapyProviderFullName;
    }

    public String getOccupationalTherapyDetailStatus() {
        return OccupationalTherapyDetailStatus;
    }

    public void setOccupationalTherapyDetailStatus(String occupationalTherapyDetailStatus) {
        OccupationalTherapyDetailStatus = occupationalTherapyDetailStatus;
    }

    @Override
    public String toString() {
        return "OccupationalTherapyResponse{" +
                "id=" + id +
                ", OccupationalTherapyRequestCategory='" + OccupationalTherapyRequestCategory + '\'' +
                ", OccupationalTherapyCertificationType='" + OccupationalTherapyCertificationType + '\'' +
                ", OccupationalTherapyServiceType='" + OccupationalTherapyServiceType + '\'' +
                ", OccupationalTherapyLevelOfService='" + OccupationalTherapyLevelOfService + '\'' +
                ", OccupationalTherapyVisit='" + OccupationalTherapyVisit + '\'' +
                ", OccupationalTherapyUnit='" + OccupationalTherapyUnit + '\'' +
                ", OccupationalTherapyCertificationAction='" + OccupationalTherapyCertificationAction + '\'' +
                ", OccupationalTherapyRejectionReason='" + OccupationalTherapyRejectionReason + '\'' +
                ", OccupationalTherapyRejectionReasonMSG='" + OccupationalTherapyRejectionReasonMSG + '\'' +
                ", OccupationalTherapyProviderFirstName='" + OccupationalTherapyProviderFirstName + '\'' +
                ", OccupationalTherapyProviderLastName='" + OccupationalTherapyProviderLastName + '\'' +
                ", OccupationalTherapyProviderMiddleName='" + OccupationalTherapyProviderMiddleName + '\'' +
                ", occupationalTherapyProviderSuffix='" + occupationalTherapyProviderSuffix + '\'' +
                ", occupationalTherapyProviderPrefix='" + occupationalTherapyProviderPrefix + '\'' +
                ", occupationalTherapyResponseServiceDateFrom=" + occupationalTherapyResponseServiceDateFrom +
                ", occupationalTherapyResponseServiceDateTo=" + occupationalTherapyResponseServiceDateTo +
                ", occupationalTherapyRevenueCode=" + occupationalTherapyRevenueCode +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", OccupationalTherapyProviderType='" + OccupationalTherapyProviderType + '\'' +
                ", OccupationalTherapyProviderIdentificationNumber='" + OccupationalTherapyProviderIdentificationNumber + '\'' +
                ", OccupationalProviderIdentificationNumberType='" + OccupationalProviderIdentificationNumberType + '\'' +
                ", OccupationalTherapyProviderSupplimentalId='" + OccupationalTherapyProviderSupplimentalId + '\'' +
                ", OccupationalTherapyProviderIdNumberType='" + OccupationalTherapyProviderIdNumberType + '\'' +
                ", OccupationalTherapyProviderRejectionReason='" + OccupationalTherapyProviderRejectionReason + '\'' +
                ", OccupationalTherapyProviderFollowUpActionDescription='" + OccupationalTherapyProviderFollowUpActionDescription + '\'' +
                ", OccupationalTherapyAddress='" + OccupationalTherapyAddress + '\'' +
                ", OccupationalTherapyCity='" + OccupationalTherapyCity + '\'' +
                ", OccupationalTherapyState='" + OccupationalTherapyState + '\'' +
                ", OccupationalTherapyPostalCode='" + OccupationalTherapyPostalCode + '\'' +
                ", OccupationalTherapyCountryCode='" + OccupationalTherapyCountryCode + '\'' +
                ", OccupationalTherapyProviderFullName='" + OccupationalTherapyProviderFullName + '\'' +
                ", OccupationalTherapyDetailStatus='" + OccupationalTherapyDetailStatus + '\'' +
                '}';
    }
}
