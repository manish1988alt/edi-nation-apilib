package com.edination.api.rap.rest;

import com.edination.api.PDGM.dao.PDGMRapListRepository;
import com.edination.api.PDGM.dao.PDGMRapListService;
import com.edination.api.PDGM.dao.SecondDaignosisCodeRepository;
import com.edination.api.PDGM.model.PDGMRapListing;
import com.edination.api.preAuthorisation.MasterCode.ProviderCodeMaster;
import com.edination.api.rap.Dao.RapRequestFormRepository;
import com.edination.api.rap.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("rap")
public class RapRestApp implements Serializable {

    @Autowired
    RapRequestFormRepository rapRequestFormRepository;
    @Autowired
    SecondDaignosisCodeRepository secondDaignosisCodeRepository;
    @Autowired
    PDGMRapListService pdgmRapListService;
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
       List<BillingDetails>  billingDetailsList =rapRequestFormRepository.findBillingDetailsByMrnNumber(pdgmRapListing.getMrnNumber());
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
        rapRequestFormDetail.setPayerDetails(rapRequestFormRepository.findPayerDetailsByMrnNumber(pdgmRapListing.getMrnNumber()));
        rapRequestFormDetail.setInsuredDetails(rapRequestFormRepository.findInsuredDetailsByMrnNumber(pdgmRapListing.getMrnNumber()));
        rapRequestFormDetail.setPrimaryDiagnosisCode(rapRequestFormRepository.findPrimaryDiagnosisCodeByMrnNumber(pdgmRapListing.getMrnNumber()));
        rapRequestFormDetail.setSecondDiagnosisCodeList(secondDaignosisCodeRepository.findSecondDiagnosisListCodeByMrn(pdgmRapListing.getMrnNumber()));
        rapRequestFormDetail.setOtherProviderDetails(rapRequestFormRepository.findOtherProviderDetailByMrnNumber(pdgmRapListing.getMrnNumber()));
        rapRequestFormDetail.setRapRequestEnquiryDetails(rapRequestFormRepository.findRapRequestEnquiryDetailsByMrnNumber(pdgmRapListing.getMrnNumber()));
        rapRequestFormDetail.setTreatmentAuthorizationDetails(rapRequestFormRepository.findTreatmentAuthorizationDetailsByMrnNumber(pdgmRapListing.getMrnNumber()));
        list.add(rapRequestFormDetail);
        return list;
    }
    @PostMapping("/preAuthRequestEdit")
    public List<RapRequestFormDetail>   preAuthRequestEdit(@RequestBody  RapRequestFormDetail rapRequestFormDetail)  throws Throwable
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
        List<BillingDetails>  billingDetailsList =rapRequestFormRepository.findBillingDetailsByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
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
        rapRequestFormDetail.setTreatmentAuthorizationDetails(rapRequestFormRepository.findTreatmentAuthorizationDetailsByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn()));
        rapRequestFormDetail1.setPayerDetails(rapRequestFormRepository.findPayerDetailsByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn()));
        rapRequestFormDetail1.setInsuredDetails(rapRequestFormRepository.findInsuredDetailsByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn()));
        rapRequestFormDetail1.setPrimaryDiagnosisCode(rapRequestFormRepository.findPrimaryDiagnosisCodeByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn()));
        rapRequestFormDetail1.setSecondDiagnosisCodeList(secondDaignosisCodeRepository.findSecondDiagnosisListCodeByMrn(rapRequestFormDetail.getRapRequestForm().getPatientMrn()));
        rapRequestFormDetail1.setOtherProviderDetails(rapRequestFormRepository.findOtherProviderDetailByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn()));
       RapRequestEnquiryDetails rapRequestEnquiryDetailsObj= rapRequestFormRepository.findRapRequestEnquiryDetailsByMrnNumber(rapRequestFormDetail.getRapRequestForm().getPatientMrn());
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
   /* @PostMapping("/preAuthRequestSave")
    public List<RapRequestFormDetail>   preAuthRequestEdit(@RequestBody  RapRequestFormDetail rapRequestFormDetail)  throws Throwable
    {
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
        TreatmentAuthorizationDetails treatmentAuthorizationDetails=new TreatmentAuthorizationDetails();
        treatmentAuthorizationDetails.setDocumentControlNumber(rapRequestFormDetail.getRapRequestForm().getTreatmentAuthorizationDetails().getDocumentControlNumber());
        treatmentAuthorizationDetails.setTreatmentAuthorizationCode(rapRequestFormDetail.getRapRequestForm().getTreatmentAuthorizationDetails().getTreatmentAuthorizationCode());
        treatmentAuthorizationDetails.setEmployeeName(rapRequestFormDetail.getRapRequestForm().getTreatmentAuthorizationDetails().getEmployeeName());
        rapRequestForm.setTreatmentAuthorizationDetails(treatmentAuthorizationDetails);
        Patientdetail patientdetail=new Patientdetail();
        patientdetail.setName(rapRequestFormDetail.getRapRequestForm().getPatientdetail().getName());
        patientdetail.setFirstName(rapRequestFormDetail.getRapRequestForm().getPatientdetail().getFirstName());
        patientdetail.setLastName(rapRequestFormDetail.getRapRequestForm().getPatientdetail().getLastName());
        patientdetail.setMiddleName(rapRequestFormDetail.getRapRequestForm().getPatientdetail().getMiddleName());
        patientdetail.setPrefix(rapRequestFormDetail.getRapRequestForm().getPatientdetail().getPrefix());
        patientdetail.setSuffix(rapRequestFormDetail.getRapRequestForm().getPatientdetail().getSuffix());
        patientdetail.setGender(rapRequestFormDetail.getRapRequestForm().getPatientdetail().getGender());
        patientdetail.setDob(rapRequestFormDetail.getRapRequestForm().getPatientdetail().getDob());
        patientdetail.setPatientNameIdentifier(rapRequestFormDetail.getRapRequestForm().getPatientdetail().getPatientNameIdentifier());
        patientdetail.setAddressLine(rapRequestFormDetail.getRapRequestForm().getPatientdetail().getAddressLine());
        patientdetail.setCity(rapRequestFormDetail.getRapRequestForm().getPatientdetail().getCity());
        patientdetail.setState(rapRequestFormDetail.getRapRequestForm().getPatientdetail().getState());
        patientdetail.setZipCode(rapRequestFormDetail.getRapRequestForm().getPatientdetail().getZipCode());
        rapRequestForm.setPatientdetail(patientdetail);
        BillingDetails billingDetails=new BillingDetails();
        for(BillingDetails bl:rapRequestFormDetail.getBillingDetailsList())
        {
            billingDetails.setMrnNumber(bl.getMrnNumber());
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
        }
        ConditionCodeDetail conditionCodeDetail=new ConditionCodeDetail();
        for(ConditionCodeDetail cnd:rapRequestFormDetail.getConditionCodeDetailList())
        {
            conditionCodeDetail.setMrnNumber(cnd.getMrnNumber());
            conditionCodeDetail.setCode(cnd.getCode());
        }
        OccuranceAndDate occuranceAndDate=new OccuranceAndDate();
        for(OccuranceAndDate cnd:rapRequestFormDetail.getOccuranceAndDateList())
        {
            occuranceAndDate.setMrnNumber(cnd.getMrnNumber());
            occuranceAndDate.setCode(cnd.getCode());
        }

        rapRequestFormDetail.getConditionCodeDetailList();
        rapRequestFormDetail.getInsuredDetails();
        rapRequestFormDetail.getOccuranceAndDateList();
        rapRequestFormDetail.getOtherProviderDetails();
        rapRequestFormDetail.getPayerDetails();
        rapRequestFormDetail.getValueCodeDetailList();
        rapRequestFormDetail.getRapRequestEnquiryDetails();



    }*/
}