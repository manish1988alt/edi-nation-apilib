package com.edination.api.preAuthorisation.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "PreAuthDemographics")
public class PreAuthDemographics {

   @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String mrnNumber;
    private String firstName;
    private String lastName;
    private String middleName;
    private String suffix;
    private String gender;
    private Date dob;
    private String ssn;
    private String prefix;
    private String relationshipToSubscriber;
    public PreAuthDemographics(){}

    public PreAuthDemographics(String mrnNumber, String firstName, String lastName, String middleName, String suffix, String gender, Date dob, String ssn, String prefix, String relationshipToSubscriber) {
        this.mrnNumber = mrnNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.suffix = suffix;
        this.gender = gender;
        this.dob = dob;
        this.ssn = ssn;
        this.prefix = prefix;
        this.relationshipToSubscriber = relationshipToSubscriber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getRelationshipToSubscriber() {
        return relationshipToSubscriber;
    }

    public void setRelationshipToSubscriber(String relationshipToSubscriber) {
        this.relationshipToSubscriber = relationshipToSubscriber;
    }

    @Override
    public String toString() {
        return "PreAuthDemographics{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", suffix='" + suffix + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", ssn='" + ssn + '\'' +
                ", prefix='" + prefix + '\'' +
                ", relationshipToSubscriber='" + relationshipToSubscriber + '\'' +
                '}';
    }
}
