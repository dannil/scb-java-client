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

package com.github.dannil.scbjavaclient.client.population;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.population.demography.PopulationDemographyClient;
import com.github.dannil.scbjavaclient.client.population.name.PopulationNameStatisticsClient;
import com.github.dannil.scbjavaclient.client.population.statistic.PopulationStatisticsClient;

/**
 * Client which handles population data fetching.
 * 
 * @author Daniel Nilsson
 */
public class PopulationClient extends AbstractContainerClient {

	private PopulationDemographyClient populationDemographyClient;
	private PopulationNameStatisticsClient populationNameStatisticsClient;
	private PopulationStatisticsClient populationStatisticsClient;

	/**
	 * Default constructor. Initializes values and creates sub-clients.
	 */
	public PopulationClient() {
		super();

		this.populationDemographyClient = new PopulationDemographyClient();
		super.clients.add(this.populationDemographyClient);

		this.populationStatisticsClient = new PopulationStatisticsClient();
		super.clients.add(this.populationStatisticsClient);

		this.populationNameStatisticsClient = new PopulationNameStatisticsClient();
		super.clients.add(this.populationNameStatisticsClient);
	}

	/**
	 * Overloaded constructor
	 * 
	 * @param locale
	 *            the locale for this client
	 */
	public PopulationClient(Locale locale) {
		this();

		super.setLocale(locale);
	}

	/**
	 * Retrieve the client for interacting with population demography data.
	 * 
	 * @return a client for population demography data
	 */
	public PopulationDemographyClient demography() {
		return this.populationDemographyClient;
	}

	/**
	 * Retrieve the client for interacting with population statistic data.
	 * 
	 * @return a client for population statistic data
	 */
	public PopulationStatisticsClient statistic() {
		return this.populationStatisticsClient;
	}

	/**
	 * Retrieve the client for interacting with population name statistic data.
	 * 
	 * @return a client for population statistic data
	 */
	public PopulationNameStatisticsClient nameStatistics() {
		return this.populationNameStatisticsClient;
	}

}
