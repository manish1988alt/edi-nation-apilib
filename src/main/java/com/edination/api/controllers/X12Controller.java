/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.controllers;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;

import com.edination.api.*;
import com.edination.api.models.*;
import com.edination.api.exceptions.*;
import com.edination.api.http.client.HttpClient;
import com.edination.api.http.client.HttpContext;
import com.edination.api.http.request.HttpRequest;
import com.edination.api.http.response.HttpResponse;
import com.edination.api.http.response.HttpStringResponse;
import com.edination.api.http.client.APICallBack;
import com.edination.api.controllers.syncwrapper.APICallBackCatcher;

public class X12Controller extends BaseController {
    //private static variables for the singleton pattern
    private static final Object syncObject = new Object();
    private static X12Controller instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the X12Controller class 
     */
    public static X12Controller getInstance() {
        if (null == instance) {
            synchronized (syncObject) {
                if (null == instance) {
                    instance = new X12Controller();
                }
            }
        }
        return instance;
    }

    /**
     * Reads an X12 file and returns its contents translated to an array of X12Interchange objects.
     * @param    fileName    Required parameter: Upload File
     * @param    ignoreNullValues    Optional parameter: Whether to ignore all null values in the response. The default is false.
     * @param    continueOnError    Optional parameter: Whether to continue reading if a corrupt interchange is encountered. The default is false.
     * @param    charSet    Optional parameter: The encoding of the file contents. The default is utf-8. The available values are: unicodeFFFE, utf-32, utf-32BE, us-ascii, iso-8859-1, utf-7, utf-8, utf-16.
     * @param    model    Optional parameter: The model to use. By default, the API will infer the model based on the transaction and version identifiers.
     * @return    Returns the List<X12Interchange> response from the API call 
     */
    public List<X12Interchange> read(
                final File fileName,
                final Boolean ignoreNullValues,
                final Boolean continueOnError,
                final String charSet,
                final String model
    ) throws Throwable {

        HttpRequest _request = _buildReadRequest(fileName, ignoreNullValues, continueOnError, charSet, model);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleReadResponse(_context);
    }

