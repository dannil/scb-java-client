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

package com.github.dannil.scbjavaclient.client.population.statistic;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.model.population.statistic.AverageAge;
import com.github.dannil.scbjavaclient.model.population.statistic.LiveBirth;
import com.github.dannil.scbjavaclient.model.population.statistic.Population;
import com.github.dannil.scbjavaclient.utility.JsonUtility;
import com.github.dannil.scbjavaclient.utility.ListUtility;

/**
 * Client which handles population statistic data fetching.
 * 
 * @author Daniel Nilsson
 */
public class PopulationStatisticsClient extends AbstractClient {

	/**
	 * Default constructor.
	 */
	public PopulationStatisticsClient() {
		super();
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param locale
	 *            the locale for this client
	 */
	public PopulationStatisticsClient(Locale locale) {
		super(locale);
	}

	// public List<String> getRegions() {
	// return super.getRegions(getUrl());
	// }

	// public List<Integer> getYears() {
	// List<String> fetchedYears = super.getYears(getUrl());
	//
	// List<Integer> years = new ArrayList<Integer>(fetchedYears.size());
	// for (String fetchedYear : fetchedYears) {
	// years.add(Integer.valueOf(fetchedYear));
	// }
	// return years;
	// }

	public List<AverageAge> getAverageAge() {
		return this.getAverageAge(null, null, null);
	}

	public List<AverageAge> getAverageAge(Collection<String> regions, Collection<String> genders,
			Collection<Integer> years) {
		Map<String, Collection<?>> mappings = new HashMap<String, Collection<?>>();
		mappings.put("ContentsCode", ListUtility.toList("BE0101G9"));
		mappings.put("Region", regions);
		mappings.put("Kon", genders);
		mappings.put("Tid", years);

		String response = super.post("BE/BE0101/BE0101B/BefolkningMedelAlder", super.queryBuilder.build(mappings));

		return JsonUtility.jsonToListOf(response, AverageAge.class);
	}

	/**
	 * Fetch all live births data.
	 * 
	 * @return the live births data wrapped in a list of
	 *         {@link com.github.dannil.scbjavaclient.model.population.statistic.LiveBirth
	 *         LiveBirth} objects
	 * 
	 * @see PopulationStatisticsClient#getLiveBirths(Collection, Collection, Collection, Collection)
	 */
	public List<LiveBirth> getLiveBirths() {
		return this.getLiveBirths(null, null, null, null);
	}

	/**
	 * Fetch all live births data which match the input constraints.
	 * 
	 * @param regions
	 *            the regions to fetch data for
	 * @param motherAges
	 *            the mothers' ages to fetch data for
	 * @param genders
	 *            the genders to fetch data for
	 * @param years
	 *            the years to fetch data for
	 * 
	 * @return the live births data wrapped in a list of
	 *         {@link com.github.dannil.scbjavaclient.model.population.statistic.LiveBirth
	 *         LiveBirth} objects
	 */
	public List<LiveBirth> getLiveBirths(Collection<String> regions, Collection<String> motherAges,
			Collection<Integer> genders, Collection<Integer> years) {
		Map<String, Collection<?>> mappings = new HashMap<String, Collection<?>>();
		mappings.put("ContentsCode", ListUtility.toList("BE0101E2"));
		mappings.put("Region", regions);
		mappings.put("AlderModer", motherAges);
		mappings.put("Kon", genders);
		mappings.put("Tid", years);

		String response = super.post("BE/BE0101/BE0101H/FoddaK", super.queryBuilder.build(mappings));

		return JsonUtility.jsonToListOf(response, LiveBirth.class);
	}

	/**
	 * Fetch all population data data.
	 * 
	 * @return the population data wrapped in a list of
	 *         {@link com.github.dannil.scbjavaclient.model.population.statistic.Population
	 *         Population} objects
	 * 
	 * @see PopulationStatisticsClient#getPopulation(Collection, Collection, Collection, Collection,
	 *      Collection)
	 */
	public List<Population> getPopulation() {
		return this.getPopulation(null, null, null, null, null);
	}

	/**
	 * Fetch all population data which match the input constraints.
	 * 
	 * @param regions
	 *            the regions to fetch data for
	 * @param relationshipStatuses
	 *            the relationship statuses to fetch data for
	 * @param ages
	 *            the ages to fetch data for
	 * @param genders
	 *            the genders to fetch data for
	 * @param years
	 *            the years to fetch data for
	 * 
	 * @return the population data wrapped in a list of
	 *         {@link com.github.dannil.scbjavaclient.model.population.statistic.Population
	 *         Population} objects
	 */
	public List<Population> getPopulation(Collection<String> regions, Collection<String> relationshipStatuses,
			Collection<String> ages, Collection<Integer> genders, Collection<Integer> years) {
		Map<String, Collection<?>> mappings = new HashMap<String, Collection<?>>();
		mappings.put("ContentsCode", ListUtility.toList("BE0101N1"));
		mappings.put("Region", regions);
		mappings.put("Civilstand", relationshipStatuses);
		mappings.put("Alder", ages);
		mappings.put("Kon", genders);
		mappings.put("Tid", years);

		String response = super.post("BE/BE0101/BE0101A/BefolkningNy", super.queryBuilder.build(mappings));

		return JsonUtility.jsonToListOf(response, Population.class);
	}

}
