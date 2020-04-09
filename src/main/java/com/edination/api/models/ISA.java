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
public class ISA 
        implements java.io.Serializable {
    private static final long serialVersionUID = 5401351621167943311L;
    private String authorizationInformationQualifier1;
    private String authorizationInformation2;
    private String securityInformationQualifier3;
    private String securityInformation4;
    private String senderIDQualifier5;
    private String interchangeSenderID6;
    private String receiverIDQualifier7;
    private String interchangeReceiverID8;
    private String interchangeDate9;
    private String interchangeTime10;
    private String interchangeControlStandardsIdentifier11;
    private String interchangeControlVersionNumber12;
    private String interchangeControlNumber13;
    private String acknowledgementRequested14;
    private String usageIndicator15;
    private String componentElementSeparator16;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("AuthorizationInformationQualifier_1")
    public String getAuthorizationInformationQualifier1 ( ) { 
        return this.authorizationInformationQualifier1;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("AuthorizationInformationQualifier_1")
    public void setAuthorizationInformationQualifier1 (String value) { 
        this.authorizationInformationQualifier1 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("AuthorizationInformation_2")
    public String getAuthorizationInformation2 ( ) { 
        return this.authorizationInformation2;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("AuthorizationInformation_2")
    public void setAuthorizationInformation2 (String value) { 
        this.authorizationInformation2 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("SecurityInformationQualifier_3")
    public String getSecurityInformationQualifier3 ( ) { 
        return this.securityInformationQualifier3;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("SecurityInformationQualifier_3")
    public void setSecurityInformationQualifier3 (String value) { 
        this.securityInformationQualifier3 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("SecurityInformation_4")
    public String getSecurityInformation4 ( ) { 
        return this.securityInformation4;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("SecurityInformation_4")
    public void setSecurityInformation4 (String value) { 
        this.securityInformation4 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("SenderIDQualifier_5")
    public String getSenderIDQualifier5 ( ) { 
        return this.senderIDQualifier5;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("SenderIDQualifier_5")
    public void setSenderIDQualifier5 (String value) { 
        this.senderIDQualifier5 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeSenderID_6")
    public String getInterchangeSenderID6 ( ) { 
        return this.interchangeSenderID6;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeSenderID_6")
    public void setInterchangeSenderID6 (String value) { 
        this.interchangeSenderID6 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("ReceiverIDQualifier_7")
    public String getReceiverIDQualifier7 ( ) { 
        return this.receiverIDQualifier7;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("ReceiverIDQualifier_7")
    public void setReceiverIDQualifier7 (String value) { 
        this.receiverIDQualifier7 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeReceiverID_8")
    public String getInterchangeReceiverID8 ( ) { 
        return this.interchangeReceiverID8;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeReceiverID_8")
    public void setInterchangeReceiverID8 (String value) { 
        this.interchangeReceiverID8 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeDate_9")
    public String getInterchangeDate9 ( ) { 
        return this.interchangeDate9;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeDate_9")
    public void setInterchangeDate9 (String value) { 
        this.interchangeDate9 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeTime_10")
    public String getInterchangeTime10 ( ) { 
        return this.interchangeTime10;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeTime_10")
    public void setInterchangeTime10 (String value) { 
        this.interchangeTime10 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeControlStandardsIdentifier_11")
    public String getInterchangeControlStandardsIdentifier11 ( ) { 
        return this.interchangeControlStandardsIdentifier11;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeControlStandardsIdentifier_11")
    public void setInterchangeControlStandardsIdentifier11 (String value) { 
        this.interchangeControlStandardsIdentifier11 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeControlVersionNumber_12")
    public String getInterchangeControlVersionNumber12 ( ) { 
        return this.interchangeControlVersionNumber12;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeControlVersionNumber_12")
    public void setInterchangeControlVersionNumber12 (String value) { 
        this.interchangeControlVersionNumber12 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("InterchangeControlNumber_13")
    public String getInterchangeControlNumber13 ( ) { 
        return this.interchangeControlNumber13;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("InterchangeControlNumber_13")
    public void setInterchangeControlNumber13 (String value) { 
        this.interchangeControlNumber13 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("AcknowledgementRequested_14")
    public String getAcknowledgementRequested14 ( ) { 
        return this.acknowledgementRequested14;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("AcknowledgementRequested_14")
    public void setAcknowledgementRequested14 (String value) { 
        this.acknowledgementRequested14 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("UsageIndicator_15")
    public String getUsageIndicator15 ( ) { 
        return this.usageIndicator15;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("UsageIndicator_15")
    public void setUsageIndicator15 (String value) { 
        this.usageIndicator15 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("ComponentElementSeparator_16")
    public String getComponentElementSeparator16 ( ) { 
        return this.componentElementSeparator16;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("ComponentElementSeparator_16")
    public void setComponentElementSeparator16 (String value) { 
        this.componentElementSeparator16 = value;
    }
 
}
