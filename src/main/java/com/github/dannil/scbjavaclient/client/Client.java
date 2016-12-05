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
 * <p>Class which specifies how clients should operate.</p>
 * 
 * @author Daniel Nilsson
 */
public class Client {

	private static final Logger LOGGER = LogManager.getLogger(Client.class);

	protected Locale locale;

	protected Localization localization;

	/**
	 * <p>Default constructor.</p>
	 */
	protected Client() {
		this.locale = Locale.getDefault();
		this.localization = new Localization(this.locale);
	}

	/**
	 * <p>Overloaded constructor.</p>
	 * 
	 * @param locale
	 *            the <code>Locale</code> for this client
	 */
	protected Client(Locale locale) {
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
	 * <p>Changes the <code>Locale</code> used for the localization. Useful if the client
	 * needs to be in a different language than the error messages.</p>
	 * 
	 * @param locale
	 *            the <code>Locale</code> for the localization
	 */
	public void setLocalizationLocale(Locale locale) {
		this.localization.setLocale(locale);
	}

	/**
	 * <p>Determines the base URL for the API based on the current
	 * <code>Locale</code>.</p>
	 * 
	 * @return the URL representing the entry point for the API
	 */
	protected String getBaseUrl() {
		// return ROOT_URL + this.locale.getLanguage() + "/ssd/";
		return URLUtility.getRootUrl(this.locale);
	}

	/**
	 * <p>Performs a GET request to the specified table.</p>
	 * 
	 * @param table
	 *            the table which will be sent a GET request
	 * @return a string representation of the API's response
	 */
	protected String get(String table) {
		String url = getBaseUrl() + table;

		AbstractRequester get = RequesterFactory.getRequester(RequestMethod.GET);
		try {
			return get.getBodyAsString(url);
		} catch (SCBClientUrlNotFoundException e) {
			// HTTP code 404, call the API again with the fallback language
			return get.getBodyAsString(URLUtility.changeLanguageForUrl(url));
		}
	}

	/**
	 * <p>Performs a POST request to the specified table.</p>
	 * 
	 * @param table
	 *            the table which will be sent a POST request
	 * @param query
	 *            the query which the API will process
	 * @return a string representation of the API's response
	 */
	protected String post(String table, String query) {
		String url = getBaseUrl() + table;

		POSTRequester post = (POSTRequester) RequesterFactory.getRequester(RequestMethod.POST);
		post.setQuery(query);
		try {
			LOGGER.info(query);
			return post.getBodyAsString(url);
		} catch (SCBClientUrlNotFoundException e) {
			// HTTP code 404, call the API again with the fallback language
			return post.getBodyAsString(URLUtility.changeLanguageForUrl(url));
		}
	}

	/**
	 * <p>Returns the list of the available regions for a given table.</p>
	 * 
	 * @param table
	 *            the table to retrieve the regions from
	 * @return a list of the available regions for the given table or null if the table
	 *         doesn't have regions
	 */
	public List<String> getRegions(String table) {
		String json = get(table);
		String code = "Region";

		JsonAPITableFormat format = new JsonAPITableFormat(json);
		return format.getValues(code);

		// String json = get(table);
		// String code = "Region";
		// try {
		// JsonAPITableFormat format = new JsonAPITableFormat(json);
		// System.out.println(format);
		// return format.getValues(code);
		// } catch (IllegalArgumentException e) {
		// Object[] variables = new Object[] { code, table };
		// throw new
		// IllegalArgumentException(this.localization.getString("code_is_not_supported_for_url",
		// variables),
		// e);
		// }
	}

	/**
	 * <p>Returns the list of the available years for a given table.</p>
	 * 
	 * @param table
	 *            the table to retrieve the years from
	 * @return a list of the available years for the given table or null if the table
	 *         doesn't have years
	 */
	public List<String> getYears(String table) {
		String json = get(table);
		String code = "Tid";

		JsonAPITableFormat format = new JsonAPITableFormat(json);
		return format.getValues(code);

		// String json = get(table);
		// String code = "Tid";
		// try {
		// JsonAPITableFormat format = new JsonAPITableFormat(json);
		// return format.getValues(code);
		// } catch (IllegalArgumentException e) {
		// Object[] variables = new Object[] { code, table };
		// throw new
		// IllegalArgumentException(this.localization.getString("code_is_not_supported_for_url",
		// variables),
		// e);
		// }
	}

	// private void validateLocale() {
	// if (!isSupportedLocale(this.locale)) {
	// throw new SCBClientException("Locale " + this.locale + " is not supported
	// by the API");
	// }
	// }

	/**
	 * <p>Returns the URL endpoint which this client represents.</p>
	 *
	 * @return the URL endpoint for this client
	 */
	public String getUrl() {
		return getBaseUrl();
	}

}
