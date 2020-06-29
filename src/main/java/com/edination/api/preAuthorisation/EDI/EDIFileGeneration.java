package com.edination.api.preAuthorisation.EDI;

import com.edination.api.eligibility.EDIFile.Context;
import com.edination.api.eligibility.EDIFile.Segment;
import com.edination.api.eligibility.EDIFile.X12Simple;
import com.edination.api.eligibility.model.Demographics;
import com.edination.api.preAuthorisation.model.HomeHealthPreAuthorizationForm;

import java.text.SimpleDateFormat;
import java.util.*;

public class EDIFileGeneration {
    public EDIFileGeneration(){}
    public String generateFile(HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm) throws Exception
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
        s.addElement("HI");
        s.addElement("146111111");
        s.addElement("617591011LTCPP");
        s.addElement("20170406");
        s.addElement("1130");
        s.addElement("10001");
        s.addElement("X");
        s.addElement("005010X217");

        s = x12.addSegment();
        s.addElement("ST");
        s.addElement("278");
        s.addElement("0032");
        s.addElement("005010X217");


        s = x12.addSegment();
        s.addElement("BHT");
        s.addElement("0007");
        s.addElement("13");
        s.addElement("0001");
        s.addElement("20100101");
        s.addElement("000000");

        s = x12.addSegment();
        s.addElement("HL");
        s.addElement("1");
        s.addElement("20");
        s.addElement("1");

        s = x12.addSegment();
        s.addElement("NM1");
        s.addElement("X3");
        s.addElement("2");
        s.addElement(homeHealthPreAuthorizationForm.getOrganizationInformation().getOrganizationName());
        s.addElement("");
        s.addElement("");
        s.addElement("");
        s.addElement("");
        s.addElement("46");
        s.addElement(homeHealthPreAuthorizationForm.getOrganizationInformation().getOrgIdentificationCodeType());
        s.addElement(homeHealthPreAuthorizationForm.getOrganizationInformation().getOrgIdentificationCode());
        s = x12.addSegment();
        s.addElement("PER");
        s.addElement("IC");
        s.addElement("");
        s.addElement("TE");
        s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getOrganizationInformation().getOrgCommunicationTypeTelephone()));
        s.addElement("Ex");
        s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getOrganizationInformation().getOrgCommunicationExt()));
        s.addElement("FX");
        s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getOrganizationInformation().getOrgCommunicationTypeFacsimile()));

        s = x12.addSegment();
        s.addElement("HL");
        s.addElement("2");
        s.addElement("1");
        s.addElement("21");
        s.addElement("1");

        s = x12.addSegment();
        s.addElement("NM1");
        s.addElement("1P");
        s.addElement("1");
        s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderLastName());
        s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderFirstName());
        s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderMiddleName());
        s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderPrefix());
        s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderSuffix());
        s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderIdentificationNumberType());
        s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderIdentificationNumber());
        s.addElement("");
        s.addElement("");
        s.addElement(" ");
        s = x12.addSegment();
        s.addElement("REF");
        s.addElement("1G");
        s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderSupplimentalId());
        s.addElement("");
        s.addElement("");

        s = x12.addSegment();
        s.addElement("PRV");
        s.addElement("AD");
        s.addElement("ZZ");
        s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getReqProviderSupplimentalId());
        s.addElement(" ");
        s.addElement(" ");
        s.addElement(" ");


        /*s = x12.addSegment();
        s.addElement("N3");
        s.addElement("200");
     //   s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getRequestingAgency());
        s = x12.addSegment();
        s.addElement("N4");
        s.addElement("JEFFERSON");
        s.addElement("NC");
        s.addElement("28640");

        s = x12.addSegment();
        s.addElement("PER");
        s.addElement("IC");
        s.addElement("TE");
       // s.addElement("9194567890");
        //String phone=String.valueOf(homeHealthPreAuthorizationForm.getProviderDetail().getPhoneNumber());
        //s.addElement(phone);*/
        s = x12.addSegment();
        s.addElement("HL");
        s.addElement("3");
        s.addElement("2");
        s.addElement("22");
        s.addElement("1");

        s = x12.addSegment();
        s.addElement("NM1");
        s.addElement("1L");
        s.addElement("1");
        s.addElement(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberLastName());
        s.addElement(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberFirstName());
        s.addElement(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberMiddleName());
        s.addElement(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberPrefix());
        s.addElement(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberSuffix());
        s.addElement("MI");
        s.addElement(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberSupplementalId());
        s.addElement(" ");
        s.addElement(" ");
        s.addElement(" ");

        s = x12.addSegment();
        s.addElement("REF");
        s.addElement("SY");
        s.addElement(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberIdentificationCode());
        s.addElement(" ");
        s.addElement(" ");

        s = x12.addSegment();
        s.addElement("N3");
        s.addElement("200");
     //   s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getRequestingAgency());
        s = x12.addSegment();
        s.addElement("N4");
        s.addElement("JEFFERSON");
        s.addElement("NC");
        s.addElement("28640");

        s = x12.addSegment();
        s.addElement("DMG");
        s.addElement("D8");
        String dob=String.valueOf(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberDob());
        s.addElement(dob);
        String Gender=homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberGender();
        if("Male".equals(Gender))
        {
         s.addElement("M");
        }
       else if("Female".equals(Gender))
        {
         s.addElement("F");
        }
        else if("Unknown".equals(Gender))
        {
         s.addElement("U");
        }
        s = x12.addSegment();
        s.addElement("INS");
        s.addElement("Y");
        s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getSubscriberDetails().getSubscriberRelToInsured()));
