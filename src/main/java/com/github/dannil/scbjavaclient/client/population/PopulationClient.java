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
 * <p>
 * Client which handles population data fetching.
 * </p>
 * 
 * @author Daniel Nilsson
 */
public class PopulationClient extends AbstractContainerClient {

	private PopulationDemographyClient populationDemographyClient;

	private PopulationNameStatisticsClient populationNameStatisticsClient;

	private PopulationStatisticsClient populationStatisticsClient;

	/**
	 * <p>
	 * Default constructor. Initializes values and creates sub-clients.
	 * </p>
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
	 * <p>
	 * Overloaded constructor.
	 * </p>
	 * 
	 * @param locale
	 *            the <code>Locale</code> for this client
	 */
	public PopulationClient(Locale locale) {
		this();

		super.setLocale(locale);
	}

	/**
	 * <p>
	 * Retrieve the client for interacting with population demography data.
	 * </p>
	 * 
	 * @return a client for population demography data
	 */
	public PopulationDemographyClient demography() {
		return this.populationDemographyClient;
	}

	/**
	 * <p>
	 * Retrieve the client for interacting with population statistic data.
	 * </p>
	 * 
	 * @return a client for population statistics data
	 */
	public PopulationStatisticsClient statistics() {
		return this.populationStatisticsClient;
	}

	/**
	 * <p>
	 * Retrieve the client for interacting with population name statistic data.
	 * </p>
	 * 
	 * @return a client for population statistic data
	 */
	public PopulationNameStatisticsClient nameStatistics() {
		return this.populationNameStatisticsClient;
	}

	@Override
	public String getUrl() {
		return super.getUrl() + "BE/";
	}

}
