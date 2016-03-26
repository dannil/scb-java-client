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

import java.util.Collection;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.environment.EnvironmentClient;
import com.github.dannil.scbjavaclient.client.population.PopulationClient;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

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

}
