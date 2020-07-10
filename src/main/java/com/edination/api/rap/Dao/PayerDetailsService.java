package com.edination.api.rap.Dao;

import com.edination.api.rap.model.PayerDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PayerDetailsService {


    @Autowired
    PayerDetailsRepository payerDetailsRepository;

    public List<PayerDetails> listAll() {
        return payerDetailsRepository.findAll();
    }

    public void save(PayerDetails expense) {
        payerDetailsRepository.save(expense);
    }

    public PayerDetails get(int id) {
        return payerDetailsRepository.findById(id).get();
    }

    public void delete(int id) {
        payerDetailsRepository.deleteById(id);
    }
}
