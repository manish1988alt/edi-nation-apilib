/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class GEBuilder {
    //the instance to build
    private GE gE;

    /**
     * Default constructor to initialize the instance
     */
    public GEBuilder() {
        gE = new GE();
    }

    public GEBuilder numberOfIncludedSets1(String numberOfIncludedSets1) {
        gE.setNumberOfIncludedSets1(numberOfIncludedSets1);
        return this;
    }

    public GEBuilder groupControlNumber2(String groupControlNumber2) {
        gE.setGroupControlNumber2(groupControlNumber2);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public GE build() {
        return gE;
    }
}