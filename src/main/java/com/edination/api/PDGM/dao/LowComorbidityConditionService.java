package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.LowComorbidityCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LowComorbidityConditionService {

    @Autowired
    LowComorbidityConditionRepository lowComorbidityConditionRepository;


    public List<LowComorbidityCondition> listAll()
    {
        return lowComorbidityConditionRepository.findAll();
    }

    public void save(LowComorbidityCondition highComorbidityCondition)
    {
        lowComorbidityConditionRepository.save(highComorbidityCondition);
    }

    public LowComorbidityCondition get(int id) {
        return lowComorbidityConditionRepository.findById(id).get();
    }

    public void delete(int id) {
        lowComorbidityConditionRepository.deleteById(id);
    }
}
