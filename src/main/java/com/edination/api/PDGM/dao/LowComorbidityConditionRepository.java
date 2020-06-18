package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.LowComorbidityCondition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LowComorbidityConditionRepository extends JpaRepository<LowComorbidityCondition,Integer> {
}
