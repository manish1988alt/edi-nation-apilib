package com.edination.api.LoginPackage.model;



import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "AdmissionDetail")
public class AdmissionDetail {
    @Id
    private String mrnNumber;
    private int zipCode;
    private String	state;
	private Date startOfCare;
    private Date	endOfCare;
    private String	city;
    private String	address1;
    private String	address2;
    private String mobile;
    private String homePhone;
    private String email;
    private String preferableCommunicationMethod;


    public AdmissionDetail(){}

    public AdmissionDetail(String mrnNumber, int zipCode, String state, Date startOfCare, Date endOfCare, String city, String address1, String address2, String mobile, String homePhone, String email, String preferableCommunicationMethod) {
        this.mrnNumber = mrnNumber;
        this.zipCode = zipCode;
        this.state = state;
        this.startOfCare = startOfCare;
        this.endOfCare = endOfCare;
        this.city = city;
        this.address1 = address1;
        this.address2 = address2;
        this.mobile = mobile;
        this.homePhone = homePhone;
        this.email = email;
        this.preferableCommunicationMethod = preferableCommunicationMethod;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getStartOfCare() {
        return startOfCare;
    }

    public void setStartOfCare(Date startOfCare) {
        this.startOfCare = startOfCare;
    }

    public Date getEndOfCare() {
        return endOfCare;
    }

    public void setEndOfCare(Date endOfCare) {
        this.endOfCare = endOfCare;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPreferableCommunicationMethod() {
        return preferableCommunicationMethod;
    }

    public void setPreferableCommunicationMethod(String preferableCommunicationMethod) {
        this.preferableCommunicationMethod = preferableCommunicationMethod;
    }

    @Override
    public String toString() {
        return "AdmissionDetail{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", zipCode=" + zipCode +
                ", state='" + state + '\'' +
                ", startOfCare=" + startOfCare +
                ", endOfCare=" + endOfCare +
                ", city='" + city + '\'' +
                ", address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", mobile='" + mobile + '\'' +
                ", homePhone='" + homePhone + '\'' +
                ", email='" + email + '\'' +
                ", preferableCommunicationMethod='" + preferableCommunicationMethod + '\'' +
                '}';
    }
}
