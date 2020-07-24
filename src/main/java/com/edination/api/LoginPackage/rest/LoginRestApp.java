package com.edination.api.LoginPackage.rest;

import com.edination.api.Dao.DemographicsService;
import com.edination.api.Dao.EpisodeRepository;
import com.edination.api.LoginPackage.dao.LoginService;
import com.edination.api.LoginPackage.model.IntakeList;
import com.edination.api.LoginPackage.model.Login;
import com.edination.api.PDGM.dao.EpisodeDetailService;
import com.edination.api.PDGM.dao.PDGMRapListRepository;
import com.edination.api.PDGM.model.AdmissionSource;
import com.edination.api.PDGM.model.EpisodeDetail;
import com.edination.api.eligibility.model.Demographics;
import com.edination.api.preAuthorisation.model.Episode;
import com.edination.api.rap.Dao.PrimaryDiagnosisCodeService;
import com.edination.api.rap.model.PrimaryDiagnosisCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("nalashaa")
public class LoginRestApp implements Serializable {
    @Autowired
    LoginService loginService;
    @Autowired
    DemographicsService demographicsService;
    @Autowired
    PDGMRapListRepository pdgmRapListRepository;
    @Autowired
    PrimaryDiagnosisCodeService primaryDiagnosisCodeService;
    @Autowired
    EpisodeRepository episodeRepository;

    @PostMapping("/login")
    public ResponseEntity<?>  loginCall(@RequestBody Login login) throws Throwable {
    String ackn="false";
        List<Login> loginList= loginService.listAll();
        for(Login login1:loginList)
        {
            if(login.getPassword().equals(login1.getPassword()) && login.getUserName().equals(login1.getUserName()))
            {
                ackn= "true";
                break;
            }
            else
            {
                ackn="false";
            }
        }
        if(ackn.equals("true")) {
            return generateSuccessObject("Success",
                    " ");
        }
        else
        {
            return generateSuccessObject("Fail",
                    "Sent failed ");
        }

    }
    @GetMapping("/intakeList")
    public List<IntakeList> intakeListing() throws Throwable {
        List<IntakeList> intakeListList=new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        List<Demographics> demographicsList=demographicsService.listAll();
        for(Demographics demographics:demographicsList) {
            IntakeList  intakelist=new IntakeList();
            intakelist.setPatientMRN(demographics.getMrnNumber());
            intakelist.setFirstName(demographics.getFirstName());
            intakelist.setLastName(demographics.getLastName());
            intakelist.setMiddleName(demographics.getMiddleName());
            intakelist.setPrefix("");
            intakelist.setSuffix(demographics.getSuffix());
            intakelist.setDob(demographics.getDob());
            intakelist.setGender(demographics.getGender());
            List<Episode> episodeDetailList=episodeRepository.findByMrnNumberEpisode(demographics.getMrnNumber());
            for(Episode episodeDetail:episodeDetailList)
            {

                String episodeStartDate = formatter.format(episodeDetail.getAdmissionDate());
                LocalDate episodestartDate=LocalDate.parse(episodeStartDate);
                LocalDate episodeEndDate=LocalDate.parse("2020-08-27");
                intakelist.setEpisodeStartDate(episodestartDate);
                intakelist.setEpisodeType(episodeDetail.getEpisodeType());
                intakelist.setAddmissionStatus(episodeDetail.getAdmissionStatus());
                intakelist.setEpisodeEndDate(episodeEndDate);
            }
            intakelist.setOasisStatus("");
           AdmissionSource admissionSourceList=pdgmRapListRepository.findAdmissionSourceByMrn(demographics.getMrnNumber());
            String refferalDate = formatter.format(admissionSourceList.getReferralDate());
                LocalDate refferDate=LocalDate.parse(refferalDate);
                intakelist.setRefferDate(refferDate);
            intakeListList.add(intakelist);

        }

        return intakeListList;
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
