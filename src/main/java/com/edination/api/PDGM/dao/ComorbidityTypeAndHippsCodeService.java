package com.edination.api.PDGM.dao;


import com.edination.api.PDGM.model.ComorbidityTypeAndHippsCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ComorbidityTypeAndHippsCodeService {

    @Autowired
    ComorbidityTypeAndHippsCodeRepository comorbidityTypeAndHippsCodeRepository;

    public List<ComorbidityTypeAndHippsCode> listAll()
    {
        return comorbidityTypeAndHippsCodeRepository.findAll();
    }

    public void save(ComorbidityTypeAndHippsCode highComorbidityCondition)
    {
        comorbidityTypeAndHippsCodeRepository.save(highComorbidityCondition);
    }

    public ComorbidityTypeAndHippsCode get(String id) {
        return comorbidityTypeAndHippsCodeRepository.findById(id).get();
    }

    public void delete(String id) {
        comorbidityTypeAndHippsCodeRepository.deleteById(id);
    }
}
