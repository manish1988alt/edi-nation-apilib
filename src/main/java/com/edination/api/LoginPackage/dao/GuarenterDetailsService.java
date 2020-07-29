package com.edination.api.LoginPackage.dao;

import com.edination.api.LoginPackage.model.GuarenterDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class GuarenterDetailsService {

    @Autowired
    GuarenterDetailsRepository guarenterDetailsRepository;

    public List<GuarenterDetails> listAll() {
        return guarenterDetailsRepository.findAll();
    }

    public void save(GuarenterDetails expense) {
        guarenterDetailsRepository.save(expense);
    }

    public GuarenterDetails get(String id) {
        return guarenterDetailsRepository.findById(id).get();
    }

    public void delete(String id) {
        guarenterDetailsRepository.deleteById(id);
    }
}
