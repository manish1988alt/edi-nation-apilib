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


      OASISItemContributed oasisItemContributed1=new OASISItemContributed();
        oasisItemContributed1.setMrnNumbe(oasisItemContributed.getMrnNumbe());

        M1800 m1800=new M1800();
        M1810 m1810=new M1810();
        M1820 m1820=new M1820();
        M1830 m1830=new M1830();
        M1840 m1840=new M1840();
        M1850 m1850=new M1850();
        M1860 m1860=new M1860();
        if(oasisItemContributed.getM1800().getId()==0 && oasisItemContributed.getM1800().getFlag())
        {
            m1800.setId(oasisItemContributed.getM1800().getId());
            m1800.setFlag(oasisItemContributed.getM1800().getFlag());
            m1800.setDiscription(oasisItemContributed.getM1800().getDiscription());
            m1800.setFunctionalPoint(0);
        }
        else  if(oasisItemContributed.getM1800().getId()==1 && oasisItemContributed.getM1800().getFlag())
        {
            m1800.setId(oasisItemContributed.getM1800().getId());
            m1800.setFlag(oasisItemContributed.getM1800().getFlag());
            m1800.setDiscription(oasisItemContributed.getM1800().getDiscription());
            m1800.setFunctionalPoint(0);
        }
        else if(oasisItemContributed.getM1800().getId()==2 && oasisItemContributed.getM1800().getFlag())
        {
            m1800.setId(oasisItemContributed.getM1800().getId());
            m1800.setFlag(oasisItemContributed.getM1800().getFlag());
            m1800.setDiscription(oasisItemContributed.getM1800().getDiscription());
            m1800.setFunctionalPoint(5);
        }
        else if(oasisItemContributed.getM1800().getId()==3 && oasisItemContributed.getM1800().getFlag())
        {
            m1800.setId(oasisItemContributed.getM1800().getId());
            m1800.setFlag(oasisItemContributed.getM1800().getFlag());
            m1800.setDiscription(oasisItemContributed.getM1800().getDiscription());
            m1800.setFunctionalPoint(5);
        }

        if(oasisItemContributed.getM1810().getId()==0 && oasisItemContributed.getM1810().getFlag())
        {
            m1810.setId(oasisItemContributed.getM1810().getId());
            m1810.setFlag(oasisItemContributed.getM1810().getFlag());
            m1810.setDiscription(oasisItemContributed.getM1810().getDiscription());
            m1810.setFunctionalPoint(0);
        }
        else  if(oasisItemContributed.getM1810().getId()==1 && oasisItemContributed.getM1810().getFlag())
        {
            m1810.setId(oasisItemContributed.getM1810().getId());
            m1810.setFlag(oasisItemContributed.getM1810().getFlag());
            m1810.setDiscription(oasisItemContributed.getM1810().getDiscription());
            m1810.setFunctionalPoint(0);
        }
        else if(oasisItemContributed.getM1810().getId()==2 && oasisItemContributed.getM1810().getFlag())
        {
            m1810.setId(oasisItemContributed.getM1810().getId());
            m1810.setFlag(oasisItemContributed.getM1810().getFlag());
            m1810.setDiscription(oasisItemContributed.getM1810().getDiscription());
            m1810.setFunctionalPoint(6);
        }
        else if(oasisItemContributed.getM1810().getId()==3 && oasisItemContributed.getM1810().getFlag())
        {
            m1810.setId(oasisItemContributed.getM1810().getId());
            m1810.setFlag(oasisItemContributed.getM1810().getFlag());
            m1810.setDiscription(oasisItemContributed.getM1810().getDiscription());
            m1810.setFunctionalPoint(5);
        }

        if(oasisItemContributed.getM1820().getId()==0 && oasisItemContributed.getM1820().getFlag())
        {
            m1820.setId(oasisItemContributed.getM1820().getId());
            m1820.setFlag(oasisItemContributed.getM1820().getFlag());
            m1820.setDiscription(oasisItemContributed.getM1820().getDiscription());
            m1820.setFunctionalPoint(0);
        }
        else  if(oasisItemContributed.getM1820().getId()==1 && oasisItemContributed.getM1820().getFlag())
        {
            m1820.setId(oasisItemContributed.getM1820().getId());
            m1820.setFlag(oasisItemContributed.getM1820().getFlag());
            m1820.setDiscription(oasisItemContributed.getM1820().getDiscription());
            m1820.setFunctionalPoint(0);
        }
        else if(oasisItemContributed.getM1820().getId()==2 && oasisItemContributed.getM1820().getFlag())
        {
            m1820.setId(oasisItemContributed.getM1820().getId());
            m1820.setFlag(oasisItemContributed.getM1820().getFlag());
            m1820.setDiscription(oasisItemContributed.getM1820().getDiscription());
            m1820.setFunctionalPoint(6);
        }
        else if(oasisItemContributed.getM1820().getId()==3 && oasisItemContributed.getM1820().getFlag())
        {
            m1820.setId(oasisItemContributed.getM1820().getId());
            m1820.setFlag(oasisItemContributed.getM1820().getFlag());
            m1820.setDiscription(oasisItemContributed.getM1820().getDiscription());
            m1820.setFunctionalPoint(6);
        }

        if(oasisItemContributed.getM1830().getId()==0 && oasisItemContributed.getM1830().getFlag())
        {
            m1830.setId(oasisItemContributed.getM1830().getId());
            m1830.setFlag(oasisItemContributed.getM1830().getFlag());
            m1830.setDiscription(oasisItemContributed.getM1830().getDiscription());
            m1830.setFunctionalPoint(0);
        }
        else  if(oasisItemContributed.getM1830().getId()==1 && oasisItemContributed.getM1830().getFlag())
        {
            m1830.setId(oasisItemContributed.getM1830().getId());
            m1830.setFlag(oasisItemContributed.getM1830().getFlag());
            m1830.setDiscription(oasisItemContributed.getM1830().getDiscription());
            m1830.setFunctionalPoint(0);
        }
        else if(oasisItemContributed.getM1830().getId()==2 && oasisItemContributed.getM1830().getFlag())
        {
            m1830.setId(oasisItemContributed.getM1830().getId());
            m1830.setFlag(oasisItemContributed.getM1830().getFlag());
            m1830.setDiscription(oasisItemContributed.getM1830().getDiscription());
            m1830.setFunctionalPoint(3);
        }
        else if(oasisItemContributed.getM1830().getId()==3 && oasisItemContributed.getM1830().getFlag())
        {
            m1830.setId(oasisItemContributed.getM1830().getId());
            m1830.setFlag(oasisItemContributed.getM1830().getFlag());
            m1830.setDiscription(oasisItemContributed.getM1830().getDiscription());
            m1830.setFunctionalPoint(13);
        }
        else if(oasisItemContributed.getM1830().getId()==4 && oasisItemContributed.getM1830().getFlag())
        {
            m1830.setId(oasisItemContributed.getM1830().getId());
            m1830.setFlag(oasisItemContributed.getM1830().getFlag());
            m1830.setDiscription(oasisItemContributed.getM1830().getDiscription());
            m1830.setFunctionalPoint(13);
        }
        else if(oasisItemContributed.getM1830().getId()==5 && oasisItemContributed.getM1830().getFlag())
        {
            m1830.setId(oasisItemContributed.getM1830().getId());
            m1830.setFlag(oasisItemContributed.getM1830().getFlag());
            m1830.setDiscription(oasisItemContributed.getM1830().getDiscription());
            m1830.setFunctionalPoint(20);
        }
        else if(oasisItemContributed.getM1830().getId()==6 && oasisItemContributed.getM1830().getFlag())
        {
            m1830.setId(oasisItemContributed.getM1830().getId());
            m1830.setFlag(oasisItemContributed.getM1830().getFlag());
            m1830.setDiscription(oasisItemContributed.getM1830().getDiscription());
            m1830.setFunctionalPoint(20);
        }

        if(oasisItemContributed.getM1840().getId()==0 && oasisItemContributed.getM1840().getFlag())
        {
            m1840.setId(oasisItemContributed.getM1840().getId());
            m1840.setFlag(oasisItemContributed.getM1840().getFlag());
            m1840.setDiscription(oasisItemContributed.getM1840().getDiscription());
            m1840.setFunctionalPoint(0);
        }
        else  if(oasisItemContributed.getM1840().getId()==1 && oasisItemContributed.getM1840().getFlag())
        {
            m1840.setId(oasisItemContributed.getM1840().getId());
            m1840.setFlag(oasisItemContributed.getM1840().getFlag());
            m1840.setDiscription(oasisItemContributed.getM1840().getDiscription());
            m1840.setFunctionalPoint(0);
        }
        else if(oasisItemContributed.getM1840().getId()==2 && oasisItemContributed.getM1840().getFlag())
        {
            m1840.setId(oasisItemContributed.getM1840().getId());
            m1840.setFlag(oasisItemContributed.getM1840().getFlag());
            m1840.setDiscription(oasisItemContributed.getM1840().getDiscription());
            m1840.setFunctionalPoint(5);
        }
        else if(oasisItemContributed.getM1840().getId()==3 && oasisItemContributed.getM1840().getFlag())
        {
            m1840.setId(oasisItemContributed.getM1840().getId());
            m1840.setFlag(oasisItemContributed.getM1840().getFlag());
            m1840.setDiscription(oasisItemContributed.getM1840().getDiscription());
            m1840.setFunctionalPoint(5);
        }
        else if(oasisItemContributed.getM1840().getId()==4 && oasisItemContributed.getM1840().getFlag())
        {
            m1840.setId(oasisItemContributed.getM1840().getId());
            m1840.setFlag(oasisItemContributed.getM1840().getFlag());
            m1840.setDiscription(oasisItemContributed.getM1840().getDiscription());
            m1840.setFunctionalPoint(5);
        }

        if(oasisItemContributed.getM1850().getId()==0 && oasisItemContributed.getM1850().getFlag())
        {
            m1850.setId(oasisItemContributed.getM1850().getId());
            m1850.setFlag(oasisItemContributed.getM1850().getFlag());
            m1850.setDiscription(oasisItemContributed.getM1850().getDiscription());
            m1850.setFunctionalPoint(0);
        }
        else  if(oasisItemContributed.getM1850().getId()==1 && oasisItemContributed.getM1850().getFlag())
        {
            m1850.setId(oasisItemContributed.getM1850().getId());
            m1850.setFlag(oasisItemContributed.getM1850().getFlag());
            m1850.setDiscription(oasisItemContributed.getM1850().getDiscription());
            m1850.setFunctionalPoint(3);
        }
        else if(oasisItemContributed.getM1850().getId()==2 && oasisItemContributed.getM1850().getFlag())
        {
            m1850.setId(oasisItemContributed.getM1850().getId());
            m1850.setFlag(oasisItemContributed.getM1850().getFlag());
            m1850.setDiscription(oasisItemContributed.getM1850().getDiscription());
            m1850.setFunctionalPoint(7);
        }
        else if(oasisItemContributed.getM1850().getId()==3 && oasisItemContributed.getM1850().getFlag())
        {
            m1850.setId(oasisItemContributed.getM1850().getId());
            m1850.setFlag(oasisItemContributed.getM1850().getFlag());
            m1850.setDiscription(oasisItemContributed.getM1850().getDiscription());
            m1850.setFunctionalPoint(7);
        }
        else if(oasisItemContributed.getM1850().getId()==4 && oasisItemContributed.getM1850().getFlag())
        {
            m1850.setId(oasisItemContributed.getM1850().getId());
            m1850.setFlag(oasisItemContributed.getM1850().getFlag());
            m1850.setDiscription(oasisItemContributed.getM1850().getDiscription());
            m1850.setFunctionalPoint(7);
        }
        else if(oasisItemContributed.getM1850().getId()==5 && oasisItemContributed.getM1850().getFlag())
        {
            m1850.setId(oasisItemContributed.getM1850().getId());
            m1850.setFlag(oasisItemContributed.getM1850().getFlag());
            m1850.setDiscription(oasisItemContributed.getM1850().getDiscription());
            m1850.setFunctionalPoint(7);
        }

        if(oasisItemContributed.getM1860().getId()==0 && oasisItemContributed.getM1860().getFlag())
        {
            m1860.setId(oasisItemContributed.getM1860().getId());
            m1860.setFlag(oasisItemContributed.getM1860().getFlag());
            m1860.setDiscription(oasisItemContributed.getM1860().getDiscription());
            m1860.setFunctionalPoint(0);
        }
        else  if(oasisItemContributed.getM1860().getId()==1 && oasisItemContributed.getM1860().getFlag())
        {
            m1860.setId(oasisItemContributed.getM1860().getId());
            m1860.setFlag(oasisItemContributed.getM1860().getFlag());
            m1860.setDiscription(oasisItemContributed.getM1860().getDiscription());
            m1860.setFunctionalPoint(0);
        }
        else if(oasisItemContributed.getM1860().getId()==2 && oasisItemContributed.getM1860().getFlag())
        {
            m1860.setId(oasisItemContributed.getM1860().getId());
            m1860.setFlag(oasisItemContributed.getM1860().getFlag());
            m1860.setDiscription(oasisItemContributed.getM1860().getDiscription());
            m1860.setFunctionalPoint(9);
        }
        else if(oasisItemContributed.getM1860().getId()==3 && oasisItemContributed.getM1860().getFlag())
        {
            m1860.setId(oasisItemContributed.getM1860().getId());
            m1860.setFlag(oasisItemContributed.getM1860().getFlag());
            m1860.setDiscription(oasisItemContributed.getM1860().getDiscription());
            m1860.setFunctionalPoint(11);
        }
        else if(oasisItemContributed.getM1860().getId()==4 && oasisItemContributed.getM1860().getFlag())
        {
            m1860.setId(oasisItemContributed.getM1860().getId());
            m1860.setFlag(oasisItemContributed.getM1860().getFlag());
            m1860.setDiscription(oasisItemContributed.getM1860().getDiscription());
            m1860.setFunctionalPoint(23);
        }
        else if(oasisItemContributed.getM1860().getId()==5 && oasisItemContributed.getM1860().getFlag())
        {
            m1860.setId(oasisItemContributed.getM1860().getId());
            m1860.setFlag(oasisItemContributed.getM1860().getFlag());
            m1860.setDiscription(oasisItemContributed.getM1860().getDiscription());
            m1860.setFunctionalPoint(23);
        }
        else if(oasisItemContributed.getM1860().getId()==6 && oasisItemContributed.getM1860().getFlag())
        {
            m1860.setId(oasisItemContributed.getM1860().getId());
            m1860.setFlag(oasisItemContributed.getM1860().getFlag());
            m1860.setDiscription(oasisItemContributed.getM1860().getDiscription());
            m1860.setFunctionalPoint(23);
        }
        oasisItemContributed1.setM1800(m1800);
        oasisItemContributed1.setM1810(m1810);
        oasisItemContributed1.setM1820(m1820);
        oasisItemContributed1.setM1830(m1830);
        oasisItemContributed1.setM1840(m1840);
        oasisItemContributed1.setM1850(m1850);
        oasisItemContributed1.setM1860(m1860);

        oasisItemContributedService.save(oasisItemContributed1);
        return "Saved Successfully";

    }
}
