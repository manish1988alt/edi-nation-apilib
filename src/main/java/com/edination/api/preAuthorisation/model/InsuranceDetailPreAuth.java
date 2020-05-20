package com.edination.api.preAuthorisation.model;

import com.edination.api.eligibility.model.PrimaryInsuranceDetail;
import com.edination.api.eligibility.model.SecondaryInsuranceDetail;
import com.edination.api.eligibility.model.TertiaryInsuranceDetail;

import javax.persistence.*;

@Entity
@Table(name = "InsuranceDetailPreAuth")
public class InsuranceDetailPreAuth {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String mrnNumber;
    private String insuranceTypeSelcted;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pId")
    private PrimaryInsuranceDetail primaryInsuranceDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sId")
    private SecondaryInsuranceDetail secondaryInsuranceDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tId")
    private TertiaryInsuranceDetail tertiaryInsuranceDetail;

    public InsuranceDetailPreAuth() {
    }

    public InsuranceDetailPreAuth(String mrnNumber, String insuranceTypeSelcted) {
        this.mrnNumber = mrnNumber;
        this.insuranceTypeSelcted = insuranceTypeSelcted;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public String getInsuranceTypeSelcted() {
        return insuranceTypeSelcted;
    }

    public void setInsuranceTypeSelcted(String insuranceTypeSelcted) {
        this.insuranceTypeSelcted = insuranceTypeSelcted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
        return "InsuranceDetailPreAuth{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", insuranceTypeSelcted='" + insuranceTypeSelcted + '\'' +
                ", primaryInsuranceDetail=" + primaryInsuranceDetail +
                ", secondaryInsuranceDetail=" + secondaryInsuranceDetail +
                ", tertiaryInsuranceDetail=" + tertiaryInsuranceDetail +
                '}';
    }
}
