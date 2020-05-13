package com.edination.api.Dao;

import com.edination.api.preAuthorisation.model.PreAuthDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreAuthRepository extends JpaRepository<PreAuthDetail,String> {

    @Query("FROM PreAuthDetail WHERE mrn_number = ?1")
    List<PreAuthDetail> findByMrnNumber(String mrnNumber);
}
