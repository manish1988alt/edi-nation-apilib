/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.controllers;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
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

public class EdiModelController extends BaseController {
    //private static variables for the singleton pattern
    private static final Object syncObject = new Object();
    private static EdiModelController instance = null;

    /**
     * Singleton pattern implementation 
     * @return The singleton instance of the EdiModelController class 
     */
    public static EdiModelController getInstance() {
        if (null == instance) {
            synchronized (syncObject) {
                if (null == instance) {
                    instance = new EdiModelController();
                }
            }
        }
        return instance;
    }

    /**
     * Uploads a model file to a subscription. It must be a valid DOT NET assembly.
     * @param    fileName    Required parameter: Upload File
     */
    public void upload(
                final File fileName
    ) throws Throwable {

        HttpRequest _request = _buildUploadRequest(fileName);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        _handleUploadResponse(_context);
    }

    /**
     * Uploads a model file to a subscription. It must be a valid DOT NET assembly.
     * @param    fileName    Required parameter: Upload File
     */
    public void uploadAsync(
                final File fileName,
                final APICallBack<Object> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildUploadRequest(fileName);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            _handleUploadResponse(_context);
                            callBack.onSuccess(_context, null);
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
     * Builds the HttpRequest object for upload
     */
    private HttpRequest _buildUploadRequest(
                final File fileName) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/models");
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("Ocp-Apim-Subscription-Key", Configuration.ocpApimSubscriptionKey);
        _headers.put("user-agent", BaseController.userAgent);


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
     * Processes the response for upload
     */
    private void _handleUploadResponse(HttpContext _context)
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


    }

    /**
     * Retrieves all models for a subscription.
     * @param    system    Optional parameter: Whether to retrieve EdiNation's or custom uploaded models.
     * @return    Returns the List<EdiModel> response from the API call 
     */
    public List<EdiModel> getModels(
                final Boolean system
    ) throws Throwable {

        HttpRequest _request = _buildGetModelsRequest(system);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetModelsResponse(_context);
    }

    /**
     * Retrieves all models for a subscription.
     * @param    system    Optional parameter: Whether to retrieve EdiNation's or custom uploaded models.
     */
    public void getModelsAsync(
                final Boolean system,
                final APICallBack<List<EdiModel>> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetModelsRequest(system);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            List<EdiModel> returnValue = _handleGetModelsResponse(_context);
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
     * Builds the HttpRequest object for getModels
     */
    private HttpRequest _buildGetModelsRequest(
                final Boolean system) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/models");

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        if (system != null) {
            _queryParameters.put("system", (system != null) ? system : true);
        }
        APIHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("Ocp-Apim-Subscription-Key", Configuration.ocpApimSubscriptionKey);
        _headers.put("user-agent", BaseController.userAgent);
        _headers.put("accept", "application/json");


        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for getModels
     * @return An object of type List<EdiModel>
     */
    private List<EdiModel> _handleGetModelsResponse(HttpContext _context)
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
        List<EdiModel> _result = APIHelper.deserialize(_responseBody,
									new TypeReference<List<EdiModel>>(){});

        return _result;
    }

    /**
     * Retrieve a particular model file as a stream.
     * @param    id    Required parameter: The model name.
     * @param    system    Optional parameter: Whether to search in EdiNation's or custom uploaded models.
     * @return    Returns the InputStream response from the API call 
     */
    public InputStream getModel(
                final String id,
                final Boolean system
    ) throws Throwable {

        HttpRequest _request = _buildGetModelRequest(id, system);
        HttpResponse _response = getClientInstance().executeAsBinary(_request);
        HttpContext _context = new HttpContext(_request, _response);

        return _handleGetModelResponse(_context);
    }

    /**
     * Retrieve a particular model file as a stream.
     * @param    id    Required parameter: The model name.
     * @param    system    Optional parameter: Whether to search in EdiNation's or custom uploaded models.
     */
    public void getModelAsync(
                final String id,
                final Boolean system,
                final APICallBack<InputStream> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildGetModelRequest(id, system);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsBinaryAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            InputStream returnValue = _handleGetModelResponse(_context);
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
     * Builds the HttpRequest object for getModel
     */
    private HttpRequest _buildGetModelRequest(
                final String id,
                final Boolean system) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/models/{id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("id", id);
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);

        //process query parameters
        Map<String, Object> _queryParameters = new HashMap<String, Object>();
        if (system != null) {
            _queryParameters.put("system", (system != null) ? system : true);
        }
        APIHelper.appendUrlWithQueryParameters(_queryBuilder, _queryParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("Ocp-Apim-Subscription-Key", Configuration.ocpApimSubscriptionKey);
        _headers.put("user-agent", BaseController.userAgent);


        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().get(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for getModel
     * @return An object of type InputStream
     */
    private InputStream _handleGetModelResponse(HttpContext _context)
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
     * Deletes a particular model from the custom models.
     * @param    id    Required parameter: The model name.
     */
    public void delete(
                final String id
    ) throws Throwable {

        HttpRequest _request = _buildDeleteRequest(id);
        HttpResponse _response = getClientInstance().executeAsString(_request);
        HttpContext _context = new HttpContext(_request, _response);

        _handleDeleteResponse(_context);
    }

    /**
     * Deletes a particular model from the custom models.
     * @param    id    Required parameter: The model name.
     */
    public void deleteAsync(
                final String id,
                final APICallBack<Object> callBack
    ) {
        Runnable _responseTask = new Runnable() {
            public void run() {

                HttpRequest _request;
                try {
                    _request = _buildDeleteRequest(id);
                } catch (Exception e) {
                    callBack.onFailure(null, e);
                    return;
                }

                // Invoke request and get response
                getClientInstance().executeAsStringAsync(_request, new APICallBack<HttpResponse>() {
                    public void onSuccess(HttpContext _context, HttpResponse _response) {
                        try {
                            _handleDeleteResponse(_context);
                            callBack.onSuccess(_context, null);
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
     * Builds the HttpRequest object for delete
     */
    private HttpRequest _buildDeleteRequest(
                final String id) throws IOException, APIException {
        //the base uri for api requests
        String _baseUri = Configuration.baseUri;

        //prepare query string for API call
        StringBuilder _queryBuilder = new StringBuilder(_baseUri + "/models/{id}");

        //process template parameters
        Map<String, Object> _templateParameters = new HashMap<String, Object>();
        _templateParameters.put("id", id);
        APIHelper.appendUrlWithTemplateParameters(_queryBuilder, _templateParameters);
        //validate and preprocess url
        String _queryUrl = APIHelper.cleanUrl(_queryBuilder);

        //load all headers for the outgoing API request
        Map<String, String> _headers = new HashMap<String, String>();
        _headers.put("Ocp-Apim-Subscription-Key", Configuration.ocpApimSubscriptionKey);
        _headers.put("user-agent", BaseController.userAgent);


        //prepare and invoke the API call request to fetch the response
        HttpRequest _request = getClientInstance().delete(_queryUrl, _headers, null);

        // Invoke the callback before request if its not null
        if (getHttpCallBack() != null) {
            getHttpCallBack().OnBeforeRequest(_request);
        }

        return _request;
    }

    /**
     * Processes the response for delete
     */
    private void _handleDeleteResponse(HttpContext _context)
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


    }

}
