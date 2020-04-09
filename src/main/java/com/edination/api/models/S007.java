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
public class S007 
        implements java.io.Serializable {
    private static final long serialVersionUID = -3460814838663450269L;
    private String applicationRecipientIdentification1;
    private String identificationCodeQualifier2;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("ApplicationRecipientIdentification_1")
    public String getApplicationRecipientIdentification1 ( ) { 
        return this.applicationRecipientIdentification1;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("ApplicationRecipientIdentification_1")
    public void setApplicationRecipientIdentification1 (String value) { 
        this.applicationRecipientIdentification1 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("IdentificationCodeQualifier_2")
    public String getIdentificationCodeQualifier2 ( ) { 
        return this.identificationCodeQualifier2;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("IdentificationCodeQualifier_2")
    public void setIdentificationCodeQualifier2 (String value) { 
        this.identificationCodeQualifier2 = value;
    }
 
}
