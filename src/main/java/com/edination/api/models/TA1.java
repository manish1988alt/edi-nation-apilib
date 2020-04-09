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
public class TA1 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5544453187017656196L;
    private String interchangeControlNumber1;
    private String interchangeDate2;
    private String interchangeTime3;
    private String interchangeAcknowledgmentCode4;
    private String interchangeNoteCode5;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeControlNumber_1")
    public String getInterchangeControlNumber1 ( ) { 
        return this.interchangeControlNumber1;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeControlNumber_1")
    public void setInterchangeControlNumber1 (String value) { 
        this.interchangeControlNumber1 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeDate_2")
    public String getInterchangeDate2 ( ) { 
        return this.interchangeDate2;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeDate_2")
    public void setInterchangeDate2 (String value) { 
        this.interchangeDate2 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeTime_3")
    public String getInterchangeTime3 ( ) { 
        return this.interchangeTime3;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeTime_3")
    public void setInterchangeTime3 (String value) { 
        this.interchangeTime3 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeAcknowledgmentCode_4")
    public String getInterchangeAcknowledgmentCode4 ( ) { 
        return this.interchangeAcknowledgmentCode4;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeAcknowledgmentCode_4")
    public void setInterchangeAcknowledgmentCode4 (String value) { 
        this.interchangeAcknowledgmentCode4 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeNoteCode_5")
    public String getInterchangeNoteCode5 ( ) { 
        return this.interchangeNoteCode5;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeNoteCode_5")
    public void setInterchangeNoteCode5 (String value) { 
        this.interchangeNoteCode5 = value;
    }
 
}
