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

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.test.model.RemoteIntegrationTestSuite;

@RunWith(JUnit4.class)
public class PopulationStatisticsClient_IntegrationTest extends RemoteIntegrationTestSuite {

	private PopulationStatisticsClient populationStatisticsClient;

	@Before
	public void setup() {
		this.populationStatisticsClient = new SCBClient().population().statistics();
	}

	// TODO Enable tests in the future

	// @Test
	// public  void getRegions() {
	// assertNotEquals(0, this.statisticsClient.getRegions().size());
	// }

	// @Test
	// public  void getYears() {
	// assertNotEquals(0, this.statisticsClient.getYears().size());
	// }

	@Test
	public void getAverageAge() {
		assertNotEquals(0, this.populationStatisticsClient.getAverageAge().size());
	}

	@Test
	public void getAverageAgeWithParameters() {
		List<String> regions = Arrays.asList("1263");
		List<String> genders = Arrays.asList("1", "2", "1+2");
		List<Integer> years = Arrays.asList(2002);

		assertNotEquals(0, this.populationStatisticsClient.getAverageAge(regions, genders, years).size());
	}

	@Test
	public void getLiveBirths() {
		assertNotEquals(0, this.populationStatisticsClient.getLiveBirths().size());
	}

	@Test
	public void getLiveBirthsWithParameters() {
		List<String> regions = Arrays.asList("1263");
		List<String> motherAges = Arrays.asList("tot");
		List<Integer> genders = Arrays.asList(1, 2);
		List<Integer> years = Arrays.asList(1996);

		assertNotEquals(0, this.populationStatisticsClient.getLiveBirths(regions, motherAges, genders, years).size());
	}

	@Test
	public void getPopulation() {
		assertNotEquals(0, this.populationStatisticsClient.getPopulation().size());
	}

	@Test
	public void getPopulationWithParameters() {
		List<String> regions = Arrays.asList("1263");
		List<String> statuses = Arrays.asList("OG", "G", "SK", "ÄNKL");
		List<String> ages = Arrays.asList("25");
		List<Integer> genders = Arrays.asList(1, 2);
		List<Integer> years = Arrays.asList(1996);

		assertNotEquals(0, this.populationStatisticsClient.getPopulation(regions, statuses, ages, genders, years)
				.size());
	}

}
