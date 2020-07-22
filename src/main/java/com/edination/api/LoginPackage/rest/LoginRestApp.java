package com.edination.api.LoginPackage.rest;

import com.edination.api.Dao.DemographicsService;
import com.edination.api.LoginPackage.dao.LoginService;
import com.edination.api.LoginPackage.model.IntakeList;
import com.edination.api.LoginPackage.model.Login;
import com.edination.api.PDGM.dao.EpisodeDetailService;
import com.edination.api.PDGM.dao.PDGMRapListRepository;
import com.edination.api.PDGM.model.AdmissionSource;
import com.edination.api.PDGM.model.EpisodeDetail;
import com.edination.api.eligibility.model.Demographics;
import com.edination.api.rap.Dao.PrimaryDiagnosisCodeService;
import com.edination.api.rap.model.PrimaryDiagnosisCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    EpisodeDetailService episodeDetailService;

    @PostMapping("/login")
    public String loginCall(@RequestBody Login login) throws Throwable {
    String Status="Fail";
        List<Login> loginList= loginService.listAll();
        for(Login login1:loginList)
        {
            if(login.getPassword().equals(login1.getPassword()) && login.getUserName().equals(login1.getUserName()))
            {
                Status= "Success";
                break;
            }
            else
            {
                Status="Fail";
            }
        }

        return Status;
    }
    @GetMapping("/intakeList")
    public IntakeList intakeListing() throws Throwable {
        IntakeList  intakelist=new IntakeList();
        List<Demographics> demographicsList=demographicsService.listAll();
        intakelist.setDemographicsList(demographicsList);
        List<AdmissionSource> admissionSourceList=pdgmRapListRepository.findAdmissionSourceList();
        intakelist.setAdmissionSourceList(admissionSourceList);
        List<PrimaryDiagnosisCode> primaryDiagnosisCodeList=primaryDiagnosisCodeService.listAll();
        intakelist.setPrimaryDiagnosisCodeList(primaryDiagnosisCodeList);
        List<EpisodeDetail> episodeDetailList=episodeDetailService.listAll();
        intakelist.setEpisodeDetailList(episodeDetailList);

        return intakelist;
    }
}
