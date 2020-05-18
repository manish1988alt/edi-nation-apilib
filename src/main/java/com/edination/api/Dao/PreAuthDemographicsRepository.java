package com.edination.api.Dao;

import com.edination.api.preAuthorisation.model.HomeHealthPreAuthorizationForm;
import com.edination.api.preAuthorisation.model.PreAuthDemographics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PreAuthDemographicsRepository   extends JpaRepository<PreAuthDemographics,String> {

 /*   @Modifying
    @Query(value="UPDATE pre_auth_demographics  SET dob = homeHealthPreAuthorizationForm.getPreAuthDemographics().getDob(), first_name =homeHealthPreAuthorizationForm.getPreAuthDemographics().getFirstName(),gender=homeHealthPreAuthorizationForm.getPreAuthDemographics().getGender(),last_name=homeHealthPreAuthorizationForm.getPreAuthDemographics().getLastName(),middle_name=homeHealthPreAuthorizationForm.getPreAuthDemographics().getMiddleName(),ssn=homeHealthPreAuthorizationForm.getPreAuthDemographics().getSsn(),suffix=homeHealthPreAuthorizationForm.getPreAuthDemographics().getSuffix()\n" +
            "            WHERE mrn_number =homeHealthPreAuthorizationForm.getPreAuthDemographics().getMrnNumber()",nativeQuery=true)
    PreAuthDemographics updateDemographics(HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm);*/

}
