/*
 * Copyright 2016 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.client.population.density;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.client.AbstractClient;
import com.github.dannil.scbjavaclient.format.json.JsonCustomResponseFormat;
import com.github.dannil.scbjavaclient.model.population.density.Density;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * <p>Client which handles population density data fetching.</p>
 * 
 * @author Daniel Nilsson
 */
public class PopulationDensityClient extends AbstractClient {

	/**
	 * <p>Default constructor.</p>
	 */
	public PopulationDensityClient() {
		super();
	}

	/**
	 * <p>Overloaded constructor.</p>
	 * 
	 * @param locale
	 *            the <code>Locale</code> for this client
	 */
	public PopulationDensityClient(Locale locale) {
		super(locale);
	}

	/**
	 * <p>Fetch all density data.</p>
	 * 
	 * @return the density data wrapped in a list of
	 *         {@link com.github.dannil.scbjavaclient.model.population.density.Density
	 *         Density} objects
	 * 
	 * @see #getDensity(Collection, Collection, Collection)
	 */
	public List<Density> getDensity() {
		return getDensity(null, null, null);
	}

	/**
	 * <p>Fetch all density data which match the input constraints.</p>
	 * 
	 * @param regions
	 *            the regions to fetch data for
	 * @param sexes
	 *            the sexes to fetch data for
	 * @param years
	 *            the years to fetch data for
	 * @return the density data wrapped in a list of
	 *         {@link com.github.dannil.scbjavaclient.model.population.density.Density
	 *         Density} objects
	 */
	public List<Density> getDensity(Collection<String> regions, Collection<String> sexes, Collection<Integer> years) {
		Map<String, Collection<?>> mappings = new HashMap<>();
		mappings.put("ContentsCode", Arrays.asList("BE0101U1", "BE0101U2", "BE0101U3"));
		mappings.put("Region", regions);
		mappings.put("Kon", sexes);
		mappings.put("Tid", years);

		String response = super.post("BE/BE0101/BE0101C/BefArealTathetKon", QueryBuilder.build(mappings));

		JsonCustomResponseFormat format = new JsonCustomResponseFormat(response);
		return format.toListOf(Density.class);
	}

	@Override
	public String getUrl() {
		return super.getUrl() + "BE/BE0101/BE0101C/";
	}

}
