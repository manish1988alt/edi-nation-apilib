package com.edination.api.PDGM.dao;

import com.edination.api.PDGM.model.TimingAndSourceOfAdmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TimingAndSourceService {

    @Autowired
    TimingAndSourceRepository timingAndSourceRepository;

    public List<TimingAndSourceOfAdmission> listAll() {
        return timingAndSourceRepository.findAll();
    }

    public void save(TimingAndSourceOfAdmission expense) {
        timingAndSourceRepository.save(expense);
    }

    public TimingAndSourceOfAdmission get(String id) {
        return timingAndSourceRepository.findById(id).get();
    }

    public void delete(String id) {
        timingAndSourceRepository.deleteById(id);
    }

}
