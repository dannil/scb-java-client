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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.dannil.scbjavaclient.client.environment.EnvironmentClient;
import com.github.dannil.scbjavaclient.client.population.PopulationClient;
import com.github.dannil.scbjavaclient.exception.SCBClientUrlNotFoundException;
import com.github.dannil.scbjavaclient.utility.JsonUtility;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;
import com.github.dannil.scbjavaclient.utility.URLUtility;
import com.github.dannil.scbjavaclient.utility.requester.AbstractRequester;
import com.github.dannil.scbjavaclient.utility.requester.RequestMethod;
import com.github.dannil.scbjavaclient.utility.requester.RequesterFactory;

/**
 * Root client for the client hierarchy.
 * 
 * @author Daniel Nilsson
 */
public class SCBClient extends AbstractContainerClient {

	private PopulationClient populationClient;

	private EnvironmentClient environmentClient;

	/**
	 * Default constructor. Initializes values and creates sub-clients.
	 */
	public SCBClient() {
		super();

		this.populationClient = new PopulationClient();
		super.clients.add(this.populationClient);

		this.environmentClient = new EnvironmentClient();
		super.clients.add(this.environmentClient);
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param locale
	 *            the locale for this client
	 */
	public SCBClient(Locale locale) {
		this();

		super.setLocale(locale);
	}

	/**
	 * Retrieve the client for interacting with environment data.
	 * 
	 * @return a client for environment data
	 */
	public EnvironmentClient environment() {
		return this.environmentClient;
	}

	/**
	 * Retrieve the client for interacting with population data.
	 * 
	 * @return a client for population data
	 */
	public PopulationClient population() {
		return this.populationClient;
	}

	/**
	 * <p>
	 * Fetch the JSON response from the specified table. As opposed to
	 * {@link #getRawData(String, Map)}, this method fetches all available data and therefore
	 * doesn't support selecting specific values before calling the API.
	 * </p>
	 * 
	 * <p>
	 * Do note: as this method matches all content codes available on the API, the response is
	 * likely to be several times larger than the response when selecting values.
	 * </p>
	 * 
	 * @param table
	 *            the table to fetch data from
	 * @return a JSON string containing all available data in the specified table
	 */
	public String getRawData(String table) {
		String json = super.get(table);

		Map<String, Collection<?>> inputs = new HashMap<String, Collection<?>>();
		JsonNode node = JsonUtility.getNode(json, "variables");
		for (int i = 0; i < node.size(); i++) {
			JsonNode child = node.get(i);
			if (child.get("code").asText().equals("ContentsCode")) {
				JsonNode values = child.get("values");
				List<String> valueTexts = new ArrayList<String>(values.size());
				for (int j = 0; j < values.size(); j++) {
					valueTexts.add(values.get(j).asText());
				}
				inputs.put("ContentsCode", valueTexts);
				break;
			}
		}
		return getRawData(table, inputs);
	}

	/**
	 * Fetch the JSON response from the specified table. Useful if you're only interested in the raw
	 * JSON data.
	 * 
	 * @param table
	 *            the table to fetch data from
	 * @param query
	 *            the selected values
	 * @return a JSON string
	 */
	public String getRawData(String table, Map<String, Collection<?>> query) {
		return super.post(table, QueryBuilder.build(query));
	}

	/**
	 * Checks if the specified locale is supported by the SCB API.
	 * 
	 * @param locale
	 *            the locale to check
	 * @return true if the locale is supported, otherwise false
	 */
	public static boolean isSupportedLocale(Locale locale) {
		String url = URLUtility.changeLanguageForUrl(ROOT_URL + locale.getLanguage(), locale);

		AbstractRequester get = RequesterFactory.getRequester(RequestMethod.GET);
		try {
			get.getBodyAsString(url);
			return true;
		} catch (SCBClientUrlNotFoundException e) {
			return false;
		}
	}

}
