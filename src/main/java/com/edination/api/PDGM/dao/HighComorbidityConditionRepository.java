package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.ComorbidityTypeAndHippsCode;
import com.edination.api.PDGM.model.HighComorbidityCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HighComorbidityConditionRepository extends JpaRepository<HighComorbidityCondition,Integer> {

    @Query(value="FROM ComorbidityTypeAndHippsCode WHERE mrn_number = ?1")
    public ComorbidityTypeAndHippsCode findComorbidityTypeByMrn(String mrnNumber);
}
