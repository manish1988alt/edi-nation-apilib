package com.edination.api.PDGM.model;

import javax.persistence.*;

@Entity
@Table(name = "M1830")
public class M1830 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int M1830ID;
    private int id;
    private boolean flag;
    private String discription;
    private int functionalPoint;
    private String mrnNumber;

    public M1830() {
    }

    public M1830(int m1830ID, int id, boolean flag, String discription, int functionalPoint, String mrnNumber) {
        M1830ID = m1830ID;
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

    public int getM1830ID() {
        return M1830ID;
    }

    public void setM1830ID(int m1830ID) {
        M1830ID = m1830ID;
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
        return "M1830{" +
                "M1830ID=" + M1830ID +
                ", id=" + id +
                ", flag=" + flag +
                ", discription='" + discription + '\'' +
                ", functionalPoint=" + functionalPoint +
                ", mrnNumber='" + mrnNumber + '\'' +
                '}';
    }
}
