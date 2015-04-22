package org.dannil.scbapi.api.population.statistic;

import static org.junit.Assert.assertNotEquals;

import org.dannil.scbapi.api.SCBAPI;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class StatisticAPI_IntegrationTest {

	private SCBAPI api;
	private StatisticAPI statisticsAPI;

	@Before
	public final void init() {
		this.api = new SCBAPI();
		this.statisticsAPI = this.api.population().statistic();
	}

	@Test
	public final void getRegions() {
		assertNotEquals(0, this.statisticsAPI.getRegions().size());
	}

	@Test
	public final void getYears() {
		assertNotEquals(0, this.statisticsAPI.getYears().size());
	}

	@Test
	public final void getPopulation() {
		assertNotEquals(0, this.statisticsAPI.getPopulation().size());
	}

}
