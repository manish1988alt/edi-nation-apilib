package com.edination.api.PDGM.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ClinicalGroupingPrimaryDiagnosis")
public class ClinicalGroupingPrimaryDiagnosis {
    @Id
    private String primaryDiagnosisCode;
    private String discription;
    private String clinicalGroup;
    private String comorbiditySubGroup;
    private String  secondPositionHIPPSCode;

    public ClinicalGroupingPrimaryDiagnosis() {
    }

    public ClinicalGroupingPrimaryDiagnosis(String primaryDiagnosisCode, String discription, String clinicalGroup, String comorbiditySubGroup, String secondPositionHIPPSCode) {
        this.primaryDiagnosisCode = primaryDiagnosisCode;
        this.discription = discription;
        this.clinicalGroup = clinicalGroup;
        this.comorbiditySubGroup = comorbiditySubGroup;
        this.secondPositionHIPPSCode = secondPositionHIPPSCode;
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

    public String getSecondPositionHIPPSCode() {
        return secondPositionHIPPSCode;
    }

    public void setSecondPositionHIPPSCode(String secondPositionHIPPSCode) {
        this.secondPositionHIPPSCode = secondPositionHIPPSCode;
    }

    @Override
    public String toString() {
        return "ClinicalGroupingPrimaryDiagnosis{" +
                "primaryDiagnosisCode='" + primaryDiagnosisCode + '\'' +
                ", discription='" + discription + '\'' +
                ", clinicalGroup='" + clinicalGroup + '\'' +
                ", comorbiditySubGroup='" + comorbiditySubGroup + '\'' +
                ", secondPositionHIPPSCode='" + secondPositionHIPPSCode + '\'' +
                '}';
    }
}
