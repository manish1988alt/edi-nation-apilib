package com.edination.api.Dao;

import com.edination.api.preAuthorisation.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestServiceRepository extends JpaRepository<RequestService,Integer> {
    @Query("FROM RequestService c WHERE mrn_number = ?1 ORDER BY c.id DESC")
    List<RequestService> findByMrnNumber(String mrnNumber);

    @Query(value = "SELECT a.* FROM (SELECT * FROM request_service c WHERE c.mrn_number = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM request_service e WHERE e.mrn_number = ?1) ",nativeQuery = true)
    RequestService findRequestServiceByMrn(String mrnNumber);


    @Query(value = "SELECT a.* FROM (SELECT * FROM home_health_aide c WHERE c.mrn_number = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM home_health_aide e WHERE e.mrn_number = ?1) ",nativeQuery = true)
   HomeHealthAide findHomeHealthAideByMrn(String mrnNumber);

    @Query(value = "SELECT a.* FROM (SELECT * FROM occupation_therapy c WHERE c.mrn_number = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM occupation_therapy e WHERE e.mrn_number = ?1) ",nativeQuery = true)
    OccupationTherapy findOccupationTherapyByMrn(String mrnNumber);

    @Query(value = "SELECT a.* FROM (SELECT * FROM physical_therapy c WHERE c.mrn_number = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM physical_therapy e WHERE e.mrn_number = ?1) ",nativeQuery = true)
    PhysicalTherapy findPhysicalTherapyByMrn(String mrnNumber);

    @Query(value = "SELECT a.* FROM (SELECT * FROM medical_social_work c WHERE c.mrn_number = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM medical_social_work e WHERE e.mrn_number = ?1) ",nativeQuery = true)
    MedicalSocialWork findMedicalSocialWorkByMrn(String mrnNumber);

    @Query(value = "SELECT a.* FROM (SELECT * FROM speech_pathology c WHERE c.mrn_number = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM speech_pathology e WHERE e.mrn_number = ?1) ",nativeQuery = true)
    SpeechPathology findSpeechPathologyByMrn(String mrnNumber);

    @Query(value = "SELECT a.* FROM (SELECT * FROM skilled_nursing c WHERE c.mrn_number = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM skilled_nursing e WHERE e.mrn_number = ?1) ",nativeQuery = true)
    SkilledNursing findSkilledNursingByMrn(String mrnNumber);
}
