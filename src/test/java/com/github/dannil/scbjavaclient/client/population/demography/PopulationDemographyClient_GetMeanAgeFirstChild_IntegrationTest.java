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

package com.github.dannil.scbjavaclient.client.population.demography;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.test.model.RemoteIntegrationTestSuite;
import com.github.dannil.scbjavaclient.utility.ListUtility;

@RunWith(Parameterized.class)
public class PopulationDemographyClient_GetMeanAgeFirstChild_IntegrationTest extends RemoteIntegrationTestSuite {

	private List<String> regions;
	private List<Integer> genders;
	private List<Integer> years;

	private PopulationDemographyClient populationDemographyClient;

	@Parameters(name = "{index}: getMeanAgeFirstChild({0}, {1}, {2})")
	public static Collection<Object[]> data() {
		List<String> regions;
		List<Integer> genders;
		List<Integer> years;

		regions = new ArrayList<String>();
		regions.add("1263");
		regions.add(null);

		genders = Arrays.asList(new Integer[] { 1, 2 });

		years = new ArrayList<Integer>();
		years.add(2002);
		years.add(null);

		List<Object[]> parameters = new ArrayList<Object[]>();

		// Test with real data
		for (String region : regions) {
			for (Integer gender : genders) {
				for (Integer year : years) {
					parameters.add(new Object[] { ListUtility.toList(region), ListUtility.toList(gender),
							ListUtility.toList(year) });
				}
			}
		}

		// Special case: test with everything null
		parameters.add(new Object[] { null, null, null });

		// Special case: test with everything at once
		parameters.add(new Object[] { regions, genders, years });

		return parameters;
	}

	private PopulationDemographyClient_GetMeanAgeFirstChild_IntegrationTest() {
		this.populationDemographyClient = new SCBClient().population().demography();

		// Test PopulationDemographyClient with English locale
		Locale locale = new Locale("en", "US");
		this.populationDemographyClient.setLocale(locale);
	}

	public PopulationDemographyClient_GetMeanAgeFirstChild_IntegrationTest(List<String> regions, List<Integer> genders,
			List<Integer> years) {
		this();

		this.regions = regions;
		this.genders = genders;
		this.years = years;
	}

	@Test
	public void getMeanAgeFirstChild() {
		assertNotEquals(0, this.populationDemographyClient.getMeanAgeFirstChild(this.regions, this.genders, this.years).size());
	}

}
