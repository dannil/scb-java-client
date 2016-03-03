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

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractContainerClient;
import com.github.dannil.scbjavaclient.client.population.demography.DemographyClient;
import com.github.dannil.scbjavaclient.client.population.statistic.StatisticClient;
import com.github.dannil.scbjavaclient.model.population.NumberOfChildrenBornWithFirstName;
import com.github.dannil.scbjavaclient.utility.JsonUtility;
import com.github.dannil.scbjavaclient.utility.ListUtility;

/**
 * Client which handles population data fetching.
 * 
 * @author Daniel Nilsson
 */
public class PopulationClient extends AbstractContainerClient {

	private DemographyClient demographyClient;
	private StatisticClient statisticClient;

	/**
	 * Default constructor. Initializes values and creates sub-clients.
	 */
	public PopulationClient() {
		super();

		this.demographyClient = new DemographyClient();
		super.clients.add(this.demographyClient);

		this.statisticClient = new StatisticClient();
		super.clients.add(this.statisticClient);
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
	public DemographyClient demography() {
		return this.demographyClient;
	}

	/**
	 * Retrieve the client for interacting with population statistic data.
	 * 
	 * @return a client for population statistic data
	 */
	public StatisticClient statistic() {
		return this.statisticClient;
	}

	public List<NumberOfChildrenBornWithFirstName> getNumberOfChildrenBornWithFirstName() {
		return this.getNumberOfChildrenBornWithFirstName(null, null);
	}

	public List<NumberOfChildrenBornWithFirstName> getNumberOfChildrenBornWithFirstName(Collection<String> firstnames,
			Collection<Integer> years) {
		Map<String, Collection<?>> mappings = new HashMap<String, Collection<?>>();
		mappings.put("ContentsCode", ListUtility.toList("BE0001AH"));
		mappings.put("Tilltalsnamn", firstnames);
		mappings.put("Tid", years);

		String response = super.post("BE/BE0001/BE0001T04Ar", super.queryBuilder.build(mappings));

		return JsonUtility
				.nodeToList(NumberOfChildrenBornWithFirstName.class, JsonUtility.toConventionalJson(response));
	}

}
