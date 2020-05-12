package com.edination.api.Dao;

import com.edination.api.preAuthorisation.model.HomeHealthPreAuthorizationForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeHealthPreAuthFormRepository extends JpaRepository<HomeHealthPreAuthorizationForm,String> {

    @Query("FROM HomeHealthPreAuthorizationForm c WHERE mrn_number = ?1 ORDER BY c.id DESC")
    List<HomeHealthPreAuthorizationForm> findByMrnNumber(String mrnNumber);
}
