/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.models;

import java.util.*;

public class OperationDetailBuilder {
    //the instance to build
    private OperationDetail operationDetail;

    /**
     * Default constructor to initialize the instance
     */
    public OperationDetailBuilder() {
        operationDetail = new OperationDetail();
    }

    public OperationDetailBuilder index(Integer index) {
        operationDetail.setIndex(index);
        return this;
    }

    public OperationDetailBuilder transactionIndex(Integer transactionIndex) {
        operationDetail.setTransactionIndex(transactionIndex);
        return this;
    }

    public OperationDetailBuilder transactionRef(String transactionRef) {
        operationDetail.setTransactionRef(transactionRef);
        return this;
    }

    public OperationDetailBuilder segmentId(String segmentId) {
        operationDetail.setSegmentId(segmentId);
        return this;
    }

    public OperationDetailBuilder value(String value) {
        operationDetail.setValue(value);
        return this;
    }

    public OperationDetailBuilder message(String message) {
        operationDetail.setMessage(message);
        return this;
    }

    public OperationDetailBuilder status(String status) {
        operationDetail.setStatus(status);
        return this;
    }
    /**
     * Build the instance with the given values
     */
    public OperationDetail build() {
        return operationDetail;
    }
}