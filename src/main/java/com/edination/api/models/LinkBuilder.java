/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class LinkBuilder {
    //the instance to build
    private Link link;

    /**
     * Default constructor to initialize the instance
     */
    public LinkBuilder() {
        link = new Link();
    }

    public LinkBuilder rel(String rel) {
        link.setRel(rel);
        return this;
    }

    public LinkBuilder href(String href) {
        link.setHref(href);
        return this;
    }

    public LinkBuilder action(String action) {
        link.setAction(action);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public Link build() {
        return link;
    }
}