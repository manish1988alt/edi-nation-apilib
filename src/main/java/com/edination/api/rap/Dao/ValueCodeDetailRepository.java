package com.edination.api.rap.Dao;

import com.edination.api.rap.model.ValueCodeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ValueCodeDetailRepository  extends JpaRepository<ValueCodeDetail,Integer> {
}
