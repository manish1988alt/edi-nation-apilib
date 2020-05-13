package com.edination.api.preAuthorisation.rest;

import com.edination.api.Dao.*;
import com.edination.api.eligibility.model.Demographics;
import com.edination.api.preAuthorisation.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("preAuthorization")
public class PreAuthRestApp implements Serializable {
    @Autowired
    PreAuthService preAuthService;
    @Autowired
    RequestServiceRepository requestServiceRepository;

    @Autowired
    HomeHealthPreAuthFormService homeHealthPreAuthFormService;
    @Autowired
    HomeHealthPreAuthFormRepository homeHealthPreAuthFormRepository;
    @GetMapping("/preAuthList")
    public List<PreAuthDetail> preAuthList()  throws Throwable
    {

   List<PreAuthDetail> list=preAuthService.listAll();
        return   list;
    }

    @PostMapping("/preauthview")
    public List<HomeHealthPreAuthorizationForm> preAuthView(@RequestBody  HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm)  throws Throwable
    {
     List<HomeHealthPreAuthorizationForm> list=  homeHealthPreAuthFormRepository.findByMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());

    return list;
    }
}
