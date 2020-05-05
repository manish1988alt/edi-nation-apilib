package com.edination.api.eligibility.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Demographics")
public class Demographics {
    @Id
    private String mrnNumber;
    private String firstName;
    private String lastName;
    private String middleName;
    private String suffix;
    private String gender;
    private Date dob;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "policyId")
    private InsuranceDetailByPolicy insuranceDetailByPolicy;

/*    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ssn")
    private InsuranceAndDiagnosis insuranceAndDiagnosis;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "policyNumber")
    private PrimaryInsuranceDetail primaryInsuranceDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "secondaryPolicyNumber")
    private SecondaryInsuranceDetail secondaryInsuranceDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tertiaryPolicyNumber")
    private TertiaryInsuranceDetail tertiaryInsuranceDetail;*/

    /*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "policyNumber")
    private InsuranceDetail insuranceDetail;*/

    public Demographics(){}

    public Demographics(String mrnNumber,String firstName, String lastName, String middleName, String suffix, String gender, Date dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.suffix = suffix;
        this.gender = gender;
        this.dob = dob;
        this.mrnNumber=mrnNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public InsuranceDetailByPolicy getInsuranceDetailByPolicy() {
        return insuranceDetailByPolicy;
    }

    public void setInsuranceDetailByPolicy(InsuranceDetailByPolicy insuranceDetailByPolicy) {
        this.insuranceDetailByPolicy = insuranceDetailByPolicy;
    }

    /*  public InsuranceAndDiagnosis getInsuranceAndDiagnosis() {
            return insuranceAndDiagnosis;
        }

        public void setInsuranceAndDiagnosis(InsuranceAndDiagnosis insuranceAndDiagnosis) {
            this.insuranceAndDiagnosis = insuranceAndDiagnosis;
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
    */

    @Override
    public String toString() {
        return "Demographics{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", suffix='" + suffix + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", insuranceDetailByPolicy=" + insuranceDetailByPolicy +
                '}';
    }
}
