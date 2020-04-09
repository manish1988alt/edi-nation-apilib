/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class EdiModelBuilder {
    //the instance to build
    private EdiModel ediModel;

    /**
     * Default constructor to initialize the instance
     */
    public EdiModelBuilder() {
        ediModel = new EdiModel();
    }

    public EdiModelBuilder name(String name) {
        ediModel.setName(name);
        return this;
    }

    public EdiModelBuilder dateCreated(String dateCreated) {
        ediModel.setDateCreated(dateCreated);
        return this;
    }

    public EdiModelBuilder links(List<Link> links) {
        ediModel.setLinks(links);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public EdiModel build() {
        return ediModel;
    }
}