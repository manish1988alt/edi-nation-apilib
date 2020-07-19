package com.edination.api.rap.Dao;

import com.edination.api.rap.model.ServicingProviderPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServicingProviderService {
    @Autowired
    ServicingProviderRepository servicingProviderRepository;

    public List<ServicingProviderPerson> listAll() {
        return servicingProviderRepository.findAll();
    }

    public void save(ServicingProviderPerson expense) {
        servicingProviderRepository.save(expense);
    }

    public ServicingProviderPerson get(String id) {
        return servicingProviderRepository.findById(id).get();
    }

    public void delete(String id) {
        servicingProviderRepository.deleteById(id);
    }
}
