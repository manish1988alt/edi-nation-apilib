package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.EpisodeDetail;
import com.edination.api.PDGM.model.TimingAndSourceOfAdmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EpisodeDetailRepository extends JpaRepository<EpisodeDetail,String> {
    @Query(value="FROM EpisodeDetail WHERE mrn_number = ?1")
    public List<EpisodeDetail> findEpisodeByMrn(String mrnNumber);
}
