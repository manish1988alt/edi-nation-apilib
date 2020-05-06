package com.edination.api.eligibility.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VerifyFlag")
public class VerifyFlag {
    @Id
    private String mrnNumber;
    private Boolean primaryflag;
    private Boolean secondaryFlag;
    private Boolean tertiaryFlag;

    public VerifyFlag(){}

    public VerifyFlag(String mrnNumber, Boolean primaryflag, Boolean secondaryFlag, Boolean tertiaryFlag) {
        this.mrnNumber = mrnNumber;
        this.primaryflag = primaryflag;
        this.secondaryFlag = secondaryFlag;
        this.tertiaryFlag = tertiaryFlag;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public Boolean getPrimaryflag() {
        return primaryflag;
    }

    public void setPrimaryflag(Boolean primaryflag) {
        this.primaryflag = primaryflag;
    }

    public Boolean getSecondaryFlag() {
        return secondaryFlag;
    }

    public void setSecondaryFlag(Boolean secondaryFlag) {
        this.secondaryFlag = secondaryFlag;
    }

    public Boolean getTertiaryFlag() {
        return tertiaryFlag;
    }

    public void setTertiaryFlag(Boolean tertiaryFlag) {
        this.tertiaryFlag = tertiaryFlag;
    }

    @Override
    public String toString() {
        return "VerifyFlag{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", primaryflag=" + primaryflag +
                ", secondaryFlag=" + secondaryFlag +
                ", tertiaryFlag=" + tertiaryFlag +
                '}';
    }
}
