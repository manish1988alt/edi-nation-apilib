package com.edination.api.preAuthorisation.model;

import javax.persistence.*;

@Entity
@Table(name = "RequestServices")
public class RequestService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String mrnNumber;
    private int revenueCode;
    private int visits;
    private int units;
    private boolean homeHealthAide;
    private boolean medicalSocialWork;
    private boolean occupationTherapy;
    private boolean skilledNursing;
    private boolean physicalTherapy;
    private boolean speechPathology;


/*    @OneToOne(cascade = CascadeType.ALL)
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
    SpeechPathology speechPathology;*/

    public RequestService() {
    }

    public RequestService(String mrnNumber, int revenueCode, int visits, int units, boolean homeHealthAide, boolean medicalSocialWork, boolean occupationTherapy, boolean skilledNursing, boolean physicalTherapy, boolean speechPathology) {
        this.mrnNumber = mrnNumber;
        this.revenueCode = revenueCode;
        this.visits = visits;
        this.units = units;
        this.homeHealthAide = homeHealthAide;
        this.medicalSocialWork = medicalSocialWork;
        this.occupationTherapy = occupationTherapy;
        this.skilledNursing = skilledNursing;
        this.physicalTherapy = physicalTherapy;
        this.speechPathology = speechPathology;
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

    public int getRevenueCode() {
        return revenueCode;
    }

    public void setRevenueCode(int revenueCode) {
        this.revenueCode = revenueCode;
    }

    public int getVisits() {
        return visits;
    }

    public void setVisits(int visits) {
        this.visits = visits;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public boolean isHomeHealthAide() {
        return homeHealthAide;
    }

    public void setHomeHealthAide(boolean homeHealthAide) {
        this.homeHealthAide = homeHealthAide;
    }

    public boolean isMedicalSocialWork() {
        return medicalSocialWork;
    }

    public void setMedicalSocialWork(boolean medicalSocialWork) {
        this.medicalSocialWork = medicalSocialWork;
    }

    public boolean isOccupationTherapy() {
        return occupationTherapy;
    }

    public void setOccupationTherapy(boolean occupationTherapy) {
        this.occupationTherapy = occupationTherapy;
    }

    public boolean isSkilledNursing() {
        return skilledNursing;
    }

    public void setSkilledNursing(boolean skilledNursing) {
        this.skilledNursing = skilledNursing;
    }

    public boolean isPhysicalTherapy() {
        return physicalTherapy;
    }

    public void setPhysicalTherapy(boolean physicalTherapy) {
        this.physicalTherapy = physicalTherapy;
    }

    public boolean isSpeechPathology() {
        return speechPathology;
    }

    public void setSpeechPathology(boolean speechPathology) {
        this.speechPathology = speechPathology;
    }

    /*  public HomeHealthAide getHomeHealthAide() {
            return homeHealthAide;
        }

        public void setHomeHealthAide(HomeHealthAide homeHealthAide) {
            this.homeHealthAide = homeHealthAide;
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
    */

    @Override
    public String toString() {
        return "RequestService{" +
                "id=" + id +
                ", mrnNumber='" + mrnNumber + '\'' +
                ", revenueCode=" + revenueCode +
                ", visits=" + visits +
                ", units=" + units +
                ", homeHealthAide=" + homeHealthAide +
                ", medicalSocialWork=" + medicalSocialWork +
                ", occupationTherapy=" + occupationTherapy +
                ", skilledNursing=" + skilledNursing +
                ", physicalTherapy=" + physicalTherapy +
                ", speechPathology=" + speechPathology +
                '}';
    }
}
