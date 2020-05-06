package com.edination.api.Dao;

import com.edination.api.eligibility.model.InsuranceDetailByPolicy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceDetailByPolicyServiceRepository extends JpaRepository<InsuranceDetailByPolicy,Integer> {
}
