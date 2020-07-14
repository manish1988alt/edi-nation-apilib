package com.edination.api.rap.Dao;

import com.edination.api.rap.model.TreatmentAuthorizationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TreatmentAuthorizationDetailsRepository extends JpaRepository<TreatmentAuthorizationDetails,Integer> {
    //SELECT d.* FROM (SELECT * FROM treatment_authorization_details c WHERE c.mrn_number ='P100' LIMIT 3)  d WHERE d.mrn_number ='P100' ORDER BY d.id ASC

    @Query(value= "SELECT d.* FROM (SELECT a.* FROM (SELECT * FROM treatment_authorization_details c WHERE c.mrn_number =?1 ORDER BY c.id DESC ) a LIMIT ?2)  d WHERE d.mrn_number =?1 ORDER BY d.id ASC",nativeQuery = true)
    List<TreatmentAuthorizationDetails> findTreatmentAuthorizationDetailsByMrnNumber(String mrnNumber, int count);
}
