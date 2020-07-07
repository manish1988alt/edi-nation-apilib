package com.edination.api.rap.model;

import javax.persistence.*;

@Entity
@Table(name = "ConditionCodeDetail")
public class ConditionCodeDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String code;
    private String mrnNumber;
    public ConditionCodeDetail() {
    }

    public ConditionCodeDetail(String code,String mrnNumber) {
        this.code = code;
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

    @Override
    public String toString() {
        return "ConditionCodeDetail{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", mrnNumber='" + mrnNumber + '\'' +
                '}';
    }
}
