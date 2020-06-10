package com.edination.api.PDGM.model;


import javax.persistence.*;

@Entity
@Table(name = "M1860")
public class M1860 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int M1860ID;
    private int id;
    private boolean flag;
    private String discription;
    private int functionalPoint;
    private String mrnNumber;
    public M1860() {
    }

    public M1860(int m1860ID, int id, boolean flag, String discription, int functionalPoint, String mrnNumber) {
        M1860ID = m1860ID;
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

    public int getM1860ID() {
        return M1860ID;
    }

    public void setM1860ID(int m1860ID) {
        M1860ID = m1860ID;
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
        return "M1860{" +
                "M1860ID=" + M1860ID +
                ", id=" + id +
                ", flag=" + flag +
                ", discription='" + discription + '\'' +
                ", functionalPoint=" + functionalPoint +
                ", mrnNumber='" + mrnNumber + '\'' +
                '}';
    }




}
