package com.edination.api.Dao;

import com.edination.api.preAuthorisation.model.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RequestServiceDao {

    @Autowired
    RequestServiceRepository requestServiceRepository;

    public List<RequestService> listAll() {
        return requestServiceRepository.findAll();
    }

    public void save(RequestService expense) {
        requestServiceRepository.save(expense);
    }

    public RequestService get(int id) {
        return requestServiceRepository.findById(id).get();
    }

    public void delete(int id) {
        requestServiceRepository.deleteById(id);
    }
}
