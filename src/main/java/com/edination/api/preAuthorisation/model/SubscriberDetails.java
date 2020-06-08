package com.edination.api.preAuthorisation.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "SubscriberDetails")
public class SubscriberDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mrnNumber;
    private String subscriberFirstName;
    private String subscriberLastName;
    private String  subscriberMiddleName;
    private String  subscriberSuffix;
    private String  subscriberPrefix;
    private String  subscriberGender;
    private Date subscriberDob;
    private String  subscriberRelToInsured;
    private String  subscriberIdentificationCode;
    private String  subscriberIdentificationNumberType;
    private String  subscriberSupplementalId;
    private String   subscriberIdNumberType;

    public SubscriberDetails() {
    }

    public SubscriberDetails(String mrnNumber, String subscriberFirstName, String subscriberLastName, String subscriberMiddleName, String subscriberSuffix, String subscriberPrefix, String subscriberGender, Date subscriberDob, String subscriberRelToInsured, String subscriberIdentificationCode, String subscriberIdentificationNumberType, String subscriberSupplementalId, String subscriberIdNumberType) {
        this.mrnNumber = mrnNumber;
        this.subscriberFirstName = subscriberFirstName;
        this.subscriberLastName = subscriberLastName;
        this.subscriberMiddleName = subscriberMiddleName;
        this.subscriberSuffix = subscriberSuffix;
        this.subscriberPrefix = subscriberPrefix;
        this.subscriberGender = subscriberGender;
        this.subscriberDob = subscriberDob;
        this.subscriberRelToInsured = subscriberRelToInsured;
        this.subscriberIdentificationCode = subscriberIdentificationCode;
        this.subscriberIdentificationNumberType = subscriberIdentificationNumberType;
        this.subscriberSupplementalId = subscriberSupplementalId;
        this.subscriberIdNumberType = subscriberIdNumberType;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubscriberFirstName() {
        return subscriberFirstName;
    }

    public void setSubscriberFirstName(String subscriberFirstName) {
        this.subscriberFirstName = subscriberFirstName;
    }

    public String getSubscriberLastName() {
        return subscriberLastName;
    }

    public void setSubscriberLastName(String subscriberLastName) {
        this.subscriberLastName = subscriberLastName;
    }

    public String getSubscriberMiddleName() {
        return subscriberMiddleName;
    }

    public void setSubscriberMiddleName(String subscriberMiddleName) {
        this.subscriberMiddleName = subscriberMiddleName;
    }

    public String getSubscriberSuffix() {
        return subscriberSuffix;
    }

    public void setSubscriberSuffix(String subscriberSuffix) {
        this.subscriberSuffix = subscriberSuffix;
    }

    public String getSubscriberPrefix() {
        return subscriberPrefix;
    }

    public void setSubscriberPrefix(String subscriberPrefix) {
        this.subscriberPrefix = subscriberPrefix;
    }

    public String getSubscriberGender() {
        return subscriberGender;
    }

    public void setSubscriberGender(String subscriberGender) {
        this.subscriberGender = subscriberGender;
    }

    public Date getSubscriberDob() {
        return subscriberDob;
    }

    public void setSubscriberDob(Date subscriberDob) {
        this.subscriberDob = subscriberDob;
    }

    public String getSubscriberRelToInsured() {
        return subscriberRelToInsured;
    }

    public void setSubscriberRelToInsured(String subscriberRelToInsured) {
        this.subscriberRelToInsured = subscriberRelToInsured;
    }

    public String getSubscriberIdentificationCode() {
        return subscriberIdentificationCode;
    }

    public void setSubscriberIdentificationCode(String subscriberIdentificationCode) {
        this.subscriberIdentificationCode = subscriberIdentificationCode;
    }

    public String getSubscriberIdentificationNumberType() {
        return subscriberIdentificationNumberType;
    }

    public void setSubscriberIdentificationNumberType(String subscriberIdentificationNumberType) {
        this.subscriberIdentificationNumberType = subscriberIdentificationNumberType;
    }

    public String getSubscriberSupplementalId() {
        return subscriberSupplementalId;
    }

    public void setSubscriberSupplementalId(String subscriberSupplementalId) {
        this.subscriberSupplementalId = subscriberSupplementalId;
    }

    public String getSubscriberIdNumberType() {
        return subscriberIdNumberType;
    }

    public void setSubscriberIdNumberType(String subscriberIdNumberType) {
        this.subscriberIdNumberType = subscriberIdNumberType;
    }

    @Override
    public String toString() {
        return "SubscriberDetails{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", subscriberFirstName='" + subscriberFirstName + '\'' +
                ", subscriberLastName='" + subscriberLastName + '\'' +
                ", subscriberMiddleName='" + subscriberMiddleName + '\'' +
                ", subscriberSuffix='" + subscriberSuffix + '\'' +
                ", subscriberPrefix='" + subscriberPrefix + '\'' +
                ", subscriberGender='" + subscriberGender + '\'' +
                ", subscriberDob=" + subscriberDob +
                ", subscriberRelToInsured='" + subscriberRelToInsured + '\'' +
                ", subscriberIdentificationCode='" + subscriberIdentificationCode + '\'' +
                ", subscriberIdentificationNumberType='" + subscriberIdentificationNumberType + '\'' +
                ", subscriberSupplementalId='" + subscriberSupplementalId + '\'' +
                ", subscriberIdNumberType='" + subscriberIdNumberType + '\'' +
                '}';
    }
}
