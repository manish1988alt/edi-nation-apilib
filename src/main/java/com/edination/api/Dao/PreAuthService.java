package com.edination.api.Dao;

import com.edination.api.preAuthorisation.model.PreAuthDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PreAuthService {

    @Autowired
    PreAuthRepository preAuthRepository;

    public List<PreAuthDetail> listAll() {
        return preAuthRepository.findAll();
    }

    public void save(PreAuthDetail expense) {
        preAuthRepository.save(expense);
    }

    public PreAuthDetail get(String id) {
        return preAuthRepository.findById(id).get();
    }

    public void delete(String id) {
        preAuthRepository.deleteById(id);
    }

}
