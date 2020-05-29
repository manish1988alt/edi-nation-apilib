package com.edination.api.preAuthorisation.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AuthorizationDetail")
public class AuthorizationDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String   authorizationNo;
    private Date     authStartDate;
    private Date     authEndDate;
    private int      totalUnitsApproved;
    private int      totalUnitsConsumed;
    private int      remainingUnits;
    private int      noOfUnitsTobeUsed;
    private String   unitsForNoOfUnitsTobeUsed;

    public AuthorizationDetail() {
    }

    public AuthorizationDetail(int id, String authorizationNo, Date authStartDate, Date authEndDate, int totalUnitsApproved, int totalUnitsConsumed, int remainingUnits, int noOfUnitsTobeUsed, String unitsForNoOfUnitsTobeUsed) {
        this.id = id;
        this.authorizationNo = authorizationNo;
        this.authStartDate = authStartDate;
        this.authEndDate = authEndDate;
        this.totalUnitsApproved = totalUnitsApproved;
        this.totalUnitsConsumed = totalUnitsConsumed;
        this.remainingUnits = remainingUnits;
        this.noOfUnitsTobeUsed = noOfUnitsTobeUsed;
        this.unitsForNoOfUnitsTobeUsed = unitsForNoOfUnitsTobeUsed;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorizationNo() {
        return authorizationNo;
    }

    public void setAuthorizationNo(String authorizationNo) {
        this.authorizationNo = authorizationNo;
    }

    public Date getAuthStartDate() {
        return authStartDate;
    }

    public void setAuthStartDate(Date authStartDate) {
        this.authStartDate = authStartDate;
    }

    public Date getAuthEndDate() {
        return authEndDate;
    }

    public void setAuthEndDate(Date authEndDate) {
        this.authEndDate = authEndDate;
    }

    public int getTotalUnitsApproved() {
        return totalUnitsApproved;
    }

    public void setTotalUnitsApproved(int totalUnitsApproved) {
        this.totalUnitsApproved = totalUnitsApproved;
    }

    public int getTotalUnitsConsumed() {
        return totalUnitsConsumed;
    }

    public void setTotalUnitsConsumed(int totalUnitsConsumed) {
        this.totalUnitsConsumed = totalUnitsConsumed;
    }

    public int getRemainingUnits() {
        return remainingUnits;
    }

    public void setRemainingUnits(int remainingUnits) {
        this.remainingUnits = remainingUnits;
    }

    public int getNoOfUnitsTobeUsed() {
        return noOfUnitsTobeUsed;
    }

    public void setNoOfUnitsTobeUsed(int noOfUnitsTobeUsed) {
        this.noOfUnitsTobeUsed = noOfUnitsTobeUsed;
    }

    public String getUnitsForNoOfUnitsTobeUsed() {
        return unitsForNoOfUnitsTobeUsed;
    }

    public void setUnitsForNoOfUnitsTobeUsed(String unitsForNoOfUnitsTobeUsed) {
        this.unitsForNoOfUnitsTobeUsed = unitsForNoOfUnitsTobeUsed;
    }

    @Override
    public String toString() {
        return "AuthorizationDetail{" +
                "id=" + id +
                ", authorizationNo='" + authorizationNo + '\'' +
                ", authStartDate=" + authStartDate +
                ", authEndDate=" + authEndDate +
                ", totalUnitsApproved=" + totalUnitsApproved +
                ", totalUnitsConsumed=" + totalUnitsConsumed +
                ", remainingUnits=" + remainingUnits +
                ", noOfUnitsTobeUsed=" + noOfUnitsTobeUsed +
                ", unitsForNoOfUnitsTobeUsed='" + unitsForNoOfUnitsTobeUsed + '\'' +
                '}';
    }
}
