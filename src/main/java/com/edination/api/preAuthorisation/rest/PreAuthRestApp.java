package com.edination.api.preAuthorisation.rest;

import com.edination.api.Dao.*;
import com.edination.api.eligibility.model.Demographics;
import com.edination.api.preAuthorisation.model.Episode;
import com.edination.api.preAuthorisation.model.PreAuthDemographics;
import com.edination.api.preAuthorisation.model.PreAuthDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("preAuthorization")
public class PreAuthRestApp implements Serializable {
    @Autowired
    EpisodeService  episodeService;
    @Autowired
    DemographicsService demographicsService;
    @Autowired
    PreAuthService preAuthService;

    @GetMapping("/preAuthList")
    public List<PreAuthDetail> preAuthList()  throws Throwable
    {

   List<PreAuthDetail> list=preAuthService.listAll();
        return   list;
    }
}