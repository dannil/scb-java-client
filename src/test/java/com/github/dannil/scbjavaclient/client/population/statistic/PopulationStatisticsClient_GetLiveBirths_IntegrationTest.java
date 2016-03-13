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

package com.github.dannil.scbjavaclient.client.population.statistic;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.test.model.RemoteIntegrationTestSuite;
import com.github.dannil.scbjavaclient.utility.ListUtility;

@RunWith(Parameterized.class)
public class PopulationStatisticsClient_GetLiveBirths_IntegrationTest extends RemoteIntegrationTestSuite {

	private List<String> regions;
	private List<String> motherAges;
	private List<Integer> genders;
	private List<Integer> years;

	private PopulationStatisticsClient statisticsClient;

	@Parameters(name = "{index}: getLiveBirths({0}, {1}, {2}, {3})")
	public static Collection<Object[]> data() {
		List<String> regions;
		List<String> motherAges;
		List<Integer> genders;
		List<Integer> years;

		regions = new ArrayList<String>();
		regions.add("1263");
		regions.add(null);

		motherAges = new ArrayList<String>();
		motherAges.add("tot");
		motherAges.add(null);

		genders = Arrays.asList(new Integer[] { 1, 2 });

		years = new ArrayList<Integer>();
		years.add(1996);
		years.add(null);

		List<Object[]> parameters = new ArrayList<Object[]>();

		// Test with real data
		for (String region : regions) {
			for (String motherAge : motherAges) {
				for (Integer gender : genders) {
					for (Integer year : years) {
						parameters.add(new Object[] { ListUtility.toList(region), ListUtility.toList(motherAge),
								ListUtility.toList(gender), ListUtility.toList(year) });
					}
				}
			}
		}

		// Special case: test with everything null
		parameters.add(new Object[] { null, null, null, null });

		// Special case: test with everything at once
		parameters.add(new Object[] { regions, motherAges, genders, years });

		return parameters;
	}

	private PopulationStatisticsClient_GetLiveBirths_IntegrationTest() {
		this.statisticsClient = new SCBClient().population().statistics();
	}

	public PopulationStatisticsClient_GetLiveBirths_IntegrationTest(List<String> regions, List<String> motherAges,
			List<Integer> genders, List<Integer> years) {
		this();

		this.regions = regions;
		this.motherAges = motherAges;
		this.genders = genders;
		this.years = years;
	}

	@Test
	public void getLiveBirths() {
		assertNotEquals(0, this.statisticsClient.getLiveBirths(this.regions, this.motherAges, this.genders, this.years)
				.size());
	}

}
