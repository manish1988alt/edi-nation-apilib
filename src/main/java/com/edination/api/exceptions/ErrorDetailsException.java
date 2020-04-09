/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.exceptions;

import java.util.*;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.edination.api.http.client.HttpContext;

public class ErrorDetailsException 
        extends APIException
        implements java.io.Serializable {
    private static final long serialVersionUID = -6939579240499546893L;
    private Integer code;
    private List<String> details;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Code")
    public Integer getCode ( ) { 
        return this.code;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Code")
    private void setCode (Integer value) { 
        this.code = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Details")
    public List<String> getDetails ( ) { 
        return this.details;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Details")
    private void setDetails (List<String> value) { 
        this.details = value;
    }
 
    /**
     * Initialization constructor
     * @param   reason  The reason for throwing exception
     * @param   context The http context of the API exception
     */
    public ErrorDetailsException(String reason, HttpContext context) {
        super(reason, context);
    }
}
