/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class X12InterchangeBuilder {
    //the instance to build
    private X12Interchange x12Interchange;

    /**
     * Default constructor to initialize the instance
     */
    public X12InterchangeBuilder() {
        x12Interchange = new X12Interchange();
    }

    public X12InterchangeBuilder segmentDelimiter(String segmentDelimiter) {
        x12Interchange.setSegmentDelimiter(segmentDelimiter);
        return this;
    }

    public X12InterchangeBuilder dataElementDelimiter(String dataElementDelimiter) {
        x12Interchange.setDataElementDelimiter(dataElementDelimiter);
        return this;
    }

    public X12InterchangeBuilder iSA(ISA iSA) {
        x12Interchange.setISA(iSA);
        return this;
    }

    public X12InterchangeBuilder tA1(TA1 tA1) {
        x12Interchange.setTA1(tA1);
        return this;
    }

    public X12InterchangeBuilder groups(List<X12Group> groups) {
        x12Interchange.setGroups(groups);
        return this;
    }

    public X12InterchangeBuilder iEATrailers(List<IEA> iEATrailers) {
        x12Interchange.setIEATrailers(iEATrailers);
        return this;
    }

    public X12InterchangeBuilder result(OperationResult result) {
        x12Interchange.setResult(result);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public X12Interchange build() {
        return x12Interchange;
    }
}