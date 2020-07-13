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
    private String attendingProviderName;
    private String remarks;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patientdetailId")
    private Patientdetail patientDetail;

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "treatmentAuthorizationId")
    private TreatmentAuthorizationDetails treatmentAuthorizationDetails;*/

    public RapRequestForm() {
    }

    public RapRequestForm(String patientMrn, String servicingProviderType, String servicingProviderName, String billingProviderType, String billingProviderName, String typeOfBill, LocalDate statementCoveredPeriodDateFrom, LocalDate statementCoveredPeriodDateTo, LocalDate admissionDate, String admissionHour, String typeOfVisit, String sourceOfReferral, LocalDate dischargeDate, String dischargeHour, String patientDischargeStatus, String accidentState, LocalDate accidentDate,String attendingProviderName,String remarks) {
        PatientMrn = patientMrn;
        this.servicingProviderType = servicingProviderType;
        this.servicingProviderName = servicingProviderName;
        this.billingProviderType = billingProviderType;
        this.billingProviderName = billingProviderName;
        this.typeOfBill = typeOfBill;
        this.statementCoveredPeriodDateFrom = statementCoveredPeriodDateFrom;
        this.statementCoveredPeriodDateTo = statementCoveredPeriodDateTo;
        this.admissionDate = admissionDate;
        this.admissionHour = admissionHour;
        this.typeOfVisit = typeOfVisit;
        this.sourceOfReferral = sourceOfReferral;
        this.dischargeDate = dischargeDate;
        this.dischargeHour = dischargeHour;
        this.patientDischargeStatus = patientDischargeStatus;
        this.accidentState = accidentState;
        this.accidentDate = accidentDate;
        this.attendingProviderName=attendingProviderName;
        this.remarks=remarks;
    }
  /*  public TreatmentAuthorizationDetails getTreatmentAuthorizationDetails() {
        return treatmentAuthorizationDetails;
    }

    public void setTreatmentAuthorizationDetails(TreatmentAuthorizationDetails treatmentAuthorizationDetails) {
        this.treatmentAuthorizationDetails = treatmentAuthorizationDetails;
    }*/

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

    public String getAttendingProviderName() {
        return attendingProviderName;
    }

    public void setAttendingProviderName(String attendingProviderName) {
        this.attendingProviderName = attendingProviderName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Patientdetail getPatientDetail() {
        return patientDetail;
    }

    public void setPatientDetail(Patientdetail patientDetail) {
        this.patientDetail = patientDetail;
    }

    @Override
    public String toString() {
        return "RapRequestForm{" +
                "id=" + id +
                ", PatientMrn='" + PatientMrn + '\'' +
                ", servicingProviderType='" + servicingProviderType + '\'' +
                ", servicingProviderName='" + servicingProviderName + '\'' +
                ", billingProviderType='" + billingProviderType + '\'' +
                ", billingProviderName='" + billingProviderName + '\'' +
                ", typeOfBill='" + typeOfBill + '\'' +
                ", statementCoveredPeriodDateFrom=" + statementCoveredPeriodDateFrom +
                ", statementCoveredPeriodDateTo=" + statementCoveredPeriodDateTo +
                ", admissionDate=" + admissionDate +
                ", admissionHour='" + admissionHour + '\'' +
                ", typeOfVisit='" + typeOfVisit + '\'' +
                ", sourceOfReferral='" + sourceOfReferral + '\'' +
                ", dischargeDate=" + dischargeDate +
                ", dischargeHour='" + dischargeHour + '\'' +
                ", patientDischargeStatus='" + patientDischargeStatus + '\'' +
                ", accidentState='" + accidentState + '\'' +
                ", accidentDate=" + accidentDate +
                ", attendingProviderName='" + attendingProviderName + '\'' +
                ", remarks='" + remarks + '\'' +
                ", patientDetail=" + patientDetail +
                '}';
    }
}
