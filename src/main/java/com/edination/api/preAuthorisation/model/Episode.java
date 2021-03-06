package com.edination.api.preAuthorisation.model;
import javax.persistence.*;
import java.time.LocalDate;
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
    private LocalDate formSentDate;
    private String	preAuthorisationStatus;
    private String admissionStatus;
    private Date admissionDate;
    private Date formReceivedDate;

    public Episode() {
    }

    public Episode(String mrnNumber, String episodeType, String payorType, String preauthFormStatus, LocalDate formSentDate, String preAuthorisationStatus, String admissionStatus, Date admissionDate, Date formReceivedDate) {
        this.mrnNumber = mrnNumber;
        this.episodeType = episodeType;
        this.payorType = payorType;
        this.preauthFormStatus = preauthFormStatus;
        this.formSentDate = formSentDate;
        this.preAuthorisationStatus = preAuthorisationStatus;
        this.admissionStatus = admissionStatus;
        this.admissionDate = admissionDate;
        this.formReceivedDate = formReceivedDate;
    }

    public Date getFormReceivedDate() {
        return formReceivedDate;
    }

    public void setFormReceivedDate(Date formReceivedDate) {
        this.formReceivedDate = formReceivedDate;
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

    public LocalDate getFormSentDate() {
        return formSentDate;
    }

    public void setFormSentDate(LocalDate formSentDate) {
        this.formSentDate = formSentDate;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
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
                ", formReceivedDate=" + formReceivedDate +
                '}';
    }
}
