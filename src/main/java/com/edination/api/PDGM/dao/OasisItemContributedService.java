package com.edination.api.PDGM.dao;


import com.edination.api.PDGM.model.OASISItemContributed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OasisItemContributedService {

@Autowired
OasisItemContributedRepository oasisItemContributedRepository;

    public List<OASISItemContributed> listAll() {
        return oasisItemContributedRepository.findAll();
    }

    public void save(OASISItemContributed expense) {
        oasisItemContributedRepository.save(expense);
    }

    public OASISItemContributed get(String id) {
        return oasisItemContributedRepository.findById(id).get();
    }

    public void delete(String id) {
        oasisItemContributedRepository.deleteById(id);
    }
}
