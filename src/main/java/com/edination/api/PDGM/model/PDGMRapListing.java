package com.edination.api.PDGM.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Entity
@Table(name = "PDGMRapListing")
public class PDGMRapListing {

    @Id
    private String mrnNumber;
    private String firstName;
    private String lastName;
    private String middleName;
    private String suffix;
    private String episodeId;
    private String oasisType;
    private Date episodeStartDates;
    private Date episodeEndDates;
    private String aging;
    private String billableVisit;
    private String hippsCode;
    private String oasisKey;
    private String claimType;

    public PDGMRapListing() {
    }

    public PDGMRapListing(String mrnNumber, String firstName, String lastName, String middleName, String suffix, String episodeId, String oasisType, Date episodeStartDates, Date episodeEndDates, String aging, String billableVisit, String hippsCode, String oasisKey, String claimType) {
        this.mrnNumber = mrnNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.suffix = suffix;
        this.episodeId = episodeId;
        this.oasisType = oasisType;
        this.episodeStartDates = episodeStartDates;
        this.episodeEndDates = episodeEndDates;
        this.aging = aging;
        this.billableVisit = billableVisit;
        this.hippsCode = hippsCode;
        this.oasisKey = oasisKey;
        this.claimType = claimType;
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

    public String getOasisType() {
        return oasisType;
    }

    public void setOasisType(String oasisType) {
        this.oasisType = oasisType;
    }

    public String getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(String episodeId) {
        this.episodeId = episodeId;
    }

    public Date getEpisodeStartDates() {
        return episodeStartDates;
    }

    public void setEpisodeStartDates(Date episodeStartDates) {
        this.episodeStartDates = episodeStartDates;
    }

    public Date getEpisodeEndDates() {
        return episodeEndDates;
    }

    public void setEpisodeEndDates(Date episodeEndDates) {
        this.episodeEndDates = episodeEndDates;
    }

    public String getAging() {
        return aging;
    }

    public void setAging(String aging) {
        this.aging = aging;
    }

    public String getBillableVisit() {
        return billableVisit;
    }

    public void setBillableVisit(String billableVisit) {
        this.billableVisit = billableVisit;
    }

    public String getHippsCode() {
        return hippsCode;
    }

    public void setHippsCode(String hippsCode) {
        this.hippsCode = hippsCode;
    }

    public String getOasisKey() {
        return oasisKey;
    }

    public void setOasisKey(String oasisKey) {
        this.oasisKey = oasisKey;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    @Override
    public String toString() {
        return "PDGMRapListing{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", suffix='" + suffix + '\'' +
                ", episodeId='" + episodeId + '\'' +
                ", oasisType='" + oasisType + '\'' +
                ", episodeStartDates=" + episodeStartDates +
                ", episodeEndDates=" + episodeEndDates +
                ", aging='" + aging + '\'' +
                ", billableVisit='" + billableVisit + '\'' +
                ", hippsCode='" + hippsCode + '\'' +
                ", oasisKey='" + oasisKey + '\'' +
                ", claimType='" + claimType + '\'' +
                '}';
    }
}
