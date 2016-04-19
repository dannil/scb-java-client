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

package com.github.dannil.scbjavaclient.client;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbjavaclient.exception.SCBClientUrlNotFoundException;
import com.github.dannil.scbjavaclient.utility.ListUtility;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

@RunWith(JUnit4.class)
public class AbstractClient_IntegrationTest {

	private class DummyClient extends AbstractClient {

		protected DummyClient() {
			super();
		}

		protected DummyClient(Locale locale) {
			super(locale);
		}

	}

	@Test
	public void toFallbackUrlGet() {
		DummyClient client = new DummyClient(new Locale("en", "US"));

		String url = "HE/HE0103/HE0103B/BefolkningAlder";

		// This request is performed by a dummy Client which is set to English (as
		// specified in the setup method.
		// This means that if we receive a response with Swedish text, we've
		// used the fallback url.
		String response = client.get(url);

		assertTrue(response.contains("ålder"));
		assertTrue(response.contains("kön"));
		assertTrue(response.contains("boendeform"));
		assertTrue(response.contains("tabellinnehåll"));
		assertTrue(response.contains("år"));
	}

	@Test
	public void toFallbackUrlPost() {
		DummyClient client = new DummyClient(new Locale("en", "US"));

		String url = "HE/HE0103/HE0103B/BefolkningAlder";

		Map<String, Collection<?>> map = new HashMap<String, Collection<?>>();
		map.put("ContentsCode", ListUtility.toList("HE0103D2"));
		map.put("Alder", ListUtility.toList("tot"));
		map.put("Kon", ListUtility.toList("4"));
		map.put("Boendeform", ListUtility.toList("SMAG"));
		map.put("Tid", ListUtility.toList("2012"));

		// This request is performed by a dummy client which is set to English (as
		// specified in the setup method.
		// This means that if we receive a response with Swedish text, we've
		// used the fallback url.
		String response = client.post(url, QueryBuilder.build(map));

		assertTrue(response.contains("ålder"));
		assertTrue(response.contains("kön"));
		assertTrue(response.contains("boendeform"));
		assertTrue(response.contains("år"));
	}

	@Test
	public void getRegions() {
		DummyClient client = new DummyClient();

		List<String> regions = client.getRegions("BE/BE0101/BE0101A/BefolkningNy");

		assertNotNull(regions);
		assertFalse(regions.isEmpty());
	}

	@Test(expected = SCBClientUrlNotFoundException.class)
	public void getRegionsInvalidTable() {
		DummyClient client = new DummyClient();

		List<String> regions = client.getRegions("BE/BE0401/BE0401A/BefolkprognRev2015");

		assertNull(regions);
	}

	@Test
	public void getYears() {
		DummyClient client = new DummyClient();

		List<String> years = client.getYears("BE/BE0101/BE0101A/BefolkningNy");

		assertNotNull(years);
		assertFalse(years.isEmpty());
	}

	@Test(expected = UnsupportedOperationException.class)
	public void getYearsInvalidTable() {
		DummyClient client = new DummyClient();

		List<String> years = client.getYears("NR/NR0105/NR0105A");

		assertNull(years);
	}

}
