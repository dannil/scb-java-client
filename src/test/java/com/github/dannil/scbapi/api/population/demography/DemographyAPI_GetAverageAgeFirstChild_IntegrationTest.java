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

package com.github.dannil.scbapi.api.population.demography;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.github.dannil.scbapi.api.SCBAPI;
import com.github.dannil.scbapi.test.utility.Config;
import com.github.dannil.scbapi.utility.ListUtility;

@RunWith(Parameterized.class)
public class DemographyAPI_GetAverageAgeFirstChild_IntegrationTest {

	private List<String> regions;
	private List<Integer> genders;
	private List<Integer> years;

	private DemographyAPI demographyAPI;

	@Parameters(name = "{index}: getAverageAgeFirstChild({0}, {1}, {2})")
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

	private DemographyAPI_GetAverageAgeFirstChild_IntegrationTest() {
		this.demographyAPI = new SCBAPI().population().demography();

		// Test DemographyAPI with English locale
		Locale locale = new Locale("en", "US");
		this.demographyAPI.setLocale(locale);
	}

	public DemographyAPI_GetAverageAgeFirstChild_IntegrationTest(List<String> regions, List<Integer> genders,
			List<Integer> years) {
		this();

		this.regions = regions;
		this.genders = genders;
		this.years = years;
	}

	@Before
	public void setup() throws InterruptedException {
		// Due to constraints set by SCB, we can only do 10 calls every 10
		// seconds, so we need an artificial timer which handles this.
		Thread.sleep(Config.getTimerMs());
	}

	@Test
	public void getAverageAgeFirstChild() {
		assertNotEquals(0, this.demographyAPI.getMeanAgeFirstChild(this.regions, this.genders, this.years).size());
	}

}
