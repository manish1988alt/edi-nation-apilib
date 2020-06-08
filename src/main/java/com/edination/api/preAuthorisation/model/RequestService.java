package com.edination.api.preAuthorisation.model;

import javax.persistence.*;

@Entity
@Table(name = "RequestService")
public class RequestService {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String mrnNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "homeHealthMrnNumber")
    private HomeHealthAide homeHealthAide;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "medicalSocialMrnNumber")
    MedicalSocialWork medicalSocialWork;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "occupationTherapyMrnNumber")
    OccupationTherapy occupationTherapy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skilledhNursingMrnNumber")
    SkilledNursing skilledNursing;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "physicalTherapyMrnNumber")
    PhysicalTherapy physicalTherapy;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "speechPathologyMrnNumber")
    SpeechPathology speechPathology;

    public RequestService() {
    }

    public RequestService(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public String getMrnNumber() {
        return mrnNumber;
    }

    public void setMrnNumber(String mrnNumber) {
        this.mrnNumber = mrnNumber;
    }

    public HomeHealthAide getHomeHealthAide() {
        return homeHealthAide;
    }
    public void setHomeHealthAide(HomeHealthAide homeHealthAide) {
        this.homeHealthAide = homeHealthAide;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MedicalSocialWork getMedicalSocialWork() {
        return medicalSocialWork;
    }

    public void setMedicalSocialWork(MedicalSocialWork medicalSocialWork) {
        this.medicalSocialWork = medicalSocialWork;
    }

    public OccupationTherapy getOccupationTherapy() {
        return occupationTherapy;
    }

    public void setOccupationTherapy(OccupationTherapy occupationTherapy) {
        this.occupationTherapy = occupationTherapy;
    }

    public SkilledNursing getSkilledNursing() {
        return skilledNursing;
    }

    public void setSkilledNursing(SkilledNursing skilledNursing) {
        this.skilledNursing = skilledNursing;
    }

    public PhysicalTherapy getPhysicalTherapy() {
        return physicalTherapy;
    }

    public void setPhysicalTherapy(PhysicalTherapy physicalTherapy) {
        this.physicalTherapy = physicalTherapy;
    }

    public SpeechPathology getSpeechPathology() {
        return speechPathology;
    }

    public void setSpeechPathology(SpeechPathology speechPathology) {
        this.speechPathology = speechPathology;
    }

    @Override
    public String toString() {
        return "RequestService{" +
                "mrnNumber='" + mrnNumber + '\'' +
                ", homeHealthAide=" + homeHealthAide +
                ", medicalSocialWork=" + medicalSocialWork +
                ", occupationTherapy=" + occupationTherapy +
                ", skilledNursing=" + skilledNursing +
                ", physicalTherapy=" + physicalTherapy +
                ", speechPathology=" + speechPathology +
                '}';
    }
}
