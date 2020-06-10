package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.M1850;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class M1850Service {


    @Autowired
    M1850Repository m1850Repository;

    public List<M1850> listAll() {
        return m1850Repository.findAll();
    }

    public void save(M1850 expense) {
        m1850Repository.save(expense);
    }

    public M1850 get(int id) {
        return m1850Repository.findById(id).get();
    }

    public void delete(int id) {
        m1850Repository.deleteById(id);
    }
}