/*
        s = x12.addSegment();
        s.addElement("HL");
        s.addElement("4");
        s.addElement("3");
        s.addElement("23");
        s.addElement("1");

        s = x12.addSegment();
        s.addElement("NM1");
        s.addElement("QC");
        s.addElement("1");
      *//*  s.addElement("RUBBLE");
        s.addElement("BARNEY");*//*
        s.addElement(homeHealthPreAuthorizationForm.getPreAuthDemographics().getFirstName());
        s.addElement(homeHealthPreAuthorizationForm.getPreAuthDemographics().getLastName());
        s = x12.addSegment();
        s.addElement("DMG");
        s.addElement("D8");
       // s.addElement("19460401");
        s.addElement(dob);
        s.addElement("M");*/

        s = x12.addSegment();
        s.addElement("HL");
        s.addElement("6");
        s.addElement("5");
        s.addElement("EV");
        s.addElement("1");

        s = x12.addSegment();
        s.addElement("TRN");
        s.addElement("2");
        s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getEnquiryDeatils().getEnquiryId()));
        s.addElement("9012345678");
        s.addElement("HOME HEALTH");

        s = x12.addSegment();
        s.addElement("UM");
        s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getProviderDetail().getRequestCategory()));
        s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getProviderDetail().getCertificationType()));
         s.addElement("42");
        s.addElement("13:B");
        s.addElement("");
        s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getProviderDetail().getLevelOfService()));
        s.addElement("");
        s.addElement("");
        s.addElement("");
        s.addElement("");

        s = x12.addSegment();
        s.addElement("REF");
        s.addElement("NT");
        s.addElement("");

        s = x12.addSegment();
        s.addElement("REF");
        s.addElement("BB");
        s.addElement("");

        s = x12.addSegment();
        s.addElement("DTP");
        s.addElement("439");
        s.addElement("D8");
        s.addElement("");

     s = x12.addSegment();
     s.addElement("DTP");
     s.addElement("484");
     s.addElement("D8");
     s.addElement("");

     s = x12.addSegment();
     s.addElement("DTP");
     s.addElement("ABC");
     s.addElement("D8");
     s.addElement("");

     s = x12.addSegment();
     s.addElement("DTP");
     s.addElement("431");
     s.addElement("D8");
     s.addElement("");

     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
   /*  Date serviceDateFrom = formatter.parse(homeHealthPreAuthorizationForm.getProviderDetail().getServiceDateFrom());
     Date serviceDateTo = formatter.parse(homeHealthPreAuthorizationForm.getProviderDetail().getServiceDateTo().toString());*/
     s = x12.addSegment();
     s.addElement("DTP");
     s.addElement("472");
     s.addElement("RD8");
     s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getServiceDateFrom().toString()+homeHealthPreAuthorizationForm.getProviderDetail().getServiceDateTo().toString());
    // Date admitdate = formatter.parse(homeHealthPreAuthorizationForm.getProviderDetail().getAdmitDate().toString());
     s = x12.addSegment();
     s.addElement("DTP");
     s.addElement("435");
     s.addElement("D8");
     s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getAdmitDate().toString());
    // Date dischargedate = formatter.parse(homeHealthPreAuthorizationForm.getProviderDetail().getDischargeDate().toString());
     s = x12.addSegment();
     s.addElement("DTP");
     s.addElement("096");
     s.addElement("D8");
     s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getDischargeDate().toString());

     s = x12.addSegment();
     s.addElement("DTP");
     s.addElement("102");
     s.addElement("D8");
     s.addElement("");

     s = x12.addSegment();
     s.addElement("DTP");
     s.addElement("036");
     s.addElement("D8");
     s.addElement("");

     s = x12.addSegment();
     s.addElement("DTP");
     s.addElement("007");
     s.addElement("RD8");
     s.addElement("");

     s = x12.addSegment();
     s.addElement("HI01");
     s.addElement("BO");
     s.addElement("490000");
     s.addElement("D8");
     s.addElement("");
     s.addElement("1");

     s = x12.addSegment();
     s.addElement("HSD");
     s.addElement("VS");
     s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideVisit()));
     s.addElement("DA");
     s.addElement("1");
     s.addElement("7");
     s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideUnit()));
     s.addElement("");


        s = x12.addSegment();
        s.addElement("CL1");
        s.addElement("3");
        s.addElement("");
        s.addElement("1");

     s = x12.addSegment();
     s.addElement("CR1");
     s.addElement("");
     s.addElement("");
     s.addElement("T");
     s.addElement("");
     s.addElement("DH");
     s.addElement("28");
     s = x12.addSegment();
     s.addElement("CR2");
     s.addElement("1");
     s.addElement("5");

     s = x12.addSegment();
     s.addElement("CR5");
     s.addElement("");
     s.addElement("");
     s.addElement("D");
     s.addElement("");
     s.addElement("");
     s.addElement("1");
     s.addElement("");
     s.addElement("");
     s.addElement("");
     s.addElement("");
     s.addElement("");
     s.addElement("");
     s.addElement("");
     s.addElement("");
     s.addElement("");
     s.addElement("2");
     s.addElement("A");
     s = x12.addSegment();
     s.addElement("CR6");
     s.addElement("7");
     s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getServiceDateFrom().toString());
     s.addElement("");
     s.addElement("");
     s.addElement("");
     s.addElement("");
     s.addElement("N");
     s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getProviderDetail().getCertificationType()));
     if (homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideSelected()) {
       s = x12.addSegment();
        s.addElement("NM1");
        s.addElement("SJ");
        s.addElement("1");
       s.addElement(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAidePoviderLastName());
        s.addElement(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderFirstName());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderMiddleName());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderPrefix());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderSuffix());
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderIdentificationNumberType()));
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderIdentificationNumber());
      s = x12.addSegment();
      s.addElement("REF");
      s.addElement("1G");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderSupplimentalId());
        s = x12.addSegment();
        s.addElement("N3");
        s.addElement(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderAddress());
        s = x12.addSegment();
        s.addElement("N4");
        s.addElement(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderCity());
        s.addElement(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderState());
        s.addElement(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderPostalCode());
        s.addElement(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideProviderCountryCode());
                s = x12.addSegment();
                s.addElement("HL");
                s.addElement("6");
                s.addElement("6");
                s.addElement("SS");
                s.addElement("0");

                s = x12.addSegment();
                s.addElement("TRN");
                s.addElement("2");
                s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getEnquiryDeatils().getEnquiryId()));
                s.addElement("9012345678");
                s.addElement("HOME HEALTH");
                s = x12.addSegment();

             s = x12.addSegment();
             s.addElement("UM");
             s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideRequestCategory()));
             s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideCertificationType()));
             s.addElement("HHA");
             s.addElement("13:B");
             s.addElement("");
             s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideLevelOfService()));
             s.addElement("");
             s.addElement("");
             s.addElement("");
             s.addElement("");


        //   Date serviceDateFromHHA = formatter.parse(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideRequestServiceDateFrom().toString());
         //  Date serviceDateToHHA = formatter.parse(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideRequestServiceDateTo().toString());
          s = x12.addSegment();
          s.addElement("DTP");
          s.addElement("472");
          s.addElement("RD8");
         s.addElement(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideRequestServiceDateFrom().toString()+homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideRequestServiceDateTo().toString());

        s = x12.addSegment();
        s.addElement("DTP");
        s.addElement("102");
       s.addElement("D8");
       s.addElement("");

      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("036");
      s.addElement("D8");
      s.addElement("");

      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("007");
      s.addElement("RD8");
      s.addElement("");

      s = x12.addSegment();
      s.addElement("HI01");
      s.addElement("BO");
      s.addElement("490000");
      s.addElement("D8");
      s.addElement("");
      s.addElement("1");

      s = x12.addSegment();
      s.addElement("SV1");
      s.addElement("HC");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("23456");
      s.addElement("UN");

      s = x12.addSegment();
      s.addElement("SV2");
      s.addElement("HC");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("23456");
      s.addElement("UN");

      s = x12.addSegment();
      s.addElement("HSD");
      s.addElement("VS");
      s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideVisit()));
      s.addElement("DA");
      s.addElement("1");
      s.addElement("7");
      s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAideUnit()));
      s.addElement("");
