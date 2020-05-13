package com.edination.api.preAuthorisation.model;

import javax.persistence.*;

@Entity
@Table(name = "HomeHealthAide")
public class HomeHealthAide {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String mrnNumber;
    private int revenueCode;
    private int visits;
    private int units;
    private boolean homeHealthAide;

    public HomeHealthAide() {
    }

    public HomeHealthAide(String mrnNumber, int revenueCode, int visits, int units, boolean homeHealthAide) {
        this.mrnNumber = mrnNumber;
        this.revenueCode = revenueCode;
        this.visits = visits;
        this.units = units;
        this.homeHealthAide = homeHealthAide;
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

    public boolean isHomeHealthAide() {
        return homeHealthAide;
    }

    public void setHomeHealthAide(boolean homeHealthAide) {
        this.homeHealthAide = homeHealthAide;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "HomeHealthAide{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", revenueCode=" + revenueCode +
                ", visits=" + visits +
                ", units=" + units +
                ", homeHealthAide=" + homeHealthAide +
                '}';
    }
}
