package com.edination.api.preAuthorisation.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "PreAuthDemographics")
public class PreAuthDemographics {

    @Id
    private String mrnNumber;
    private String firstName;
    private String lastName;
    private String middleName;
    private String suffix;
    private String gender;
    private Date dob;
    private String ssn;

    public PreAuthDemographics(){}

    public PreAuthDemographics(String mrnNumber, String firstName, String lastName, String middleName, String suffix, String gender, Date dob, String ssn) {
        this.mrnNumber = mrnNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.suffix = suffix;
        this.gender = gender;
        this.dob = dob;
        this.ssn = ssn;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
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

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "PreAuthDemographics{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", suffix='" + suffix + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", ssn='" + ssn + '\'' +
                '}';
    }
}
