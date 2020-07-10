package com.edination.api.rap.Dao;

import com.edination.api.rap.model.OccuranceAndDate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OccuranceAndDateRepository extends JpaRepository<OccuranceAndDate,Integer> {
}
