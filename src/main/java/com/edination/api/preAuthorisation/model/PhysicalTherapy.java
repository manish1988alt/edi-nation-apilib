package com.edination.api.preAuthorisation.model;

import javax.persistence.*;

@Entity
@Table(name = "PhysicalTherapy")
public class PhysicalTherapy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String mrnNumber;
    private int revenueCode;
    private boolean PhysicalTherapy;
    private int visits;
    private int units;

    public PhysicalTherapy() {
    }

    public PhysicalTherapy(String mrnNumber, int revenueCode, boolean physicalTherapy, int visits, int units) {
        this.mrnNumber = mrnNumber;
        this.revenueCode = revenueCode;
        PhysicalTherapy = physicalTherapy;
        this.visits = visits;
        this.units = units;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public int getRevenueCode() {
        return revenueCode;
    }

    public void setRevenueCode(int revenueCode) {
        this.revenueCode = revenueCode;
    }

    public boolean getPhysicalTherapy() {
        return PhysicalTherapy;
    }

    public void setPhysicalTherapy(boolean physicalTherapy) {
        PhysicalTherapy = physicalTherapy;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PhysicalTherapy{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", revenueCode=" + revenueCode +
                ", PhysicalTherapy=" + PhysicalTherapy +
                ", visits=" + visits +
                ", units=" + units +
                '}';
    }
}
