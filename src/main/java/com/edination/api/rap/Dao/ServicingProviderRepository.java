package com.edination.api.rap.Dao;

import com.edination.api.rap.model.BillingProviderFacility;
import com.edination.api.rap.model.BillingProviderPerson;
import com.edination.api.rap.model.ServicingProviderFacility;
import com.edination.api.rap.model.ServicingProviderPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicingProviderRepository extends JpaRepository<ServicingProviderPerson,String> {
    @Query(value="SELECT *  FROM servicing_provider_person where id=?1",nativeQuery = true)
    ServicingProviderPerson findServicingProviderPerson(String id);

    @Query(value="SELECT *  FROM servicing_provider_facility where id=?1",nativeQuery = true)
    ServicingProviderFacility findServicingProviderFacility(String id);

    @Query("FROM BillingProviderPerson where id=?1")
    BillingProviderPerson findBillingProviderPerson(String id);

    @Query(value="SELECT *  FROM billing_provider_facility where id=?1",nativeQuery = true)
    BillingProviderFacility findBillingProviderFacility(String id);
}
