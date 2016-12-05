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

package com.github.dannil.scbjavaclient.client.population.amount;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.Client;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.population.amount.Population;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles population amount data fetching.</p>
 * 
 * @author Daniel Nilsson
 */
public class PopulationAmountClient extends Client {

	/**
	 * <p>Default constructor.</p>
	 */
	public PopulationAmountClient() {
		super();
	}

	/**
	 * <p>Overloaded constructor.</p>
	 * 
	 * @param locale
	 *            the <code>Locale</code> for this client
	 */
	public PopulationAmountClient(Locale locale) {
		super(locale);
	}

	/**
	 * <p>Fetch all population amount data.</p>
	 * 
	 * @return the population amount data wrapped in a list of
	 *         {@link com.github.dannil.scbjavaclient.model.population.amount.Population
	 *         Population} objects
	 * 
	 * @see #getPopulation(Collection, Collection, Collection, Collection, Collection)
	 */
	public List<Population> getPopulation() {
		return getPopulation(null, null, null, null, null);
	}

	/**
	 * <p>Fetch all population amount data which match the input constraints.</p>
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
	 * @return the population amount data wrapped in a list of
	 *         {@link com.github.dannil.scbjavaclient.model.population.amount.Population
	 *         Population} objects
	 */
	public List<Population> getPopulation(Collection<String> regions, Collection<String> relationshipStatuses,
			Collection<String> ages, Collection<Integer> genders, Collection<Integer> years) {
		Map<String, Collection<?>> mappings = new HashMap<String, Collection<?>>();
		mappings.put("ContentsCode", Arrays.asList("BE0101N1", "BE0101N2"));
		mappings.put("Region", regions);
		mappings.put("Civilstand", relationshipStatuses);
		mappings.put("Alder", ages);
		mappings.put("Kon", genders);
		mappings.put("Tid", years);

		String response = super.post("BE/BE0101/BE0101A/BefolkningNy", QueryBuilder.build(mappings));

		JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
		return format.toListOf(Population.class);
	}

	@Override
	public String getUrl() {
		return super.getUrl() + "BE/BE0101/BE0101A/";
	}

}
