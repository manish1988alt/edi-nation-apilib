package com.edination.api.eligibility.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Demographics")
public class Demographics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long mrnNumber;
    private String firstName;
    private String lastName;
    private String middleName;
    private String suffix;
    private String gender;
    private Date dob;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ssn")
    private InsuranceAndDiagnosis insuranceAndDiagnosis;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "policyNumber")
    private InsuranceDetail insuranceDetail;

    public Demographics(){}

    public Demographics(String firstName, String lastName, String middleName, String suffix, String gender, Date dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.suffix = suffix;
        this.gender = gender;
        this.dob = dob;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public long getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(long mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public InsuranceAndDiagnosis getInsuranceAndDiagnosis() {
        return insuranceAndDiagnosis;
    }

    public void setInsuranceAndDiagnosis(InsuranceAndDiagnosis insuranceAndDiagnosis) {
        this.insuranceAndDiagnosis = insuranceAndDiagnosis;
    }

    public InsuranceDetail getInsuranceDetail() {
        return insuranceDetail;
    }

    public void setInsuranceDetail(InsuranceDetail insuranceDetail) {
        this.insuranceDetail = insuranceDetail;
    }

    @Override
    public String toString() {
        return "Demographics{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", suffix='" + suffix + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", insuranceAndDiagnosis=" + insuranceAndDiagnosis +
                ", insuranceDetail=" + insuranceDetail +
                '}';
    }
}
