package com.edination.api.Dao;

import com.edination.api.eligibility.model.TertiaryInsuranceDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TertiaryInsuranceDetailRepository extends JpaRepository<TertiaryInsuranceDetail,Integer> {


    @Query("FROM TertiaryInsuranceDetail c WHERE mrn_number = ?1 ORDER BY c.id DESC")
    List<TertiaryInsuranceDetail> findByMrnNumber(String mrnNumber);

    @Query(value = "SELECT a.* FROM (SELECT * FROM tertiary_insurance_detail c WHERE c.mrn_number = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM tertiary_insurance_detail e WHERE e.mrn_number = ?1) ",nativeQuery = true)
    List<TertiaryInsuranceDetail> findByID(String mrnNumber);
}
