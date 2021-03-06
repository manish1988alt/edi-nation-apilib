package com.edination.api.Dao;

import com.edination.api.preAuthorisation.model.HomeHealthPreAuthorizationForm;
import com.edination.api.preAuthorisation.model.PreAuthDemographics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface PreAuthDemographicsRepository   extends JpaRepository<PreAuthDemographics,Integer> {

 /*   @Modifying
    @Query(value="UPDATE pre_auth_demographics  SET dob = homeHealthPreAuthorizationForm.getPreAuthDemographics().getDob(), first_name =homeHealthPreAuthorizationForm.getPreAuthDemographics().getFirstName(),gender=homeHealthPreAuthorizationForm.getPreAuthDemographics().getGender(),last_name=homeHealthPreAuthorizationForm.getPreAuthDemographics().getLastName(),middle_name=homeHealthPreAuthorizationForm.getPreAuthDemographics().getMiddleName(),ssn=homeHealthPreAuthorizationForm.getPreAuthDemographics().getSsn(),suffix=homeHealthPreAuthorizationForm.getPreAuthDemographics().getSuffix()\n" +
            "            WHERE mrn_number =homeHealthPreAuthorizationForm.getPreAuthDemographics().getMrnNumber()",nativeQuery=true)
    PreAuthDemographics updateDemographics(HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm);*/
   // @Query(value="SELECT DISTINCT mrn_number FROM pre_auth_demographics ORDER BY id",nativeQuery=true)
    @Query(value = "FROM PreAuthDemographics")
    List<PreAuthDemographics> uniqueDemographics();

    @Query(value = "SELECT a.* FROM (SELECT * FROM pre_auth_demographics c WHERE c.mrn_number = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM pre_auth_demographics e WHERE e.mrn_number = ?1) ",nativeQuery = true)
    PreAuthDemographics findByMrnNumber(String mrnNumber);


}
