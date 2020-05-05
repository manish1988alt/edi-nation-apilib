package com.edination.api.eligibility.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="InsuranceDetail")
public class PrimaryInsuranceDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String policyNumber;
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
    private String  insuredlastName;
    private String  insuredfirstName;
    private String  insuredmiddleName;
    private Date  insureddob;
    private String  insuredsex;
    private Date statusVerifiedDate;
    private String eligibility;
    private Boolean eligibilityCheckSelected;





    public PrimaryInsuranceDetail(){}

    public PrimaryInsuranceDetail(String policyNumber, String group_name, String insurancePlanName, String insurancePlanType, String insuranceAddress, Date startDate, Date endDate, String mrnNumber, String city, String state, int zipcode, String insuredlastName, String insuredfirstName, String insuredmiddleName, Date insureddob, String insuredsex, Date statusVerifiedDate, String eligibility, Boolean eligibilityCheckSelected) {
        this.policyNumber = policyNumber;
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
        this.insuredlastName = insuredlastName;
        this.insuredfirstName = insuredfirstName;
        this.insuredmiddleName = insuredmiddleName;
        this.insureddob = insureddob;
        this.insuredsex = insuredsex;
        this.statusVerifiedDate = statusVerifiedDate;
        this.eligibility = eligibility;
        this.eligibilityCheckSelected = eligibilityCheckSelected;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }

    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
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

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
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

    public String getInsuredlastName() {
        return insuredlastName;
    }

    public void setInsuredlastName(String insuredlastName) {
        this.insuredlastName = insuredlastName;
    }

    public String getInsuredfirstName() {
        return insuredfirstName;
    }

    public void setInsuredfirstName(String insuredfirstName) {
        this.insuredfirstName = insuredfirstName;
    }

    public String getInsuredmiddleName() {
        return insuredmiddleName;
    }

    public void setInsuredmiddleName(String insuredmiddleName) {
        this.insuredmiddleName = insuredmiddleName;
    }

    public Date getInsureddob() {
        return insureddob;
    }

    public void setInsureddob(Date insureddob) {
        this.insureddob = insureddob;
    }

    public String getInsuredsex() {
        return insuredsex;
    }

    public void setInsuredsex(String insuredsex) {
        this.insuredsex = insuredsex;
    }

    public Date getStatusVerifiedDate() {
        return statusVerifiedDate;
    }

    public void setStatusVerifiedDate(Date statusVerifiedDate) {
        this.statusVerifiedDate = statusVerifiedDate;
    }

    public String getEligibility() {
        return eligibility;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public Boolean getEligibilityCheckSelected() {
        return eligibilityCheckSelected;
    }

    public void setEligibilityCheckSelected(Boolean eligibilityCheckSelected) {
        this.eligibilityCheckSelected = eligibilityCheckSelected;
    }

    @Override
    public String toString() {
        return "PrimaryInsuranceDetail{" +
                "id=" + id +
                ", policyNumber='" + policyNumber + '\'' +
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
                ", insuredlastName='" + insuredlastName + '\'' +
                ", insuredfirstName='" + insuredfirstName + '\'' +
                ", insuredmiddleName='" + insuredmiddleName + '\'' +
                ", insureddob=" + insureddob +
                ", insuredsex='" + insuredsex + '\'' +
                ", statusVerifiedDate=" + statusVerifiedDate +
                ", eligibility='" + eligibility + '\'' +
                ", eligibilityCheckSelected=" + eligibilityCheckSelected +
                '}';
    }
}
