package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.M1033;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface M1033Repository extends JpaRepository<M1033,Integer> {


    @Query(value = "SELECT a.* FROM (SELECT * FROM m1033 c WHERE c.mrn_number ='P100' ORDER BY c.m1033id DESC ) a LIMIT 10" ,nativeQuery = true)
    List<M1033> findM1033ByMrnNumber(String mrnNumber);

}
