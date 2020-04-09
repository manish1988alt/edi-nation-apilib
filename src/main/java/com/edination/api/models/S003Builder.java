/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class S003Builder {
    //the instance to build
    private S003 s003;

    /**
     * Default constructor to initialize the instance
     */
    public S003Builder() {
        s003 = new S003();
    }

    public S003Builder interchangeRecipientIdentification1(String interchangeRecipientIdentification1) {
        s003.setInterchangeRecipientIdentification1(interchangeRecipientIdentification1);
        return this;
    }

    public S003Builder identificationCodeQualifier2(String identificationCodeQualifier2) {
        s003.setIdentificationCodeQualifier2(identificationCodeQualifier2);
        return this;
    }

    public S003Builder interchangeRecipientInternalIdentification3(String interchangeRecipientInternalIdentification3) {
        s003.setInterchangeRecipientInternalIdentification3(interchangeRecipientInternalIdentification3);
        return this;
    }

    public S003Builder interchangeRecipientInternalSubIdentification4(String interchangeRecipientInternalSubIdentification4) {
        s003.setInterchangeRecipientInternalSubIdentification4(interchangeRecipientInternalSubIdentification4);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public S003 build() {
        return s003;
    }
}