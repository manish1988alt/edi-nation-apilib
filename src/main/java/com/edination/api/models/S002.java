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
public class S002 
        implements java.io.Serializable {
    private static final long serialVersionUID = -2298597068341547916L;
    private String interchangeSenderIdentification1;
    private String identificationCodeQualifier2;
    private String interchangeSenderInternalIdentification3;
    private String interchangeSenderInternalSubIdentification4;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeSenderIdentification_1")
    public String getInterchangeSenderIdentification1 ( ) { 
        return this.interchangeSenderIdentification1;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeSenderIdentification_1")
    public void setInterchangeSenderIdentification1 (String value) { 
        this.interchangeSenderIdentification1 = value;
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
    @JsonGetter("InterchangeSenderInternalIdentification_3")
    public String getInterchangeSenderInternalIdentification3 ( ) { 
        return this.interchangeSenderInternalIdentification3;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeSenderInternalIdentification_3")
    public void setInterchangeSenderInternalIdentification3 (String value) { 
        this.interchangeSenderInternalIdentification3 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeSenderInternalSubIdentification_4")
    public String getInterchangeSenderInternalSubIdentification4 ( ) { 
        return this.interchangeSenderInternalSubIdentification4;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeSenderInternalSubIdentification_4")
    public void setInterchangeSenderInternalSubIdentification4 (String value) { 
        this.interchangeSenderInternalSubIdentification4 = value;
    }
 
}
