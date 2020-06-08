package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.OASISItemContributed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OasisItemContributedRepository  extends JpaRepository<OASISItemContributed,Integer> {

    @Query("FROM OASISItemContributed WHERE mrn_numbe = ?1")
    List<OASISItemContributed> findByMrnNumber(String mrnNumber);
}
