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
public class X12Group 
        implements java.io.Serializable {
    private static final long serialVersionUID = 6403964378014869307L;
    private GS gS;
    private List<Object> transactions;
    private List<GE> gETrailers;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("GS")
    public GS getGS ( ) { 
        return this.gS;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("GS")
    public void setGS (GS value) { 
        this.gS = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Transactions")
    public List<Object> getTransactions ( ) { 
        return this.transactions;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Transactions")
    public void setTransactions (List<Object> value) { 
        this.transactions = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("GETrailers")
    public List<GE> getGETrailers ( ) { 
        return this.gETrailers;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("GETrailers")
    public void setGETrailers (List<GE> value) { 
        this.gETrailers = value;
    }
 
}
