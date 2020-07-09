package com.edination.api.PDGM.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
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
    private LocalDate hippsCodeGeneratedDate;
    private String oasisKey;
    private String claimType;
    private String action;
    private String primaryDiagnosisCode;
    private String rapsType;
    private String rapsFormStatus;
    private Date rapsSentDate;

    public PDGMRapListing() {
    }

    public PDGMRapListing(String mrnNumber, String firstName, String lastName, String middleName, String suffix, String episodeId, String oasisType, Date episodeStartDates, Date episodeEndDates, String aging, String billableVisit, String hippsCode, LocalDate hippsCodeGeneratedDate, String oasisKey, String claimType, String action, String primaryDiagnosisCode, String rapsType, String rapsFormStatus, Date rapsSentDate) {
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
        this.hippsCodeGeneratedDate = hippsCodeGeneratedDate;
        this.oasisKey = oasisKey;
        this.claimType = claimType;
        this.action = action;
        this.primaryDiagnosisCode = primaryDiagnosisCode;
        this.rapsType = rapsType;
        this.rapsFormStatus = rapsFormStatus;
        this.rapsSentDate = rapsSentDate;
    }

    public LocalDate getHippsCodeGeneratedDate() {
        return hippsCodeGeneratedDate;
    }

    public void setHippsCodeGeneratedDate(LocalDate hippsCodeGeneratedDate) {
        this.hippsCodeGeneratedDate = hippsCodeGeneratedDate;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getRapsType() {
        return rapsType;
    }

    public void setRapsType(String rapsType) {
        this.rapsType = rapsType;
    }

    public String getRapsFormStatus() {
        return rapsFormStatus;
    }

    public void setRapsFormStatus(String rapsFormStatus) {
        this.rapsFormStatus = rapsFormStatus;
    }

    public Date getRapsSentDate() {
        return rapsSentDate;
    }

    public void setRapsSentDate(Date rapsSentDate) {
        this.rapsSentDate = rapsSentDate;
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

    public String getPrimaryDiagnosisCode() {
        return primaryDiagnosisCode;
    }

    public void setPrimaryDiagnosisCode(String primaryDiagnosisCode) {
        this.primaryDiagnosisCode = primaryDiagnosisCode;
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
                ", hippsCodeGeneratedDate=" + hippsCodeGeneratedDate +
                ", oasisKey='" + oasisKey + '\'' +
                ", claimType='" + claimType + '\'' +
                ", action='" + action + '\'' +
                ", primaryDiagnosisCode='" + primaryDiagnosisCode + '\'' +
                ", rapsType='" + rapsType + '\'' +
                ", rapsFormStatus='" + rapsFormStatus + '\'' +
                ", rapsSentDate=" + rapsSentDate +
                '}';
    }
}
