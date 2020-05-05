package com.edination.api.Dao;

import com.edination.api.eligibility.model.SecondaryInsuranceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SecondaryInsuranceDetailService {

    @Autowired
    SecondaryInsuranceDetailRepository secondaryInsuranceDetailRepository;


    public List<SecondaryInsuranceDetail> listAll() {
        return secondaryInsuranceDetailRepository.findAll();
    }

    public void save(SecondaryInsuranceDetail expense) {
        secondaryInsuranceDetailRepository.save(expense);
    }

    public SecondaryInsuranceDetail get(String id) {
        return secondaryInsuranceDetailRepository.findById(id).get();
    }

    public void delete(String id) {
        secondaryInsuranceDetailRepository.deleteById(id);
    }
}
