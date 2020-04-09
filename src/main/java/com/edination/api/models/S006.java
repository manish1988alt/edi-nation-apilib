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
public class S006 
        implements java.io.Serializable {
    private static final long serialVersionUID = 6005401939350837190L;
    private String applicationSenderIdentification1;
    private String identificationCodeQualifier2;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("ApplicationSenderIdentification_1")
    public String getApplicationSenderIdentification1 ( ) { 
        return this.applicationSenderIdentification1;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("ApplicationSenderIdentification_1")
    public void setApplicationSenderIdentification1 (String value) { 
        this.applicationSenderIdentification1 = value;
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
