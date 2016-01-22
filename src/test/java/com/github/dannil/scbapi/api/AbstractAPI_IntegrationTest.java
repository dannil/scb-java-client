package com.github.dannil.scbapi.api;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbapi.utility.ListUtility;
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

		Map<String, List<?>> map = new HashMap<String, List<?>>();
		map.put("ContentsCode", ListUtility.toList("HE0103D2"));
		map.put("Alder", ListUtility.toList("tot"));
		map.put("Kon", ListUtility.toList("4"));
		map.put("Boendeform", ListUtility.toList("SMAG"));
		map.put("Tid", ListUtility.toList("2012"));

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
