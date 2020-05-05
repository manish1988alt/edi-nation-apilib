package com.edination.api.eligibility.model;

import javax.persistence.*;

@Entity
@Table(name = "InsuranceDetailByPolicy")
public class InsuranceDetailByPolicy {

    @Id
    private String policyId;

    //private String mrnNumber;


    public InsuranceDetailByPolicy(){}

    public InsuranceDetailByPolicy(String policyId) {
        this.policyId = policyId;

    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pId")
    private PrimaryInsuranceDetail primaryInsuranceDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sId")
    private SecondaryInsuranceDetail secondaryInsuranceDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tId")
    private TertiaryInsuranceDetail tertiaryInsuranceDetail;

    public String getPolicyId() {
        return policyId;
    }

    public void setPolicyId(String policyId) {
        this.policyId = policyId;
    }
/*
    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }*/

    public PrimaryInsuranceDetail getPrimaryInsuranceDetail() {
        return primaryInsuranceDetail;
    }

    public void setPrimaryInsuranceDetail(PrimaryInsuranceDetail primaryInsuranceDetail) {
        this.primaryInsuranceDetail = primaryInsuranceDetail;
    }

    public SecondaryInsuranceDetail getSecondaryInsuranceDetail() {
        return secondaryInsuranceDetail;
    }

    public void setSecondaryInsuranceDetail(SecondaryInsuranceDetail secondaryInsuranceDetail) {
        this.secondaryInsuranceDetail = secondaryInsuranceDetail;
    }

    public TertiaryInsuranceDetail getTertiaryInsuranceDetail() {
        return tertiaryInsuranceDetail;
    }

    public void setTertiaryInsuranceDetail(TertiaryInsuranceDetail tertiaryInsuranceDetail) {
        this.tertiaryInsuranceDetail = tertiaryInsuranceDetail;
    }

    @Override
    public String toString() {
        return "InsuranceDetailByPolicy{" +
                "policyId='" + policyId + '\'' +
                ", primaryInsuranceDetail=" + primaryInsuranceDetail +
                ", secondaryInsuranceDetail=" + secondaryInsuranceDetail +
                ", tertiaryInsuranceDetail=" + tertiaryInsuranceDetail +
                '}';
    }
}
