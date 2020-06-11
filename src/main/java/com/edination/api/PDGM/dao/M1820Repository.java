package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.M1820;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface M1820Repository extends JpaRepository<M1820,Integer> {

    @Query(value = "SELECT d.* FROM (SELECT a.* FROM (SELECT * FROM m1820 c WHERE c.mrn_number =?1 ORDER BY c.m1820id DESC ) a LIMIT 4) d WHERE d.mrn_number =?1 ORDER BY d.m1820id ASC" ,nativeQuery = true)
    List<M1820> findM1820ByMrnNumber(String mrnNumber);
}
