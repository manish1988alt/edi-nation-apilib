package com.edination.api.LoginPackage.dao;

import com.edination.api.LoginPackage.model.AddressDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.soap.Addressing;
import java.util.List;

@Service
@Transactional
public class AddressDetailService {
    @Autowired
    AddressDetailRepository addressDetailRepository;


    public List<AddressDetail> listAll() {
        return addressDetailRepository.findAll();
    }

    public void save(AddressDetail expense) {
        addressDetailRepository.save(expense);
    }

    public AddressDetail get(String id) {
        return addressDetailRepository.findById(id).get();
    }

    public void delete(String id) {
        addressDetailRepository.deleteById(id);
    }
}
