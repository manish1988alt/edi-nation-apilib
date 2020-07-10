package com.edination.api.rap.Dao;

import com.edination.api.rap.model.InsuredDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuredDetailsRepository extends JpaRepository<InsuredDetails,Integer> {
}
