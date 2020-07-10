package com.edination.api.rap.Dao;

import com.edination.api.rap.model.ConditionCodeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConditionCodeDetailRepository extends JpaRepository<ConditionCodeDetail,Integer> {
}
