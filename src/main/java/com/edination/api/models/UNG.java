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
public class UNG 
        implements java.io.Serializable {
    private static final long serialVersionUID = 2259532761016514560L;
    private String messageGroupIdentification1;
    private S006 aPPLICATIONSENDERIDENTIFICATION2;
    private S007 aPPLICATIONRECIPIENTIDENTIFICATION3;
    private S004 dATEANDTIMEOFPREPARATION4;
    private String groupReferenceNumber5;
    private String controllingAgency6;
    private S008 mESSAGEVERSION7;
    private String applicationPassword8;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("MessageGroupIdentification_1")
    public String getMessageGroupIdentification1 ( ) { 
        return this.messageGroupIdentification1;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("MessageGroupIdentification_1")
    public void setMessageGroupIdentification1 (String value) { 
        this.messageGroupIdentification1 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("APPLICATIONSENDERIDENTIFICATION_2")
    public S006 getAPPLICATIONSENDERIDENTIFICATION2 ( ) { 
        return this.aPPLICATIONSENDERIDENTIFICATION2;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("APPLICATIONSENDERIDENTIFICATION_2")
    public void setAPPLICATIONSENDERIDENTIFICATION2 (S006 value) { 
        this.aPPLICATIONSENDERIDENTIFICATION2 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("APPLICATIONRECIPIENTIDENTIFICATION_3")
    public S007 getAPPLICATIONRECIPIENTIDENTIFICATION3 ( ) { 
        return this.aPPLICATIONRECIPIENTIDENTIFICATION3;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("APPLICATIONRECIPIENTIDENTIFICATION_3")
    public void setAPPLICATIONRECIPIENTIDENTIFICATION3 (S007 value) { 
        this.aPPLICATIONRECIPIENTIDENTIFICATION3 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("DATEANDTIMEOFPREPARATION_4")
    public S004 getDATEANDTIMEOFPREPARATION4 ( ) { 
        return this.dATEANDTIMEOFPREPARATION4;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("DATEANDTIMEOFPREPARATION_4")
    public void setDATEANDTIMEOFPREPARATION4 (S004 value) { 
        this.dATEANDTIMEOFPREPARATION4 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("GroupReferenceNumber_5")
    public String getGroupReferenceNumber5 ( ) { 
        return this.groupReferenceNumber5;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("GroupReferenceNumber_5")
    public void setGroupReferenceNumber5 (String value) { 
        this.groupReferenceNumber5 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("ControllingAgency_6")
    public String getControllingAgency6 ( ) { 
        return this.controllingAgency6;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("ControllingAgency_6")
    public void setControllingAgency6 (String value) { 
        this.controllingAgency6 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("MESSAGEVERSION_7")
    public S008 getMESSAGEVERSION7 ( ) { 
        return this.mESSAGEVERSION7;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("MESSAGEVERSION_7")
    public void setMESSAGEVERSION7 (S008 value) { 
        this.mESSAGEVERSION7 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("ApplicationPassword_8")
    public String getApplicationPassword8 ( ) { 
        return this.applicationPassword8;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("ApplicationPassword_8")
    public void setApplicationPassword8 (String value) { 
        this.applicationPassword8 = value;
    }
 
}
