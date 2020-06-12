package com.edination.api.preAuthorisation.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "PreAuthorizationResponseHistory")
public class PreAuthorizationResponseHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String firstName;
    private String lastName;
    private String middleName;
    private String prefix;
    private String suffix;
    private String mrnNumber;
    private String enquiryId;
    private Date requestSentDate;
    private Date responseReceiveDate;
    private String responseType;
    private String authorizationStatus;
    private String  authorizationEffectiveNess;

    public PreAuthorizationResponseHistory() {
    }

    public PreAuthorizationResponseHistory(String firstName, String lastName, String middleName, String prefix, String suffix, String mrnNumber, String enquiryId, Date requestSentDate, Date responseReceiveDate, String responseType, String authorizationStatus, String authorizationEffectiveNess) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.prefix = prefix;
        this.suffix = suffix;
        this.mrnNumber = mrnNumber;
        this.enquiryId = enquiryId;
        this.requestSentDate = requestSentDate;
        this.responseReceiveDate = responseReceiveDate;
        this.responseType = responseType;
        this.authorizationStatus = authorizationStatus;
        this.authorizationEffectiveNess = authorizationEffectiveNess;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public String getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(String enquiryId) {
        this.enquiryId = enquiryId;
    }

    public Date getRequestSentDate() {
        return requestSentDate;
    }

    public void setRequestSentDate(Date requestSentDate) {
        this.requestSentDate = requestSentDate;
    }

    public Date getResponseReceiveDate() {
        return responseReceiveDate;
    }

    public void setResponseReceiveDate(Date responseReceiveDate) {
        this.responseReceiveDate = responseReceiveDate;
    }

    public String getResponseType() {
        return responseType;
    }

    public void setResponseType(String responseType) {
        this.responseType = responseType;
    }

    public String getAuthorizationStatus() {
        return authorizationStatus;
    }

    public void setAuthorizationStatus(String authorizationStatus) {
        this.authorizationStatus = authorizationStatus;
    }

    public String getAuthorizationEffectiveNess() {
        return authorizationEffectiveNess;
    }

    public void setAuthorizationEffectiveNess(String authorizationEffectiveNess) {
        this.authorizationEffectiveNess = authorizationEffectiveNess;
    }

    @Override
    public String toString() {
        return "PreAuthorizationResponseHistory{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", enquiryId='" + enquiryId + '\'' +
                ", requestSentDate=" + requestSentDate +
                ", responseReceiveDate=" + responseReceiveDate +
                ", responseType='" + responseType + '\'' +
                ", authorizationStatus='" + authorizationStatus + '\'' +
                ", authorizationEffectiveNess='" + authorizationEffectiveNess + '\'' +
                '}';
    }
}
