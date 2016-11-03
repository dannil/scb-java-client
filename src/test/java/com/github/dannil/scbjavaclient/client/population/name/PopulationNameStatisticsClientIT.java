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

import static org.junit.Assert.assertNotEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbjavaclient.client.SCBClient;

@RunWith(JUnit4.class)
public class PopulationNameStatisticsClientIT {

	private PopulationNameStatisticsClient populationNameStatisticsClient;

	@Before
	public void setup() {
		this.populationNameStatisticsClient = new SCBClient().population().nameStatistics();
	}

	@Test
	public void getNumberOfChildrenBornWithFirstName() {
		assertNotEquals(0, this.populationNameStatisticsClient.getNumberOfChildrenBornWithFirstName().size());
	}

	@Test
	public void getNumberOfChildrenBornWithFirstNameWithParameters() {
		List<String> firstnames = Arrays.asList("AdinaK");
		List<Integer> years = Arrays.asList(2002);

		assertNotEquals(0, this.populationNameStatisticsClient.getNumberOfChildrenBornWithFirstName(firstnames, years)
				.size());
	}

}
