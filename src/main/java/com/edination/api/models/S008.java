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
public class S008 
        implements java.io.Serializable {
    private static final long serialVersionUID = 1079413768856333209L;
    private String messageVersionNumber1;
    private String messageReleaseNumber2;
    private String associationAssignedCode3;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("MessageVersionNumber_1")
    public String getMessageVersionNumber1 ( ) { 
        return this.messageVersionNumber1;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("MessageVersionNumber_1")
    public void setMessageVersionNumber1 (String value) { 
        this.messageVersionNumber1 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("MessageReleaseNumber_2")
    public String getMessageReleaseNumber2 ( ) { 
        return this.messageReleaseNumber2;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("MessageReleaseNumber_2")
    public void setMessageReleaseNumber2 (String value) { 
        this.messageReleaseNumber2 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("AssociationAssignedCode_3")
    public String getAssociationAssignedCode3 ( ) { 
        return this.associationAssignedCode3;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("AssociationAssignedCode_3")
    public void setAssociationAssignedCode3 (String value) { 
        this.associationAssignedCode3 = value;
    }
 
}
