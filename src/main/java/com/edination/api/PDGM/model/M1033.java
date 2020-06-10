package com.edination.api.PDGM.model;

import javax.persistence.*;

@Entity
@Table(name = "M1033")
public class M1033 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int M1033ID;
    private int id;
    private boolean flag;
    private String discription;
    private int functionalPoint;
    private String mrnNumber;

    public M1033() {
    }

    public M1033(int m1033ID, int id, boolean flag, String discription, int functionalPoint, String mrnNumber) {
        M1033ID = m1033ID;
        this.id = id;
        this.flag = flag;
        this.discription = discription;
        this.functionalPoint = functionalPoint;
        this.mrnNumber = mrnNumber;
    }

    public int getM1033ID() {
        return M1033ID;
    }

    public void setM1033ID(int m1033ID) {
        M1033ID = m1033ID;
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

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    @Override
    public String toString() {
        return "M1033{" +
                "M1033ID=" + M1033ID +
                ", id=" + id +
                ", flag=" + flag +
                ", discription='" + discription + '\'' +
                ", functionalPoint=" + functionalPoint +
                ", mrnNumber='" + mrnNumber + '\'' +
                '}';
    }
}
