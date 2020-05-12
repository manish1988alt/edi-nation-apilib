package com.edination.api.preAuthorisation.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HomeHealthPreAuthorizationForm")
public class HomeHealthPreAuthorizationForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String mrnNumber;
    private Date currenttimdate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "demographicMrnNumber")
    private PreAuthDemographics preAuthDemographics;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "insurancedetailMrnNumber")
    private InsuranceDetailPreAuth insuranceDetailPreAuth;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "providerId")
    private ProviderDetail providerDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admissionMrnNumber")
    private AdmissionDetail admissionDetail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "requestforMrnNumber")
    private RequestFor requestFor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "requestserviceMrnNumber")
    private RequestService requestService;

    public HomeHealthPreAuthorizationForm() {
    }

    public HomeHealthPreAuthorizationForm(String mrnNumber, Date currenttimdate) {
        this.mrnNumber = mrnNumber;
        this.currenttimdate = currenttimdate;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public Date getCurrenttimdate() {
        return currenttimdate;
    }

    public void setCurrenttimdate(Date currenttimdate) {
        this.currenttimdate = currenttimdate;
    }

    public PreAuthDemographics getPreAuthDemographics() {
        return preAuthDemographics;
    }

    public void setPreAuthDemographics(PreAuthDemographics preAuthDemographics) {
        this.preAuthDemographics = preAuthDemographics;
    }

    public InsuranceDetailPreAuth getInsuranceDetailPreAuth() {
        return insuranceDetailPreAuth;
    }

    public void setInsuranceDetailPreAuth(InsuranceDetailPreAuth insuranceDetailPreAuth) {
        this.insuranceDetailPreAuth = insuranceDetailPreAuth;
    }

    public ProviderDetail getProviderDetail() {
        return providerDetail;
    }

    public void setProviderDetail(ProviderDetail providerDetail) {
        this.providerDetail = providerDetail;
    }

    public AdmissionDetail getAdmissionDetail() {
        return admissionDetail;
    }

    public void setAdmissionDetail(AdmissionDetail admissionDetail) {
        this.admissionDetail = admissionDetail;
    }

    public RequestFor getRequestFor() {
        return requestFor;
    }

    public void setRequestFor(RequestFor requestFor) {
        this.requestFor = requestFor;
    }

    public RequestService getRequestService() {
        return requestService;
    }

    public void setRequestService(RequestService requestService) {
        this.requestService = requestService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "HomeHealthPreAuthorizationForm{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", currenttimdate=" + currenttimdate +
                ", preAuthDemographics=" + preAuthDemographics +
                ", insuranceDetailPreAuth=" + insuranceDetailPreAuth +
                ", providerDetail=" + providerDetail +
                ", admissionDetail=" + admissionDetail +
                ", requestFor=" + requestFor +
                ", requestService=" + requestService +
                '}';
    }
}
