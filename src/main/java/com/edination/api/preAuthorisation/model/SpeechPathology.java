package com.edination.api.preAuthorisation.model;

import javax.persistence.*;

@Entity
@Table(name = "SpeechPathology")
public class SpeechPathology {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mrnNumber;
    private int revenueCode;
    private int visits;
    private int units;
    private boolean speechPathology;

    public SpeechPathology() {
    }

    public SpeechPathology(String mrnNumber, int revenueCode, int visits, int units, boolean speechPathology) {
        this.mrnNumber = mrnNumber;
        this.revenueCode = revenueCode;
        this.visits = visits;
        this.units = units;
        this.speechPathology = speechPathology;
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

    public boolean isSpeechPathology() {
        return speechPathology;
    }

    public void setSpeechPathology(boolean speechPathology) {
        this.speechPathology = speechPathology;
    }

    @Override
    public String toString() {
        return "SpeechPathology{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", revenueCode=" + revenueCode +
                ", visits=" + visits +
                ", units=" + units +
                ", speechPathology=" + speechPathology +
                '}';
    }
}
