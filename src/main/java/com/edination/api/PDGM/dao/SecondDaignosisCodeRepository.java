package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.SecondDiagnosisCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecondDaignosisCodeRepository extends JpaRepository<SecondDiagnosisCode,Integer> {
    @Query(value="FROM SecondDiagnosisCode WHERE mrn_number = ?1")
    public List<SecondDiagnosisCode> findSecondDiagnosisCodeByMrn(String mrnNumber);


}
