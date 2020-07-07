package com.edination.api.rap.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ValueCodeDetail")
public class ValueCodeDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String code;
    private double amount;
    private String mrnNumber;

    public ValueCodeDetail() {
    }

    public ValueCodeDetail(String code, double amount,String mrnNumber) {
        this.code = code;
        this.amount = amount;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ValueCodeDetail{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", amount=" + amount +
                ", mrnNumber='" + mrnNumber + '\'' +
                '}';
    }
}
