package com.edination.api.PDGM.model;

import javax.persistence.*;

@Entity
@Table(name = "M1850")
public class M1850 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int M1850ID;
    private int id;
    private boolean flag;
    private String discription;
    private int functionalPoint;
    private String mrnNumber;
    public M1850() {
    }

    public M1850(int m1850ID, int id, boolean flag, String discription, int functionalPoint, String mrnNumber) {
        M1850ID = m1850ID;
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

    public int getM1850ID() {
        return M1850ID;
    }

    public void setM1850ID(int m1850ID) {
        M1850ID = m1850ID;
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
        return "M1850{" +
                "M1850ID=" + M1850ID +
                ", id=" + id +
                ", flag=" + flag +
                ", discription='" + discription + '\'' +
                ", functionalPoint=" + functionalPoint +
                ", mrnNumber='" + mrnNumber + '\'' +
                '}';
    }
}
