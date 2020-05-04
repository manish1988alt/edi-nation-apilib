package com.edination.api.eligibility.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "InsuranceAndDiagnosis")
public class InsuranceAndDiagnosis {
    @Id
    private String ssn;
    private String insuredfirstName;
    private String insuredlastName;
    private String insuredmiddleName;
    private String insuredsex;
    private Date insureddob;
    private String mop;
    private String patientReltoInsured;
    private String insuredAddress;
    private String insuredCity;
    private String insuredState;
    private int insuredzipcode;



public InsuranceAndDiagnosis(){}


    public InsuranceAndDiagnosis(String ssn,String insuredfirstName, String insuredlastName, String insuredmiddleName, String insuredsex, Date insureddob, String mop,String patientReltoInsured,  String insuredAddress, String insuredCity, String insuredState, int insuredzipcode) {
        this.ssn=ssn;
        this.insuredfirstName = insuredfirstName;
        this.insuredlastName = insuredlastName;
        this.insuredmiddleName = insuredmiddleName;
        this.insuredsex = insuredsex;
        this.insureddob = insureddob;
        this.mop=mop;
        this.patientReltoInsured = patientReltoInsured;
        this.insuredAddress = insuredAddress;
        this.insuredCity = insuredCity;
        this.insuredState = insuredState;
        this.insuredzipcode = insuredzipcode;

    }

   /* public InsuranceDetail getInsuranceDetail() {
        return insuranceDetail;
    }

    public void setInsuranceDetail(InsuranceDetail insuranceDetail) {
        this.insuranceDetail = insuranceDetail;
    }*/

    public String getInsuredlastName() {
        return insuredlastName;
    }

    public void setInsuredlastName(String insuredlastName) {
        this.insuredlastName = insuredlastName;
    }



    public String getMop() {
        return mop;
    }

    public void setMop(String mop) {
        this.mop = mop;
    }

    public String getPatientReltoInsured() {
        return patientReltoInsured;
    }

    public void setPatientReltoInsured(String patientReltoInsured) {
        this.patientReltoInsured = patientReltoInsured;
    }
    public String getInsuredAddress() {
        return insuredAddress;
    }

    public void setInsuredAddress(String insuredAddress) {
        this.insuredAddress = insuredAddress;
    }

    public String getInsuredCity() {
        return insuredCity;
    }

    public void setInsuredCity(String insuredCity) {
        this.insuredCity = insuredCity;
    }

    public String getInsuredState() {
        return insuredState;
    }

    public void setInsuredState(String insuredState) {
        this.insuredState = insuredState;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
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

    public String getInsuredsex() {
        return insuredsex;
    }

    public void setInsuredsex(String insuredsex) {
        this.insuredsex = insuredsex;
    }

    public Date getInsureddob() {
        return insureddob;
    }

    public void setInsureddob(Date insureddob) {
        this.insureddob = insureddob;
    }

    public int getInsuredzipcode() {
        return insuredzipcode;
    }

    public void setInsuredzipcode(int insuredzipcode) {
        this.insuredzipcode = insuredzipcode;
    }

   /* public SecondaryInsuranceDetail getSecondaryInsuranceDetail() {
        return secondaryInsuranceDetail;
    }

    public void setSecondaryInsuranceDetail(SecondaryInsuranceDetail secondaryInsuranceDetail) {
        this.secondaryInsuranceDetail = secondaryInsuranceDetail;
    }

    public TertiaryInsuranceDetail getTertiaryInsuranceDetail() {
        return tertiaryInsuranceDetail;
    }

    public void setTertiaryInsuranceDetail(TertiaryInsuranceDetail tertiaryInsuranceDetail) {
        this.tertiaryInsuranceDetail = tertiaryInsuranceDetail;
    }*/

    @Override
    public String toString() {
        return "InsuranceAndDiagnosis{" +
                "ssn='" + ssn + '\'' +
                ", insuredfirstName='" + insuredfirstName + '\'' +
                ", insuredlastName='" + insuredlastName + '\'' +
                ", insuredmiddleName='" + insuredmiddleName + '\'' +
                ", insuredsex='" + insuredsex + '\'' +
                ", insureddob=" + insureddob +
                ", mop='" + mop + '\'' +
                ", patientReltoInsured='" + patientReltoInsured + '\'' +
                ", insuredAddress='" + insuredAddress + '\'' +
                ", insuredCity='" + insuredCity + '\'' +
                ", insuredState='" + insuredState + '\'' +
                ", insuredzipcode=" + insuredzipcode +
                '}';
    }
}
