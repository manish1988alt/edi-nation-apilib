package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.M1830;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class M1830Service {

    @Autowired
    M1830Repository m1830Repository;

    public List<M1830> listAll() {
        return m1830Repository.findAll();
    }

    public void save(M1830 expense) {
        m1830Repository.save(expense);
    }

    public M1830 get(int id) {
        return m1830Repository.findById(id).get();
    }

    public void delete(int id) {
        m1830Repository.deleteById(id);
    }
}
