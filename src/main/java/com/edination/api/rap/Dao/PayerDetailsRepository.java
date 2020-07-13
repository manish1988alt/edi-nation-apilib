package com.edination.api.rap.Dao;

import com.edination.api.rap.model.PayerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PayerDetailsRepository extends JpaRepository<PayerDetails,Integer> {

    @Query(value = "SELECT a.* FROM (SELECT * FROM payer_details c WHERE c.mrn_number = ?1 AND count=?2 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM payer_details e WHERE e.mrn_number = ?1 AND count=?2) ",nativeQuery = true)
     PayerDetails findPayerDetailsByMrnNumber(String mrnNumber,int count);
}
