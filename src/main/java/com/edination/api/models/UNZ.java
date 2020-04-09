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
public class UNZ 
        implements java.io.Serializable {
    private static final long serialVersionUID = -8761992322445354398L;
    private String interchangeControlCount1;
    private String interchangeControlReference2;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeControlCount_1")
    public String getInterchangeControlCount1 ( ) { 
        return this.interchangeControlCount1;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeControlCount_1")
    public void setInterchangeControlCount1 (String value) { 
        this.interchangeControlCount1 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeControlReference_2")
    public String getInterchangeControlReference2 ( ) { 
        return this.interchangeControlReference2;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeControlReference_2")
    public void setInterchangeControlReference2 (String value) { 
        this.interchangeControlReference2 = value;
    }
 
}
