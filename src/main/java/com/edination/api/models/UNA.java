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
public class UNA 
        implements java.io.Serializable {
    private static final long serialVersionUID = -2592863407848737801L;
    private String componentDataElement;
    private String dataElement;
    private String decimalNotation;
    private String releaseIndicator;
    private String reserved;
    private String segment;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("ComponentDataElement")
    public String getComponentDataElement ( ) { 
        return this.componentDataElement;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("ComponentDataElement")
    public void setComponentDataElement (String value) { 
        this.componentDataElement = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("DataElement")
    public String getDataElement ( ) { 
        return this.dataElement;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("DataElement")
    public void setDataElement (String value) { 
        this.dataElement = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("DecimalNotation")
    public String getDecimalNotation ( ) { 
        return this.decimalNotation;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("DecimalNotation")
    public void setDecimalNotation (String value) { 
        this.decimalNotation = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("ReleaseIndicator")
    public String getReleaseIndicator ( ) { 
        return this.releaseIndicator;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("ReleaseIndicator")
    public void setReleaseIndicator (String value) { 
        this.releaseIndicator = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Reserved")
    public String getReserved ( ) { 
        return this.reserved;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Reserved")
    public void setReserved (String value) { 
        this.reserved = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Segment")
    public String getSegment ( ) { 
        return this.segment;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Segment")
    public void setSegment (String value) { 
        this.segment = value;
    }
 
}
