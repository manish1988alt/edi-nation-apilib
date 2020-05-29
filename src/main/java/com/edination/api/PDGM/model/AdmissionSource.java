package com.edination.api.PDGM.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "AdmissionSource")
public class AdmissionSource {
    @Id
    private String mrnNumber;
    private String souceOfAdmission;
    private Date referralDate;

    public AdmissionSource() {
    }

    public AdmissionSource(String mrnNumber, String souceOfAdmission, Date referralDate) {
        this.mrnNumber = mrnNumber;
        this.souceOfAdmission = souceOfAdmission;
        this.referralDate = referralDate;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public String getSouceOfAdmission() {
        return souceOfAdmission;
    }

    public void setSouceOfAdmission(String souceOfAdmission) {
        this.souceOfAdmission = souceOfAdmission;
    }

    public Date getReferralDate() {
        return referralDate;
    }

    public void setReferralDate(Date referralDate) {
        this.referralDate = referralDate;
    }

    @Override
    public String toString() {
        return "AdmissionSource{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", souceOfAdmission='" + souceOfAdmission + '\'' +
                ", referralDate=" + referralDate +
                '}';
    }
}
