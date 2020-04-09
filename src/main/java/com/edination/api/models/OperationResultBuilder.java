/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class OperationResultBuilder {
    //the instance to build
    private OperationResult operationResult;

    /**
     * Default constructor to initialize the instance
     */
    public OperationResultBuilder() {
        operationResult = new OperationResult();
    }

    public OperationResultBuilder lastIndex(Integer lastIndex) {
        operationResult.setLastIndex(lastIndex);
        return this;
    }

    public OperationResultBuilder details(List<OperationDetail> details) {
        operationResult.setDetails(details);
        return this;
    }

    public OperationResultBuilder status(String status) {
        operationResult.setStatus(status);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public OperationResult build() {
        return operationResult;
    }
}