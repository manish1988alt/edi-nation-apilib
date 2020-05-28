package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.PDGMRapListing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PDGMRapListRepository extends JpaRepository<PDGMRapListing,String> {
}
