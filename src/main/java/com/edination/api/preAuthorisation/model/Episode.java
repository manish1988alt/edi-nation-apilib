package com.edination.api.preAuthorisation.model;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Episode")
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String mrnNumber;
    private String	episodeType;
    private String payorType;
    private String	preauthFormStatus;
    private Date formSentDate;
    private String	preAuthorisationStatus;
    private String admissionStatus;
    private Date admissionDate;

    public Episode() {
    }

    public Episode(String episodeType, String payorType, String preauthFormStatus, Date formSentDate, String preAuthorisationStatus, String admissionStatus,Date admissionDate) {
        this.episodeType = episodeType;
        this.payorType = payorType;
        this.preauthFormStatus = preauthFormStatus;
        this.formSentDate = formSentDate;
        this.preAuthorisationStatus = preAuthorisationStatus;
        this.admissionStatus = admissionStatus;
        this.admissionDate = admissionDate;
    }

    public String getEpisodeType() {
        return episodeType;
    }

    public void setEpisodeType(String episodeType) {
        this.episodeType = episodeType;
    }

    public String getPayorType() {
        return payorType;
    }

    public void setPayorType(String payorType) {
        this.payorType = payorType;
    }

    public String getPreauthFormStatus() {
        return preauthFormStatus;
    }

    public void setPreauthFormStatus(String preauthFormStatus) {
        this.preauthFormStatus = preauthFormStatus;
    }

    public Date getFormSentDate() {
        return formSentDate;
    }

    public void setFormSentDate(Date formSentDate) {
        this.formSentDate = formSentDate;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public String getFormStatus() {
        return preAuthorisationStatus;
    }

    public void setFormStatus(String preAuthorisationStatus) {
        this.preAuthorisationStatus = preAuthorisationStatus;
    }

    public String getAdmissionStatus() {
        return admissionStatus;
    }

    public void setAdmissionStatus(String admissionStatus) {
        this.admissionStatus = admissionStatus;
    }
    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }
    public Date getAdmissionDate() {
        return admissionDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPreAuthorisationStatus() {
        return preAuthorisationStatus;
    }

    public void setPreAuthorisationStatus(String preAuthorisationStatus) {
        this.preAuthorisationStatus = preAuthorisationStatus;
    }

    @Override
    public String toString() {
        return "Episode{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", episodeType='" + episodeType + '\'' +
                ", payorType='" + payorType + '\'' +
                ", preauthFormStatus='" + preauthFormStatus + '\'' +
                ", formSentDate=" + formSentDate +
                ", preAuthorisationStatus='" + preAuthorisationStatus + '\'' +
                ", admissionStatus='" + admissionStatus + '\'' +
                ", admissionDate=" + admissionDate +
                '}';
    }
}
