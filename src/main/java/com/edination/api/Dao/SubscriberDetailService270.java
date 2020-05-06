package com.edination.api.Dao;

import com.edination.api.eligibility.model.SubscriberDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SubscriberDetailService270 {
    @Autowired
    SubscriberDetailRepository270 subscriberDetailRepository270;

    public List<SubscriberDetail> listAll() {
        return subscriberDetailRepository270.findAll();
    }

    public void save(SubscriberDetail expense) {
        subscriberDetailRepository270.save(expense);
    }

    public SubscriberDetail get(String id) {
        return subscriberDetailRepository270.findById(id).get();
    }

    public void delete(String id) {
        subscriberDetailRepository270.deleteById(id);
    }
}
