package com.edination.api.PDGM.model;

import javax.persistence.*;

@Entity
@Table(name = "M1840")
public class M1840 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int M1840ID;
    private int id;
    private boolean flag;
    private String discription;
    private int functionalPoint;
    private String mrnNumber;

    public M1840() {
    }

    public M1840(int m1840ID, int id, boolean flag, String discription, int functionalPoint, String mrnNumber) {
        M1840ID = m1840ID;
        this.id = id;
        this.flag = flag;
        this.discription = discription;
        this.functionalPoint = functionalPoint;
        this.mrnNumber = mrnNumber;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public int getM1840ID() {
        return M1840ID;
    }

    public void setM1840ID(int m1840ID) {
        M1840ID = m1840ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public int getFunctionalPoint() {
        return functionalPoint;
    }

    public void setFunctionalPoint(int functionalPoint) {
        this.functionalPoint = functionalPoint;
    }

    @Override
    public String toString() {
        return "M1840{" +
                "M1840ID=" + M1840ID +
                ", id=" + id +
                ", flag=" + flag +
                ", discription='" + discription + '\'' +
                ", functionalPoint=" + functionalPoint +
                ", mrnNumber='" + mrnNumber + '\'' +
                '}';
    }
}
