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
public class UNE 
        implements java.io.Serializable {
    private static final long serialVersionUID = -3859131239232600031L;
    private String groupControlCount1;
    private String groupReferenceNumber2;
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("GroupControlCount_1")
    public String getGroupControlCount1 ( ) { 
        return this.groupControlCount1;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("GroupControlCount_1")
    public void setGroupControlCount1 (String value) { 
        this.groupControlCount1 = value;
    }
 
    /** GETTER
     * TODO: Write general description for this method
     */
    @JsonGetter("GroupReferenceNumber_2")
    public String getGroupReferenceNumber2 ( ) { 
        return this.groupReferenceNumber2;
    }
    
    /** SETTER
     * TODO: Write general description for this method
     */
    @JsonSetter("GroupReferenceNumber_2")
    public void setGroupReferenceNumber2 (String value) { 
        this.groupReferenceNumber2 = value;
    }
 
}
