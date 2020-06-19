package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.HippsCodeAndCaseMixWeight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HippsCodeAndCaseMixWeightService {

    @Autowired
    HippsCodeAndCaseMixWeightRepository hippsCodeAndCaseMixWeightRepository;

    public List<HippsCodeAndCaseMixWeight> listAll()
    {
        return hippsCodeAndCaseMixWeightRepository.findAll();
    }

    public void save(HippsCodeAndCaseMixWeight highComorbidityCondition)
    {
        hippsCodeAndCaseMixWeightRepository.save(highComorbidityCondition);
    }

    public HippsCodeAndCaseMixWeight get(String id) {
        return hippsCodeAndCaseMixWeightRepository.findById(id).get();
    }

    public void delete(String id) {
        hippsCodeAndCaseMixWeightRepository.deleteById(id);
    }
}

