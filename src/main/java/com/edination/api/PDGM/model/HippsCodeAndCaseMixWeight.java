package com.edination.api.PDGM.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HippsCodeAndCaseMixWeight")
public class HippsCodeAndCaseMixWeight {
    @Id
    private String mrnNumber;
    private String position1;
    private String position2;
    private String position3;
    private String position4;
    private String position5;
    private String hippscode;
    private double weight;

    public HippsCodeAndCaseMixWeight() {
    }

    public HippsCodeAndCaseMixWeight(String mrnNumber, String position1, String position2, String position3, String position4, String position5, String hippscode, double weight) {
        this.mrnNumber = mrnNumber;
        this.position1 = position1;
        this.position2 = position2;
        this.position3 = position3;
        this.position4 = position4;
        this.position5 = position5;
        this.hippscode = hippscode;
        this.weight = weight;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public String getPosition1() {
        return position1;
    }

    public void setPosition1(String position1) {
        this.position1 = position1;
    }

    public String getPosition2() {
        return position2;
    }

    public void setPosition2(String position2) {
        this.position2 = position2;
    }

    public String getPosition3() {
        return position3;
    }

    public void setPosition3(String position3) {
        this.position3 = position3;
    }

    public String getPosition4() {
        return position4;
    }

    public void setPosition4(String position4) {
        this.position4 = position4;
    }

    public String getPosition5() {
        return position5;
    }

    public void setPosition5(String position5) {
        this.position5 = position5;
    }

    public String getHippscode() {
        return hippscode;
    }

    public void setHippscode(String hippscode) {
        this.hippscode = hippscode;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "HippsCodeAndCaseMixWeight{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", position1='" + position1 + '\'' +
                ", position2='" + position2 + '\'' +
                ", position3='" + position3 + '\'' +
                ", position4='" + position4 + '\'' +
                ", position5='" + position5 + '\'' +
                ", hippscode='" + hippscode + '\'' +
                ", weight=" + weight +
                '}';
    }
}
