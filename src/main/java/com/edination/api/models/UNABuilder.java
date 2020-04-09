/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class UNABuilder {
    //the instance to build
    private UNA uNA;

    /**
     * Default constructor to initialize the instance
     */
    public UNABuilder() {
        uNA = new UNA();
    }

    public UNABuilder componentDataElement(String componentDataElement) {
        uNA.setComponentDataElement(componentDataElement);
        return this;
    }

    public UNABuilder dataElement(String dataElement) {
        uNA.setDataElement(dataElement);
        return this;
    }

    public UNABuilder decimalNotation(String decimalNotation) {
        uNA.setDecimalNotation(decimalNotation);
        return this;
    }

    public UNABuilder releaseIndicator(String releaseIndicator) {
        uNA.setReleaseIndicator(releaseIndicator);
        return this;
    }

    public UNABuilder reserved(String reserved) {
        uNA.setReserved(reserved);
        return this;
    }

    public UNABuilder segment(String segment) {
        uNA.setSegment(segment);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public UNA build() {
        return uNA;
    }
}