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

import java.util.List;
import java.util.Locale;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.dannil.scbjavaclient.exception.SCBClientUrlNotFoundException;
import com.github.dannil.scbjavaclient.format.json.JsonAPITableFormat;
import com.github.dannil.scbjavaclient.utility.Localization;
import com.github.dannil.scbjavaclient.utility.URLUtility;
import com.github.dannil.scbjavaclient.utility.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.utility.requester.POSTRequester;
import com.github.dannil.scbjavaclient.utility.requester.RequestMethod;
import com.github.dannil.scbjavaclient.utility.requester.RequesterFactory;

/**
 * <p>
 * Abstract class which specifies how clients should operate.
 * </p>
 * 
 * @author Daniel Nilsson
 */
public abstract class AbstractClient {

	protected static final String ROOT_URL = "http://api.scb.se/OV0104/v1/doris/";

	private static final Logger LOGGER = LogManager.getLogger(AbstractClient.class);

	protected Locale locale;

	protected Localization localization;

	/**
	 * <p>
	 * Default constructor.
	 * </p>
	 */
	protected AbstractClient() {
		this.locale = Locale.getDefault();

		// validateLocale();

		this.localization = new Localization(this.locale);
	}

	/**
	 * <p>
	 * Overloaded constructor.
	 * </p>
	 * 
	 * @param locale
	 *            the locale for this client
	 */
	protected AbstractClient(Locale locale) {
		this();
		this.locale = locale;

		// validateLocale();

		this.localization.setLocale(this.locale);
	}

	/**
	 * <p>
	 * Retrieves the language for this client instance.
	 * </p>
	 * 
	 * @return the language for this client instance
	 */
	public Locale getLocale() {
		return this.locale;
	}

	/**
	 * <p>
	 * Sets the language for this client instance. Note that doing this after a
	 * call to {@link #setLocalizationLanguage(Locale)} overwrites the
	 * localization language with the input of this method.
	 * </p>
	 * 
	 * @param locale
	 *            the language for this client
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;

		// validateLocale();

		this.localization.setLocale(locale);
	}

	/**
	 * <p>
	 * Changes the language used for the localization. Useful if the client
	 * needs to be in a different language than the error messages.
	 * </p>
	 * 
	 * @param locale
	 *            the language for the localization
	 */
	public void setLocalizationLanguage(Locale locale) {
		this.localization.setLocale(locale);
	}

	/**
	 * <p>
	 * Determines the base URL for the API based on the current
	 * <code>Locale</code>.
	 * </p>
	 * 
	 * @return the URL representing the entry point for the API.
	 */
	protected String getBaseUrl() {
		return ROOT_URL + this.locale.getLanguage() + "/ssd/";
	}

	/**
	 * <p>
	 * Performs a GET request to the specified URL.
	 * </p>
	 * 
	 * @param url
	 *            the URL which will be sent a GET request
	 * @return a string representation of the API's response
	 */
	protected String get(String url) {
		AbstractRequester get = RequesterFactory.getRequester(RequestMethod.GET);
		try {
			return get.getBodyAsString(getBaseUrl() + url);
		} catch (SCBClientUrlNotFoundException e) {
			// 404, call the client again with the fallback language
			return get.getBodyAsString(URLUtility.changeLanguageForUrl(getBaseUrl() + url));
		}
	}

	/**
	 * <p>
	 * Performs a POST request to the specified URL.
	 * </p>
	 * 
	 * @param url
	 *            the URL which will be sent a POST request
	 * @param query
	 *            the query which the API will process
	 * @return a string representation of the API's response
	 */
	protected String post(String url, String query) {
		POSTRequester post = (POSTRequester) RequesterFactory.getRequester(RequestMethod.POST);
		post.setQuery(query);
		try {
			LOGGER.info(query);
			String response = post.getBodyAsString(getBaseUrl() + url);
			return response;
		} catch (SCBClientUrlNotFoundException e) {
			// 404, call the client again with the fallback language
			return post.getBodyAsString(URLUtility.changeLanguageForUrl(getBaseUrl() + url));
		}
	}

