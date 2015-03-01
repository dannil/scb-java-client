package org.dannil.scbapi.integrationtest;

import java.util.ArrayList;
import java.util.List;

import org.dannil.scbapi.SCBPopulationAPI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SCBPopulationAPI_IntegrationTest {

	private SCBPopulationAPI populationApi;

	private List<String> regions;
	private List<Integer> years;

	@Before
	public final void init() {
		this.populationApi = new SCBPopulationAPI();

		this.regions = new ArrayList<String>();
		this.regions.add("1263");
		this.regions.add("1267");
		this.regions.add("00");

		this.years = new ArrayList<Integer>();
		this.years.add(1987);
		this.years.add(1993);
		this.years.add(2001);
	}

	@Test
	public final void getPopulationNotNull() {
		Assert.assertNotEquals(0, this.populationApi.getPopulation().getPopulations().size());
	}

	@Test
	public final void getPopulationForRegionNotNull() {
		Assert.assertNotEquals(0, this.populationApi.getPopulationForRegion(this.regions.get(0)).getPopulations().size());
	}

	@Test
	public final void getPopulationForRegionAndYearsNotNull() {
		Assert.assertNotEquals(0, this.populationApi.getPopulationForRegion(this.regions.get(0), this.years).getPopulations().size());
	}

	@Test
	public final void getPopulationForRegionAndYearNotNull() {
		Assert.assertNotEquals(0, this.populationApi.getPopulationForRegion(this.regions.get(0), this.years.get(0)).getPopulations().size());
	}

	@Test
	public final void getPopulationForRegions() {
		Assert.assertNotEquals(0, this.populationApi.getPopulationForRegions(this.regions).getPopulations().size());
	}

	@Test
	public final void getPopulationForRegionsAndYearsNotNull() {
		Assert.assertNotEquals(0, this.populationApi.getPopulationForRegions(this.regions, this.years).getPopulations().size());
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
