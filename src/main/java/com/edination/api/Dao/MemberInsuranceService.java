package com.edination.api.Dao;

import com.edination.api.eligibility.model.MemberInsuranceEligibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MemberInsuranceService {
    @Autowired
    MemberInsuranceRepository memberInsuranceRepository;
    
    public List<MemberInsuranceEligibility> listAll() {
        return memberInsuranceRepository.findAll();
    }

    public void save(MemberInsuranceEligibility expense) {
        memberInsuranceRepository.save(expense);
    }

    public MemberInsuranceEligibility get(String id) {
        return memberInsuranceRepository.findById(id).get();
    }

    public void delete(String id) {
        memberInsuranceRepository.deleteById(id);
    }

}
