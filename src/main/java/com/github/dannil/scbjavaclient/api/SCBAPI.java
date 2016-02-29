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

package com.github.dannil.scbjavaclient.api;

import java.util.Locale;

import com.github.dannil.scbjavaclient.api.environment.EnvironmentAPI;
import com.github.dannil.scbjavaclient.api.population.PopulationAPI;

/**
 * Root client for the client hierarchy.
 * 
 * @author Daniel Nilsson
 */
public class SCBAPI extends AbstractContainerAPI {

	private PopulationAPI populationApi;
	private EnvironmentAPI environmentApi;

	/**
	 * Default constructor. Initializes values and creates sub-clients.
	 */
	public SCBAPI() {
		super();

		this.populationApi = new PopulationAPI();
		super.apis.add(this.populationApi);

		this.environmentApi = new EnvironmentAPI();
		super.apis.add(this.environmentApi);
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param locale
	 *            the locale for this client
	 */
	public SCBAPI(Locale locale) {
		this();

		super.setLocale(locale);
	}

	/**
	 * Retrieve the client for interacting with environment data.
	 * 
	 * @return a client for environment data
	 */
	public EnvironmentAPI environment() {
		return this.environmentApi;
	}

	/**
	 * Retrieve the client for interacting with population data.
	 * 
	 * @return a client for population data
	 */
	public PopulationAPI population() {
		return this.populationApi;
	}

}
