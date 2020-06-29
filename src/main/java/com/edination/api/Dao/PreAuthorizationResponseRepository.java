package com.edination.api.Dao;

import com.edination.api.preAuthorisation.model.PreAuthorizationResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PreAuthorizationResponseRepository extends JpaRepository<PreAuthorizationResponse,Integer> {
    @Query("FROM PreAuthorizationResponse c WHERE mrn_number = ?1 ORDER BY c.id DESC")
    List<PreAuthorizationResponse> findByMrnNumber(String mrnNumber);

    @Query(value = "SELECT  c.* FROM pre_authorization_response c WHERE c.mrn_number = ?1 AND c.enquiry_id=?2",nativeQuery = true)
    List<PreAuthorizationResponse> findByMrnNumberHistoryView(String mrnNumber,String enquiryId);


    @Query(value = "SELECT a.* FROM (SELECT * FROM pre_authorization_response c WHERE c.mrn_number = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM pre_authorization_response e WHERE e.mrn_number = ?1) ",nativeQuery = true)
    List<PreAuthorizationResponse> findByID(String mrnNumber);


    @Query(value ="SELECT c.discription FROM entity_identifier_code_master c WHERE code = ?1",nativeQuery = true)
    String findEntityIdentifierCode(String code);
    @Query(value ="SELECT c.discription FROM gender_code_master c WHERE code = ?1",nativeQuery = true)
    String findGenderCode(String code);

    @Query(value ="SELECT c.discription FROM identification_code_qualifier_master c  WHERE code = ?1",nativeQuery = true)
    String findIdentificationCodeQualifier(String code);

    @Query(value ="SELECT c.discription FROM reference_identification_qualifier_master c WHERE code = ?1",nativeQuery = true)
    String findReferenceIdentificationQualifier(String code);

    @Query(value ="SELECT c.discription FROM unit_or_basis_for_measurement_code_master c WHERE code = ?1",nativeQuery = true)
    String findUnitOrBasisForMeasurementCodeMaster(String code);

    @Query(value ="SELECT c.discription FROM certification_type_code_master c WHERE code = ?1",nativeQuery = true)
    String findCertificationTypeCodeMaster(String code);

    @Query(value ="SELECT c.discription FROM certification_action_code_master c WHERE code = ?1",nativeQuery = true)
    String findCertificationActionTypeCodeMaster(String code);

    @Query(value ="SELECT c.discription FROM entity_type_qualifier_master c WHERE code = ?1",nativeQuery = true)
    String findEntityTypeQualifierMaster(String code);

    @Query(value ="SELECT c.discription FROM service_type_code_master c WHERE code = ?1",nativeQuery = true)
    String findServiceTypeCodeMaster(String code);

    @Query(value ="SELECT c.discription FROM rejection_reason_code_master c WHERE code = ?1",nativeQuery = true)
    String findServiceTypeRejectionResion(String code);

    @Query(value ="SELECT c.discription FROM follow_up_action_code_master c WHERE code = ?1",nativeQuery = true)
    String findServiceFollowUpAction(String code);

    @Query(value ="SELECT c.discription FROM individual_relationship_code_master c WHERE code = ?1",nativeQuery = true)
    String findReletionship(String code);

    @Query(value ="SELECT c.discription FROM certification_type_code_master c WHERE code = ?1",nativeQuery = true)
    String findCertificatioType(String code);
    @Query(value ="SELECT c.discription FROM request_category_code_master c WHERE code = ?1",nativeQuery = true)
    String findRequestCategory(String code);



}
