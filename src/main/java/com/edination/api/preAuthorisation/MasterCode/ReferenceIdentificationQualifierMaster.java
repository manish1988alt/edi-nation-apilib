package com.edination.api.preAuthorisation.MasterCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ReferenceIdentificationQualifierMaster")
public class ReferenceIdentificationQualifierMaster {

    @Id
    private String code;
    private String discription;

    public ReferenceIdentificationQualifierMaster() {
    }

    public ReferenceIdentificationQualifierMaster(String code, String discription) {
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
        return "ReferenceIdentificationQualifierMaster{" +
                "code='" + code + '\'' +
                ", discription='" + discription + '\'' +
                '}';
    }
}
