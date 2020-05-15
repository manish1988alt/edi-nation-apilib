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

    @Query(value = "SELECT a.* FROM (SELECT * FROM pre_auth_detail c  ORDER BY c.pre_auth_id DESC ) a WHERE a.pre_auth_id= (SELECT max(e.pre_auth_id) FROM pre_auth_detail e ) ",nativeQuery = true)
    List<PreAuthDetail> findByID();
}
