package com.edination.api.preAuthorisation.model;

import javax.persistence.*;

@Entity
@Table(name = "OrganizationInformation")
public class OrganizationInformation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String mrnNumber;
    private String  orgIdentificationCode;
    private String orgIdentificationCodeType;
    private String  organizationName;
    private String  orgCommunicationTypeTelephone;
    private int  orgCommunicationTypeFacsimile;
    private String  orgCommunicationTypeEMail;
    private int  orgCommunicationExt;

    public OrganizationInformation() {
    }

    public OrganizationInformation(String mrnNumber, String orgIdentificationCode, String orgIdentificationCodeType, String organizationName, String orgCommunicationTypeTelephone, int orgCommunicationTypeFacsimile, String orgCommunicationTypeEMail, int orgCommunicationExt) {
        this.mrnNumber = mrnNumber;
        this.orgIdentificationCode = orgIdentificationCode;
        this.orgIdentificationCodeType = orgIdentificationCodeType;
        this.organizationName = organizationName;
        this.orgCommunicationTypeTelephone = orgCommunicationTypeTelephone;
        this.orgCommunicationTypeFacsimile = orgCommunicationTypeFacsimile;
        this.orgCommunicationTypeEMail = orgCommunicationTypeEMail;
        this.orgCommunicationExt = orgCommunicationExt;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrgIdentificationCode() {
        return orgIdentificationCode;
    }

    public void setOrgIdentificationCode(String orgIdentificationCode) {
        this.orgIdentificationCode = orgIdentificationCode;
    }

    public String getOrgIdentificationCodeType() {
        return orgIdentificationCodeType;
    }

    public void setOrgIdentificationCodeType(String orgIdentificationCodeType) {
        this.orgIdentificationCodeType = orgIdentificationCodeType;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrgCommunicationTypeTelephone() {
        return orgCommunicationTypeTelephone;
    }

    public void setOrgCommunicationTypeTelephone(String orgCommunicationTypeTelephone) {
        this.orgCommunicationTypeTelephone = orgCommunicationTypeTelephone;
    }

    public int getOrgCommunicationTypeFacsimile() {
        return orgCommunicationTypeFacsimile;
    }

    public void setOrgCommunicationTypeFacsimile(int orgCommunicationTypeFacsimile) {
        this.orgCommunicationTypeFacsimile = orgCommunicationTypeFacsimile;
    }

    public String getOrgCommunicationTypeEMail() {
        return orgCommunicationTypeEMail;
    }

    public void setOrgCommunicationTypeEMail(String orgCommunicationTypeEMail) {
        this.orgCommunicationTypeEMail = orgCommunicationTypeEMail;
    }

    @Override
    public String toString() {
        return "OrganizationInformation{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", orgIdentificationCode='" + orgIdentificationCode + '\'' +
                ", orgIdentificationCodeType='" + orgIdentificationCodeType + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", orgCommunicationTypeTelephone='" + orgCommunicationTypeTelephone + '\'' +
                ", orgCommunicationTypeFacsimile=" + orgCommunicationTypeFacsimile +
                ", orgCommunicationTypeEMail='" + orgCommunicationTypeEMail + '\'' +
                ", orgCommunicationExt=" + orgCommunicationExt +
                '}';
    }

    public int getOrgCommunicationExt() {
        return orgCommunicationExt;
    }

    public void setOrgCommunicationExt(int orgCommunicationExt) {
        this.orgCommunicationExt = orgCommunicationExt;
    }






}
