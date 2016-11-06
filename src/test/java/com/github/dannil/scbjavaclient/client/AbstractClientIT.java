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

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbjavaclient.exception.SCBClientForbiddenException;
import com.github.dannil.scbjavaclient.exception.SCBClientUrlNotFoundException;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

@RunWith(JUnit4.class)
public class AbstractClientIT {

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

		// This request is performed by a dummy Client which is set to English
		// (as
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
		map.put("ContentsCode", Arrays.asList("HE0103D2"));
		map.put("Alder", Arrays.asList("tot"));
		map.put("Kon", Arrays.asList("4"));
		map.put("Boendeform", Arrays.asList("SMAG"));
		map.put("Tid", Arrays.asList("2012"));

		// This request is performed by a dummy client which is set to English
		// (as
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

	@Test(expected = IllegalArgumentException.class)
	public void getRegionsMissingCodeInTable() {
		DummyClient client = new DummyClient();

		List<String> regions = client.getRegions("BE/BE0001/BE0001T04Ar");

		assertNull(regions);
	}

	@Test
	public void getYears() {
		DummyClient client = new DummyClient();

		List<String> years = client.getYears("BE/BE0101/BE0101A/BefolkningNy");

		assertNotNull(years);
		assertFalse(years.isEmpty());
	}

	// TODO Fix test
	// @Test(expected = IllegalArgumentException.class)
	// public void getYearsMissingCodeInTable() {
	// DummyClient client = new DummyClient();
	//
	// List<String> years = client.getYears("NR/NR0105/NR0105A");
	//
	// assertNull(years);
	// }

	@Test(expected = SCBClientUrlNotFoundException.class)
	public void urlNotFoundException() {
		DummyClient client = new DummyClient();

		String response = client.get("ABC/ABC/ABC");

		assertNull(response);
	}

	@Test(expected = SCBClientForbiddenException.class)
	public void forbiddenException() {
		// Need to use SCBClient here instead of DummyClient to reach
		// getRawData(String)-method
		SCBClient client = new SCBClient();

		// This call will result in a HTTP 403 response (forbidden) since the
		// response from this
		// table is larger than the API allows (given all the available inputs)
		String response = client.getRawData("NV/NV0119/IVPKNLonAr");

		assertNull(response);
	}

}
