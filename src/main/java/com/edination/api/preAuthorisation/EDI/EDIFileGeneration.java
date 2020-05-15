package com.edination.api.preAuthorisation.EDI;

import com.edination.api.eligibility.EDIFile.Context;
import com.edination.api.eligibility.EDIFile.Segment;
import com.edination.api.eligibility.EDIFile.X12Simple;
import com.edination.api.eligibility.model.Demographics;
import com.edination.api.preAuthorisation.model.HomeHealthPreAuthorizationForm;

public class EDIFileGeneration {
    public EDIFileGeneration(){}
    public String generateFile(HomeHealthPreAuthorizationForm homeHealthPreAuthorizationForm)
    {
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
        if(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getInsuranceTypeSelcted().equals("primary")) {
            //s.addElement("BLUE CROSS BLUE SHIELD NC");
            s.addElement(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getInsurancePlanName());
            s.addElement("46");
            s.addElement(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getGroup_name());
        }
        if(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getInsuranceTypeSelcted().equals("secondary")) {
            //s.addElement("BLUE CROSS BLUE SHIELD NC");
            s.addElement(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getInsurancePlanName());
            s.addElement("46");
            s.addElement(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getGroup_name());
        }
        if(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getInsuranceTypeSelcted().equals("tertiary")) {
            //s.addElement("BLUE CROSS BLUE SHIELD NC");
            s.addElement(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getInsurancePlanName());
            s.addElement("46");
            s.addElement(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getGroup_name());
        }
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
       // s.addElement("HELBY");
        s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getProviderName());
        //s.addElement("MARCUS");
        s.addElement("");
        s.addElement("XX");
        //s.addElement("1111122222");
        s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getRequestingProviderIDNumber());
        s = x12.addSegment();
        s.addElement("N3");
        s.addElement("200");
        s.addElement(homeHealthPreAuthorizationForm.getProviderDetail().getRequestingAgency());
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
        String phone=String.valueOf(homeHealthPreAuthorizationForm.getProviderDetail().getPhoneNumber());
        s.addElement(phone);
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
        /*s.addElement("RUBBLE");
        s.addElement("BARNEY");
        s.addElement("MI");
        s.addElement("YPPW1234567890");*/
        s.addElement(homeHealthPreAuthorizationForm.getPreAuthDemographics().getFirstName());
        s.addElement(homeHealthPreAuthorizationForm.getPreAuthDemographics().getLastName());
        s.addElement("MI");
        s.addElement(homeHealthPreAuthorizationForm.getPreAuthDemographics().getSsn());
        s = x12.addSegment();
        s.addElement("DMG");
        s.addElement("D8");
        String dob=String.valueOf(homeHealthPreAuthorizationForm.getPreAuthDemographics().getDob());
        s.addElement(dob);
        s.addElement("M");

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
      /*  s.addElement("RUBBLE");
        s.addElement("BARNEY");*/
        s.addElement(homeHealthPreAuthorizationForm.getPreAuthDemographics().getFirstName());
        s.addElement(homeHealthPreAuthorizationForm.getPreAuthDemographics().getLastName());
        s = x12.addSegment();
        s.addElement("DMG");
        s.addElement("D8");
       // s.addElement("19460401");
        s.addElement(dob);
        s.addElement("M");

        s = x12.addSegment();
        s.addElement("HL");
        s.addElement("5");
        s.addElement("4");
        s.addElement("EV");
        s.addElement("1");

        s = x12.addSegment();
        s.addElement("UM");
        s.addElement("HS");
        if(homeHealthPreAuthorizationForm.getRequestFor().getNewadmissionService()) {
         s.addElement("I");
        }
        s.addElement("A9");
        s.addElement("32:B");
       // s.addElement("B");
       /* s.addElement("4");
        s.addElement("M");*/

        s = x12.addSegment();
        s.addElement("DTP");
        s.addElement("435");
        s.addElement("D8");
        if(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getInsuranceTypeSelcted().equals("primary")) {
            // s.addElement("20100101");
            String start=String.valueOf(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getStartDate());
            s.addElement(start);
               }
        if(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getInsuranceTypeSelcted().equals("secondary")) {
            // s.addElement("20100101");
            String start=String.valueOf(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getStartDate());
            s.addElement(start);
           }
        if(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getInsuranceTypeSelcted().equals("tertiary")) {
            // s.addElement("20100101");
            String start=String.valueOf(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getStartDate());
            s.addElement(start);
             }
        s = x12.addSegment();
        s.addElement("DTP");
        s.addElement("096");
        s.addElement("D8");
        if(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getInsuranceTypeSelcted().equals("primary")) {
            // s.addElement("20100101");
            String end=String.valueOf(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getStartDate());
            s.addElement(end);
        }
        if(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getInsuranceTypeSelcted().equals("secondary")) {
            // s.addElement("20100101");
            String end=String.valueOf(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getSecondaryInsuranceDetail().getStartDate());
            s.addElement(end);
        }
        if(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getInsuranceTypeSelcted().equals("tertiary")) {
            // s.addElement("20100101");
            String end=String.valueOf(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getTertiaryInsuranceDetail().getStartDate());
            s.addElement(end);
        }
        s = x12.addSegment();
        s.addElement("MSG");
        s.addElement("NFSS");
        s = x12.addSegment();
        s.addElement("HI");
        //s.addElement("BF:D8:20050125");
        s.addElement("BF");
        s.addElement("D8");
        String admission=String.valueOf(homeHealthPreAuthorizationForm.getAdmissionDetail().getAdmissionDate());
        s.addElement(admission);

        s = x12.addSegment();
        s.addElement("HSD");
        s.addElement("DY");
        s.addElement("4");

        s = x12.addSegment();
        s.addElement("CL1");
        s.addElement("3");
        s.addElement("1");

        s = x12.addSegment();
        s.addElement("NM1");
        s.addElement("FA");
        s.addElement("2");
       // s.addElement("FLINTSTONE UNIVERSITY HOSPITAL");
        s.addElement(homeHealthPreAuthorizationForm.getAdmissionDetail().getReferringPhysician());
        s.addElement("XX");
        s.addElement("1001234567");

        s = x12.addSegment();
        s.addElement("N3");
        s.addElement("THELMA LANE");
        s = x12.addSegment();
        s.addElement("N4");
        s.addElement("DURHAM");
        s.addElement("NC");
        s.addElement("27705");

        if(homeHealthPreAuthorizationForm.getRequestService().getHomeHealthAide().getHomeHealthAide())
        {

        }
        if(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getOccupationTherapy())
        {

            s = x12.addSegment();
            s.addElement("HL");
            s.addElement("6");
            s.addElement("5");
            s.addElement("SS");
            s.addElement("0");
            s = x12.addSegment();
            s.addElement("UM");
            s.addElement("HS");
            s.addElement("N");
            s.addElement("AD");
            s = x12.addSegment();
            s.addElement("DTP");
            s.addElement("472");
            s.addElement("D8");
            s.addElement("20170406");
         s = x12.addSegment();
         s.addElement("HSD");
         s.addElement("VS");
         String visit=String.valueOf(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getVisits());
         s.addElement(visit);
         s.addElement("DA");
         s.addElement("1");
         s.addElement("34");
         String unit=String.valueOf(homeHealthPreAuthorizationForm.getRequestService().getOccupationTherapy().getUnits());
         s.addElement(unit);

         s = x12.addSegment();
            s.addElement("PWK");
            s.addElement("M1");
            s.addElement("EL");
            s.addElement("AC");
            s.addElement("102030405060");
            s = x12.addSegment();
            s.addElement("MSG");
            s.addElement("A");

        }
        if(homeHealthPreAuthorizationForm.getRequestService().getMedicalSocialWork().getMedicalSocialWork())
        {

        }
        if(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getPhysicalTherapy())
        {
            s = x12.addSegment();
            s.addElement("HL");
            s.addElement("7");
            s.addElement("5");
            s.addElement("SS");
            s.addElement("0");
            s = x12.addSegment();
            s.addElement("UM");
            s.addElement("HS");
            s.addElement("4");
            s.addElement("PT");
            s = x12.addSegment();
            s.addElement("DTP");
            s.addElement("472");
            s.addElement("D8");
            s.addElement("20170406");
         s = x12.addSegment();
         s.addElement("HSD");
         s.addElement("VS");
         String visit=String.valueOf(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getVisits());
         s.addElement(visit);
         s.addElement("DA");
         s.addElement("1");
         s.addElement("34");
         String unit=String.valueOf(homeHealthPreAuthorizationForm.getRequestService().getPhysicalTherapy().getUnits());
         s.addElement(unit);
            s = x12.addSegment();
            s.addElement("PWK");
            s.addElement("M1");
            s.addElement("EL");
            s.addElement(" ");
            s.addElement("AC");
            s.addElement("222");
            s = x12.addSegment();
            s.addElement("MSG");
            s.addElement("A");
        }
        if(homeHealthPreAuthorizationForm.getRequestService().getSkilledNursing().getSkilledNursing())
        {

        }
        if(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getSpeechPathology())
        {
                s = x12.addSegment();
            s.addElement("HL");
            s.addElement("8");
            s.addElement("5");
            s.addElement("SS");
            s.addElement("0");
            s = x12.addSegment();
            s.addElement("UM");
            s.addElement("HS");
            s.addElement("R");
            s.addElement("AF");
            s = x12.addSegment();
            s.addElement("DTP");
            s.addElement("472");
            s.addElement("D8");
            s.addElement("20170406");
         s = x12.addSegment();
         s.addElement("HSD");
         s.addElement("VS");
         String visit=String.valueOf(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getVisits());
         s.addElement(visit);
         s.addElement("DA");
         s.addElement("1");
         s.addElement("34");
         String unit=String.valueOf(homeHealthPreAuthorizationForm.getRequestService().getSpeechPathology().getUnits());
         s.addElement(unit);
            s = x12.addSegment();
            s.addElement("PWK");
            s.addElement("M1");
            s.addElement("EL");
            s.addElement(" ");
            s.addElement("AC");
            s.addElement("987457");
            s = x12.addSegment();
            s.addElement("MSG");
            s.addElement("A");

        }
        s = x12.addSegment();
        s.addElement("TRN");
        s.addElement("1");
        s.addElement("TS32-2");
        s.addElement("90004N7891");

        s = x12.addSegment();
        s.addElement("DTP");
        s.addElement("472");
        s.addElement("RD8");

        String start=String.valueOf(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getStartDate());
        String end=String.valueOf(homeHealthPreAuthorizationForm.getInsuranceDetailPreAuth().getPrimaryInsuranceDetail().getEndDate());
        s.addElement(start+"-"+end);

        s = x12.addSegment();
        s.addElement("SV2");
        s.addElement("HC:33510");

        s = x12.addSegment();
        s.addElement("NM1");
        s.addElement("IL");
        s.addElement("1");
        s.addElement("HELBY");
        s.addElement("MARCUS");
        s.addElement("XX");
        s.addElement("1111122222");
       // s.addElement(demographics1.getInsuranceDetail().getPolicyNumber());
        //END

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
