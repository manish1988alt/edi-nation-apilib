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
public class GE 
        implements java.io.Serializable {
    private static final long serialVersionUID = -4729396281626739562L;
    private String numberOfIncludedSets1;
    private String groupControlNumber2;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("NumberOfIncludedSets_1")
    public String getNumberOfIncludedSets1 ( ) { 
        return this.numberOfIncludedSets1;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("NumberOfIncludedSets_1")
    public void setNumberOfIncludedSets1 (String value) { 
        this.numberOfIncludedSets1 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("GroupControlNumber_2")
    public String getGroupControlNumber2 ( ) { 
        return this.groupControlNumber2;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("GroupControlNumber_2")
    public void setGroupControlNumber2 (String value) { 
        this.groupControlNumber2 = value;
    }
 
}
