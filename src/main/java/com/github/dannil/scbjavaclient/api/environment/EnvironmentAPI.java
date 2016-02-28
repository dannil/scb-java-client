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

package com.github.dannil.scbjavaclient.api.environment;

import java.util.Locale;

import com.github.dannil.scbjavaclient.api.AbstractContainerAPI;
import com.github.dannil.scbjavaclient.api.environment.landandwaterarea.LandAndWaterAreaAPI;

public class EnvironmentAPI extends AbstractContainerAPI {

	private LandAndWaterAreaAPI landAndWaterAreaApi;

	/**
	 * Default constructor. Initializes values and creates sub-clients.
	 */
	public EnvironmentAPI() {
		super();

		this.landAndWaterAreaApi = new LandAndWaterAreaAPI();
		super.apis.add(this.landAndWaterAreaApi);
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param locale
	 *            the locale for this client
	 */
	public EnvironmentAPI(Locale locale) {
		this();

		super.setLocale(locale);
	}

	/**
	 * Retrieve the client for interacting with land and water area data.
	 * 
	 * @return a client for land and water area data
	 */
	public LandAndWaterAreaAPI landAndWaterArea() {
		return this.landAndWaterAreaApi;
	}

}
