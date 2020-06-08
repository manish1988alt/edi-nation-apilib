package com.edination.api.preAuthorisation.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RequesterDetails")
public class RequesterDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mrnNumber;
	private String   reqProviderFullName;
	private String reqProviderType;
    private String reqProviderIdentificationNumber;
    private String  reqProviderIdentificationNumberType;
    private String  reqProviderSupplimentalId;
    private String  reqProviderIdNumberType;
    private Date serviceDateFrom;
    private Date serviceDateTo;
    private Date admitDate;
    private Date  dischargeDate;
    private String requestCategory;
    private String  certificationType;
    private String  serviceType;
    private String  levelOfService;

    public RequesterDetails() {
    }

    public RequesterDetails(String mrnNumber, String reqProviderFullName, String reqProviderType, String reqProviderIdentificationNumber, String reqProviderIdentificationNumberType, String reqProviderSupplimentalId, String reqProviderIdNumberType, Date serviceDateFrom, Date serviceDateTo, Date admitDate, Date dischargeDate, String requestCategory, String certificationType, String serviceType, String levelOfService) {
        this.mrnNumber = mrnNumber;
        this.reqProviderFullName = reqProviderFullName;
        this.reqProviderType = reqProviderType;
        this.reqProviderIdentificationNumber = reqProviderIdentificationNumber;
        this.reqProviderIdentificationNumberType = reqProviderIdentificationNumberType;
        this.reqProviderSupplimentalId = reqProviderSupplimentalId;
        this.reqProviderIdNumberType = reqProviderIdNumberType;
        this.serviceDateFrom = serviceDateFrom;
        this.serviceDateTo = serviceDateTo;
        this.admitDate = admitDate;
        this.dischargeDate = dischargeDate;
        this.requestCategory = requestCategory;
        this.certificationType = certificationType;
        this.serviceType = serviceType;
        this.levelOfService = levelOfService;
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

    public String getReqProviderFullName() {
        return reqProviderFullName;
    }

    public void setReqProviderFullName(String reqProviderFullName) {
        this.reqProviderFullName = reqProviderFullName;
    }

    public String getReqProviderType() {
        return reqProviderType;
    }

    public void setReqProviderType(String reqProviderType) {
        this.reqProviderType = reqProviderType;
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

    @Override
    public String toString() {
        return "RequesterDetails{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", reqProviderFullName='" + reqProviderFullName + '\'' +
                ", reqProviderType='" + reqProviderType + '\'' +
                ", reqProviderIdentificationNumber='" + reqProviderIdentificationNumber + '\'' +
                ", reqProviderIdentificationNumberType='" + reqProviderIdentificationNumberType + '\'' +
                ", reqProviderSupplimentalId='" + reqProviderSupplimentalId + '\'' +
                ", reqProviderIdNumberType='" + reqProviderIdNumberType + '\'' +
                ", serviceDateFrom=" + serviceDateFrom +
                ", serviceDateTo=" + serviceDateTo +
                ", admitDate=" + admitDate +
                ", dischargeDate=" + dischargeDate +
                ", requestCategory='" + requestCategory + '\'' +
                ", certificationType='" + certificationType + '\'' +
                ", serviceType='" + serviceType + '\'' +
                ", levelOfService='" + levelOfService + '\'' +
                '}';
    }
}
