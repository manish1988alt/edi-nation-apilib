/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class UNEBuilder {
    //the instance to build
    private UNE uNE;

    /**
     * Default constructor to initialize the instance
     */
    public UNEBuilder() {
        uNE = new UNE();
    }

    public UNEBuilder groupControlCount1(String groupControlCount1) {
        uNE.setGroupControlCount1(groupControlCount1);
        return this;
    }

    public UNEBuilder groupReferenceNumber2(String groupReferenceNumber2) {
        uNE.setGroupReferenceNumber2(groupReferenceNumber2);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public UNE build() {
        return uNE;
    }
}