package com.edination.api.eligibility.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="InsuranceDetail")
public class InsuranceDetail {
    @Id
    private String policyNumber;
    private String group_name;
    private String insurancePlanName;
    private String insurancePlanType;
    private String insuranceAddress;
    private String City;
    private String State;
    private int zipcode;
    private Date startDate;
    private Date  endDate;
    private Date statusVerifiedDate;
    private String eligibility;
    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mrnNumber")
    private Demographics demographics;*/

    public InsuranceDetail(){}

    public InsuranceDetail(String policyNumber, String group_name, String insurancePlanName, String insurancePlanType, String insuranceAddress, String city, String state, int zipcode, Date startDate, Date endDate, String eligibility,Date statusVerifiedDate) {
        this.policyNumber = policyNumber;
        this.group_name = group_name;
        this.insurancePlanName = insurancePlanName;
        this.insurancePlanType = insurancePlanType;
        this.insuranceAddress = insuranceAddress;
        City = city;
        State = state;
        this.zipcode = zipcode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.eligibility = eligibility;
        this.statusVerifiedDate=statusVerifiedDate;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public String getInsurancePlanName() {
        return insurancePlanName;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public void setInsurancePlanName(String insurancePlanName) {
        this.insurancePlanName = insurancePlanName;
    }

    public String getInsurancePlanType() {
        return insurancePlanType;
    }

    public void setInsurancePlanType(String insurancePlanType) {
        this.insurancePlanType = insurancePlanType;
    }

    public String getInsuranceAddress() {
        return insuranceAddress;
    }

    public void setInsuranceAddress(String insuranceAddress) {
        this.insuranceAddress = insuranceAddress;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    public Date getStatusVerifiedDate() {
        return statusVerifiedDate;
    }

    public void setStatusVerifiedDate(Date statusVerifiedDate) {
        this.statusVerifiedDate = statusVerifiedDate;
    }

    @Override
    public String toString() {
        return "InsuranceDetail{" +
                "policyNumber='" + policyNumber + '\'' +
                ", group_name='" + group_name + '\'' +
                ", insurancePlanName='" + insurancePlanName + '\'' +
                ", insurancePlanType='" + insurancePlanType + '\'' +
                ", insuranceAddress='" + insuranceAddress + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", zipcode=" + zipcode +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", statusVerifiedDate=" + statusVerifiedDate +
                ", eligibility='" + eligibility + '\'' +
                '}';
    }
}
