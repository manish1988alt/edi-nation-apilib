package com.edination.api.PDGM.dao;


import com.edination.api.PDGM.model.M1800;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class M1800Service {

    @Autowired
    M1800Repository m1800Repository;

    public List<M1800> listAll() {
        return m1800Repository.findAll();
    }

    public void save(M1800 expense) {
        m1800Repository.save(expense);
    }

    public M1800 get(int id) {
        return m1800Repository.findById(id).get();
    }

    public void delete(int id) {
        m1800Repository.deleteById(id);
    }
}
