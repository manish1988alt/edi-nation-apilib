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
public class IEA 
        implements java.io.Serializable {
    private static final long serialVersionUID = -5765832997017934722L;
    private String numberOfIncludedGroups1;
    private String interchangeControlNumber2;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("NumberOfIncludedGroups_1")
    public String getNumberOfIncludedGroups1 ( ) { 
        return this.numberOfIncludedGroups1;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("NumberOfIncludedGroups_1")
    public void setNumberOfIncludedGroups1 (String value) { 
        this.numberOfIncludedGroups1 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeControlNumber_2")
    public String getInterchangeControlNumber2 ( ) { 
        return this.interchangeControlNumber2;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeControlNumber_2")
    public void setInterchangeControlNumber2 (String value) { 
        this.interchangeControlNumber2 = value;
    }
 
}
