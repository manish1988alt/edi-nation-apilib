package com.edination.api.rap.Dao;

import com.edination.api.rap.model.OccuranceAndDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OccuranceAndDateService {


    @Autowired
    OccuranceAndDateRepository occuranceAndDateRepository;

    public List<OccuranceAndDate> listAll() {
        return occuranceAndDateRepository.findAll();
    }

    public void save(OccuranceAndDate expense) {
        occuranceAndDateRepository.save(expense);
    }

    public OccuranceAndDate get(int id) {
        return occuranceAndDateRepository.findById(id).get();
    }

    public void delete(int id) {
        occuranceAndDateRepository.deleteById(id);
    }
}
