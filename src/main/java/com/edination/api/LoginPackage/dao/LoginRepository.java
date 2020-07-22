package com.edination.api.LoginPackage.dao;

import com.edination.api.LoginPackage.model.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login,String> {
}
