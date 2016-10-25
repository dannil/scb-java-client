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

package com.github.dannil.scbjavaclient.client.environment;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.environment.landandwaterarea.EnvironmentLandAndWaterAreaClient;

/**
 * Client which handles environment data fetching.
 * 
 * @author Daniel Nilsson
 */
public class EnvironmentClient extends AbstractContainerClient {

	private EnvironmentLandAndWaterAreaClient environmentLandAndWaterAreaClient;

	/**
	 * Default constructor. Initializes values and creates sub-clients.
	 */
	public EnvironmentClient() {
		super();

		this.environmentLandAndWaterAreaClient = new EnvironmentLandAndWaterAreaClient();
		super.clients.add(this.environmentLandAndWaterAreaClient);
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param locale
	 *            the locale for this client
	 */
	public EnvironmentClient(Locale locale) {
		this();

		super.setLocale(locale);
	}

	/**
	 * Retrieve the client for interacting with environment land and water area data.
	 * 
	 * @return a client for environment land and water area data
	 */
	public EnvironmentLandAndWaterAreaClient landAndWaterArea() {
		return this.environmentLandAndWaterAreaClient;
	}

	@Override
	public String getUrl() {
		return super.getUrl() + "MI/";
	}

}
