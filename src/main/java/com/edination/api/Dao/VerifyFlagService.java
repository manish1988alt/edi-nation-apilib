package com.edination.api.Dao;

import com.edination.api.eligibility.model.VerifyFlag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class VerifyFlagService {

    @Autowired
    VerifyFlagRepository verifyFlagRepository;

    public List<VerifyFlag> listAll() {
        return verifyFlagRepository.findAll();
    }

    public void save(VerifyFlag expense) {
        verifyFlagRepository.save(expense);
    }

    public VerifyFlag get(String id) {
        return verifyFlagRepository.findById(id).get();
    }

    public void delete(String id) {
        verifyFlagRepository.deleteById(id);
    }
}
