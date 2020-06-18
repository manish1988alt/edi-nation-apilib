package com.edination.api.PDGM.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LowComorbidityCondtion")
public class LowComorbidityCondition {

    @Id
    private int id;
    private String primaryComorbiditySubgroup;
    private String validPrimaryComorbidity;
    private String interaction;
    private String comorbidityAdjustmentLevel;
    private String hippsCode;

    public LowComorbidityCondition() {
    }

    public LowComorbidityCondition(String primaryComorbiditySubgroup, String validPrimaryComorbidity, String interaction, String comorbidityAdjustmentLevel, String hippsCode) {
        this.primaryComorbiditySubgroup = primaryComorbiditySubgroup;
        this.validPrimaryComorbidity = validPrimaryComorbidity;
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
        return "LowComorbidityCondtion{" +
                "id=" + id +
                ", primaryComorbiditySubgroup='" + primaryComorbiditySubgroup + '\'' +
                ", validPrimaryComorbidity='" + validPrimaryComorbidity + '\'' +
                ", interaction='" + interaction + '\'' +
                ", comorbidityAdjustmentLevel='" + comorbidityAdjustmentLevel + '\'' +
                ", hippsCode='" + hippsCode + '\'' +
                '}';
    }
}
