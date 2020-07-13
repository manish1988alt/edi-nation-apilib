package com.edination.api.rap.Dao;

import com.edination.api.rap.model.InsuredDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuredDetailsRepository extends JpaRepository<InsuredDetails,Integer> {

    @Query(value = "SELECT a.* FROM (SELECT * FROM insured_details c WHERE c.mrn_number = ?1 AND count=?2 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM insured_details e WHERE e.mrn_number = ?1 AND count=?2) ",nativeQuery = true)
    InsuredDetails findInsuredDetailsByMrnNumber(String mrnNumber,int count);
}
