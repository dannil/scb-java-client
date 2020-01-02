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
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublisher;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

import com.github.dannil.scbjavaclient.exception.SCBClientException;

/**
 * <p>Class which contains the logic for sending URL requests to a specified address.</p>
 *
 * @since 1.2.0
 */
public abstract class AbstractRequester {

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
     * <p>Retrieves the response from the specified URL.</p>
     *
     * @param url
     *            the URL to call
     * @return the response as an
     *         {@link java.net.http.HttpResponse HttpResponse}
     */
    public abstract HttpResponse<String> getResponse(String url);

    /**
     * <p>Retrieves the response from the specified URL, using the specified HTTP
     * method.</p>
     *
     * @param url
     *            the URL to call
     * @param method
     *            the HTTP method to use
     * @return the response as an
     *         {@link java.net.http.HttpResponse HttpResponse}
     * @throws IOException
     *             if an input/output error occurred during the request
     * @throws InterruptedException
     *             if the request was interrupted
     */
    protected HttpResponse<String> getResponse(String url, String method) throws IOException, InterruptedException {
        return getResponse(url, method, "");
    }

    /**
     * <p>Retrieves the response from the specified URL, using the specified HTTP method
     * and request body.</p>
     *
     * @param url
     *            the URL to call
     * @param method
     *            the HTTP method to use
     * @param body
     *            the request body
     * @return the response as an
     *         {@link java.net.http.HttpResponse HttpResponse}
     * @throws IOException
     *             if an input/output error occurred during the request
     * @throws InterruptedException
     *             if the request was interrupted
     */
    protected HttpResponse<String> getResponse(String url, String method, String body)
            throws IOException, InterruptedException {
        List<String> headers = new ArrayList<>();
        for (Entry<String, String> requestProperty : this.requestProperties.entrySet()) {
            headers.add(requestProperty.getKey());
            headers.add(requestProperty.getValue());
        }

        BodyPublisher bodyPublisher = BodyPublishers.ofString(body, getCharset());
        if (!body.isEmpty()) {
            bodyPublisher = BodyPublishers.noBody();
        }

        HttpClient client = HttpClient.newHttpClient();
        Builder builder = HttpRequest.newBuilder().uri(URI.create(url)).headers(headers.toArray(new String[0])).method(
                method, bodyPublisher);
        HttpRequest request = builder.build();

        return client.send(request, BodyHandlers.ofString(getCharset()));
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
