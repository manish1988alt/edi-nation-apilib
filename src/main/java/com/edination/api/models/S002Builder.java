/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class S002Builder {
    //the instance to build
    private S002 s002;

    /**
     * Default constructor to initialize the instance
     */
    public S002Builder() {
        s002 = new S002();
    }

    public S002Builder interchangeSenderIdentification1(String interchangeSenderIdentification1) {
        s002.setInterchangeSenderIdentification1(interchangeSenderIdentification1);
        return this;
    }

    public S002Builder identificationCodeQualifier2(String identificationCodeQualifier2) {
        s002.setIdentificationCodeQualifier2(identificationCodeQualifier2);
        return this;
    }

    public S002Builder interchangeSenderInternalIdentification3(String interchangeSenderInternalIdentification3) {
        s002.setInterchangeSenderInternalIdentification3(interchangeSenderInternalIdentification3);
        return this;
    }

    public S002Builder interchangeSenderInternalSubIdentification4(String interchangeSenderInternalSubIdentification4) {
        s002.setInterchangeSenderInternalSubIdentification4(interchangeSenderInternalSubIdentification4);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public S002 build() {
        return s002;
    }
}