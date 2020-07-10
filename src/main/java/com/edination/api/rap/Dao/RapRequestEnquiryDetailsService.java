package com.edination.api.rap.Dao;


import com.edination.api.rap.model.RapRequestEnquiryDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RapRequestEnquiryDetailsService {


    @Autowired
    RapRequestEnquiryDetailsRepository rapRequestEnquiryDetailsRepository;

    public List<RapRequestEnquiryDetails> listAll() {
        return rapRequestEnquiryDetailsRepository.findAll();
    }

    public void save(RapRequestEnquiryDetails expense) {
        rapRequestEnquiryDetailsRepository.save(expense);
    }

    public RapRequestEnquiryDetails get(int id) {
        return rapRequestEnquiryDetailsRepository.findById(id).get();
    }

    public void delete(int id) {
        rapRequestEnquiryDetailsRepository.deleteById(id);
    }
}
