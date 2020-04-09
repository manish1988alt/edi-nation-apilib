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
public class Link 
        implements java.io.Serializable {
    private static final long serialVersionUID = 6993547266073165454L;
    private String rel;
    private String href;
    private String action;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Rel")
    public String getRel ( ) { 
        return this.rel;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Rel")
    public void setRel (String value) { 
        this.rel = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Href")
    public String getHref ( ) { 
        return this.href;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Href")
    public void setHref (String value) { 
        this.href = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Action")
    public String getAction ( ) { 
        return this.action;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Action")
    public void setAction (String value) { 
        this.action = value;
    }
 
}