	/**
	 * <p>
	 * Returns the list of the available regions for a given URL.
	 * </p>
	 * 
	 * @param url
	 *            the URL to retrieve the regions from
	 * @return a list of the available regions for the given URL
	 * @throws IllegalArgumentException
	 *             if the specified URL doesn't supply a regions code
	 */
	public List<String> getRegions(String url) {
		String json = get(url);
		String code = "Region";
		try {
			JsonAPITableFormat format = new JsonAPITableFormat(json);
			List<String> values = format.getValues(code);
			return values;
		} catch (IllegalArgumentException e) {
			Object[] variables = new Object[] { code, url };
			throw new IllegalArgumentException(this.localization.getString("code_is_not_supported_for_url", variables), e);
		}

		// if (!inputs.containsKey("Region")) {
		// Object[] variables = new Object[] { url };
		//
		// throw new
		// UnsupportedOperationException(this.localization.getString("regions_is_not_supported_for_url",
		// variables));
		// }
		// return inputs.get("Region");

		// String content = get(url);
		//
		// JsonNode contentAsJsonNode = JsonUtility.toNode(content);
		//
		// List<String> codes = contentAsJsonNode.findValuesAsText("code");
		// List<JsonNode> values = contentAsJsonNode.findValues("values");
		//
		// int position = codes.indexOf("Region");
		// if (position < 0) {
		// Object[] variables = new Object[] { url };
		//
		// throw new
		// UnsupportedOperationException(this.localization.getString("regions_is_not_supported_for_url",
		// variables));
		// }
		//
		// JsonNode jsonRegions = values.get(position);
		//
		// List<String> regions = new ArrayList<String>(jsonRegions.size());
		// for (int j = 0; j < jsonRegions.size(); j++) {
		// regions.add(jsonRegions.get(j).asText());
		// }
		//
		// return regions;
	}

	/**
	 * <p>
	 * Returns the list of the available years for a given URL.
	 * </p>
	 * 
	 * @param url
	 *            the URL to retrieve the years from
	 * @return a list of the available years for the given URL
	 * @throws IllegalArgumentException
	 *             if the specified URL doesn't supply a years code
	 */
	public List<String> getYears(String url) {
		String json = get(url);
		String code = "Tid";
		try {
			JsonAPITableFormat format = new JsonAPITableFormat(json);
			return format.getValues(code);
		} catch (IllegalArgumentException e) {
			Object[] variables = new Object[] { code, url };
			throw new IllegalArgumentException(this.localization.getString("code_is_not_supported_for_url", variables), e);
		}
		//
		// String content = get(url);
		//
		// JsonNode contentAsJsonNode = JsonUtility.toNode(content);
		//
		// List<String> codes = contentAsJsonNode.findValuesAsText("code");
		// List<JsonNode> values = contentAsJsonNode.findValues("values");
		//
		// int position = codes.indexOf("Tid");
		// if (position < 0) {
		// Object[] variables = new Object[] { url };
		//
		// throw new
		// UnsupportedOperationException(this.localization.getString("years_is_not_supported_for_url",
		// variables));
		// }
		//
		// JsonNode jsonYears = values.get(position);
		//
		// List<String> years = new ArrayList<String>(jsonYears.size());
		// for (int j = 0; j < jsonYears.size(); j++) {
		// years.add(jsonYears.get(j).asText());
		// }
		//
		// return years;
	}

	// private void validateLocale() {
	// if (!isSupportedLocale(this.locale)) {
	// throw new SCBClientException("Locale " + this.locale + " is not supported
	// by the API");
	// }
	// }

	/**
	 * <p>
	 * Returns the URL endpoint which this client represents.
	 * </p>
	 *
	 * @return the URL endpoint for this client
	 */
	public String getUrl() {
		return getBaseUrl();
	}

}
