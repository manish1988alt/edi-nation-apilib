/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class GSBuilder {
    //the instance to build
    private GS gS;

    /**
     * Default constructor to initialize the instance
     */
    public GSBuilder() {
        gS = new GS();
    }

    public GSBuilder codeIdentifyingInformationType1(String codeIdentifyingInformationType1) {
        gS.setCodeIdentifyingInformationType1(codeIdentifyingInformationType1);
        return this;
    }

    public GSBuilder senderIDCode2(String senderIDCode2) {
        gS.setSenderIDCode2(senderIDCode2);
        return this;
    }

    public GSBuilder receiverIDCode3(String receiverIDCode3) {
        gS.setReceiverIDCode3(receiverIDCode3);
        return this;
    }

    public GSBuilder date4(String date4) {
        gS.setDate4(date4);
        return this;
    }

    public GSBuilder time5(String time5) {
        gS.setTime5(time5);
        return this;
    }

    public GSBuilder groupControlNumber6(String groupControlNumber6) {
        gS.setGroupControlNumber6(groupControlNumber6);
        return this;
    }

    public GSBuilder transactionTypeCode7(String transactionTypeCode7) {
        gS.setTransactionTypeCode7(transactionTypeCode7);
        return this;
    }

    public GSBuilder versionAndRelease8(String versionAndRelease8) {
        gS.setVersionAndRelease8(versionAndRelease8);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public GS build() {
        return gS;
    }
}