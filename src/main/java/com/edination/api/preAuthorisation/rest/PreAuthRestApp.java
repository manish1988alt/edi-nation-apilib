package com.edination.api.preAuthorisation.rest;

import com.edination.api.Dao.*;
import com.edination.api.eligibility.EDIFile.SFTPFILE;
import com.edination.api.eligibility.model.Demographics;
import com.edination.api.preAuthorisation.EDI.EDIFileGeneration;
import com.edination.api.preAuthorisation.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
PreAuthDemographicService preAuthDemographicService;
    @Autowired
    HomeHealthPreAuthFormService homeHealthPreAuthFormService;
    @Autowired
    HomeHealthPreAuthFormRepository homeHealthPreAuthFormRepository;
    @GetMapping("/preAuthList")
    public List<PreAuthDetail> preAuthList()  throws Throwable
    {
        List<PreAuthDetail> list=new ArrayList<>();
        List<PreAuthDemographics> authDemographicsList=preAuthDemographicService.listAll();
        for(PreAuthDemographics preAuthDemographics:authDemographicsList)
        {
            list.addAll(preAuthRepository.findByID(preAuthDemographics.getMrnNumber()));
        }
  // List<PreAuthDetail> list=preAuthService.listAll();

        return   list;
    }

    @PostMapping("/preauthview")
    public List<HomeHealthPreAuthorizationForm> preAuthView(@RequestBody  HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm)  throws Throwable
    {
    // List<HomeHealthPreAuthorizationForm> list=  homeHealthPreAuthFormRepository.findByMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
        List<HomeHealthPreAuthorizationForm> list=   homeHealthPreAuthFormRepository.findByID(homeHealthPreAuthorizationForm.getMrnNumber());
    return list;
    }

    @PostMapping("/preauthSave")
    public ResponseEntity<?> preAuthSave(@RequestBody  HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm)  throws Throwable
    {
        String ackn="false";

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
        preAuthDetail.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
        preAuthDetail.setPreAuthDemographics(demographics);
        preAuthDetail.setEpisode(episode);
        preAuthService.save(preAuthDetail);

       ackn="true";
        if(ackn.equals("true")) {
            return generateSuccessObject("true",
                    " ");
        }
        else
        {
            return generateSuccessObject("false",
                    "Save failed ");
        }


    }

    @PostMapping("/preauthSendRequest")
    public ResponseEntity<?> preAuthSendRequest(@RequestBody  HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm)  throws Throwable {
        File file = new File("Hipaa-5010-278-GenericRequest.txt");
        generateFile(homeHealthPreAuthorizationForm, file);
      String  ackn = new SFTPFILE().fileUpload(file, homeHealthPreAuthorizationForm.getMrnNumber() + "_" + file.getName());

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
            episode.setPreauthFormStatus("Sent For Approval");
            episode.setPreAuthorisationStatus(pre.getEpisode().getPreAuthorisationStatus());
            episode.setPayorType(pre.getEpisode().getPayorType());
            episode.setFormSentDate(homeHealthPreAuthorizationForm.getCurrenttimdate());
        }
        preAuthDetail.setMrnNumber(homeHealthPreAuthorizationForm.getMrnNumber());
        preAuthDetail.setPreAuthDemographics(demographics);
        preAuthDetail.setEpisode(episode);
        preAuthService.save(preAuthDetail);
        if(ackn.equals("true")) {
            return generateSuccessObject("true",
                    " ");
        }
        else
        {
            return generateSuccessObject("false",
                    "Sent failed ");
        }


    }
    public void generateFile(HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm,File file)
    {
        String data=new EDIFileGeneration().generateFile(homeHealthPreAuthorizationForm);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(data);
            System.out.println("File generated successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    protected ResponseEntity<?> generateSuccessObject(String key, String errorBuilder){
        Response.ResponseBuilder builder = null;

        ResponseEntity responseEntity;

        try{
            Map<String, Object> responseObj = new HashMap<String, Object>();
            responseObj.put("ackn",key);
            responseEntity= new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);
        }catch (Exception e) {
            Map<String, Object> responseObj1 = new HashMap<String, Object>();
            responseObj1.put("Error",HttpStatus.BAD_REQUEST);
            responseEntity= new ResponseEntity<>(responseObj1,HttpStatus.EXPECTATION_FAILED);
        }
        return  responseEntity;
    }
}
