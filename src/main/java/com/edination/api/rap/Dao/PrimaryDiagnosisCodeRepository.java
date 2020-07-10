package com.edination.api.rap.Dao;

import com.edination.api.rap.model.PrimaryDiagnosisCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrimaryDiagnosisCodeRepository extends JpaRepository<PrimaryDiagnosisCode,String> {
}
