package com.edination.api.preAuthorisation.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DependentDetailResponse")
public class DependentDetailResponse {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String dependentFirstName;
    private String dependentLastName;
    private String dependentMiddleName;
    private String dependentPrefix;
    private String dependentSuffix;
    private String dependentGender;
    private Date dependentDob;
    private String dependentSubscriberIdentificationCode;
    private String dependentSubscriberIdNumberType;
    private String dependentReletionship;
    private String  dependentDetailStatus;
    private String dependentSupplementalId;
    private String  dependentIdentificationNumberType;
    private String dependentRejectionReaso;
    private String dependentFollowUpActionDescription;

    public DependentDetailResponse() {
    }

    public DependentDetailResponse(String dependentFirstName, String dependentLastName, String dependentMiddleName, String dependentPrefix, String dependentSuffix, String dependentGender, Date dependentDob, String dependentSubscriberIdentificationCode, String dependentSubscriberIdNumberType, String dependentReletionship, String dependentDetailStatus, String dependentSupplementalId, String dependentIdentificationNumberType, String dependentRejectionReaso, String dependentFollowUpActionDescription) {
        this.dependentFirstName = dependentFirstName;
        this.dependentLastName = dependentLastName;
        this.dependentMiddleName = dependentMiddleName;
        this.dependentPrefix = dependentPrefix;
        this.dependentSuffix = dependentSuffix;
        this.dependentGender = dependentGender;
        this.dependentDob = dependentDob;
        this.dependentSubscriberIdentificationCode = dependentSubscriberIdentificationCode;
        this.dependentSubscriberIdNumberType = dependentSubscriberIdNumberType;
        this.dependentReletionship = dependentReletionship;
        this.dependentDetailStatus = dependentDetailStatus;
        this.dependentSupplementalId = dependentSupplementalId;
        this.dependentIdentificationNumberType = dependentIdentificationNumberType;
        this.dependentRejectionReaso = dependentRejectionReaso;
        this.dependentFollowUpActionDescription = dependentFollowUpActionDescription;
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

    public String getDependentPrefix() {
        return dependentPrefix;
    }

    public void setDependentPrefix(String dependentPrefix) {
        this.dependentPrefix = dependentPrefix;
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

    public String getDependentSubscriberIdentificationCode() {
        return dependentSubscriberIdentificationCode;
    }

    public void setDependentSubscriberIdentificationCode(String dependentSubscriberIdentificationCode) {
        this.dependentSubscriberIdentificationCode = dependentSubscriberIdentificationCode;
    }

    public String getDependentSubscriberIdNumberType() {
        return dependentSubscriberIdNumberType;
    }

    public void setDependentSubscriberIdNumberType(String dependentSubscriberIdNumberType) {
        this.dependentSubscriberIdNumberType = dependentSubscriberIdNumberType;
    }

    public String getDependentReletionship() {
        return dependentReletionship;
    }

    public void setDependentReletionship(String dependentReletionship) {
        this.dependentReletionship = dependentReletionship;
    }

    public String getDependentDetailStatus() {
        return dependentDetailStatus;
    }

    public void setDependentDetailStatus(String dependentDetailStatus) {
        this.dependentDetailStatus = dependentDetailStatus;
    }

    public String getDependentSupplementalId() {
        return dependentSupplementalId;
    }

    public void setDependentSupplementalId(String dependentSupplementalId) {
        this.dependentSupplementalId = dependentSupplementalId;
    }

    public String getDependentIdentificationNumberType() {
        return dependentIdentificationNumberType;
    }

    public void setDependentIdentificationNumberType(String dependentIdentificationNumberType) {
        this.dependentIdentificationNumberType = dependentIdentificationNumberType;
    }

    public String getDependentRejectionReaso() {
        return dependentRejectionReaso;
    }

    public void setDependentRejectionReaso(String dependentRejectionReaso) {
        this.dependentRejectionReaso = dependentRejectionReaso;
    }

    public String getDependentFollowUpActionDescription() {
        return dependentFollowUpActionDescription;
    }

    public void setDependentFollowUpActionDescription(String dependentFollowUpActionDescription) {
        this.dependentFollowUpActionDescription = dependentFollowUpActionDescription;
    }

    @Override
    public String toString() {
        return "DependentDetailResponse{" +
                "id=" + id +
                ", dependentFirstName='" + dependentFirstName + '\'' +
                ", dependentLastName='" + dependentLastName + '\'' +
                ", dependentMiddleName='" + dependentMiddleName + '\'' +
                ", dependentPrefix='" + dependentPrefix + '\'' +
                ", dependentSuffix='" + dependentSuffix + '\'' +
                ", dependentGender='" + dependentGender + '\'' +
                ", dependentDob=" + dependentDob +
                ", dependentSubscriberIdentificationCode='" + dependentSubscriberIdentificationCode + '\'' +
                ", dependentSubscriberIdNumberType='" + dependentSubscriberIdNumberType + '\'' +
                ", dependentReletionship='" + dependentReletionship + '\'' +
                ", dependentDetailStatus='" + dependentDetailStatus + '\'' +
                ", dependentSupplementalId='" + dependentSupplementalId + '\'' +
                ", dependentIdentificationNumberType='" + dependentIdentificationNumberType + '\'' +
                ", dependentRejectionReaso='" + dependentRejectionReaso + '\'' +
                ", dependentFollowUpActionDescription='" + dependentFollowUpActionDescription + '\'' +
                '}';
    }
}
