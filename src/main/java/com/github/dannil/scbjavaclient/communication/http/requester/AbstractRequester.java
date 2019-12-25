/*
 * Copyright 2018 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.communication.http.requester;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.github.dannil.scbjavaclient.communication.http.HttpResponse;
import com.github.dannil.scbjavaclient.communication.http.HttpStatusCode;
import com.github.dannil.scbjavaclient.exception.SCBClientException;

/**
 * <p>Class which contains the logic for sending URL requests to a specified address.</p>
 *
 * @since 1.2.0
 */
public abstract class AbstractRequester {

    private static final int HTTP_ERRORS_START_CODE = 400;

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
        this.requestProperties.put("Accept", "application/json");
        this.requestProperties.put("User-Agent", createUserAgent());
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
     * @return the response as an {@link com.github.dannil.scbjavaclient.communication.http.HttpResponse
     *         Response}
     * @throws IOException
     *             if an exception occurred while retrieving the <code>Response</code>
     */
    protected HttpResponse getResponse(URLConnection connection) throws IOException {
        HttpURLConnection httpConnection = (HttpURLConnection) connection;
        HttpStatusCode status = HttpStatusCode.valueOf(httpConnection.getResponseCode());
        InputStream stream = null;
        if (status.getCode() < HTTP_ERRORS_START_CODE) {
            stream = httpConnection.getInputStream();
        }
        return new HttpResponse(status, stream);
    }

    /**
     * <p>Retrieves the response from the specified URL.</p>
     *
     * @param url
     *            the URL to call
     * @return the response as an {@link com.github.dannil.scbjavaclient.communication.http.HttpResponse
     *         Response}
     */
    public abstract HttpResponse getResponse(String url);

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
        this.requestProperties.put("Accept-Charset", this.charset.name());
        this.requestProperties.put("Content-Type",
                "application/json; charset=" + this.charset.name().toLowerCase(Locale.ENGLISH));
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
