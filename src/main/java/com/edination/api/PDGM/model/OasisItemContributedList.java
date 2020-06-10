package com.edination.api.PDGM.model;

import java.util.List;

public class OasisItemContributedList {
private String mrnNumber;
    List<M1033> m1033List;
    List<M1800> m1800List;
    List<M1810> m1810List;
    List<M1820> m1820List;
    List<M1830> m1830List;
    List<M1840> m1840List;
    List<M1850> m1850List;
    List<M1860> m1860List;

    public OasisItemContributedList() {
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public List<M1033> getM1033List() {
        return m1033List;
    }

    public void setM1033List(List<M1033> m1033List) {
        this.m1033List = m1033List;
    }

    public List<M1800> getM1800List() {
        return m1800List;
    }

    public void setM1800List(List<M1800> m1800List) {
        this.m1800List = m1800List;
    }

    public List<M1810> getM1810List() {
        return m1810List;
    }

    public void setM1810List(List<M1810> m1810List) {
        this.m1810List = m1810List;
    }

    public List<M1820> getM1820List() {
        return m1820List;
    }

    public void setM1820List(List<M1820> m1820List) {
        this.m1820List = m1820List;
    }

    public List<M1830> getM1830List() {
        return m1830List;
    }

    public void setM1830List(List<M1830> m1830List) {
        this.m1830List = m1830List;
    }

    public List<M1840> getM1840List() {
        return m1840List;
    }

    public void setM1840List(List<M1840> m1840List) {
        this.m1840List = m1840List;
    }



    public List<M1850> getM1850List() {
        return m1850List;
    }

    public void setM1850List(List<M1850> m1850List) {
        this.m1850List = m1850List;
    }

    public List<M1860> getM1860List() {
        return m1860List;
    }

    public void setM1860List(List<M1860> m1860List) {
        this.m1860List = m1860List;
    }
    @Override
    public String toString() {
        return "OasisItemContributedList{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", m1033List=" + m1033List +
                ", m1800List=" + m1800List +
                ", m1810List=" + m1810List +
                ", m1820List=" + m1820List +
                ", m1830List=" + m1830List +
                ", m1840List=" + m1840List +
                ", m1850List=" + m1850List +
                ", m1860List=" + m1860List +
                '}';
    }

}
