package org.dannil.scbapi.integrationtest;

import java.util.ArrayList;
import java.util.List;

import org.dannil.scbapi.api.SCBAPI;
import org.dannil.scbapi.api.population.statistic.StatisticAPI;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StatisticAPI_IntegrationTest {

	private SCBAPI api;
	private StatisticAPI statisticsAPI;

	private List<String> regions;
	private List<String> relationshipStatuses;
	private List<String> ages;
	private List<Integer> genders;
	private List<Integer> years;

	@Before
	public void initialize() {
		this.api = new SCBAPI();
		this.statisticsAPI = this.api.population().statistic();

		this.regions = new ArrayList<String>();
		this.regions.add("1263");

		this.relationshipStatuses = new ArrayList<String>();
		this.relationshipStatuses.add("OG");
		this.relationshipStatuses.add("G");
		this.relationshipStatuses.add("SK");
		this.relationshipStatuses.add("ÄNKL");

		this.ages = new ArrayList<String>();
		this.ages.add("25");
		this.ages.add("30");

		this.genders = new ArrayList<Integer>();
		this.genders.add(1);
		this.genders.add(2);

		this.years = new ArrayList<Integer>();
		this.years.add(2002);
	}

	@Test
	public final void getPopulationNotNull() {
		Assert.assertNotEquals(0, this.statisticsAPI.getPopulation().size());
	}

	@Test
	public final void getPopulationForRegions() {
		Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(this.regions, null, null, null, null).size());
	}

	@Test
	public final void getPopulationForRegionsAndRelationshipStatuses() {
		Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(this.regions, this.relationshipStatuses, null, null, null).size());
	}

	@Test
	public final void getPopulationForRegionsAndRelationshipStatusesAndAges() {
		Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(this.regions, this.relationshipStatuses, this.ages, null, null).size());
	}

	@Test
	public final void getPopulationgetPopulationForRegionsAndRelationshipStatusesAndAgesAndGenders() {
		Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(this.regions, this.relationshipStatuses, this.ages, this.genders, null).size());
	}

	@Test
	public final void getPopulationgetPopulationForRegionsAndRelationshipStatusesAndAgesAndGendersAndYears() {
		Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(this.regions, this.relationshipStatuses, this.ages, this.genders, this.years).size());
	}

	@Test
	public final void getPopulationForRelationshipStatuses() {
		Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null, this.relationshipStatuses, null, null, null).size());
	}

	@Test
	public final void getPopulationForAges() {
		Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null, null, this.ages, null, null).size());
	}

	@Test
	public final void getPopulationForGenders() {
		Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null, null, null, this.genders, null).size());
	}

	@Test
	public final void getPopulationForYears() {
		Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null, null, null, null, this.years).size());
	}

}
