package com.edination.api.Dao;

import com.edination.api.eligibility.model.MemberInsuranceEligibility;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberInsuranceRepository extends JpaRepository<MemberInsuranceEligibility,String> {

    @Query("FROM MemberInsuranceEligibility WHERE mrn_number = ?1")
    List<MemberInsuranceEligibility> findByMrnNumber(String mrnNumber);
}
