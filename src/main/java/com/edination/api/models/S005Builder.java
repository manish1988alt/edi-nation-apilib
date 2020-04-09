/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class S005Builder {
    //the instance to build
    private S005 s005;

    /**
     * Default constructor to initialize the instance
     */
    public S005Builder() {
        s005 = new S005();
    }

    public S005Builder recipientReferencePassword1(String recipientReferencePassword1) {
        s005.setRecipientReferencePassword1(recipientReferencePassword1);
        return this;
    }

    public S005Builder recipientReferencePasswordQualifier2(String recipientReferencePasswordQualifier2) {
        s005.setRecipientReferencePasswordQualifier2(recipientReferencePasswordQualifier2);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public S005 build() {
        return s005;
    }
}