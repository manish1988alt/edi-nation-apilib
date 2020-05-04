package com.edination.api.Dao;

import com.edination.api.eligibility.model.MemberInsuranceEligibility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public interface MemberInsuranceRepository extends JpaRepository<MemberInsuranceEligibility,String> {


   // public EntityManager entityManager=null;

    @Query("FROM MemberInsuranceEligibility c WHERE mrn_number = ?1 ORDER BY c.id DESC")
    List<MemberInsuranceEligibility> findByMrnNumber(String mrnNumber);

    @Query(value = "SELECT a.* FROM (SELECT * FROM member_insurance_eligibility c WHERE c.mrn_number = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM member_insurance_eligibility e WHERE e.mrn_number = ?1) ",nativeQuery = true)
    List<MemberInsuranceEligibility> findByID(String mrnNumber);




/*    Page<MemberInsuranceEligibility> page = Repository.findAll(
              PageRequest.of(0, 1, Sort.by(Sort.Direction.ASC, "seatNumber")));

@Query("SELECT p FROM MemberInsuranceEligibility p ORDER BY p.id DESC", MemberInsuranceEligibility.class.setMaxResults(limit).getResultList())
     List<MemberInsuranceEligibility> findOrderedByID(int limit) ;*/
}
