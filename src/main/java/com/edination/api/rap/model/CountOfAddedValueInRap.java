package com.edination.api.rap.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CountOfAddedValueInRap")
public class CountOfAddedValueInRap {
    @Id
    private String mrnNumber;
    private int conditionCodeCount;
    private int occuranceCodeCount;
    private int valueCodeCount;
    private int otherProviderCount;
    private int treatmentAuthorizationCount;

    public CountOfAddedValueInRap() {
    }

    public CountOfAddedValueInRap(String mrnNumber, int conditionCodeCount, int occuranceCodeCount, int valueCodeCount, int otherProviderCount, int treatmentAuthorizationCount) {
        this.mrnNumber = mrnNumber;
        this.conditionCodeCount = conditionCodeCount;
        this.occuranceCodeCount = occuranceCodeCount;
        this.valueCodeCount = valueCodeCount;
        this.otherProviderCount = otherProviderCount;
        this.treatmentAuthorizationCount = treatmentAuthorizationCount;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public int getConditionCodeCount() {
        return conditionCodeCount;
    }

    public void setConditionCodeCount(int conditionCodeCount) {
        this.conditionCodeCount = conditionCodeCount;
    }

    public int getOccuranceCodeCount() {
        return occuranceCodeCount;
    }

    public void setOccuranceCodeCount(int occuranceCodeCount) {
        this.occuranceCodeCount = occuranceCodeCount;
    }

    public int getValueCodeCount() {
        return valueCodeCount;
    }

    public void setValueCodeCount(int valueCodeCount) {
        this.valueCodeCount = valueCodeCount;
    }

    public int getOtherProviderCount() {
        return otherProviderCount;
    }

    public void setOtherProviderCount(int otherProviderCount) {
        this.otherProviderCount = otherProviderCount;
    }

    public int getTreatmentAuthorizationCount() {
        return treatmentAuthorizationCount;
    }

    public void setTreatmentAuthorizationCount(int treatmentAuthorizationCount) {
        this.treatmentAuthorizationCount = treatmentAuthorizationCount;
    }

    @Override
    public String toString() {
        return "CountOfAddedValueInRap{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", conditionCodeCount=" + conditionCodeCount +
                ", occuranceCodeCount=" + occuranceCodeCount +
                ", valueCodeCount=" + valueCodeCount +
                ", otherProviderCount=" + otherProviderCount +
                ", treatmentAuthorizationCount=" + treatmentAuthorizationCount +
                '}';
    }
}
