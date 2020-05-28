package com.edination.api.preAuthorisation.MasterCode;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ShipDeliveryPatternTimeCodeMaster")
public class ShipDeliveryPatternTimeCodeMaster {

    @Id
    private String code;
    private String discription;

    public ShipDeliveryPatternTimeCodeMaster() {
    }

    public ShipDeliveryPatternTimeCodeMaster(String code, String discription) {
        this.code = code;
        this.discription = discription;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    @Override
    public String toString() {
        return "ShipDeliveryPatternTimeCodeMaster{" +
                "code='" + code + '\'' +
                ", discription='" + discription + '\'' +
                '}';
    }
}
