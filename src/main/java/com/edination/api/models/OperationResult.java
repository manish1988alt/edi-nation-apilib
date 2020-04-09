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
public class OperationResult 
        implements java.io.Serializable {
    private static final long serialVersionUID = 868749116738562838L;
    private Integer lastIndex;
    private List<OperationDetail> details;
    private String status;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("LastIndex")
    public Integer getLastIndex ( ) { 
        return this.lastIndex;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("LastIndex")
    public void setLastIndex (Integer value) { 
        this.lastIndex = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Details")
    public List<OperationDetail> getDetails ( ) { 
        return this.details;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Details")
    public void setDetails (List<OperationDetail> value) { 
        this.details = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Status")
    public String getStatus ( ) { 
        return this.status;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Status")
    public void setStatus (String value) { 
        this.status = value;
    }
 
}
