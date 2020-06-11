package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.M1860;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface M1860Repository  extends JpaRepository<M1860,Integer> {

    @Query(value = "SELECT d.* FROM (SELECT a.* FROM (SELECT * FROM m1860 c WHERE c.mrn_number =?1 ORDER BY c.m1860id DESC ) a LIMIT 7) d WHERE d.mrn_number =?1 ORDER BY d.m1860id ASC" ,nativeQuery = true)
    List<M1860> findM1860ByMrnNumber(String mrnNumber);
}
