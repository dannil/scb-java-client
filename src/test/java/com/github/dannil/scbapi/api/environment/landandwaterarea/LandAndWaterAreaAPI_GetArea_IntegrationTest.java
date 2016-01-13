/*
Copyright 2014 Daniel Nilsson

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

package com.github.dannil.scbapi.api.environment.landandwaterarea;

import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.github.dannil.scbapi.api.SCBAPI;
import com.github.dannil.scbapi.model.environment.Type;
import com.github.dannil.scbapi.test.utility.Config;
import com.github.dannil.scbapi.utility.ListUtility;

@RunWith(Parameterized.class)
public class LandAndWaterAreaAPI_GetArea_IntegrationTest {

	private List<String> regions;
	private List<Type> types;
	private List<Integer> years;

	private LandAndWaterAreaAPI landAndWaterAreaAPI;

	@Parameters(name = "{index}: getArea({0}, {1}, {2})")
	public static Collection<Object[]> data() {
		List<String> regions;
		List<Type> types;
		List<Integer> years;

		regions = new ArrayList<String>();
		regions.add("1263");
		regions.add(null);

		types = Arrays.asList(Type.values());

		years = new ArrayList<Integer>();
		years.add(2012);
		years.add(null);

		List<Object[]> parameters = new ArrayList<Object[]>();

		// Test with real data
		for (String region : regions) {
			for (Type type : types) {
				for (Integer year : years) {
					parameters.add(new Object[] { ListUtility.toList(region), ListUtility.toList(type), ListUtility.toList(year) });
				}
			}
		}

		// Special case: test with everything null
		parameters.add(new Object[] { null, null, null });

		// Special case: test with everything at once
		parameters.add(new Object[] { regions, types, years });

		return parameters;
	}

	private LandAndWaterAreaAPI_GetArea_IntegrationTest() {
		this.landAndWaterAreaAPI = new SCBAPI().environment().landAndWaterArea();
	}

	public LandAndWaterAreaAPI_GetArea_IntegrationTest(List<String> regions, List<Type> types, List<Integer> years) throws InterruptedException {
		this();

		this.regions = regions;
		this.types = types;
		this.years = years;

		// Due to constraints set by SCB, we can only do 10 calls every 10
		// seconds, so we need an artificial timer which handles this.
		Thread.sleep(Config.getTimerMs());
	}

	@Test
	public final void getArea() {
		assertNotEquals(0, this.landAndWaterAreaAPI.getArea(this.regions, this.types, this.years));
	}

}
