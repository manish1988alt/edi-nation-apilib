package com.edination.api.preAuthorisation.MasterCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "TimePeriodQualifierMaster")
public class TimePeriodQualifierMaster {

    @Id
    private String code;
    private String discription;

    public TimePeriodQualifierMaster() {
    }

    public TimePeriodQualifierMaster(String code, String discription) {
        this.code = code;
        this.discription = discription;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Override
    public String toString() {
        return "TimePeriodQualifierMaster{" +
                "code='" + code + '\'' +
                ", discription='" + discription + '\'' +
                '}';
    }
}
