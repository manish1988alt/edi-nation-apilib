package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.AdmissionSource;
import com.edination.api.PDGM.model.EpisodeDetail;
import com.edination.api.PDGM.model.PDGMRapListing;
import com.edination.api.PDGM.model.TimingAndSourceOfAdmission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PDGMRapListRepository extends JpaRepository<PDGMRapListing,String> {



    @Query(value="FROM TimingAndSourceOfAdmission WHERE mrn_number = ?1")
    public List<TimingAndSourceOfAdmission> findTimingSourceByMrn(String mrnNumber);

    @Query(value="FROM AdmissionSource WHERE mrn_number = ?1")
    public AdmissionSource findAdmissionSourceByMrn(String mrnNumber);


}
