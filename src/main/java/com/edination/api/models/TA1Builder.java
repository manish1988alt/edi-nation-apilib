/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class TA1Builder {
    //the instance to build
    private TA1 tA1;

    /**
     * Default constructor to initialize the instance
     */
    public TA1Builder() {
        tA1 = new TA1();
    }

    public TA1Builder interchangeControlNumber1(String interchangeControlNumber1) {
        tA1.setInterchangeControlNumber1(interchangeControlNumber1);
        return this;
    }

    public TA1Builder interchangeDate2(String interchangeDate2) {
        tA1.setInterchangeDate2(interchangeDate2);
        return this;
    }

    public TA1Builder interchangeTime3(String interchangeTime3) {
        tA1.setInterchangeTime3(interchangeTime3);
        return this;
    }

    public TA1Builder interchangeAcknowledgmentCode4(String interchangeAcknowledgmentCode4) {
        tA1.setInterchangeAcknowledgmentCode4(interchangeAcknowledgmentCode4);
        return this;
    }

    public TA1Builder interchangeNoteCode5(String interchangeNoteCode5) {
        tA1.setInterchangeNoteCode5(interchangeNoteCode5);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public TA1 build() {
        return tA1;
    }
}