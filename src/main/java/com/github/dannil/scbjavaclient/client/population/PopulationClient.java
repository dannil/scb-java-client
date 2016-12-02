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

package com.github.dannil.scbjavaclient.client.population;

import java.util.Locale;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.population.amount.PopulationAmountClient;
import com.github.dannil.scbjavaclient.client.population.averageage.PopulationAverageAgeClient;
import com.github.dannil.scbjavaclient.client.population.demography.PopulationDemographyClient;
import com.github.dannil.scbjavaclient.client.population.density.PopulationDensityClient;
import com.github.dannil.scbjavaclient.client.population.livebirths.PopulationLiveBirthsClient;
import com.github.dannil.scbjavaclient.client.population.name.PopulationNameStatisticsClient;
import com.github.dannil.scbjavaclient.client.population.partnership.PopulationPartnershipClient;

/**
 * <p>Client which handles population data fetching.</p>
 * 
 * @author Daniel Nilsson
 */
public class PopulationClient extends AbstractContainerClient {

	// private PopulationAmountClient populationAmountClient;
	//
	// private PopulationAverageAgeClient populationAverageAgeClient;
	//
	// private PopulationDemographyClient populationDemographyClient;
	//
	// private PopulationDensityClient populationDensityClient;
	//
	// private PopulationLiveBirthsClient populationLiveBirthsClient;
	//
	// private PopulationNameStatisticsClient populationNameStatisticsClient;
	//
	// private PopulationPartnershipClient populationPartnershipClient;

	/**
	 * <p>Default constructor. Initializes values and creates sub-clients.</p>
	 */
	public PopulationClient() {
		super();

		super.clients.put("amount", new PopulationAmountClient());
		super.clients.put("averageage", new PopulationAverageAgeClient());
		super.clients.put("demography", new PopulationDemographyClient());
		super.clients.put("density", new PopulationDensityClient());
		super.clients.put("livebirths", new PopulationLiveBirthsClient());
		super.clients.put("namestatistics", new PopulationNameStatisticsClient());
		super.clients.put("partnership", new PopulationPartnershipClient());
	}

	/**
	 * <p>Overloaded constructor.</p>
	 * 
	 * @param locale
	 *            the <code>Locale</code> for this client
	 */
	public PopulationClient(Locale locale) {
		this();

		super.setLocale(locale);
	}

	/**
	 * <p>Retrieve the client for interacting with population amount data.</p>
	 * 
	 * @return a client for population amount data
	 */
	public PopulationAmountClient amount() {
		return (PopulationAmountClient) this.clients.get("amount");
	}

	/**
	 * <p>Retrieve the client for interacting with population average age data. </p>
	 * 
	 * @return a client for population amount data
	 */
	public PopulationAverageAgeClient averageAge() {
		return (PopulationAverageAgeClient) this.clients.get("averageage");
	}

	/**
	 * <p>Retrieve the client for interacting with population demography data. </p>
	 * 
	 * @return a client for population demography data
	 */
	public PopulationDemographyClient demography() {
		return (PopulationDemographyClient) this.clients.get("demography");
	}

	/**
	 * <p>Retrieve the client for interacting with population density data. </p>
	 * 
	 * @return a client for population density data
	 */
	public PopulationDensityClient density() {
		return (PopulationDensityClient) this.clients.get("density");
	}

	/**
	 * <p>Retrieve the client for interacting with population density data. </p>
	 * 
	 * @return a client for population density data
	 */
	public PopulationLiveBirthsClient liveBirths() {
		return (PopulationLiveBirthsClient) this.clients.get("livebirths");
	}

	/**
	 * <p>Retrieve the client for interacting with population name statistic data.</p>
	 * 
	 * @return a client for population name statistic data
	 */
	public PopulationNameStatisticsClient nameStatistics() {
		return (PopulationNameStatisticsClient) this.clients.get("namestatistics");
	}

	/**
	 * <p>Retrieve the client for interacting with population partnership data.</p>
	 * 
	 * @return a client for population name statistic data
	 */
	public PopulationPartnershipClient partnership() {
		return (PopulationPartnershipClient) this.clients.get("partnership");
	}

	@Override
	public String getUrl() {
		return super.getUrl() + "BE/";
	}

}
