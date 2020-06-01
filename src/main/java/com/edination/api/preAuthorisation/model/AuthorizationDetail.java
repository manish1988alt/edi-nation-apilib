package com.edination.api.preAuthorisation.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AuthorizationDetail")
public class AuthorizationDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String enquiryId;
    private Date processDateAndTime;
    private Date serviceDateFrom;
    private Date serviceDateTo;
    private Date effectiveDateTo;
    private Date effectiveDateFrom;
    private Date expirationeDateTo;
    private Date admitDate;
    private Date dischargeDate;
    private String certificationIdentificationNumber;
    private String preAuthorizationStatus;
    private String enquiryDetailStatus;
    private int      totalUnitsApproved;
    private int      totalUnitsConsumed;
    private int      remainingUnits;
    private int      noOfUnitsTobeUsed;
    private String   unitsForNoOfUnitsTobeUsed;

    public AuthorizationDetail() {
    }

    public AuthorizationDetail(String enquiryId, Date processDateAndTime, Date serviceDateFrom, Date serviceDateTo, Date effectiveDateTo, Date effectiveDateFrom, Date expirationeDateTo, Date admitDate, Date dischargeDate, String certificationIdentificationNumber, String preAuthorizationStatus, String enquiryDetailStatus, int totalUnitsApproved, int totalUnitsConsumed, int remainingUnits, int noOfUnitsTobeUsed, String unitsForNoOfUnitsTobeUsed) {
        this.enquiryId = enquiryId;
        this.processDateAndTime = processDateAndTime;
        this.serviceDateFrom = serviceDateFrom;
        this.serviceDateTo = serviceDateTo;
        this.effectiveDateTo = effectiveDateTo;
        this.effectiveDateFrom = effectiveDateFrom;
        this.expirationeDateTo = expirationeDateTo;
        this.admitDate = admitDate;
        this.dischargeDate = dischargeDate;
        this.certificationIdentificationNumber = certificationIdentificationNumber;
        this.preAuthorizationStatus = preAuthorizationStatus;
        this.enquiryDetailStatus = enquiryDetailStatus;
        this.totalUnitsApproved = totalUnitsApproved;
        this.totalUnitsConsumed = totalUnitsConsumed;
        this.remainingUnits = remainingUnits;
        this.noOfUnitsTobeUsed = noOfUnitsTobeUsed;
        this.unitsForNoOfUnitsTobeUsed = unitsForNoOfUnitsTobeUsed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(String enquiryId) {
        this.enquiryId = enquiryId;
    }

    public Date getProcessDateAndTime() {
        return processDateAndTime;
    }

    public void setProcessDateAndTime(Date processDateAndTime) {
        this.processDateAndTime = processDateAndTime;
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

    public Date getEffectiveDateTo() {
        return effectiveDateTo;
    }

    public void setEffectiveDateTo(Date effectiveDateTo) {
        this.effectiveDateTo = effectiveDateTo;
    }

    public Date getEffectiveDateFrom() {
        return effectiveDateFrom;
    }

    public void setEffectiveDateFrom(Date effectiveDateFrom) {
        this.effectiveDateFrom = effectiveDateFrom;
    }

    public Date getExpirationeDateTo() {
        return expirationeDateTo;
    }

    public void setExpirationeDateTo(Date expirationeDateTo) {
        this.expirationeDateTo = expirationeDateTo;
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

    public String getCertificationIdentificationNumber() {
        return certificationIdentificationNumber;
    }

    public void setCertificationIdentificationNumber(String certificationIdentificationNumber) {
        this.certificationIdentificationNumber = certificationIdentificationNumber;
    }

    public String getPreAuthorizationStatus() {
        return preAuthorizationStatus;
    }

    public void setPreAuthorizationStatus(String preAuthorizationStatus) {
        this.preAuthorizationStatus = preAuthorizationStatus;
    }

    public String getEnquiryDetailStatus() {
        return enquiryDetailStatus;
    }

    public void setEnquiryDetailStatus(String enquiryDetailStatus) {
        this.enquiryDetailStatus = enquiryDetailStatus;
    }

    public int getTotalUnitsApproved() {
        return totalUnitsApproved;
    }

    public void setTotalUnitsApproved(int totalUnitsApproved) {
        this.totalUnitsApproved = totalUnitsApproved;
    }

    public int getTotalUnitsConsumed() {
        return totalUnitsConsumed;
    }

    public void setTotalUnitsConsumed(int totalUnitsConsumed) {
        this.totalUnitsConsumed = totalUnitsConsumed;
    }

    public int getRemainingUnits() {
        return remainingUnits;
    }

    public void setRemainingUnits(int remainingUnits) {
        this.remainingUnits = remainingUnits;
    }

    public int getNoOfUnitsTobeUsed() {
        return noOfUnitsTobeUsed;
    }

    public void setNoOfUnitsTobeUsed(int noOfUnitsTobeUsed) {
        this.noOfUnitsTobeUsed = noOfUnitsTobeUsed;
    }

    public String getUnitsForNoOfUnitsTobeUsed() {
        return unitsForNoOfUnitsTobeUsed;
    }

    public void setUnitsForNoOfUnitsTobeUsed(String unitsForNoOfUnitsTobeUsed) {
        this.unitsForNoOfUnitsTobeUsed = unitsForNoOfUnitsTobeUsed;
    }

    @Override
    public String toString() {
        return "AuthorizationDetail{" +
                "id=" + id +
                ", enquiryId='" + enquiryId + '\'' +
                ", processDateAndTime=" + processDateAndTime +
                ", serviceDateFrom=" + serviceDateFrom +
                ", serviceDateTo=" + serviceDateTo +
                ", effectiveDateTo=" + effectiveDateTo +
                ", effectiveDateFrom=" + effectiveDateFrom +
                ", expirationeDateTo=" + expirationeDateTo +
                ", admitDate=" + admitDate +
                ", dischargeDate=" + dischargeDate +
                ", certificationIdentificationNumber='" + certificationIdentificationNumber + '\'' +
                ", preAuthorizationStatus='" + preAuthorizationStatus + '\'' +
                ", enquiryDetailStatus='" + enquiryDetailStatus + '\'' +
                ", totalUnitsApproved=" + totalUnitsApproved +
                ", totalUnitsConsumed=" + totalUnitsConsumed +
                ", remainingUnits=" + remainingUnits +
                ", noOfUnitsTobeUsed=" + noOfUnitsTobeUsed +
                ", unitsForNoOfUnitsTobeUsed='" + unitsForNoOfUnitsTobeUsed + '\'' +
                '}';
    }
}
