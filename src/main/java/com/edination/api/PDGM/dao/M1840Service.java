package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.M1840;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class M1840Service {


    @Autowired
    M1840Repository m1840Repository;

    public List<M1840> listAll() {
        return m1840Repository.findAll();
    }

    public void save(M1840 expense) {
        m1840Repository.save(expense);
    }

    public M1840 get(int id) {
        return m1840Repository.findById(id).get();
    }

    public void delete(int id) {
        m1840Repository.deleteById(id);
    }
}
