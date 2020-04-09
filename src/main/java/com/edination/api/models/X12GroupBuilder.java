/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class X12GroupBuilder {
    //the instance to build
    private X12Group x12Group;

    /**
     * Default constructor to initialize the instance
     */
    public X12GroupBuilder() {
        x12Group = new X12Group();
    }

    public X12GroupBuilder gS(GS gS) {
        x12Group.setGS(gS);
        return this;
    }

    public X12GroupBuilder transactions(List<Object> transactions) {
        x12Group.setTransactions(transactions);
        return this;
    }

    public X12GroupBuilder gETrailers(List<GE> gETrailers) {
        x12Group.setGETrailers(gETrailers);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public X12Group build() {
        return x12Group;
    }
}