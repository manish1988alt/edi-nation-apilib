package com.edination.api.preAuthorisation.model;

import javax.persistence.*;

@Entity
@Table(name = "ProviderDetail")
public class ProviderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String  requestingProviderIDNumber;
    private String requestingAgency;
	private String  providerName;
	private String  providerTaxIDNumber;
    private int  phoneNumber;
    private int  extension;
    private int faxNumber;

    public ProviderDetail() {
    }

    public ProviderDetail(String requestingAgency, String providerName, String requestingProviderIDNumber, String providerTaxIDNumber, int phoneNumber, int extension, int faxNumber) {
        this.requestingAgency = requestingAgency;
        this.providerName = providerName;
        this.requestingProviderIDNumber = requestingProviderIDNumber;
        this.providerTaxIDNumber = providerTaxIDNumber;
        this.phoneNumber = phoneNumber;
        this.extension = extension;
        this.faxNumber = faxNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequestingAgency() {
        return requestingAgency;
    }

    public void setRequestingAgency(String requestingAgency) {
        this.requestingAgency = requestingAgency;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getRequestingProviderIDNumber() {
        return requestingProviderIDNumber;
    }

    public void setRequestingProviderIDNumber(String requestingProviderIDNumber) {
        this.requestingProviderIDNumber = requestingProviderIDNumber;
    }

    public String getProviderTaxIDNumber() {
        return providerTaxIDNumber;
    }

    public void setProviderTaxIDNumber(String providerTaxIDNumber) {
        this.providerTaxIDNumber = providerTaxIDNumber;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getExtension() {
        return extension;
    }

    public void setExtension(int extension) {
        this.extension = extension;
    }

    public int getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(int faxNumber) {
        this.faxNumber = faxNumber;
    }

    @Override
    public String toString() {
        return "ProviderDetail{" +
                "id=" + id +
                ", requestingProviderIDNumber='" + requestingProviderIDNumber + '\'' +
                ", requestingAgency='" + requestingAgency + '\'' +
                ", providerName='" + providerName + '\'' +
                ", providerTaxIDNumber='" + providerTaxIDNumber + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", extension=" + extension +
                ", faxNumber=" + faxNumber +
                '}';
    }
}
