package com.edination.api.Dao;

import com.edination.api.eligibility.model.TertiaryInsuranceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TertiaryInsuranceDetailService {

    @Autowired
    TertiaryInsuranceDetailRepository tertiaryInsuranceDetailRepository;


    public List<TertiaryInsuranceDetail> listAll() {
        return tertiaryInsuranceDetailRepository.findAll();
    }

    public void save(TertiaryInsuranceDetail expense) {
        tertiaryInsuranceDetailRepository.save(expense);
    }

    public TertiaryInsuranceDetail get(int id) {
        return tertiaryInsuranceDetailRepository.findById(id).get();
    }

    public void delete(int id) {
        tertiaryInsuranceDetailRepository.deleteById(id);
    }
}
