package com.edination.api.Dao;

import com.edination.api.preAuthorisation.model.PreAuthorizationResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreAuthorizationResponseRepository extends JpaRepository<PreAuthorizationResponse,Integer> {
    @Query("FROM PreAuthorizationResponse c WHERE mrn_number = ?1 ORDER BY c.id DESC")
    List<PreAuthorizationResponse> findByMrnNumber(String mrnNumber);

    @Query(value = "SELECT a.* FROM (SELECT * FROM pre_authorization_response c WHERE c.mrn_number = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM pre_authorization_response e WHERE e.mrn_number = ?1) ",nativeQuery = true)
    List<PreAuthorizationResponse> findByID(String mrnNumber);
}
