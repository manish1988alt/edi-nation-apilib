package com.edination.api.Dao;

import com.edination.api.preAuthorisation.model.Episode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EpisodeService {
@Autowired
EpisodeRepository episodeRepository;

    public List<Episode> listAll() {
        return episodeRepository.findAll();
    }

    public void save(Episode expense) {
        episodeRepository.save(expense);
    }

    public Episode get(String id) {
        return episodeRepository.findById(id).get();
    }

    public void delete(String id) {
        episodeRepository.deleteById(id);
    }
}
