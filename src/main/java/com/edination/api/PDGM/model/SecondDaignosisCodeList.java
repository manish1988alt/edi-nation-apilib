package com.edination.api.PDGM.model;

import java.util.List;

public class SecondDaignosisCodeList {
    List<SecondDiagnosisCode> secondDiagnosisCodeList;
    ComorbidityTypeAndHippsCode comorbidityTypeAndHippsCode;

    public SecondDaignosisCodeList() {
    }

    public List<SecondDiagnosisCode> getSecondDiagnosisCodeList() {
        return secondDiagnosisCodeList;
    }

    public void setSecondDiagnosisCodeList(List<SecondDiagnosisCode> secondDiagnosisCodeList) {
        this.secondDiagnosisCodeList = secondDiagnosisCodeList;
    }

    public ComorbidityTypeAndHippsCode getComorbidityTypeAndHippsCode() {
        return comorbidityTypeAndHippsCode;
    }

    public void setComorbidityTypeAndHippsCode(ComorbidityTypeAndHippsCode comorbidityTypeAndHippsCode) {
        this.comorbidityTypeAndHippsCode = comorbidityTypeAndHippsCode;
    }

    @Override
    public String toString() {
        return "SecondDaignosisCodeList{" +
                "secondDiagnosisCodeList=" + secondDiagnosisCodeList +
                ", comorbidityTypeAndHippsCode=" + comorbidityTypeAndHippsCode +
                '}';
    }
}
