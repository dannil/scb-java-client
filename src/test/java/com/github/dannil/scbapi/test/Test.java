package com.github.dannil.scbapi.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.github.dannil.scbapi.api.SCBAPI;
import com.github.dannil.scbapi.api.environment.landandwaterarea.LandAndWaterAreaAPI;
import com.github.dannil.scbapi.api.population.statistic.StatisticAPI;
import com.github.dannil.scbapi.model.environment.landandwaterarea.Area;
import com.github.dannil.scbapi.model.environment.landandwaterarea.Area.Type;
import com.github.dannil.scbapi.model.population.demography.AverageAgeFirstChild;
import com.github.dannil.scbapi.model.population.statistic.LiveBirth;
import com.github.dannil.scbapi.model.population.statistic.Population;
import com.github.dannil.scbapi.utility.ParseUtility;

public class Test {

	public static void main(String[] args) {

		Locale locale = new Locale("en");
		SCBAPI api = new SCBAPI(locale);

		List<String> regions = new ArrayList<String>();
		// regions.add("00");
		regions.add("1267");

		List<Type> types = new ArrayList<Type>();
		types.add(Type.INLANDWATEREXCLUDINGTHEFOURLARGELAKES);

		List<Integer> years = new ArrayList<Integer>();
		years.add(2012);
		years.add(2013);

		List<String> ages = new ArrayList<String>();
		ages.add("18");
		ages.add("20");

		// Map<String, String> map = api.getRegionMappings();
		// for (String key : map.keySet()) {
		// // System.out.println(key + " : " + map.get(key));
		// }

		System.out.println(ParseUtility.parseLong("221", null));

		StatisticAPI statisticApi = api.population().statistic();

		List<LiveBirth> collection9 = statisticApi.getLiveBirths();
		for (LiveBirth l : collection9) {
			System.out.println(l);
		}

		List<Population> collection8 = statisticApi.getPopulation(regions, null, ages, null, years);
		for (Population p : collection8) {
			System.out.println(p);
		}

		List<Population> collection4 = statisticApi.getPopulation();
		for (Population p : collection4) {
			System.out.println(p);
		}

		// List<Integer> availableYears = statisticApi.getYears();
		// for (Integer year : availableYears) {
		// System.out.println(year);
		// }

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
