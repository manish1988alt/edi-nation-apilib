/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class UNGBuilder {
    //the instance to build
    private UNG uNG;

    /**
     * Default constructor to initialize the instance
     */
    public UNGBuilder() {
        uNG = new UNG();
    }

    public UNGBuilder messageGroupIdentification1(String messageGroupIdentification1) {
        uNG.setMessageGroupIdentification1(messageGroupIdentification1);
        return this;
    }

    public UNGBuilder aPPLICATIONSENDERIDENTIFICATION2(S006 aPPLICATIONSENDERIDENTIFICATION2) {
        uNG.setAPPLICATIONSENDERIDENTIFICATION2(aPPLICATIONSENDERIDENTIFICATION2);
        return this;
    }

    public UNGBuilder aPPLICATIONRECIPIENTIDENTIFICATION3(S007 aPPLICATIONRECIPIENTIDENTIFICATION3) {
        uNG.setAPPLICATIONRECIPIENTIDENTIFICATION3(aPPLICATIONRECIPIENTIDENTIFICATION3);
        return this;
    }

    public UNGBuilder dATEANDTIMEOFPREPARATION4(S004 dATEANDTIMEOFPREPARATION4) {
        uNG.setDATEANDTIMEOFPREPARATION4(dATEANDTIMEOFPREPARATION4);
        return this;
    }

    public UNGBuilder groupReferenceNumber5(String groupReferenceNumber5) {
        uNG.setGroupReferenceNumber5(groupReferenceNumber5);
        return this;
    }

    public UNGBuilder controllingAgency6(String controllingAgency6) {
        uNG.setControllingAgency6(controllingAgency6);
        return this;
    }

    public UNGBuilder mESSAGEVERSION7(S008 mESSAGEVERSION7) {
        uNG.setMESSAGEVERSION7(mESSAGEVERSION7);
        return this;
    }

    public UNGBuilder applicationPassword8(String applicationPassword8) {
        uNG.setApplicationPassword8(applicationPassword8);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public UNG build() {
        return uNG;
    }
}