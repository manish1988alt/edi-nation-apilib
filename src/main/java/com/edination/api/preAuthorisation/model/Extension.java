package com.edination.api.preAuthorisation.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Extension")
public class Extension {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String previousAuthorizationNumber;
    private Date fromDate;
    private Date toDate;
    private boolean serviceflag;

    public Extension() {
    }

    public Extension(String previousAuthorizationNumber, Date fromDate, Date toDate, boolean serviceflag) {
        this.previousAuthorizationNumber = previousAuthorizationNumber;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.serviceflag = serviceflag;
    }

    public String getPreviousAuthorizationNumber() {
        return previousAuthorizationNumber;
    }

    public void setPreviousAuthorizationNumber(String previousAuthorizationNumber) {
        this.previousAuthorizationNumber = previousAuthorizationNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public boolean getServiceflag() {
        return serviceflag;
    }

    public void setServiceflag(boolean serviceflag) {
        this.serviceflag = serviceflag;
    }

    @Override
    public String toString() {
        return "Extension{" +
                "id=" + id +
                ", previousAuthorizationNumber='" + previousAuthorizationNumber + '\'' +
                ", fromDate=" + fromDate +
                ", toDate=" + toDate +
                ", serviceflag=" + serviceflag +
                '}';
    }
}
