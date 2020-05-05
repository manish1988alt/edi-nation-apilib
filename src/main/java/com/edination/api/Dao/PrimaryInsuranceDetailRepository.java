package com.edination.api.Dao;

import com.edination.api.eligibility.model.PrimaryInsuranceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PrimaryInsuranceDetailRepository  extends JpaRepository<PrimaryInsuranceDetail,String> {

    @Query("FROM PrimaryInsuranceDetail c WHERE mrn_number = ?1 ORDER BY c.id DESC")
    List<PrimaryInsuranceDetail> findByMrnNumber(String mrnNumber);

    @Query(value = "SELECT a.* FROM (SELECT * FROM insurance_detail c WHERE c.mrn_number = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM member_insurance_eligibility e WHERE e.mrn_number = ?1) ",nativeQuery = true)
    List<PrimaryInsuranceDetail> findByID(String mrnNumber);
}
