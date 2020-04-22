package com.edination.api.Dao;

import com.edination.api.eligibility.model.Demographics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemographicRepository extends JpaRepository<Demographics,String> {
    //@Query(value="select first_name, last_name from demographics u where mrnNumber=:mrnNumber", nativeQuery=true)
    @Query("SELECT d.firstName,d.lastName FROM Demographics d WHERE mrn_number = ?1")
    List<Demographics> findByMrnNumber(String mrnNumber);
}
