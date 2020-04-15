package com.edination.api.Dao;

import com.edination.api.eligibility.model.Demographics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DemographicsService {
    @Autowired
    DemographicRepository repository;

    public List<Demographics> listAll() {
        return repository.findAll();
    }

    public void save(Demographics expense) {
        repository.save(expense);
    }

    public Demographics get(long id) {
        return repository.findById(id).get();
    }

    public void delete(long id) {
        repository.deleteById(id);
    }
}
