package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.SecondDiagnosisCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SecondDiagnosisCodeService {
    @Autowired
    SecondDaignosisCodeRepository secondDaignosisCodeRepository;

    public List<SecondDiagnosisCode> listAll() {
        return secondDaignosisCodeRepository.findAll();
    }

    public void save(SecondDiagnosisCode expense) {
        secondDaignosisCodeRepository.save(expense);
    }

    public SecondDiagnosisCode get(int id) {
        return secondDaignosisCodeRepository.findById(id).get();
    }

    public void delete(int id) {
        secondDaignosisCodeRepository.deleteById(id);
    }
}
