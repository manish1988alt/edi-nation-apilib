package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OasisItemContributedRepository  extends JpaRepository<OASISItemContributed,Integer> {

    @Query("FROM OASISItemContributed WHERE mrn_numbe = ?1")
    List<OASISItemContributed> findByMrnNumber(String mrnNumber);

    @Query("FROM M1033 WHERE mrn_number = ?1")
    List<M1033> findM1033ByMrnNumber(String mrnNumber);

    @Query("FROM M1800 WHERE mrn_number = ?1")
    List<M1800> findM1800ByMrnNumber(String mrnNumber);

    @Query("FROM M1810 WHERE mrn_number = ?1")
    List<M1810> findM1810ByMrnNumber(String mrnNumber);

    @Query("FROM M1820 WHERE mrn_number = ?1")
    List<M1820> findM1820ByMrnNumber(String mrnNumber);

    @Query("FROM M1830 WHERE mrn_number = ?1")
    List<M1830> findM1830ByMrnNumber(String mrnNumber);

    @Query("FROM M1840 WHERE mrn_number = ?1")
    List<M1840> findM1840ByMrnNumber(String mrnNumber);

    @Query("FROM M1850 WHERE mrn_number = ?1")
    List<M1850> findM1850ByMrnNumber(String mrnNumber);

    @Query("FROM M1860 WHERE mrn_number = ?1")
    List<M1860> findM1860ByMrnNumber(String mrnNumber);
}
