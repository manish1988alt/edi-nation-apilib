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

    @Query("FROM ValueCode")
    List<ValueCode> valueCodesList();

    @Query("FROM OccuranceCode")
    List<OccuranceCode> occuranceCodesList();

    @Query("FROM DischargeStatusCode")
    List<DischargeStatusCode> dischargeStatusCodeList();

    @Query("FROM SourceOfReferral")
    List<SourceOfReferral> sourceOfReferralList();

    @Query("FROM TypeOfBillCode")
    List<TypeOfBillCode> typeOfBillCodeList();

    @Query("FROM TypeOfVisitCode")
    List<TypeOfVisitCode> typeOfVisitCodeList();

    @Query("FROM RapRequestForm WHERE patient_mrn=?1")
    RapRequestForm rapRequestFormView(String mrnNumber);

    @Query("FROM ValueCodeDetail WHERE mrn_number =?1")
    List<ValueCodeDetail> findValueCodeDetailByMrnNumber(String mrnNumber);

    @Query("FROM  ConditionCodeDetail  WHERE mrn_number =?1 ")
    List<ConditionCodeDetail> findConditionCodeDetailByMrnNumber(String mrnNumber);

    @Query("FROM  OccuranceAndDate  WHERE mrn_number =?1 ")
    List<OccuranceAndDate> findOccuranceAndDateByMrnNumber(String mrnNumber);
}
