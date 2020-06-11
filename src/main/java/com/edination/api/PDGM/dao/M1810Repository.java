package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.M1810;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface M1810Repository extends JpaRepository<M1810,Integer> {
    @Query(value = "SELECT d.* FROM (SELECT a.* FROM (SELECT * FROM m1810 c WHERE c.mrn_number =?1 ORDER BY c.m1810id DESC ) a LIMIT 4) d WHERE d.mrn_number =?1 ORDER BY d.m1810id ASC" ,nativeQuery = true)
    List<M1810> findM1810ByMrnNumber(String mrnNumber);
}
