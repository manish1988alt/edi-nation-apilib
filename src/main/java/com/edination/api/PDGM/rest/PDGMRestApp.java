package com.edination.api.PDGM.rest;


import com.edination.api.PDGM.model.DiagnosisCode;
import com.edination.api.PDGM.dao.*;
import com.edination.api.PDGM.model.*;
import com.edination.api.rap.Dao.BillingDetailsRepository;
import com.edination.api.rap.Dao.BillingDetailsService;
import com.edination.api.rap.model.BillingDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;

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
    @Autowired
    HighComorbidityConditionRepository highComorbidityConditionRepository;
    @Autowired
    SecondDaignosisCodeRepository secondDaignosisCodeRepository;
    @Autowired
    SecondDiagnosisCodeService secondDiagnosisCodeService;
    @Autowired
    HighComorbidityConditionService highComorbidityConditionService;
    @Autowired
    LowComorbidityConditionRepository lowComorbidityConditionRepository;
    @Autowired
    LowComorbidityConditionService lowComorbidityConditionService;
    @Autowired
    ComorbidityTypeAndHippsCodeService comorbidityTypeAndHippsCodeService;
    @Autowired
    HippsCodeAndCaseMixWeightRepository hippsCodeAndCaseMixWeightRepository;
    @Autowired
    HippsCodeAndCaseMixWeightService hippsCodeAndCaseMixWeightService;
    @Autowired
    BillingDetailsRepository billingDetailsRepository;
    @Autowired
    BillingDetailsService billingDetailsService;
    ;
    @GetMapping("/rapList")
    public List<PDGMRapListing> rapList()  throws Throwable{
     List<PDGMRapListing> pdgmRapListings=new ArrayList<>();

       for(PDGMRapListing rapListing: pdgmRapListService.listAll())
       {
           PDGMRapListing pdgmObject=new PDGMRapListing();
           pdgmObject.setAction(rapListing.getAction());
           pdgmObject.setRapsFormStatus(rapListing.getRapsFormStatus());
           if("No Action".equals(pdgmObject.getRapsFormStatus()) || "".equals(pdgmObject.getRapsFormStatus()))
           {
               pdgmObject.setRapsType("NA");
               pdgmObject.setRapsSentDate("No Value");
           }
          else
           {
               pdgmObject.setRapsType(rapListing.getRapsType());
               pdgmObject.setRapsSentDate(rapListing.getRapsSentDate());
           }
           pdgmObject.setMrnNumber(rapListing.getMrnNumber());
           pdgmObject.setHippsCodeGeneratedDate(rapListing.getHippsCodeGeneratedDate());
           pdgmObject.setHippsCode(rapListing.getHippsCode());
           pdgmObject.setAging(rapListing.getAging());
           pdgmObject.setBillableVisit(rapListing.getBillableVisit());
           pdgmObject.setClaimType(rapListing.getClaimType());
           pdgmObject.setOasisKey(rapListing.getOasisKey());
           pdgmObject.setOasisType(rapListing.getOasisType());
           pdgmObject.setEpisodeId(rapListing.getEpisodeId());
           pdgmObject.setPrimaryDiagnosisCode(rapListing.getPrimaryDiagnosisCode());
           pdgmObject.setEpisodeEndDates(rapListing.getEpisodeEndDates());
           pdgmObject.setEpisodeStartDates(rapListing.getEpisodeStartDates());
           pdgmObject.setSuffix(rapListing.getSuffix());
           pdgmObject.setMiddleName(rapListing.getMiddleName());
           pdgmObject.setLastName(rapListing.getLastName());
           pdgmObject.setFirstName(rapListing.getFirstName());
           pdgmRapListings.add(pdgmObject);

       }
       return pdgmRapListings;
    }

    @PostMapping("/pdgmTool")
    public List<Object> pdgmTool(@RequestBody  PDGMRapListing pdgmRapList ) throws Throwable
    {
        String position1="";
        String position2="";
        String position3="";
        String position4="";
        String position5="1";
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
        long sourcedays = ChronoUnit.DAYS.between(episodedateBefore,referralBefore);
        System.out.println(sourcedays);
        String sourceOfAdmission=admissionSource.getSouceOfAdmission();
        if(("Non-Healthcare Facility Point Of Origin".equals(sourceOfAdmission)||"Clinic Or Physician’s Office".equals(sourceOfAdmission)||"Court/Law Enforcement".equals(sourceOfAdmission)))
        {
            community=true;
        }
      else  if(sourcedays<=14&&("Transfer from Hospital (Different Facility)".equals(sourceOfAdmission)||"Transfer from Skilled Nursing Facility (SNF)".equals(sourceOfAdmission) || "Intermediate Care Facility (ICF)".equals(sourceOfAdmission)||"Transfer from Another Healthcare Facility".equals(sourceOfAdmission)||"Clinic Or Physician’s Office".equals(sourceOfAdmission)))
        {
            institutional=true;
        }
        else  if(sourcedays>14&&("Transfer from Hospital (Different Facility)".equals(sourceOfAdmission)||"Transfer from Skilled Nursing Facility (SNF)".equals(sourceOfAdmission) ||"Intermediate Care Facility (ICF)".equals(sourceOfAdmission)||"Transfer from Another Healthcare Facility".equals(sourceOfAdmission)||"Clinic Or Physician’s Office".equals(sourceOfAdmission)))
        {
            community=true;
        }
      if(earlyVisit&&community)
      {
          postionCode=1;
          position1="1";
      }
        if(lateVisit&&community)
        {
            postionCode=3;
            position1="3";
        }
        if(earlyVisit&&institutional)
        {
            postionCode=2;
            position1="2";
        }
        if(lateVisit&&institutional)
        {
            postionCode=4;
            position1="4";
        }
        TimingAndSourceOfAdmission timingAndSourceOfAdmission=new TimingAndSourceOfAdmission(admissionSource.getMrnNumber(),earlyVisit,lateVisit,community,institutional,postionCode);
        timingAndSourceService.save(timingAndSourceOfAdmission);

        EpisodeDetail episodeDetail=episodeDetailService.get(pdgmRapList.getMrnNumber());
        List<TimingAndSourceOfAdmission> timingAndSourceOfAdmissionsList=pdgmRapListRepository.findTimingSourceByMrn(pdgmRapList.getMrnNumber());

        list.add(episodeDetail);
        list.addAll(timingAndSourceOfAdmissionsList);

        List<ClinicalGroupingPrimaryDiagnosis> clinicalGroupingPrimaryDiagnoses=pdgmRapListRepository.findClinicalGroupingPrimaryDiagnosis(pdgmRapList.getPrimaryDiagnosisCode());
        list.addAll(clinicalGroupingPrimaryDiagnoses);
        for(ClinicalGroupingPrimaryDiagnosis clinicalGroupingPrimaryDiagnosesPosition:clinicalGroupingPrimaryDiagnoses)
        {
            position2=clinicalGroupingPrimaryDiagnosesPosition.getSecondPositionHIPPSCode();
        }

        List<Object> listposition3= this.position3Operation(pdgmRapList);
        CalculationClinicalGroupHIPPSCode groupHIPPSCode=(CalculationClinicalGroupHIPPSCode)listposition3.get(1);
        position3=groupHIPPSCode.getHIPPSCode();


        ComorbidityTypeAndHippsCode comorbidityTypeAndHippsCodes=highComorbidityConditionRepository.findComorbidityTypeByMrn(pdgmRapList.getMrnNumber());
        position4=comorbidityTypeAndHippsCodes.getHippsCode();

        Set<SecondDiagnosisCode> secondDiagnosisCodeVal=secondDaignosisCodeRepository.findSecondDiagnosisCodeByMrn(pdgmRapList.getMrnNumber());
        SecondDaignosisCodeList secondDaignosisCodeList =new SecondDaignosisCodeList();
        secondDaignosisCodeList.setComorbidityTypeAndHippsCode(comorbidityTypeAndHippsCodes);
        secondDaignosisCodeList.setSecondDiagnosisCodeList(secondDiagnosisCodeVal);
        list.add(secondDaignosisCodeList);

        String finalHippsCode=position1.trim()+position2.trim()+position3.trim()+position4.trim()+position5.trim();
        HippsCodeWeight hippsCodeWeight=hippsCodeAndCaseMixWeightRepository.findHippsCodeByMrn(finalHippsCode);



        HippsCodeAndCaseMixWeight hippsCodeAndCaseMixWeight=new HippsCodeAndCaseMixWeight();
        hippsCodeAndCaseMixWeight.setMrnNumber(pdgmRapList.getMrnNumber());
        hippsCodeAndCaseMixWeight.setPosition1(position1);
        hippsCodeAndCaseMixWeight.setPosition2(position2);
        hippsCodeAndCaseMixWeight.setPosition3(position3);
        hippsCodeAndCaseMixWeight.setPosition4(position4);
        hippsCodeAndCaseMixWeight.setPosition5(position5);
        hippsCodeAndCaseMixWeight.setHippscode(hippsCodeWeight.getHippscode());
        hippsCodeAndCaseMixWeight.setWeight(hippsCodeWeight.getWeight());
        hippsCodeAndCaseMixWeightService.save(hippsCodeAndCaseMixWeight);

       List<HippsCodeAndCaseMixWeight> hippsCodeAndCaseMixWeightList =hippsCodeAndCaseMixWeightRepository.findHippsCodeAndCaseMixWeighByMrn(pdgmRapList.getMrnNumber());
        list.addAll(hippsCodeAndCaseMixWeightList);
        return list;
    }

    @PostMapping("/pdgmInsertCode")
    public  ResponseEntity<?> pdgmInsertCode(@RequestBody  PDGMRapListing pdgmRapList ) throws Throwable
    {
        List<HippsCodeAndCaseMixWeight> hippsCodeAndCaseMixWeightList =hippsCodeAndCaseMixWeightRepository.findHippsCodeAndCaseMixWeighByMrn(pdgmRapList.getMrnNumber());
        String currentDate = java.time.LocalDate.now().toString();
        LocalDate hippsCodeGenerationDate=LocalDate.parse(currentDate);
        PDGMRapListing rapListing=new PDGMRapListing();
        rapListing.setMrnNumber(pdgmRapList.getMrnNumber());
        for(HippsCodeAndCaseMixWeight hippsCodeAndCaseMixWeight:hippsCodeAndCaseMixWeightList)
        {
            rapListing.setHippsCode(hippsCodeAndCaseMixWeight.getHippscode());
        }
        rapListing.setAging(pdgmRapList.getAging());
        rapListing.setBillableVisit(pdgmRapList.getBillableVisit());
        rapListing.setClaimType(pdgmRapList.getClaimType());
        rapListing.setEpisodeEndDates(pdgmRapList.getEpisodeEndDates());
        rapListing.setEpisodeId(pdgmRapList.getEpisodeId());
        rapListing.setFirstName(pdgmRapList.getFirstName());
        rapListing.setLastName(pdgmRapList.getLastName());
        rapListing.setMiddleName(pdgmRapList.getMiddleName());
        rapListing.setSuffix(pdgmRapList.getSuffix());
        rapListing.setOasisKey(pdgmRapList.getOasisKey());
        rapListing.setOasisType(pdgmRapList.getOasisType());
        rapListing.setPrimaryDiagnosisCode(pdgmRapList.getPrimaryDiagnosisCode());
        rapListing.setEpisodeStartDates(pdgmRapList.getEpisodeStartDates());
        rapListing.setHippsCodeGeneratedDate(hippsCodeGenerationDate);
        rapListing.setRapsSentDate(pdgmRapList.getRapsSentDate());
        rapListing.setRapsType(pdgmRapList.getRapsType());
        rapListing.setRapsFormStatus(pdgmRapList.getRapsFormStatus());
        rapListing.setAction(pdgmRapList.getAction());
        pdgmRapListService.save(rapListing);
        List<BillingDetails> billingDetailsList = billingDetailsRepository.findBillingDetailsByMrnNumber(pdgmRapList.getMrnNumber());
        for(BillingDetails bl:billingDetailsList)
        {

            BillingDetails billingDetails=new BillingDetails();
            billingDetails.setMrnNumber(bl.getMrnNumber());
            for(HippsCodeAndCaseMixWeight hippsCodeAndCaseMixWeight:hippsCodeAndCaseMixWeightList)
            {
                billingDetails.sethCPCS_Rate_HCPCS_Code(hippsCodeAndCaseMixWeight.getHippscode());
            }

            billingDetails.setTotalCostForTotalCharge(bl.getTotalCostForTotalCharge());
            billingDetails.setTotalCostForNonCoverageCharge(bl.getTotalCostForNonCoverageCharge());
            billingDetails.setTotalCharge(bl.getTotalCharge());
            billingDetails.setServiceUnit(bl.getServiceUnit());
            billingDetails.setServiceDate(hippsCodeGenerationDate);
            billingDetails.setRevenueCode("0023");
            billingDetails.setRevenueCodeDescription(bl.getRevenueCodeDescription());
            billingDetails.setNonCoverageCharge(bl.getNonCoverageCharge());
            billingDetails.setCreationDate(bl.getCreationDate());
            billingDetails.setCount(bl.getCount());
            billingDetailsService.save(billingDetails);
        }

        String ackn="Success";
        if(ackn.equals("Success")) {
            return generateSuccessObject("Success",
                    " ");
        }
        else
        {
            return generateSuccessObject("Error",
                    "Sent failed ");
        }
    }

   @PostMapping("/pdgmToolPosition3")
    public ResponseEntity<?> pdgmToolPosition3(@RequestBody  OasisItemContributedList oasisItemContributed ) throws Throwable
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

        boolean  functionFlag=true;
        boolean  functionTenFlag=false;
        Map<Integer,Boolean> flagList=new HashMap<>();
        Map<Integer,String> discriptionList=new HashMap<>();
        for(M1033 oasisItemContributedlist:oasisItemContributed.getM1033List()) {
            flagList.put(oasisItemContributedlist.getId(),oasisItemContributedlist.getFlag());
            discriptionList.put(oasisItemContributedlist.getId(),oasisItemContributedlist.getDiscription());
            if (oasisItemContributedlist.getId() > 0 && oasisItemContributedlist.getId() <= 7) {
                if (oasisItemContributedlist.getFlag()) {
                    {
                        count = count + 1;
                    }
                }
            }
        }
        m1033Repository.deletedM1033ByMrn(oasisItemContributed.getMrnNumber());
        m1800Repository.deletedM1800ByMrn(oasisItemContributed.getMrnNumber());
        m1810Repository.deletedM1810ByMrn(oasisItemContributed.getMrnNumber());
        m1820Repository.deletedM1820ByMrn(oasisItemContributed.getMrnNumber());
        m1830Repository.deletedM1830ByMrn(oasisItemContributed.getMrnNumber());
        m1840Repository.deletedM1840ByMrn(oasisItemContributed.getMrnNumber());
        m1850Repository.deletedM1850ByMrn(oasisItemContributed.getMrnNumber());
        m1860Repository.deletedM1860ByMrn(oasisItemContributed.getMrnNumber());
             m1033=new M1033();
             m1033.setId(1);
             m1033.setFlag(flagList.get(1));
            if(flagList.get(1))
            {
              m1033.setFunctionalPoint(0);
            }
             m1033.setDiscription(discriptionList.get(1));
             m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
             m1033Service.save(m1033);

             m1033=new M1033();
             m1033.setId(2);
             m1033.setFlag(flagList.get(2));
             if(flagList.get(2))
            {
              m1033.setFunctionalPoint(0);
            }
            m1033.setDiscription(discriptionList.get(2));
            m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
            m1033Service.save(m1033);

             m1033=new M1033();
             m1033.setId(3);
             m1033.setFlag(flagList.get(3));
            if(flagList.get(3))
            {
              m1033.setFunctionalPoint(0);
            }
             m1033.setDiscription(discriptionList.get(3));
             m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
             m1033Service.save(m1033);

        if(!(flagList.get(4))) {
            m1033 = new M1033();
            m1033.setId(4);
            m1033.setFlag(flagList.get(4));
            m1033.setDiscription(discriptionList.get(4));
            m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
            m1033Service.save(m1033);
        }
        if(!(flagList.get(5))) {
            m1033 = new M1033();
            m1033.setId(5);
            m1033.setFlag(flagList.get(5));
            m1033.setDiscription(discriptionList.get(5));
            m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
            m1033Service.save(m1033);

        }
        if(!(flagList.get(6))) {
            m1033 = new M1033();
            m1033.setId(6);
            m1033.setFlag(flagList.get(6));
            m1033.setDiscription(discriptionList.get(6));
            m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
            m1033Service.save(m1033);
        }
        if(!(flagList.get(7))) {
            m1033 = new M1033();
            m1033.setId(7);
            m1033.setFlag(flagList.get(7));
            m1033.setDiscription(discriptionList.get(7));
            m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
            m1033Service.save(m1033);
        }
        if(!(flagList.get(8))) {
            m1033 = new M1033();
            m1033.setId(8);
            m1033.setFlag(flagList.get(8));
            m1033.setDiscription(discriptionList.get(8));
            m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
            m1033Service.save(m1033);
        }

        if(!(flagList.get(9))) {
            m1033 = new M1033();
            m1033.setId(9);
            m1033.setFlag(flagList.get(9));
            m1033.setDiscription(discriptionList.get(9));
            m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
            m1033Service.save(m1033);
        }

        if(!(flagList.get(10))) {
            m1033 = new M1033();
            m1033.setId(10);
            m1033.setFlag(flagList.get(10));
            m1033.setDiscription(discriptionList.get(10));
            m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
            m1033Service.save(m1033);
        }

        if(count<4 && flagList.get(10))
        {
            m1033=new M1033();
            m1033.setId(10);
            m1033.setFlag(flagList.get(10));
            m1033.setDiscription(discriptionList.get(10));
            m1033.setFunctionalPoint(0);
            m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
            m1033Service.save(m1033);
            if(flagList.get(4))
            {
                m1033=new M1033();
                m1033.setId(4);
                m1033.setFlag(flagList.get(4));
                m1033.setDiscription(discriptionList.get(4));
                m1033.setFunctionalPoint(0);
                m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1033Service.save(m1033);
            }

            if(flagList.get(5)) {
                m1033 = new M1033();
                m1033.setId(5);
                m1033.setFlag(flagList.get(5));
                m1033.setDiscription(discriptionList.get(5));
                m1033.setFunctionalPoint(0);
                m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1033Service.save(m1033);

            }
            if(flagList.get(6)) {
                m1033 = new M1033();
                m1033.setId(6);
                m1033.setFlag(flagList.get(6));
                m1033.setDiscription(discriptionList.get(6));
                m1033.setFunctionalPoint(0);
                m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1033Service.save(m1033);

            }
            if(flagList.get(7)) {
                m1033 = new M1033();
                m1033.setId(7);
                m1033.setFlag(flagList.get(7));
                m1033.setDiscription(discriptionList.get(7));
                m1033.setFunctionalPoint(0);
                m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1033Service.save(m1033);

            }
            if(flagList.get(8)) {
                m1033 = new M1033();
                m1033.setId(7);
                m1033.setFlag(flagList.get(8));
                m1033.setDiscription(discriptionList.get(8));
                m1033.setFunctionalPoint(0);
                m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1033Service.save(m1033);

            }
            if(flagList.get(9)) {
                m1033 = new M1033();
                m1033.setId(9);
                m1033.setFlag(flagList.get(9));
                m1033.setDiscription(discriptionList.get(9));
                m1033.setFunctionalPoint(0);
                m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1033Service.save(m1033);

            }
        }



             if(count>=4 && flagList.get(10))
            {
                m1033=new M1033();
                m1033.setId(10);
                m1033.setFlag(flagList.get(10));
                m1033.setDiscription(discriptionList.get(10));
                m1033.setFunctionalPoint(0);
                m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1033Service.save(m1033);
                if(flagList.get(4))
                {
                    m1033=new M1033();
                    m1033.setId(4);
                    m1033.setFlag(flagList.get(4));
                    m1033.setDiscription(discriptionList.get(4));
                    m1033.setFunctionalPoint(0);
                    m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                    m1033Service.save(m1033);
                }

                if(flagList.get(5)) {
                    m1033 = new M1033();
                    m1033.setId(5);
                    m1033.setFlag(flagList.get(5));
                    m1033.setDiscription(discriptionList.get(5));
                    m1033.setFunctionalPoint(0);
                    m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                    m1033Service.save(m1033);

                }
                if(flagList.get(6)) {
                    m1033 = new M1033();
                    m1033.setId(6);
                    m1033.setFlag(flagList.get(6));
                    m1033.setDiscription(discriptionList.get(6));
                    m1033.setFunctionalPoint(0);
                    m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                    m1033Service.save(m1033);

                }
                if(flagList.get(7)) {
                    m1033 = new M1033();
                    m1033.setId(7);
                    m1033.setFlag(flagList.get(7));
                    m1033.setDiscription(discriptionList.get(7));
                    m1033.setFunctionalPoint(0);
                    m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                    m1033Service.save(m1033);

                }
                if(flagList.get(8)) {
                    m1033 = new M1033();
                    m1033.setId(8);
                    m1033.setFlag(flagList.get(8));
                    m1033.setDiscription(discriptionList.get(8));
                    m1033.setFunctionalPoint(0);
                    m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                    m1033Service.save(m1033);

                }
                if(flagList.get(9)) {
                    m1033 = new M1033();
                    m1033.setId(9);
                    m1033.setFlag(flagList.get(9));
                    m1033.setDiscription(discriptionList.get(9));
                    m1033.setFunctionalPoint(0);
                    m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                    m1033Service.save(m1033);

                }
            }
        if(count<4 && !(flagList.get(10)))
        {
            if(flagList.get(4))
            {
                m1033=new M1033();
                m1033.setId(4);
                m1033.setFlag(flagList.get(4));
                m1033.setDiscription(discriptionList.get(4));
                m1033.setFunctionalPoint(0);
                m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1033Service.save(m1033);
            }

            if(flagList.get(5)) {
                m1033 = new M1033();
                m1033.setId(5);
                m1033.setFlag(flagList.get(5));
                m1033.setDiscription(discriptionList.get(5));
                m1033.setFunctionalPoint(0);
                m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1033Service.save(m1033);

            }
            if(flagList.get(6)) {
                m1033 = new M1033();
                m1033.setId(6);
                m1033.setFlag(flagList.get(6));
                m1033.setDiscription(discriptionList.get(6));
                m1033.setFunctionalPoint(0);
                m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1033Service.save(m1033);

            }
            if(flagList.get(7)) {
                m1033 = new M1033();
                m1033.setId(7);
                m1033.setFlag(flagList.get(7));
                m1033.setDiscription(discriptionList.get(7));
                m1033.setFunctionalPoint(0);
                m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1033Service.save(m1033);

            }
        }
        if(count<4 && !(flagList.get(10))&&(flagList.get(8)||flagList.get(9)))
        {
            if(flagList.get(8))
            {
                m1033 = new M1033();
                m1033.setId(8);
                m1033.setFlag(flagList.get(8));
                m1033.setDiscription(discriptionList.get(8));
                m1033.setFunctionalPoint(0);
                m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1033Service.save(m1033);
            }
            if(flagList.get(9))
            {
                m1033 = new M1033();
                m1033.setId(9);
                m1033.setFlag(flagList.get(9));
                m1033.setDiscription(discriptionList.get(9));
                m1033.setFunctionalPoint(0);
                m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1033Service.save(m1033);
            }
        }

        if(count>=4 && !(flagList.get(10)))
        {

           if(flagList.get(4)) {
               m1033 = new M1033();
               m1033.setId(4);
               m1033.setFlag(flagList.get(4));
               m1033.setDiscription(discriptionList.get(4));
               if(functionFlag) {
                   m1033.setFunctionalPoint(11);
               }
               else
               {
                   m1033.setFunctionalPoint(0);
               }
               m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
               m1033Service.save(m1033);
               functionFlag=false;
           }
            if(flagList.get(5)) {
                m1033 = new M1033();
                m1033.setId(5);
                m1033.setFlag(flagList.get(5));
                m1033.setDiscription(discriptionList.get(5));
                if(functionFlag) {
                    m1033.setFunctionalPoint(11);
                }
                else
                {
                    m1033.setFunctionalPoint(0);
                }
                m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1033Service.save(m1033);
                functionFlag=false;
            }
            if(flagList.get(6)) {
                m1033 = new M1033();
                m1033.setId(6);
                m1033.setFlag(flagList.get(6));
                m1033.setDiscription(discriptionList.get(6));
                if(functionFlag) {
                    m1033.setFunctionalPoint(11);
                }
                else
                {
                    m1033.setFunctionalPoint(0);
                }
                m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1033Service.save(m1033);
                functionFlag=false;
            }
            if(flagList.get(7)) {
                m1033 = new M1033();
                m1033.setId(7);
                m1033.setFlag(flagList.get(7));
                m1033.setDiscription(discriptionList.get(7));
                if(functionFlag) {
                    m1033.setFunctionalPoint(11);
                }
                else
                {
                    m1033.setFunctionalPoint(0);
                }
                m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1033Service.save(m1033);
                functionFlag=false;
            }
            if(flagList.get(8)) {
                m1033 = new M1033();
                m1033.setId(8);
                m1033.setFlag(flagList.get(8));
                m1033.setDiscription(discriptionList.get(8));
                if(functionFlag) {
                    m1033.setFunctionalPoint(11);
                }
                else
                {
                    m1033.setFunctionalPoint(0);
                }
                m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1033Service.save(m1033);
                functionFlag=false;
            }

            if(flagList.get(9)) {
                m1033 = new M1033();
                m1033.setId(9);
                m1033.setFlag(flagList.get(9));
                m1033.setDiscription(discriptionList.get(9));
                if(functionFlag) {
                    m1033.setFunctionalPoint(11);
                }
                else
                {
                    m1033.setFunctionalPoint(0);
                }
                m1033.setMrnNumber(oasisItemContributed.getMrnNumber());
                m1033Service.save(m1033);
                functionFlag=false;
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
        String ackn="Success";
        if(ackn.equals("Success")) {
            return generateSuccessObject("Success",
                    " ");
        }
        else
        {
            return generateSuccessObject("Error",
                    "Sent failed ");
        }


    }


    @PostMapping("/pdgmToolPosition3Oasis")
    public List<Object> pdgmToolPosition3Oasis(@RequestBody  PDGMRapListing pdgmRapList ) throws Throwable
    {
        List<Object> list=new ArrayList<>();
        list= this.position3Operation(pdgmRapList);
        return list;
    }
    public List<Object> position3Operation(PDGMRapListing pdgmRapList)
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
    @PostMapping("/pdgmToolDivision6")
    public ResponseEntity<?> pdgmToolDivision6(@RequestBody DiagnosisCode diagnosisCode ) throws Throwable {
        boolean diagnosiscodeflag = false;
        boolean diagnosisSubChapterflag = false;
        boolean primaryLowFlag=false;
        boolean interactionLowFlag=false;
        List<String> comorbiditylevel = new ArrayList<>();
        boolean primaryFlag = false;
        boolean secondFlag = false;
        boolean interactionFlag = false;
        List<String> Lowcomorbiditylevel=new ArrayList<>();
        String comorbitiyCondition="";
        String hippsCode="";
        int highCount=0;
        List<ClinicalGroupingPrimaryDiagnosis> clinicalGroupingPrimaryDiagnoses = pdgmRapListRepository.findClinicalGroupingPrimaryDiagnosis(diagnosisCode.getPrimaryDiagnosisCode());
        List<String> seconddiagoniscode = diagnosisCode.getSecondaryDiagnosisCode();
        int secondDaignosisCount=0;
        for(String s:seconddiagoniscode)
        {
            secondDaignosisCount=secondDaignosisCount+1;
        }
        List<ClinicalGroupingPrimaryDiagnosis> clinicalGroupingSecondaryDiagnoses = new ArrayList<>();
        for (String daignosiscode2 : seconddiagoniscode) {
            clinicalGroupingSecondaryDiagnoses.addAll(pdgmRapListRepository.findClinicalGroupingPrimaryDiagnosis(daignosiscode2));
        }
          int CodeCount=0;

          List<String> considercomorbidity=new ArrayList<>();
        for (ClinicalGroupingPrimaryDiagnosis clinicalGroupingPrimary : clinicalGroupingPrimaryDiagnoses) {
            for (ClinicalGroupingPrimaryDiagnosis clinicalGroupingSecond : clinicalGroupingSecondaryDiagnoses) {

                if (!(clinicalGroupingPrimary.getPrimaryDiagnosisCode().equals(clinicalGroupingSecond.getPrimaryDiagnosisCode()))) {
                    diagnosiscodeflag = true;
                   // primaryCodeCount=primaryCodeCount+1;
                    if (!(clinicalGroupingPrimary.getSubChapterDescription().equals(clinicalGroupingSecond.getSubChapterDescription()))) {
                        diagnosisSubChapterflag = true;
                       // secondaryCodeCount=secondaryCodeCount+1;
                    }
                }

                if(diagnosiscodeflag&&diagnosisSubChapterflag)
                {
                    considercomorbidity.add("Yes");
                }
                else
                {
                    considercomorbidity.add("No");
                }
            }
        }
        for(String considercomorbiditycon:considercomorbidity)
        {
            if("Yes".equals(considercomorbiditycon)) {
                CodeCount = CodeCount + 1;
            }
        }

        if (CodeCount<1)
        {
            comorbitiyCondition="No-Comorbidity";
            hippsCode="1";
        }
        else if(CodeCount>=1 && secondDaignosisCount>1) {
            List<HighComorbidityCondition> highComorbidityConditionList = highComorbidityConditionService.listAll();
        List<String> compareList=new ArrayList<>();
            for (ClinicalGroupingPrimaryDiagnosis secondaryComorbiditySubGroup : clinicalGroupingSecondaryDiagnoses) {

                for (HighComorbidityCondition highComorbidityubgroup : highComorbidityConditionList) {
                    HighComorbidityCondition highComorbidityCondition = new HighComorbidityCondition();

                    if (secondaryComorbiditySubGroup.getComorbiditySubGroup().equals(highComorbidityubgroup.getPrimaryComorbiditySubgroup())) {
                        primaryFlag = true;
                        compareList.add(secondaryComorbiditySubGroup.getComorbiditySubGroup());
                        highComorbidityCondition.setId(highComorbidityubgroup.getId());
                        highComorbidityCondition.setPrimaryComorbiditySubgroup(highComorbidityubgroup.getPrimaryComorbiditySubgroup());
                        highComorbidityCondition.setValidPrimaryComorbidity("Yes");
                        highComorbidityConditionService.save(highComorbidityCondition);
                    }
                    else {
                        highComorbidityCondition.setId(highComorbidityubgroup.getId());
                        highComorbidityCondition.setPrimaryComorbiditySubgroup(highComorbidityubgroup.getPrimaryComorbiditySubgroup());
                        for(String subg:compareList) {
                            if (highComorbidityubgroup.getPrimaryComorbiditySubgroup().equals(subg)) {
                                highComorbidityCondition.setValidPrimaryComorbidity("Yes");
                            }
                            else
                            {
                                highComorbidityCondition.setValidPrimaryComorbidity("No");
                            }
                        }
                        highComorbidityConditionService.save(highComorbidityCondition);
                }
                    if (secondaryComorbiditySubGroup.getComorbiditySubGroup().equals(highComorbidityubgroup.getSecondaryComorbiditySubgroup())) {
                        secondFlag = true;
                        highComorbidityCondition.setId(highComorbidityubgroup.getId());
                        highComorbidityCondition.setSecondaryComorbiditySubgroup(highComorbidityubgroup.getSecondaryComorbiditySubgroup());
                        highComorbidityCondition.setValidSecondaryComorbidity("Yes");
                        highComorbidityConditionService.save(highComorbidityCondition);
                    }
                    else {
                        highComorbidityCondition.setId(highComorbidityubgroup.getId());
                        highComorbidityCondition.setSecondaryComorbiditySubgroup(highComorbidityubgroup.getSecondaryComorbiditySubgroup());
                        for(String subg:compareList) {
                            if (highComorbidityubgroup.getSecondaryComorbiditySubgroup().equals(subg)) {
                                highComorbidityCondition.setValidSecondaryComorbidity("Yes");
                            }
                            else
                            {
                                highComorbidityCondition.setValidSecondaryComorbidity("No");
                            }
                        }

                        highComorbidityConditionService.save(highComorbidityCondition);
                  }


                }
            }
            List<HighComorbidityCondition> highComorbidityConditionList1 = highComorbidityConditionService.listAll();

            for(HighComorbidityCondition high:highComorbidityConditionList1)
            {
                HighComorbidityCondition highComorbidityCondition = new HighComorbidityCondition();
                if("Yes".equals(high.getValidPrimaryComorbidity())&& "Yes".equals(high.getValidSecondaryComorbidity()))
                {
                    highCount=highCount+1;
                    highComorbidityCondition.setId(high.getId());
                    highComorbidityCondition.setPrimaryComorbiditySubgroup(high.getPrimaryComorbiditySubgroup());
                    highComorbidityCondition.setValidPrimaryComorbidity(high.getValidPrimaryComorbidity());
                    highComorbidityCondition.setSecondaryComorbiditySubgroup(high.getSecondaryComorbiditySubgroup());
                    highComorbidityCondition.setValidSecondaryComorbidity(high.getValidSecondaryComorbidity());
                    highComorbidityCondition.setInteraction("True");
                    highComorbidityCondition.setComorbidityAdjustmentLevel("High");
                    highComorbidityConditionService.save(highComorbidityCondition);

                }
                else
                {
                    highComorbidityCondition.setId(high.getId());
                    highComorbidityCondition.setPrimaryComorbiditySubgroup(high.getPrimaryComorbiditySubgroup());
                    highComorbidityCondition.setValidPrimaryComorbidity(high.getValidPrimaryComorbidity());
                    highComorbidityCondition.setSecondaryComorbiditySubgroup(high.getSecondaryComorbiditySubgroup());
                    highComorbidityCondition.setValidSecondaryComorbidity(high.getValidSecondaryComorbidity());
                    highComorbidityCondition.setInteraction("False");
                    highComorbidityCondition.setComorbidityAdjustmentLevel("Non-High");
                    highComorbidityConditionService.save(highComorbidityCondition);
                }
            }
        }

            if (highCount >= 1) {
                hippsCode = "3";
                comorbitiyCondition = "High-Comorbidity";
            }

            else {
                List<String> compareList=new ArrayList<>();
                List<LowComorbidityCondition> lowComorbidityConditionList=lowComorbidityConditionService.listAll();
                LowComorbidityCondition lowComorbidityConditionObj = new LowComorbidityCondition();
                for(ClinicalGroupingPrimaryDiagnosis secondaryComorbiditySubGroup:clinicalGroupingSecondaryDiagnoses) {
                    for (LowComorbidityCondition lowComorbidityCondition : lowComorbidityConditionList) {
                        if (secondaryComorbiditySubGroup.getComorbiditySubGroup().equals(lowComorbidityCondition.getPrimaryComorbiditySubgroup())) {
                           //primaryLowFlag = true;
                            compareList.add(secondaryComorbiditySubGroup.getComorbiditySubGroup());
                            lowComorbidityConditionObj.setId(lowComorbidityCondition.getId());
                            lowComorbidityConditionObj.setPrimaryComorbiditySubgroup(lowComorbidityCondition.getPrimaryComorbiditySubgroup());
                            lowComorbidityConditionObj.setValidPrimaryComorbidity("Yes");
                            lowComorbidityConditionObj.setInteraction("True");
                            lowComorbidityConditionObj.setComorbidityAdjustmentLevel("Low");
                            Lowcomorbiditylevel.add("Low");
                            lowComorbidityConditionService.save(lowComorbidityConditionObj);
                        } else {

                            for(String subg:compareList) {
                                if (lowComorbidityCondition.getPrimaryComorbiditySubgroup().equals(subg)) {
                                    lowComorbidityConditionObj.setId(lowComorbidityCondition.getId());
                                    lowComorbidityConditionObj.setPrimaryComorbiditySubgroup(lowComorbidityCondition.getPrimaryComorbiditySubgroup());
                                    lowComorbidityConditionObj.setValidPrimaryComorbidity("Yes");
                                    lowComorbidityConditionObj.setInteraction("True");
                                    lowComorbidityConditionObj.setComorbidityAdjustmentLevel("Low");
                                    Lowcomorbiditylevel.add("Low");
                                    lowComorbidityConditionService.save(lowComorbidityConditionObj);
                                }
                                else
                                {
                                    lowComorbidityConditionObj.setId(lowComorbidityCondition.getId());
                                    lowComorbidityConditionObj.setPrimaryComorbiditySubgroup(lowComorbidityCondition.getPrimaryComorbiditySubgroup());
                                    lowComorbidityConditionObj.setValidPrimaryComorbidity("No");
                                    lowComorbidityConditionObj.setInteraction("False");
                                    lowComorbidityConditionObj.setComorbidityAdjustmentLevel("Non-Low");
                                    Lowcomorbiditylevel.add("Non-Low");
                                    lowComorbidityConditionService.save(lowComorbidityConditionObj);
                                }
                            }


                            //primaryLowFlag=false;
                        }

                    }
                }
                int count1 = 0;
                for (String lowcomor : Lowcomorbiditylevel) {
                    if ("Low".equals(lowcomor)) {
                        count1 = count1 + 1;
                    }
                }
                if (count1 >= 1) {
                    hippsCode = "2";
                    comorbitiyCondition = "Low-Comorbidity";
                }
                else
                {
                    hippsCode = "1";
                    comorbitiyCondition = "No-Comorbidity";
                }


        }

          secondDaignosisCodeRepository.deletedSecondDiagnosisCodeByMrn(diagnosisCode.getMrnNumber());
        for (ClinicalGroupingPrimaryDiagnosis clinicalGroupingSecond : clinicalGroupingSecondaryDiagnoses) {
            SecondDiagnosisCode secondDiagnosisCode = new SecondDiagnosisCode();
            secondDiagnosisCode.setSecondDiagnosisCode(clinicalGroupingSecond.getPrimaryDiagnosisCode());
            secondDiagnosisCode.setDiscription(clinicalGroupingSecond.getDiscription());
            secondDiagnosisCode.setClinicalGroup(clinicalGroupingSecond.getClinicalGroup());
            secondDiagnosisCode.setComorbiditySubGroup(clinicalGroupingSecond.getComorbiditySubGroup());
            secondDiagnosisCode.setMrnNumber(diagnosisCode.getMrnNumber());
            secondDiagnosisCode.setiCDQualifier("ICD-10");
            secondDiagnosisCodeService.save(secondDiagnosisCode);
        }

        ComorbidityTypeAndHippsCode comorbidityTypeAndHippsCode=new ComorbidityTypeAndHippsCode();
        comorbidityTypeAndHippsCode.setComorbidityType(comorbitiyCondition);
        comorbidityTypeAndHippsCode.setHippsCode(hippsCode);
        comorbidityTypeAndHippsCode.setMrnNumber(diagnosisCode.getMrnNumber());
        comorbidityTypeAndHippsCodeService.save(comorbidityTypeAndHippsCode);

        String ackn="Success";
        if(ackn.equals("Success")) {
            return generateSuccessObject("Success",
                    " ");
        }
        else
        {
            return generateSuccessObject("Error",
                    "Sent failed ");
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
