package com.edination.api.rap.Dao;

import com.edination.api.rap.model.CountOfAddedValueInRap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CountOfAddedValueInRapService {

    @Autowired
    CountOfAddedValueInRapRepository countOfAddedValueInRapRepository;

    public List<CountOfAddedValueInRap> listAll() {
        return countOfAddedValueInRapRepository.findAll();
    }

    public void save(CountOfAddedValueInRap expense) {
        countOfAddedValueInRapRepository.save(expense);
    }

    public CountOfAddedValueInRap get(String id) {
        return countOfAddedValueInRapRepository.findById(id).get();
    }

    public void delete(String id) {
        countOfAddedValueInRapRepository.deleteById(id);
    }
}
