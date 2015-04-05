package org.dannil.scbapi.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.dannil.scbapi.api.SCBAPI;
import org.dannil.scbapi.api.environment.landandwaterarea.LandAndWaterAreaAPI;
import org.dannil.scbapi.model.environment.landandwaterarea.Area;
import org.dannil.scbapi.model.population.demography.AverageAgeFirstChild;
import org.dannil.scbapi.model.population.statistic.Statistic;

public class Test {

	public static void main(String[] args) {

		Locale locale = new Locale("en");
		SCBAPI api = new SCBAPI(locale);

		List<String> regions = new ArrayList<String>();
		// regions.add("00");
		regions.add("1267");

		List<String> types = new ArrayList<String>();
		types.add("01");
		types.add("02");

		List<Integer> years = new ArrayList<Integer>();
		years.add(2012);
		years.add(2013);

		List<String> ages = new ArrayList<String>();
		ages.add("18");
		ages.add("20");

		Map<String, String> map = api.getRegionMappings();
		for (String key : map.keySet()) {
			// System.out.println(key + " : " + map.get(key));
		}

		List<Statistic> collection8 = api.population().statistic().getPopulation(regions, null, ages, null, years);
		for (Statistic p : collection8) {
			System.out.println(p);
		}

		// WORKS
		List<Statistic> collection4 = api.population().statistic().getPopulation();
		for (Statistic p : collection4) {
			System.out.println(p);
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

		List<AverageAgeFirstChild> collection7 = api.population().demography().getAverageAgeFirstChild(regions, null, null);
		for (AverageAgeFirstChild a : collection7) {
			System.out.println(a);
		}

	}
}
