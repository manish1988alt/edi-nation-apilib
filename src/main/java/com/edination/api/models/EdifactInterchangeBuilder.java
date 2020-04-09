/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class EdifactInterchangeBuilder {
    //the instance to build
    private EdifactInterchange edifactInterchange;

    /**
     * Default constructor to initialize the instance
     */
    public EdifactInterchangeBuilder() {
        edifactInterchange = new EdifactInterchange();
    }

    public EdifactInterchangeBuilder uNA(UNA uNA) {
        edifactInterchange.setUNA(uNA);
        return this;
    }

    public EdifactInterchangeBuilder uNB(UNB uNB) {
        edifactInterchange.setUNB(uNB);
        return this;
    }

    public EdifactInterchangeBuilder groups(List<EdifactGroup> groups) {
        edifactInterchange.setGroups(groups);
        return this;
    }

    public EdifactInterchangeBuilder uNZTrailers(List<UNZ> uNZTrailers) {
        edifactInterchange.setUNZTrailers(uNZTrailers);
        return this;
    }

    public EdifactInterchangeBuilder result(OperationResult result) {
        edifactInterchange.setResult(result);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public EdifactInterchange build() {
        return edifactInterchange;
    }
}