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

package com.github.dannil.scbjavaclient.client.environment.landandwaterarea;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.model.environment.landandwaterarea.Area;
import com.github.dannil.scbjavaclient.utility.JsonUtility;
import com.github.dannil.scbjavaclient.utility.ListUtility;

/**
 * Client which handles environment land and water area data fetching.
 * 
 * @author Daniel Nilsson
 */
public class EnvironmentLandAndWaterAreaClient extends AbstractClient {

	/**
	 * Default constructor.
	 */
	public EnvironmentLandAndWaterAreaClient() {
		super();
	}

	/**
	 * Overloaded constructor.
	 * 
	 * @param locale
	 *            the locale for this client
	 */
	public EnvironmentLandAndWaterAreaClient(Locale locale) {
		super(locale);
	}

	// public Collection<String> getRegions() {
	// return super.getRegions(getUrl());
	// }
	//
	// public Collection<Integer> getYears() {
	// Collection<String> fetchedYears = super.getYears(getUrl());
	//
	// Collection<Integer> years = new ArrayCollection<Integer>(fetchedYears.size());
	// for (String fetchedYear : fetchedYears) {
	// years.add(Integer.valueOf(fetchedYear));
	// }
	// return years;
	// }

	/**
	 * Fetch all area data.
	 * 
	 * @return the area data wrapped in a list of
	 *         {@link com.github.dannil.scbjavaclient.model.environment.landandwaterarea.Area Area}
	 *         objects
	 * 
	 * @see EnvironmentLandAndWaterAreaClient#getArea(Collection, Collection, Collection)
	 */
	public List<Area> getArea() {
		return this.getArea(null, null, null);
	}

	/**
	 * Fetch all area data which match the input constraints.
	 * 
	 * @param regions
	 *            the regions to fetch data for
	 * @param types
	 *            the types to fetch data for
	 * @param years
	 *            the years to fetch data for
	 * @return the area data wrapped in a list of
	 *         {@link com.github.dannil.scbjavaclient.model.environment.landandwaterarea.Area Area}
	 *         objects
	 */
	public List<Area> getArea(Collection<String> regions, Collection<String> types, Collection<Integer> years) {
		Map<String, Collection<?>> mappings = new HashMap<String, Collection<?>>();
		mappings.put("ContentsCode", ListUtility.toList("MI0802AA"));
		mappings.put("Region", regions);
		mappings.put("ArealTyp", types);
		mappings.put("Tid", years);

		String response = super.post("MI/MI0802/Areal2012", super.queryBuilder.build(mappings));

		return JsonUtility.jsonToListOf(response, Area.class);
	}

}
