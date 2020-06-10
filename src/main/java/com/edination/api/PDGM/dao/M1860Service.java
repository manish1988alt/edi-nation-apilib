package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.M1860;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class M1860Service {


    @Autowired
    M1860Repository m1860Repository;

    public List<M1860> listAll() {
        return m1860Repository.findAll();
    }

    public void save(M1860 expense) {
        m1860Repository.save(expense);
    }

    public M1860 get(int id) {
        return m1860Repository.findById(id).get();
    }

    public void delete(int id) {
        m1860Repository.deleteById(id);
    }
}
