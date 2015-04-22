package org.dannil.scbapi.api.environment.landandwaterarea;

import static org.junit.Assert.assertNotEquals;

import org.dannil.scbapi.api.SCBAPI;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LandAndWaterArea_IntegrationTest {

	private SCBAPI api;
	private LandAndWaterAreaAPI landAndWaterAreaApi;

	@Before
	public final void init() {
		this.api = new SCBAPI();
		this.landAndWaterAreaApi = this.api.environment().landAndWaterArea();
	}

	@Test
	public final void getRegions() {
		assertNotEquals(0, this.landAndWaterAreaApi.getRegions().size());
	}

	@Test
	public final void getYears() {
		assertNotEquals(0, this.landAndWaterAreaApi.getYears().size());
	}

	@Test
	public final void getArea() {
		assertNotEquals(0, this.landAndWaterAreaApi.getArea().size());
	}

}
