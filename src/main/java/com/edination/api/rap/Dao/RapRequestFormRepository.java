package com.edination.api.rap.Dao;

import com.edination.api.rap.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RapRequestFormRepository extends JpaRepository<RapRequestForm,Integer> {

    @Query(" FROM ServicingProviderPerson")
    List<ServicingProviderPerson> servicingProviderPersonList();

    @Query("FROM ServicingProviderFacility")
    List<ServicingProviderFacility> servicingProviderFacilityList();

    @Query("FROM BillingProviderPerson")
    List<BillingProviderPerson> billingProviderPersonList();

    @Query("FROM BillingProviderFacility")
    List<BillingProviderFacility> billingProviderFacilityList();

    @Query("FROM ConditionCodes")
    List<ConditionCodes> conditionCodesList();
}
