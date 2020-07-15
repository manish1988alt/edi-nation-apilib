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

    @Query(value="SELECT *  FROM servicing_provider_person where id=?1",nativeQuery = true)
    ServicingProviderPerson findServicingProviderPerson(String id);

    @Query("FROM ServicingProviderFacility")
    List<ServicingProviderFacility> servicingProviderFacilityList();

    @Query(value="SELECT *  FROM servicing_provider_facility where id=?1",nativeQuery = true)
    ServicingProviderFacility findServicingProviderFacility(String id);

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

    //@Query("FROM RapRequestForm WHERE patient_mrn=?1")
    @Query(value = "SELECT a.* FROM (SELECT * FROM rap_request_form c WHERE c.patient_mrn = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM rap_request_form e WHERE e.patient_mrn = ?1) ",nativeQuery = true)
    RapRequestForm rapRequestFormView(String mrnNumber);

    @Query("FROM ValueCodeDetail WHERE mrn_number =?1")
    List<ValueCodeDetail> findValueCodeDetailByMrnNumber(String mrnNumber);

    //@Query("FROM  ConditionCodeDetail  WHERE mrn_number =?1 ")
    @Query(value= "SELECT d.* FROM (SELECT a.* FROM (SELECT * FROM condition_code_detail c WHERE c.mrn_number =?1 ORDER BY c.id DESC ) a LIMIT ?2)  d WHERE d.mrn_number =?1 ORDER BY d.id ASC",nativeQuery = true)
    List<ConditionCodeDetail> findConditionCodeDetailByMrnNumber(String mrnNumber,int count);

    @Query("FROM  OccuranceAndDate  WHERE mrn_number =?1 ")
    List<OccuranceAndDate> findOccuranceAndDateByMrnNumber(String mrnNumber);

/*   // @Query("FROM  BillingDetails  WHERE mrn_number =?1 ")
    @Query(value = "SELECT a.* FROM (SELECT * FROM billing_details c WHERE c.mrn_number = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM billing_details e WHERE e.mrn_number = ?1) ",nativeQuery = true)
    List<BillingDetails> findBillingDetailsByMrnNumber(String mrnNumber);*/

    /*@Query("FROM  PayerDetails  WHERE mrn_number =?1 ")
    List<PayerDetails> findPayerDetailsByMrnNumber(String mrnNumber);*/

 /*   @Query("FROM  InsuredDetails  WHERE mrn_number =?1 ")
    List<InsuredDetails> findInsuredDetailsByMrnNumber(String mrnNumber);*/

    @Query("FROM  PrimaryDiagnosisCode  WHERE mrn_number =?1 ")
    PrimaryDiagnosisCode findPrimaryDiagnosisCodeByMrnNumber(String mrnNumber);

    @Query("FROM  OtherProviderDetail  WHERE mrn_number =?1 ")
    List<OtherProviderDetail> findOtherProviderDetailByMrnNumber(String mrnNumber);

    @Query("FROM  TreatmentAuthorizationDetails  WHERE mrn_number =?1 ")
    List<TreatmentAuthorizationDetails> findTreatmentAuthorizationDetailsByMrnNumber(String mrnNumber);

    /*@Query("FROM  RapRequestEnquiryDetails  WHERE mrn_number =?1 ")
    RapRequestEnquiryDetails findRapRequestEnquiryDetailsByMrnNumber(String mrnNumber);*/
}
