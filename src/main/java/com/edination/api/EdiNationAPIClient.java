/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api;

import com.edination.api.controllers.*;
import com.edination.api.http.client.HttpClient;

public class EdiNationAPIClient {
    /**
     * Singleton access to Edifact controller
     * @return	Returns the EdifactController instance 
     */
    public EdifactController getEdifact() {
        return EdifactController.getInstance();
    }

    /**
     * Singleton access to EdiModel controller
     * @return	Returns the EdiModelController instance 
     */
    public EdiModelController getEdiModel() {
        return EdiModelController.getInstance();
    }

    /**
     * Singleton access to X12 controller
     * @return	Returns the X12Controller instance 
     */
    public X12Controller getX12() {
        return X12Controller.getInstance();
    }

    /**
     * Get the shared http client currently being used for API calls
     * @return The http client instance currently being used
     */
    public HttpClient getSharedHttpClient() {
        return BaseController.getClientInstance();
    }
    
    /**
     * Set a shared http client to be used for API calls
     * @param httpClient The http client to use
     */
    public void setSharedHttpClient(HttpClient httpClient) {
        BaseController.setClientInstance(httpClient);
    }

    /**
     * Default constructor 
     */     
    public EdiNationAPIClient() {
    }

    /**
     * Client initialization constructor 
     */     
    public EdiNationAPIClient(String ocpApimSubscriptionKey) {
        this();
        Configuration.ocpApimSubscriptionKey = ocpApimSubscriptionKey;
    }
}