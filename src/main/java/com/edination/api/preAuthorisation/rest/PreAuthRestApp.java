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
    PreAuthRepository preAuthRepository;
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

    @PostMapping("/preauthSave")
    public String preauthSave(@RequestBody  HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm)  throws Throwable
    {
      homeHealthPreAuthFormService.save(homeHealthPreAuthorizationForm);
        PreAuthDetail preAuthDetail=new PreAuthDetail();
        PreAuthDemographics demographics=new PreAuthDemographics();
        //List<PreAuthDetail> list=preAuthService.listAll();
        List<PreAuthDetail> list= preAuthRepository.findByMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
        demographics.setMrnNumber(homeHealthPreAuthorizationForm.getPreAuthDemographics().getMrnNumber());
        demographics.setFirstName(homeHealthPreAuthorizationForm.getPreAuthDemographics().getFirstName());
        demographics.setLastName(homeHealthPreAuthorizationForm.getPreAuthDemographics().getLastName());
        demographics.setMiddleName(homeHealthPreAuthorizationForm.getPreAuthDemographics().getMiddleName());
        demographics.setSuffix(homeHealthPreAuthorizationForm.getPreAuthDemographics().getSuffix());
        demographics.setDob(homeHealthPreAuthorizationForm.getPreAuthDemographics().getDob());
        demographics.setGender(homeHealthPreAuthorizationForm.getPreAuthDemographics().getGender());
        demographics.setSsn(homeHealthPreAuthorizationForm.getPreAuthDemographics().getSsn());
        Episode episode=new Episode();
        for(PreAuthDetail pre:list) {
            episode.setAdmissionDate(homeHealthPreAuthorizationForm.getAdmissionDetail().getAdmissionDate());
            episode.setAdmissionStatus(pre.getEpisode().getAdmissionStatus());
            episode.setEpisodeType(pre.getEpisode().getEpisodeType());
            episode.setMrnNumber(pre.getEpisode().getMrnNumber());
            episode.setPreauthFormStatus("Saved As Draft");
            episode.setPreAuthorisationStatus(pre.getEpisode().getPreAuthorisationStatus());
            episode.setPayorType(pre.getEpisode().getPayorType());
            episode.setFormSentDate(homeHealthPreAuthorizationForm.getCurrenttimdate());
        }
        preAuthDetail.setPreAuthDemographics(demographics);
        preAuthDetail.setEpisode(episode);
        preAuthService.save(preAuthDetail);

      return "Saved successfully";
    }
}
