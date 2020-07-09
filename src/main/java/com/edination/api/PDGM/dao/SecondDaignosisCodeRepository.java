package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.SecondDiagnosisCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@Repository
@Transactional
public interface SecondDaignosisCodeRepository extends JpaRepository<SecondDiagnosisCode,Integer> {
    @Query(value="FROM SecondDiagnosisCode WHERE mrn_number = ?1")
    public Set<SecondDiagnosisCode> findSecondDiagnosisCodeByMrn(String mrnNumber);

    @Query(value="FROM SecondDiagnosisCode WHERE mrn_number = ?1")
    public List<SecondDiagnosisCode> findSecondDiagnosisListCodeByMrn(String mrnNumber);

    @Modifying
    @Query(value="DELETE FROM second_diagnosis_code s WHERE s.mrn_number = ?1",nativeQuery = true)
    public void deletedSecondDiagnosisCodeByMrn(String mrnNumber);


}
