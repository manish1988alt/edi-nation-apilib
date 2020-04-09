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
public class OperationDetail 
        implements java.io.Serializable {
    private static final long serialVersionUID = -3769673688132774935L;
    private Integer index;
    private Integer transactionIndex;
    private String transactionRef;
    private String segmentId;
    private String value;
    private String message;
    private String status;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Index")
    public Integer getIndex ( ) { 
        return this.index;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Index")
    public void setIndex (Integer value) { 
        this.index = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("TransactionIndex")
    public Integer getTransactionIndex ( ) { 
        return this.transactionIndex;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("TransactionIndex")
    public void setTransactionIndex (Integer value) { 
        this.transactionIndex = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("TransactionRef")
    public String getTransactionRef ( ) { 
        return this.transactionRef;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("TransactionRef")
    public void setTransactionRef (String value) { 
        this.transactionRef = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("SegmentId")
    public String getSegmentId ( ) { 
        return this.segmentId;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("SegmentId")
    public void setSegmentId (String value) { 
        this.segmentId = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Value")
    public String getValue ( ) { 
        return this.value;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Value")
    public void setValue (String value) { 
        this.value = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Message")
    public String getMessage ( ) { 
        return this.message;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Message")
    public void setMessage (String value) { 
        this.message = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Status")
    public String getStatus ( ) { 
        return this.status;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Status")
    public void setStatus (String value) { 
        this.status = value;
    }
 
}
