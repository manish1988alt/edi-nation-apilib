package com.edination.api.rap.Dao;

import com.edination.api.rap.model.TreatmentAuthorizationDetails;
import com.edination.api.rap.model.ValueCodeDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ValueCodeDetailService {

    @Autowired
    ValueCodeDetailRepository valueCodeDetailRepository;

    public List<ValueCodeDetail> listAll() {
        return valueCodeDetailRepository.findAll();
    }

    public void save(ValueCodeDetail expense) {
        valueCodeDetailRepository.save(expense);
    }

    public ValueCodeDetail get(int id) {
        return valueCodeDetailRepository.findById(id).get();
    }

    public void delete(int id) {
        valueCodeDetailRepository.deleteById(id);
    }
}
