package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.M1820;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface M1820Repository extends JpaRepository<M1820,Integer> {

    @Query(value = "SELECT a.* FROM (SELECT * FROM m1820 c WHERE c.mrn_number ='P100' ORDER BY c.m1820id DESC ) a LIMIT 4" ,nativeQuery = true)
    List<M1820> findM1820ByMrnNumber(String mrnNumber);
}
