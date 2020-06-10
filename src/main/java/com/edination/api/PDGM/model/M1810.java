package com.edination.api.PDGM.model;


import javax.persistence.*;

@Entity
@Table(name = "M1810")
public class M1810 {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int M1810ID;
    private int id;
    private boolean flag;
    private String discription;
    private int functionalPoint;
    private String mrnNumber;

    public M1810() {
    }

    public M1810(int m1810ID, int id, boolean flag, String discription, int functionalPoint, String mrnNumber) {
        M1810ID = m1810ID;
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

    public int getM1810ID() {
        return M1810ID;
    }

    public void setM1810ID(int m1810ID) {
        M1810ID = m1810ID;
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
        return "M1810{" +
                "M1810ID=" + M1810ID +
                ", id=" + id +
                ", flag=" + flag +
                ", discription='" + discription + '\'' +
                ", functionalPoint=" + functionalPoint +
                ", mrnNumber='" + mrnNumber + '\'' +
                '}';
    }
}

