package com.edination.api.preAuthorisation.model;

import javax.persistence.*;

@Entity
@Table(name = "PreAuthDetail")
public class PreAuthDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int preAuthId;

    //private String preAuthId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "preAuthMrnNumber")
    private PreAuthDemographics preAuthDemographics;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "epsMrnNumber")
    private Episode episode;

    public PreAuthDetail(){}

    public int getPreAuthId() {
        return preAuthId;
    }

    public void setPreAuthId(int preAuthId) {
        this.preAuthId = preAuthId;
    }

    public PreAuthDemographics getPreAuthDemographics() {
        return preAuthDemographics;
    }

    public void setPreAuthDemographics(PreAuthDemographics preAuthDemographics) {
        this.preAuthDemographics = preAuthDemographics;
    }

    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(Episode episode) {
        this.episode = episode;
    }

    @Override
    public String toString() {
        return "PreAuthDetail{" +
                "preAuthId='" + preAuthId + '\'' +
                ", preAuthDemographics=" + preAuthDemographics +
                ", episode=" + episode +
                '}';
    }
}
