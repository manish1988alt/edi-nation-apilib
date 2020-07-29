package com.edination.api.LoginPackage.dao;

import com.edination.api.PDGM.model.AdmissionSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AdmissionSourceService {
@Autowired
AdmissionSourceRepository admissionSourceRepository;

    public List<AdmissionSource> listAll() {
        return admissionSourceRepository.findAll();
    }

    public void save(AdmissionSource expense) {
        admissionSourceRepository.save(expense);
    }

    public AdmissionSource get(String id) {
        return admissionSourceRepository.findById(id).get();
    }

    public void delete(String id) {
        admissionSourceRepository.deleteById(id);
    }
}
