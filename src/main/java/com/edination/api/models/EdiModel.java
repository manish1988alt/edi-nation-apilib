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
public class EdiModel 
        implements java.io.Serializable {
    private static final long serialVersionUID = -8588669883022528852L;
    private String name;
    private String dateCreated;
    private List<Link> links;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Name")
    public String getName ( ) { 
        return this.name;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Name")
    public void setName (String value) { 
        this.name = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("DateCreated")
    public String getDateCreated ( ) { 
        return this.dateCreated;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("DateCreated")
    public void setDateCreated (String value) { 
        this.dateCreated = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Links")
    public List<Link> getLinks ( ) { 
        return this.links;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Links")
    public void setLinks (List<Link> value) { 
        this.links = value;
    }
 
}
