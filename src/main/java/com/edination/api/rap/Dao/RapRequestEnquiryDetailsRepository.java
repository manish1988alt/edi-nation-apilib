package com.edination.api.rap.Dao;

import com.edination.api.rap.model.RapRequestEnquiryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RapRequestEnquiryDetailsRepository extends JpaRepository<RapRequestEnquiryDetails,Integer> {

    @Query(value = "SELECT a.* FROM (SELECT * FROM rap_request_enquiry_details c WHERE c.mrn_number = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM rap_request_enquiry_details e WHERE e.mrn_number = ?1) ",nativeQuery = true)
    RapRequestEnquiryDetails findRapRequestEnquiryDetailsByMrnNumber(String mrnNumber);
}
