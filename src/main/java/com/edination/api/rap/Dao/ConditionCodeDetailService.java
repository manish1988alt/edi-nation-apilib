package com.edination.api.rap.Dao;

import com.edination.api.rap.model.ConditionCodeDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ConditionCodeDetailService {

    @Autowired
    ConditionCodeDetailRepository conditionCodeDetailRepository;

    public List<ConditionCodeDetail> listAll() {
        return conditionCodeDetailRepository.findAll();
    }

    public void save(ConditionCodeDetail expense) {
        conditionCodeDetailRepository.save(expense);
    }

    public ConditionCodeDetail get(int id) {
        return conditionCodeDetailRepository.findById(id).get();
    }

    public void delete(int id) {
        conditionCodeDetailRepository.deleteById(id);
    }
}
