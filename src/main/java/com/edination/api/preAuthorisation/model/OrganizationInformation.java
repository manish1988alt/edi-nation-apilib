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
    private String  orgCommunicationType;
    private int  orgCommunicationNo;
    private int  orgCommunicationExt;

    public OrganizationInformation() {
    }

    public OrganizationInformation(String mrnNumber, String orgIdentificationCode, String orgIdentificationCodeType, String organizationName, String orgCommunicationType, int orgCommunicationNo, int orgCommunicationExt) {
        this.mrnNumber = mrnNumber;
        this.orgIdentificationCode = orgIdentificationCode;
        this.orgIdentificationCodeType = orgIdentificationCodeType;
        this.organizationName = organizationName;
        this.orgCommunicationType = orgCommunicationType;
        this.orgCommunicationNo = orgCommunicationNo;
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

    public String getOrgCommunicationType() {
        return orgCommunicationType;
    }

    public void setOrgCommunicationType(String orgCommunicationType) {
        this.orgCommunicationType = orgCommunicationType;
    }

    public int getOrgCommunicationNo() {
        return orgCommunicationNo;
    }

    public void setOrgCommunicationNo(int orgCommunicationNo) {
        this.orgCommunicationNo = orgCommunicationNo;
    }

    @Override
    public String toString() {
        return "OrganizationInformation{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", orgIdentificationCode='" + orgIdentificationCode + '\'' +
                ", orgIdentificationCodeType='" + orgIdentificationCodeType + '\'' +
                ", organizationName='" + organizationName + '\'' +
                ", orgCommunicationType='" + orgCommunicationType + '\'' +
                ", orgCommunicationNo=" + orgCommunicationNo +
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
