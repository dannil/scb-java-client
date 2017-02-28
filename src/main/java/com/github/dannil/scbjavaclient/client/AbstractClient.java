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

import java.util.Locale;

import com.github.dannil.scbjavaclient.exception.SCBClientNotFoundException;
import com.github.dannil.scbjavaclient.http.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.http.requester.GETRequester;
import com.github.dannil.scbjavaclient.http.requester.POSTRequester;
import com.github.dannil.scbjavaclient.utility.Localization;
import com.github.dannil.scbjavaclient.utility.URLUtility;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * <p>Abstract class which specifies how clients should operate.</p>
 *
 * @since 0.0.2
 */
public abstract class AbstractClient {

    private static final Logger LOGGER = LogManager.getLogger(AbstractClient.class);

    private Locale locale;

    private Localization localization;

    /**
     * <p>Default constructor.</p>
     */
    protected AbstractClient() {
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
     * <p>Determines the URL for the API based on the current <code>Locale</code>.</p>
     *
     * @return the URL representing the entry point for the API
     */
    protected String getRootUrl() {
        return URLUtility.getRootUrl(this.locale);
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
        try {
            LOGGER.info("GET: {}", url);
            return get.getBody(url);
        } catch (SCBClientNotFoundException e) {
            // HTTP code 404, call the API again with the fallback language
            LOGGER.error("HTTP {}: {}", e.getStatusCode().getCode(), url);
            return get.getBody(URLUtility.changeLanguageForUrl(url));
        }
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
        try {
            LOGGER.info("POST: {}, {}", url, query);
            return post.getBody(url);
        } catch (SCBClientNotFoundException e) {
            // HTTP code 404, call the API again with the fallback language
            LOGGER.error("HTTP {}: {}", e.getStatusCode().getCode(), url);
            return post.getBody(URLUtility.changeLanguageForUrl(url));
        }
    }

    /**
     * <p>Returns the URL endpoint which this client represents.</p>
     *
     * @return the URL endpoint for this client
     */
    public abstract String getUrl();

}
