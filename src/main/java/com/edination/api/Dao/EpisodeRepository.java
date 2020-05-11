package com.edination.api.Dao;

import com.edination.api.preAuthorisation.model.Episode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EpisodeRepository extends JpaRepository<Episode,String> {
}
