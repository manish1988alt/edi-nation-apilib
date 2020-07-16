package com.edination.api.rap.EDI;

import com.edination.api.Dao.PrimaryInsuranceDetailRepository;
import com.edination.api.Dao.SecondaryInsuranceDetailRepository;
import com.edination.api.Dao.TertiaryInsuranceDetailRepository;
import com.edination.api.PDGM.model.SecondDiagnosisCode;
import com.edination.api.eligibility.EDIFile.Context;
import com.edination.api.eligibility.EDIFile.Segment;
import com.edination.api.eligibility.EDIFile.X12Simple;
import com.edination.api.eligibility.model.PrimaryInsuranceDetail;
import com.edination.api.eligibility.model.SecondaryInsuranceDetail;
import com.edination.api.eligibility.model.TertiaryInsuranceDetail;
import com.edination.api.preAuthorisation.model.HomeHealthPreAuthorizationForm;
import com.edination.api.rap.Dao.RapRequestFormRepository;
import com.edination.api.rap.model.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EDIFileGeneration {
 @Autowired
 RapRequestFormRepository rapRequestFormRepository;
    @Autowired
    PrimaryInsuranceDetailRepository primaryInsuranceDetailRepository;
    @Autowired
    SecondaryInsuranceDetailRepository secondaryInsuranceDetailRepository;
    @Autowired
    TertiaryInsuranceDetailRepository tertiaryInsuranceDetailRepository;
    public EDIFileGeneration(){}
    public String generateFile(RapRequestFormDetail rapRequestFormDetail) throws Exception
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
         ServicingProviderPerson servicingProviderPerson=rapRequestFormRepository.findServicingProviderPerson(rapRequestFormDetail.getRapRequestForm().getServicingProviderName());
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
         ServicingProviderFacility servicingProviderFacility=rapRequestFormRepository.findServicingProviderFacility(rapRequestFormDetail.getRapRequestForm().getServicingProviderName());
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
      BillingProviderPerson billingProviderPerson=rapRequestFormRepository.findBillingProviderPerson(rapRequestFormDetail.getRapRequestForm().getBillingProviderName());
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
      BillingProviderFacility billingProviderFacility=rapRequestFormRepository.findBillingProviderFacility(rapRequestFormDetail.getRapRequestForm().getBillingProviderName());
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


}
