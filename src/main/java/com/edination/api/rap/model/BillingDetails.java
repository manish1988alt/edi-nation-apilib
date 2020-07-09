package com.edination.api.rap.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "BillingDetails")
public class BillingDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mrnNumber;
    private int   count;
    private String  revenueCode;
    private String revenueCodeDescription;
    private String hCPCS_Rate_HCPCS_Code;
    private LocalDate serviceDate;
    private String  serviceUnit;
    private double  totalCharge;
    private double nonCoverageCharge;
    private double totalCostForTotalCharge;
    private double totalCostForNonCoverageCharge;
    private LocalDate creationDate;

    public BillingDetails() {
    }

    public BillingDetails(String mrnNumber,int count, String revenueCode, String revenueCodeDescription, String hCPCS_Rate_HCPCS_Code, LocalDate serviceDate, String serviceUnit, double totalCharge, double nonCoverageCharge, double totalCostForTotalCharge, double totalCostForNonCoverageCharge, LocalDate creationDate) {
        this.mrnNumber=mrnNumber;
        this.count = count;
        this.revenueCode = revenueCode;
        this.revenueCodeDescription = revenueCodeDescription;
        this.hCPCS_Rate_HCPCS_Code = hCPCS_Rate_HCPCS_Code;
        this.serviceDate = serviceDate;
        this.serviceUnit = serviceUnit;
        this.totalCharge = totalCharge;
        this.nonCoverageCharge = nonCoverageCharge;
        this.totalCostForTotalCharge = totalCostForTotalCharge;
        this.totalCostForNonCoverageCharge = totalCostForNonCoverageCharge;
        this.creationDate = creationDate;
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

    public String getRevenueCode() {
        return revenueCode;
    }

    public void setRevenueCode(String revenueCode) {
        this.revenueCode = revenueCode;
    }

    public String getRevenueCodeDescription() {
        return revenueCodeDescription;
    }

    public void setRevenueCodeDescription(String revenueCodeDescription) {
        this.revenueCodeDescription = revenueCodeDescription;
    }

    public String gethCPCS_Rate_HCPCS_Code() {
        return hCPCS_Rate_HCPCS_Code;
    }

    public void sethCPCS_Rate_HCPCS_Code(String hCPCS_Rate_HCPCS_Code) {
        this.hCPCS_Rate_HCPCS_Code = hCPCS_Rate_HCPCS_Code;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public String getServiceUnit() {
        return serviceUnit;
    }

    public void setServiceUnit(String serviceUnit) {
        this.serviceUnit = serviceUnit;
    }

    public double getTotalCharge() {
        return totalCharge;
    }

    public void setTotalCharge(double totalCharge) {
        this.totalCharge = totalCharge;
    }

    public double getNonCoverageCharge() {
        return nonCoverageCharge;
    }

    public void setNonCoverageCharge(double nonCoverageCharge) {
        this.nonCoverageCharge = nonCoverageCharge;
    }

    public double getTotalCostForTotalCharge() {
        return totalCostForTotalCharge;
    }

    public void setTotalCostForTotalCharge(double totalCostForTotalCharge) {
        this.totalCostForTotalCharge = totalCostForTotalCharge;
    }

    public double getTotalCostForNonCoverageCharge() {
        return totalCostForNonCoverageCharge;
    }

    public void setTotalCostForNonCoverageCharge(double totalCostForNonCoverageCharge) {
        this.totalCostForNonCoverageCharge = totalCostForNonCoverageCharge;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public String toString() {
        return "BillingDetails{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", count=" + count +
                ", revenueCode='" + revenueCode + '\'' +
                ", revenueCodeDescription='" + revenueCodeDescription + '\'' +
                ", hCPCS_Rate_HCPCS_Code='" + hCPCS_Rate_HCPCS_Code + '\'' +
                ", serviceDate=" + serviceDate +
                ", serviceUnit='" + serviceUnit + '\'' +
                ", totalCharge=" + totalCharge +
                ", nonCoverageCharge=" + nonCoverageCharge +
                ", totalCostForTotalCharge=" + totalCostForTotalCharge +
                ", totalCostForNonCoverageCharge=" + totalCostForNonCoverageCharge +
                ", creationDate=" + creationDate +
                '}';
    }
}
