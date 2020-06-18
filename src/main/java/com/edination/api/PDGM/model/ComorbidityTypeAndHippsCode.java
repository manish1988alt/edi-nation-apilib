package com.edination.api.PDGM.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ComorbidityTypeAndHippsCode")
public class ComorbidityTypeAndHippsCode {
    @Id
    private String mrnNumber;
    private String comorbidityType;
    private String hippsCode;

    public ComorbidityTypeAndHippsCode() {
    }

    public ComorbidityTypeAndHippsCode(String mrnNumber, String comorbidityType, String hippsCode) {
        this.mrnNumber = mrnNumber;
        this.comorbidityType = comorbidityType;
        this.hippsCode = hippsCode;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public String getComorbidityType() {
        return comorbidityType;
    }

    public void setComorbidityType(String comorbidityType) {
        this.comorbidityType = comorbidityType;
    }

    public String getHippsCode() {
        return hippsCode;
    }

    public void setHippsCode(String hippsCode) {
        this.hippsCode = hippsCode;
    }

    @Override
    public String toString() {
        return "ComorbidityTypeAndHippsCode{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", comorbidityType='" + comorbidityType + '\'' +
                ", hippsCode='" + hippsCode + '\'' +
                '}';
    }
}
