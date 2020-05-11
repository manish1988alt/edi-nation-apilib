package com.edination.api.preAuthorisation.model;

import sun.util.calendar.LocalGregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.Table;


public class AdmissionDetail {

    private String	requestType;
	private LocalGregorianCalendar.Date admissionDate;
    private LocalGregorianCalendar.Date	dischargeDate;
    private String	referringPhysician;
    private String	primaryDiagnosis;
    private String	primaryDiagnosisDescription;
    private String admissionStatus;

    public AdmissionDetail(){}

    public AdmissionDetail(String requestType, LocalGregorianCalendar.Date admissionDate, LocalGregorianCalendar.Date dischargeDate, String referringPhysician, String primaryDiagnosis, String primaryDiagnosisDescription, String admissionStatus) {
        this.requestType = requestType;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.referringPhysician = referringPhysician;
        this.primaryDiagnosis = primaryDiagnosis;
        this.primaryDiagnosisDescription = primaryDiagnosisDescription;
        this.admissionStatus = admissionStatus;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public LocalGregorianCalendar.Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(LocalGregorianCalendar.Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public LocalGregorianCalendar.Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(LocalGregorianCalendar.Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getReferringPhysician() {
        return referringPhysician;
    }

    public void setReferringPhysician(String referringPhysician) {
        this.referringPhysician = referringPhysician;
    }

    public String getPrimaryDiagnosis() {
        return primaryDiagnosis;
    }

    public void setPrimaryDiagnosis(String primaryDiagnosis) {
        this.primaryDiagnosis = primaryDiagnosis;
    }

    public String getPrimaryDiagnosisDescription() {
        return primaryDiagnosisDescription;
    }

    public void setPrimaryDiagnosisDescription(String primaryDiagnosisDescription) {
        this.primaryDiagnosisDescription = primaryDiagnosisDescription;
    }

    public String getAdmissionStatus() {
        return admissionStatus;
    }

    public void setAdmissionStatus(String admissionStatus) {
        this.admissionStatus = admissionStatus;
    }

    @Override
    public String toString() {
        return "AdmissionDetail{" +
                "requestType='" + requestType + '\'' +
                ", admissionDate=" + admissionDate +
                ", dischargeDate=" + dischargeDate +
                ", referringPhysician='" + referringPhysician + '\'' +
                ", primaryDiagnosis='" + primaryDiagnosis + '\'' +
                ", primaryDiagnosisDescription='" + primaryDiagnosisDescription + '\'' +
                ", admissionStatus='" + admissionStatus + '\'' +
                '}';
    }
}
