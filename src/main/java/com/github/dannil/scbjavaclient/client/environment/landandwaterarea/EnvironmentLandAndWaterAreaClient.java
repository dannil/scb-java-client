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

package com.github.dannil.scbjavaclient.client.environment.landandwaterarea;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.Client;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.environment.landandwaterarea.Area;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles environment land and water area data fetching.</p>
 * 
 * @author Daniel Nilsson
 */
public class EnvironmentLandAndWaterAreaClient extends Client {

	/**
	 * <p>Default constructor.</p>
	 */
	public EnvironmentLandAndWaterAreaClient() {
		super();
	}

	/**
	 * <p>Overloaded constructor.</p>
	 * 
	 * @param locale
	 *            the <code>Locale</code> for this client
	 */
	public EnvironmentLandAndWaterAreaClient(Locale locale) {
		super(locale);
	}

	/**
	 * <p>Fetch all area data.</p>
	 * 
	 * @return the area data wrapped in a list of
	 *         {@link com.github.dannil.scbjavaclient.model.environment.landandwaterarea.Area
	 *         Area} objects
	 * 
	 * @see #getArea(Collection, Collection, Collection)
	 */
	public List<Area> getArea() {
		return getArea(null, null, null);
	}

	/**
	 * <p>Fetch all area data which match the input constraints.</p>
	 * 
	 * @param regions
	 *            the regions to fetch data for
	 * @param types
	 *            the types to fetch data for
	 * @param years
	 *            the years to fetch data for
	 * @return the area data wrapped in a list of
	 *         {@link com.github.dannil.scbjavaclient.model.environment.landandwaterarea.Area
	 *         Area} objects
	 */
	public List<Area> getArea(Collection<String> regions, Collection<String> types, Collection<Integer> years) {
		Map<String, Collection<?>> mappings = new HashMap<String, Collection<?>>();
		mappings.put("ContentsCode", Arrays.asList("MI0802AA"));
		mappings.put("Region", regions);
		mappings.put("ArealTyp", types);
		mappings.put("Tid", years);

		String response = super.post("MI/MI0802/Areal2012", QueryBuilder.build(mappings));

		JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
		return format.toListOf(Area.class);
	}

	@Override
	public String getUrl() {
		return super.getUrl() + "MI/MI0802/";
	}
}
