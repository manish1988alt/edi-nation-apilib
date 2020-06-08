package com.edination.api.preAuthorisation.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "EnquiryDeatils")
public class EnquiryDeatils {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mrnNumber;
    private int enquiryId;
    private Date preauthReqSentDate;

    public EnquiryDeatils() {
    }

    public EnquiryDeatils(String mrnNumber, int enquiryId, Date preauthReqSentDate) {
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

    public Date getPreauthReqSentDate() {
        return preauthReqSentDate;
    }

    public void setPreauthReqSentDate(Date preauthReqSentDate) {
        this.preauthReqSentDate = preauthReqSentDate;
    }
    @Override
    public String toString() {
        return "EnquiryDeatils{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", enquiryId=" + enquiryId +
                ", preauthReqSentDate=" + preauthReqSentDate +
                '}';
    }
}
