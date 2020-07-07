package com.edination.api.rap.model;

import java.util.List;

public class RapRequestFormDetail {

    private String patientMrn;
    private RapRequestForm rapRequestForm;
    List<ConditionCodeDetail> conditionCodeDetailList;
    List<OccuranceAndDate> occuranceAndDateList;
    List<ValueCodeDetail> valueCodeDetailList;

    public RapRequestFormDetail() {
    }

    public RapRequestFormDetail(String patientMrn, RapRequestForm rapRequestForm, List<ConditionCodeDetail> conditionCodeDetailList, List<OccuranceAndDate> occuranceAndDateList, List<ValueCodeDetail> valueCodeDetailList) {
        this.patientMrn = patientMrn;
        this.rapRequestForm = rapRequestForm;
        this.conditionCodeDetailList = conditionCodeDetailList;
        this.occuranceAndDateList = occuranceAndDateList;
        this.valueCodeDetailList = valueCodeDetailList;
    }

    public String getPatientMrn() {
        return patientMrn;
    }

    public void setPatientMrn(String patientMrn) {
        this.patientMrn = patientMrn;
    }

    public RapRequestForm getRapRequestForm() {
        return rapRequestForm;
    }

    public void setRapRequestForm(RapRequestForm rapRequestForm) {
        this.rapRequestForm = rapRequestForm;
    }

    public List<ConditionCodeDetail> getConditionCodeDetailList() {
        return conditionCodeDetailList;
    }

    public void setConditionCodeDetailList(List<ConditionCodeDetail> conditionCodeDetailList) {
        this.conditionCodeDetailList = conditionCodeDetailList;
    }

    public List<OccuranceAndDate> getOccuranceAndDateList() {
        return occuranceAndDateList;
    }

    public void setOccuranceAndDateList(List<OccuranceAndDate> occuranceAndDateList) {
        this.occuranceAndDateList = occuranceAndDateList;
    }

    public List<ValueCodeDetail> getValueCodeDetailList() {
        return valueCodeDetailList;
    }

    public void setValueCodeDetailList(List<ValueCodeDetail> valueCodeDetailList) {
        this.valueCodeDetailList = valueCodeDetailList;
    }

    @Override
    public String toString() {
        return "RapRequestFormDetail{" +
                "patientMrn='" + patientMrn + '\'' +
                ", rapRequestForm=" + rapRequestForm +
                ", conditionCodeDetailList=" + conditionCodeDetailList +
                ", occuranceAndDateList=" + occuranceAndDateList +
                ", valueCodeDetailList=" + valueCodeDetailList +
                '}';
    }
}
