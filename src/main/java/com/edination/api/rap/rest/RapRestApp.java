package com.edination.api.rap.rest;

import com.edination.api.PDGM.dao.PDGMRapListRepository;
import com.edination.api.PDGM.dao.PDGMRapListService;
import com.edination.api.PDGM.dao.SecondDaignosisCodeRepository;
import com.edination.api.PDGM.model.ClinicalGroupingPrimaryDiagnosis;
import com.edination.api.PDGM.model.PDGMRapListing;
import com.edination.api.preAuthorisation.MasterCode.ProviderCodeMaster;
import com.edination.api.rap.Dao.*;
import com.edination.api.rap.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.Response;
import java.io.Serializable;
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
    OccuranceAndDateService occuranceAndDateService;
    @Autowired
    ValueCodeDetailService valueCodeDetailService;
    @Autowired
    InsuredDetailsService insuredDetailsService;
    @Autowired
    PayerDetailsService payerDetailsService;
    @Autowired
    OtherProviderDetailService otherProviderDetailService;
    @Autowired
    RapRequestEnquiryDetailsService rapRequestEnquiryDetailsService;
    @Autowired
    TreatmentAuthorizationDetailsService treatmentAuthorizationDetailsService;
    @Autowired
    BillingDetailsRepository billingDetailsRepository;
    @Autowired
    PayerDetailsRepository payerDetailsRepository;
    @Autowired
    InsuredDetailsRepository insuredDetailsRepository;
    @Autowired
    RapRequestEnquiryDetailsRepository rapRequestEnquiryDetailsRepository;

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
    @PostMapping("/rapRequestView")
    public List<RapRequestFormDetail> rapRequestView(@RequestBody PDGMRapListing pdgmRapListing) throws Throwable
    {
        List<RapRequestFormDetail> list=new ArrayList<>();
        List<ConditionCodeDetail> conditionCodeDetailList=rapRequestFormRepository.findConditionCodeDetailByMrnNumber(pdgmRapListing.getMrnNumber());
        List<OccuranceAndDate> occuranceAndDateList=rapRequestFormRepository.findOccuranceAndDateByMrnNumber(pdgmRapListing.getMrnNumber());
        List<ValueCodeDetail> valueCodeDetailList=rapRequestFormRepository.findValueCodeDetailByMrnNumber(pdgmRapListing.getMrnNumber());
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
        rapRequestFormDetail.setOtherProviderDetails(rapRequestFormRepository.findOtherProviderDetailByMrnNumber(pdgmRapListing.getMrnNumber()));
        rapRequestFormDetail.setRapRequestEnquiryDetails(rapRequestEnquiryDetailsRepository.findRapRequestEnquiryDetailsByMrnNumber(pdgmRapListing.getMrnNumber()));
        rapRequestFormDetail.setTreatmentAuthorizationDetails(rapRequestFormRepository.findTreatmentAuthorizationDetailsByMrnNumber(pdgmRapListing.getMrnNumber()));
        list.add(rapRequestFormDetail);
        return list;
    }
    @PostMapping("/rapRequestEdit")
    public List<RapRequestFormDetail>  rapRequestEdit(@RequestBody  RapRequestFormDetail rapRequestFormDetail)  throws Throwable
    {
        List<RapRequestFormDetail> list=new ArrayList<>();
        List<ConditionCodeDetail> conditionCodeDetailList=rapRequestFormRepository.findConditionCodeDetailByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
        List<OccuranceAndDate> occuranceAndDateList=rapRequestFormRepository.findOccuranceAndDateByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
        List<ValueCodeDetail> valueCodeDetailList=rapRequestFormRepository.findValueCodeDetailByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
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
        rapRequestFormDetail.setInsuredDetails(insuredDetailsList);
        rapRequestFormDetail.setTreatmentAuthorizationDetails(rapRequestFormRepository.findTreatmentAuthorizationDetailsByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn()));
        rapRequestFormDetail1.setPrimaryDiagnosisCode(rapRequestFormRepository.findPrimaryDiagnosisCodeByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn()));
        rapRequestFormDetail1.setSecondDiagnosisCodeList(secondDaignosisCodeRepository.findSecondDiagnosisListCodeByMrn(rapRequestFormDetail.getRapRequestForm().getPatientMrn()));
        rapRequestFormDetail1.setOtherProviderDetails(rapRequestFormRepository.findOtherProviderDetailByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn()));
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

        ackn= this.saveOperation(rapRequestFormDetail,"Sent For Approval");


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
        RapRequestForm rapRequestForm=new RapRequestForm();
        rapRequestForm.setPatientMrn(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
        rapRequestForm.setAccidentDate(rapRequestFormDetail.getRapRequestForm().getAccidentDate());
        rapRequestForm.setAccidentState(rapRequestFormDetail.getRapRequestForm().getAccidentState());
        rapRequestForm.setAdmissionDate(rapRequestFormDetail.getRapRequestForm().getAdmissionDate());
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
        rapRequestForm.setStatementCoveredPeriodDateFrom(rapRequestFormDetail.getRapRequestForm().getStatementCoveredPeriodDateFrom());
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
            billingDetails.setMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
            billingDetails.sethCPCS_Rate_HCPCS_Code(bl.gethCPCS_Rate_HCPCS_Code());
            billingDetails.setTotalCostForTotalCharge(bl.getTotalCostForTotalCharge());
            billingDetails.setTotalCostForNonCoverageCharge(bl.getTotalCostForNonCoverageCharge());
            billingDetails.setTotalCharge(bl.getTotalCharge());
            billingDetails.setServiceUnit(bl.getServiceUnit());
            billingDetails.setServiceDate(bl.getServiceDate());
            billingDetails.setRevenueCodeDescription(bl.getRevenueCodeDescription());
            billingDetails.setNonCoverageCharge(bl.getNonCoverageCharge());
            billingDetails.setCreationDate(bl.getCreationDate());
            billingDetails.setCount(bl.getCount());
            billingDetailsService.save(billingDetails);
        }

        for(ConditionCodeDetail cnd:rapRequestFormDetail.getConditionCodeDetailList())
        {
            ConditionCodeDetail conditionCodeDetail=new ConditionCodeDetail();
            conditionCodeDetail.setMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
            conditionCodeDetail.setCode(cnd.getCode());
            conditionCodeDetailService.save(conditionCodeDetail);
        }

        for(OccuranceAndDate occurance:rapRequestFormDetail.getOccuranceAndDateList())
        {
            OccuranceAndDate occuranceAndDate=new OccuranceAndDate();
            occuranceAndDate.setMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
            occuranceAndDate.setCode(occurance.getCode());
            occuranceAndDateService.save(occuranceAndDate);
        }

        for(ValueCodeDetail valueCode:rapRequestFormDetail.getValueCodeDetailList())
        {
            ValueCodeDetail valueCodeDetail=new ValueCodeDetail();
            valueCodeDetail.setMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
            valueCodeDetail.setCode(valueCode.getCode());
            valueCodeDetailService.save(valueCodeDetail);
        }


        for(InsuredDetails insuredDetails1:rapRequestFormDetail.getInsuredDetails())
        {
            InsuredDetails insuredDetails=new InsuredDetails();
            insuredDetails.setCount(insuredDetails1.getCount());
            insuredDetails.setInsuredGroupName(insuredDetails1.getInsuredGroupName());
            insuredDetails.setInsuredGroupNumber(insuredDetails1.getInsuredGroupNumber());
            insuredDetails.setInsuredName(insuredDetails1.getInsuredName());
            insuredDetails.setInsuredUniqueIdentifiers(insuredDetails1.getInsuredUniqueIdentifiers());
            insuredDetails.setMrnNumber(insuredDetails1.getMrnNumber());
            insuredDetails.setRelationshipToInsured(insuredDetails1.getRelationshipToInsured());
            insuredDetailsService.save(insuredDetails);
        }

        for(PayerDetails payerDetails1: rapRequestFormDetail.getPayerDetails())
        {
            PayerDetails payerDetails=new PayerDetails();
            payerDetails.setAssignmentOfBenefit(payerDetails1.getAssignmentOfBenefit());
            payerDetails.setCount(payerDetails1.getCount());
            payerDetails.setEstimateAmount(payerDetails1.getEstimateAmount());
            payerDetails.setHealthPlanID(payerDetails1.getHealthPlanID());
            payerDetails.setMrnNumber(payerDetails1.getMrnNumber());
            payerDetails.setPayerCarrierNumber(payerDetails1.getPayerCarrierNumber());
            payerDetails.setPayerName(payerDetails1.getPayerName());
            payerDetails.setPayerType(payerDetails1.getPayerType());
            payerDetails.setPriorPayment(payerDetails1.getPriorPayment());
            payerDetailsService.save(payerDetails);
        }
        for(TreatmentAuthorizationDetails treatmentAuthorizationDetails1: rapRequestFormDetail.getTreatmentAuthorizationDetails())
        {
            TreatmentAuthorizationDetails treatmentAuthorizationDetails = new TreatmentAuthorizationDetails();
            treatmentAuthorizationDetails.setEmployeeName(treatmentAuthorizationDetails1.getEmployeeName());
            treatmentAuthorizationDetails.setTreatmentAuthorizationCode(treatmentAuthorizationDetails1.getTreatmentAuthorizationCode());
            treatmentAuthorizationDetails.setDocumentControlNumber(treatmentAuthorizationDetails1.getDocumentControlNumber());
            treatmentAuthorizationDetails.setMrnNumber(treatmentAuthorizationDetails1.getMrnNumber());
            treatmentAuthorizationDetailsService.save(treatmentAuthorizationDetails);
        }
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

        }
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
            pdgmRapListing1.setEpisodeStartDates(pdgmRapListing.getEpisodeStartDates());
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
            LocalDate formSentDate = LocalDate.parse(currentDate);
            pdgmRapListing1.setRapsSentDate(formSentDate);
            pdgmRapListing1.setRapsType(pdgmRapListing.getRapsType());
            pdgmRapListService.save(pdgmRapListing1);
        }
        return ackn;
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