package com.edination.api.rap.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "OccuranceAndDate")
public class OccuranceAndDate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String code1;
    private LocalDate dateFrom1;
    private LocalDate dateThrough1;
    private String code2;
    private LocalDate dateFrom2;
    private LocalDate dateThrough2;
    private String code3;
    private LocalDate dateFrom3;
    private LocalDate dateThrough3;

    public OccuranceAndDate() {
    }

    public OccuranceAndDate(String code1, LocalDate dateFrom1, LocalDate dateThrough1, String code2, LocalDate dateFrom2, LocalDate dateThrough2, String code3, LocalDate dateFrom3, LocalDate dateThrough3) {
        this.code1 = code1;
        this.dateFrom1 = dateFrom1;
        this.dateThrough1 = dateThrough1;
        this.code2 = code2;
        this.dateFrom2 = dateFrom2;
        this.dateThrough2 = dateThrough2;
        this.code3 = code3;
        this.dateFrom3 = dateFrom3;
        this.dateThrough3 = dateThrough3;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode1() {
        return code1;
    }

    public void setCode1(String code1) {
        this.code1 = code1;
    }

    public LocalDate getDateFrom1() {
        return dateFrom1;
    }

    public void setDateFrom1(LocalDate dateFrom1) {
        this.dateFrom1 = dateFrom1;
    }

    public LocalDate getDateThrough1() {
        return dateThrough1;
    }

    public void setDateThrough1(LocalDate dateThrough1) {
        this.dateThrough1 = dateThrough1;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public LocalDate getDateFrom2() {
        return dateFrom2;
    }

    public void setDateFrom2(LocalDate dateFrom2) {
        this.dateFrom2 = dateFrom2;
    }

    public LocalDate getDateThrough2() {
        return dateThrough2;
    }

    public void setDateThrough2(LocalDate dateThrough2) {
        this.dateThrough2 = dateThrough2;
    }

    public String getCode3() {
        return code3;
    }

    public void setCode3(String code3) {
        this.code3 = code3;
    }

    public LocalDate getDateFrom3() {
        return dateFrom3;
    }

    public void setDateFrom3(LocalDate dateFrom3) {
        this.dateFrom3 = dateFrom3;
    }

    public LocalDate getDateThrough3() {
        return dateThrough3;
    }

    public void setDateThrough3(LocalDate dateThrough3) {
        this.dateThrough3 = dateThrough3;
    }

    @Override
    public String toString() {
        return "OccuranceAndDate{" +
                "id=" + id +
                ", code1='" + code1 + '\'' +
                ", dateFrom1=" + dateFrom1 +
                ", dateThrough1=" + dateThrough1 +
                ", code2='" + code2 + '\'' +
                ", dateFrom2=" + dateFrom2 +
                ", dateThrough2=" + dateThrough2 +
                ", code3='" + code3 + '\'' +
                ", dateFrom3=" + dateFrom3 +
                ", dateThrough3=" + dateThrough3 +
                '}';
    }
}
