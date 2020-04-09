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
public class S001 
        implements java.io.Serializable {
    private static final long serialVersionUID = 1060395201093799816L;
    private String syntaxIdentifier1;
    private String syntaxVersionNumber2;
    private String serviceCodeListDirectoryVersionNumber3;
    private String characterEncoding4;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("SyntaxIdentifier_1")
    public String getSyntaxIdentifier1 ( ) { 
        return this.syntaxIdentifier1;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("SyntaxIdentifier_1")
    public void setSyntaxIdentifier1 (String value) { 
        this.syntaxIdentifier1 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("SyntaxVersionNumber_2")
    public String getSyntaxVersionNumber2 ( ) { 
        return this.syntaxVersionNumber2;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("SyntaxVersionNumber_2")
    public void setSyntaxVersionNumber2 (String value) { 
        this.syntaxVersionNumber2 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("ServiceCodeListDirectoryVersionNumber_3")
    public String getServiceCodeListDirectoryVersionNumber3 ( ) { 
        return this.serviceCodeListDirectoryVersionNumber3;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("ServiceCodeListDirectoryVersionNumber_3")
    public void setServiceCodeListDirectoryVersionNumber3 (String value) { 
        this.serviceCodeListDirectoryVersionNumber3 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("CharacterEncoding_4")
    public String getCharacterEncoding4 ( ) { 
        return this.characterEncoding4;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("CharacterEncoding_4")
    public void setCharacterEncoding4 (String value) { 
        this.characterEncoding4 = value;
    }
 
}
