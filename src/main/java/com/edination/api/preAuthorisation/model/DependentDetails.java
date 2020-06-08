package com.edination.api.preAuthorisation.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DependentDetails")
public class DependentDetails {



    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mrnNumber;
    private String  dependentFirstName;
    private String  dependentLastName;
    private String  dependentMiddleName;
    private String  dependentSuffix;
    private String   dependentGender;
    private Date dependentDob;
    private String   dependentPrefix;
    private String    dependentRelToSubscriber;
    private String    dependentSubscriberIdentificationCode;
    private String    dependentSubscriberIdentificationNumberType;
    private String    dependentSubscriberSupplementalId;
    private String   dependentSubscriberIdNumberType;

    public DependentDetails() {
    }

    public DependentDetails(String mrnNumber, String dependentFirstName, String dependentLastName, String dependentMiddleName, String dependentSuffix, String dependentGender, Date dependentDob, String dependentPrefix, String dependentRelToSubscriber, String dependentSubscriberIdentificationCode, String dependentSubscriberIdentificationNumberType, String dependentSubscriberSupplementalId, String dependentSubscriberIdNumberType) {
        this.mrnNumber = mrnNumber;
        this.dependentFirstName = dependentFirstName;
        this.dependentLastName = dependentLastName;
        this.dependentMiddleName = dependentMiddleName;
        this.dependentSuffix = dependentSuffix;
        this.dependentGender = dependentGender;
        this.dependentDob = dependentDob;
        this.dependentPrefix = dependentPrefix;
        this.dependentRelToSubscriber = dependentRelToSubscriber;
        this.dependentSubscriberIdentificationCode = dependentSubscriberIdentificationCode;
        this.dependentSubscriberIdentificationNumberType = dependentSubscriberIdentificationNumberType;
        this.dependentSubscriberSupplementalId = dependentSubscriberSupplementalId;
        this.dependentSubscriberIdNumberType = dependentSubscriberIdNumberType;
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

    public String getDependentFirstName() {
        return dependentFirstName;
    }

    public void setDependentFirstName(String dependentFirstName) {
        this.dependentFirstName = dependentFirstName;
    }

    public String getDependentLastName() {
        return dependentLastName;
    }

    public void setDependentLastName(String dependentLastName) {
        this.dependentLastName = dependentLastName;
    }

    public String getDependentMiddleName() {
        return dependentMiddleName;
    }

    public void setDependentMiddleName(String dependentMiddleName) {
        this.dependentMiddleName = dependentMiddleName;
    }

    public String getDependentSuffix() {
        return dependentSuffix;
    }

    public void setDependentSuffix(String dependentSuffix) {
        this.dependentSuffix = dependentSuffix;
    }

    public String getDependentGender() {
        return dependentGender;
    }

    public void setDependentGender(String dependentGender) {
        this.dependentGender = dependentGender;
    }

    public Date getDependentDob() {
        return dependentDob;
    }

    public void setDependentDob(Date dependentDob) {
        this.dependentDob = dependentDob;
    }

    public String getDependentPrefix() {
        return dependentPrefix;
    }

    public void setDependentPrefix(String dependentPrefix) {
        this.dependentPrefix = dependentPrefix;
    }

    public String getDependentRelToSubscriber() {
        return dependentRelToSubscriber;
    }

    public void setDependentRelToSubscriber(String dependentRelToSubscriber) {
        this.dependentRelToSubscriber = dependentRelToSubscriber;
    }

    public String getDependentSubscriberIdentificationCode() {
        return dependentSubscriberIdentificationCode;
    }

    public void setDependentSubscriberIdentificationCode(String dependentSubscriberIdentificationCode) {
        this.dependentSubscriberIdentificationCode = dependentSubscriberIdentificationCode;
    }

    public String getDependentSubscriberIdentificationNumberType() {
        return dependentSubscriberIdentificationNumberType;
    }

    public void setDependentSubscriberIdentificationNumberType(String dependentSubscriberIdentificationNumberType) {
        this.dependentSubscriberIdentificationNumberType = dependentSubscriberIdentificationNumberType;
    }

    public String getDependentSubscriberSupplementalId() {
        return dependentSubscriberSupplementalId;
    }

    public void setDependentSubscriberSupplementalId(String dependentSubscriberSupplementalId) {
        this.dependentSubscriberSupplementalId = dependentSubscriberSupplementalId;
    }

    public String getDependentSubscriberIdNumberType() {
        return dependentSubscriberIdNumberType;
    }

    public void setDependentSubscriberIdNumberType(String dependentSubscriberIdNumberType) {
        this.dependentSubscriberIdNumberType = dependentSubscriberIdNumberType;
    }

    @Override
    public String toString() {
        return "DependentDetails{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", dependentFirstName='" + dependentFirstName + '\'' +
                ", dependentLastName='" + dependentLastName + '\'' +
                ", dependentMiddleName='" + dependentMiddleName + '\'' +
                ", dependentSuffix='" + dependentSuffix + '\'' +
                ", dependentGender='" + dependentGender + '\'' +
                ", dependentDob=" + dependentDob +
                ", dependentPrefix='" + dependentPrefix + '\'' +
                ", dependentRelToSubscriber='" + dependentRelToSubscriber + '\'' +
                ", dependentSubscriberIdentificationCode='" + dependentSubscriberIdentificationCode + '\'' +
                ", dependentSubscriberIdentificationNumberType='" + dependentSubscriberIdentificationNumberType + '\'' +
                ", dependentSubscriberSupplementalId='" + dependentSubscriberSupplementalId + '\'' +
                ", dependentSubscriberIdNumberType='" + dependentSubscriberIdNumberType + '\'' +
                '}';
    }
}
