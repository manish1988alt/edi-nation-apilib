package com.edination.api.Dao;

import com.edination.api.eligibility.model.SubscriberDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriberDetailRepository270 extends JpaRepository<SubscriberDetail,String> {
}
