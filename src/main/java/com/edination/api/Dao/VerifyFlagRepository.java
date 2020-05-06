package com.edination.api.Dao;

import com.edination.api.eligibility.model.VerifyFlag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerifyFlagRepository extends JpaRepository<VerifyFlag,String> {
}
