package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.M1830;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface M1830Repository extends JpaRepository<M1830,Integer> {

    @Query(value = "SELECT d.* FROM (SELECT a.* FROM (SELECT * FROM m1830 c WHERE c.mrn_number =?1 ORDER BY c.m1830id DESC ) a LIMIT 7) d WHERE d.mrn_number =?1 ORDER BY d.m1830id ASC" ,nativeQuery = true)
    List<M1830> findM1830ByMrnNumber(String mrnNumber);

    @Modifying
    @Query(value="DELETE FROM m1830 s WHERE s.mrn_number = ?1",nativeQuery = true)
    public void deletedM1830ByMrn(String mrnNumber);
}
