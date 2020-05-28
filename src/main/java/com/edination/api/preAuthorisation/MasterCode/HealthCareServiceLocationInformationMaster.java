package com.edination.api.preAuthorisation.MasterCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "HealthCareServiceLocationInformationMaster")
public class HealthCareServiceLocationInformationMaster {

    @Id
    private String code;
    private String discription;

    public HealthCareServiceLocationInformationMaster() {
    }

    public HealthCareServiceLocationInformationMaster(String code, String discription) {
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
        return "HealthCareServiceLocationInformationMaster{" +
                "code='" + code + '\'' +
                ", discription='" + discription + '\'' +
                '}';
    }
}
