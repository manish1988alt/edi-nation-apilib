package com.edination.api.preAuthorisation.model;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "AdditionalServices")
public class AdditionalServices {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String previousAuthorizationNumber;
    private int numberOfServiceCompletedTillDate;
    private Date fromDate;
    private Date toDate;
    private boolean serviceflag;

    public AdditionalServices() {
    }

    public AdditionalServices(String previousAuthorizationNumber, int numberOfServiceCompletedTillDate, Date fromDate, Date toDate, boolean serviceflag) {
        this.previousAuthorizationNumber = previousAuthorizationNumber;
        this.numberOfServiceCompletedTillDate = numberOfServiceCompletedTillDate;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.serviceflag = serviceflag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPreviousAuthorizationNumber() {
        return previousAuthorizationNumber;
    }

    public void setPreviousAuthorizationNumber(String previousAuthorizationNumber) {
        this.previousAuthorizationNumber = previousAuthorizationNumber;
    }

    public int getNumberOfServiceCompletedTillDate() {
        return numberOfServiceCompletedTillDate;
    }

    public void setNumberOfServiceCompletedTillDate(int numberOfServiceCompletedTillDate) {
        this.numberOfServiceCompletedTillDate = numberOfServiceCompletedTillDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public boolean isServiceflag() {
        return serviceflag;
    }

    public void setServiceflag(boolean serviceflag) {
        this.serviceflag = serviceflag;
    }

    @Override
    public String toString() {
        return "AdditionalServices{" +
                "id=" + id +
                ", previousAuthorizationNumber='" + previousAuthorizationNumber + '\'' +
                ", numberOfServiceCompletedTillDate=" + numberOfServiceCompletedTillDate +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", serviceflag=" + serviceflag +
                '}';
    }
}
