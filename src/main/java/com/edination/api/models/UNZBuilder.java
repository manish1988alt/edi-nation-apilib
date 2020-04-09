/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class UNZBuilder {
    //the instance to build
    private UNZ uNZ;

    /**
     * Default constructor to initialize the instance
     */
    public UNZBuilder() {
        uNZ = new UNZ();
    }

    public UNZBuilder interchangeControlCount1(String interchangeControlCount1) {
        uNZ.setInterchangeControlCount1(interchangeControlCount1);
        return this;
    }

    public UNZBuilder interchangeControlReference2(String interchangeControlReference2) {
        uNZ.setInterchangeControlReference2(interchangeControlReference2);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public UNZ build() {
        return uNZ;
    }
}