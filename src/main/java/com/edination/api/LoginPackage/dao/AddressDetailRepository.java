package com.edination.api.LoginPackage.dao;

import com.edination.api.LoginPackage.model.AddressDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressDetailRepository  extends JpaRepository<AddressDetail,String> {
}
