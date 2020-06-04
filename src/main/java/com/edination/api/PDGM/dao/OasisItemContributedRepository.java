package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.OASISItemContributed;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OasisItemContributedRepository  extends JpaRepository<OASISItemContributed,String> {
}
