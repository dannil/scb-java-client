package org.dannil.scbapi.integrationtest;

import java.util.ArrayList;
import java.util.List;

import org.dannil.scbapi.api.SCBAPI;
import org.dannil.scbapi.api.population.StatisticsAPI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SCBPopulationAPI_IntegrationTest {

	private SCBAPI coreApi;
	private StatisticsAPI populationApi;

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
	public final void getPopulationForRegionsNotNull() {
		Assert.assertNotEquals(0, this.populationApi.getPopulation(this.regionCodes, null).getPopulations().size());
	}

	@Test
	public final void getPopulationForRegionAndYearsNotNull() {
		Assert.assertNotEquals(0, this.populationApi.getPopulation(this.regionCodes, this.years).getPopulations().size());
	}

	@Test
	public final void getPopulationBetweenYearsNotNull() {
		Assert.assertNotEquals(0, this.populationApi.getPopulation(null, this.years).getPopulations().size());
	}

}
