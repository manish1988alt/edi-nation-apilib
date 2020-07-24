package com.edination.api.rap.rest;

import com.edination.api.Dao.*;
import com.edination.api.PDGM.dao.PDGMRapListRepository;
import com.edination.api.PDGM.dao.PDGMRapListService;
import com.edination.api.PDGM.dao.SecondDaignosisCodeRepository;
import com.edination.api.PDGM.model.ClinicalGroupingPrimaryDiagnosis;
import com.edination.api.PDGM.model.PDGMRapListing;
import com.edination.api.PDGM.model.SecondDiagnosisCode;
import com.edination.api.eligibility.EDIFile.Context;
import com.edination.api.eligibility.EDIFile.SFTPFILE;
import com.edination.api.eligibility.EDIFile.Segment;
import com.edination.api.eligibility.EDIFile.X12Simple;
import com.edination.api.eligibility.model.PrimaryInsuranceDetail;
import com.edination.api.eligibility.model.SecondaryInsuranceDetail;
import com.edination.api.eligibility.model.TertiaryInsuranceDetail;
import com.edination.api.preAuthorisation.MasterCode.IndividualRelationshipCodeMaster;
import com.edination.api.preAuthorisation.MasterCode.ProviderCodeMaster;
import com.edination.api.preAuthorisation.model.Episode;
import com.edination.api.preAuthorisation.model.PreAuthDetail;
import com.edination.api.rap.Dao.*;
import com.edination.api.rap.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

@RestController
@RequestMapping("rap")
public class RapRestApp implements Serializable {

    @Autowired
    RapRequestFormRepository rapRequestFormRepository;
    @Autowired
    SecondDaignosisCodeRepository secondDaignosisCodeRepository;
    @Autowired
    RapRequestFormService rapRequestFormService;
    @Autowired
    PDGMRapListService pdgmRapListService;
    @Autowired
    PDGMRapListRepository pdgmRapListRepository;
    @Autowired
    PrimaryDiagnosisCodeService primaryDiagnosisCodeService;
    @Autowired
    BillingDetailsService billingDetailsService;
    @Autowired
    ConditionCodeDetailService conditionCodeDetailService;
    @Autowired
    ConditionCodeDetailRepository conditionCodeDetailRepository;
    @Autowired
    OccuranceAndDateService occuranceAndDateService;
    @Autowired
    OccuranceAndDateRepository occuranceAndDateRepository;
    @Autowired
    ValueCodeDetailService valueCodeDetailService;
    @Autowired
    ValueCodeDetailRepository valueCodeDetailRepository;
    @Autowired
    InsuredDetailsService insuredDetailsService;
    @Autowired
    PayerDetailsService payerDetailsService;
    @Autowired
    OtherProviderDetailService otherProviderDetailService;
    @Autowired
    OtherProviderDetailRepository otherProviderDetailRepository;
    @Autowired
    RapRequestEnquiryDetailsService rapRequestEnquiryDetailsService;
    @Autowired
    TreatmentAuthorizationDetailsService treatmentAuthorizationDetailsService;
    @Autowired
    TreatmentAuthorizationDetailsRepository treatmentAuthorizationDetailsRepository;
    @Autowired
    BillingDetailsRepository billingDetailsRepository;
    @Autowired
    PayerDetailsRepository payerDetailsRepository;
    @Autowired
    InsuredDetailsRepository insuredDetailsRepository;
    @Autowired
    RapRequestEnquiryDetailsRepository rapRequestEnquiryDetailsRepository;
    @Autowired
    CountOfAddedValueInRapService countOfAddedValueInRapService;
    @Autowired
    CountOfAddedValueInRapRepository countOfAddedValueInRapRepository;
    @Autowired
    PreAuthRepository  preAuthRepository;
    @Autowired
    PreAuthorizationResponseRepository preAuthorizationResponseRepository;


    @Autowired
    ServicingProviderRepository servicingProviderRepository;
    @Autowired
    PrimaryInsuranceDetailRepository primaryInsuranceDetailRepository;
    @Autowired
    SecondaryInsuranceDetailRepository secondaryInsuranceDetailRepository;
    @Autowired
    TertiaryInsuranceDetailRepository tertiaryInsuranceDetailRepository;

    @PostMapping("/serviceProviderTypeList")
    public List<Object> serviceProviderTypeList(@RequestBody RapRequestForm rapRequestForm) throws Throwable {
        List<Object> list = new ArrayList<>();
        if ("Person".equals(rapRequestForm.getServicingProviderType())) {
            List<ServicingProviderPerson> servicingProviderPersonList = rapRequestFormRepository.servicingProviderPersonList();
            list.addAll(servicingProviderPersonList);
        }
        if ("Facility".equals(rapRequestForm.getServicingProviderType())) {
            list.addAll(rapRequestFormRepository.servicingProviderFacilityList());
        }
        return list;
    }

    @PostMapping("/billingProviderTypeList")
    public List<Object> billingProviderTypeList(@RequestBody RapRequestForm rapRequestForm) throws Throwable {
        List<Object> list = new ArrayList<>();
        if ("Person".equals(rapRequestForm.getBillingProviderType())) {
            list.add(rapRequestFormRepository.billingProviderPersonList());
        } else if ("Facility".equals(rapRequestForm.getBillingProviderType())) {
            list.add(rapRequestFormRepository.billingProviderFacilityList());
        }
        return list;
    }
    @PostMapping("/otherProviderTypeList")
    public List<OtherProviderList> otherProviderTypeList(@RequestBody OtherProviderList otherProviderList) throws Throwable {

        return  rapRequestFormRepository.OtherProviderList(otherProviderList.getProviderType());

    }
    @GetMapping("/condtionCodeList")
    public List<ConditionCodes> condtionCodeList() throws Throwable {
        return rapRequestFormRepository.conditionCodesList();
    }
    @GetMapping("/valueCodeList")
    public List<ValueCode> valueCodeList() throws Throwable {
        return rapRequestFormRepository.valueCodesList();
    }
    @GetMapping("/occuranceCodeList")
    public List<OccuranceCode> occuranceCodeList() throws Throwable {
        return rapRequestFormRepository.occuranceCodesList();
    }

    @GetMapping("/dischargeStatusCodeList")
    public List<DischargeStatusCode> dischargeStatusCodeList() throws Throwable {
        return rapRequestFormRepository.dischargeStatusCodeList();
    }

    @GetMapping("/sourceOfReferralCodeList")
    public List<SourceOfReferral> sourceOfReferralCodeList() throws Throwable {
        return rapRequestFormRepository.sourceOfReferralList();
    }

    @GetMapping("/typeOfBillCodeList")
    public List<TypeOfBillCode> typeOfBillCodeList() throws Throwable {
        return rapRequestFormRepository.typeOfBillCodeList();
    }

    @GetMapping("/typeOfVisitCodeList")
    public List<TypeOfVisitCode> typeOfVisitCodeList() throws Throwable {
        return rapRequestFormRepository.typeOfVisitCodeList();
    }
    @GetMapping("/providerCodeList")
    public List<ProviderCodeMaster> providerCodeList() throws Throwable {
        return rapRequestFormRepository.otherProviderList();
    }
    @GetMapping("/attendingProviderList")
    public List<AttendingProviderDetail> attendingProviderList() throws Throwable {
        return rapRequestFormRepository.attendingProviderDetailList();
    }

