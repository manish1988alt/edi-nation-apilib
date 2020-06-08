package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PDGMRapListRepository extends JpaRepository<PDGMRapListing,String> {



    @Query(value="FROM TimingAndSourceOfAdmission WHERE mrn_number = ?1")
    public List<TimingAndSourceOfAdmission> findTimingSourceByMrn(String mrnNumber);

    @Query(value="FROM AdmissionSource WHERE mrn_number = ?1")
    public AdmissionSource findAdmissionSourceByMrn(String mrnNumber);

    @Query(value="FROM ClinicalGroupingPrimaryDiagnosis WHERE primary_diagnosis_code = ?1")
    public List<ClinicalGroupingPrimaryDiagnosis> findClinicalGroupingPrimaryDiagnosis(String primaryDiagnosisCode);

    @Query(value="FROM CalculationClinicalGroupHIPPSCode WHERE clinical_sub_groupcode = ?1 AND function_score=?2")
    public List<CalculationClinicalGroupHIPPSCode> findCalculationClinicalGroupHIPPSCode(String clinicalSubGroupcode,int functionScore);


}
