package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.M1800;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface M1800Repository  extends JpaRepository<M1800,Integer> {

    @Query(value = "SELECT a.* FROM (SELECT * FROM m1800 c WHERE c.mrn_number ='P100' ORDER BY c.m1800id DESC ) a LIMIT 4" ,nativeQuery = true)
    List<M1800> findM1800ByMrnNumber(String mrnNumber);
}
