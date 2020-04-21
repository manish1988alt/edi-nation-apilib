package com.edination.api.Dao;

import com.edination.api.eligibility.model.MemberInsuranceEligibility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberInsuranceRepository extends JpaRepository<MemberInsuranceEligibility,String> {


}
