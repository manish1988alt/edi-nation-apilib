package com.edination.api.eligibility.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="InsuranceDetail")
public class PrimaryInsuranceDetail {
   /* @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;*/
   @Id
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

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mrnNumber")
    private Demographics demographics;*/



    public PrimaryInsuranceDetail(){}

    public PrimaryInsuranceDetail(String policyNumber, String group_name, String insurancePlanName, String insurancePlanType, String insuranceAddress, Date startDate, Date endDate, String mrnNumber, String city, String state, int zipcode) {
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
    }

/* public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/

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

   /* public Demographics getDemographics() {
        return demographics;
    }

    public void setDemographics(Demographics demographics) {
        this.demographics = demographics;
    }*/

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

    @Override
    public String toString() {
        return "PrimaryInsuranceDetail{" +
                "policyNumber='" + policyNumber + '\'' +
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
