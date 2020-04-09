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
public class UNB 
        implements java.io.Serializable {
    private static final long serialVersionUID = -8216841260722916561L;
    private S001 sYNTAXIDENTIFIER1;
    private S002 iNTERCHANGESENDER2;
    private S003 iNTERCHANGERECIPIENT3;
    private S004 dATEANDTIMEOFPREPARATION4;
    private String interchangeControlReference5;
    private S005 rECIPIENTSREFERENCEPASSWORDDETAILS6;
    private String applicationReference7;
    private String processingPriorityCode8;
    private String acknowledgementRequest9;
    private String interchangeAgreementIdentifier10;
    private String testIndicator11;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("SYNTAXIDENTIFIER_1")
    public S001 getSYNTAXIDENTIFIER1 ( ) { 
        return this.sYNTAXIDENTIFIER1;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("SYNTAXIDENTIFIER_1")
    public void setSYNTAXIDENTIFIER1 (S001 value) { 
        this.sYNTAXIDENTIFIER1 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("INTERCHANGESENDER_2")
    public S002 getINTERCHANGESENDER2 ( ) { 
        return this.iNTERCHANGESENDER2;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("INTERCHANGESENDER_2")
    public void setINTERCHANGESENDER2 (S002 value) { 
        this.iNTERCHANGESENDER2 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("INTERCHANGERECIPIENT_3")
    public S003 getINTERCHANGERECIPIENT3 ( ) { 
        return this.iNTERCHANGERECIPIENT3;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("INTERCHANGERECIPIENT_3")
    public void setINTERCHANGERECIPIENT3 (S003 value) { 
        this.iNTERCHANGERECIPIENT3 = value;
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
    @JsonGetter("InterchangeControlReference_5")
    public String getInterchangeControlReference5 ( ) { 
        return this.interchangeControlReference5;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeControlReference_5")
    public void setInterchangeControlReference5 (String value) { 
        this.interchangeControlReference5 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("RECIPIENTSREFERENCEPASSWORDDETAILS_6")
    public S005 getRECIPIENTSREFERENCEPASSWORDDETAILS6 ( ) { 
        return this.rECIPIENTSREFERENCEPASSWORDDETAILS6;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("RECIPIENTSREFERENCEPASSWORDDETAILS_6")
    public void setRECIPIENTSREFERENCEPASSWORDDETAILS6 (S005 value) { 
        this.rECIPIENTSREFERENCEPASSWORDDETAILS6 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("ApplicationReference_7")
    public String getApplicationReference7 ( ) { 
        return this.applicationReference7;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("ApplicationReference_7")
    public void setApplicationReference7 (String value) { 
        this.applicationReference7 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("ProcessingPriorityCode_8")
    public String getProcessingPriorityCode8 ( ) { 
        return this.processingPriorityCode8;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("ProcessingPriorityCode_8")
    public void setProcessingPriorityCode8 (String value) { 
        this.processingPriorityCode8 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("AcknowledgementRequest_9")
    public String getAcknowledgementRequest9 ( ) { 
        return this.acknowledgementRequest9;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("AcknowledgementRequest_9")
    public void setAcknowledgementRequest9 (String value) { 
        this.acknowledgementRequest9 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeAgreementIdentifier_10")
    public String getInterchangeAgreementIdentifier10 ( ) { 
        return this.interchangeAgreementIdentifier10;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeAgreementIdentifier_10")
    public void setInterchangeAgreementIdentifier10 (String value) { 
        this.interchangeAgreementIdentifier10 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("TestIndicator_11")
    public String getTestIndicator11 ( ) { 
        return this.testIndicator11;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("TestIndicator_11")
    public void setTestIndicator11 (String value) { 
        this.testIndicator11 = value;
    }
 
}
