package org.dannil.scbapi.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.dannil.scbapi.api.SCBAPI;
import org.dannil.scbapi.model.Area;
import org.dannil.scbapi.model.AreaCollection;
import org.dannil.scbapi.model.population.Statistics;
import org.dannil.scbapi.model.population.StatisticsCollection;

public class Test {

	public static void main(String[] args) {

		Locale locale = new Locale("sv");
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
		StatisticsCollection collection4 = api.population().statistics().getPopulation();
		for (Statistics p : collection4.getPopulations()) {
			// System.out.println(p);
		}

		AreaCollection collection5 = api.environment().getArea(regions, null, years);
		for (Area a : collection5.getAreas()) {
			System.out.println(a);
		}

		AreaCollection collection6 = api.environment().getArea(regions, types, years);
		for (Area a : collection6.getAreas()) {
			System.out.println(a);
		}

	}
}
