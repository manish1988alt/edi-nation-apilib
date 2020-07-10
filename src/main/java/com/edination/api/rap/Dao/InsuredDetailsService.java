package com.edination.api.rap.Dao;

import com.edination.api.rap.model.InsuredDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InsuredDetailsService {


    @Autowired
    InsuredDetailsRepository insuredDetailsRepository;

    public List<InsuredDetails> listAll() {
        return insuredDetailsRepository.findAll();
    }

    public void save(InsuredDetails expense) {
        insuredDetailsRepository.save(expense);
    }

    public InsuredDetails get(int id) {
        return insuredDetailsRepository.findById(id).get();
    }

    public void delete(int id) {
        insuredDetailsRepository.deleteById(id);
    }
}
