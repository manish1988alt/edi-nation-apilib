package com.edination.api.Dao;

import com.edination.api.preAuthorisation.model.PreAuthDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreAuthRepository extends JpaRepository<PreAuthDetail,String> {
}
