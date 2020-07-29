package com.edination.api.LoginPackage.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "GuarenterDetails")
public class GuarenterDetails {

    @Id
    private String mrnNumber;
    private String	firstName;
    private String	middleName;
    private String	lastName;
    private String	relationshipToPatient;
    private String	address;

    public GuarenterDetails() {
    }

    public GuarenterDetails(String mrnNumber, String firstName, String middleName, String lastName, String relationshipToPatient, String address) {
        this.mrnNumber = mrnNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.relationshipToPatient = relationshipToPatient;
        this.address = address;
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

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRelationshipToPatient() {
        return relationshipToPatient;
    }

    public void setRelationshipToPatient(String relationshipToPatient) {
        this.relationshipToPatient = relationshipToPatient;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "GuarenterDetails{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", relationshipToPatient='" + relationshipToPatient + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
