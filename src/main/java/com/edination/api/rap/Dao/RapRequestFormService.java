package com.edination.api.rap.Dao;

import com.edination.api.rap.model.RapRequestForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RapRequestFormService {

    @Autowired
    RapRequestFormRepository rapRequestFormRepository;

    public List<RapRequestForm> listAll() {
        return rapRequestFormRepository.findAll();
    }

    public void save(RapRequestForm expense) {
        rapRequestFormRepository.save(expense);
    }

    public RapRequestForm get(int id) {
        return rapRequestFormRepository.findById(id).get();
    }

    public void delete(int id) {
        rapRequestFormRepository.deleteById(id);
    }


}
