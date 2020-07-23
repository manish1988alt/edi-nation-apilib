package com.edination.api.LoginPackage.model;


import com.edination.api.PDGM.model.AdmissionSource;
import com.edination.api.PDGM.model.EpisodeDetail;
import com.edination.api.eligibility.model.Demographics;
import com.edination.api.rap.model.PrimaryDiagnosisCode;

import java.time.LocalDate;
import java.util.List;

public class IntakeList {
    private String patientMRN;
    private String firstName;
    private String lastName;
    private String middleName;
    private String prefix;
    private String suffix;
    private String gender;
    private LocalDate dob;
    private LocalDate refferDate;
    private LocalDate episodeStartDate;
    private LocalDate episodeEndDate;
    private String addmissionStatus;
    private String episodeType;
    private String oasisStatus;

    public IntakeList() {
    }

    public IntakeList(String patientMRN, String firstName, String lastName, String middleName, String prefix, String suffix, String gender, LocalDate dob, LocalDate refferDate, LocalDate episodeStartDate, LocalDate episodeEndDate, String addmissionStatus, String episodeType, String oasisStatus) {
        this.patientMRN = patientMRN;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.prefix = prefix;
        this.suffix = suffix;
        this.gender = gender;
        this.dob = dob;
        this.refferDate = refferDate;
        this.episodeStartDate = episodeStartDate;
        this.episodeEndDate = episodeEndDate;
        this.addmissionStatus = addmissionStatus;
        this.episodeType = episodeType;
        this.oasisStatus = oasisStatus;
    }

    public String getPatientMRN() {
        return patientMRN;
    }

    public void setPatientMRN(String patientMRN) {
        this.patientMRN = patientMRN;
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

    public LocalDate getRefferDate() {
        return refferDate;
    }

    public void setRefferDate(LocalDate refferDate) {
        this.refferDate = refferDate;
    }

    public LocalDate getEpisodeStartDate() {
        return episodeStartDate;
    }

    public void setEpisodeStartDate(LocalDate episodeStartDate) {
        this.episodeStartDate = episodeStartDate;
    }

    public LocalDate getEpisodeEndDate() {
        return episodeEndDate;
    }

    public void setEpisodeEndDate(LocalDate episodeEndDate) {
        this.episodeEndDate = episodeEndDate;
    }

    public String getAddmissionStatus() {
        return addmissionStatus;
    }

    public void setAddmissionStatus(String addmissionStatus) {
        this.addmissionStatus = addmissionStatus;
    }

    public String getEpisodeType() {
        return episodeType;
    }

    public void setEpisodeType(String episodeType) {
        this.episodeType = episodeType;
    }

    public String getOasisStatus() {
        return oasisStatus;
    }

    public void setOasisStatus(String oasisStatus) {
        this.oasisStatus = oasisStatus;
    }

    @Override
    public String toString() {
        return "IntakeList{" +
                "patientMRN='" + patientMRN + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", refferDate=" + refferDate +
                ", episodeStartDate=" + episodeStartDate +
                ", episodeEndDate=" + episodeEndDate +
                ", addmissionStatus='" + addmissionStatus + '\'' +
                ", episodeType='" + episodeType + '\'' +
                ", oasisStatus='" + oasisStatus + '\'' +
                '}';
    }
}

