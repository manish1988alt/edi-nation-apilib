package com.edination.api.PDGM.dao;


import com.edination.api.PDGM.model.M1820;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class M1820Service {
    @Autowired
    M1820Repository m1820Repository;

    public List<M1820> listAll() {
        return m1820Repository.findAll();
    }

    public void save(M1820 expense) {
        m1820Repository.save(expense);
    }

    public M1820 get(int id) {
        return m1820Repository.findById(id).get();
    }

    public void delete(int id) {
        m1820Repository.deleteById(id);
    }
}