//HHA
            }
     if (homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapySelected()) {
      s = x12.addSegment();
      s.addElement("NM1");
      s.addElement("SJ");
      s.addElement("1");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyPoviderLastName());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderFirstName());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderMiddleName());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderPrefix());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderSuffix());
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderIdentificationNumberType()));
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderIdentificationNumber());
      s = x12.addSegment();
      s.addElement("REF");
      s.addElement("1G");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderSupplimentalId());
      s = x12.addSegment();
      s.addElement("N3");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderAddress());
      s = x12.addSegment();
      s.addElement("N4");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderCity());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderState());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderPostalCode());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyProviderCountryCode());
      s = x12.addSegment();
      s.addElement("HL");
      s.addElement("6");
      s.addElement("7");
      s.addElement("SS");
      s.addElement("0");

      s = x12.addSegment();
      s.addElement("TRN");
      s.addElement("2");
      s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getEnquiryDeatils().getEnquiryId()));
      s.addElement("9012345678");
      s.addElement("HOME HEALTH");
      s = x12.addSegment();
      s = x12.addSegment();
      s.addElement("UM");
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyRequestCategory()));
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyCertificationType()));
      s.addElement("AD");
      s.addElement("13:B");
      s.addElement("");
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyLevelOfService()));
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");


      //Date serviceDateFromHHA = formatter.parse(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyRequestServiceDateFrom().toString());
     // Date serviceDateToHHA = formatter.parse(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyRequestServiceDateTo().toString());
      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("472");
      s.addElement("RD8");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyRequestServiceDateFrom().toString()+homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyRequestServiceDateTo().toString());

      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("102");
      s.addElement("D8");
      s.addElement("");

      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("036");
      s.addElement("D8");
      s.addElement("");

      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("007");
      s.addElement("RD8");
      s.addElement("");

      s = x12.addSegment();
      s.addElement("HI01");
      s.addElement("BO");
      s.addElement("490000");
      s.addElement("D8");
      s.addElement("");
      s.addElement("1");

      s = x12.addSegment();
      s.addElement("SV1");
      s.addElement("HC");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("23456");
      s.addElement("UN");

      s = x12.addSegment();
      s.addElement("SV2");
      s.addElement("HC");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("23456");
      s.addElement("UN");

      s = x12.addSegment();
      s.addElement("HSD");
      s.addElement("VS");
      s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyVisit()));
      s.addElement("DA");
      s.addElement("1");
      s.addElement("7");
      s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapyUnit()));
      s.addElement("");
