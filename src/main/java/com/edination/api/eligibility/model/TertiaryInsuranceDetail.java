package com.edination.api.eligibility.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="TertiaryInsuranceDetail")
public class TertiaryInsuranceDetail {


    @Id
    private String tertiaryPolicyNumber;
    private String group_name;
    private String insurancePlanName;
    private String insurancePlanType;
    private String insuranceAddress;
    private Date startDate;
    private Date  endDate;
    private String mrnNumber;
    private String City;
    private String State;
    private int zipcode;
public TertiaryInsuranceDetail(){}

    public TertiaryInsuranceDetail(String tertiaryPolicyNumber, String group_name, String insurancePlanName, String insurancePlanType, String insuranceAddress, Date startDate, Date endDate, String mrnNumber, String city, String state, int zipcode) {
        this.tertiaryPolicyNumber = tertiaryPolicyNumber;
        this.group_name = group_name;
        this.insurancePlanName = insurancePlanName;
        this.insurancePlanType = insurancePlanType;
        this.insuranceAddress = insuranceAddress;
        this.startDate = startDate;
        this.endDate = endDate;
        this.mrnNumber = mrnNumber;
        City = city;
        State = state;
        this.zipcode = zipcode;
    }

    public String getPolicyNumber() {
        return tertiaryPolicyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.tertiaryPolicyNumber = tertiaryPolicyNumber;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public String getInsurancePlanName() {
        return insurancePlanName;
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

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public String getTertiaryPolicyNumber() {
        return tertiaryPolicyNumber;
    }

    public void setTertiaryPolicyNumber(String tertiaryPolicyNumber) {
        this.tertiaryPolicyNumber = tertiaryPolicyNumber;
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

    @Override
    public String toString() {
        return "TertiaryInsuranceDetail{" +
                "tertiaryPolicyNumber='" + tertiaryPolicyNumber + '\'' +
                ", group_name='" + group_name + '\'' +
                ", insurancePlanName='" + insurancePlanName + '\'' +
                ", insurancePlanType='" + insurancePlanType + '\'' +
                ", insuranceAddress='" + insuranceAddress + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", City='" + City + '\'' +
                ", State='" + State + '\'' +
                ", zipcode=" + zipcode +
                '}';
    }
}
