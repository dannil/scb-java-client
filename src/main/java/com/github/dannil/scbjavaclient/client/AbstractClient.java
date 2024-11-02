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

import java.net.http.HttpResponse;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

import com.github.dannil.scbjavaclient.communication.CommunicationProtocol;
import com.github.dannil.scbjavaclient.communication.URLEndpoint;
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
import com.github.dannil.scbjavaclient.utility.StreamUtility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Abstract class which specifies how clients should operate.
 *
 * @since 0.0.2
 */
public abstract class AbstractClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractClient.class);

    private CommunicationProtocol communicationProtocol;

    private Locale locale;

    private Localization localization;

    /**
     * Default constructor.
     */
    protected AbstractClient() {
        this.communicationProtocol = CommunicationProtocol.HTTPS;
        this.locale = Locale.US;
        this.localization = new Localization(this.locale);
    }

    /**
     * Overloaded constructor.
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
     * Returns the communication protocol for this client instance.
     *
     * @return the
     *         {@link com.github.dannil.scbjavaclient.communication.CommunicationProtocol
     *         CommunicationProtocol} for this client instance
     */
    public CommunicationProtocol getCommunicationProtocol() {
        return this.communicationProtocol;
    }

    /**
     * Sets the communication protocol for this client instance.
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
     * Retrieves the <code>Locale</code> for this client instance.
     *
     * @return the <code>Locale</code> for this client instance
     */
    public Locale getLocale() {
        return this.locale;
    }

    /**
     * Sets the <code>Locale</code> for this client instance. Note that doing this
     * after a call to {@link #setLocalizationLocale(Locale)} overwrites the localization
     * language with the input of this method.
     *
     * @param locale
     *            the <code>Locale</code> for this client
     */
    public void setLocale(Locale locale) {
        this.locale = locale;
        this.localization.setLocale(locale);
    }

    /**
     * Returns the <code>Locale</code> used for the localization.
     *
     * @return locale the <code>Locale</code> for the localization
     */
    public Locale getLocalizationLocale() {
        return this.localization.getLocale();
    }

    /**
     * Changes the <code>Locale</code> used for the localization. Useful if the client
     * needs to be in a different language than the error messages.
     *
     * @param loc
     *            the <code>Locale</code> for the localization
     */
    public void setLocalizationLocale(Locale loc) {
        this.localization.setLocale(loc);
    }

    /**
     * Determines the URL for the API based on the current <code>Locale</code> and
     * communication protocol.
     *
     * @return the URL representing the entry point for the API
     */
    protected URLEndpoint getRootUrl() {
        return URLEndpoint.getRootUrl(this.locale, this.communicationProtocol);
    }

    /**
     * Performs a GET request to the specified URL.
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
     * Performs a POST request to the specified URL.
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
     * Handles the HTTP request. This method contains the common logic for handling GET
     * and POST requests.
     *
     * @param requester
     *            the requester
     * @param url
     *            the URL
     * @return a string representation of the API's response
     */
    private String handleRequest(AbstractRequester requester, String url) {
        HttpResponse<String> response = requester.getResponse(url);
        String body = null;
        URLEndpoint endpointUrl = new URLEndpoint(url);
        String urlLanguage = endpointUrl.getLanguage();
        if (response.statusCode() == HttpStatusCode.OK.getCode()) {
            // Handle possible byte order mark
            body = StreamUtility.skipUnicodeByteOrderMark(response.body());
        } else if (response.statusCode() == HttpStatusCode.NOT_FOUND.getCode()
                && !Objects.equals(urlLanguage, APIConstants.FALLBACK_LOCALE.getLanguage())) {
            // HTTP code 404, call the API again with the fallback language
            URLEndpoint fallbackEndpointUrl = endpointUrl.toURL(APIConstants.FALLBACK_LOCALE);
            LOGGER.debug("Couldn't find table {} for locale {}, retrying with fallback locale {}",
                    endpointUrl.getTable(), this.locale.getLanguage(), APIConstants.FALLBACK_LOCALE.getLanguage());
            return handleRequest(requester, fallbackEndpointUrl.toString());
        } else if (response.statusCode() == HttpStatusCode.FORBIDDEN.getCode()) {
            throw new SCBClientResponseTooLargeException("The response exceeded the maximum size allowed by the API");
        }
        return body;
    }

    /**
     * Retrieves the response models for a given table.
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
     * Retrieves the response models for a given table which match the input
     * constraints.
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
     * Returns the URL endpoint which this client represents.
     *
     * @return the URL endpoint for this client
     */
    public abstract URLEndpoint getUrl();

}
