package com.edination.api.rap.model;

import javax.persistence.*;

@Entity
@Table(name = "PayerDetails")
public class PayerDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mrnNumber;
    private int count;
    private String payerType;
    private String payerName;
    private int    payerCarrierNumber;
    private String healthPlanID;
    private String assignmentOfBenefit;
    private double priorPayment;
    private double estimateAmount;

    public PayerDetails() {
    }

    public PayerDetails(String mrnNumber, int count, String payerType, String payerName, int payerCarrierNumber, String healthPlanID, String assignmentOfBenefit, double priorPayment, double estimateAmount) {
        this.mrnNumber = mrnNumber;
        this.count = count;
        this.payerType = payerType;
        this.payerName = payerName;
        this.payerCarrierNumber = payerCarrierNumber;
        this.healthPlanID = healthPlanID;
        this.assignmentOfBenefit = assignmentOfBenefit;
        this.priorPayment = priorPayment;
        this.estimateAmount = estimateAmount;
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

    public String getPayerType() {
        return payerType;
    }

    public void setPayerType(String payerType) {
        this.payerType = payerType;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public int getPayerCarrierNumber() {
        return payerCarrierNumber;
    }

    public void setPayerCarrierNumber(int payerCarrierNumber) {
        this.payerCarrierNumber = payerCarrierNumber;
    }

    public String getHealthPlanID() {
        return healthPlanID;
    }

    public void setHealthPlanID(String healthPlanID) {
        this.healthPlanID = healthPlanID;
    }

    public String getAssignmentOfBenefit() {
        return assignmentOfBenefit;
    }

    public void setAssignmentOfBenefit(String assignmentOfBenefit) {
        this.assignmentOfBenefit = assignmentOfBenefit;
    }

    public double getPriorPayment() {
        return priorPayment;
    }

    public void setPriorPayment(double priorPayment) {
        this.priorPayment = priorPayment;
    }

    public double getEstimateAmount() {
        return estimateAmount;
    }

    public void setEstimateAmount(double estimateAmount) {
        this.estimateAmount = estimateAmount;
    }

    @Override
    public String toString() {
        return "PayerDetails{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", count=" + count +
                ", payerType='" + payerType + '\'' +
                ", payerName='" + payerName + '\'' +
                ", payerCarrierNumber=" + payerCarrierNumber +
                ", healthPlanID='" + healthPlanID + '\'' +
                ", assignmentOfBenefit='" + assignmentOfBenefit + '\'' +
                ", priorPayment=" + priorPayment +
                ", estimateAmount=" + estimateAmount +
                '}';
    }
}
