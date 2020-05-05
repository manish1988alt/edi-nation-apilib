package com.edination.api.Dao;

import com.edination.api.eligibility.model.PrimaryInsuranceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrimaryInsuranceDetailService {
    @Autowired
    PrimaryInsuranceDetailRepository primaryInsuranceDetailRepository;

    public List<PrimaryInsuranceDetail> listAll() {
        return primaryInsuranceDetailRepository.findAll();
    }

    public void save(PrimaryInsuranceDetail expense) {
        primaryInsuranceDetailRepository.save(expense);
    }

    public PrimaryInsuranceDetail get(String id) {
        return primaryInsuranceDetailRepository.findById(id).get();
    }

    public void delete(String id) {
        primaryInsuranceDetailRepository.deleteById(id);
    }
}
