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
public class S005 
        implements java.io.Serializable {
    private static final long serialVersionUID = 7779093790981908068L;
    private String recipientReferencePassword1;
    private String recipientReferencePasswordQualifier2;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("RecipientReferencePassword_1")
    public String getRecipientReferencePassword1 ( ) { 
        return this.recipientReferencePassword1;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("RecipientReferencePassword_1")
    public void setRecipientReferencePassword1 (String value) { 
        this.recipientReferencePassword1 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("RecipientReferencePasswordQualifier_2")
    public String getRecipientReferencePasswordQualifier2 ( ) { 
        return this.recipientReferencePasswordQualifier2;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("RecipientReferencePasswordQualifier_2")
    public void setRecipientReferencePasswordQualifier2 (String value) { 
        this.recipientReferencePasswordQualifier2 = value;
    }
 
}
