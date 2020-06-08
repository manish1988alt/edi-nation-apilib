package com.edination.api.PDGM.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CalculationClinicalGroupHIPPSCode")
public class CalculationClinicalGroupHIPPSCode
{
    @Id
    private int id;
    private String   clinicalSubGroupcode;
    private int functionScore;
    private String functionalThreshold;
    private String     HIPPSCode;

    public CalculationClinicalGroupHIPPSCode() {
    }

    public CalculationClinicalGroupHIPPSCode(int id, String clinicalSubGroupcode, int functionScore, String functionalThreshold, String HIPPSCode) {
        this.id = id;
        this.clinicalSubGroupcode = clinicalSubGroupcode;
        this.functionScore = functionScore;
        this.functionalThreshold = functionalThreshold;
        this.HIPPSCode = HIPPSCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getClinicalSubGroupcode() {
        return clinicalSubGroupcode;
    }

    public void setClinicalSubGroupcode(String clinicalSubGroupcode) {
        this.clinicalSubGroupcode = clinicalSubGroupcode;
    }

    public int getFunctionScore() {
        return functionScore;
    }

    public void setFunctionScore(int functionScore) {
        this.functionScore = functionScore;
    }

    public String getFunctionalThreshold() {
        return functionalThreshold;
    }

    public void setFunctionalThreshold(String functionalThreshold) {
        this.functionalThreshold = functionalThreshold;
    }

    public String getHIPPSCode() {
        return HIPPSCode;
    }

    public void setHIPPSCode(String HIPPSCode) {
        this.HIPPSCode = HIPPSCode;
    }

    @Override
    public String toString() {
        return "CalculationClinicalGroupHIPPSCode{" +
                "id=" + id +
                ", clinicalSubGroupcode='" + clinicalSubGroupcode + '\'' +
                ", functionScore=" + functionScore +
                ", functionalThreshold=" + functionalThreshold +
                ", HIPPSCode='" + HIPPSCode + '\'' +
                '}';
    }
}
