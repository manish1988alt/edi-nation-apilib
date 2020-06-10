package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.M1810;
import com.edination.api.PDGM.model.M1820;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class M1810Service {

    @Autowired
    M1810Repository m1810Repository;

    public List<M1810> listAll() {
        return m1810Repository.findAll();
    }

    public void save(M1810 expense) {
        m1810Repository.save(expense);
    }

    public M1810 get(int id) {
        return m1810Repository.findById(id).get();
    }

    public void delete(int id) {
        m1810Repository.deleteById(id);
    }
}
