package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.ComorbidityTypeAndHippsCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ComorbidityTypeAndHippsCodeRepository extends JpaRepository<ComorbidityTypeAndHippsCode,String> {
    @Query(value="FROM ComorbidityTypeAndHippsCode WHERE mrn_number = ?1")
    public ComorbidityTypeAndHippsCode findComorbidityTypeByMrn(String mrnNumber);
}
