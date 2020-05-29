package com.edination.api.PDGM.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "EpisodeDetail")
public class EpisodeDetail {

    @Id
    private String mrnNumber;
    private String firstName;
    private String lastName;
    private String middleName;
    private String suffix;
    private String gender;
    private Date dob;
    private String episodeId;
    private String episodeType;
    private Date episodeStartDate;
    private Date episodeEndDate;
    private String numberOrVisits;

    public EpisodeDetail() {
    }

    public EpisodeDetail(String mrnNumber, String firstName, String lastName, String middleName, String suffix, String gender, Date dob, String episodeId, String episodeType, Date episodeStartDate, Date episodeEndDate, String numberOrVisits) {
        this.mrnNumber = mrnNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.suffix = suffix;
        this.gender = gender;
        this.dob = dob;
        this.episodeId = episodeId;
        this.episodeType = episodeType;
        this.episodeStartDate = episodeStartDate;
        this.episodeEndDate = episodeEndDate;
        this.numberOrVisits = numberOrVisits;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getEpisodeId() {
        return episodeId;
    }

    public void setEpisodeId(String episodeId) {
        this.episodeId = episodeId;
    }

    public String getEpisodeType() {
        return episodeType;
    }

    public void setEpisodeType(String episodeType) {
        this.episodeType = episodeType;
    }

    public Date getEpisodeStartDate() {
        return episodeStartDate;
    }

    public void setEpisodeStartDate(Date episodeStartDate) {
        this.episodeStartDate = episodeStartDate;
    }

    public Date getEpisodeEndDate() {
        return episodeEndDate;
    }

    public void setEpisodeEndDate(Date episodeEndDate) {
        this.episodeEndDate = episodeEndDate;
    }

    public String getNumberOrVisits() {
        return numberOrVisits;
    }

    public void setNumberOrVisits(String numberOrVisits) {
        this.numberOrVisits = numberOrVisits;
    }

    @Override
    public String toString() {
        return "EpisodeDetail{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", suffix='" + suffix + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", episodeId='" + episodeId + '\'' +
                ", episodeType='" + episodeType + '\'' +
                ", episodeStartDate=" + episodeStartDate +
                ", episodeEndDate=" + episodeEndDate +
                ", numberOrVisits='" + numberOrVisits + '\'' +
                '}';
    }
}
