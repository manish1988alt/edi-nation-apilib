/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class S004 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5033802018926111602L;
    private String date1;
    private String time2;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Date_1")
    public String getDate1 ( ) { 
        return this.date1;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Date_1")
    public void setDate1 (String value) { 
        this.date1 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Time_2")
    public String getTime2 ( ) { 
        return this.time2;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Time_2")
    public void setTime2 (String value) { 
        this.time2 = value;
    }
 
}
