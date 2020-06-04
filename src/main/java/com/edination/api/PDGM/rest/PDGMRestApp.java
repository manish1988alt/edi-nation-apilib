package com.edination.api.PDGM.rest;


import com.edination.api.PDGM.dao.*;
import com.edination.api.PDGM.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("pdgm")
public class PDGMRestApp implements Serializable {

    @Autowired
    PDGMRapListService pdgmRapListService;
    @Autowired
    PDGMRapListRepository pdgmRapListRepository;
    @Autowired
    TimingAndSourceService timingAndSourceService;
    @Autowired
    TimingAndSourceRepository timingAndSourceRepository;
    @Autowired
    EpisodeDetailService episodeDetailService;
@Autowired
OasisItemContributedService oasisItemContributedService;
    @GetMapping("/rapList")
    public List<PDGMRapListing> rapList()  throws Throwable{

        return pdgmRapListService.listAll();
    }

    @PostMapping("/pdgmTool")
    public List<Object> pdgmTool(@RequestBody  PDGMRapListing pdgmRapList ) throws Throwable
    {
        List<Object> list=new ArrayList<>();
        boolean earlyVisit=false;
        boolean lateVisit=false;
        boolean community=false;
        boolean institutional=false;
        int postionCode=0;
        String currentDate = java.time.LocalDate.now().toString();
       // String episodeStartDate = pdgmRapList.getEpisodeStartDates().toString();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String episodeStartDate = formatter.format(pdgmRapList.getEpisodeStartDates());
        //Parsing the date
        System.out.println(episodeStartDate);
        LocalDate episodedateBefore = LocalDate.parse(episodeStartDate);
        LocalDate currentdateAfter = LocalDate.parse(currentDate);

        //calculating number of days in between
        long visitdays = ChronoUnit.DAYS.between(episodedateBefore, currentdateAfter);
        if(visitdays<=30)
        {
            earlyVisit=true;
        }
        else if(visitdays>30&&visitdays<=60)
        {
            lateVisit=true;
        }
        else if(visitdays>=60&&visitdays<=90)
        {
            earlyVisit=true;
        }
        else if(visitdays>90&&visitdays<=120)
        {
            lateVisit=true;
        }
       AdmissionSource admissionSource= pdgmRapListRepository.findAdmissionSourceByMrn(pdgmRapList.getMrnNumber());
        //Date referralDate = formatter.parse(admissionSource.getReferralDate().toString());
        String referralDate = formatter.format(admissionSource.getReferralDate());
        System.out.println(referralDate);
        LocalDate referralBefore = LocalDate.parse(referralDate);
        long sourcedays = ChronoUnit.DAYS.between(referralBefore, currentdateAfter);
        String sourceOfAdmission=admissionSource.getSouceOfAdmission();
        if(sourcedays>14&&("Non-Healthcare Facility Point Of Origin".equals(sourceOfAdmission)||"Clinic Or Physician’s Office".equals(sourceOfAdmission)||"Court/Law Enforcement".equals(sourceOfAdmission)))
        {
            community=true;
        }
      else  if(sourcedays<=14&&("Transfer from Hospital (Different Facility)".equals(sourceOfAdmission)||"Transfer from Skilled Nursing Facility (SNF) or Intermediate Care Facility (ICF)".equals(sourceOfAdmission)||"Transfer from Another Healthcare Facility".equals(sourceOfAdmission)||"Clinic Or Physician’s Office".equals(sourceOfAdmission)))
        {
            institutional=true;
        }
      if(earlyVisit&&community)
      {
          postionCode=1;
      }
        if(lateVisit&&community)
        {
            postionCode=3;
        }
        if(earlyVisit&&institutional)
        {
            postionCode=2;
        }
        if(lateVisit&&institutional)
        {
            postionCode=4;
        }
        TimingAndSourceOfAdmission timingAndSourceOfAdmission=new TimingAndSourceOfAdmission(admissionSource.getMrnNumber(),earlyVisit,lateVisit,community,institutional,postionCode);
        timingAndSourceService.save(timingAndSourceOfAdmission);

        EpisodeDetail episodeDetail=episodeDetailService.get(pdgmRapList.getMrnNumber());
        List<TimingAndSourceOfAdmission> timingAndSourceOfAdmissionsList=pdgmRapListRepository.findTimingSourceByMrn(pdgmRapList.getMrnNumber());

        list.add(episodeDetail);
        list.addAll(timingAndSourceOfAdmissionsList);

        List<ClinicalGroupingPrimaryDiagnosis> clinicalGroupingPrimaryDiagnoses=pdgmRapListRepository.findClinicalGroupingPrimaryDiagnosis(pdgmRapList.getPrimaryDiagnosisCode());
        list.addAll(clinicalGroupingPrimaryDiagnoses);

        return list;
    }

   @PostMapping("/pdgmToolPosition3")
    public String pdgmToolPosition3(@RequestBody  OASISItemContributed oasisItemContributed ) throws Throwable
    {

        oasisItemContributedService.save(oasisItemContributed);
        return "Saved Successfully";

    }
}
