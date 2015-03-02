package org.dannil.scbapi.integrationtest;

import java.util.ArrayList;
import java.util.List;

import org.dannil.scbapi.PopulationAPI;
import org.dannil.scbapi.SCBAPI;
import org.junit.Assert;
import org.junit.Before;
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

	@Before
	public void initialize() {
		this.coreApi = new SCBAPI();
		this.populationApi = this.coreApi.population();

		this.regionCodes = new ArrayList<String>();
		this.regionTexts = new ArrayList<String>();

		this.regionCodes.add("1263");

		this.years = new ArrayList<Integer>();
		this.years.add(2002);
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
