package com.edination.api.eligibility.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="MemberInsuranceEligibility")
public class MemberInsuranceEligibility{
          @Id
          private String policyNumber;
    /*    @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "mrnNumber")
        private Demographics demographics;*/

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "policyNumber")
        private InsuranceDetail insuranceDetail;

        private String  mrnNumber;
        private Date startDate;
        private Date  endDate;
        private Date statusVerifiedDate;
        private String eligibility;

        public MemberInsuranceEligibility(){}

        public MemberInsuranceEligibility(String policyNumber, Date startDate, Date endDate, Date statusVerifiedDate, String eligibility,String mrnNumber) {
            this.policyNumber = policyNumber;
            this.startDate = startDate;
            this.endDate = endDate;
            this.statusVerifiedDate = statusVerifiedDate;
            this.eligibility = eligibility;
            this.mrnNumber=mrnNumber;
        }


        public String getPolicyNumber() {
            return policyNumber;
        }

        public void setPolicyNumber(String policyNumber) {
            this.policyNumber = policyNumber;
        }

        public Date getStartDate() {
            return startDate;
        }

        public void setStartDate(Date startDate) {
            this.startDate = startDate;
        }

        public Date getEndDate() {
            return endDate;
        }

        public void setEndDate(Date endDate) {
            this.endDate = endDate;
        }

        public Date getStatusVerifiedDate() {
            return statusVerifiedDate;
        }

        public void setStatusVerifiedDate(Date statusVerifiedDate) {
            this.statusVerifiedDate = statusVerifiedDate;
        }

        public String getEligibility() {
            return eligibility;
        }

        public void setEligibility(String eligibility) {
            this.eligibility = eligibility;
        }

    /*public Demographics getDemographics() {
        return demographics;
    }

    public void setDemographics(Demographics demographics) {
        this.demographics = demographics;
    }
*/

    public InsuranceDetail getInsuranceDetail() {
        return insuranceDetail;
    }

    public void setInsuranceDetail(InsuranceDetail insuranceDetail) {
        this.insuranceDetail = insuranceDetail;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    @Override
    public String toString() {
        return "MemberInsuranceEligibility{" +
                "policyNumber='" + policyNumber + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", statusVerifiedDate=" + statusVerifiedDate +
                ", eligibility='" + eligibility + '\'' +
                '}';
    }
}
