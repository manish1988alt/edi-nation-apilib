package com.edination.api.Dao;

import com.edination.api.eligibility.model.EdiDataElement271;
import com.edination.api.eligibility.model.MemberInsuranceEligibility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class EDI271Service {
     @Autowired
    EDI271Repository edi271Repository;
    public List<EdiDataElement271> listAll() {
        return edi271Repository.findAll();
    }

    public void save(EdiDataElement271 expense) {
        edi271Repository.save(expense);
    }

    public EdiDataElement271 get(String id) {
        return edi271Repository.findById(id).get();
    }

    public void delete(String id) {
        edi271Repository.deleteById(id);
    }

}
