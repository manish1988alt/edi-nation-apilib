package com.edination.api.preAuthorisation.model;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AdmissionDetail")
public class AdmissionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String mrnNumber;
    private String	requestType;
	private Date admissionDate;
    private Date	dischargeDate;
    private String	referringPhysician;
    private String	primaryDiagnosis;
    private String	primaryDiagnosisDescription;


    public AdmissionDetail(){}

    public AdmissionDetail(String mrnNumber, String requestType, Date admissionDate, Date dischargeDate, String referringPhysician, String primaryDiagnosis, String primaryDiagnosisDescription) {
        this.mrnNumber = mrnNumber;
        this.requestType = requestType;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.referringPhysician = referringPhysician;
        this.primaryDiagnosis = primaryDiagnosis;
        this.primaryDiagnosisDescription = primaryDiagnosisDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
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

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    @Override
    public String toString() {
        return "AdmissionDetail{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", requestType='" + requestType + '\'' +
                ", admissionDate=" + admissionDate +
                ", dischargeDate=" + dischargeDate +
                ", referringPhysician='" + referringPhysician + '\'' +
                ", primaryDiagnosis='" + primaryDiagnosis + '\'' +
                ", primaryDiagnosisDescription='" + primaryDiagnosisDescription + '\'' +
                '}';
    }
}
