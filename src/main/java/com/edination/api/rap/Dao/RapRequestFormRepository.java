package com.edination.api.rap.Dao;

import com.edination.api.preAuthorisation.MasterCode.ProviderCodeMaster;
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

    @Query("FROM ProviderCodeMaster")
    List<ProviderCodeMaster> otherProviderList();

    @Query("FROM OtherProviderList WHERE provider_type=?1")
    List<OtherProviderList> OtherProviderList(String providerType);

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

    @Query("FROM AttendingProviderDetail")
    List<AttendingProviderDetail> attendingProviderDetailList();

    @Query("FROM RapRequestForm WHERE patient_mrn=?1")
    RapRequestForm rapRequestFormView(String mrnNumber);

    @Query("FROM ValueCodeDetail WHERE mrn_number =?1")
    List<ValueCodeDetail> findValueCodeDetailByMrnNumber(String mrnNumber);

    @Query("FROM  ConditionCodeDetail  WHERE mrn_number =?1 ")
    List<ConditionCodeDetail> findConditionCodeDetailByMrnNumber(String mrnNumber);

    @Query("FROM  OccuranceAndDate  WHERE mrn_number =?1 ")
    List<OccuranceAndDate> findOccuranceAndDateByMrnNumber(String mrnNumber);

    @Query("FROM  BillingDetails  WHERE mrn_number =?1 ")
    List<BillingDetails> findBillingDetailsByMrnNumber(String mrnNumber);

    @Query("FROM  PayerDetails  WHERE mrn_number =?1 ")
    PayerDetails findPayerDetailsByMrnNumber(String mrnNumber);

    @Query("FROM  InsuredDetails  WHERE mrn_number =?1 ")
    InsuredDetails findInsuredDetailsByMrnNumber(String mrnNumber);

    @Query("FROM  PrimaryDiagnosisCode  WHERE mrn_number =?1 ")
    PrimaryDiagnosisCode findPrimaryDiagnosisCodeByMrnNumber(String mrnNumber);

    @Query("FROM  OtherProviderDetail  WHERE mrn_number =?1 ")
    List<OtherProviderDetail> findOtherProviderDetailByMrnNumber(String mrnNumber);
}
