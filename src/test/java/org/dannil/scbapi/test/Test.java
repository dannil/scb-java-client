package org.dannil.scbapi.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.dannil.scbapi.api.SCBAPI;
import org.dannil.scbapi.api.environment.LandAndWaterAreaAPI;
import org.dannil.scbapi.model.Area;
import org.dannil.scbapi.model.population.Statistic;

public class Test {

	public static void main(String[] args) {

		Locale locale = new Locale("en");
		SCBAPI api = new SCBAPI(locale);

		List<String> regions = new ArrayList<String>();
		regions.add("00");
		regions.add("1267");

		List<String> types = new ArrayList<String>();
		types.add("01");
		types.add("02");

		List<Integer> years = new ArrayList<Integer>();
		years.add(2012);
		years.add(2013);

		Map<String, String> map = api.getRegionMappings();
		for (String key : map.keySet()) {
			// System.out.println(key + " : " + map.get(key));
		}

		// WORKS
		List<Statistic> collection4 = api.population().statistic().getPopulation();
		for (Statistic p : collection4) {
			// System.out.println(p);
		}

		List<Area> collection5 = api.environment().landAndWaterArea().getArea(regions, null, years);
		for (Area a : collection5) {
			System.out.println(a);
		}

		api.setLocale(new Locale("sv"));

		LandAndWaterAreaAPI lawApi = api.environment().landAndWaterArea();
		List<Area> collection6 = lawApi.getArea(regions, types, years);
		for (Area a : collection6) {
			System.out.println(a);
		}

		api.population().demography().getAverageAgeFirstChild(regions, null, years);

	}
}
