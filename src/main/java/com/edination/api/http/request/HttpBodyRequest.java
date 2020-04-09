/*
 * EdiNationAPILib
 *
 * This file was automatically generated for EdiNation by APIMATIC v2.0 ( https://apimatic.io ).
 */
package com.edination.api.http.request;

import com.edination.api.http.request.HttpMethod;

import java.util.Map;

public class HttpBodyRequest extends HttpRequest {
    /**
     * Private store for properties
     */
    private String body;

    /**
     * Body for the http request
     */
    public String getBody() {
        return body;
    }

    /**
     * Create a request with explicit body
     *
     * @param _method   The HTTP method to use. Can be PUT, POST, DELETE and PATCH
     * @param _queryUrl The http url to create the HTTP Request. Expect a fully qualified absolute Url
     * @param _headers  The key-value map of all http headers to be sent
     * @param _body     The object to be sent as body after serialization
     * @return Http request initialized with the given method, url, headers and request body
     */
    public HttpBodyRequest(HttpMethod _method, String _queryUrl,
                           Map<String, String> _headers, String _body) {
        super(_method, _queryUrl, _headers, null);
        this.body = _body!=null ? _body : "";
    }

    /**
     * Create a request with explicit body
     *
     * @param _method   The HTTP method to use. Can be PUT, POST, DELETE and PATCH
     * @param _queryUrl The http url to create the HTTP Request. Expect a fully qualified absolute Url
     * @param _headers  The key-value map of all http headers to be sent
     * @param _body     The object to be sent as body after serialization
     * @param _username Username for basic authentication
     * @param _password Password for basic authentication
     * @return Http request initialized with the given method, url, headers and request body
     */
    public HttpBodyRequest(HttpMethod _method, String _queryUrl,
                           Map<String, String> _headers, String _body,
                           String _username, String _password) {
        super(_method, _queryUrl, _headers, null, _username, _password);
        this.body = _body!=null ? _body : "";
    }
}
