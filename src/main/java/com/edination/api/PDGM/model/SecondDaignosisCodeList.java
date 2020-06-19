package com.edination.api.PDGM.model;

import java.util.List;
import java.util.Set;

public class SecondDaignosisCodeList {
    Set<SecondDiagnosisCode> secondDiagnosisCodeList;
    ComorbidityTypeAndHippsCode comorbidityTypeAndHippsCode;

    public SecondDaignosisCodeList() {
    }

    public Set<SecondDiagnosisCode> getSecondDiagnosisCodeList() {
        return secondDiagnosisCodeList;
    }

    public void setSecondDiagnosisCodeList(Set<SecondDiagnosisCode> secondDiagnosisCodeList) {
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
