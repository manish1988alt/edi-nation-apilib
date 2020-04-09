/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class ISABuilder {
    //the instance to build
    private ISA iSA;

    /**
     * Default constructor to initialize the instance
     */
    public ISABuilder() {
        iSA = new ISA();
    }

    public ISABuilder authorizationInformationQualifier1(String authorizationInformationQualifier1) {
        iSA.setAuthorizationInformationQualifier1(authorizationInformationQualifier1);
        return this;
    }

    public ISABuilder authorizationInformation2(String authorizationInformation2) {
        iSA.setAuthorizationInformation2(authorizationInformation2);
        return this;
    }

    public ISABuilder securityInformationQualifier3(String securityInformationQualifier3) {
        iSA.setSecurityInformationQualifier3(securityInformationQualifier3);
        return this;
    }

    public ISABuilder securityInformation4(String securityInformation4) {
        iSA.setSecurityInformation4(securityInformation4);
        return this;
    }

    public ISABuilder senderIDQualifier5(String senderIDQualifier5) {
        iSA.setSenderIDQualifier5(senderIDQualifier5);
        return this;
    }

    public ISABuilder interchangeSenderID6(String interchangeSenderID6) {
        iSA.setInterchangeSenderID6(interchangeSenderID6);
        return this;
    }

    public ISABuilder receiverIDQualifier7(String receiverIDQualifier7) {
        iSA.setReceiverIDQualifier7(receiverIDQualifier7);
        return this;
    }

    public ISABuilder interchangeReceiverID8(String interchangeReceiverID8) {
        iSA.setInterchangeReceiverID8(interchangeReceiverID8);
        return this;
    }

    public ISABuilder interchangeDate9(String interchangeDate9) {
        iSA.setInterchangeDate9(interchangeDate9);
        return this;
    }

    public ISABuilder interchangeTime10(String interchangeTime10) {
        iSA.setInterchangeTime10(interchangeTime10);
        return this;
    }

    public ISABuilder interchangeControlStandardsIdentifier11(String interchangeControlStandardsIdentifier11) {
        iSA.setInterchangeControlStandardsIdentifier11(interchangeControlStandardsIdentifier11);
        return this;
    }

    public ISABuilder interchangeControlVersionNumber12(String interchangeControlVersionNumber12) {
        iSA.setInterchangeControlVersionNumber12(interchangeControlVersionNumber12);
        return this;
    }

    public ISABuilder interchangeControlNumber13(String interchangeControlNumber13) {
        iSA.setInterchangeControlNumber13(interchangeControlNumber13);
        return this;
    }

    public ISABuilder acknowledgementRequested14(String acknowledgementRequested14) {
        iSA.setAcknowledgementRequested14(acknowledgementRequested14);
        return this;
    }

    public ISABuilder usageIndicator15(String usageIndicator15) {
        iSA.setUsageIndicator15(usageIndicator15);
        return this;
    }

    public ISABuilder componentElementSeparator16(String componentElementSeparator16) {
        iSA.setComponentElementSeparator16(componentElementSeparator16);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public ISA build() {
        return iSA;
    }
}