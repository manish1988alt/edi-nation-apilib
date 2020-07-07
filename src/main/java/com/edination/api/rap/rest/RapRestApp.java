package com.edination.api.rap.rest;

import com.edination.api.PDGM.model.PDGMRapListing;
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

    @PostMapping("/rapRequestView")
    public List<RapRequestForm> rapRequestView(@RequestBody PDGMRapListing pdgmRapListing) throws Throwable
    {
        return rapRequestFormRepository.rapRequestFormView(pdgmRapListing.getMrnNumber());
    }

}