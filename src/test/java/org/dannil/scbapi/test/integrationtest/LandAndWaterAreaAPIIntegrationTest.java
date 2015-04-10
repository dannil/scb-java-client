package org.dannil.scbapi.test.integrationtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.dannil.scbapi.api.SCBAPI;
import org.dannil.scbapi.api.environment.landandwaterarea.LandAndWaterAreaAPI;
import org.dannil.scbapi.model.environment.landandwaterarea.Area.Type;
import org.dannil.scbapi.test.utility.Config;
import org.dannil.scbapi.utility.ListUtility;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class LandAndWaterAreaAPIIntegrationTest {

	private SCBAPI api;
	private LandAndWaterAreaAPI landAndWaterAreaAPI;

	@Parameters(name = "{index}: getArea({0}, {1}, {2})")
	public static Collection<Object[]> data() {
		List<String> regions;
		List<Type> types;
		List<Integer> years;

		regions = new ArrayList<String>();
		regions.add("1263");
		regions.add(null);

		types = Arrays.asList(Type.values());

		years = new ArrayList<Integer>();
		years.add(2012);
		years.add(null);

		List<Object[]> parameters = new ArrayList<Object[]>();

		// Test with real data
		for (String region : regions) {
			for (Type type : types) {
				for (Integer year : years) {
					parameters.add(new Object[] { ListUtility.toList(region), ListUtility.toList(type), ListUtility.toList(year) });
				}
			}
		}

		// Special case: test with everything null
		parameters.add(new Object[] { null, null, null });

		// Special case: test with everything at once
		parameters.add(new Object[] { regions, types, years });

		return parameters;
	}

	List<String> regions;
	List<Type> types;
	List<Integer> years;

	private LandAndWaterAreaAPIIntegrationTest() {
		this.api = new SCBAPI();
		this.landAndWaterAreaAPI = this.api.environment().landAndWaterArea();
	}

	public LandAndWaterAreaAPIIntegrationTest(List<String> regions, List<Type> types, List<Integer> years) throws InterruptedException {
		this();

		this.regions = regions;
		this.types = types;
		this.years = years;

		// Due to constraints set by SCB, we can only do 10 calls every 10
		// seconds, so we need an artificial timer which handles this.
		Thread.sleep(Config.TIMER);
	}

	@Test
	public final void getArea() {
		Assert.assertNotEquals(0, this.landAndWaterAreaAPI.getArea(this.regions, this.types, this.years));
	}

}
