package com.edination.api.eligibility.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Entity
@Table(name = "SubscriberDetail")
public class SubscriberDetail {
    @Id
    private String subscriberPrimaryIdentifier;
    private String subscriberLastName;
    private String  subscriberFirstName;
    private String subscriberNameSuffix;
    private Date  subscriberBirthDate;
    private String   dateTimeQualifier;
    private String   serviceTypeCode;
    private String   compositeMedicalProcedureIdentifier;

    public SubscriberDetail(String subscriberPrimaryIdentifier, String subscriberLastName, String subscriberFirstName, String subscriberNameSuffix, Date subscriberBirthDate, String dateTimeQualifier, String serviceTypeCode, String compositeMedicalProcedureIdentifier) {
        this.subscriberPrimaryIdentifier = subscriberPrimaryIdentifier;
        this.subscriberLastName = subscriberLastName;
        this.subscriberFirstName = subscriberFirstName;
        this.subscriberNameSuffix = subscriberNameSuffix;
        this.subscriberBirthDate = subscriberBirthDate;
        this.dateTimeQualifier = dateTimeQualifier;
        this.serviceTypeCode = serviceTypeCode;
        this.compositeMedicalProcedureIdentifier = compositeMedicalProcedureIdentifier;
    }

    public String getSubscriberPrimaryIdentifier() {
        return subscriberPrimaryIdentifier;
    }

    public void setSubscriberPrimaryIdentifier(String subscriberPrimaryIdentifier) {
        this.subscriberPrimaryIdentifier = subscriberPrimaryIdentifier;
    }

    public String getSubscriberLastName() {
        return subscriberLastName;
    }

    public void setSubscriberLastName(String subscriberLastName) {
        this.subscriberLastName = subscriberLastName;
    }

    public String getSubscriberFirstName() {
        return subscriberFirstName;
    }

    public void setSubscriberFirstName(String subscriberFirstName) {
        this.subscriberFirstName = subscriberFirstName;
    }

    public String getSubscriberNameSuffix() {
        return subscriberNameSuffix;
    }

    public void setSubscriberNameSuffix(String subscriberNameSuffix) {
        this.subscriberNameSuffix = subscriberNameSuffix;
    }

    public Date getSubscriberBirthDate() {
        return subscriberBirthDate;
    }

    public void setSubscriberBirthDate(Date subscriberBirthDate) {
        this.subscriberBirthDate = subscriberBirthDate;
    }

    public String getDateTimeQualifier() {
        return dateTimeQualifier;
    }

    public void setDateTimeQualifier(String dateTimeQualifier) {
        this.dateTimeQualifier = dateTimeQualifier;
    }

    public String getServiceTypeCode() {
        return serviceTypeCode;
    }

    public void setServiceTypeCode(String serviceTypeCode) {
        this.serviceTypeCode = serviceTypeCode;
    }

    public String getCompositeMedicalProcedureIdentifier() {
        return compositeMedicalProcedureIdentifier;
    }

    public void setCompositeMedicalProcedureIdentifier(String compositeMedicalProcedureIdentifier) {
        this.compositeMedicalProcedureIdentifier = compositeMedicalProcedureIdentifier;
    }

    @Override
    public String toString() {
        return "SubscriberDetail{" +
                "subscriberPrimaryIdentifier='" + subscriberPrimaryIdentifier + '\'' +
                ", subscriberLastName='" + subscriberLastName + '\'' +
                ", subscriberFirstName='" + subscriberFirstName + '\'' +
                ", subscriberNameSuffix='" + subscriberNameSuffix + '\'' +
                ", subscriberBirthDate=" + subscriberBirthDate +
                ", dateTimeQualifier='" + dateTimeQualifier + '\'' +
                ", serviceTypeCode='" + serviceTypeCode + '\'' +
                ", compositeMedicalProcedureIdentifier='" + compositeMedicalProcedureIdentifier + '\'' +
                '}';
    }
}
