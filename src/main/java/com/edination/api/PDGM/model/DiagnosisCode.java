package com.edination.api.PDGM.model;

import java.util.List;

public class DiagnosisCode {

    private String mrnNumber;
    private String primaryDiagnosisCode;
    private List<String> secondaryDiagnosisCode;

    public DiagnosisCode() {
    }

    public DiagnosisCode(String mrnNumber, String primaryDiagnosisCode, List<String> secondaryDiagnosisCode) {
        this.mrnNumber = mrnNumber;
        this.primaryDiagnosisCode = primaryDiagnosisCode;
        this.secondaryDiagnosisCode = secondaryDiagnosisCode;
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

    public List<String> getSecondaryDiagnosisCode() {
        return secondaryDiagnosisCode;
    }

    public void setSecondaryDiagnosisCode(List<String> secondaryDiagnosisCode) {
        this.secondaryDiagnosisCode = secondaryDiagnosisCode;
    }

    @Override
    public String toString() {
        return "DiagnosisCode{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", primaryDiagnosisCode='" + primaryDiagnosisCode + '\'' +
                ", secondaryDiagnosisCode=" + secondaryDiagnosisCode +
                '}';
    }
}
