package com.edination.api.Dao;

import com.edination.api.preAuthorisation.model.PreAuthorizationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PreAuthorizationResponseService {

    @Autowired
    PreAuthorizationResponseRepository preAuthorizationResponseRepository;
    public List<PreAuthorizationResponse> listAll() {
        return preAuthorizationResponseRepository.findAll();
    }

    public void save(PreAuthorizationResponse expense) {
        preAuthorizationResponseRepository.save(expense);
    }

    public PreAuthorizationResponse get(int id) {
        return preAuthorizationResponseRepository.findById(id).get();
    }

    public void delete(int id) {
        preAuthorizationResponseRepository.deleteById(id);
    }
}