    @GetMapping("/reletionshipList")
    public List<IndividualRelationshipCodeMaster> reletionshipList() throws Throwable {
        return preAuthorizationResponseRepository.findReletionshipList();
    }
    @PostMapping("/rapRequestView")
    public List<RapRequestFormDetail> rapRequestView(@RequestBody PDGMRapListing pdgmRapListing) throws Throwable
    {
        List<RapRequestFormDetail> list=new ArrayList<>();
        CountOfAddedValueInRap countOfAddedValueInRap=countOfAddedValueInRapService.get(pdgmRapListing.getMrnNumber());
        List<ConditionCodeDetail> conditionCodeDetailList=conditionCodeDetailRepository.findConditionCodeDetailByMrnNumber(pdgmRapListing.getMrnNumber(),countOfAddedValueInRap.getConditionCodeCount());
        List<OccuranceAndDate> occuranceAndDateList=occuranceAndDateRepository.findOccuranceAndDateByMrnNumber(pdgmRapListing.getMrnNumber(),countOfAddedValueInRap.getOccuranceCodeCount());
        List<ValueCodeDetail> valueCodeDetailList=valueCodeDetailRepository.findValueCodeDetailByMrnNumber(pdgmRapListing.getMrnNumber(),countOfAddedValueInRap.getValueCodeCount());
        RapRequestFormDetail rapRequestFormDetail=new RapRequestFormDetail();

        rapRequestFormDetail.setRapRequestForm(rapRequestFormRepository.rapRequestFormView(pdgmRapListing.getMrnNumber()));
        rapRequestFormDetail.setConditionCodeDetailList(conditionCodeDetailList);
        rapRequestFormDetail.setOccuranceAndDateList(occuranceAndDateList);
        rapRequestFormDetail.setValueCodeDetailList(valueCodeDetailList);
        rapRequestFormDetail.setPatientMrn(pdgmRapListing.getMrnNumber());
       List<BillingDetails>  billingDetailsList =billingDetailsRepository.findBillingDetailsByMrnNumber(pdgmRapListing.getMrnNumber());
       List<BillingDetails> billingDetailsListUpdate=new ArrayList<>();
        String currentDate = java.time.LocalDate.now().toString();
        LocalDate creationDate=LocalDate.parse(currentDate);
        for (BillingDetails bl:billingDetailsList)
        {
            BillingDetails billingDetails=new BillingDetails();
            billingDetails.setCount(bl.getCount());
            billingDetails.setCreationDate(creationDate);
            billingDetails.sethCPCS_Rate_HCPCS_Code(bl.gethCPCS_Rate_HCPCS_Code());
            billingDetails.setId(bl.getId());
            billingDetails.setMrnNumber(bl.getMrnNumber());
            billingDetails.setNonCoverageCharge(bl.getNonCoverageCharge());
            billingDetails.setRevenueCode(bl.getRevenueCode());
            billingDetails.setRevenueCodeDescription(bl.getRevenueCodeDescription());
            billingDetails.setServiceDate(bl.getServiceDate());
            billingDetails.setServiceUnit(bl.getServiceUnit());
            billingDetails.setTotalCharge(bl.getTotalCharge());
            billingDetails.setTotalCostForNonCoverageCharge(bl.getTotalCostForNonCoverageCharge());
            billingDetails.setTotalCostForTotalCharge(bl.getTotalCostForTotalCharge());
            billingDetailsListUpdate.add(billingDetails);


        }
        rapRequestFormDetail.setBillingDetailsList(billingDetailsListUpdate);
        List<Integer> count=new ArrayList<Integer>();
        count.add(1);
        count.add(2);
        count.add(3);

        List<PayerDetails> payerDetailsList=new ArrayList<>();
        List<InsuredDetails> insuredDetailsList=new ArrayList<>();
        for(int value:count)
        {
            payerDetailsList.add(payerDetailsRepository.findPayerDetailsByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn(),value));
            insuredDetailsList.add(insuredDetailsRepository.findInsuredDetailsByMrnNumber(pdgmRapListing.getMrnNumber(),value));
        }
        rapRequestFormDetail.setPayerDetails(payerDetailsList);
        rapRequestFormDetail.setInsuredDetails(insuredDetailsList);
        rapRequestFormDetail.setPrimaryDiagnosisCode(rapRequestFormRepository.findPrimaryDiagnosisCodeByMrnNumber(pdgmRapListing.getMrnNumber()));
        rapRequestFormDetail.setSecondDiagnosisCodeList(secondDaignosisCodeRepository.findSecondDiagnosisListCodeByMrn(pdgmRapListing.getMrnNumber()));
        rapRequestFormDetail.setOtherProviderDetails(otherProviderDetailRepository.findOtherProviderDetailByMrnNumber(pdgmRapListing.getMrnNumber(),countOfAddedValueInRap.getOtherProviderCount()));
        rapRequestFormDetail.setRapRequestEnquiryDetails(rapRequestEnquiryDetailsRepository.findRapRequestEnquiryDetailsByMrnNumber(pdgmRapListing.getMrnNumber()));
        rapRequestFormDetail.setTreatmentAuthorizationDetails(treatmentAuthorizationDetailsRepository.findTreatmentAuthorizationDetailsByMrnNumber(pdgmRapListing.getMrnNumber(),countOfAddedValueInRap.getTreatmentAuthorizationCount()));
        list.add(rapRequestFormDetail);
        return list;
    }
    @PostMapping("/rapRequestEdit")
    public List<RapRequestFormDetail>  rapRequestEdit(@RequestBody  RapRequestFormDetail rapRequestFormDetail)  throws Throwable
    {
        List<RapRequestFormDetail> list=new ArrayList<>();
        CountOfAddedValueInRap countOfAddedValueInRap=countOfAddedValueInRapService.get(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
        List<ConditionCodeDetail> conditionCodeDetailList=conditionCodeDetailRepository.findConditionCodeDetailByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn(),countOfAddedValueInRap.getConditionCodeCount());
        List<OccuranceAndDate> occuranceAndDateList=occuranceAndDateRepository.findOccuranceAndDateByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn(),countOfAddedValueInRap.getOccuranceCodeCount());
        List<ValueCodeDetail> valueCodeDetailList=valueCodeDetailRepository.findValueCodeDetailByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn(),countOfAddedValueInRap.getValueCodeCount());
        RapRequestFormDetail rapRequestFormDetail1=new RapRequestFormDetail();

        rapRequestFormDetail1.setRapRequestForm(rapRequestFormRepository.rapRequestFormView(rapRequestFormDetail.getRapRequestForm().getPatientMrn()));
        rapRequestFormDetail1.setConditionCodeDetailList(conditionCodeDetailList);
        rapRequestFormDetail1.setOccuranceAndDateList(occuranceAndDateList);
        rapRequestFormDetail1.setValueCodeDetailList(valueCodeDetailList);
        rapRequestFormDetail1.setPatientMrn(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
        List<BillingDetails>  billingDetailsList =billingDetailsRepository.findBillingDetailsByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
        List<BillingDetails> billingDetailsListUpdate=new ArrayList<>();
        String currentDate = java.time.LocalDate.now().toString();
        LocalDate creationDate=LocalDate.parse(currentDate);
        for (BillingDetails bl:billingDetailsList)
        {
            BillingDetails billingDetails=new BillingDetails();
            billingDetails.setCount(bl.getCount());
            billingDetails.setCreationDate(creationDate);
            billingDetails.sethCPCS_Rate_HCPCS_Code(bl.gethCPCS_Rate_HCPCS_Code());
            billingDetails.setId(bl.getId());
            billingDetails.setMrnNumber(bl.getMrnNumber());
            billingDetails.setNonCoverageCharge(bl.getNonCoverageCharge());
            billingDetails.setRevenueCode(bl.getRevenueCode());
            billingDetails.setRevenueCodeDescription(bl.getRevenueCodeDescription());
            billingDetails.setServiceDate(bl.getServiceDate());
            billingDetails.setServiceUnit(bl.getServiceUnit());
            billingDetails.setTotalCharge(bl.getTotalCharge());
            billingDetails.setTotalCostForNonCoverageCharge(bl.getTotalCostForNonCoverageCharge());
            billingDetails.setTotalCostForTotalCharge(bl.getTotalCostForTotalCharge());
            billingDetailsListUpdate.add(billingDetails);

        }
        rapRequestFormDetail1.setBillingDetailsList(billingDetailsListUpdate);
        List<Integer> count=new ArrayList<Integer>();
        count.add(1);
        count.add(2);
        count.add(3);

         List<PayerDetails> payerDetailsList=new ArrayList<>();
        List<InsuredDetails> insuredDetailsList=new ArrayList<>();
        for(int value:count)
        {
            payerDetailsList.add(payerDetailsRepository.findPayerDetailsByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn(),value));
            insuredDetailsList.add(insuredDetailsRepository.findInsuredDetailsByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn(),value));
        }
        rapRequestFormDetail1.setPayerDetails(payerDetailsList);
        rapRequestFormDetail1.setInsuredDetails(insuredDetailsList);
        rapRequestFormDetail1.setTreatmentAuthorizationDetails(treatmentAuthorizationDetailsRepository.findTreatmentAuthorizationDetailsByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn(),countOfAddedValueInRap.getTreatmentAuthorizationCount()));
        rapRequestFormDetail1.setPrimaryDiagnosisCode(rapRequestFormRepository.findPrimaryDiagnosisCodeByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn()));
        rapRequestFormDetail1.setSecondDiagnosisCodeList(secondDaignosisCodeRepository.findSecondDiagnosisListCodeByMrn(rapRequestFormDetail.getRapRequestForm().getPatientMrn()));
        rapRequestFormDetail1.setOtherProviderDetails(otherProviderDetailRepository.findOtherProviderDetailByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn(),countOfAddedValueInRap.getOtherProviderCount()));
        RapRequestEnquiryDetails rapRequestEnquiryDetailsObj= rapRequestEnquiryDetailsRepository.findRapRequestEnquiryDetailsByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
       PDGMRapListing pdgmRapListing=pdgmRapListService.get(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
        if("Sent For Approval".equals(pdgmRapListing.getRapsFormStatus()))
        {
            RapRequestEnquiryDetails enquiryDetails=new RapRequestEnquiryDetails();
            enquiryDetails.setId(rapRequestEnquiryDetailsObj.getId());
            String currentEnqDate = java.time.LocalDate.now().toString();
            LocalDate currentEnqDateF=LocalDate.parse(currentEnqDate);
            Random rand = new Random();
            int rand_int1 = rand.nextInt(1000);
            enquiryDetails.setEnquiryId(rand_int1);
            enquiryDetails.setMrnNumber(rapRequestEnquiryDetailsObj.getMrnNumber());
            enquiryDetails.setPreauthReqSentDate(currentEnqDateF);
            rapRequestFormDetail1.setRapRequestEnquiryDetails(enquiryDetails);
        }
        else
        {
            rapRequestFormDetail1.setRapRequestEnquiryDetails(rapRequestEnquiryDetailsObj);

        }
        list.add(rapRequestFormDetail1);
        return list;
    }
   @PostMapping("/rapRequestSave")
    public ResponseEntity<?>  rapRequestSave(@RequestBody  RapRequestFormDetail rapRequestFormDetail)  throws Throwable
    {
        String ackn="";

        ackn= this.saveOperation(rapRequestFormDetail,"Save As Draft");


        if(ackn.equals("true")) {
            return generateSuccessObject("Success",
                    " ");
        }
        else
        {
            return generateSuccessObject("Error",
                    "Sent failed ");
        }
    }

    @PostMapping("/rapRequestSent")
    public ResponseEntity<?>  rapRequestSent(@RequestBody  RapRequestFormDetail rapRequestFormDetail)  throws Throwable
    {

        String ackn="";

        File file = new File("Hipaa-5010-837-GenericRequest.txt");
        ackn= this.saveOperation(rapRequestFormDetail,"Sent For Approval");
        if(ackn.equals("true")) {
            generateFile(rapRequestFormDetail, file);
            new SFTPFILE().fileUpload(file, rapRequestFormDetail.getRapRequestForm().getPatientMrn() + "_" + file.getName());
        }
        else
        {
            ackn="false";
        }


        if(ackn.equals("true")) {
            return generateSuccessObject("Success",
                    " ");
        }
        else
        {
            return generateSuccessObject("Error",
                    "Sent failed ");
        }
    }

    public String saveOperation(RapRequestFormDetail rapRequestFormDetail,String rapFormStatus)
    {
        String ackn="false";
        Episode episode=new Episode();
       List<PreAuthDetail> preAuthDetail= preAuthRepository.findByID(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
        for(PreAuthDetail preAuthDetail1:preAuthDetail)
        {
        episode= preAuthDetail1.getEpisode();
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String episodeStartDate = formatter.format(episode.getAdmissionDate());
        LocalDate addmission_date = LocalDate.parse(episodeStartDate);
       RapRequestForm rapRequestForm=new RapRequestForm();
        rapRequestForm.setPatientMrn(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
        rapRequestForm.setAccidentDate(rapRequestFormDetail.getRapRequestForm().getAccidentDate());
        rapRequestForm.setAccidentState(rapRequestFormDetail.getRapRequestForm().getAccidentState());
        rapRequestForm.setAdmissionDate(addmission_date);
        rapRequestForm.setAdmissionHour(rapRequestFormDetail.getRapRequestForm().getAdmissionHour());
        rapRequestForm.setAttendingProviderName(rapRequestFormDetail.getRapRequestForm().getAttendingProviderName());
        rapRequestForm.setBillingProviderName(rapRequestFormDetail.getRapRequestForm().getBillingProviderName());
        rapRequestForm.setBillingProviderType(rapRequestFormDetail.getRapRequestForm().getBillingProviderType());
        rapRequestForm.setDischargeDate(rapRequestFormDetail.getRapRequestForm().getDischargeDate());
        rapRequestForm.setDischargeHour(rapRequestFormDetail.getRapRequestForm().getDischargeHour());
        rapRequestForm.setPatientDischargeStatus(rapRequestFormDetail.getRapRequestForm().getPatientDischargeStatus());
        rapRequestForm.setServicingProviderName(rapRequestFormDetail.getRapRequestForm().getServicingProviderName());
        rapRequestForm.setServicingProviderType(rapRequestFormDetail.getRapRequestForm().getServicingProviderType());
        rapRequestForm.setSourceOfReferral(rapRequestFormDetail.getRapRequestForm().getSourceOfReferral());

        rapRequestForm.setStatementCoveredPeriodDateFrom(addmission_date);
        rapRequestForm.setStatementCoveredPeriodDateTo(rapRequestFormDetail.getRapRequestForm().getStatementCoveredPeriodDateTo());
        rapRequestForm.setTypeOfBill(rapRequestFormDetail.getRapRequestForm().getTypeOfBill());
        rapRequestForm.setTypeOfVisit(rapRequestFormDetail.getRapRequestForm().getTypeOfVisit());
        rapRequestForm.setRemarks(rapRequestFormDetail.getRapRequestForm().getRemarks());

        Patientdetail patientdetail=new Patientdetail();
        patientdetail.setName(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getName());
        patientdetail.setFirstName(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getFirstName());
        patientdetail.setLastName(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getLastName());
        patientdetail.setMiddleName(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getMiddleName());
        patientdetail.setPrefix(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getPrefix());
        patientdetail.setSuffix(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getSuffix());
        patientdetail.setGender(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getGender());
        patientdetail.setDob(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getDob());
        patientdetail.setPatientNameIdentifier(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getPatientNameIdentifier());
        patientdetail.setAddressLine(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getAddressLine());
        patientdetail.setCity(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getCity());
        patientdetail.setState(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getState());
        patientdetail.setZipCode(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getZipCode());
        rapRequestForm.setPatientDetail(patientdetail);
        rapRequestFormService.save(rapRequestForm);

        for(BillingDetails bl:rapRequestFormDetail.getBillingDetailsList())
        {
            BillingDetails billingDetails=new BillingDetails();
            billingDetails.setMrnNumber(bl.getMrnNumber());
            billingDetails.sethCPCS_Rate_HCPCS_Code(bl.gethCPCS_Rate_HCPCS_Code());
            billingDetails.setTotalCostForTotalCharge(bl.getTotalCostForTotalCharge());
            billingDetails.setTotalCostForNonCoverageCharge(bl.getTotalCostForNonCoverageCharge());
            billingDetails.setTotalCharge(bl.getTotalCharge());
            billingDetails.setServiceUnit(bl.getServiceUnit());
            billingDetails.setServiceDate(bl.getServiceDate());
            billingDetails.setRevenueCode("0023");
            billingDetails.setRevenueCodeDescription(bl.getRevenueCodeDescription());
            billingDetails.setNonCoverageCharge(bl.getNonCoverageCharge());
            billingDetails.setCreationDate(bl.getCreationDate());
            billingDetails.setCount(bl.getCount());
            billingDetailsService.save(billingDetails);
        }
        int conditionCodeCount=0;
        int occuranceCodeCount=0;
        int valueCodeCount=0;
        int otherProviderCount=0;
        int treatmentAuthorizationCount=0;
        CountOfAddedValueInRap countOfAddedValueInRap=new CountOfAddedValueInRap();
        countOfAddedValueInRap.setMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
        for(ConditionCodeDetail cnd:rapRequestFormDetail.getConditionCodeDetailList())
        {
            ConditionCodeDetail conditionCodeDetail=new ConditionCodeDetail();
            conditionCodeDetail.setMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
            conditionCodeDetail.setCode(cnd.getCode());
            conditionCodeDetailService.save(conditionCodeDetail);
            conditionCodeCount++;
        }
        countOfAddedValueInRap.setConditionCodeCount(conditionCodeCount);
        for(OccuranceAndDate occurance:rapRequestFormDetail.getOccuranceAndDateList())
        {
            OccuranceAndDate occuranceAndDate=new OccuranceAndDate();
            occuranceAndDate.setMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
            occuranceAndDate.setCode(occurance.getCode());
            occuranceAndDate.setDateFrom(occurance.getDateFrom());
            occuranceAndDate.setDateThrough(occurance.getDateThrough());
            occuranceAndDateService.save(occuranceAndDate);
            occuranceCodeCount++;
        }
        countOfAddedValueInRap.setOccuranceCodeCount(occuranceCodeCount);
        for(ValueCodeDetail valueCode:rapRequestFormDetail.getValueCodeDetailList())
        {
            ValueCodeDetail valueCodeDetail=new ValueCodeDetail();
            valueCodeDetail.setMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
            valueCodeDetail.setCode(valueCode.getCode());
            valueCodeDetail.setAmount(valueCode.getAmount());
            valueCodeDetailService.save(valueCodeDetail);
            valueCodeCount++;
        }
        countOfAddedValueInRap.setValueCodeCount(valueCodeCount);
        int i=1;
        for(InsuredDetails insuredDetails1:rapRequestFormDetail.getInsuredDetails())
        {

            InsuredDetails insuredDetails=new InsuredDetails();
            insuredDetails.setCount(i);
            insuredDetails.setInsuredGroupName(insuredDetails1.getInsuredGroupName());
            insuredDetails.setInsuredGroupNumber(insuredDetails1.getInsuredGroupNumber());
            insuredDetails.setInsuredName(insuredDetails1.getInsuredName());
            insuredDetails.setInsuredUniqueIdentifiers(insuredDetails1.getInsuredUniqueIdentifiers());
            insuredDetails.setMrnNumber(insuredDetails1.getMrnNumber());
            insuredDetails.setRelationshipToInsured(insuredDetails1.getRelationshipToInsured());
            insuredDetailsService.save(insuredDetails);
            i++;
        }
int j=1;
        for(PayerDetails payerDetails1: rapRequestFormDetail.getPayerDetails())
        {
            PayerDetails payerDetails=new PayerDetails();
            payerDetails.setAssignmentOfBenefit(payerDetails1.getAssignmentOfBenefit());
            payerDetails.setCount(j);
            payerDetails.setEstimateAmount(payerDetails1.getEstimateAmount());
            payerDetails.setHealthPlanID(payerDetails1.getHealthPlanID());
            payerDetails.setMrnNumber(payerDetails1.getMrnNumber());
            payerDetails.setPayerCarrierNumber(payerDetails1.getPayerCarrierNumber());
            payerDetails.setPayerName(payerDetails1.getPayerName());
            payerDetails.setPayerType(payerDetails1.getPayerType());
            payerDetails.setPriorPayment(payerDetails1.getPriorPayment());
            payerDetailsService.save(payerDetails);
            j++;
        }
        for(TreatmentAuthorizationDetails treatmentAuthorizationDetails1: rapRequestFormDetail.getTreatmentAuthorizationDetails())
        {
            TreatmentAuthorizationDetails treatmentAuthorizationDetails = new TreatmentAuthorizationDetails();
            treatmentAuthorizationDetails.setEmployeeName(treatmentAuthorizationDetails1.getEmployeeName());
            treatmentAuthorizationDetails.setTreatmentAuthorizationCode(treatmentAuthorizationDetails1.getTreatmentAuthorizationCode());
            treatmentAuthorizationDetails.setDocumentControlNumber(treatmentAuthorizationDetails1.getDocumentControlNumber());
            treatmentAuthorizationDetails.setMrnNumber(treatmentAuthorizationDetails1.getMrnNumber());
            treatmentAuthorizationDetailsService.save(treatmentAuthorizationDetails);
            treatmentAuthorizationCount++;
        }
        countOfAddedValueInRap.setTreatmentAuthorizationCount(treatmentAuthorizationCount);
        for(OtherProviderDetail otherProviderDetail1: rapRequestFormDetail.getOtherProviderDetails())
        {
            OtherProviderDetail otherProviderDetail=new OtherProviderDetail();
            otherProviderDetail.setFirstName(otherProviderDetail1.getFirstName());
            otherProviderDetail.setLastName(otherProviderDetail1.getLastName());
            otherProviderDetail.setMiddleName(otherProviderDetail1.getMiddleName());
            otherProviderDetail.setPrefix(otherProviderDetail1.getPrefix());
            otherProviderDetail.setSuffix(otherProviderDetail1.getSuffix());
            otherProviderDetail.setDob(otherProviderDetail1.getDob());
            otherProviderDetail.setGender(otherProviderDetail1.getGender());
            otherProviderDetail.setProviderName(otherProviderDetail1.getProviderName());
            otherProviderDetail.setProviderType(otherProviderDetail1.getProviderType());
            otherProviderDetail.setAddressLine(otherProviderDetail1.getAddressLine());
            otherProviderDetail.setCity(otherProviderDetail1.getCity());
            otherProviderDetail.setState(otherProviderDetail1.getState());
            otherProviderDetail.setZipCode(otherProviderDetail1.getZipCode());
            otherProviderDetail.setMrnNumber(otherProviderDetail1.getMrnNumber());
            otherProviderDetailService.save(otherProviderDetail);
            otherProviderCount++;

        }
        countOfAddedValueInRap.setOtherProviderCount(otherProviderCount);
        countOfAddedValueInRapService.save(countOfAddedValueInRap);
        RapRequestEnquiryDetails rapRequestEnquiryDetails=new RapRequestEnquiryDetails();
        rapRequestEnquiryDetails.setMrnNumber( rapRequestFormDetail.getRapRequestEnquiryDetails().getMrnNumber());
        rapRequestEnquiryDetails.setEnquiryId( rapRequestFormDetail.getRapRequestEnquiryDetails().getEnquiryId());
        rapRequestEnquiryDetails.setPreauthReqSentDate( rapRequestFormDetail.getRapRequestEnquiryDetails().getPreauthReqSentDate());
        rapRequestEnquiryDetailsService.save(rapRequestEnquiryDetails);

        PDGMRapListing pdgmRapListing= pdgmRapListService.get(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
        List<ClinicalGroupingPrimaryDiagnosis> clinicalGroupingPrimaryDiagnosis1= pdgmRapListRepository.findClinicalGroupingPrimaryDiagnosis(pdgmRapListing.getPrimaryDiagnosisCode());
        for(ClinicalGroupingPrimaryDiagnosis clinicalGroupingPrimaryDiagnosis:clinicalGroupingPrimaryDiagnosis1) {
            PrimaryDiagnosisCode primaryDiagnosisCode = new PrimaryDiagnosisCode();
            primaryDiagnosisCode.setMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
            primaryDiagnosisCode.setiCDQualifier("ICD-10");
            primaryDiagnosisCode.setPrimaryDiagnosisCode(clinicalGroupingPrimaryDiagnosis.getPrimaryDiagnosisCode());
            primaryDiagnosisCode.setDiscription(clinicalGroupingPrimaryDiagnosis.getDiscription());
            primaryDiagnosisCodeService.save(primaryDiagnosisCode);
        }
        ackn="true";
        if("true".equals(ackn)) {
            PDGMRapListing pdgmRapListing1 = new PDGMRapListing();
            pdgmRapListing1.setFirstName(pdgmRapListing.getFirstName());
            pdgmRapListing1.setLastName(pdgmRapListing.getLastName());
            pdgmRapListing1.setMiddleName(pdgmRapListing.getMiddleName());
            pdgmRapListing1.setSuffix(pdgmRapListing.getSuffix());
            pdgmRapListing1.setEpisodeStartDates(episode.getAdmissionDate());
            pdgmRapListing1.setEpisodeEndDates(pdgmRapListing.getEpisodeEndDates());
            pdgmRapListing1.setPrimaryDiagnosisCode(pdgmRapListing.getPrimaryDiagnosisCode());
            pdgmRapListing1.setEpisodeId(pdgmRapListing.getEpisodeId());
            pdgmRapListing1.setOasisType(pdgmRapListing.getOasisType());
            pdgmRapListing1.setOasisKey(pdgmRapListing.getOasisKey());
            pdgmRapListing1.setClaimType(pdgmRapListing.getClaimType());
            pdgmRapListing1.setBillableVisit(pdgmRapListing.getBillableVisit());
            pdgmRapListing1.setAging(pdgmRapListing.getAging());
            pdgmRapListing1.setHippsCode(pdgmRapListing.getHippsCode());
            pdgmRapListing1.setHippsCodeGeneratedDate(pdgmRapListing.getHippsCodeGeneratedDate());
            pdgmRapListing1.setMrnNumber(pdgmRapListing.getMrnNumber());
            pdgmRapListing1.setAction(pdgmRapListing.getAction());
            pdgmRapListing1.setRapsFormStatus(rapFormStatus);
            String currentDate = java.time.LocalDate.now().toString();
            pdgmRapListing1.setRapsSentDate(currentDate);
            if("Sent For Approval".equals(rapFormStatus)) {
                pdgmRapListing1.setRapsType("Initial RAP");
            }
            else{
                pdgmRapListing1.setRapsType(pdgmRapListing.getRapsType());
            }

            pdgmRapListService.save(pdgmRapListing1);
        }
        return ackn;
    }

    public void generateFile(RapRequestFormDetail rapRequestFormDetail,File file) throws Exception
    {
        String data=this.generateEDIFile(rapRequestFormDetail);
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
    public String generateEDIFile(RapRequestFormDetail rapRequestFormDetail) throws Exception
    {
        Map<String,String> relationMap= new HashMap<>();

        relationMap.put("Spouse","1");
        relationMap.put("Grandfather or Grandmother","4");
        relationMap.put("Grandson or Granddaughter","5");
        relationMap.put("Nephew or Niece","7");
        relationMap.put("Adopted Child","9");
        relationMap.put("Foster Child","10");
        relationMap.put("Ward","15");
        relationMap.put("Stepson or Stepdaughter","17");
        relationMap.put("Child","19");
        relationMap.put("Employee","20");
        relationMap.put("Unknown","21");
        relationMap.put("Handicapped Dependent","22");
        relationMap.put("Sponsored Dependent","23");
        relationMap.put("Dependent of a Minor Dependent","24");
        relationMap.put("Significant Other","29");
        relationMap.put("Mother","32");
        relationMap.put("Father","33");
        relationMap.put("Other Adult","34");
        relationMap.put("Emancipated Minor","36");
        relationMap.put("Organ Donor","39");
        relationMap.put("Cadaver Donor","40");
        relationMap.put("Injured Plaintiff","41");
        relationMap.put("Child Where Insured Has No Financial Responsibility","43");
        relationMap.put("Life Partner","53");
        relationMap.put("Other Relationship","G8");
        relationMap.put("Admission Review","AR");
        relationMap.put("Health Services Review","HS");
        relationMap.put("Specialty Care Review","SC");
        relationMap.put("Appeal - Immediate","1");
        relationMap.put("Appeal - Standard","2");
        relationMap.put("Cancel","3");
        relationMap.put("Extension","4");
        relationMap.put("Initial","I");
        relationMap.put("Renewal","R");
        relationMap.put("Revised","S");
        relationMap.put("Emergency","03");
        relationMap.put("Urgent","U");
        relationMap.put("Physician","1T");
        relationMap.put("Clinic","1T");
        relationMap.put("Group Practice","1T");
        relationMap.put("Facility","FA");
        relationMap.put("Service Provider","SJ");
        relationMap.put("Employer’s Identification Number","24");
        relationMap.put("Social Security Number","34");
        relationMap.put("Electronic Transmitter Identification Number (ETIN)","46");
        Context c = new Context('~', '*', ':');
        X12Simple x12 = new X12Simple(c);

        //add ISA segment
        Segment s = x12.addSegment();

        s.addElement("ISA");
        s.addElement("00");
        s.addElement(" ");
        s.addElement("00");
        s.addElement(" ");
        s.addElement("ZZ");
        s.addElement("146111111");
        s.addElement("ZZ");
        s.addElement("617591011LTCPP");
        s.addElement("170406");
        s.addElement("1130");
        s.addElement("|");
        // s.addElement("U");
        s.addElement("00501");
        s.addElement("100000001");
        s.addElement("0");
        s.addElement("P");
        s.addElement(":");

        s = x12.addSegment();
        s.addElement("GS");
        s.addElement("HC");
        s.addElement("146111111");
        s.addElement("617591011LTCPP");
        s.addElement("20170406");
        s.addElement("1130");
        s.addElement("10001");
        s.addElement("X");
        s.addElement("005010X217");

        s = x12.addSegment();
        s.addElement("ST");
        s.addElement("837");
        s.addElement("0032");
        s.addElement("005010X217");


        s = x12.addSegment();
        s.addElement("BHT");
        s.addElement("0019");
        s.addElement("00");
        s.addElement("0123");
        s.addElement("20100101");
        s.addElement("0923");
        s.addElement("CH");

        s = x12.addSegment();
        s.addElement("NM1");
        s.addElement("41");
        if("Person".equals(rapRequestFormDetail.getRapRequestForm().getServicingProviderType()))
        {
            s.addElement("1");
            ServicingProviderPerson servicingProviderPerson=servicingProviderRepository.findServicingProviderPerson(rapRequestFormDetail.getRapRequestForm().getServicingProviderName());
            s.addElement(servicingProviderPerson.getPersonLastName());
            s.addElement(servicingProviderPerson.getPersonFirstName());
            s.addElement(servicingProviderPerson.getPersonMiddleName());
            s.addElement(servicingProviderPerson.getPersonPrefix());
            s.addElement(servicingProviderPerson.getPersonSuffix());
            s.addElement("46");
            s.addElement(servicingProviderPerson.getid());
        }
        else
        {
            s.addElement("2");
            ServicingProviderFacility servicingProviderFacility=servicingProviderRepository.findServicingProviderFacility(rapRequestFormDetail.getRapRequestForm().getServicingProviderName());
            s.addElement(servicingProviderFacility.getFacilityLastName());
            s.addElement(servicingProviderFacility.getFacilityFirstName());
            s.addElement(servicingProviderFacility.getFacilityMiddleName());
            s.addElement("");
            s.addElement("");
            s.addElement("46");
            s.addElement(servicingProviderFacility.getid());

            s = x12.addSegment();
            s.addElement("PER");
            s.addElement("IC");
            s.addElement("");
            s.addElement("TE");
            s.addElement(String.valueOf(servicingProviderFacility.getFacilityCommunicationTypeTelephone()));
            s.addElement("Ex");
            s.addElement(String.valueOf(servicingProviderFacility.getFacilityCommunicationExt()));
            s.addElement("FX");
            s.addElement(String.valueOf(servicingProviderFacility.getFacilityCommunicationTypeFacsimile()));
            s.addElement("EM");
            s.addElement(String.valueOf(servicingProviderFacility.getFacilityCommunicationTypeEMail()));

        }

        s = x12.addSegment();
        s.addElement("NM1");
        s.addElement("40");
        s.addElement("2");
        List<PayerDetails> payerDetailsList=rapRequestFormDetail.getPayerDetails();
        PayerDetails primaryPayer=new PayerDetails();
        PayerDetails secondaryPayer=new PayerDetails();
        PayerDetails tertiaryPayer=new PayerDetails();
        for(PayerDetails payerDetails:payerDetailsList) {
            if("primary".equals(payerDetails.getPayerType())) {
                primaryPayer=payerDetails;
            }
            if("secondary".equals(payerDetails.getPayerType())) {
                secondaryPayer=payerDetails;
            }
            if("tertiary".equals(payerDetails.getPayerType())) {
                tertiaryPayer=payerDetails;
            }
        }
        if(!("".equals(primaryPayer.toString()))) {
            s.addElement(primaryPayer.getPayerName());
            s.addElement("");
            s.addElement("");
            s.addElement("");
            s.addElement("");
            s.addElement("46");
            s.addElement(String.valueOf(primaryPayer.getPayerCarrierNumber()));
        }
        else if(!("".equals(secondaryPayer.toString())))
        {
            s.addElement(secondaryPayer.getPayerName());
            s.addElement("");
            s.addElement("");
            s.addElement("");
            s.addElement("");
            s.addElement("46");
            s.addElement(String.valueOf(secondaryPayer.getPayerCarrierNumber()));
        }
        else if(!("".equals(tertiaryPayer.toString())))
        {
            s.addElement(tertiaryPayer.getPayerName());
            s.addElement("");
            s.addElement("");
            s.addElement("");
            s.addElement("");
            s.addElement("46");
            s.addElement(String.valueOf(tertiaryPayer.getPayerCarrierNumber()));
        }


        s = x12.addSegment();
        s.addElement("HL");
        s.addElement("1");
        s.addElement("2");
        s.addElement("20");
        s.addElement("1");

        s = x12.addSegment();
        s.addElement("PRV");
        s.addElement("PC");
        s.addElement("ZZ");

        s = x12.addSegment();
        s.addElement("NM1");
        s.addElement("85");
        if("Person".equals(rapRequestFormDetail.getRapRequestForm().getBillingProviderType()))
        {
            s.addElement("1");
            BillingProviderPerson billingProviderPerson=servicingProviderRepository.findBillingProviderPerson(rapRequestFormDetail.getRapRequestForm().getBillingProviderName());
            s.addElement(billingProviderPerson.getPersonLastName());
            s.addElement(billingProviderPerson.getPersonFirstName());
            s.addElement(billingProviderPerson.getPersonMiddleName());
            s.addElement(billingProviderPerson.getPersonPrefix());
            s.addElement(billingProviderPerson.getPersonSuffix());
            s.addElement("XX");
            s.addElement(billingProviderPerson.getid());
            s = x12.addSegment();
            s.addElement("N3");
            s.addElement(billingProviderPerson.getPersonAddressLine());
            s = x12.addSegment();
            s.addElement("N4");
            s.addElement(billingProviderPerson.getPersonCity());
            s.addElement(billingProviderPerson.getPersonState());
            s.addElement(billingProviderPerson.getPersonZipCode());
            s = x12.addSegment();
            s.addElement("REF");
            s.addElement("SY");
            s.addElement(billingProviderPerson.getid());
        }
        else
        {
            s.addElement("2");
            BillingProviderFacility billingProviderFacility=servicingProviderRepository.findBillingProviderFacility(rapRequestFormDetail.getRapRequestForm().getBillingProviderName());
            s.addElement(billingProviderFacility.getFacilityLastName());
            s.addElement(billingProviderFacility.getFacilityFirstName());
            s.addElement(billingProviderFacility.getFacilityMiddleName());
            s.addElement("");
            s.addElement("");
            s.addElement("XX");
            s.addElement(billingProviderFacility.getid());
            s = x12.addSegment();
            s.addElement("N3");
            s.addElement(billingProviderFacility.getFacilityAddressLine());
            s = x12.addSegment();
            s.addElement("N4");
            s.addElement(billingProviderFacility.getFacilityCity());
            s.addElement(billingProviderFacility.getFacilityState());
            s.addElement(billingProviderFacility.getFacilityZipCode());
            s = x12.addSegment();
            s.addElement("REF");
            s.addElement("SY");
            s.addElement(billingProviderFacility.getid());

            s = x12.addSegment();
            s.addElement("PER");
            s.addElement("IC");
            s.addElement("");
            s.addElement("TE");
            s.addElement(String.valueOf(billingProviderFacility.getFacilityCommunicationTypeTelephone()));
            s.addElement("Ex");
            s.addElement(String.valueOf(billingProviderFacility.getFacilityCommunicationExt()));
            s.addElement("FX");
            s.addElement(String.valueOf(billingProviderFacility.getFacilityCommunicationTypeFacsimile()));
            s.addElement("EM");
            s.addElement(String.valueOf(billingProviderFacility.getFacilityCommunicationTypeEMail()));

        }
        s = x12.addSegment();
        s.addElement("HL");
        s.addElement("2");
        s.addElement("1");
        s.addElement("22");
        s.addElement("0");

        s = x12.addSegment();
        s.addElement("NM1");
        s.addElement("1L");
        s.addElement("1");
        List<InsuredDetails> insuredDetailsList=rapRequestFormDetail.getInsuredDetails();
        InsuredDetails primaryInsurance=new InsuredDetails();
        InsuredDetails secondaryInsurance=new InsuredDetails();
        InsuredDetails tertiaryInsurance=new InsuredDetails();
        for(InsuredDetails insuredDetails:insuredDetailsList) {
            if(insuredDetails.getCount()==1) {
                primaryInsurance=insuredDetails;
            }
            if(2==insuredDetails.getCount()) {
                secondaryInsurance=insuredDetails;
            }
            if(3==insuredDetails.getCount()) {
                tertiaryInsurance=insuredDetails;
            }
        }


        if(!("".equals(primaryInsurance.toString()))) {
            for (PrimaryInsuranceDetail primary:primaryInsuranceDetailRepository.findByID(primaryInsurance.getMrnNumber())) {
                s.addElement(primary.getInsuredlastName());
                s.addElement(primary.getInsuredfirstName());
                s.addElement(primary.getInsuredmiddleName());
                s.addElement("");
                s.addElement("");
                s.addElement("MI");
                s.addElement(primary.getSsn());
                s.addElement(" ");
                s.addElement(" ");
                s.addElement(" ");

                s = x12.addSegment();
                s.addElement("REF");
                s.addElement("SY");
                s.addElement(primary.getPolicyNumber());
                s.addElement(" ");
                s.addElement(" ");

                s = x12.addSegment();
                s.addElement("N3");
                s.addElement(primary.getInsuranceAddress());
                //   s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getRequestingAgency());
                s = x12.addSegment();
                s.addElement("N4");
                s.addElement(primary.getCity());
                s.addElement(primary.getState());
                s.addElement(String.valueOf(primary.getZipcode()));

                s = x12.addSegment();
                s.addElement("DMG");
                s.addElement("D8");
                String dob = String.valueOf(primary.getInsureddob());
                s.addElement(dob);
                String Gender = primary.getInsuredsex();
                if ("Male".equals(Gender)) {
                    s.addElement("M");
                } else if ("Female".equals(Gender)) {
                    s.addElement("F");
                } else if ("Unknown".equals(Gender)) {
                    s.addElement("U");
                }
                s = x12.addSegment();
                s.addElement("INS");
                s.addElement("Y");
                s.addElement(relationMap.get(primary.getPatientRelationInsured()));
                s = x12.addSegment();
                s.addElement("NM1");
                s.addElement("PR");
                s.addElement("2");
                s.addElement(primaryInsurance.getInsuredGroupName());
                s.addElement("");
                s.addElement("");
                s.addElement("");
                s.addElement("");
                s.addElement("PI");
                s.addElement(String.valueOf(primaryInsurance.getInsuredGroupNumber()));
            }

        }
        else if(!("".equals(secondaryInsurance.toString()))) {

            for (SecondaryInsuranceDetail secondary:secondaryInsuranceDetailRepository.findByID(secondaryInsurance.getMrnNumber())) {
                s.addElement(secondary.getInsuredlastName());
                s.addElement(secondary.getInsuredfirstName());
                s.addElement(secondary.getInsuredmiddleName());
                s.addElement("");
                s.addElement("");
                s.addElement("MI");
                s.addElement(secondary.getSsn());
                s.addElement(" ");
                s.addElement(" ");
                s.addElement(" ");

                s = x12.addSegment();
                s.addElement("REF");
                s.addElement("SY");
                s.addElement(secondary.getPolicyNumber());
                s.addElement(" ");
                s.addElement(" ");

                s = x12.addSegment();
                s.addElement("N3");
                s.addElement(secondary.getInsuranceAddress());
                //   s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getRequestingAgency());
                s = x12.addSegment();
                s.addElement("N4");
                s.addElement(secondary.getCity());
                s.addElement(secondary.getState());
                s.addElement(String.valueOf(secondary.getZipcode()));

                s = x12.addSegment();
                s.addElement("DMG");
                s.addElement("D8");
                String dob = String.valueOf(secondary.getInsureddob());
                s.addElement(dob);
                String Gender = secondary.getInsuredsex();
                if ("Male".equals(Gender)) {
                    s.addElement("M");
                } else if ("Female".equals(Gender)) {
                    s.addElement("F");
                } else if ("Unknown".equals(Gender)) {
                    s.addElement("U");
                }
                s = x12.addSegment();
                s.addElement("INS");
                s.addElement("Y");
                s.addElement(relationMap.get(secondary.getPatientRelationInsured()));
                s = x12.addSegment();
                s.addElement("NM1");
                s.addElement("PR");
                s.addElement("2");
                s.addElement(secondaryInsurance.getInsuredGroupName());
                s.addElement("");
                s.addElement("");
                s.addElement("");
                s.addElement("");
                s.addElement("PI");
                s.addElement(String.valueOf(secondaryInsurance.getInsuredGroupNumber()));
            }
        }
        else  if(!("".equals(tertiaryInsurance.toString()))) {

            for (TertiaryInsuranceDetail tertiary:tertiaryInsuranceDetailRepository.findByID(tertiaryInsurance.getMrnNumber())) {
                s.addElement(tertiary.getInsuredlastName());
                s.addElement(tertiary.getInsuredfirstName());
                s.addElement(tertiary.getInsuredmiddleName());
                s.addElement("");
                s.addElement("");
                s.addElement("MI");
                s.addElement(tertiary.getSsn());
                s.addElement(" ");
                s.addElement(" ");
                s.addElement(" ");

                s = x12.addSegment();
                s.addElement("REF");
                s.addElement("SY");
                s.addElement(tertiary.getPolicyNumber());
                s.addElement(" ");
                s.addElement(" ");

                s = x12.addSegment();
                s.addElement("N3");
                s.addElement(tertiary.getInsuranceAddress());
                //   s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getRequestingAgency());
                s = x12.addSegment();
                s.addElement("N4");
                s.addElement(tertiary.getCity());
                s.addElement(tertiary.getState());
                s.addElement(String.valueOf(tertiary.getZipcode()));

                s = x12.addSegment();
                s.addElement("DMG");
                s.addElement("D8");
                String dob = String.valueOf(tertiary.getInsureddob());
                s.addElement(dob);
                String Gender = tertiary.getInsuredsex();
                if ("Male".equals(Gender)) {
                    s.addElement("M");
                } else if ("Female".equals(Gender)) {
                    s.addElement("F");
                } else if ("Unknown".equals(Gender)) {
                    s.addElement("U");
                }
                s = x12.addSegment();
                s.addElement("INS");
                s.addElement("Y");
                s.addElement(relationMap.get(tertiary.getPatientRelationInsured()));
                s = x12.addSegment();
                s.addElement("NM1");
                s.addElement("PR");
                s.addElement("2");
                s.addElement(tertiaryInsurance.getInsuredGroupName());
                s.addElement("");
                s.addElement("");
                s.addElement("");
                s.addElement("");
                s.addElement("PI");
                s.addElement(String.valueOf(tertiaryInsurance.getInsuredGroupNumber()));
            }
        }
        s = x12.addSegment();
        s.addElement("HL");
        s.addElement("3");
        s.addElement("2");
        s.addElement("23");
        s.addElement("0");

        s = x12.addSegment();
        s.addElement("NM1");
        s.addElement("QC");
        s.addElement("1");
        s.addElement(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getLastName());
        s.addElement(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getFirstName());
        s.addElement(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getMiddleName());
        s.addElement(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getPrefix());
        s.addElement(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getSuffix());

        s = x12.addSegment();
        s.addElement("N3");
        s.addElement(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getAddressLine());
        //   s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getRequestingAgency());
        s = x12.addSegment();
        s.addElement("N4");
        s.addElement(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getCity());
        s.addElement(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getState());
        s.addElement(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getZipCode());

        s = x12.addSegment();
        s.addElement("DMG");
        s.addElement("D8");
        // s.addElement("19460401");
        s.addElement(rapRequestFormDetail.getRapRequestForm().getPatientDetail().getDob().toString());
        String Gender = rapRequestFormDetail.getRapRequestForm().getPatientDetail().getGender();
        if ("Male".equals(Gender)) {
            s.addElement("M");
        } else if ("Female".equals(Gender)) {
            s.addElement("F");
        } else if ("Unknown".equals(Gender)) {
            s.addElement("U");
        }

        s = x12.addSegment();
        s.addElement("HL");
        s.addElement("4");
        s.addElement("2");
        s.addElement("24");
        s.addElement("0");
        for(BillingDetails billingDetails:rapRequestFormDetail.getBillingDetailsList())
        {
            s = x12.addSegment();
            s.addElement("CLM");
            s.addElement(billingDetails.getMrnNumber());
            s.addElement(String.valueOf(billingDetails.getTotalCostForTotalCharge()));
            s.addElement("");
            s.addElement("");
            s.addElement("11:B:1");
            s.addElement("Y");
            s.addElement("A");
            s.addElement("Y");
            s.addElement("I");

        }


        s = x12.addSegment();
        s.addElement("DTP");
        s.addElement("434");
        s.addElement("D8");
        s.addElement(rapRequestFormDetail.getRapRequestForm().getStatementCoveredPeriodDateFrom().toString());
        s = x12.addSegment();
        s.addElement("DTP");
        s.addElement("435");
        s.addElement("D8");
        s.addElement(rapRequestFormDetail.getRapRequestForm().getAdmissionDate().toString());
        s = x12.addSegment();
        s.addElement("DTP");
        s.addElement("096");
        s.addElement("D8");
        s.addElement(rapRequestFormDetail.getRapRequestForm().getDischargeDate().toString());

        s = x12.addSegment();
        s.addElement("CL1");
        s.addElement("3");
        s.addElement("01");

        s = x12.addSegment();
        s.addElement("HI");
        s.addElement("ABK:"+rapRequestFormDetail.getPrimaryDiagnosisCode().getPrimaryDiagnosisCode());

        s = x12.addSegment();
        s.addElement("HI");

        String secondCode="";
        for(SecondDiagnosisCode secondDiagnosisCode:rapRequestFormDetail.getSecondDiagnosisCodeList())
        {
            secondCode=secondCode+"BF:"+secondDiagnosisCode.getSecondDiagnosisCode();
        }
        s.addElement(secondCode);
        AttendingProviderDetail attendingProviderDetail=rapRequestFormRepository.findAttendingProviderDetail(rapRequestFormDetail.getRapRequestForm().getAttendingProviderName());
        s = x12.addSegment();
        s.addElement("NM1");
        s.addElement("71");
        s.addElement("1");
        s.addElement(attendingProviderDetail.getLastName());
        s.addElement(attendingProviderDetail.getFirstName());
        s.addElement(attendingProviderDetail.getMiddleName());
        s.addElement(attendingProviderDetail.getPrefix());
        s.addElement(attendingProviderDetail.getSuffix());
        s = x12.addSegment();
        s.addElement("REF");
        s.addElement("1G");
        s.addElement(attendingProviderDetail.getId());
        s = x12.addSegment();
        s.addElement("N3");
        s.addElement(attendingProviderDetail.getAddressLine());
        //   s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getRequestingAgency());
        s = x12.addSegment();
        s.addElement("N4");
        s.addElement(attendingProviderDetail.getCity());
        s.addElement(attendingProviderDetail.getState());
        s.addElement(attendingProviderDetail.getZipCode());
        s = x12.addSegment();
        s.addElement("LX");
        s.addElement("1");
        for(BillingDetails billingDetails:rapRequestFormDetail.getBillingDetailsList()) {
            s = x12.addSegment();
            s.addElement("SV1");
            s.addElement(billingDetails.getRevenueCode());
            s.addElement("HC:85025");
            s.addElement(String.valueOf(billingDetails.getTotalCostForTotalCharge()));
            s.addElement("");
            s.addElement("");
            s.addElement("");
            s.addElement("");
            s.addElement("UN");
            s.addElement(String.valueOf(billingDetails.getId()));
            s = x12.addSegment();
            s.addElement("DTP");
            s.addElement("472");
            s.addElement("D8");
            s.addElement(billingDetails.getServiceDate().toString());
        }


        s = x12.addSegment();
        s.addElement("SE");
        s.addElement("42");
        s.addElement("0021");

        s = x12.addSegment();
        s.addElement("GE");
        s.addElement("1");
        s.addElement("101");

        s = x12.addSegment();
        s.addElement("IEA");
        s.addElement("1");
        s.addElement("000000101");
        String x12String = x12.toString();
        // System.out.print(x12String);


        return x12String;

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