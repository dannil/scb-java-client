package org.dannil.scbapi.integrationtest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.dannil.scbapi.SCBAPI;
import org.dannil.scbapi.PopulationAPI;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SCBPopulationAPI_IntegrationTest {

	private SCBAPI coreApi;
	private PopulationAPI populationApi;

	private List<String> regionCodes;
	private List<String> regionTexts;
	private List<Integer> years;

	public SCBPopulationAPI_IntegrationTest() {
		this.coreApi = new SCBAPI();
		this.populationApi = new PopulationAPI();

		this.regionCodes = new ArrayList<String>();
		this.regionTexts = new ArrayList<String>();

		Map<String, String> map = this.coreApi.getRegionMappings();
		for (String code : map.keySet()) {
			this.regionCodes.add(code);
			this.regionTexts.add(map.get(code));
		}

		this.years = this.populationApi.getAvailableYears();
	}

	@Test
	public final void getPopulationNotNull() {
		Assert.assertNotEquals(0, this.populationApi.getPopulation().getPopulations().size());
	}

	@Test
	public final void getPopulationForRegionNotNull() {
		Assert.assertNotEquals(0, this.populationApi.getPopulationForRegion(this.regionCodes.get(0)).getPopulations().size());
	}

	@Test
	public final void getPopulationForRegionAndYearsNotNull() {
		Assert.assertNotEquals(0, this.populationApi.getPopulationForRegion(this.regionCodes.get(0), this.years).getPopulations().size());
	}

	@Test
	public final void getPopulationForRegionAndYearNotNull() {
		Assert.assertNotEquals(0, this.populationApi.getPopulationForRegion(this.regionCodes.get(0), this.years.get(0)).getPopulations().size());
	}

	@Test
	public final void getPopulationForRegions() {
		Assert.assertNotEquals(0, this.populationApi.getPopulationForRegions(this.regionCodes).getPopulations().size());
	}

	@Test
	public final void getPopulationForRegionsAndYearsNotNull() {
		Assert.assertNotEquals(0, this.populationApi.getPopulationForRegions(this.regionCodes, this.years).getPopulations().size());
	}

	@Test
	public final void getPopulationForYearNotNull() {
		Assert.assertNotEquals(0, this.populationApi.getPopulationForYear(this.years.get(0)).getPopulations().size());
	}

	@Test
	public final void getPopulationBetweenYearsNotNull() {
		Assert.assertNotEquals(0, this.populationApi.getPopulationBetweenYears(this.years.get(0), this.years.get(this.years.size() - 1)).getPopulations().size());
	}

	@Test
	public final void getPopulationForYearsNotNull() {
		Assert.assertNotEquals(0, this.populationApi.getPopulationForYears(this.years).getPopulations().size());
	}

}
