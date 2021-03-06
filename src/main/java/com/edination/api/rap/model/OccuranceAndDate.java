package com.edination.api.rap.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "OccuranceAndDate")
public class OccuranceAndDate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String code;
    private LocalDate dateFrom;
    private LocalDate dateThrough;
    private String mrnNumber;


    public OccuranceAndDate() {
    }

    public OccuranceAndDate(String code, LocalDate dateFrom, LocalDate dateThrough,String mrnNumber) {
        this.code = code;
        this.dateFrom = dateFrom;
        this.dateThrough = dateThrough;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public LocalDate getDateThrough() {
        return dateThrough;
    }

    public void setDateThrough(LocalDate dateThrough) {
        this.dateThrough = dateThrough;
    }

    @Override
    public String toString() {
        return "OccuranceAndDate{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", dateFrom=" + dateFrom +
                ", dateThrough=" + dateThrough +
                ", mrnNumber='" + mrnNumber + '\'' +
                '}';
    }
}
