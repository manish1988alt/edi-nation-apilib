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
    M1033Repository m1033Repository;
    @Autowired
    M1800Repository m1800Repository;
    @Autowired
    M1810Repository m1810Repository;
    @Autowired
    M1820Repository m1820Repository;
    @Autowired
    M1830Repository m1830Repository;
    @Autowired
    M1840Repository m1840Repository;
    @Autowired
    M1850Repository m1850Repository;
    @Autowired
    M1860Repository m1860Repository;
    @Autowired
    M1800Service m1800Service;
    @Autowired
    M1810Service m1810Service;
    @Autowired
    M1820Service m1820Service;
    @Autowired
    M1830Service m1830Service;
    @Autowired
    M1840Service m1840Service;
    @Autowired
    M1850Service m1850Service;
    @Autowired
    M1860Service m1860Service;
    @Autowired
    M1033Service m1033Service;

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
        else if(visitdays>30)
        {
            lateVisit=true;
        }
   /*     else if(visitdays>=60&&visitdays<=90)
        {
            earlyVisit=true;
        }
        else if(visitdays>90&&visitdays<=120)
        {
            lateVisit=true;
        }*/
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
    public String pdgmToolPosition3(@RequestBody  OasisItemContributedList oasisItemContributed ) throws Throwable
    {

        M1033 m1033=new M1033();
        M1800 m1800 = new M1800();
        M1810 m1810 = new M1810();
        M1820 m1820 = new M1820();
        M1830 m1830 = new M1830();
        M1840 m1840 = new M1840();
        M1850 m1850 = new M1850();
        M1860 m1860 = new M1860();
        int count=0;
        for(M1033 oasisItemContributedlist:oasisItemContributed.getM1033List())
         {

             if (oasisItemContributedlist.getId() >0 && oasisItemContributedlist.getId() <=7) {

                 if (oasisItemContributedlist.getFlag()) {
                    count= count+1;
                 }
                 if(count>=4 && !(oasisItemContributedlist.getId()==10 && oasisItemContributedlist.getFlag()))
                 {
                     m1033=new M1033();
                     m1033.setId(oasisItemContributedlist.getId());
                     m1033.setFlag(oasisItemContributedlist.getFlag());
                     m1033.setDiscription(oasisItemContributedlist.getDiscription());
                     if(oasisItemContributedlist.getId()==4 && oasisItemContributedlist.getFlag()) {
                         m1033.setFunctionalPoint(11);
                     }
                     m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                     m1033Service.save(m1033);
                 }
                 /*else
                 {
                     m1033=new M1033();
                     m1033.setId(oasisItemContributedlist.getId());
                     m1033.setFlag(oasisItemContributedlist.getFlag());
                     m1033.setDiscription(oasisItemContributedlist.getDiscription());
                     m1033.setFunctionalPoint(0);
                     m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                     m1033Service.save(m1033);

                 }*/


             }
              if(oasisItemContributedlist.getId() >0 && oasisItemContributedlist.getId() <=7 && oasisItemContributedlist.getId()==10)
             {
                 if (oasisItemContributedlist.getFlag()) {
                     count= count+1;
                 }
                 if(count>=4 && oasisItemContributedlist.getId()==10 && oasisItemContributedlist.getFlag())
                 {
                     m1033=new M1033();
                     m1033.setId(oasisItemContributedlist.getId());
                     m1033.setFlag(oasisItemContributedlist.getFlag());
                     m1033.setDiscription(oasisItemContributedlist.getDiscription());
                     m1033.setFunctionalPoint(0);
                     m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                     m1033Service.save(m1033);
                 }

             }
             if (oasisItemContributedlist.getId() >0 && oasisItemContributedlist.getId() <=7 && (oasisItemContributedlist.getId() ==8 || oasisItemContributedlist.getId() ==9))
             {
                 if (oasisItemContributedlist.getFlag()) {
                     count= count+1;
                 }
                 if(count>=4 && (oasisItemContributedlist.getId()==8 && oasisItemContributedlist.getFlag()||oasisItemContributedlist.getId()==9 && !(oasisItemContributedlist.getFlag()&&oasisItemContributedlist.getId()==10)))
                 {
                     m1033=new M1033();
                     m1033.setId(oasisItemContributedlist.getId());
                     m1033.setFlag(oasisItemContributedlist.getFlag());
                     m1033.setDiscription(oasisItemContributedlist.getDiscription());
                     if(oasisItemContributedlist.getId()==4 && oasisItemContributedlist.getFlag()) {
                         m1033.setFunctionalPoint(11);
                     }
                     m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                     m1033Service.save(m1033);
                 }
               if(count<4 && (oasisItemContributedlist.getId()==8 && oasisItemContributedlist.getFlag()||oasisItemContributedlist.getId()==9 &&oasisItemContributedlist.getFlag()) && !(oasisItemContributedlist.getFlag()&&oasisItemContributedlist.getId()==10))
                 {
                     m1033=new M1033();
                     m1033.setId(oasisItemContributedlist.getId());
                     m1033.setFlag(oasisItemContributedlist.getFlag());
                     m1033.setDiscription(oasisItemContributedlist.getDiscription());
                     m1033.setFunctionalPoint(0);
                     m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                     m1033Service.save(m1033);
                 }
                 if(count>=4 && (oasisItemContributedlist.getId()==8 && oasisItemContributedlist.getFlag()||oasisItemContributedlist.getId()==9 && oasisItemContributedlist.getFlag()) && (oasisItemContributedlist.getId()==10 && oasisItemContributedlist.getFlag()))
                 {
                     m1033=new M1033();
                     m1033.setId(oasisItemContributedlist.getId());
                     m1033.setFlag(oasisItemContributedlist.getFlag());
                     m1033.setDiscription(oasisItemContributedlist.getDiscription());
                     m1033.setFunctionalPoint(0);
                     m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                     m1033Service.save(m1033);
                 }

             }
            /* if (oasisItemContributedlist.getId() >0 && oasisItemContributedlist.getId() <=7 && (oasisItemContributedlist.getId() ==8 || oasisItemContributedlist.getId() ==9) && oasisItemContributedlist.getId()==10)
             {
                 if (oasisItemContributedlist.getFlag()) {
                     count= count+1;
                 }
                 if(count>=4 && (oasisItemContributedlist.getId()==8 && oasisItemContributedlist.getFlag()||oasisItemContributedlist.getId()==9 && oasisItemContributedlist.getFlag()) && (oasisItemContributedlist.getId()==10 && oasisItemContributedlist.getFlag()))
                 {
                     m1033=new M1033();
                     m1033.setId(oasisItemContributedlist.getId());
                     m1033.setFlag(oasisItemContributedlist.getFlag());
                     m1033.setDiscription(oasisItemContributedlist.getDiscription());
                     m1033.setFunctionalPoint(0);
                     m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                     m1033Service.save(m1033);
                 }

             }*/
             if (oasisItemContributedlist.getId() ==1)
             {
                 m1033=new M1033();
                 m1033.setId(oasisItemContributedlist.getId());
                 m1033.setFlag(oasisItemContributedlist.getFlag());
                 m1033.setDiscription(oasisItemContributedlist.getDiscription());
                 m1033.setFunctionalPoint(0);
                 m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                 m1033Service.save(m1033);
             }
             if (oasisItemContributedlist.getId() ==2)
             {
                 m1033=new M1033();
                 m1033.setId(oasisItemContributedlist.getId());
                 m1033.setFlag(oasisItemContributedlist.getFlag());
                 m1033.setDiscription(oasisItemContributedlist.getDiscription());
                 m1033.setFunctionalPoint(0);
                 m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                 m1033Service.save(m1033);
             }
             if (oasisItemContributedlist.getId() ==3)
             {
                 m1033=new M1033();
                 m1033.setId(oasisItemContributedlist.getId());
                 m1033.setFlag(oasisItemContributedlist.getFlag());
                 m1033.setDiscription(oasisItemContributedlist.getDiscription());
                 m1033.setFunctionalPoint(0);
                 m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                 m1033Service.save(m1033);
             }/*
             if (oasisItemContributedlist.getId() ==4)
             {
                 m1033=new M1033();
                 m1033.setId(oasisItemContributedlist.getId());
                 m1033.setFlag(oasisItemContributedlist.getFlag());
                 m1033.setDiscription(oasisItemContributedlist.getDiscription());
                 m1033.setFunctionalPoint(0);
                 m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                 m1033Service.save(m1033);
             }
             if (oasisItemContributedlist.getId() ==5)
             {
                 m1033=new M1033();
                 m1033.setId(oasisItemContributedlist.getId());
                 m1033.setFlag(oasisItemContributedlist.getFlag());
                 m1033.setDiscription(oasisItemContributedlist.getDiscription());
                 m1033.setFunctionalPoint(0);
                 m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                 m1033Service.save(m1033);
             }
             if (oasisItemContributedlist.getId() ==6)
             {
                 m1033=new M1033();
                 m1033.setId(oasisItemContributedlist.getId());
                 m1033.setFlag(oasisItemContributedlist.getFlag());
                 m1033.setDiscription(oasisItemContributedlist.getDiscription());
                 m1033.setFunctionalPoint(0);
                 m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                 m1033Service.save(m1033);
             }
             if (oasisItemContributedlist.getId() ==7)
             {
                 m1033=new M1033();
                 m1033.setId(oasisItemContributedlist.getId());
                 m1033.setFlag(oasisItemContributedlist.getFlag());
                 m1033.setDiscription(oasisItemContributedlist.getDiscription());
                 m1033.setFunctionalPoint(0);
                 m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                 m1033Service.save(m1033);
             }*/
             if (oasisItemContributedlist.getId() ==8)
             {
                 m1033=new M1033();
                 m1033.setId(oasisItemContributedlist.getId());
                 m1033.setFlag(oasisItemContributedlist.getFlag());
                 m1033.setDiscription(oasisItemContributedlist.getDiscription());
                 m1033.setFunctionalPoint(0);
                 m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                 m1033Service.save(m1033);
             }
             if (oasisItemContributedlist.getId() ==9)
             {
                 m1033=new M1033();
                 m1033.setId(oasisItemContributedlist.getId());
                 m1033.setFlag(oasisItemContributedlist.getFlag());
                 m1033.setDiscription(oasisItemContributedlist.getDiscription());
                 m1033.setFunctionalPoint(0);
                 m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                 m1033Service.save(m1033);
             }
             if ( oasisItemContributedlist.getId()==10)
             {
                 m1033=new M1033();
                 m1033.setId(oasisItemContributedlist.getId());
                 m1033.setFlag(oasisItemContributedlist.getFlag());
                 m1033.setDiscription(oasisItemContributedlist.getDiscription());
                 m1033.setFunctionalPoint(0);
                 m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                 m1033Service.save(m1033);
             }
         }
        for(M1800 oasisItemContributedlist:oasisItemContributed.getM1800List())
        {
            if (oasisItemContributedlist.getId() == 0) {
                m1800=new M1800();
                m1800.setId(oasisItemContributedlist.getId());
                m1800.setFlag(oasisItemContributedlist.getFlag());
                m1800.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1800.setFunctionalPoint(0);
                }
                m1800.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1800Service.save(m1800);

            }
            if (oasisItemContributedlist.getId() == 1) {
                m1800=new M1800();
                m1800.setId(oasisItemContributedlist.getId());
                m1800.setFlag(oasisItemContributedlist.getFlag());
                m1800.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1800.setFunctionalPoint(0);
                }
                m1800.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1800Service.save(m1800);
            }
            if (oasisItemContributedlist.getId() == 2) {
                m1800=new M1800();
                m1800.setId(oasisItemContributedlist.getId());
                m1800.setFlag(oasisItemContributedlist.getFlag());
                m1800.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1800.setFunctionalPoint(5);
                }
                m1800.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1800Service.save(m1800);
            }
            if (oasisItemContributedlist.getId() == 3 ) {
                m1800=new M1800();
                m1800.setId(oasisItemContributedlist.getId());
                m1800.setFlag(oasisItemContributedlist.getFlag());
                m1800.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1800.setFunctionalPoint(5);
                }
                m1800.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1800Service.save(m1800);
            }
        }
        for(M1810 oasisItemContributedlist:oasisItemContributed.getM1810List())
        {
            if (oasisItemContributedlist.getId() == 0) {
                m1810=new M1810();
                m1810.setId(oasisItemContributedlist.getId());
                m1810.setFlag(oasisItemContributedlist.getFlag());
                m1810.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1810.setFunctionalPoint(0);
                }
                m1810.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1810Service.save(m1810);
            }
            if (oasisItemContributedlist.getId() == 1) {
                m1810=new M1810();
                m1810.setId(oasisItemContributedlist.getId());
                m1810.setFlag(oasisItemContributedlist.getFlag());
                m1810.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1810.setFunctionalPoint(0);
                }
                m1810.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1810Service.save(m1810);
            }
            if (oasisItemContributedlist.getId() == 2 ) {
                m1810=new M1810();
                m1810.setId(oasisItemContributedlist.getId());
                m1810.setFlag(oasisItemContributedlist.getFlag());
                m1810.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1810.setFunctionalPoint(6);
                }
                m1810.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1810Service.save(m1810);
            }
            if (oasisItemContributedlist.getId() == 3) {
                m1810=new M1810();
                m1810.setId(oasisItemContributedlist.getId());
                m1810.setFlag(oasisItemContributedlist.getFlag());
                m1810.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1810.setFunctionalPoint(5);
                }
                m1810.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1810Service.save(m1810);
            }
        }
        for(M1820 oasisItemContributedlist:oasisItemContributed.getM1820List())
        {
            if (oasisItemContributedlist.getId() == 0) {
                m1820=new M1820();
                m1820.setId(oasisItemContributedlist.getId());
                m1820.setFlag(oasisItemContributedlist.getFlag());
                m1820.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1820.setFunctionalPoint(0);
                }
                m1820.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1820Service.save(m1820);
            }
            if (oasisItemContributedlist.getId() == 1) {
                m1820=new M1820();
                m1820.setId(oasisItemContributedlist.getId());
                m1820.setFlag(oasisItemContributedlist.getFlag());
                m1820.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1820.setFunctionalPoint(0);
                }
                m1820.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1820Service.save(m1820);
            }
            if (oasisItemContributedlist.getId() == 2) {
                m1820=new M1820();
                m1820.setId(oasisItemContributedlist.getId());
                m1820.setFlag(oasisItemContributedlist.getFlag());
                m1820.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1820.setFunctionalPoint(6);
                }
                m1820.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1820Service.save(m1820);
            }
            if (oasisItemContributedlist.getId() == 3) {
                m1820=new M1820();
                m1820.setId(oasisItemContributedlist.getId());
                m1820.setFlag(oasisItemContributedlist.getFlag());
                m1820.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1820.setFunctionalPoint(6);
                }
                m1820.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1820Service.save(m1820);
            }

        }
        for(M1830 oasisItemContributedlist:oasisItemContributed.getM1830List())
        {
            if (oasisItemContributedlist.getId() == 0) {
                m1830=new M1830();
                m1830.setId(oasisItemContributedlist.getId());
                m1830.setFlag(oasisItemContributedlist.getFlag());
                m1830.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1830.setFunctionalPoint(0);
                }
                m1830.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1830Service.save(m1830);
            }
            if (oasisItemContributedlist.getId() == 1) {
                m1830=new M1830();
                m1830.setId(oasisItemContributedlist.getId());
                m1830.setFlag(oasisItemContributedlist.getFlag());
                m1830.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1830.setFunctionalPoint(0);
                }
                m1830.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1830Service.save(m1830);
            }
            if (oasisItemContributedlist.getId() == 2) {
                m1830=new M1830();
                m1830.setId(oasisItemContributedlist.getId());
                m1830.setFlag(oasisItemContributedlist.getFlag());
                m1830.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1830.setFunctionalPoint(3);
                }
                m1830.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1830Service.save(m1830);
            }
            if (oasisItemContributedlist.getId() == 3) {
                m1830.setId(oasisItemContributedlist.getId());
                m1830.setFlag(oasisItemContributedlist.getFlag());
                m1830.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1830.setFunctionalPoint(13);
                }
                m1830.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1830Service.save(m1830);
            }
            if (oasisItemContributedlist.getId() == 4) {
                m1830=new M1830();
                m1830.setId(oasisItemContributedlist.getId());
                m1830.setFlag(oasisItemContributedlist.getFlag());
                m1830.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1830.setFunctionalPoint(13);
                }
                m1830.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1830Service.save(m1830);
            }
            if (oasisItemContributedlist.getId() == 5) {
                m1830=new M1830();
                m1830.setId(oasisItemContributedlist.getId());
                m1830.setFlag(oasisItemContributedlist.getFlag());
                m1830.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1830.setFunctionalPoint(20);
                }
                m1830.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1830Service.save(m1830);
            }
            if (oasisItemContributedlist.getId() == 6) {
                m1830=new M1830();
                m1830.setId(oasisItemContributedlist.getId());
                m1830.setFlag(oasisItemContributedlist.getFlag());
                m1830.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1830.setFunctionalPoint(20);
                }
                m1830.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1830Service.save(m1830);
            }

        }
        for(M1840 oasisItemContributedlist:oasisItemContributed.getM1840List())
        {
            if (oasisItemContributedlist.getId() == 0) {
                m1840=new M1840();
                m1840.setId(oasisItemContributedlist.getId());
                m1840.setFlag(oasisItemContributedlist.getFlag());
                m1840.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1840.setFunctionalPoint(0);
                }
                m1840.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1840Service.save(m1840);
            }
            if (oasisItemContributedlist.getId() == 1) {
                m1840=new M1840();
                m1840.setId(oasisItemContributedlist.getId());
                m1840.setFlag(oasisItemContributedlist.getFlag());
                m1840.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1840.setFunctionalPoint(0);
                }
                m1840.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1840Service.save(m1840);
            }
            if (oasisItemContributedlist.getId() == 2) {
                m1840=new M1840();
                m1840.setId(oasisItemContributedlist.getId());
                m1840.setFlag(oasisItemContributedlist.getFlag());
                m1840.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1840.setFunctionalPoint(5);
                }
                m1840.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1840Service.save(m1840);
            }
            if (oasisItemContributedlist.getId() == 3) {
                m1840=new M1840();
                m1840.setId(oasisItemContributedlist.getId());
                m1840.setFlag(oasisItemContributedlist.getFlag());
                m1840.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1840.setFunctionalPoint(5);
                }
                m1840.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1840Service.save(m1840);
            }
            if (oasisItemContributedlist.getId() == 4) {
                m1840=new M1840();
                m1840.setId(oasisItemContributedlist.getId());
                m1840.setFlag(oasisItemContributedlist.getFlag());
                m1840.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1840.setFunctionalPoint(5);
                }
                m1840.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1840Service.save(m1840);
            }

        }
        for(M1850 oasisItemContributedlist:oasisItemContributed.getM1850List())
        {
            if (oasisItemContributedlist.getId() == 0) {
                m1850=new M1850();
                m1850.setId(oasisItemContributedlist.getId());
                m1850.setFlag(oasisItemContributedlist.getFlag());
                m1850.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1850.setFunctionalPoint(0);
                }
                m1850.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1850Service.save(m1850);
            }
            if (oasisItemContributedlist.getId() == 1) {
                m1850=new M1850();
                m1850.setId(oasisItemContributedlist.getId());
                m1850.setFlag(oasisItemContributedlist.getFlag());
                m1850.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1850.setFunctionalPoint(3);
                }
                m1850.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1850Service.save(m1850);
            }
            if (oasisItemContributedlist.getId() == 2) {
                m1850=new M1850();
                m1850.setId(oasisItemContributedlist.getId());
                m1850.setFlag(oasisItemContributedlist.getFlag());
                m1850.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1850.setFunctionalPoint(7);
                }
                m1850.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1850Service.save(m1850);
            }
            if (oasisItemContributedlist.getId() == 3) {
                m1850=new M1850();
                m1850.setId(oasisItemContributedlist.getId());
                m1850.setFlag(oasisItemContributedlist.getFlag());
                m1850.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1850.setFunctionalPoint(7);
                }
                m1850.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1850Service.save(m1850);
            }
            if (oasisItemContributedlist.getId() == 4) {
                m1850=new M1850();
                m1850.setId(oasisItemContributedlist.getId());
                m1850.setFlag(oasisItemContributedlist.getFlag());
                m1850.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1850.setFunctionalPoint(7);
                }
                m1850.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1850Service.save(m1850);
            }
            if (oasisItemContributedlist.getId() == 5) {
                m1850=new M1850();
                m1850.setId(oasisItemContributedlist.getId());
                m1850.setFlag(oasisItemContributedlist.getFlag());
                m1850.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1850.setFunctionalPoint(7);
                }
                m1850.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1850Service.save(m1850);
            }
        }
        for(M1860 oasisItemContributedlist:oasisItemContributed.getM1860List())
        {

            if (oasisItemContributedlist.getId() == 0) {
                m1860=new M1860();
                m1860.setId(oasisItemContributedlist.getId());
                m1860.setFlag(oasisItemContributedlist.getFlag());
                m1860.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1860.setFunctionalPoint(0);
                }
                m1860.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1860Service.save(m1860);
            }
            if (oasisItemContributedlist.getId() == 1) {
                m1860=new M1860();
                m1860.setId(oasisItemContributedlist.getId());
                m1860.setFlag(oasisItemContributedlist.getFlag());
                m1860.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1860.setFunctionalPoint(0);
                }
                m1860.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1860Service.save(m1860);
            }
            if (oasisItemContributedlist.getId() == 2) {
                m1860=new M1860();
                m1860.setId(oasisItemContributedlist.getId());
                m1860.setFlag(oasisItemContributedlist.getFlag());
                m1860.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1860.setFunctionalPoint(9);
                }
                m1860.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1860Service.save(m1860);
            }
            if (oasisItemContributedlist.getId() == 3) {
                m1860=new M1860();
                m1860.setId(oasisItemContributedlist.getId());
                m1860.setFlag(oasisItemContributedlist.getFlag());
                m1860.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1860.setFunctionalPoint(11);
                }
                m1860.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1860Service.save(m1860);
            }
            if (oasisItemContributedlist.getId() == 4) {
                m1860=new M1860();
                m1860.setId(oasisItemContributedlist.getId());
                m1860.setFlag(oasisItemContributedlist.getFlag());
                m1860.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1860.setFunctionalPoint(23);
                }
                m1860.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1860Service.save(m1860);
            }
            if (oasisItemContributedlist.getId() == 5) {
                m1860=new M1860();
                m1860.setId(oasisItemContributedlist.getId());
                m1860.setFlag(oasisItemContributedlist.getFlag());
                m1860.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1860.setFunctionalPoint(23);
                }
                m1860.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1860Service.save(m1860);
            }
            if (oasisItemContributedlist.getId() == 6) {
                m1860=new M1860();
                m1860.setId(oasisItemContributedlist.getId());
                m1860.setFlag(oasisItemContributedlist.getFlag());
                m1860.setDiscription(oasisItemContributedlist.getDiscription());
                if (oasisItemContributedlist.getFlag()) {
                    m1860.setFunctionalPoint(23);
                }
                m1860.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1860Service.save(m1860);
            }
        }


        return "Saved Successfully";

    }


    @PostMapping("/pdgmToolPosition3Oasis")
    public List<Object> pdgmToolPosition3Oasis(@RequestBody  PDGMRapListing pdgmRapList ) throws Throwable
    {
        List<Object> list=new ArrayList<>();
        List<ClinicalGroupingPrimaryDiagnosis> clinicalGroupingPrimaryDiagnosesList=pdgmRapListRepository.findClinicalGroupingPrimaryDiagnosis(pdgmRapList.getPrimaryDiagnosisCode());
        String subgroup="";
        int functionpoint=0;
        for(ClinicalGroupingPrimaryDiagnosis clinicalGroupingPrimaryDiagnosis:clinicalGroupingPrimaryDiagnosesList)
        {
          subgroup= clinicalGroupingPrimaryDiagnosis.getClinicalGroup();
        }

        List<M1033> m1033List=m1033Repository.findM1033ByMrnNumber(pdgmRapList.getMrnNumber());
        List<M1800> m1800List=m1800Repository.findM1800ByMrnNumber(pdgmRapList.getMrnNumber());
        List<M1810> m1810List=m1810Repository.findM1810ByMrnNumber(pdgmRapList.getMrnNumber());
        List<M1820> m1820List=m1820Repository.findM1820ByMrnNumber(pdgmRapList.getMrnNumber());
        List<M1830> m1830List=m1830Repository.findM1830ByMrnNumber(pdgmRapList.getMrnNumber());
        List<M1840> m1840List=m1840Repository.findM1840ByMrnNumber(pdgmRapList.getMrnNumber());
        List<M1850> m1850List=m1850Repository.findM1850ByMrnNumber(pdgmRapList.getMrnNumber());
        List<M1860> m1860List=m1860Repository.findM1860ByMrnNumber(pdgmRapList.getMrnNumber());
        //List<OASISItemContributed> oasisItemContributedList=oasisItemContributedRepository.findByMrnNumber(pdgmRapList.getMrnNumber());
        for(M1033 m1033:m1033List) {
            if (m1033.getFlag()) {
                functionpoint = functionpoint + m1033.getFunctionalPoint();
            }
        }
        for(M1800 m1800:m1800List) {
            if (m1800.getFlag()) {
                functionpoint = functionpoint + m1800.getFunctionalPoint();
            }
        }

        for(M1810 m1810:m1810List) {
            if (m1810.getFlag()) {
                functionpoint = functionpoint + m1810.getFunctionalPoint();
            }
        }
        for(M1820 m1820:m1820List) {
            if (m1820.getFlag()) {
                functionpoint = functionpoint + m1820.getFunctionalPoint();
            }
        }
        for(M1830 m1830:m1830List) {
            if (m1830.getFlag()) {
                functionpoint = functionpoint + m1830.getFunctionalPoint();
            }
        }
        for(M1840 m1840:m1840List) {
            if (m1840.getFlag()) {
                functionpoint = functionpoint + m1840.getFunctionalPoint();
            }
        }

        for(M1850 m1850:m1850List) {
            if (m1850.getFlag()) {
                functionpoint = functionpoint + m1850.getFunctionalPoint();
            }
        }

        for(M1860 m1860:m1860List) {
            if (m1860.getFlag()) {
                functionpoint = functionpoint + m1860.getFunctionalPoint();
            }
        }

        OasisItemContributedList oasisItemContributedList1=new OasisItemContributedList();

        oasisItemContributedList1.setM1033List(m1033List);
        oasisItemContributedList1.setM1800List(m1800List);
        oasisItemContributedList1.setM1810List(m1810List);
        oasisItemContributedList1.setM1820List(m1820List);
        oasisItemContributedList1.setM1830List(m1830List);
        oasisItemContributedList1.setM1840List(m1840List);
        oasisItemContributedList1.setM1850List(m1850List);
        oasisItemContributedList1.setM1860List(m1860List);
      List<CalculationClinicalGroupHIPPSCode> calculationClinicalGroupHIPPSCodes=pdgmRapListRepository.findCalculationClinicalGroupHIPPSCode(subgroup,functionpoint);
       // list.addAll(oasisItemContributedList);
        list.add(oasisItemContributedList1);
        list.addAll(calculationClinicalGroupHIPPSCodes);

        return list;
    }


}
