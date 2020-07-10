package com.edination.api.rap.Dao;

import com.edination.api.rap.model.BillingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BillingDetailsService {

    @Autowired
    BillingDetailsRepository billingDetailsRepository;

    public List<BillingDetails> listAll() {
        return billingDetailsRepository.findAll();
    }

    public void save(BillingDetails expense) {
        billingDetailsRepository.save(expense);
    }

    public BillingDetails get(int id) {
        return billingDetailsRepository.findById(id).get();
    }

    public void delete(int id) {
        billingDetailsRepository.deleteById(id);
    }
}
