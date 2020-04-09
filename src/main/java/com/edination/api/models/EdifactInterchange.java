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
public class EdifactInterchange 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5552943089368224663L;
    private UNA uNA;
    private UNB uNB;
    private List<EdifactGroup> groups;
    private List<UNZ> uNZTrailers;
    private OperationResult result;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("UNA")
    public UNA getUNA ( ) { 
        return this.uNA;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("UNA")
    public void setUNA (UNA value) { 
        this.uNA = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("UNB")
    public UNB getUNB ( ) { 
        return this.uNB;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("UNB")
    public void setUNB (UNB value) { 
        this.uNB = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Groups")
    public List<EdifactGroup> getGroups ( ) { 
        return this.groups;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Groups")
    public void setGroups (List<EdifactGroup> value) { 
        this.groups = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("UNZTrailers")
    public List<UNZ> getUNZTrailers ( ) { 
        return this.uNZTrailers;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("UNZTrailers")
    public void setUNZTrailers (List<UNZ> value) { 
        this.uNZTrailers = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Result")
    public OperationResult getResult ( ) { 
        return this.result;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Result")
    public void setResult (OperationResult value) { 
        this.result = value;
    }
 
}
