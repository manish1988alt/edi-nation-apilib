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
public class X12Interchange 
        implements java.io.Serializable {
    private static final long serialVersionUID = 420034164856853054L;
    private String segmentDelimiter;
    private String dataElementDelimiter;
    private ISA iSA;
    private TA1 tA1;
    private List<X12Group> groups;
    private List<IEA> iEATrailers;
    private OperationResult result;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("SegmentDelimiter")
    public String getSegmentDelimiter ( ) { 
        return this.segmentDelimiter;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("SegmentDelimiter")
    public void setSegmentDelimiter (String value) { 
        this.segmentDelimiter = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("DataElementDelimiter")
    public String getDataElementDelimiter ( ) { 
        return this.dataElementDelimiter;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("DataElementDelimiter")
    public void setDataElementDelimiter (String value) { 
        this.dataElementDelimiter = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("ISA")
    public ISA getISA ( ) { 
        return this.iSA;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("ISA")
    public void setISA (ISA value) { 
        this.iSA = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("TA1")
    public TA1 getTA1 ( ) { 
        return this.tA1;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("TA1")
    public void setTA1 (TA1 value) { 
        this.tA1 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Groups")
    public List<X12Group> getGroups ( ) { 
        return this.groups;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Groups")
    public void setGroups (List<X12Group> value) { 
        this.groups = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("IEATrailers")
    public List<IEA> getIEATrailers ( ) { 
        return this.iEATrailers;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("IEATrailers")
    public void setIEATrailers (List<IEA> value) { 
        this.iEATrailers = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Result")
    public OperationResult getResult ( ) { 
        return this.result;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Result")
    public void setResult (OperationResult value) { 
        this.result = value;
    }
 
}
