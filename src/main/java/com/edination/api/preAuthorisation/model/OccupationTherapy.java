package com.edination.api.preAuthorisation.model;


import javax.persistence.*;

@Entity
@Table(name = "OccupationTherapy")
public class OccupationTherapy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mrnNumber;
    private int revenueCode;
    private int visits;
    private int units;
    private boolean occupationTherapy;

    public OccupationTherapy() {
    }

    public OccupationTherapy(String mrnNumber, int revenueCode, int visits, int units, boolean occupationTherapy) {
        this.mrnNumber = mrnNumber;
        this.revenueCode = revenueCode;
        this.visits = visits;
        this.units = units;
        this.occupationTherapy = occupationTherapy;
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

    public boolean isOccupationTherapy() {
        return occupationTherapy;
    }

    public void setOccupationTherapy(boolean occupationTherapy) {
        this.occupationTherapy = occupationTherapy;
    }

    @Override
    public String toString() {
        return "OccupationTherapy{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", revenueCode=" + revenueCode +
                ", visits=" + visits +
                ", units=" + units +
                ", occupationTherapy=" + occupationTherapy +
                '}';
    }
}
