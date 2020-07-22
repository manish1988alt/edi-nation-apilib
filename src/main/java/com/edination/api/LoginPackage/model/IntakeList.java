package com.edination.api.LoginPackage.model;


import com.edination.api.PDGM.model.AdmissionSource;
import com.edination.api.PDGM.model.EpisodeDetail;
import com.edination.api.eligibility.model.Demographics;
import com.edination.api.rap.model.PrimaryDiagnosisCode;

import java.util.List;

public class IntakeList {

    List<Demographics> demographicsList;
    List<AdmissionSource> admissionSourceList;
    List<PrimaryDiagnosisCode> primaryDiagnosisCodeList;
    List<EpisodeDetail> episodeDetailList;

    public IntakeList() {
    }

    public IntakeList(List<Demographics> demographicsList, List<AdmissionSource> admissionSourceList, List<PrimaryDiagnosisCode> primaryDiagnosisCodeList, List<EpisodeDetail> episodeDetailList) {
        this.demographicsList = demographicsList;
        this.admissionSourceList = admissionSourceList;
        this.primaryDiagnosisCodeList = primaryDiagnosisCodeList;
        this.episodeDetailList = episodeDetailList;
    }

    public List<Demographics> getDemographicsList() {
        return demographicsList;
    }

    public void setDemographicsList(List<Demographics> demographicsList) {
        this.demographicsList = demographicsList;
    }

    public List<AdmissionSource> getAdmissionSourceList() {
        return admissionSourceList;
    }

    public void setAdmissionSourceList(List<AdmissionSource> admissionSourceList) {
        this.admissionSourceList = admissionSourceList;
    }

    public List<PrimaryDiagnosisCode> getPrimaryDiagnosisCodeList() {
        return primaryDiagnosisCodeList;
    }

    public void setPrimaryDiagnosisCodeList(List<PrimaryDiagnosisCode> primaryDiagnosisCodeList) {
        this.primaryDiagnosisCodeList = primaryDiagnosisCodeList;
    }

    public List<EpisodeDetail> getEpisodeDetailList() {
        return episodeDetailList;
    }

    public void setEpisodeDetailList(List<EpisodeDetail> episodeDetailList) {
        this.episodeDetailList = episodeDetailList;
    }

    @Override
    public String toString() {
        return "IntakeList{" +
                "demographicsList=" + demographicsList +
                ", admissionSourceList=" + admissionSourceList +
                ", primaryDiagnosisCodeList=" + primaryDiagnosisCodeList +
                ", episodeDetailList=" + episodeDetailList +
                '}';
    }
}

