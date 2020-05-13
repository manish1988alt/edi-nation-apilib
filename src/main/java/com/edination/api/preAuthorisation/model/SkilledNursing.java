package com.edination.api.preAuthorisation.model;

import javax.persistence.*;

@Entity
@Table(name = "SkilledNursing")
public class SkilledNursing {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String mrnNumber;
    private int revenueCode;
    private int visits;
    private int units;
    private boolean skilledNursing;

    public SkilledNursing() {
    }

    public SkilledNursing(String mrnNumber, int revenueCode, int visits, int units, boolean skilledNursing) {
        this.mrnNumber = mrnNumber;
        this.revenueCode = revenueCode;
        this.visits = visits;
        this.units = units;
        this.skilledNursing = skilledNursing;
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

    public boolean isSkilledNursing() {
        return skilledNursing;
    }

    public void setSkilledNursing(boolean skilledNursing) {
        this.skilledNursing = skilledNursing;
    }

    @Override
    public String toString() {
        return "SkilledNursing{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", revenueCode=" + revenueCode +
                ", visits=" + visits +
                ", units=" + units +
                ", skilledNursing=" + skilledNursing +
                '}';
    }
}
