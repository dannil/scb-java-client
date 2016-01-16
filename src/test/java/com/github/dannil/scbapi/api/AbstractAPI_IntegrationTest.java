package com.github.dannil.scbapi.api;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AbstractAPI_IntegrationTest {

	private class DummyAPI extends AbstractAPI {

		protected DummyAPI() {
			super();
		}

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
