package com.edination.api.preAuthorisation.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreAuthorizationResponseHistoryRepository extends JpaRepository<PreAuthorizationResponseHistory,Integer>
{

    @Query("FROM PreAuthorizationResponseHistory c WHERE mrn_number = ?1 ORDER BY c.id DESC")
    List<PreAuthorizationResponseHistory> findByMrnNumber(String mrnNumber);
}
