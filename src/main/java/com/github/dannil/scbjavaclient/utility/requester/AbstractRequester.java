/*
 * Copyright 2016 Daniel Nilsson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dannil.scbjavaclient.utility.requester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.input.BOMInputStream;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.HttpClientBuilder;

import com.github.dannil.scbjavaclient.exception.SCBClientException;
import com.github.dannil.scbjavaclient.utility.HttpUtility;

/**
 * <p>Class which contains the logic for sending URL requests to a specified address.</p>
 * 
 * @author Daniel Nilsson
 */
public abstract class AbstractRequester {

	private static Properties properties;

	protected Charset charset;

	protected HttpClient client;

	protected Map<String, String> requestProperties;

	static {
		properties = new Properties();
		try (InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream("project.properties")) {
			properties.load(input);
		} catch (IOException e) {
			throw new SCBClientException(e);
		}
	}

	/**
	 * <p>Default constructor. Loads the request properties and other data needed for the
	 * requesters.</p>
	 */
	protected AbstractRequester() {
		this.client = HttpClientBuilder.create().build();
		this.charset = StandardCharsets.UTF_8;

		this.requestProperties = new HashMap<String, String>();
		this.requestProperties.put("Accept", "application/json");
		this.requestProperties.put("Content-Type", "application/json; charset=" + this.charset.name().toLowerCase());

		String artifactId = properties.getProperty("artifactId");
		String version = properties.getProperty("version");
		String url = properties.getProperty("url");

		StringBuilder builder = new StringBuilder(64);
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
	 * <p>Performs a request with the specified <code>HttpRequest</code> and retrieves the response
	 * as a <code>HttpResponse</code>.</p>
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
		StringBuilder builder = new StringBuilder(64);
		try (BOMInputStream bis = new BOMInputStream(response.getEntity().getContent())) {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(bis, this.charset.name()))) {
				for (String line = br.readLine(); line != null; line = br.readLine()) {
					builder.append(line);
				}
			}
		} catch (IOException e) {
			throw new SCBClientException(e);
		}
		return builder.toString();
	}

	/**
	 * <p>Return the content from the specified table.</p>
	 *
	 * @param table
	 *            the table to fetch the content from
	 * @return the content of the table
	 */
	public String getBodyAsStringFromTable(String table) {
		return getBodyAsString("https://api.scb.se/OV0104/v1/doris/sv/ssd/" + table);
	}

	/**
	 * <p>Returns the response from the specified URL as a string.</p>
	 * 
	 * @param url
	 *            the URL to get the response from
	 * @return the response
	 */
	public abstract String getBodyAsString(String url);

	/**
	 * <p>Getter for charset.</p>
	 * 
	 * @return the charset
	 */
	public Charset getCharset() {
		return this.charset;
	}

	/**
	 * <p>Setter for charset. Also updates the request properties with the new charset.</p>
	 * 
	 * @param charset
	 *            the charset
	 */
	public void setCharset(Charset charset) {
		this.charset = charset;
		this.requestProperties.put("Content-Type", "application/json; charset=" + this.charset.name().toLowerCase());
	}

}
