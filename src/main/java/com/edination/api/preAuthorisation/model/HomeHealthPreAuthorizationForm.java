package com.edination.api.preAuthorisation.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "HomeHealthPreAuthorizationForm1")
public class HomeHealthPreAuthorizationForm {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String mrnNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "enquiryid")
    private EnquiryDeatils enquiryDeatils;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "demographicMrnNumber")
    private PreAuthDemographics preAuthDemographics;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orgnizationId")
    private OrganizationInformation organizationInformation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subscriberId")
    private SubscriberDetails subscriberDetails;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dependentId")
    private DependentDetails dependentDetails;

  /*  @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "insurancedetailMrnNumber")
    private InsuranceDetailPreAuth insuranceDetailPreAuth;*/

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "providerId")
    private RequesterDetails providerDetail;

 /*   @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "admissionMrnNumber")
    private AdmissionDetail admissionDetail;*/

   /* @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "requestforMrnNumber")
    private RequestFor requestFor;*/

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "requestserviceMrnNumber")
    private RequestService requestService;

    public HomeHealthPreAuthorizationForm() {
    }

    public HomeHealthPreAuthorizationForm(String mrnNumber, EnquiryDeatils enquiryDeatils, PreAuthDemographics preAuthDemographics, OrganizationInformation organizationInformation, SubscriberDetails subscriberDetails, DependentDetails dependentDetails, RequesterDetails providerDetail, RequestService requestService) {
        this.mrnNumber = mrnNumber;
        this.enquiryDeatils = enquiryDeatils;
        this.preAuthDemographics = preAuthDemographics;
        this.organizationInformation = organizationInformation;
        this.subscriberDetails = subscriberDetails;
        this.dependentDetails = dependentDetails;
        this.providerDetail = providerDetail;
        this.requestService = requestService;
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

    public EnquiryDeatils getEnquiryDeatils() {
        return enquiryDeatils;
    }

    public void setEnquiryDeatils(EnquiryDeatils enquiryDeatils) {
        this.enquiryDeatils = enquiryDeatils;
    }

    public PreAuthDemographics getPreAuthDemographics() {
        return preAuthDemographics;
    }

    public void setPreAuthDemographics(PreAuthDemographics preAuthDemographics) {
        this.preAuthDemographics = preAuthDemographics;
    }

    public OrganizationInformation getOrganizationInformation() {
        return organizationInformation;
    }

    public void setOrganizationInformation(OrganizationInformation organizationInformation) {
        this.organizationInformation = organizationInformation;
    }

    public SubscriberDetails getSubscriberDetails() {
        return subscriberDetails;
    }

    public void setSubscriberDetails(SubscriberDetails subscriberDetails) {
        this.subscriberDetails = subscriberDetails;
    }

    public DependentDetails getDependentDetails() {
        return dependentDetails;
    }

    public void setDependentDetails(DependentDetails dependentDetails) {
        this.dependentDetails = dependentDetails;
    }

    public RequesterDetails getProviderDetail() {
        return providerDetail;
    }

    public void setProviderDetail(RequesterDetails providerDetail) {
        this.providerDetail = providerDetail;
    }

    public RequestService getRequestService() {
        return requestService;
    }

    public void setRequestService(RequestService requestService) {
        this.requestService = requestService;
    }

    @Override
    public String toString() {
        return "HomeHealthPreAuthorizationForm{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", enquiryDeatils=" + enquiryDeatils +
                ", preAuthDemographics=" + preAuthDemographics +
                ", organizationInformation=" + organizationInformation +
                ", subscriberDetails=" + subscriberDetails +
                ", dependentDetails=" + dependentDetails +
                ", providerDetail=" + providerDetail +
                ", requestService=" + requestService +
                '}';
    }
}
