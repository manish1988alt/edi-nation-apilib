package com.edination.api.rap.Dao;

import com.edination.api.rap.model.CountOfAddedValueInRap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountOfAddedValueInRapRepository extends JpaRepository<CountOfAddedValueInRap,String> {
}
