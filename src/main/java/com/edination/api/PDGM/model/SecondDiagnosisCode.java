package com.edination.api.PDGM.model;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name="SecondDiagnosisCode")
public class SecondDiagnosisCode {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String iCDQualifier;
    private String secondDiagnosisCode;
    private String discription;
    private String clinicalGroup;
    private String comorbiditySubGroup;
    private String mrnNumber;

    public SecondDiagnosisCode() {
    }

    public SecondDiagnosisCode(String secondDiagnosisCode, String discription, String clinicalGroup, String comorbiditySubGroup, String mrnNumber,String iCDQualifier) {
        this.secondDiagnosisCode = secondDiagnosisCode;
        this.discription = discription;
        this.clinicalGroup = clinicalGroup;
        this.comorbiditySubGroup = comorbiditySubGroup;
        this.mrnNumber = mrnNumber;
        this.iCDQualifier=iCDQualifier;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getiCDQualifier() {
        return iCDQualifier;
    }

    public void setiCDQualifier(String iCDQualifier) {
        this.iCDQualifier = iCDQualifier;
    }

    public String getSecondDiagnosisCode() {
        return secondDiagnosisCode;
    }

    public void setSecondDiagnosisCode(String secondDiagnosisCode) {
        this.secondDiagnosisCode = secondDiagnosisCode;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getClinicalGroup() {
        return clinicalGroup;
    }

    public void setClinicalGroup(String clinicalGroup) {
        this.clinicalGroup = clinicalGroup;
    }

    public String getComorbiditySubGroup() {
        return comorbiditySubGroup;
    }

    public void setComorbiditySubGroup(String comorbiditySubGroup) {
        this.comorbiditySubGroup = comorbiditySubGroup;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    @Override
    public String toString() {
        return "SecondDiagnosisCode{" +
                "id=" + id +
                ", iCDQualifier='" + iCDQualifier + '\'' +
                ", secondDiagnosisCode='" + secondDiagnosisCode + '\'' +
                ", discription='" + discription + '\'' +
                ", clinicalGroup='" + clinicalGroup + '\'' +
                ", comorbiditySubGroup='" + comorbiditySubGroup + '\'' +
                ", mrnNumber='" + mrnNumber + '\'' +
                '}';
    }
}
