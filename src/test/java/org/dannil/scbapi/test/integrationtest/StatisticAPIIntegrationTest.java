package org.dannil.scbapi.test.integrationtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.dannil.scbapi.api.SCBAPI;
import org.dannil.scbapi.api.population.statistic.StatisticAPI;
import org.dannil.scbapi.model.population.statistic.Statistic.Gender;
import org.dannil.scbapi.model.population.statistic.Statistic.RelationshipStatus;
import org.dannil.scbapi.utility.ListUtility;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class StatisticAPIIntegrationTest {

	private SCBAPI api;
	private StatisticAPI statisticsAPI;

	@Parameters(name = "{index}: getPopulation({0}, {1}, {2}, {3}, {4})")
	public static Collection<Object[]> data() {
		List<String> regions;
		List<RelationshipStatus> statuses;
		List<String> ages;
		List<Gender> genders;
		List<Integer> years;

		regions = new ArrayList<String>();
		regions.add("1263");
		regions.add(null);

		statuses = Arrays.asList(RelationshipStatus.values());

		ages = new ArrayList<String>();
		ages.add("25");
		ages.add(null);

		genders = Arrays.asList(Gender.values());

		years = new ArrayList<Integer>();
		years.add(2002);
		years.add(null);

		List<Object[]> parameters = new ArrayList<Object[]>();

		// Test with real data
		for (String region : regions) {
			for (RelationshipStatus status : statuses) {
				for (String age : ages) {
					for (Gender gender : genders) {
						for (Integer year : years) {
							parameters.add(new Object[] { ListUtility.toList(region), ListUtility.toList(status), ListUtility.toList(age), ListUtility.toList(gender), ListUtility.toList(year) });
						}
					}
				}
			}
		}

		// Special case: test with everything at once
		parameters.add(new Object[] { regions, statuses, ages, genders, years });

		return parameters;
	}

	List<String> regions;
	List<RelationshipStatus> statuses;
	List<String> ages;
	List<Gender> genders;
	List<Integer> years;

	private StatisticAPIIntegrationTest() {
		this.api = new SCBAPI();
		this.statisticsAPI = this.api.population().statistic();
	}

	public StatisticAPIIntegrationTest(List<String> regions, List<RelationshipStatus> statuses, List<String> ages, List<Gender> genders, List<Integer> years) throws InterruptedException {
		this();

		this.regions = regions;
		this.statuses = statuses;
		this.ages = ages;
		this.genders = genders;
		this.years = years;

		// Due to constraints set by SCB, we can only do 10 calls every 10
		// seconds, so we need an artificial timer which handles this.
		Thread.sleep(800);
	}

	@Test
	public final void getPopulation() {
		Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(this.regions, this.statuses, this.ages, this.genders, this.years));
	}

	// @Test
	// public final void getPopulationNotNull() {
	// Assert.assertNotEquals(0, this.statisticsAPI.getPopulation().size());
	// }
	//
	// @Test
	// public final void getPopulationForRegions() {
	// Assert.assertNotEquals(0,
	// this.statisticsAPI.getPopulation(StatisticAPIIntegrationTest.regions,
	// null, null, null, null).size());
	// }
	//
	// @Test
	// public final void getPopulationForRegionsAndRelationshipStatuses() {
	// Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(this.regions,
	// this.relationshipStatuses, null, null, null).size());
	// }
	//
	// @Test
	// public final void getPopulationForRegionsAndRelationshipStatusesAndAges()
	// {
	// Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(this.regions,
	// this.relationshipStatuses, this.ages, null, null).size());
	// }
	//
	// @Test
	// public final void
	// getPopulationgetPopulationForRegionsAndRelationshipStatusesAndAgesAndGenders()
	// {
	// Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(this.regions,
	// this.relationshipStatuses, this.ages, this.genders, null).size());
	// }
	//
	// @Test
	// public final void
	// getPopulationgetPopulationForRegionsAndRelationshipStatusesAndAgesAndGendersAndYears()
	// {
	// Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(this.regions,
	// this.relationshipStatuses, this.ages, this.genders, this.years).size());
	// }
	//
	// @Test
	// public final void getPopulationForRelationshipStatuses() {
	// Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null,
	// this.relationshipStatuses, null, null, null).size());
	// }
	//
	// @Test
	// public final void getPopulationForRelationshipStatusUnmarried() {
	// Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null,
	// Arrays.asList(RelationshipStatus.UNMARRIED), null, null, null).size());
	// }
	//
	// @Test
	// public final void getPopulationForRelationshipStatusMarried() {
	// Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null,
	// Arrays.asList(RelationshipStatus.MARRIED), null, null, null).size());
	// }
	//
	// @Test
	// public final void getPopulationForRelationshipStatusDivorced() {
	// Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null,
	// Arrays.asList(RelationshipStatus.DIVORCED), null, null, null).size());
	// }
	//
	// @Test
	// public final void getPopulationForRelationshipStatusWidow() {
	// Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null,
	// Arrays.asList(RelationshipStatus.WIDOW), null, null, null).size());
	// }
	//
	// @Test
	// public final void getPopulationForAges() {
	// Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null, null,
	// this.ages, null, null).size());
	// }
	//
	// @Test
	// public final void getPopulationForGenders() {
	// Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null, null,
	// null, this.genders, null).size());
	// }
	//
	// @Test
	// public final void getPopulationForGenderMan() {
	// Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null, null,
	// null, Arrays.asList(Gender.MAN), null).size());
	// }
	//
	// @Test
	// public final void getPopulationForGenderWoman() {
	// Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null, null,
	// null, Arrays.asList(Gender.WOMAN), null).size());
	// }
	//
	// @Test
	// public final void getPopulationForYears() {
	// Assert.assertNotEquals(0, this.statisticsAPI.getPopulation(null, null,
	// null, null, this.years).size());
	// }

}
