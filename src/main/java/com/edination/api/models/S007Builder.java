/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class S007Builder {
    //the instance to build
    private S007 s007;

    /**
     * Default constructor to initialize the instance
     */
    public S007Builder() {
        s007 = new S007();
    }

    public S007Builder applicationRecipientIdentification1(String applicationRecipientIdentification1) {
        s007.setApplicationRecipientIdentification1(applicationRecipientIdentification1);
        return this;
    }

    public S007Builder identificationCodeQualifier2(String identificationCodeQualifier2) {
        s007.setIdentificationCodeQualifier2(identificationCodeQualifier2);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public S007 build() {
        return s007;
    }
}