//HHA
     }

     if (homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapySelected()) {
      s = x12.addSegment();
      s.addElement("NM1");
      s.addElement("SJ");
      s.addElement("1");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyPoviderLastName());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderFirstName());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderMiddleName());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderPrefix());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderSuffix());
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderIdentificationNumberType()));
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderIdentificationNumber());
      s = x12.addSegment();
      s.addElement("REF");
      s.addElement("1G");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderSupplimentalId());
      s = x12.addSegment();
      s.addElement("N3");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderAddress());
      s = x12.addSegment();
      s.addElement("N4");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderCity());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderState());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderPostalCode());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyProviderCountryCode());
      s = x12.addSegment();
      s.addElement("HL");
      s.addElement("6");
      s.addElement("8");
      s.addElement("SS");
      s.addElement("0");

      s = x12.addSegment();
      s.addElement("TRN");
      s.addElement("2");
      s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getEnquiryDeatils().getEnquiryId()));
      s.addElement("9012345678");
      s.addElement("HOME HEALTH");
      s = x12.addSegment();
      s = x12.addSegment();
      s.addElement("UM");
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyRequestCategory()));
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyCertificationType()));
      s.addElement("PT");
      s.addElement("13:B");
      s.addElement("");
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyLevelOfService()));
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");


     // Date serviceDateFromHHA = formatter.parse(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyRequestServiceDateFrom().toString());
     // Date serviceDateToHHA = formatter.parse(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyRequestServiceDateTo().toString());
      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("472");
      s.addElement("RD8");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyRequestServiceDateFrom().toString()+homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyRequestServiceDateTo().toString());

      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("102");
      s.addElement("D8");
      s.addElement("");

      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("036");
      s.addElement("D8");
      s.addElement("");

      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("007");
      s.addElement("RD8");
      s.addElement("");

      s = x12.addSegment();
      s.addElement("HI01");
      s.addElement("BO");
      s.addElement("490000");
      s.addElement("D8");
      s.addElement("");
      s.addElement("1");

      s = x12.addSegment();
      s.addElement("SV1");
      s.addElement("HC");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("23456");
      s.addElement("UN");

      s = x12.addSegment();
      s.addElement("SV2");
      s.addElement("HC");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("23456");
      s.addElement("UN");

      s = x12.addSegment();
      s.addElement("HSD");
      s.addElement("VS");
      s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyVisit()));
      s.addElement("DA");
      s.addElement("1");
      s.addElement("7");
      s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapyUnit()));
      s.addElement("");
