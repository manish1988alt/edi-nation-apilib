package com.edination.api.rap.Dao;

import com.edination.api.rap.model.PrimaryDiagnosisCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrimaryDiagnosisCodeService {
    @Autowired
    PrimaryDiagnosisCodeRepository primaryDiagnosisCodeRepository;

    public List<PrimaryDiagnosisCode> listAll() {
        return primaryDiagnosisCodeRepository.findAll();
    }

    public void save(PrimaryDiagnosisCode expense) {
        primaryDiagnosisCodeRepository.save(expense);
    }

    public PrimaryDiagnosisCode get(String id) {
        return primaryDiagnosisCodeRepository.findById(id).get();
    }

    public void delete(String id) {
        primaryDiagnosisCodeRepository.deleteById(id);
    }
}
