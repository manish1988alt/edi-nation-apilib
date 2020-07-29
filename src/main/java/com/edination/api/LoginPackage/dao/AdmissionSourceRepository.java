package com.edination.api.LoginPackage.dao;

import com.edination.api.PDGM.model.AdmissionSource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdmissionSourceRepository extends JpaRepository<AdmissionSource,String> {
}
