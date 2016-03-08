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
import com.github.dannil.scbjavaclient.client.population.statistic.PopulationStatisticsClient;
import com.github.dannil.scbjavaclient.test.model.RemoteIntegrationTestSuite;
import com.github.dannil.scbjavaclient.utility.ListUtility;

@RunWith(Parameterized.class)
public class PopulationStatisticsClient_GetPopulation_IntegrationTest extends RemoteIntegrationTestSuite {

	private List<String> regions;
	private List<String> statuses;
	private List<String> ages;
	private List<Integer> genders;
	private List<Integer> years;

	private PopulationStatisticsClient statisticsClient;

	@Parameters(name = "{index}: getPopulation({0}, {1}, {2}, {3}, {4})")
	public static Collection<Object[]> data() {
		List<String> regions;
		List<String> statuses;
		List<String> ages;
		List<Integer> genders;
		List<Integer> years;

		regions = new ArrayList<String>();
		regions.add("1263");
		regions.add(null);

		statuses = Arrays.asList(new String[] { "OG", "G", "SK", "ÄNKL" });

		ages = new ArrayList<String>();
		ages.add("25");
		ages.add(null);

		genders = Arrays.asList(new Integer[] { 1, 2 });

		years = new ArrayList<Integer>();
		years.add(2002);
		years.add(null);

		List<Object[]> parameters = new ArrayList<Object[]>();

		// Test with real data
		for (String region : regions) {
			for (String status : statuses) {
				for (String age : ages) {
					for (Integer gender : genders) {
						for (Integer year : years) {
							parameters.add(new Object[] { ListUtility.toList(region), ListUtility.toList(status),
									ListUtility.toList(age), ListUtility.toList(gender), ListUtility.toList(year) });
						}
					}
				}
			}
		}

		// Special case: test with everything null
		parameters.add(new Object[] { null, null, null, null, null });

		// Special case: test with everything at once
		parameters.add(new Object[] { regions, statuses, ages, genders, years });

		return parameters;
	}

	private PopulationStatisticsClient_GetPopulation_IntegrationTest() {
		this.statisticsClient = new SCBClient().population().statistic();
	}

	public PopulationStatisticsClient_GetPopulation_IntegrationTest(List<String> regions, List<String> statuses, List<String> ages,
			List<Integer> genders, List<Integer> years) {
		this();

		this.regions = regions;
		this.statuses = statuses;
		this.ages = ages;
		this.genders = genders;
		this.years = years;
	}

	@Test
	public void getPopulation() {
		assertNotEquals(0,
				this.statisticsClient.getPopulation(this.regions, this.statuses, this.ages, this.genders, this.years)
						.size());
	}

}
