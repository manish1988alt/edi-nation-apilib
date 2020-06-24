package com.edination.api.Dao;

import com.edination.api.eligibility.model.SecondaryInsuranceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecondaryInsuranceDetailRepository extends JpaRepository<SecondaryInsuranceDetail,String> {

    @Query("FROM SecondaryInsuranceDetail c WHERE mrn_number = ?1 ORDER BY c.id DESC")
    List<SecondaryInsuranceDetail> findByMrnNumber(String mrnNumber);

    @Query(value = "SELECT a.* FROM (SELECT * FROM secondary_insurance_detail c WHERE c.mrn_number = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM secondary_insurance_detail e WHERE e.mrn_number = ?1) ",nativeQuery = true)
    List<SecondaryInsuranceDetail> findByID(String mrnNumber);

    @Query(value = "SELECT a.eligibility FROM (SELECT * FROM secondary_insurance_detail c WHERE c.mrn_number = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM secondary_insurance_detail e WHERE e.mrn_number = ?1) ",nativeQuery = true)
    String findByIDEligibility(String mrnNumber);
}
