package com.edination.api.PDGM.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TimingAndSourceOfAdmission")
public class TimingAndSourceOfAdmission {

    @Id
    private String mrnNumber;
    private boolean earlyVisits;
    private boolean lateVisits;
    private boolean community;
    private boolean institutional;
    private int position1Code;

    public TimingAndSourceOfAdmission() {
    }

    public TimingAndSourceOfAdmission(String mrnNumber, boolean earlyVisits, boolean lateVisits, boolean community, boolean institutional, int position1Code) {
        this.mrnNumber = mrnNumber;
        this.earlyVisits = earlyVisits;
        this.lateVisits = lateVisits;
        this.community = community;
        this.institutional = institutional;
        this.position1Code = position1Code;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public boolean isEarlyVisits() {
        return earlyVisits;
    }

    public void setEarlyVisits(boolean earlyVisits) {
        this.earlyVisits = earlyVisits;
    }

    public boolean isLateVisits() {
        return lateVisits;
    }

    public void setLateVisits(boolean lateVisits) {
        this.lateVisits = lateVisits;
    }

    public boolean isCommunity() {
        return community;
    }

    public void setCommunity(boolean community) {
        this.community = community;
    }

    public boolean isInstitutional() {
        return institutional;
    }

    public void setInstitutional(boolean institutional) {
        this.institutional = institutional;
    }

    public int getPosition1Code() {
        return position1Code;
    }

    public void setPosition1Code(int position1Code) {
        this.position1Code = position1Code;
    }

    @Override
    public String toString() {
        return "TimingAndSourceOfAdmission{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", earlyVisits=" + earlyVisits +
                ", lateVisits=" + lateVisits +
                ", community=" + community +
                ", institutional=" + institutional +
                ", position1Code=" + position1Code +
                '}';
    }
}
