package com.edination.api.rap.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "ServicingProviderFacility")
public class ServicingProviderFacility {

    @Id
    private String id;
    private String providerName;
    private String facilityFirstName;
    private String facilityLastName;
    private String facilityMiddleName;
    private String facilityAddressLine;
    private String facilityCity;
    private String facilityState;
    private String facilityZipCode;
    private String  facilityCommunicationTypeTelephone;
    private int  facilityCommunicationTypeFacsimile;
    private String  facilityCommunicationTypeEMail;
    private int  facilityCommunicationExt;

    public ServicingProviderFacility() {
    }

    public ServicingProviderFacility(String id, String facilityFirstName, String facilityLastName, String facilityMiddleName, String facilityAddressLine, String facilityCity, String facilityState, String facilityZipCode, String facilityCommunicationTypeTelephone, int facilityCommunicationTypeFacsimile, String facilityCommunicationTypeEMail, int facilityCommunicationExt,String providerName) {
        this.id = id;
        this.providerName=providerName;
        this.facilityFirstName = facilityFirstName;
        this.facilityLastName = facilityLastName;
        this.facilityMiddleName = facilityMiddleName;
        this.facilityAddressLine = facilityAddressLine;
        this.facilityCity = facilityCity;
        this.facilityState = facilityState;
        this.facilityZipCode = facilityZipCode;
        this.facilityCommunicationTypeTelephone = facilityCommunicationTypeTelephone;
        this.facilityCommunicationTypeFacsimile = facilityCommunicationTypeFacsimile;
        this.facilityCommunicationTypeEMail = facilityCommunicationTypeEMail;
        this.facilityCommunicationExt = facilityCommunicationExt;
    }

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String getProviderName() {
        return providerName;
    }

    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    public String getFacilityFirstName() {
        return facilityFirstName;
    }

    public void setFacilityFirstName(String facilityFirstName) {
        this.facilityFirstName = facilityFirstName;
    }

    public String getFacilityLastName() {
        return facilityLastName;
    }

    public void setFacilityLastName(String facilityLastName) {
        this.facilityLastName = facilityLastName;
    }

    public String getFacilityMiddleName() {
        return facilityMiddleName;
    }

    public void setFacilityMiddleName(String facilityMiddleName) {
        this.facilityMiddleName = facilityMiddleName;
    }

    public String getFacilityAddressLine() {
        return facilityAddressLine;
    }

    public void setFacilityAddressLine(String facilityAddressLine) {
        this.facilityAddressLine = facilityAddressLine;
    }

    public String getFacilityCity() {
        return facilityCity;
    }

    public void setFacilityCity(String facilityCity) {
        this.facilityCity = facilityCity;
    }

    public String getFacilityState() {
        return facilityState;
    }

    public void setFacilityState(String facilityState) {
        this.facilityState = facilityState;
    }

    public String getFacilityZipCode() {
        return facilityZipCode;
    }

    public void setFacilityZipCode(String facilityZipCode) {
        this.facilityZipCode = facilityZipCode;
    }

    public String getFacilityCommunicationTypeTelephone() {
        return facilityCommunicationTypeTelephone;
    }

    public void setFacilityCommunicationTypeTelephone(String facilityCommunicationTypeTelephone) {
        this.facilityCommunicationTypeTelephone = facilityCommunicationTypeTelephone;
    }

    public int getFacilityCommunicationTypeFacsimile() {
        return facilityCommunicationTypeFacsimile;
    }

    public void setFacilityCommunicationTypeFacsimile(int facilityCommunicationTypeFacsimile) {
        this.facilityCommunicationTypeFacsimile = facilityCommunicationTypeFacsimile;
    }

    public String getFacilityCommunicationTypeEMail() {
        return facilityCommunicationTypeEMail;
    }
    public void setFacilityCommunicationTypeEMail(String facilityCommunicationTypeEMail) {
        this.facilityCommunicationTypeEMail = facilityCommunicationTypeEMail;
    }

    public int getFacilityCommunicationExt() {
        return facilityCommunicationExt;
    }

    public void setFacilityCommunicationExt(int facilityCommunicationExt) {
        this.facilityCommunicationExt = facilityCommunicationExt;
    }
    @Override
    public String toString() {
        return "ServicingProviderFacility{" +
                "id='" + id + '\'' +
                ", providerName='" + providerName + '\'' +
                ", facilityFirstName='" + facilityFirstName + '\'' +
                ", facilityLastName='" + facilityLastName + '\'' +
                ", facilityMiddleName='" + facilityMiddleName + '\'' +
                ", facilityAddressLine='" + facilityAddressLine + '\'' +
                ", facilityCity='" + facilityCity + '\'' +
                ", facilityState='" + facilityState + '\'' +
                ", facilityZipCode='" + facilityZipCode + '\'' +
                ", facilityCommunicationTypeTelephone='" + facilityCommunicationTypeTelephone + '\'' +
                ", facilityCommunicationTypeFacsimile=" + facilityCommunicationTypeFacsimile +
                ", facilityCommunicationTypeEMail='" + facilityCommunicationTypeEMail + '\'' +
                ", facilityCommunicationExt=" + facilityCommunicationExt +
                '}';
    }
    
}
