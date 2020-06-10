package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.M1850;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface M1850Repository  extends JpaRepository<M1850,Integer> {

    @Query(value = "SELECT a.* FROM (SELECT * FROM m1850 c WHERE c.mrn_number ='P100' ORDER BY c.m1850id DESC ) a LIMIT 6" ,nativeQuery = true)
    List<M1850> findM1850ByMrnNumber(String mrnNumber);
}
