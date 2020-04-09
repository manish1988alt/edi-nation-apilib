/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class S001Builder {
    //the instance to build
    private S001 s001;

    /**
     * Default constructor to initialize the instance
     */
    public S001Builder() {
        s001 = new S001();
    }

    public S001Builder syntaxIdentifier1(String syntaxIdentifier1) {
        s001.setSyntaxIdentifier1(syntaxIdentifier1);
        return this;
    }

    public S001Builder syntaxVersionNumber2(String syntaxVersionNumber2) {
        s001.setSyntaxVersionNumber2(syntaxVersionNumber2);
        return this;
    }

    public S001Builder serviceCodeListDirectoryVersionNumber3(String serviceCodeListDirectoryVersionNumber3) {
        s001.setServiceCodeListDirectoryVersionNumber3(serviceCodeListDirectoryVersionNumber3);
        return this;
    }

    public S001Builder characterEncoding4(String characterEncoding4) {
        s001.setCharacterEncoding4(characterEncoding4);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public S001 build() {
        return s001;
    }
}