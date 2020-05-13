package com.edination.api.preAuthorisation.model;

import javax.persistence.*;

@Entity
@Table(name = "MedicalSocialWork")
public class MedicalSocialWork {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mrnNumber;
    private int revenueCode;
    private int visits;
    private int units;
    private boolean medicalSocialWork;

    public MedicalSocialWork() {
    }

    public MedicalSocialWork(String mrnNumber, int revenueCode, int visits, int units, boolean medicalSocialWork) {
        this.mrnNumber = mrnNumber;
        this.revenueCode = revenueCode;
        this.visits = visits;
        this.units = units;
        this.medicalSocialWork = medicalSocialWork;
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

    public int getRevenueCode() {
        return revenueCode;
    }

    public void setRevenueCode(int revenueCode) {
        this.revenueCode = revenueCode;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public boolean isMedicalSocialWork() {
        return medicalSocialWork;
    }

    public void setMedicalSocialWork(boolean medicalSocialWork) {
        this.medicalSocialWork = medicalSocialWork;
    }

    @Override
    public String toString() {
        return "MedicalSocialWork{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", revenueCode=" + revenueCode +
                ", visits=" + visits +
                ", units=" + units +
                ", medicalSocialWork=" + medicalSocialWork +
                '}';
    }
}
