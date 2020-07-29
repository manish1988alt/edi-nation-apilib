package com.edination.api.LoginPackage.model;

import com.edination.api.PDGM.model.AdmissionSource;
import com.edination.api.PDGM.model.SecondDiagnosisCode;
import com.edination.api.eligibility.model.Demographics;
import com.edination.api.eligibility.model.PrimaryInsuranceDetail;
import com.edination.api.preAuthorisation.model.*;
import com.edination.api.rap.model.AttendingProviderDetail;
import com.edination.api.rap.model.OtherProviderDetail;
import com.edination.api.rap.model.PrimaryDiagnosisCode;


import java.util.List;

public class AddPatientModel {
    private Demographics demographics;
    private AddressDetail addressDetail;
    private AdmissionSource admissionSource;
    private OtherProviderDetail otherProviderDetail;
    private PrimaryInsuranceDetail primaryInsuranceDetail;
    private PrimaryDiagnosisCode primaryDiagnosisCode;
    private List<SecondDiagnosisCode> secondDiagnosisCodeList;
    private SkilledNursing skilledNursing;
    private HomeHealthAide homeHealthAide;
    private MedicalSocialWork medicalSocialWork;
    private PhysicalTherapy physicalTherapy;
    private  SpeechPathology speechPathology;
    private  OccupationTherapy occupationTherapy;
    private GuarenterDetails guarenterDetails;

    public AddPatientModel() {
    }

    public AddPatientModel(Demographics demographics, AddressDetail addressDetail, AdmissionSource admissionSource, OtherProviderDetail otherProviderDetail, PrimaryInsuranceDetail primaryInsuranceDetail, PrimaryDiagnosisCode primaryDiagnosisCode, List<SecondDiagnosisCode> secondDiagnosisCodeList, SkilledNursing skilledNursing, HomeHealthAide homeHealthAide, MedicalSocialWork medicalSocialWork, PhysicalTherapy physicalTherapy, SpeechPathology speechPathology, OccupationTherapy occupationTherapy, GuarenterDetails guarenterDetails) {
        this.demographics = demographics;
        this.addressDetail = addressDetail;
        this.admissionSource = admissionSource;
        this.otherProviderDetail = otherProviderDetail;
        this.primaryInsuranceDetail = primaryInsuranceDetail;
        this.primaryDiagnosisCode = primaryDiagnosisCode;
        this.secondDiagnosisCodeList = secondDiagnosisCodeList;
        this.skilledNursing = skilledNursing;
        this.homeHealthAide = homeHealthAide;
        this.medicalSocialWork = medicalSocialWork;
        this.physicalTherapy = physicalTherapy;
        this.speechPathology = speechPathology;
        this.occupationTherapy = occupationTherapy;
        this.guarenterDetails = guarenterDetails;
    }

    public Demographics getDemographics() {
        return demographics;
    }

    public void setDemographics(Demographics demographics) {
        this.demographics = demographics;
    }

    public AddressDetail getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(AddressDetail addressDetail) {
        this.addressDetail = addressDetail;
    }

    public AdmissionSource getAdmissionSource() {
        return admissionSource;
    }

    public void setAdmissionSource(AdmissionSource admissionSource) {
        this.admissionSource = admissionSource;
    }

    public OtherProviderDetail getOtherProviderDetail() {
        return otherProviderDetail;
    }

    public void setOtherProviderDetail(OtherProviderDetail otherProviderDetail) {
        this.otherProviderDetail = otherProviderDetail;
    }

    public PrimaryInsuranceDetail getPrimaryInsuranceDetail() {
        return primaryInsuranceDetail;
    }

    public void setPrimaryInsuranceDetail(PrimaryInsuranceDetail primaryInsuranceDetail) {
        this.primaryInsuranceDetail = primaryInsuranceDetail;
    }

    public PrimaryDiagnosisCode getPrimaryDiagnosisCode() {
        return primaryDiagnosisCode;
    }

    public void setPrimaryDiagnosisCode(PrimaryDiagnosisCode primaryDiagnosisCode) {
        this.primaryDiagnosisCode = primaryDiagnosisCode;
    }

    public List<SecondDiagnosisCode> getSecondDiagnosisCodeList() {
        return secondDiagnosisCodeList;
    }

    public void setSecondDiagnosisCodeList(List<SecondDiagnosisCode> secondDiagnosisCodeList) {
        this.secondDiagnosisCodeList = secondDiagnosisCodeList;
    }

    public SkilledNursing getSkilledNursing() {
        return skilledNursing;
    }

    public void setSkilledNursing(SkilledNursing skilledNursing) {
        this.skilledNursing = skilledNursing;
    }

    public HomeHealthAide getHomeHealthAide() {
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

    public OccupationTherapy getOccupationTherapy() {
        return occupationTherapy;
    }

    public void setOccupationTherapy(OccupationTherapy occupationTherapy) {
        this.occupationTherapy = occupationTherapy;
    }

    public GuarenterDetails getGuarenterDetails() {
        return guarenterDetails;
    }

    public void setGuarenterDetails(GuarenterDetails guarenterDetails) {
        this.guarenterDetails = guarenterDetails;
    }

    @Override
    public String toString() {
        return "AddPatientModel{" +
                "demographics=" + demographics +
                ", addressDetail=" + addressDetail +
                ", admissionSource=" + admissionSource +
                ", otherProviderDetail=" + otherProviderDetail +
                ", primaryInsuranceDetail=" + primaryInsuranceDetail +
                ", primaryDiagnosisCode=" + primaryDiagnosisCode +
                ", secondDiagnosisCodeList=" + secondDiagnosisCodeList +
                ", skilledNursing=" + skilledNursing +
                ", homeHealthAide=" + homeHealthAide +
                ", medicalSocialWork=" + medicalSocialWork +
                ", physicalTherapy=" + physicalTherapy +
                ", speechPathology=" + speechPathology +
                ", occupationTherapy=" + occupationTherapy +
                ", guarenterDetails=" + guarenterDetails +
                '}';
    }
}
