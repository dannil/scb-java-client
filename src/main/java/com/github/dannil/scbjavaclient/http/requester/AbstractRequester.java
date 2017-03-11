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

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.github.dannil.scbjavaclient.exception.SCBClientException;
import com.github.dannil.scbjavaclient.http.HttpStatusCode;
import com.github.dannil.scbjavaclient.http.Response;
import com.github.dannil.scbjavaclient.utility.URLUtility;

/**
 * <p>Class which contains the logic for sending URL requests to a specified address.</p>
 *
 * @since 0.0.2
 */
public abstract class AbstractRequester {

    private static final String REQUESTPROPERTY_ACCEPT = "Accept";

    private static final String REQUESTPROPERTY_ACCEPT_CHARSET = "Accept-Charset";

    private static final String REQUESTPROPERTY_CONTENT_TYPE = "Content-Type";

    private static final String REQUESTPROPERTY_USER_AGENT = "User-Agent";

    private static Properties properties;

    private Charset charset;

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
        this.requestProperties = new HashMap<>();
        this.requestProperties.put(REQUESTPROPERTY_ACCEPT, "application/json");
        this.requestProperties.put(REQUESTPROPERTY_USER_AGENT, createUserAgent());
        setCharset(charset);
    }

    /**
     * <p>Retrieves the <code>URLConnection</code> that represents the specified URL. This
     * method sets the request properties for the <code>URLConnection</code> being
     * retrieved.</p>
     *
     * @param url
     *            the URL
     * @return a <code>URLConnection</code>
     * @throws IOException
     *             if an exception occurred when creating the <code>URLConnection</code>
     */
    protected URLConnection getConnection(String url) throws IOException {
        URLConnection connection = new URL(url).openConnection();
        for (Entry<String, String> entry : this.requestProperties.entrySet()) {
            connection.setRequestProperty(entry.getKey(), entry.getValue());
        }
        return connection;
    }

    /**
     * <p>Retrieves the response from the specified <code>URLConnection</code>.</p>
     *
     * @param connection
     *            the <code>URLConnection</code>
     * @return the response as an <code>InputStream</code>
     * @throws IOException
     *             if an exception occurred while retrieving the <code>InputStream</code>
     */
    protected Response getResponse(URLConnection connection) throws IOException {
        HttpURLConnection httpConnection = (HttpURLConnection) connection;
        HttpStatusCode status = HttpStatusCode.valueOf(httpConnection.getResponseCode());
        InputStream stream = null;
        if (status.getCode() < 400) {
            stream = httpConnection.getInputStream();
        } else {
            stream = httpConnection.getErrorStream();
        }
        return new Response(status, stream);
    }

    public abstract Response getResponse(String url);

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
        return getResponse(URLUtility.getRootUrl() + table).getBody();
    }

    /**
     * <p>Getter for charset.</p>
     *
     * @return the charset
     */
    public final Charset getCharset() {
        return this.charset;
    }

    /**
     * <p>Setter for charset.</p>
     *
     * @param charset
     *            the charset
     */
    public final void setCharset(Charset charset) {
        this.charset = charset;
        this.requestProperties.put(REQUESTPROPERTY_ACCEPT_CHARSET, this.charset.name());
        this.requestProperties.put(REQUESTPROPERTY_CONTENT_TYPE, "application/json; charset="
                + this.charset.name().toLowerCase());
    }

    /**
     * <p>Creates the user agent string.</p>
     *
     * @return the user agent string
     */
    private String createUserAgent() {
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

        return builder.toString();
    }

}
