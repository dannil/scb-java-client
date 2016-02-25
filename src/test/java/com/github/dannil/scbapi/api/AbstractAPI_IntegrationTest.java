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

package com.github.dannil.scbapi.api;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbapi.utility.QueryBuilder;

@RunWith(JUnit4.class)
public class AbstractAPI_IntegrationTest {

	private class DummyAPI extends AbstractAPI {

		protected DummyAPI() {
			super();
		}

		protected DummyAPI(Locale locale) {
			super(locale);
		}

	}

	@Test
	public void toFallbackUrlGet() {
		DummyAPI api = new DummyAPI(new Locale("en", "US"));

		String url = "HE/HE0103/HE0103B/BefolkningAlder";

		// This request is performed by a dummy API which is set to English (as
		// specified in the setup method.
		// This means that if we receive a response with Swedish text, we've
		// used the fallback url.
		String response = api.get(url);

		assertTrue(response.contains("ålder"));
		assertTrue(response.contains("kön"));
		assertTrue(response.contains("boendeform"));
		assertTrue(response.contains("tabellinnehåll"));
		assertTrue(response.contains("år"));
	}

	@Test
	public void toFallbackUrlPost() {
		DummyAPI api = new DummyAPI(new Locale("en", "US"));

		String url = "HE/HE0103/HE0103B/BefolkningAlder";

		// Build the payload
		QueryBuilder builder = QueryBuilder.getInstance();

		Map<String, Collection<?>> map = new HashMap<String, Collection<?>>();
		map.put("ContentsCode", Arrays.asList("HE0103D2"));
		map.put("Alder", Arrays.asList("tot"));
		map.put("Kon", Arrays.asList("4"));
		map.put("Boendeform", Arrays.asList("SMAG"));
		map.put("Tid", Arrays.asList("2012"));

		// This request is performed by a dummy API which is set to English (as
		// specified in the setup method.
		// This means that if we receive a response with Swedish text, we've
		// used the fallback url.
		String response = api.post(url, builder.build(map));

		assertTrue(response.contains("ålder"));
		assertTrue(response.contains("kön"));
		assertTrue(response.contains("boendeform"));
		assertTrue(response.contains("år"));
	}

	@Test
	public void getRegions() {
		DummyAPI api = new DummyAPI();

		List<String> regions = api.getRegions("BE/BE0101/BE0101A/BefolkningNy");

		assertNotNull(regions);
		assertFalse(regions.isEmpty());
	}

	@Test
	public void getYears() {
		DummyAPI api = new DummyAPI();

		List<String> years = api.getYears("BE/BE0101/BE0101A/BefolkningNy");

		assertNotNull(years);
		assertFalse(years.isEmpty());
	}

}
