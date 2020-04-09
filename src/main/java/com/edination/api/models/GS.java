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
public class GS 
        implements java.io.Serializable {
    private static final long serialVersionUID = 7398592844764239276L;
    private String codeIdentifyingInformationType1;
    private String senderIDCode2;
    private String receiverIDCode3;
    private String date4;
    private String time5;
    private String groupControlNumber6;
    private String transactionTypeCode7;
    private String versionAndRelease8;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("CodeIdentifyingInformationType_1")
    public String getCodeIdentifyingInformationType1 ( ) { 
        return this.codeIdentifyingInformationType1;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("CodeIdentifyingInformationType_1")
    public void setCodeIdentifyingInformationType1 (String value) { 
        this.codeIdentifyingInformationType1 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("SenderIDCode_2")
    public String getSenderIDCode2 ( ) { 
        return this.senderIDCode2;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("SenderIDCode_2")
    public void setSenderIDCode2 (String value) { 
        this.senderIDCode2 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("ReceiverIDCode_3")
    public String getReceiverIDCode3 ( ) { 
        return this.receiverIDCode3;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("ReceiverIDCode_3")
    public void setReceiverIDCode3 (String value) { 
        this.receiverIDCode3 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Date_4")
    public String getDate4 ( ) { 
        return this.date4;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Date_4")
    public void setDate4 (String value) { 
        this.date4 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("Time_5")
    public String getTime5 ( ) { 
        return this.time5;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("Time_5")
    public void setTime5 (String value) { 
        this.time5 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("GroupControlNumber_6")
    public String getGroupControlNumber6 ( ) { 
        return this.groupControlNumber6;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("GroupControlNumber_6")
    public void setGroupControlNumber6 (String value) { 
        this.groupControlNumber6 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("TransactionTypeCode_7")
    public String getTransactionTypeCode7 ( ) { 
        return this.transactionTypeCode7;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("TransactionTypeCode_7")
    public void setTransactionTypeCode7 (String value) { 
        this.transactionTypeCode7 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("VersionAndRelease_8")
    public String getVersionAndRelease8 ( ) { 
        return this.versionAndRelease8;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("VersionAndRelease_8")
    public void setVersionAndRelease8 (String value) { 
        this.versionAndRelease8 = value;
    }
 
}
