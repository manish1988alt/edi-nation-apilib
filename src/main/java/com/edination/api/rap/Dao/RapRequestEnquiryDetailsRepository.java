package com.edination.api.rap.Dao;

import com.edination.api.rap.model.RapRequestEnquiryDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RapRequestEnquiryDetailsRepository extends JpaRepository<RapRequestEnquiryDetails,Integer> {
}
