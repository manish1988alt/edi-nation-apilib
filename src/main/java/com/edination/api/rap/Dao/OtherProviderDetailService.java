package com.edination.api.rap.Dao;

import com.edination.api.rap.model.OtherProviderDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OtherProviderDetailService {


    @Autowired
    OtherProviderDetailRepository otherProviderDetailRepository;

    public List<OtherProviderDetail> listAll() {
        return otherProviderDetailRepository.findAll();
    }

    public void save(OtherProviderDetail expense) {
        otherProviderDetailRepository.save(expense);
    }

    public OtherProviderDetail get(int id) {
        return otherProviderDetailRepository.findById(id).get();
    }

    public void delete(int id) {
        otherProviderDetailRepository.deleteById(id);
    }
}
