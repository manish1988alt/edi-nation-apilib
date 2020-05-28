package com.edination.api.PDGM.rest;


import com.edination.api.PDGM.dao.PDGMRapListService;
import com.edination.api.PDGM.model.PDGMRapListing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("pdgm")
public class PDGMRestApp implements Serializable {

    @Autowired
    PDGMRapListService pdgmRapListService;

    @GetMapping("/rapList")
    public List<PDGMRapListing> rapList()  throws Throwable{

        return pdgmRapListService.listAll();
    }
}
