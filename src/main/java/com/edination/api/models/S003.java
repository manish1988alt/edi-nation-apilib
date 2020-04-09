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
public class S003 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5696716242696107615L;
    private String interchangeRecipientIdentification1;
    private String identificationCodeQualifier2;
    private String interchangeRecipientInternalIdentification3;
    private String interchangeRecipientInternalSubIdentification4;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeRecipientIdentification_1")
    public String getInterchangeRecipientIdentification1 ( ) { 
        return this.interchangeRecipientIdentification1;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeRecipientIdentification_1")
    public void setInterchangeRecipientIdentification1 (String value) { 
        this.interchangeRecipientIdentification1 = value;
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
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeRecipientInternalIdentification_3")
    public String getInterchangeRecipientInternalIdentification3 ( ) { 
        return this.interchangeRecipientInternalIdentification3;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeRecipientInternalIdentification_3")
    public void setInterchangeRecipientInternalIdentification3 (String value) { 
        this.interchangeRecipientInternalIdentification3 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeRecipientInternalSubIdentification_4")
    public String getInterchangeRecipientInternalSubIdentification4 ( ) { 
        return this.interchangeRecipientInternalSubIdentification4;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeRecipientInternalSubIdentification_4")
    public void setInterchangeRecipientInternalSubIdentification4 (String value) { 
        this.interchangeRecipientInternalSubIdentification4 = value;
    }
 
}
