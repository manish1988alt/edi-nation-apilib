package com.edination.api.rap.Dao;


import com.edination.api.rap.model.TreatmentAuthorizationDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TreatmentAuthorizationDetailsService {



    @Autowired
    TreatmentAuthorizationDetailsRepository treatmentAuthorizationDetailsRepository;

    public List<TreatmentAuthorizationDetails> listAll() {
        return treatmentAuthorizationDetailsRepository.findAll();
    }

    public void save(TreatmentAuthorizationDetails expense) {
        treatmentAuthorizationDetailsRepository.save(expense);
    }

    public TreatmentAuthorizationDetails get(int id) {
        return treatmentAuthorizationDetailsRepository.findById(id).get();
    }

    public void delete(int id) {
        treatmentAuthorizationDetailsRepository.deleteById(id);
    }
}