//HHA
     }

     if (homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkSelected()) {
      s = x12.addSegment();
      s.addElement("NM1");
      s.addElement("SJ");
      s.addElement("1");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkPoviderLastName());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderFirstName());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderMiddleName());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderPrefix());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderSuffix());
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderIdentificationNumberType()));
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderIdentificationNumber());
      s = x12.addSegment();
      s.addElement("REF");
      s.addElement("1G");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderSupplimentalId());
      s = x12.addSegment();
      s.addElement("N3");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderAddress());
      s = x12.addSegment();
      s.addElement("N4");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderCity());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderState());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderPostalCode());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkProviderCountryCode());
      s = x12.addSegment();
      s.addElement("HL");
      s.addElement("6");
      s.addElement("9");
      s.addElement("SS");
      s.addElement("0");

      s = x12.addSegment();
      s.addElement("TRN");
      s.addElement("2");
      s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getEnquiryDeatils().getEnquiryId()));
      s.addElement("9012345678");
      s.addElement("HOME HEALTH");
      s = x12.addSegment();
      s = x12.addSegment();
      s.addElement("UM");
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkRequestCategory()));
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkCertificationType()));
      s.addElement("MSW");
      s.addElement("13:B");
      s.addElement("");
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkLevelOfService()));
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");


      //Date serviceDateFromHHA = formatter.parse(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkRequestServiceDateFrom().toString());
      //Date serviceDateToHHA = formatter.parse(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkRequestServiceDateTo().toString());
      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("472");
      s.addElement("RD8");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkRequestServiceDateFrom().toString()+homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkRequestServiceDateTo().toString());

      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("102");
      s.addElement("D8");
      s.addElement("");

      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("036");
      s.addElement("D8");
      s.addElement("");

      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("007");
      s.addElement("RD8");
      s.addElement("");

      s = x12.addSegment();
      s.addElement("HI01");
      s.addElement("BO");
      s.addElement("490000");
      s.addElement("D8");
      s.addElement("");
      s.addElement("1");

      s = x12.addSegment();
      s.addElement("SV1");
      s.addElement("HC");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("23456");
      s.addElement("UN");

      s = x12.addSegment();
      s.addElement("SV2");
      s.addElement("HC");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("23456");
      s.addElement("UN");

      s = x12.addSegment();
      s.addElement("HSD");
      s.addElement("VS");
      s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkVisit()));
      s.addElement("DA");
      s.addElement("1");
      s.addElement("7");
      s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWorkUnit()));
      s.addElement("");
