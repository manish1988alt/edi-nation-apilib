package com.edination.api.Dao;

import com.edination.api.eligibility.model.Demographics;
import com.edination.api.eligibility.model.EdiDataElement271;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EDI271Repository extends JpaRepository<EdiDataElement271,String> {

    @Query("FROM EdiDataElement271 WHERE mrn_number = ?1")
    List<EdiDataElement271> findByMrnNumber(String mrnNumber);
}
