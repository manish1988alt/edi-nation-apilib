package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.PDGMRapListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PDGMRapListService {

    @Autowired
    PDGMRapListRepository pdgmRapListRepository;

    public List<PDGMRapListing> listAll() {
        return pdgmRapListRepository.findAll();
    }

    public void save(PDGMRapListing expense) {
        pdgmRapListRepository.save(expense);
    }

    public PDGMRapListing get(String id) {
        return pdgmRapListRepository.findById(id).get();
    }

    public void delete(String id) {
        pdgmRapListRepository.deleteById(id);
    }
}
