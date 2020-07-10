package com.edination.api.rap.model;

import javax.persistence.*;

@Entity
@Table(name = "TreatmentAuthorizationDetails")
public class TreatmentAuthorizationDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String TreatmentAuthorizationCode;
    private String documentControlNumber;
    private String employeeName;
    private String mrnNumber;
    public TreatmentAuthorizationDetails() {
    }

    public TreatmentAuthorizationDetails(String mrnNumber,String treatmentAuthorizationCode, String documentControlNumber, String employeeName) {
        TreatmentAuthorizationCode = treatmentAuthorizationCode;
        this.documentControlNumber = documentControlNumber;
        this.employeeName = employeeName;
        this.mrnNumber=mrnNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public String getTreatmentAuthorizationCode() {
        return TreatmentAuthorizationCode;
    }

    public void setTreatmentAuthorizationCode(String treatmentAuthorizationCode) {
        TreatmentAuthorizationCode = treatmentAuthorizationCode;
    }

    public String getDocumentControlNumber() {
        return documentControlNumber;
    }

    public void setDocumentControlNumber(String documentControlNumber) {
        this.documentControlNumber = documentControlNumber;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    @Override
    public String toString() {
        return "TreatmentAuthorizationDetails{" +
                "id=" + id +
                ", TreatmentAuthorizationCode='" + TreatmentAuthorizationCode + '\'' +
                ", documentControlNumber='" + documentControlNumber + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", mrnNumber='" + mrnNumber + '\'' +
                '}';
    }
}
