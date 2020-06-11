package com.edination.api.preAuthorisation.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RequesterResponseInformation")
public class RequesterResponseInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String reqProviderFullName;
    private String reqProviderFirstName;
    private String reqProviderLastName;
    private String reqProviderMiddleName;
    private String reqProviderSuffix;
    private String reqProviderPrefix;
    private String requestCategory;
    private String certificationType;
    private String serviceType;
    private String levelOfService;
    private String reqProviderType;
    private Date serviceDateFrom;
    private Date serviceDateTo;
    private Date admitDate;
    private Date dischargeDate;
    private String reqProviderIdentificationNumber;
    private String reqProviderIdentificationNumberType;
    private String reqProviderSupplimentalId;
    private String reqProviderIdNumberType;
    private String reqProviderRejectionReason;
    private String reqProviderFollowUpActionDescription;
    private String reqProviderDetailStatus;

    public RequesterResponseInformation() {
    }

    public RequesterResponseInformation(String reqProviderFullName, String reqProviderFirstName, String reqProviderLastName, String reqProviderMiddleName, String reqProviderSuffix, String reqProviderPrefix, String requestCategory, String certificationType, String serviceType, String levelOfService, String reqProviderType, Date serviceDateFrom, Date serviceDateTo, Date admitDate, Date dischargeDate, String reqProviderIdentificationNumber, String reqProviderIdentificationNumberType, String reqProviderSupplimentalId, String reqProviderIdNumberType, String reqProviderRejectionReason, String reqProviderFollowUpActionDescription, String reqProviderDetailStatus) {
        this.reqProviderFullName = reqProviderFullName;
        this.reqProviderFirstName = reqProviderFirstName;
        this.reqProviderLastName = reqProviderLastName;
        this.reqProviderMiddleName = reqProviderMiddleName;
        this.reqProviderSuffix = reqProviderSuffix;
        this.reqProviderPrefix = reqProviderPrefix;
        this.requestCategory = requestCategory;
        this.certificationType = certificationType;
        this.serviceType = serviceType;
        this.levelOfService = levelOfService;
        this.reqProviderType = reqProviderType;
        this.serviceDateFrom = serviceDateFrom;
        this.serviceDateTo = serviceDateTo;
        this.admitDate = admitDate;
        this.dischargeDate = dischargeDate;
        this.reqProviderIdentificationNumber = reqProviderIdentificationNumber;
        this.reqProviderIdentificationNumberType = reqProviderIdentificationNumberType;
        this.reqProviderSupplimentalId = reqProviderSupplimentalId;
        this.reqProviderIdNumberType = reqProviderIdNumberType;
        this.reqProviderRejectionReason = reqProviderRejectionReason;
        this.reqProviderFollowUpActionDescription = reqProviderFollowUpActionDescription;
        this.reqProviderDetailStatus = reqProviderDetailStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReqProviderFullName() {
        return reqProviderFullName;
    }

    public void setReqProviderFullName(String reqProviderFullName) {
        this.reqProviderFullName = reqProviderFullName;
    }

    public String getReqProviderFirstName() {
        return reqProviderFirstName;
    }

    public void setReqProviderFirstName(String reqProviderFirstName) {
        this.reqProviderFirstName = reqProviderFirstName;
    }

    public String getReqProviderLastName() {
        return reqProviderLastName;
    }

    public void setReqProviderLastName(String reqProviderLastName) {
        this.reqProviderLastName = reqProviderLastName;
    }

    public String getReqProviderMiddleName() {
        return reqProviderMiddleName;
    }

    public void setReqProviderMiddleName(String reqProviderMiddleName) {
        this.reqProviderMiddleName = reqProviderMiddleName;
    }

    public String getReqProviderSuffix() {
        return reqProviderSuffix;
    }

    public void setReqProviderSuffix(String reqProviderSuffix) {
        this.reqProviderSuffix = reqProviderSuffix;
    }

    public String getReqProviderPrefix() {
        return reqProviderPrefix;
    }

    public void setReqProviderPrefix(String reqProviderPrefix) {
        this.reqProviderPrefix = reqProviderPrefix;
    }

    public String getRequestCategory() {
        return requestCategory;
    }

    public void setRequestCategory(String requestCategory) {
        this.requestCategory = requestCategory;
    }

    public String getCertificationType() {
        return certificationType;
    }

    public void setCertificationType(String certificationType) {
        this.certificationType = certificationType;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getLevelOfService() {
        return levelOfService;
    }

    public void setLevelOfService(String levelOfService) {
        this.levelOfService = levelOfService;
    }

    public String getReqProviderType() {
        return reqProviderType;
    }

    public void setReqProviderType(String reqProviderType) {
        this.reqProviderType = reqProviderType;
    }

    public Date getServiceDateFrom() {
        return serviceDateFrom;
    }

    public void setServiceDateFrom(Date serviceDateFrom) {
        this.serviceDateFrom = serviceDateFrom;
    }

    public Date getServiceDateTo() {
        return serviceDateTo;
    }

    public void setServiceDateTo(Date serviceDateTo) {
        this.serviceDateTo = serviceDateTo;
    }

    public Date getAdmitDate() {
        return admitDate;
    }

    public void setAdmitDate(Date admitDate) {
        this.admitDate = admitDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getReqProviderIdentificationNumber() {
        return reqProviderIdentificationNumber;
    }

    public void setReqProviderIdentificationNumber(String reqProviderIdentificationNumber) {
        this.reqProviderIdentificationNumber = reqProviderIdentificationNumber;
    }

    public String getReqProviderIdentificationNumberType() {
        return reqProviderIdentificationNumberType;
    }

    public void setReqProviderIdentificationNumberType(String reqProviderIdentificationNumberType) {
        this.reqProviderIdentificationNumberType = reqProviderIdentificationNumberType;
    }

    public String getReqProviderSupplimentalId() {
        return reqProviderSupplimentalId;
    }

    public void setReqProviderSupplimentalId(String reqProviderSupplimentalId) {
        this.reqProviderSupplimentalId = reqProviderSupplimentalId;
    }

    public String getReqProviderIdNumberType() {
        return reqProviderIdNumberType;
    }

    public void setReqProviderIdNumberType(String reqProviderIdNumberType) {
        this.reqProviderIdNumberType = reqProviderIdNumberType;
    }

    public String getReqProviderRejectionReason() {
        return reqProviderRejectionReason;
    }

    public void setReqProviderRejectionReason(String reqProviderRejectionReason) {
        this.reqProviderRejectionReason = reqProviderRejectionReason;
    }

    public String getReqProviderFollowUpActionDescription() {
        return reqProviderFollowUpActionDescription;
    }

    public void setReqProviderFollowUpActionDescription(String reqProviderFollowUpActionDescription) {
        this.reqProviderFollowUpActionDescription = reqProviderFollowUpActionDescription;
    }

    public String getReqProviderDetailStatus() {
        return reqProviderDetailStatus;
    }

    public void setReqProviderDetailStatus(String reqProviderDetailStatus) {
        this.reqProviderDetailStatus = reqProviderDetailStatus;
    }

    @Override
    public String toString() {
        return "RequesterResponseInformation{" +
                "id=" + id +
                ", reqProviderFullName='" + reqProviderFullName + '\'' +
                ", reqProviderFirstName='" + reqProviderFirstName + '\'' +
                ", reqProviderLastName='" + reqProviderLastName + '\'' +
                ", reqProviderMiddleName='" + reqProviderMiddleName + '\'' +
                ", reqProviderSuffix='" + reqProviderSuffix + '\'' +
                ", reqProviderPrefix='" + reqProviderPrefix + '\'' +
                ", requestCategory='" + requestCategory + '\'' +
                ", certificationType='" + certificationType + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", levelOfService='" + levelOfService + '\'' +
                ", reqProviderType='" + reqProviderType + '\'' +
                ", serviceDateFrom=" + serviceDateFrom +
                ", serviceDateTo=" + serviceDateTo +
                ", admitDate=" + admitDate +
                ", dischargeDate=" + dischargeDate +
                ", reqProviderIdentificationNumber='" + reqProviderIdentificationNumber + '\'' +
                ", reqProviderIdentificationNumberType='" + reqProviderIdentificationNumberType + '\'' +
                ", reqProviderSupplimentalId='" + reqProviderSupplimentalId + '\'' +
                ", reqProviderIdNumberType='" + reqProviderIdNumberType + '\'' +
                ", reqProviderRejectionReason='" + reqProviderRejectionReason + '\'' +
                ", reqProviderFollowUpActionDescription='" + reqProviderFollowUpActionDescription + '\'' +
                ", reqProviderDetailStatus='" + reqProviderDetailStatus + '\'' +
                '}';
    }
}
