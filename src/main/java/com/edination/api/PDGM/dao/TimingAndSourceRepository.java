package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.EpisodeDetail;
import com.edination.api.PDGM.model.TimingAndSourceOfAdmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimingAndSourceRepository  extends JpaRepository<TimingAndSourceOfAdmission,String> {


}
