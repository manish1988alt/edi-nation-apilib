package com.edination.api.rap.model;

import com.edination.api.PDGM.model.SecondDiagnosisCode;

import java.util.List;

public class RapRequestFormDetail {

    private String patientMrn;
    private RapRequestForm rapRequestForm;
    List<ConditionCodeDetail> conditionCodeDetailList;
    List<OccuranceAndDate> occuranceAndDateList;
    List<ValueCodeDetail> valueCodeDetailList;
    List<BillingDetails> billingDetailsList;
    PayerDetails payerDetails;
    InsuredDetails insuredDetails;
    PrimaryDiagnosisCode primaryDiagnosisCode;
    List<SecondDiagnosisCode> secondDiagnosisCodeList;
    List<OtherProviderDetail> otherProviderDetails;
    RapRequestEnquiryDetails rapRequestEnquiryDetails;
    public RapRequestFormDetail() {
    }

    public RapRequestFormDetail(String patientMrn, RapRequestForm rapRequestForm, List<ConditionCodeDetail> conditionCodeDetailList, List<OccuranceAndDate> occuranceAndDateList, List<ValueCodeDetail> valueCodeDetailList) {
        this.patientMrn = patientMrn;
        this.rapRequestForm = rapRequestForm;
        this.conditionCodeDetailList = conditionCodeDetailList;
        this.occuranceAndDateList = occuranceAndDateList;
        this.valueCodeDetailList = valueCodeDetailList;
    }

    public RapRequestEnquiryDetails getRapRequestEnquiryDetails() {
        return rapRequestEnquiryDetails;
    }

    public void setRapRequestEnquiryDetails(RapRequestEnquiryDetails rapRequestEnquiryDetails) {
        this.rapRequestEnquiryDetails = rapRequestEnquiryDetails;
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

    public List<BillingDetails> getBillingDetailsList() {
        return billingDetailsList;
    }

    public void setBillingDetailsList(List<BillingDetails> billingDetailsList) {
        this.billingDetailsList = billingDetailsList;
    }

    public PayerDetails getPayerDetails() {
        return payerDetails;
    }

    public void setPayerDetails(PayerDetails payerDetails) {
        this.payerDetails = payerDetails;
    }

    public InsuredDetails getInsuredDetails() {
        return insuredDetails;
    }

    public void setInsuredDetails(InsuredDetails insuredDetails) {
        this.insuredDetails = insuredDetails;
    }

    public PrimaryDiagnosisCode getPrimaryDiagnosisCode() {
        return primaryDiagnosisCode;
    }

    public void setPrimaryDiagnosisCode(PrimaryDiagnosisCode primaryDiagnosisCode) {
        this.primaryDiagnosisCode = primaryDiagnosisCode;
    }

    public List<SecondDiagnosisCode> getSecondDiagnosisCodeList() {
        return secondDiagnosisCodeList;
    }

    public void setSecondDiagnosisCodeList(List<SecondDiagnosisCode> secondDiagnosisCodeList) {
        this.secondDiagnosisCodeList = secondDiagnosisCodeList;
    }

    public List<OtherProviderDetail> getOtherProviderDetails() {
        return otherProviderDetails;
    }

    public void setOtherProviderDetails(List<OtherProviderDetail> otherProviderDetails) {
        this.otherProviderDetails = otherProviderDetails;
    }

    @Override
    public String toString() {
        return "RapRequestFormDetail{" +
                "patientMrn='" + patientMrn + '\'' +
                ", rapRequestForm=" + rapRequestForm +
                ", conditionCodeDetailList=" + conditionCodeDetailList +
                ", occuranceAndDateList=" + occuranceAndDateList +
                ", valueCodeDetailList=" + valueCodeDetailList +
                ", billingDetailsList=" + billingDetailsList +
                ", payerDetails=" + payerDetails +
                ", insuredDetails=" + insuredDetails +
                ", primaryDiagnosisCode=" + primaryDiagnosisCode +
                ", secondDiagnosisCodeList=" + secondDiagnosisCodeList +
                ", otherProviderDetails=" + otherProviderDetails +
                ", rapRequestEnquiryDetails=" + rapRequestEnquiryDetails +
                '}';
    }
}
