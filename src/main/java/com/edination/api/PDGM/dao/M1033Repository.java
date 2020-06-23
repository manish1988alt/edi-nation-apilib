package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.M1033;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface M1033Repository extends JpaRepository<M1033,Integer> {


  /*  @Query(value = "SELECT d.* FROM (SELECT a.* FROM (SELECT * FROM m1033 c WHERE c.mrn_number =?1 ORDER BY c.m1033id DESC ) a LIMIT 10)  d WHERE d.mrn_number =?1 ORDER BY d.m1033id ASC" ,nativeQuery = true)
    List<M1033> findM1033ByMrnNumber(String mrnNumber);*/

    @Query(value = "SELECT d.* FROM  m1033  d WHERE d.mrn_number =?1 ORDER BY d.id ASC" ,nativeQuery = true)
    List<M1033> findM1033ByMrnNumber(String mrnNumber);

    @Modifying
    @Query(value="DELETE FROM m1033 s WHERE s.mrn_number = ?1",nativeQuery = true)
    public void deletedM1033ByMrn(String mrnNumber);

}
