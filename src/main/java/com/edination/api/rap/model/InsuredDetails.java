package com.edination.api.rap.model;

import javax.persistence.*;

@Entity
@Table(name = "InsuredDetails")
public class InsuredDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mrnNumber;
    private int count;
    private String insuredName;
    private String relationshipToInsured;
    private String insuredUniqueIdentifiers;
    private String insuredGroupName;
    private int insuredGroupNumber;

    public InsuredDetails() {
    }

    public InsuredDetails(String mrnNumber, int count, String insuredName, String relationshipToInsured, String insuredUniqueIdentifiers, String insuredGroupName, int insuredGroupNumber) {
        this.mrnNumber = mrnNumber;
        this.count = count;
        this.insuredName = insuredName;
        this.relationshipToInsured = relationshipToInsured;
        this.insuredUniqueIdentifiers = insuredUniqueIdentifiers;
        this.insuredGroupName = insuredGroupName;
        this.insuredGroupNumber = insuredGroupNumber;
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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getInsuredName() {
        return insuredName;
    }

    public void setInsuredName(String insuredName) {
        this.insuredName = insuredName;
    }

    public String getRelationshipToInsured() {
        return relationshipToInsured;
    }

    public void setRelationshipToInsured(String relationshipToInsured) {
        this.relationshipToInsured = relationshipToInsured;
    }

    public String getInsuredUniqueIdentifiers() {
        return insuredUniqueIdentifiers;
    }

    public void setInsuredUniqueIdentifiers(String insuredUniqueIdentifiers) {
        this.insuredUniqueIdentifiers = insuredUniqueIdentifiers;
    }

    public String getInsuredGroupName() {
        return insuredGroupName;
    }

    public void setInsuredGroupName(String insuredGroupName) {
        this.insuredGroupName = insuredGroupName;
    }

    public int getInsuredGroupNumber() {
        return insuredGroupNumber;
    }

    public void setInsuredGroupNumber(int insuredGroupNumber) {
        this.insuredGroupNumber = insuredGroupNumber;
    }

    @Override
    public String toString() {
        return "InsuredDetails{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", count=" + count +
                ", insuredName='" + insuredName + '\'' +
                ", relationshipToInsured='" + relationshipToInsured + '\'' +
                ", insuredUniqueIdentifiers='" + insuredUniqueIdentifiers + '\'' +
                ", insuredGroupName='" + insuredGroupName + '\'' +
                ", insuredGroupNumber=" + insuredGroupNumber +
                '}';
    }
}
