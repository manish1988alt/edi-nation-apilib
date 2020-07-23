package com.edination.api.Dao;

import com.edination.api.preAuthorisation.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode,String> {

    @Query(value = "SELECT a.* FROM (SELECT * FROM episode c WHERE c.mrn_number = ?1 ORDER BY c.id DESC ) a WHERE a.id= (SELECT max(e.id) FROM episode e WHERE e.mrn_number = ?1)",nativeQuery = true)
    List<Episode> findByMrnNumberEpisode(String mrnNumber);
}
