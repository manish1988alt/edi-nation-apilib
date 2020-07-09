package com.edination.api.rap.rest;

import com.edination.api.PDGM.dao.SecondDaignosisCodeRepository;
import com.edination.api.PDGM.model.PDGMRapListing;
import com.edination.api.preAuthorisation.MasterCode.ProviderCodeMaster;
import com.edination.api.rap.Dao.RapRequestFormRepository;
import com.edination.api.rap.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("rap")
public class RapRestApp implements Serializable {

    @Autowired
    RapRequestFormRepository rapRequestFormRepository;
@Autowired
    SecondDaignosisCodeRepository secondDaignosisCodeRepository;
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
        if ("Person".equals(rapRequestForm.getServicingProviderType())) {
            list.add(rapRequestFormRepository.billingProviderPersonList());
        } else if ("Facility".equals(rapRequestForm.getServicingProviderType())) {
            list.add(rapRequestFormRepository.billingProviderFacilityList());
        }
        return list;
    }
    @PostMapping("/otherProviderTypeList")
    public List<OtherProviderList> otherProviderTypeList(@RequestBody RapRequestForm rapRequestForm) throws Throwable {

        return  rapRequestFormRepository.OtherProviderList(rapRequestForm.getServicingProviderType());

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
        rapRequestFormDetail.setBillingDetailsList(rapRequestFormRepository.findBillingDetailsByMrnNumber(pdgmRapListing.getMrnNumber()));
        rapRequestFormDetail.setPayerDetails(rapRequestFormRepository.findPayerDetailsByMrnNumber(pdgmRapListing.getMrnNumber()));
        rapRequestFormDetail.setInsuredDetails(rapRequestFormRepository.findInsuredDetailsByMrnNumber(pdgmRapListing.getMrnNumber()));
        rapRequestFormDetail.setPrimaryDiagnosisCode(rapRequestFormRepository.findPrimaryDiagnosisCodeByMrnNumber(pdgmRapListing.getMrnNumber()));
        rapRequestFormDetail.setSecondDiagnosisCodeList(secondDaignosisCodeRepository.findSecondDiagnosisListCodeByMrn(pdgmRapListing.getMrnNumber()));
        rapRequestFormDetail.setOtherProviderDetails(rapRequestFormRepository.findOtherProviderDetailByMrnNumber(pdgmRapListing.getMrnNumber()));
        list.add(rapRequestFormDetail);
        return list;
    }

}