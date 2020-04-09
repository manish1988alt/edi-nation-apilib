/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class EdifactGroupBuilder {
    //the instance to build
    private EdifactGroup edifactGroup;

    /**
     * Default constructor to initialize the instance
     */
    public EdifactGroupBuilder() {
        edifactGroup = new EdifactGroup();
    }

    public EdifactGroupBuilder uNG(UNG uNG) {
        edifactGroup.setUNG(uNG);
        return this;
    }

    public EdifactGroupBuilder transactions(List<Object> transactions) {
        edifactGroup.setTransactions(transactions);
        return this;
    }

    public EdifactGroupBuilder uNETrailers(List<UNE> uNETrailers) {
        edifactGroup.setUNETrailers(uNETrailers);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public EdifactGroup build() {
        return edifactGroup;
    }
}