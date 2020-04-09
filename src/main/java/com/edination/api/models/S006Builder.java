/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class S006Builder {
    //the instance to build
    private S006 s006;

    /**
     * Default constructor to initialize the instance
     */
    public S006Builder() {
        s006 = new S006();
    }

    public S006Builder applicationSenderIdentification1(String applicationSenderIdentification1) {
        s006.setApplicationSenderIdentification1(applicationSenderIdentification1);
        return this;
    }

    public S006Builder identificationCodeQualifier2(String identificationCodeQualifier2) {
        s006.setIdentificationCodeQualifier2(identificationCodeQualifier2);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public S006 build() {
        return s006;
    }
}