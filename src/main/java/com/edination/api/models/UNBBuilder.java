/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class UNBBuilder {
    //the instance to build
    private UNB uNB;

    /**
     * Default constructor to initialize the instance
     */
    public UNBBuilder() {
        uNB = new UNB();
    }

    public UNBBuilder sYNTAXIDENTIFIER1(S001 sYNTAXIDENTIFIER1) {
        uNB.setSYNTAXIDENTIFIER1(sYNTAXIDENTIFIER1);
        return this;
    }

    public UNBBuilder iNTERCHANGESENDER2(S002 iNTERCHANGESENDER2) {
        uNB.setINTERCHANGESENDER2(iNTERCHANGESENDER2);
        return this;
    }

    public UNBBuilder iNTERCHANGERECIPIENT3(S003 iNTERCHANGERECIPIENT3) {
        uNB.setINTERCHANGERECIPIENT3(iNTERCHANGERECIPIENT3);
        return this;
    }

    public UNBBuilder dATEANDTIMEOFPREPARATION4(S004 dATEANDTIMEOFPREPARATION4) {
        uNB.setDATEANDTIMEOFPREPARATION4(dATEANDTIMEOFPREPARATION4);
        return this;
    }

    public UNBBuilder interchangeControlReference5(String interchangeControlReference5) {
        uNB.setInterchangeControlReference5(interchangeControlReference5);
        return this;
    }

    public UNBBuilder rECIPIENTSREFERENCEPASSWORDDETAILS6(S005 rECIPIENTSREFERENCEPASSWORDDETAILS6) {
        uNB.setRECIPIENTSREFERENCEPASSWORDDETAILS6(rECIPIENTSREFERENCEPASSWORDDETAILS6);
        return this;
    }

    public UNBBuilder applicationReference7(String applicationReference7) {
        uNB.setApplicationReference7(applicationReference7);
        return this;
    }

    public UNBBuilder processingPriorityCode8(String processingPriorityCode8) {
        uNB.setProcessingPriorityCode8(processingPriorityCode8);
        return this;
    }

    public UNBBuilder acknowledgementRequest9(String acknowledgementRequest9) {
        uNB.setAcknowledgementRequest9(acknowledgementRequest9);
        return this;
    }

    public UNBBuilder interchangeAgreementIdentifier10(String interchangeAgreementIdentifier10) {
        uNB.setInterchangeAgreementIdentifier10(interchangeAgreementIdentifier10);
        return this;
    }

    public UNBBuilder testIndicator11(String testIndicator11) {
        uNB.setTestIndicator11(testIndicator11);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public UNB build() {
        return uNB;
    }
}