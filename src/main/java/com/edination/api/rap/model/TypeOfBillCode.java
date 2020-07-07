package com.edination.api.rap.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TypeOfBillCode")
public class TypeOfBillCode {


    @Id
    private String code;
    private String codeDescription;

    public TypeOfBillCode() {
    }

    public TypeOfBillCode(String code, String codeDescription) {
        this.code = code;
        this.codeDescription = codeDescription;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeDescription() {
        return codeDescription;
    }

    public void setCodeDescription(String codeDescription) {
        this.codeDescription = codeDescription;
    }

    @Override
    public String toString() {
        return "TypeOfBillCode{" +
                "code='" + code + '\'' +
                ", codeDescription='" + codeDescription + '\'' +
                '}';
    }
}
