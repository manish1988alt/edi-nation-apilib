/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class S008Builder {
    //the instance to build
    private S008 s008;

    /**
     * Default constructor to initialize the instance
     */
    public S008Builder() {
        s008 = new S008();
    }

    public S008Builder messageVersionNumber1(String messageVersionNumber1) {
        s008.setMessageVersionNumber1(messageVersionNumber1);
        return this;
    }

    public S008Builder messageReleaseNumber2(String messageReleaseNumber2) {
        s008.setMessageReleaseNumber2(messageReleaseNumber2);
        return this;
    }

    public S008Builder associationAssignedCode3(String associationAssignedCode3) {
        s008.setAssociationAssignedCode3(associationAssignedCode3);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public S008 build() {
        return s008;
    }
}