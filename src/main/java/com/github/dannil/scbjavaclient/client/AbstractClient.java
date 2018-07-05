/*
 * Copyright 2014 Daniel Nilsson
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.github.dannil.scbjavaclient.client;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.communication.CommunicationProtocol;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
import com.github.dannil.scbjavaclient.communication.http.HttpResponse;
import com.github.dannil.scbjavaclient.communication.http.HttpStatusCode;
import com.github.dannil.scbjavaclient.communication.http.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.communication.http.requester.GETRequester;
import com.github.dannil.scbjavaclient.communication.http.requester.POSTRequester;
import com.github.dannil.scbjavaclient.constants.APIConstants;
import com.github.dannil.scbjavaclient.exception.SCBClientResponseTooLargeException;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.ResponseModel;
import com.github.dannil.scbjavaclient.utility.Localization;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Abstract class which specifies how clients should operate.</p>
 *
 * @since 0.0.2
 */
public abstract class AbstractClient {

    private CommunicationProtocol communicationProtocol;

    private Locale locale;

    private Localization localization;

    /**
     * <p>Default constructor.</p>
     */
    protected AbstractClient() {
        this.communicationProtocol = CommunicationProtocol.HTTPS;
        this.locale = Locale.getDefault();
        this.localization = new Localization(this.locale);
    }

    /**
     * <p>Overloaded constructor.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    protected AbstractClient(Locale locale) {
        this();
        this.locale = locale;
        this.localization.setLocale(this.locale);
    }

    /**
     * <p>Returns the communication protocol for this client instance.</p>
     *
     * @return the
     *         {@link com.github.dannil.scbjavaclient.communication.CommunicationProtocol
     *         CommunicationProtocol} for this client instance
     */
    public CommunicationProtocol getCommunicationProtocol() {
        return this.communicationProtocol;
    }

    /**
     * <p>Sets the communication protocol for this client instance.</p>
     *
     * @param communicationProtocol
     *            the
     *            {@link com.github.dannil.scbjavaclient.communication.CommunicationProtocol
     *            CommunicationProtocol} for this client instance
     */
    public void setCommunicationProtocol(CommunicationProtocol communicationProtocol) {
        this.communicationProtocol = communicationProtocol;
    }

    /**
     * <p>Retrieves the <code>Locale</code> for this client instance.</p>
     *
     * @return the <code>Locale</code> for this client instance
     */
    public Locale getLocale() {
        return this.locale;
    }

    /**
     * <p>Sets the <code>Locale</code> for this client instance. Note that doing this
     * after a call to {@link #setLocalizationLocale(Locale)} overwrites the localization
     * language with the input of this method.</p>
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
        this.localization.setLocale(locale);
    }

    /**
     * <p>Returns the <code>Locale</code> used for the localization.</p>
     *
     * @return locale the <code>Locale</code> for the localization
     */
    public Locale getLocalizationLocale() {
        return this.localization.getLocale();
    }

    /**
     * <p>Changes the <code>Locale</code> used for the localization. Useful if the client
     * needs to be in a different language than the error messages.</p>
     *
     * @param loc
     *            the <code>Locale</code> for the localization
     */
    public void setLocalizationLocale(Locale loc) {
        this.localization.setLocale(loc);
    }

    /**
     * <p>Determines the URL for the API based on the current <code>Locale</code> and
     * communication protocol.</p>
     *
     * @return the URL representing the entry point for the API
     */
    protected URLEndpoint getRootUrl() {
        return URLEndpoint.getRootUrl(this.locale, this.communicationProtocol);
    }

    /**
     * <p>Performs a GET request to the specified URL.</p>
     *
     * @param url
     *            the URL which will be sent a GET request
     * @return a string representation of the API's response
     */
    protected String doGetRequest(String url) {
        AbstractRequester get = new GETRequester();
        return handleRequest(get, url);
    }

    /**
     * <p>Performs a POST request to the specified URL.</p>
     *
     * @param url
     *            the URL which will be sent a POST request
     * @param query
     *            the query which the API will process
     * @return a string representation of the API's response
     */
    protected String doPostRequest(String url, String query) {
        POSTRequester post = new POSTRequester();
        post.setQuery(query);
        return handleRequest(post, url);
    }

    /**
     * <p>Handles the request. This method contains the common logic for handling GET and
     * POST requests.</p>
     *
     * @param requester
     *            the requester
     * @param url
     *            the URL
     * @return a string representation of the API's response
     */
    private String handleRequest(AbstractRequester requester, String url) {
        HttpResponse response = requester.getResponse(url);
        String body = null;
        if (response.getStatus() == HttpStatusCode.OK) {
            body = response.getBody();
        } else if (response.getStatus() == HttpStatusCode.NOT_FOUND) {
            // HTTP code 404, call the API again with the fallback language
            URLEndpoint endpointUrl = new URLEndpoint(url).toURL(APIConstants.FALLBACK_LOCALE);
            body = requester.getResponse(endpointUrl.toString()).getBody();
        } else if (response.getStatus() == HttpStatusCode.FORBIDDEN) {
            throw new SCBClientResponseTooLargeException("The response exceeded the maximum size allowed by the API");
        }
        return body;
    }

    /**
     * <p>Retrieves the response models for a given table.</p>
     *
     * @param table
     *            the table
     * @return a list of {@link com.github.dannil.scbjavaclient.model.ResponseModel
     *         ResponseModel}
     */
    protected List<ResponseModel> getResponseModels(String table) {
        Map<String, Collection<?>> mappings = new HashMap<>();
        return getResponseModels(table, mappings);
    }

    /**
     * <p>Retrieves the response models for a given table which match the input
     * constraints.</p>
     *
     * @param table
     *            the table
     * @param mappings
     *            the mappings
     * @return a list of {@link com.github.dannil.scbjavaclient.model.ResponseModel
     *         ResponseModel}
     */
    protected List<ResponseModel> getResponseModels(String table, Map<String, Collection<?>> mappings) {
        String response = doPostRequest(getUrl() + table, QueryBuilder.build(mappings));

        JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
        return format.toListOf(ResponseModel.class);
    }

    /**
     * <p>Returns the URL endpoint which this client represents.</p>
     *
     * @return the URL endpoint for this client
     */
    public abstract URLEndpoint getUrl();

}
