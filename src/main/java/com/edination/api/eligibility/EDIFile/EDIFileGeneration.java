package com.edination.api.eligibility.EDIFile;

import com.edination.api.eligibility.model.Demographics;

public class EDIFileGeneration {
    public EDIFileGeneration(){}
    public String generateFile(Demographics demographics1)
    {
        Context c = new Context('~', '*', ':');
        X12Simple x12 = new X12Simple(c);

        //add ISA segment
        Segment s = x12.addSegment();
        s.addElement("ISA");
        s.addElement("00");
        s.addElement(" 1234567");
        s.addElement("00");
        s.addElement("11111");
        s.addElement("ZZ");
        s.addElement("ZZ");
        s.addElement("170508");
        s.addElement("1141");
       // s.addElement("U");
        s.addElement("00501");
        s.addElement("000000101");
        s.addElement("1");
        s.addElement("P");
        s.addElement(":");

        s = x12.addSegment();
        s.addElement("GS");
        s.addElement("HC");
        s.addElement("XXXXXXXX");
        s.addElement("XXXXXXX");
        s.addElement("1741");
        s.addElement("101");
        s.addElement("X");
        s.addElement("005010X279A1");

        s = x12.addSegment();
        s.addElement("ST");
        s.addElement("270");
        s.addElement("1234");
        s.addElement("005010X279A1");
        s = x12.addSegment();
        s.addElement("BHT");
        s.addElement("0022");
        s.addElement("13");
        s.addElement("10001234");
        s.addElement("20060501");
        s.addElement("1319");
        s = x12.addSegment();
        s.addElement("HL");
        s.addElement("1");
        s.addElement("20");
        s.addElement("1");
        s = x12.addSegment();
        s.addElement("NM1");
        s.addElement("PR");
        s.addElement("ABC COMPANY");
        s.addElement("PI");
        s.addElement("842610001");
        s = x12.addSegment();
        s.addElement("HL");
        s.addElement("2");
        s.addElement("1");
        s.addElement("21");
        s.addElement("1");
        s = x12.addSegment();
        s.addElement("NM1");
        s.addElement("1P");
        s.addElement("2");
        s.addElement("BONE AND JOINT CLINIC");
        s.addElement("SV");
        s.addElement("2000035");

        s = x12.addSegment();
        s.addElement("HL");
        s.addElement("3");
        s.addElement("2");
        s.addElement("22");
        s.addElement("0");

        s = x12.addSegment();
        s.addElement("TRN");
        s.addElement("1");
        s.addElement("93175-012547");
        s.addElement("9877281234");

        //NEED TO KEPT DYNAMIC VALUE START
        s = x12.addSegment();
        s.addElement("NM1");
        s.addElement("IL");
        s.addElement("1");
        s.addElement(demographics1.getFirstName());
        s.addElement(demographics1.getLastName());
        s.addElement("MI");
        s.addElement(demographics1.getInsuranceDetail().getPolicyNumber());
        //END

        s = x12.addSegment();
        s.addElement("DMG");
        s.addElement("D8");
        s.addElement(demographics1.getDob().toString());

        s = x12.addSegment();
        s.addElement("DTP");
        s.addElement("291");
        s.addElement("D8");
        s.addElement("20060501");

        s = x12.addSegment();
        s.addElement("EQ");
        s.addElement("30");

        s = x12.addSegment();
        s.addElement("SE");
        s.addElement("13");
        s.addElement("1234");

        s = x12.addSegment();
        s.addElement("GE");
        s.addElement("1");
        s.addElement("101");

        s = x12.addSegment();
        s.addElement("IEA");
        s.addElement("1");
        s.addElement("000000101");

        String x12String = x12.toString();
        System.out.print(x12String);

        return x12String;

    }


}
