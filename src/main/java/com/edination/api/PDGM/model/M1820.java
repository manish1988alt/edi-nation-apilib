package com.edination.api.PDGM.model;

import javax.persistence.*;

@Entity
@Table(name = "M1820")
public class M1820 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int M1820ID;
    private int id;
    private boolean flag;
    private String discription;
    private int functionalPoint;
    private String mrnNumber;


    public M1820() {
    }

    public M1820(int m1820ID, int id, boolean flag, String discription, int functionalPoint, String mrnNumber) {
        M1820ID = m1820ID;
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

    public int getM1820ID() {
        return M1820ID;
    }

    public void setM1820ID(int m1820ID) {
        M1820ID = m1820ID;
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
        return "M1820{" +
                "M1820ID=" + M1820ID +
                ", id=" + id +
                ", flag=" + flag +
                ", discription='" + discription + '\'' +
                ", functionalPoint=" + functionalPoint +
                ", mrnNumber='" + mrnNumber + '\'' +
                '}';
    }
}
