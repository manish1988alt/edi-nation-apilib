/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class S004Builder {
    //the instance to build
    private S004 s004;

    /**
     * Default constructor to initialize the instance
     */
    public S004Builder() {
        s004 = new S004();
    }

    public S004Builder date1(String date1) {
        s004.setDate1(date1);
        return this;
    }

    public S004Builder time2(String time2) {
        s004.setTime2(time2);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public S004 build() {
        return s004;
    }
}