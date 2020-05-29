package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.EpisodeDetail;
import com.edination.api.PDGM.model.TimingAndSourceOfAdmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EpisodeDetailService {
@Autowired
EpisodeDetailRepository episodeDetailRepository;
    public List<EpisodeDetail> listAll() {
        return episodeDetailRepository.findAll();
    }

    public void save(EpisodeDetail expense) {
        episodeDetailRepository.save(expense);
    }

    public EpisodeDetail get(String id) {
        return episodeDetailRepository.findById(id).get();
    }

    public void delete(String id) {
        episodeDetailRepository.deleteById(id);
    }
}
