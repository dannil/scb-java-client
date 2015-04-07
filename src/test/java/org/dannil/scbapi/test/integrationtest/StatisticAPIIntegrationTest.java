package org.dannil.scbapi.test.integrationtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.dannil.scbapi.api.SCBAPI;
import org.dannil.scbapi.api.population.statistic.StatisticAPI;
import org.dannil.scbapi.model.population.statistic.Statistic.Gender;
import org.dannil.scbapi.model.population.statistic.Statistic.RelationshipStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StatisticAPIIntegrationTest {

	private SCBAPI api;
	private StatisticAPI statisticsAPI;

	private List<String> regions;
	private List<RelationshipStatus> relationshipStatuses;
	private List<String> ages;
	private List<Gender> genders;
	private List<Integer> years;

	@Before
	public void initialize() {
		this.api = new SCBAPI();
		this.statisticsAPI = this.api.population().statistic();

		this.regions = new ArrayList<String>();
		this.regions.add("1263");

		this.relationshipStatuses = new ArrayList<RelationshipStatus>();
		this.relationshipStatuses.add(RelationshipStatus.UNMARRIED);
		this.relationshipStatuses.add(RelationshipStatus.MARRIED);
		this.relationshipStatuses.add(RelationshipStatus.DIVORCED);
		this.relationshipStatuses.add(RelationshipStatus.WIDOW);

		this.ages = new ArrayList<String>();
		this.ages.add("25");
		this.ages.add("30");

		this.genders = new ArrayList<Gender>();
		this.genders.add(Gender.MAN);
		this.genders.add(Gender.WOMAN);

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
	public final void getPopulationForRelationshipStatusUnmarried() {
		Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null, Arrays.asList(RelationshipStatus.UNMARRIED), null, null, null).size());
	}

	@Test
	public final void getPopulationForRelationshipStatusMarried() {
		Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null, Arrays.asList(RelationshipStatus.MARRIED), null, null, null).size());
	}

	@Test
	public final void getPopulationForRelationshipStatusDivorced() {
		Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null, Arrays.asList(RelationshipStatus.DIVORCED), null, null, null).size());
	}

	@Test
	public final void getPopulationForRelationshipStatusWidow() {
		Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null, Arrays.asList(RelationshipStatus.WIDOW), null, null, null).size());
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
	public final void getPopulationForGenderMan() {
		Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null, null, null, Arrays.asList(Gender.MAN), null).size());
	}

	@Test
	public final void getPopulationForGenderWoman() {
		Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null, null, null, Arrays.asList(Gender.WOMAN), null).size());
	}

	@Test
	public final void getPopulationForYears() {
		Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null, null, null, null, this.years).size());
	}

}
