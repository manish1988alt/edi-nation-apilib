package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.M1850;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface M1850Repository  extends JpaRepository<M1850,Integer> {

    @Query(value = "SELECT d.* FROM (SELECT a.* FROM (SELECT * FROM m1850 c WHERE c.mrn_number =?1 ORDER BY c.m1850id DESC ) a LIMIT 6) d WHERE d.mrn_number =?1 ORDER BY d.m1850id ASC" ,nativeQuery = true)
    List<M1850> findM1850ByMrnNumber(String mrnNumber);

    @Modifying
    @Query(value="DELETE FROM m1850 s WHERE s.mrn_number = ?1",nativeQuery = true)
    public void deletedM1850ByMrn(String mrnNumber);
}
