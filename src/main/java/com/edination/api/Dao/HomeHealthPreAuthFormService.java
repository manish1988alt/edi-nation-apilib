package com.edination.api.Dao;

import com.edination.api.preAuthorisation.model.HomeHealthPreAuthorizationForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HomeHealthPreAuthFormService {
    @Autowired
    HomeHealthPreAuthFormRepository homeHealthPreAuthFormRepository;

    public List<HomeHealthPreAuthorizationForm> listAll() {
        return homeHealthPreAuthFormRepository.findAll();
    }

    public void save(HomeHealthPreAuthorizationForm expense) {
        homeHealthPreAuthFormRepository.save(expense);
    }

    public HomeHealthPreAuthorizationForm get(String id) {
        return homeHealthPreAuthFormRepository.findById(id).get();
    }

    public void delete(String id) {
        homeHealthPreAuthFormRepository.deleteById(id);
    }
}
