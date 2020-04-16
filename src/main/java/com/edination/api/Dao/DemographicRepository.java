package com.edination.api.Dao;

import com.edination.api.eligibility.model.Demographics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemographicRepository extends JpaRepository<Demographics,String> {
}
