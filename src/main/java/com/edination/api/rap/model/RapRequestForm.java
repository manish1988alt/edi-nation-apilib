package com.edination.api.rap.model;

import javax.persistence.*;
import java.time.LocalDate;
@Entity
@Table(name = "RapRequestForm")
public class RapRequestForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String PatientMrn;
    private String servicingProviderType;
    private String servicingProviderName;
    private String billingProviderType;
    private String billingProviderName;
    private String typeOfBill;
    private LocalDate statementCoveredPeriodDateFrom;
    private LocalDate statementCoveredPeriodDateTo;
    private LocalDate admissionDate;
    private String admissionHour;
    private String typeOfVisit;
    private String sourceOfReferral;
    private LocalDate dischargeDate;
    private String dischargeHour;
    private String patientDischargeStatus;
    private String accidentState;
    private LocalDate accidentDate;
    private String conditionCode1;
    private String conditionCode2;
    private String conditionCode3;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patientdetailId")
    private Patientdetail patientdetail;

    public RapRequestForm() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPatientMrn() {
        return PatientMrn;
    }

    public void setPatientMrn(String patientMrn) {
        PatientMrn = patientMrn;
    }

    public String getServicingProviderType() {
        return servicingProviderType;
    }

    public void setServicingProviderType(String servicingProviderType) {
        this.servicingProviderType = servicingProviderType;
    }

    public String getServicingProviderName() {
        return servicingProviderName;
    }

    public void setServicingProviderName(String servicingProviderName) {
        this.servicingProviderName = servicingProviderName;
    }

    public String getBillingProviderType() {
        return billingProviderType;
    }

    public void setBillingProviderType(String billingProviderType) {
        this.billingProviderType = billingProviderType;
    }

    public String getBillingProviderName() {
        return billingProviderName;
    }

    public void setBillingProviderName(String billingProviderName) {
        this.billingProviderName = billingProviderName;
    }

    public String getTypeOfBill() {
        return typeOfBill;
    }

    public void setTypeOfBill(String typeOfBill) {
        this.typeOfBill = typeOfBill;
    }

    public LocalDate getStatementCoveredPeriodDateFrom() {
        return statementCoveredPeriodDateFrom;
    }

    public void setStatementCoveredPeriodDateFrom(LocalDate statementCoveredPeriodDateFrom) {
        this.statementCoveredPeriodDateFrom = statementCoveredPeriodDateFrom;
    }

    public LocalDate getStatementCoveredPeriodDateTo() {
        return statementCoveredPeriodDateTo;
    }

    public void setStatementCoveredPeriodDateTo(LocalDate statementCoveredPeriodDateTo) {
        this.statementCoveredPeriodDateTo = statementCoveredPeriodDateTo;
    }

    public LocalDate getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalDate admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getAdmissionHour() {
        return admissionHour;
    }

    public void setAdmissionHour(String admissionHour) {
        this.admissionHour = admissionHour;
    }

    public String getTypeOfVisit() {
        return typeOfVisit;
    }

    public void setTypeOfVisit(String typeOfVisit) {
        this.typeOfVisit = typeOfVisit;
    }

    public String getSourceOfReferral() {
        return sourceOfReferral;
    }

    public void setSourceOfReferral(String sourceOfReferral) {
        this.sourceOfReferral = sourceOfReferral;
    }

    public LocalDate getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalDate dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getDischargeHour() {
        return dischargeHour;
    }

    public void setDischargeHour(String dischargeHour) {
        this.dischargeHour = dischargeHour;
    }

    public String getPatientDischargeStatus() {
        return patientDischargeStatus;
    }

    public void setPatientDischargeStatus(String patientDischargeStatus) {
        this.patientDischargeStatus = patientDischargeStatus;
    }

    public String getAccidentState() {
        return accidentState;
    }

    public void setAccidentState(String accidentState) {
        this.accidentState = accidentState;
    }

    public LocalDate getAccidentDate() {
        return accidentDate;
    }

    public void setAccidentDate(LocalDate accidentDate) {
        this.accidentDate = accidentDate;
    }

    public String getConditionCode1() {
        return conditionCode1;
    }

    public void setConditionCode1(String conditionCode1) {
        this.conditionCode1 = conditionCode1;
    }

    public String getConditionCode2() {
        return conditionCode2;
    }

    public void setConditionCode2(String conditionCode2) {
        this.conditionCode2 = conditionCode2;
    }

    public String getConditionCode3() {
        return conditionCode3;
    }

    public void setConditionCode3(String conditionCode3) {
        this.conditionCode3 = conditionCode3;
    }

    public Patientdetail getPatientdetail() {
        return patientdetail;
    }

    public void setPatientdetail(Patientdetail patientdetail) {
        this.patientdetail = patientdetail;
    }
}