//HHA
     }
     if (homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingSelected()) {
      s = x12.addSegment();
      s.addElement("NM1");
      s.addElement("SJ");
      s.addElement("1");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingPoviderLastName());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderFirstName());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderMiddleName());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderPrefix());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderSuffix());
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderIdentificationNumberType()));
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderIdentificationNumber());
      s = x12.addSegment();
      s.addElement("REF");
      s.addElement("1G");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderSupplimentalId());
      s = x12.addSegment();
      s.addElement("N3");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderAddress());
      s = x12.addSegment();
      s.addElement("N4");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderCity());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderState());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderPostalCode());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingProviderCountryCode());
      s = x12.addSegment();
      s.addElement("HL");
      s.addElement("6");
      s.addElement("10");
      s.addElement("SS");
      s.addElement("0");

      s = x12.addSegment();
      s.addElement("TRN");
      s.addElement("2");
      s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getEnquiryDeatils().getEnquiryId()));
      s.addElement("9012345678");
      s.addElement("HOME HEALTH");
      s = x12.addSegment();
      s = x12.addSegment();
      s.addElement("UM");
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingRequestCategory()));
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingCertificationType()));
      s.addElement("AG");
      s.addElement("13:B");
      s.addElement("");
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingLevelOfService()));
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");


     // Date serviceDateFromHHA = formatter.parse(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingRequestServiceDateFrom().toString());
     // Date serviceDateToHHA = formatter.parse(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingRequestServiceDateTo().toString());
      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("472");
      s.addElement("RD8");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingRequestServiceDateFrom().toString()+homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingRequestServiceDateTo().toString());

      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("102");
      s.addElement("D8");
      s.addElement("");

      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("036");
      s.addElement("D8");
      s.addElement("");

      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("007");
      s.addElement("RD8");
      s.addElement("");

      s = x12.addSegment();
      s.addElement("HI01");
      s.addElement("BO");
      s.addElement("490000");
      s.addElement("D8");
      s.addElement("");
      s.addElement("1");

      s = x12.addSegment();
      s.addElement("SV1");
      s.addElement("HC");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("23456");
      s.addElement("UN");

      s = x12.addSegment();
      s.addElement("SV2");
      s.addElement("HC");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("23456");
      s.addElement("UN");

      s = x12.addSegment();
      s.addElement("HSD");
      s.addElement("VS");
      s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingVisit()));
      s.addElement("DA");
      s.addElement("1");
      s.addElement("7");
      s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursingUnit()));
      s.addElement("");
