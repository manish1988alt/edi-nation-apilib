package com.edination.api.rap.Dao;

import com.edination.api.rap.model.TreatmentAuthorizationDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentAuthorizationDetailsRepository extends JpaRepository<TreatmentAuthorizationDetails,Integer> {
}
