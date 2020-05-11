package com.edination.api.Dao;

import com.edination.api.preAuthorisation.model.PreAuthDemographics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreAuthDemographicsRepository   extends JpaRepository<PreAuthDemographics,String> {
}
