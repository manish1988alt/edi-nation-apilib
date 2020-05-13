package com.edination.api.Dao;

import com.edination.api.preAuthorisation.model.OccupationTherapy;
import com.edination.api.preAuthorisation.model.RequestService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestServiceRepository extends JpaRepository<RequestService,Integer> {
    @Query("FROM RequestService c WHERE mrn_number = ?1 ORDER BY c.id DESC")
    List<RequestService> findByMrnNumber(String mrnNumber);

}
