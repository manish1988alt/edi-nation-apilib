package com.edination.api.preAuthorisation.model;

import javax.persistence.*;

@Entity
@Table(name = "RequestFor")
public class RequestFor {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

   private String mrnNumber;
   private boolean newadmissionService;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "previousAuthorizationNumberAd")
    private AdditionalServices additionalServices;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "previousAuthorizationNumberExt")
    private Extension extension;

    public RequestFor() {
    }

    public RequestFor(String mrnNumber, boolean newadmissionService) {
        this.mrnNumber = mrnNumber;
        this.newadmissionService = newadmissionService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isNewadmissionService() {
        return newadmissionService;
    }

    public void setNewadmissionService(boolean newadmissionService) {
        this.newadmissionService = newadmissionService;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public AdditionalServices getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(AdditionalServices additionalServices) {
        this.additionalServices = additionalServices;
    }

    public Extension getExtension() {
        return extension;
    }

    public void setExtension(Extension extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "RequestFor{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", newadmissionService=" + newadmissionService +
                ", additionalServices=" + additionalServices +
                ", extension=" + extension +
                '}';
    }
}
