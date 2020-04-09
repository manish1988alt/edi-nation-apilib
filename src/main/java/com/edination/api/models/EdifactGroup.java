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
public class EdifactGroup 
        implements java.io.Serializable {
    private static final long serialVersionUID = 9187009861534085767L;
    private UNG uNG;
    private List<Object> transactions;
    private List<UNE> uNETrailers;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("UNG")
    public UNG getUNG ( ) { 
        return this.uNG;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("UNG")
    public void setUNG (UNG value) { 
        this.uNG = value;
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
    @JsonGetter("UNETrailers")
    public List<UNE> getUNETrailers ( ) { 
        return this.uNETrailers;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("UNETrailers")
    public void setUNETrailers (List<UNE> value) { 
        this.uNETrailers = value;
    }
 
}
