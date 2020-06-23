package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.M1800;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface M1800Repository  extends JpaRepository<M1800,Integer> {

    @Query(value = "SELECT d.* FROM (SELECT a.* FROM (SELECT * FROM m1800 c WHERE c.mrn_number =?1 ORDER BY c.m1800id DESC ) a LIMIT 4)  d WHERE d.mrn_number =?1 ORDER BY d.m1800id ASC" ,nativeQuery = true)
    List<M1800> findM1800ByMrnNumber(String mrnNumber);

    @Modifying
    @Query(value="DELETE FROM m1800 s WHERE s.mrn_number = ?1",nativeQuery = true)
    public void deletedM1800ByMrn(String mrnNumber);
}
