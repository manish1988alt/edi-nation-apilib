package com.edination.api.LoginPackage.dao;

import com.edination.api.LoginPackage.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class LoginService {
    @Autowired
    LoginRepository loginRepository;

    public List<Login> listAll() {
        return loginRepository.findAll();
    }

    public void save(Login expense) {
        loginRepository.save(expense);
    }

    public Login get(String id) {
        return loginRepository.findById(id).get();
    }

    public void delete(String id) {
        loginRepository.deleteById(id);
    }
}
