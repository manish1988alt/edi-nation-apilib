package com.edination.api.rap.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table(name = "BillingProviderPerson")
public class BillingProviderPerson {
    @Id
    private String personId;
    private String personFirstName;
    private String personLastName;
    private String personMiddleName;
    private String personPrefix;
    private String personSuffix;
    private String personGender;
    private LocalDate personDob;
    private String personAddressLine;
    private String personCity;
    private String personState;
    private String personZipCode;

    public BillingProviderPerson() {
    }

    public BillingProviderPerson(String personId, String personFirstName, String personLastName, String personMiddleName, String personPrefix, String personSuffix, String personGender, LocalDate personDob, String personAddressLine, String personCity, String personState, String personZipCode) {
        this.personId = personId;
        this.personFirstName = personFirstName;
        this.personLastName = personLastName;
        this.personMiddleName = personMiddleName;
        this.personPrefix = personPrefix;
        this.personSuffix = personSuffix;
        this.personGender = personGender;
        this.personDob = personDob;
        this.personAddressLine = personAddressLine;
        this.personCity = personCity;
        this.personState = personState;
        this.personZipCode = personZipCode;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public String getPersonLastName() {
        return personLastName;
    }

    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    public String getPersonMiddleName() {
        return personMiddleName;
    }

    public void setPersonMiddleName(String personMiddleName) {
        this.personMiddleName = personMiddleName;
    }

    public String getPersonPrefix() {
        return personPrefix;
    }

    public void setPersonPrefix(String personPrefix) {
        this.personPrefix = personPrefix;
    }

    public String getPersonSuffix() {
        return personSuffix;
    }

    public void setPersonSuffix(String personSuffix) {
        this.personSuffix = personSuffix;
    }

    public String getPersonGender() {
        return personGender;
    }

    public void setPersonGender(String personGender) {
        this.personGender = personGender;
    }

    public LocalDate getPersonDob() {
        return personDob;
    }

    public void setPersonDob(LocalDate personDob) {
        this.personDob = personDob;
    }

    public String getPersonAddressLine() {
        return personAddressLine;
    }

    public void setPersonAddressLine(String personAddressLine) {
        this.personAddressLine = personAddressLine;
    }

    public String getPersonCity() {
        return personCity;
    }

    public void setPersonCity(String personCity) {
        this.personCity = personCity;
    }

    public String getPersonState() {
        return personState;
    }

    public void setPersonState(String personState) {
        this.personState = personState;
    }

    public String getPersonZipCode() {
        return personZipCode;
    }

    public void setPersonZipCode(String personZipCode) {
        this.personZipCode = personZipCode;
    }

    @Override
    public String toString() {
        return "BillingProviderPerson{" +
                "personId='" + personId + '\'' +
                ", personFirstName='" + personFirstName + '\'' +
                ", personLastName='" + personLastName + '\'' +
                ", personMiddleName='" + personMiddleName + '\'' +
                ", personPrefix='" + personPrefix + '\'' +
                ", personSuffix='" + personSuffix + '\'' +
                ", personGender='" + personGender + '\'' +
                ", personDob=" + personDob +
                ", personAddressLine='" + personAddressLine + '\'' +
                ", personCity='" + personCity + '\'' +
                ", personState='" + personState + '\'' +
                ", personZipCode='" + personZipCode + '\'' +
                '}';
    }
}
