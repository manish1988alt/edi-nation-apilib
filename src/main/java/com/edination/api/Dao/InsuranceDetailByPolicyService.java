package com.edination.api.Dao;

import com.edination.api.eligibility.model.InsuranceDetailByPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InsuranceDetailByPolicyService {
    @Autowired
    InsuranceDetailByPolicyServiceRepository insuranceDetailByPolicyServiceRepository;

    public List<InsuranceDetailByPolicy> listAll() {
        return insuranceDetailByPolicyServiceRepository.findAll();
    }

    public void save(InsuranceDetailByPolicy expense) {
        insuranceDetailByPolicyServiceRepository.save(expense);
    }

    public InsuranceDetailByPolicy get(Integer id) {
        return insuranceDetailByPolicyServiceRepository.findById(id).get();
    }

    public void delete(Integer id) {
        insuranceDetailByPolicyServiceRepository.deleteById(id);
    }
}
