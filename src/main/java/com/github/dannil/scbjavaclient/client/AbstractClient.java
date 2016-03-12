/*
 * Copyright 2014 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.dannil.scbjavaclient.utility.JsonUtility;
import com.github.dannil.scbjavaclient.utility.Localization;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;
import com.github.dannil.scbjavaclient.utility.requester.POSTRequester;
import com.github.dannil.scbjavaclient.utility.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.utility.requester.RequesterFactory;

/**
 * Abstract class which specifies how clients should operate.
 * 
 * @author Daniel Nilsson
 */
public abstract class AbstractClient {

	private static final Logger LOGGER = Logger.getLogger(AbstractClient.class.getName());

	protected Locale locale;

	protected QueryBuilder queryBuilder;
	protected Localization localization;

	protected AbstractClient() {
		this.locale = Locale.getDefault();

		this.queryBuilder = QueryBuilder.getInstance();
		this.localization = new Localization(this.locale);
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param locale
	 *            the locale for this client
	 */
	protected AbstractClient(Locale locale) {
		this();
		this.locale = locale;

		this.localization.setLanguage(this.locale);
	}

	/**
	 * Retrieves the language for this Client instance.
	 * 
	 * @return the language for this Client instance
	 */
	public Locale getLocale() {
		return this.locale;
	}

	/**
	 * Sets the language for this client instance. Note that doing this after a call to
	 * {@link #setLocalizationLanguage(Locale)} overwrites the localization language with the input
	 * of this method.
	 * 
	 * @param locale
	 *            the language for this client
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;

		this.localization.setLanguage(locale);
	}

	/**
	 * Changes the language used for the localization. Useful if the client needs to be in a
	 * different language than the error messages.
	 * 
	 * @param locale
	 *            the language for the localization
	 */
	public void setLocalizationLanguage(Locale locale) {
		this.localization.setLanguage(locale);
	}

	/**
	 * Determines the base URL for the API based on the current locale.
	 * 
	 * @return the URL representing the entry point for the API.
	 */
	protected String getBaseUrl() {
		return "http://api.scb.se/OV0104/v1/doris/" + this.locale.getLanguage() + "/ssd/";
	}

	/**
	 * Performs a GET request to the specified address.
	 * 
	 * @param address
	 *            the address which will be sent a GET request
	 * @return a string representation of the API's response
	 */
	// TODO Improve method
	protected String get(String address) {
		AbstractRequester get = RequesterFactory.getInstance("GET");
		try {
			String response = get.doRequest(getBaseUrl() + address);

			return response;
		} catch (FileNotFoundException e) {
			// 404, call the Client again with the fallback language

			try {
				return get.doRequest(toUrl(getBaseUrl() + address, this.locale));
			} catch (IOException e1) {
				e1.printStackTrace();

				return "UNHANDLED";
			}
		} catch (IOException e) {
			// Handle all other cases
			e.printStackTrace();

			return "IOException";
		}
	}

	/**
	 * Performs a POST request to the specified address.
	 * 
	 * @param address
	 *            the address which will be sent a POST request
	 * @param query
	 *            the payload which the API processes
	 * @return a string representation of the API's response
	 */
	// TODO Improve method
	protected String post(String address, String query) {
		AbstractRequester post = RequesterFactory.getInstance("POST");
		((POSTRequester) post).setPayload(query);
		try {
			String response = post.doRequest(getBaseUrl() + address);

			LOGGER.log(Level.INFO, query);

			return response;
		} catch (FileNotFoundException e) {
			// 404, call the Client again with the fallback language

			try {
				LOGGER.log(Level.INFO, query);

				return post.doRequest(toUrl(getBaseUrl() + address, this.locale));
			} catch (IOException e1) {
				e1.printStackTrace();

				return "UNHANDLED";
			}
		} catch (IOException e) {
			// Handle all other cases
			e.printStackTrace();

			return "IOException";
		}
	}

	// TODO Maybe should be in a separate utility class?
	/**
	 * Generates a new URL to the API with the specified inputs.
	 * 
	 * @param url
	 *            the URL to edit
	 * @param locale
	 *            the locale which to manipulate the URL with
	 * @return the modified URL
	 */
	private String toUrl(String url, Locale locale) {
		String internalAddress = url;

		// Some tables only support Swedish so we need to fall back to
		// Swedish if this is the case
		Locale fallback = new Locale("sv", "SE");

		int start = internalAddress.indexOf(locale.getLanguage(), internalAddress.indexOf("doris"));
		int end = start + locale.getLanguage().length();

		StringBuilder builder = new StringBuilder(internalAddress);
		builder.replace(start, end, fallback.getLanguage());

		return builder.toString();
	}

	/**
	 * Returns the list of the available regions for a given URL.
	 * 
	 * @param url
	 *            the URL to retrieve the regions from
	 * @throws UnsupportedOperationException
	 *             if the specified URL doesn't supply a regions table
	 * @return a list of the available regions for the given URL
	 */
	public List<String> getRegions(String url) {
		String content = get(url);

		JsonNode contentAsJsonNode = JsonUtility.getNode(content);

		List<String> codes = contentAsJsonNode.findValuesAsText("code");
		List<JsonNode> values = contentAsJsonNode.findValues("values");

		int position = codes.indexOf("Region");
		if (position < 0) {
			throw new UnsupportedOperationException(
					this.localization.getString("regions_is_not_supported_for_url", url));
		}

		JsonNode jsonRegions = values.get(position);

		List<String> regions = new ArrayList<String>(jsonRegions.size());
		for (int j = 0; j < jsonRegions.size(); j++) {
			regions.add(jsonRegions.get(j).asText());
		}

		return regions;
	}

	/**
	 * Returns the list of the available years for a given URL.
	 * 
	 * @param url
	 *            the URL to retrieve the years from
	 * @throws UnsupportedOperationException
	 *             if the specified URL doesn't supply a years table
	 * @return a list of the available years for the given URL
	 */
	protected List<String> getYears(String url) {
		String content = get(url);

		JsonNode contentAsJsonNode = JsonUtility.getNode(content);

		List<String> codes = contentAsJsonNode.findValuesAsText("code");
		List<JsonNode> values = contentAsJsonNode.findValues("values");

		int position = codes.indexOf("Tid");
		if (position < 0) {
			throw new UnsupportedOperationException(this.localization.getString("years_is_not_supported_for_url", url));
		}

		JsonNode jsonYears = values.get(position);

		List<String> years = new ArrayList<String>(jsonYears.size());
		for (int j = 0; j < jsonYears.size(); j++) {
			years.add(jsonYears.get(j).asText());
		}

		return years;
	}

	// /**
	// * Returns the URL endpoint which this client represents.
	// *
	// * @return the URL endpoint for this client
	// */
	// protected abstract String getUrl();

}
