package com.edination.api.Dao;

import com.edination.api.preAuthorisation.model.Episode;
import com.edination.api.preAuthorisation.model.PreAuthDemographics;
import com.edination.api.preAuthorisation.model.PreAuthDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreAuthRepository extends JpaRepository<PreAuthDetail,String> {

    @Query("FROM PreAuthDetail WHERE mrn_number = ?1")
    List<PreAuthDetail> findByMrnNumber(String mrnNumber);

    @Query(value = "SELECT a.* FROM (SELECT * FROM pre_auth_detail c WHERE c.mrn_number = ?1 ORDER BY c.pre_auth_id DESC ) a WHERE a.pre_auth_id= (SELECT max(e.pre_auth_id) FROM pre_auth_detail e WHERE e.mrn_number = ?1) ",nativeQuery = true)
    List<PreAuthDetail> findByID(String mrnNumber);

    @Query(value = "SELECT a.* FROM (SELECT * FROM pre_auth_demographics c WHERE c.mrn_number = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM pre_auth_demographics e WHERE e.mrn_number = ?1) ",nativeQuery = true)
    PreAuthDemographics findByMrnNumberdemographics(String mrnNumber);

    @Query(value = "SELECT a.* FROM (SELECT * FROM episode c WHERE c.mrn_number = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM episode e WHERE e.mrn_number = ?1) AND a.admission_date<CURRENT_DATE+INTERVAL 365 DAY ORDER BY a.admission_date DESC",nativeQuery = true)
    Episode findByMrnNumberEpisode(String mrnNumber);

}
