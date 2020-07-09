package com.edination.api.rap.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PrimaryDiagnosisCode")
public class PrimaryDiagnosisCode {
    @Id
    private String mrnNumber;
    private String primaryDiagnosisCode;
    private String discription;
    private String iCDQualifier;

    public PrimaryDiagnosisCode() {
    }

    public PrimaryDiagnosisCode(String mrnNumber, String primaryDiagnosisCode, String discription, String iCDQualifier) {
        this.mrnNumber = mrnNumber;
        this.primaryDiagnosisCode = primaryDiagnosisCode;
        this.discription = discription;
        this.iCDQualifier = iCDQualifier;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public String getPrimaryDiagnosisCode() {
        return primaryDiagnosisCode;
    }

    public void setPrimaryDiagnosisCode(String primaryDiagnosisCode) {
        this.primaryDiagnosisCode = primaryDiagnosisCode;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getiCDQualifier() {
        return iCDQualifier;
    }

    public void setiCDQualifier(String iCDQualifier) {
        this.iCDQualifier = iCDQualifier;
    }

    @Override
    public String toString() {
        return "PrimaryDiagnosisCode{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", primaryDiagnosisCode='" + primaryDiagnosisCode + '\'' +
                ", discription='" + discription + '\'' +
                ", iCDQualifier='" + iCDQualifier + '\'' +
                '}';
    }
}
