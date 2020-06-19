package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.HippsCodeAndCaseMixWeight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HippsCodeAndCaseMixWeightRepository extends JpaRepository<HippsCodeAndCaseMixWeight,String> {

    @Query(value="FROM HippsCodeAndCaseMixWeight WHERE mrn_number = ?1")
    public List<HippsCodeAndCaseMixWeight> findHippsCodeAndCaseMixWeighByMrn(String mrnNumber);
}