    /**
     * Reads an X12 file and returns its contents translated to an array of X12Interchange objects.
     * @param    fileName    Required parameter: Upload File
     * @param    ignoreNullValues    Optional parameter: Whether to ignore all null values in the response. The default is false.
     * @param    continueOnError    Optional parameter: Whether to continue reading if a corrupt interchange is encountered. The default is false.
     * @param    charSet    Optional parameter: The encoding of the file contents. The default is utf-8. The available values are: unicodeFFFE, utf-32, utf-32BE, us-ascii, iso-8859-1, utf-7, utf-8, utf-16.
     * @param    model    Optional parameter: The model to use. By default, the API will infer the model based on the transaction and version identifiers.
     */
    public void readAsync(
                final File fileName,
                final Boolean ignoreNullValues,
                final Boolean continueOnError,
                final String charSet,
                final String model,
                final APICallBack<List<X12Interchange>> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildReadRequest(fileName, ignoreNullValues, continueOnError, charSet, model);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            List<X12Interchange> returnValue = _handleReadResponse(_context);
                            callBack.onSuccess(_context, returnValue);
                        } catch (Exception e) {
                            callBack.onFailure(_context, e);
                        }
                    }

                    public void onFailure(HttpContext _context, Throwable _exception) {
                        // Let the caller know of the failure
                        callBack.onFailure(_context, _exception);
                    }
                });
            }
        };

        // Execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * Builds the HttpRequest object for read
     */
    private HttpRequest _buildReadRequest(
                final File fileName,
                final Boolean ignoreNullValues,
                final Boolean continueOnError,
                final String charSet,
                final String model) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/x12/read");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        if (ignoreNullValues != null) {
            _queryParameters.put("ignoreNullValues", (ignoreNullValues != null) ? ignoreNullValues : false);
        }
        if (continueOnError != null) {
            _queryParameters.put("continueOnError", (continueOnError != null) ? continueOnError : false);
        }
        if (charSet != null) {
            _queryParameters.put("charSet", (charSet != null) ? charSet : "utf-8");
        }
        if (model != null) {
            _queryParameters.put("model", model);
        }
        APIHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("Ocp-Apim-Subscription-Key", Configuration.ocpApimSubscriptionKey);
        _headers.put("user-agent", BaseController.userAgent);
        _headers.put("accept", "application/json");


        //load all fields for the outgoing API request
        Map<String, Object> _parameters = new HashMap<String, Object>();
        _parameters.put("fileName", fileName);

        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().post(_queryUrl, _headers, APIHelper.prepareFormFields(_parameters));

        // Invoke the callback before request if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for read
     * @return An object of type List<X12Interchange>
     */
    private List<X12Interchange> _handleReadResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new ErrorDetailsException("Bad Request", _context);
        }
        if (_responseCode == 500) {
            throw new ErrorDetailsException("Server Error", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        List<X12Interchange> _result = APIHelper.deserialize(_responseBody,
									new TypeReference<List<X12Interchange>>(){});

        return _result;
    }

    /**
     * Translates an X12Interchange object to a raw X12 interchange and returns it as a stream.
     * @param    preserveWhitespace    Optional parameter: Whether to preserve blank data elements so the output contains multiple delimiters instead of omitting any excess delimiters. The default is false.
     * @param    charSet    Optional parameter: The encoding of the file contents. The default is utf-8. The available values are: unicodeFFFE, utf-32, utf-32BE, us-ascii, iso-8859-1, utf-7, utf-8, utf-16.
     * @param    postfix    Optional parameter: The postfix to be applied at the end of each segment, just after the segment separator. This is usually a carriage return (CR), line feed (LF) or both. By default, there is no postfix.
     * @param    contentType    Optional parameter: Example: application/json
     * @param    body    Optional parameter: The X12Interchange object to translate to raw X12.
     * @return    Returns the InputStream response from the API call 
     */
    public InputStream write(
                final Boolean preserveWhitespace,
                final String charSet,
                final String postfix,
                final String contentType,
                final X12Interchange body
    ) throws Throwable {

        HttpRequest _request = _buildWriteRequest(preserveWhitespace, charSet, postfix, contentType, body);
        HttpResponse _response = getClientInstance().executeAsBinary(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleWriteResponse(_context);
    }

    /**
     * Translates an X12Interchange object to a raw X12 interchange and returns it as a stream.
     * @param    preserveWhitespace    Optional parameter: Whether to preserve blank data elements so the output contains multiple delimiters instead of omitting any excess delimiters. The default is false.
     * @param    charSet    Optional parameter: The encoding of the file contents. The default is utf-8. The available values are: unicodeFFFE, utf-32, utf-32BE, us-ascii, iso-8859-1, utf-7, utf-8, utf-16.
     * @param    postfix    Optional parameter: The postfix to be applied at the end of each segment, just after the segment separator. This is usually a carriage return (CR), line feed (LF) or both. By default, there is no postfix.
     * @param    contentType    Optional parameter: Example: application/json
     * @param    body    Optional parameter: The X12Interchange object to translate to raw X12.
     */
    public void writeAsync(
                final Boolean preserveWhitespace,
                final String charSet,
                final String postfix,
                final String contentType,
                final X12Interchange body,
                final APICallBack<InputStream> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildWriteRequest(preserveWhitespace, charSet, postfix, contentType, body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsBinaryAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            InputStream returnValue = _handleWriteResponse(_context);
                            callBack.onSuccess(_context, returnValue);
                        } catch (Exception e) {
                            callBack.onFailure(_context, e);
                        }
                    }

                    public void onFailure(HttpContext _context, Throwable _exception) {
                        // Let the caller know of the failure
                        callBack.onFailure(_context, _exception);
                    }
                });
            }
        };

        // Execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * Builds the HttpRequest object for write
     */
    private HttpRequest _buildWriteRequest(
                final Boolean preserveWhitespace,
                final String charSet,
                final String postfix,
                final String contentType,
                final X12Interchange body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/x12/write");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        if (preserveWhitespace != null) {
            _queryParameters.put("preserveWhitespace", (preserveWhitespace != null) ? preserveWhitespace : false);
        }
        if (charSet != null) {
            _queryParameters.put("charSet", (charSet != null) ? charSet : "utf-8");
        }
        if (postfix != null) {
            _queryParameters.put("postfix", postfix);
        }
        APIHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        if (contentType != null) {
            _headers.put("Content-Type", contentType != null ? contentType : "application/json");
        }
        _headers.put("Ocp-Apim-Subscription-Key", Configuration.ocpApimSubscriptionKey);
        _headers.put("user-agent", BaseController.userAgent);


        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(body));

        // Invoke the callback before request if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for write
     * @return An object of type InputStream
     */
    private InputStream _handleWriteResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new ErrorDetailsException("Bad Request", _context);
        }
        if (_responseCode == 500) {
            throw new ErrorDetailsException("Server Error", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        InputStream _result = _response.getRawBody();
        return _result;
    }

    /**
     * Validates an X12Interchange object according to the X12 standard rules for each version and transaction.
     * @param    basicSyntax    Optional parameter: All data elements with alpha (A) or alphanumeric (AN) data types are validated against a syntax set of allowed characters. The default syntax set is the Extended, hence the default for this parameter is false. By setting this to true, validation will use the Basic syntax set.
     * @param    syntaxSet    Optional parameter: In case you need to validate against a syntax set, different than Basic and Extended, populate this filed with all of the allowed symbols, url-escaped.
     * @param    skipTrailer    Optional parameter: You are allowed to validate an X12Interchange with missing interchange, functional group or transaction trailers (IEA, GE, SE). This is because these will be automatically applied during the Write oprtaion so you don't have to worry about counting the items. By default it is expected that all trailers are present when you validate the X12Interchange and by default, this is set to false. To skip all trailer validation, set this to true.
     * @param    structureOnly    Optional parameter: This is equivalent to HIPAA Snip level 1, where only the structure and control segments are validated. By default, this is set to false, however if you want to not validate things such as data types, number of repeteitions or dates, set this to true.
     * @param    contentType    Optional parameter: Example: application/json
     * @param    body    Optional parameter: The X12Interchange object to validate.
     * @return    Returns the OperationResult response from the API call 
     */
    public OperationResult validate(
                final Boolean basicSyntax,
                final String syntaxSet,
                final Boolean skipTrailer,
                final Boolean structureOnly,
                final String contentType,
                final X12Interchange body
    ) throws Throwable {

        HttpRequest _request = _buildValidateRequest(basicSyntax, syntaxSet, skipTrailer, structureOnly, contentType, body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleValidateResponse(_context);
    }

    /**
     * Validates an X12Interchange object according to the X12 standard rules for each version and transaction.
     * @param    basicSyntax    Optional parameter: All data elements with alpha (A) or alphanumeric (AN) data types are validated against a syntax set of allowed characters. The default syntax set is the Extended, hence the default for this parameter is false. By setting this to true, validation will use the Basic syntax set.
     * @param    syntaxSet    Optional parameter: In case you need to validate against a syntax set, different than Basic and Extended, populate this filed with all of the allowed symbols, url-escaped.
     * @param    skipTrailer    Optional parameter: You are allowed to validate an X12Interchange with missing interchange, functional group or transaction trailers (IEA, GE, SE). This is because these will be automatically applied during the Write oprtaion so you don't have to worry about counting the items. By default it is expected that all trailers are present when you validate the X12Interchange and by default, this is set to false. To skip all trailer validation, set this to true.
     * @param    structureOnly    Optional parameter: This is equivalent to HIPAA Snip level 1, where only the structure and control segments are validated. By default, this is set to false, however if you want to not validate things such as data types, number of repeteitions or dates, set this to true.
     * @param    contentType    Optional parameter: Example: application/json
     * @param    body    Optional parameter: The X12Interchange object to validate.
     */
    public void validateAsync(
                final Boolean basicSyntax,
                final String syntaxSet,
                final Boolean skipTrailer,
                final Boolean structureOnly,
                final String contentType,
                final X12Interchange body,
                final APICallBack<OperationResult> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildValidateRequest(basicSyntax, syntaxSet, skipTrailer, structureOnly, contentType, body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            OperationResult returnValue = _handleValidateResponse(_context);
                            callBack.onSuccess(_context, returnValue);
                        } catch (Exception e) {
                            callBack.onFailure(_context, e);
                        }
                    }

                    public void onFailure(HttpContext _context, Throwable _exception) {
                        // Let the caller know of the failure
                        callBack.onFailure(_context, _exception);
                    }
                });
            }
        };

        // Execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * Builds the HttpRequest object for validate
     */
    private HttpRequest _buildValidateRequest(
                final Boolean basicSyntax,
                final String syntaxSet,
                final Boolean skipTrailer,
                final Boolean structureOnly,
                final String contentType,
                final X12Interchange body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/x12/validate");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        if (basicSyntax != null) {
            _queryParameters.put("basicSyntax", (basicSyntax != null) ? basicSyntax : false);
        }
        if (syntaxSet != null) {
            _queryParameters.put("syntaxSet", syntaxSet);
        }
        if (skipTrailer != null) {
            _queryParameters.put("skipTrailer", (skipTrailer != null) ? skipTrailer : false);
        }
        if (structureOnly != null) {
            _queryParameters.put("structureOnly", (structureOnly != null) ? structureOnly : false);
        }
        APIHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        if (contentType != null) {
            _headers.put("Content-Type", contentType != null ? contentType : "application/json");
        }
        _headers.put("Ocp-Apim-Subscription-Key", Configuration.ocpApimSubscriptionKey);
        _headers.put("user-agent", BaseController.userAgent);
        _headers.put("accept", "application/json");


        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(body));

        // Invoke the callback before request if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for validate
     * @return An object of type OperationResult
     */
    private OperationResult _handleValidateResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new ErrorDetailsException("Bad Request", _context);
        }
        if (_responseCode == 500) {
            throw new ErrorDetailsException("Server Error", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        OperationResult _result = APIHelper.deserialize(_responseBody,
                                                        new TypeReference<OperationResult>(){});

        return _result;
    }

    /**
     * Generates functional/implementation and/or technical acknowledment(s) for the requested X12Interchange.
     * @param    basicSyntax    Optional parameter: All data elements with alpha (A) or alphanumeric (AN) data types are validated against a syntax set of allowed characters. The default syntax set is the Extended, hence the default for this parameter is false. By setting this to true, validation will use the Basic syntax set.
     * @param    syntaxSet    Optional parameter: In case you need to validate against a syntax set, different than Basic and Extended, populate this filed with all of the allowed symbols, url-escaped.
     * @param    detectDuplicates    Optional parameter: If you need to detect duplicates as in functional groups or transactions with the same reference number, set this flag to true. The default is false.
     * @param    tranRefNumber    Optional parameter: The default is 1. Set this to whatever the 997 or 999 X12Interchange.ST.TransactionSetControlNumber_02 needs to be. In case there are multiple acknowledgments (for multiple functional groups), this will be starting reference number and every subsequent acknowledgment will have the previous reference number incremented with 1.
     * @param    interchangeRefNumber    Optional parameter: The default is 1. Set this to whatever the 997 or 999 X12Interchange.ISA.InterchangeControlNumber_13 needs to be.
     * @param    ackForValidTrans    Optional parameter: The default is false. Set this to true if you need AK2 loops included for all valid transaction as well. By default AK2 loops are generated only for invalid transactions.
     * @param    batchAcks    Optional parameter: The default is true. Set this to false if you need to generate separate X12Interchange for each acknowledgment. By default all acknowledgments are batched in the same X12Interchange.
     * @param    technicalAck    Optional parameter: The default technical acknowledgment TA1 is generated according to X12Interchange.ISA.AcknowledgementRequested_14. You can either enforce it to always generate TA1s or supress it to never generate any TA1s. This will override the flag in X12Interchange.ISA.AcknowledgementRequested_14.              The available values are: default, enforce, suppress.
     * @param    ack    Optional parameter: The default value is 997. The type of acknowledgment being generated. Set this to 999 if you need to generate an implementation instead of functional acknowledgment. The available values are: 997, 999.
     * @param    ak901isP    Optional parameter: The value of the AK9's first element. By default it is "E". Set this to true if you want this value to be "P" instead.
     * @param    contentType    Optional parameter: Example: application/json
     * @param    body    Optional parameter: The X12Interchange object to acknowledge.
     * @return    Returns the List<X12Interchange> response from the API call 
     */
    public List<X12Interchange> ack(
                final Boolean basicSyntax,
                final String syntaxSet,
                final Boolean detectDuplicates,
                final Integer tranRefNumber,
                final Integer interchangeRefNumber,
                final Boolean ackForValidTrans,
                final Boolean batchAcks,
                final String technicalAck,
                final String ack,
                final Boolean ak901isP,
                final String contentType,
                final X12Interchange body
    ) throws Throwable {

        HttpRequest _request = _buildAckRequest(basicSyntax, syntaxSet, detectDuplicates, tranRefNumber, interchangeRefNumber, ackForValidTrans, batchAcks, technicalAck, ack, ak901isP, contentType, body);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleAckResponse(_context);
    }

    /**
     * Generates functional/implementation and/or technical acknowledment(s) for the requested X12Interchange.
     * @param    basicSyntax    Optional parameter: All data elements with alpha (A) or alphanumeric (AN) data types are validated against a syntax set of allowed characters. The default syntax set is the Extended, hence the default for this parameter is false. By setting this to true, validation will use the Basic syntax set.
     * @param    syntaxSet    Optional parameter: In case you need to validate against a syntax set, different than Basic and Extended, populate this filed with all of the allowed symbols, url-escaped.
     * @param    detectDuplicates    Optional parameter: If you need to detect duplicates as in functional groups or transactions with the same reference number, set this flag to true. The default is false.
     * @param    tranRefNumber    Optional parameter: The default is 1. Set this to whatever the 997 or 999 X12Interchange.ST.TransactionSetControlNumber_02 needs to be. In case there are multiple acknowledgments (for multiple functional groups), this will be starting reference number and every subsequent acknowledgment will have the previous reference number incremented with 1.
     * @param    interchangeRefNumber    Optional parameter: The default is 1. Set this to whatever the 997 or 999 X12Interchange.ISA.InterchangeControlNumber_13 needs to be.
     * @param    ackForValidTrans    Optional parameter: The default is false. Set this to true if you need AK2 loops included for all valid transaction as well. By default AK2 loops are generated only for invalid transactions.
     * @param    batchAcks    Optional parameter: The default is true. Set this to false if you need to generate separate X12Interchange for each acknowledgment. By default all acknowledgments are batched in the same X12Interchange.
     * @param    technicalAck    Optional parameter: The default technical acknowledgment TA1 is generated according to X12Interchange.ISA.AcknowledgementRequested_14. You can either enforce it to always generate TA1s or supress it to never generate any TA1s. This will override the flag in X12Interchange.ISA.AcknowledgementRequested_14.              The available values are: default, enforce, suppress.
     * @param    ack    Optional parameter: The default value is 997. The type of acknowledgment being generated. Set this to 999 if you need to generate an implementation instead of functional acknowledgment. The available values are: 997, 999.
     * @param    ak901isP    Optional parameter: The value of the AK9's first element. By default it is "E". Set this to true if you want this value to be "P" instead.
     * @param    contentType    Optional parameter: Example: application/json
     * @param    body    Optional parameter: The X12Interchange object to acknowledge.
     */
    public void ackAsync(
                final Boolean basicSyntax,
                final String syntaxSet,
                final Boolean detectDuplicates,
                final Integer tranRefNumber,
                final Integer interchangeRefNumber,
                final Boolean ackForValidTrans,
                final Boolean batchAcks,
                final String technicalAck,
                final String ack,
                final Boolean ak901isP,
                final String contentType,
                final X12Interchange body,
                final APICallBack<List<X12Interchange>> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildAckRequest(basicSyntax, syntaxSet, detectDuplicates, tranRefNumber, interchangeRefNumber, ackForValidTrans, batchAcks, technicalAck, ack, ak901isP, contentType, body);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            List<X12Interchange> returnValue = _handleAckResponse(_context);
                            callBack.onSuccess(_context, returnValue);
                        } catch (Exception e) {
                            callBack.onFailure(_context, e);
                        }
                    }

                    public void onFailure(HttpContext _context, Throwable _exception) {
                        // Let the caller know of the failure
                        callBack.onFailure(_context, _exception);
                    }
                });
            }
        };

        // Execute async using thread pool
        APIHelper.getScheduler().execute(_responseTask);
    }

    /**
     * Builds the HttpRequest object for ack
     */
    private HttpRequest _buildAckRequest(
                final Boolean basicSyntax,
                final String syntaxSet,
                final Boolean detectDuplicates,
                final Integer tranRefNumber,
                final Integer interchangeRefNumber,
                final Boolean ackForValidTrans,
                final Boolean batchAcks,
                final String technicalAck,
                final String ack,
                final Boolean ak901isP,
                final String contentType,
                final X12Interchange body) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/x12/ack");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        if (basicSyntax != null) {
            _queryParameters.put("basicSyntax", (basicSyntax != null) ? basicSyntax : false);
        }
        if (syntaxSet != null) {
            _queryParameters.put("syntaxSet", syntaxSet);
        }
        if (detectDuplicates != null) {
            _queryParameters.put("detectDuplicates", (detectDuplicates != null) ? detectDuplicates : false);
        }
        if (tranRefNumber != null) {
            _queryParameters.put("tranRefNumber", (tranRefNumber != null) ? tranRefNumber : 1);
        }
        if (interchangeRefNumber != null) {
            _queryParameters.put("interchangeRefNumber", (interchangeRefNumber != null) ? interchangeRefNumber : 1);
        }
        if (ackForValidTrans != null) {
            _queryParameters.put("ackForValidTrans", (ackForValidTrans != null) ? ackForValidTrans : false);
        }
        if (batchAcks != null) {
            _queryParameters.put("batchAcks", (batchAcks != null) ? batchAcks : true);
        }
        if (technicalAck != null) {
            _queryParameters.put("technicalAck", technicalAck);
        }
        if (ack != null) {
            _queryParameters.put("ack", (ack != null) ? ack : "997");
        }
        if (ak901isP != null) {
            _queryParameters.put("ak901isP", (ak901isP != null) ? ak901isP : false);
        }
        APIHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        if (contentType != null) {
            _headers.put("Content-Type", contentType != null ? contentType : "application/json");
        }
        _headers.put("Ocp-Apim-Subscription-Key", Configuration.ocpApimSubscriptionKey);
        _headers.put("user-agent", BaseController.userAgent);
        _headers.put("accept", "application/json");


        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().postBody(_queryUrl, _headers, APIHelper.serialize(body));

        // Invoke the callback before request if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for ack
     * @return An object of type List<X12Interchange>
     */
    private List<X12Interchange> _handleAckResponse(HttpContext _context)
            throws APIException, IOException {
        HttpResponse _response = _context.getResponse();

        //invoke the callback after response if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnAfterResponse(_context);
        }

        //Error handling using HTTP status codes
        int _responseCode = _response.getStatusCode();

        if (_responseCode == 400) {
            throw new ErrorDetailsException("Bad Request", _context);
        }
        if (_responseCode == 500) {
            throw new ErrorDetailsException("Server Error", _context);
        }
        //handle errors defined at the API level
        validateResponse(_response, _context);

        //extract result from the http response
        String _responseBody = ((HttpStringResponse)_response).getBody();
        List<X12Interchange> _result = APIHelper.deserialize(_responseBody,
									new TypeReference<List<X12Interchange>>(){});

        return _result;
    }

}
