package com.edination.api.rap.Dao;

import com.edination.api.rap.model.OtherProviderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OtherProviderDetailRepository extends JpaRepository<OtherProviderDetail,Integer> {
}
