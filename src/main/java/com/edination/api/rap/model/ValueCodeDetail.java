package com.edination.api.rap.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ValueCodeDetail")
public class ValueCodeDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String code1;
    private double amount1;
    private String code2;
    private double amount2;
    private String code3;
    private double amount3;

    public ValueCodeDetail() {
    }

    public ValueCodeDetail(String code1, double amount1, String code2, double amount2, String code3, double amount3) {
        this.code1 = code1;
        this.amount1 = amount1;
        this.code2 = code2;
        this.amount2 = amount2;
        this.code3 = code3;
        this.amount3 = amount3;
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

    public double getAmount1() {
        return amount1;
    }

    public void setAmount1(double amount1) {
        this.amount1 = amount1;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public double getAmount2() {
        return amount2;
    }

    public void setAmount2(double amount2) {
        this.amount2 = amount2;
    }

    public String getCode3() {
        return code3;
    }

    public void setCode3(String code3) {
        this.code3 = code3;
    }

    public double getAmount3() {
        return amount3;
    }

    public void setAmount3(double amount3) {
        this.amount3 = amount3;
    }

    @Override
    public String toString() {
        return "ValueCode{" +
                "id=" + id +
                ", code1='" + code1 + '\'' +
                ", amount1=" + amount1 +
                ", code2='" + code2 + '\'' +
                ", amount2=" + amount2 +
                ", code3='" + code3 + '\'' +
                ", amount3=" + amount3 +
                '}';
    }
}
