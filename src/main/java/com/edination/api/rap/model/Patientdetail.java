package com.edination.api.rap.model;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "Patientdetail")
public class Patientdetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String patientNameIdentifier;
    private String name;
    private String firstName;
    private String lastName;
    private String middleName;
    private String prefix;
    private String suffix;
    private String gender;
    private LocalDate dob;
    private String addressLine;
    private String city;
    private String state;
    private String zipCode;

    public Patientdetail() {
    }

    public Patientdetail(String patientNameIdentifier, String name, String firstName, String lastName, String middleName, String prefix, String suffix, String gender, LocalDate dob, String addressLine, String city, String state, String zipCode) {
        this.patientNameIdentifier = patientNameIdentifier;
        this.name = name;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.prefix = prefix;
        this.suffix = suffix;
        this.gender = gender;
        this.dob = dob;
        this.addressLine = addressLine;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientNameIdentifier() {
        return patientNameIdentifier;
    }

    public void setPatientNameIdentifier(String patientNameIdentifier) {
        this.patientNameIdentifier = patientNameIdentifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
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

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddressLine() {
        return addressLine;
    }

    public void setAddressLine(String addressLine) {
        this.addressLine = addressLine;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String toString() {
        return "Patientdetail{" +
                "id=" + id +
                ", patientNameIdentifier='" + patientNameIdentifier + '\'' +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", addressLine='" + addressLine + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}

