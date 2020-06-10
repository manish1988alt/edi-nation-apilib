package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.M1033;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class M1033Service {
    @Autowired
    M1033Repository m1033Repository;

    public List<M1033> listAll() {
        return m1033Repository.findAll();
    }

    public void save(M1033 expense) {
        m1033Repository.save(expense);
    }

    public M1033 get(int id) {
        return m1033Repository.findById(id).get();
    }

    public void delete(int id) {
        m1033Repository.deleteById(id);
    }
}
