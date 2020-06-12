package com.edination.api.preAuthorisation.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PreAuthorizationResponseHistoryService {
    @Autowired
    PreAuthorizationResponseHistoryRepository preAuthorizationResponseHistoryRepository;

    public List<PreAuthorizationResponseHistory> listAll() {
        return preAuthorizationResponseHistoryRepository.findAll();
    }

    public void save(PreAuthorizationResponseHistory expense) {
        preAuthorizationResponseHistoryRepository.save(expense);
    }

    public PreAuthorizationResponseHistory get(int id) {
        return preAuthorizationResponseHistoryRepository.findById(id).get();
    }

    public void delete(int id) {
        preAuthorizationResponseHistoryRepository.deleteById(id);
    }
}
