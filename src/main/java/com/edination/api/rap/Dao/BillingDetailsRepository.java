package com.edination.api.rap.Dao;

import com.edination.api.rap.model.BillingDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillingDetailsRepository extends JpaRepository<BillingDetails,Integer> {
}
