package com.edination.api.PDGM.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HighComorbidityCondition")
public class HighComorbidityCondition {

    @Id
    private int id;
    private String primaryComorbiditySubgroup;
    private String validPrimaryComorbidity;
    private String secondaryComorbiditySubgroup;
    private String validSecondaryComorbidity;
    private String interaction;
    private String comorbidityAdjustmentLevel;
    private String hippsCode;

    public HighComorbidityCondition() {
    }

    public HighComorbidityCondition(String primaryComorbiditySubgroup, String validPrimaryComorbidity, String secondaryComorbiditySubgroup, String validSecondaryComorbidity, String interaction, String comorbidityAdjustmentLevel, String hippsCode) {
        this.primaryComorbiditySubgroup = primaryComorbiditySubgroup;
        this.validPrimaryComorbidity = validPrimaryComorbidity;
        this.secondaryComorbiditySubgroup = secondaryComorbiditySubgroup;
        this.validSecondaryComorbidity = validSecondaryComorbidity;
        this.interaction = interaction;
        this.comorbidityAdjustmentLevel = comorbidityAdjustmentLevel;
        this.hippsCode = hippsCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimaryComorbiditySubgroup() {
        return primaryComorbiditySubgroup;
    }

    public void setPrimaryComorbiditySubgroup(String primaryComorbiditySubgroup) {
        this.primaryComorbiditySubgroup = primaryComorbiditySubgroup;
    }

    public String getValidPrimaryComorbidity() {
        return validPrimaryComorbidity;
    }

    public void setValidPrimaryComorbidity(String validPrimaryComorbidity) {
        this.validPrimaryComorbidity = validPrimaryComorbidity;
    }

    public String getSecondaryComorbiditySubgroup() {
        return secondaryComorbiditySubgroup;
    }

    public void setSecondaryComorbiditySubgroup(String secondaryComorbiditySubgroup) {
        this.secondaryComorbiditySubgroup = secondaryComorbiditySubgroup;
    }

    public String getValidSecondaryComorbidity() {
        return validSecondaryComorbidity;
    }

    public void setValidSecondaryComorbidity(String validSecondaryComorbidity) {
        this.validSecondaryComorbidity = validSecondaryComorbidity;
    }

    public String getInteraction() {
        return interaction;
    }

    public void setInteraction(String interaction) {
        this.interaction = interaction;
    }

    public String getComorbidityAdjustmentLevel() {
        return comorbidityAdjustmentLevel;
    }

    public void setComorbidityAdjustmentLevel(String comorbidityAdjustmentLevel) {
        this.comorbidityAdjustmentLevel = comorbidityAdjustmentLevel;
    }

    public String getHippsCode() {
        return hippsCode;
    }

    public void setHippsCode(String hippsCode) {
        this.hippsCode = hippsCode;
    }

    @Override
    public String toString() {
        return "HighComorbidityCondition{" +
                "id=" + id +
                ", primaryComorbiditySubgroup='" + primaryComorbiditySubgroup + '\'' +
                ", validPrimaryComorbidity='" + validPrimaryComorbidity + '\'' +
                ", secondaryComorbiditySubgroup='" + secondaryComorbiditySubgroup + '\'' +
                ", validSecondaryComorbidity='" + validSecondaryComorbidity + '\'' +
                ", interaction='" + interaction + '\'' +
                ", comorbidityAdjustmentLevel='" + comorbidityAdjustmentLevel + '\'' +
                ", hippsCode='" + hippsCode + '\'' +
                '}';
    }
}
