package com.edination.api.rap.model;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "RapRequestEnquiryDetails")
public class RapRequestEnquiryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mrnNumber;
    private int enquiryId;
    private LocalDate preauthReqSentDate;

    public RapRequestEnquiryDetails() {
    }

    public RapRequestEnquiryDetails(String mrnNumber, int enquiryId, LocalDate preauthReqSentDate) {
        this.mrnNumber = mrnNumber;
        this.enquiryId = enquiryId;
        this.preauthReqSentDate = preauthReqSentDate;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEnquiryId() {
        return enquiryId;
    }

    public void setEnquiryId(int enquiryId) {
        this.enquiryId = enquiryId;
    }

    public LocalDate getPreauthReqSentDate() {
        return preauthReqSentDate;
    }
    public void setPreauthReqSentDate(LocalDate preauthReqSentDate) {
        this.preauthReqSentDate = preauthReqSentDate;
    }

    @Override
    public String toString() {
        return "RapRequestEnquiryDetails{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", enquiryId=" + enquiryId +
                ", preauthReqSentDate=" + preauthReqSentDate +
                '}';
    }
}
