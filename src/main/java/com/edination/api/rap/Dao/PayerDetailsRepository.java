package com.edination.api.rap.Dao;

import com.edination.api.rap.model.PayerDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PayerDetailsRepository extends JpaRepository<PayerDetails,Integer> {
}
