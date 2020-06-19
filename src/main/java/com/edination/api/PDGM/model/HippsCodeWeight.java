package com.edination.api.PDGM.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HippsCodeWeight")
public class HippsCodeWeight {

    @Id
    private String hippscode;
    private double weight;
    private int visitThreshold;

    public HippsCodeWeight() {
    }

    public HippsCodeWeight(String hippscode, double weight, int visitThreshold) {
        this.hippscode = hippscode;
        this.weight = weight;
        this.visitThreshold = visitThreshold;
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

    public int getVisitThreshold() {
        return visitThreshold;
    }

    public void setVisitThreshold(int visitThreshold) {
        this.visitThreshold = visitThreshold;
    }

    @Override
    public String toString() {
        return "HippsCodeWeight{" +
                "hippscode='" + hippscode + '\'' +
                ", weight=" + weight +
                ", visitThreshold=" + visitThreshold +
                '}';
    }
}
