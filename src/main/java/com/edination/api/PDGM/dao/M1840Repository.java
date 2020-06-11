package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.M1840;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface M1840Repository extends JpaRepository<M1840,Integer> {

    @Query(value = "SELECT d.* FROM (SELECT a.* FROM (SELECT * FROM m1840 c WHERE c.mrn_number =?1 ORDER BY c.m1840id DESC ) a LIMIT 4) d WHERE d.mrn_number =?1 ORDER BY d.m1840id ASC" ,nativeQuery = true)
    List<M1840> findM1840ByMrnNumber(String mrnNumber);
}
