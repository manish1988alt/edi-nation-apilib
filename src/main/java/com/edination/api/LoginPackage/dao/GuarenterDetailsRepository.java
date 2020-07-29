package com.edination.api.LoginPackage.dao;


import com.edination.api.LoginPackage.model.GuarenterDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuarenterDetailsRepository extends JpaRepository<GuarenterDetails,String> {
}
