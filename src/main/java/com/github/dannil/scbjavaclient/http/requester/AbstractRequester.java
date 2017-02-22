/*
 * Copyright 2016 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.http.requester;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.github.dannil.scbjavaclient.exception.SCBClientException;
import com.github.dannil.scbjavaclient.utility.HttpUtility;
import com.github.dannil.scbjavaclient.utility.URLUtility;

import org.apache.commons.io.input.BOMInputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;

/**
 * <p>Class which contains the logic for sending URL requests to a specified address.</p>
 *
 * @since 0.0.2
 */
public abstract class AbstractRequester {

    private static Properties properties;

    private Charset charset;

    private HttpClient client;

    private Map<String, String> requestProperties;

    static {
        properties = new Properties();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        try (InputStream input = loader.getResourceAsStream("project.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new SCBClientException(e);
        }
    }

    /**
     * <p>Default constructor. Specifies the charset to be used for requests as UTF-8.</p>
     */
    protected AbstractRequester() {
        this(StandardCharsets.UTF_8);
    }

    /**
     * <p>Overloaded constructor. Loads the request properties and other data needed for
     * the requesters.</p>
     *
     * @param charset
     *            the charset to use when doing a request
     */
    protected AbstractRequester(Charset charset) {
        this.charset = charset;

        this.client = HttpClientBuilder.create().build();

        this.requestProperties = new HashMap<>();
        this.requestProperties.put("Accept", "application/json");
        this.requestProperties.put("Content-Type", "application/json; charset=" + this.charset.name().toLowerCase());

        String artifactId = properties.getProperty("artifactId");
        String version = properties.getProperty("version");
        String url = properties.getProperty("url");

        StringBuilder builder = new StringBuilder();
        builder.append(artifactId);
        builder.append('/');
        builder.append(version);
        builder.append(" (");
        builder.append(url);
        builder.append("), ");
        builder.append(System.getProperty("os.name"));

        this.requestProperties.put("User-Agent", builder.toString());
    }

    /**
     * <p>Performs a request with the specified <code>HttpRequest</code> and retrieves the
     * response as a <code>HttpResponse</code>.</p>
     *
     * @param request
     *            the request
     * @return the response
     */
    protected HttpResponse getResponse(HttpRequestBase request) {
        try {
            HttpResponse response = this.client.execute(request);
            URI uri = request.getURI();
            int statusCode = response.getStatusLine().getStatusCode();
            HttpUtility.validateStatusCode(uri, statusCode);
            return response;
        } catch (IOException e) {
            throw new SCBClientException(e);
        }
    }

    /**
     * <p>Extracts the response body from the <code>HttpResponse</code>.</p>
     *
     * @param response
     *            the response to extract the body from
     * @return the body as a string
     */
    protected String getBody(HttpResponse response) {
        try (BOMInputStream bis = new BOMInputStream(response.getEntity().getContent())) {
            try (ByteArrayOutputStream bos = new ByteArrayOutputStream()) {
                int result = bis.read();
                while (result != -1) {
                    bos.write((byte) result);
                    result = bis.read();
                }
                return bos.toString();
            }
        } catch (IOException e) {
            throw new SCBClientException(e);
        }
    }

    /**
     * <p>Extracts the response body from the URL.</p>
     *
     * @param url
     *            the URL to get the response from
     * @return the response
     */
    public abstract String getBody(String url);

    /**
     * <p>Return the content from the specified table.</p>
     *
     * @param table
     *            the table to fetch the content from
     * @return the content of the table
     */
    public String getBodyFromTable(String table) {
        // #NOTE#
        //
        // This needs to be rewritten to handle different locale. A good solution is hard
        // to find right now since this class should not need to worry about the current
        // locale, as methods calling this method (getBodyFromTable) should really
        // convert the input language. This solution isn't really implementable right
        // now as the only method calling this method is getInputs() in the model.
        // However, the model doesn't (and should NOT) have any idea about the locale.
        //
        // A solution to this is to implement issue #12 on GitHub
        // (https://github.com/dannil/scb-java-client/issues/12) which transfers the
        // responsibility to a client. The client knows what locale is currently in use
        // and the method can therefore be rewritten to either accept the locale as a
        // parameter or the input URL is converted before calling this method.
        return getBody(URLUtility.getRootUrl() + table);
    }

    /**
     * <p>Getter for request properties.</p>
     *
     * @return the request properties
     */
    public Map<String, String> getRequestProperties() {
        return this.requestProperties;
    }

    /**
     * <p>Getter for charset.</p>
     *
     * @return the charset
     */
    public Charset getCharset() {
        return this.charset;
    }

    /**
     * <p>Setter for charset. Also updates the request properties with the new
     * charset.</p>
     *
     * @param charset
     *            the charset
     */
    public void setCharset(Charset charset) {
        this.charset = charset;
        this.requestProperties.put("Content-Type", "application/json; charset=" + this.charset.name().toLowerCase());
    }

}