//HHA
     }
     if (homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologySelected()) {
      s = x12.addSegment();
      s.addElement("NM1");
      s.addElement("SJ");
      s.addElement("1");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyPoviderLastName());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderFirstName());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderMiddleName());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderPrefix());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderSuffix());
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderIdentificationNumberType()));
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderIdentificationNumber());
      s = x12.addSegment();
      s.addElement("REF");
      s.addElement("1G");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderSupplimentalId());
      s = x12.addSegment();
      s.addElement("N3");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderAddress());
      s = x12.addSegment();
      s.addElement("N4");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderCity());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderState());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderPostalCode());
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyProviderCountryCode());
      s = x12.addSegment();
      s.addElement("HL");
      s.addElement("6");
      s.addElement("11");
      s.addElement("SS");
      s.addElement("0");

      s = x12.addSegment();
      s.addElement("TRN");
      s.addElement("2");
      s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getEnquiryDeatils().getEnquiryId()));
      s.addElement("9012345678");
      s.addElement("HOME HEALTH");
      s = x12.addSegment();
      s = x12.addSegment();
      s.addElement("UM");
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyRequestCategory()));
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyCertificationType()));
      s.addElement("AF");
      s.addElement("13:B");
      s.addElement("");
      s.addElement(relationMap.get(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyLevelOfService()));
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");


      Date serviceDateFromHHA = formatter.parse(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyRequestServiceDateFrom().toString());
      Date serviceDateToHHA = formatter.parse(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyRequestServiceDateTo().toString());
      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("472");
      s.addElement("RD8");
      s.addElement(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyRequestServiceDateFrom().toString()+homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyRequestServiceDateTo().toString());

      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("102");
      s.addElement("D8");
      s.addElement("");

      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("036");
      s.addElement("D8");
      s.addElement("");

      s = x12.addSegment();
      s.addElement("DTP");
      s.addElement("007");
      s.addElement("RD8");
      s.addElement("");

      s = x12.addSegment();
      s.addElement("HI01");
      s.addElement("BO");
      s.addElement("490000");
      s.addElement("D8");
      s.addElement("");
      s.addElement("1");

      s = x12.addSegment();
      s.addElement("SV1");
      s.addElement("HC");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("23456");
      s.addElement("UN");

      s = x12.addSegment();
      s.addElement("SV2");
      s.addElement("HC");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("");
      s.addElement("23456");
      s.addElement("UN");

      s = x12.addSegment();
      s.addElement("HSD");
      s.addElement("VS");
      s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyVisit()));
      s.addElement("DA");
      s.addElement("1");
      s.addElement("7");
      s.addElement(String.valueOf(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathologyUnit()));
      s.addElement("");
//HHA
     }
        s = x12.addSegment();
        s.addElement("SE");
        s.addElement("23");
        s.addElement("1001");

        s = x12.addSegment();
        s.addElement("GE");
        s.addElement("1");
        s.addElement("10001");

        s = x12.addSegment();
        s.addElement("IEA");
        s.addElement("1");
        s.addElement("100000001");
        String x12String = x12.toString();
       // System.out.print(x12String);


        return x12String;

    }


}
