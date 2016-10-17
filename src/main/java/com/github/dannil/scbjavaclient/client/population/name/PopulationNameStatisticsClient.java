/*
 * Copyright 2016 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.population.name;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.model.population.name.NumberOfChildrenBornWithFirstName;
import com.github.dannil.scbjavaclient.utility.JsonUtility;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * Client which handles population name statistics data fetching.
 * 
 * @author Daniel Nilsson
 */
public class PopulationNameStatisticsClient extends AbstractClient {

	/**
	 * Default constructor.
	 */
	public PopulationNameStatisticsClient() {
		super();
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param locale
	 *            the locale for this client
	 */
	public PopulationNameStatisticsClient(Locale locale) {
		super(locale);
	}

	/**
	 * Fetch all number of children born with first name data.
	 * 
	 * @return the number of children born with first name data wrapped in a list of
	 *         {@link com.github.dannil.scbjavaclient.model.population.name.NumberOfChildrenBornWithFirstName
	 *         NumberOfChildrenBornWithFirstName} objects
	 * 
	 * @see PopulationNameStatisticsClient#getNumberOfChildrenBornWithFirstName(Collection,
	 *      Collection)
	 */
	public List<NumberOfChildrenBornWithFirstName> getNumberOfChildrenBornWithFirstName() {
		return this.getNumberOfChildrenBornWithFirstName(null, null);
	}

	/**
	 * Fetch number of children born with first name data which match the input constraints.
	 * 
	 * @param firstnames
	 *            the firstnames to fetch data for
	 * @param years
	 *            the years to fetch data for
	 * @return the number of children born with first name data wrapped in a list of
	 *         {@link com.github.dannil.scbjavaclient.model.population.name.NumberOfChildrenBornWithFirstName
	 *         NumberOfChildrenBornWithFirstName} objects
	 */
	public List<NumberOfChildrenBornWithFirstName> getNumberOfChildrenBornWithFirstName(Collection<String> firstnames,
			Collection<Integer> years) {
		Map<String, Collection<?>> mappings = new HashMap<String, Collection<?>>();
		mappings.put("ContentsCode", Arrays.asList("BE0001AH"));
		mappings.put("Tilltalsnamn", firstnames);
		mappings.put("Tid", years);

		String response = super.post("BE/BE0001/BE0001T04Ar", QueryBuilder.build(mappings));

		return JsonUtility.jsonToListOf(response, NumberOfChildrenBornWithFirstName.class);
	}

	@Override
	public String getUrl() {
		return super.getUrl() + "BE/BE0001/";
	}

}
