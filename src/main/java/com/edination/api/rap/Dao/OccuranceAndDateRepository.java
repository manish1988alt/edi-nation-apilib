package com.edination.api.rap.Dao;

import com.edination.api.rap.model.OccuranceAndDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OccuranceAndDateRepository extends JpaRepository<OccuranceAndDate,Integer> {

    @Query(value= "SELECT d.* FROM (SELECT a.* FROM (SELECT * FROM occurance_and_date c WHERE c.mrn_number =?1 ORDER BY c.id DESC ) a LIMIT ?2)  d WHERE d.mrn_number =?1 ORDER BY d.id ASC",nativeQuery = true)
    List<OccuranceAndDate> findOccuranceAndDateByMrnNumber(String mrnNumber, int count);
}
