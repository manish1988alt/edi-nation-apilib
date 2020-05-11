package com.edination.api.Dao;

import com.edination.api.preAuthorisation.model.PreAuthDemographics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PreAuthDemographicService {
    @Autowired
    PreAuthDemographicsRepository preAuthDemographicsRepository;


    public List<PreAuthDemographics> listAll() {
        return preAuthDemographicsRepository.findAll();
    }

    public void save(PreAuthDemographics expense) {
        preAuthDemographicsRepository.save(expense);
    }

    public PreAuthDemographics get(String id) {
        return preAuthDemographicsRepository.findById(id).get();
    }

    public void delete(String id) {
        preAuthDemographicsRepository.deleteById(id);
    }
}
