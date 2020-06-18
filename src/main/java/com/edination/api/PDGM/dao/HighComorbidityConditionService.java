package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.HighComorbidityCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HighComorbidityConditionService {
    @Autowired
    HighComorbidityConditionRepository highComorbidityConditionRepository;

    public List<HighComorbidityCondition> listAll()
    {
        return highComorbidityConditionRepository.findAll();
    }

    public void save(HighComorbidityCondition highComorbidityCondition)
    {
        highComorbidityConditionRepository.save(highComorbidityCondition);
    }

    public HighComorbidityCondition get(int id) {
        return highComorbidityConditionRepository.findById(id).get();
    }

    public void delete(int id) {
        highComorbidityConditionRepository.deleteById(id);
    }
}
