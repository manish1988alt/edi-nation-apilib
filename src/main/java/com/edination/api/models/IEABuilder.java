/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class IEABuilder {
    //the instance to build
    private IEA iEA;

    /**
     * Default constructor to initialize the instance
     */
    public IEABuilder() {
        iEA = new IEA();
    }

    public IEABuilder numberOfIncludedGroups1(String numberOfIncludedGroups1) {
        iEA.setNumberOfIncludedGroups1(numberOfIncludedGroups1);
        return this;
    }

    public IEABuilder interchangeControlNumber2(String interchangeControlNumber2) {
        iEA.setInterchangeControlNumber2(interchangeControlNumber2);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public IEA build() {
        return iEA;
    }
}