package com.edination.api.PDGM.model;

import javax.persistence.*;

@Entity
@Table(name = "OASISItemContributed")
public class OASISItemContributed {
    @Id
    private int oasisId;
    private String mrnNumbe;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "M1800Id")
    private M1800 m1800;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "M1810Id")
    private M1810 m1810;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "M1820Id")
    private M1820 m1820;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "M1830Id")
    private M1830 m1830;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "M1840Id")
    private M1840 m1840;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "M1850Id")
    private M1850 m1850;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "M1860Id")
    private M1860 m1860;


    public OASISItemContributed() {
    }

    public OASISItemContributed(int oasisId, String mrnNumbe) {
        this.oasisId = oasisId;
        this.mrnNumbe = mrnNumbe;
    }

    public String getMrnNumbe() {
        return mrnNumbe;
    }

    public void setMrnNumbe(String mrnNumbe) {
        this.mrnNumbe = mrnNumbe;
    }

    public M1800 getM1800() {
        return m1800;
    }

    public void setM1800(M1800 m1800) {
        this.m1800 = m1800;
    }

    public M1810 getM1810() {
        return m1810;
    }

    public void setM1810(M1810 m1810) {
        this.m1810 = m1810;
    }

    public M1820 getM1820() {
        return m1820;
    }

    public void setM1820(M1820 m1820) {
        this.m1820 = m1820;
    }

    public M1830 getM1830() {
        return m1830;
    }

    public void setM1830(M1830 m1830) {
        this.m1830 = m1830;
    }

    public M1840 getM1840() {
        return m1840;
    }

    public void setM1840(M1840 m1840) {
        this.m1840 = m1840;
    }

    public M1860 getM1860() {
        return m1860;
    }

    public void setM1860(M1860 m1860) {
        this.m1860 = m1860;
    }

    public M1850 getM1850() {
        return m1850;
    }

    public void setM1850(M1850 m1850) {
        this.m1850 = m1850;
    }

    public int getOasisId() {
        return oasisId;
    }

    public void setOasisId(int oasisId) {
        this.oasisId = oasisId;
    }

    @Override
    public String toString() {
        return "OASISItemContributed{" +
                "oasisId='" + oasisId + '\'' +
                ", mrnNumbe='" + mrnNumbe + '\'' +
                ", m1800=" + m1800 +
                ", m1810=" + m1810 +
                ", m1820=" + m1820 +
                ", m1830=" + m1830 +
                ", m1840=" + m1840 +
                ", m1850=" + m1850 +
                ", m1860=" + m1860 +
                '}';
    }



}
