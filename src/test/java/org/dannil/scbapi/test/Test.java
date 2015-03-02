package org.dannil.scbapi.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.dannil.scbapi.SCBAPI;
import org.dannil.scbapi.model.Population;
import org.dannil.scbapi.model.PopulationCollection;

public class Test {

	public static void main(String[] args) {

		Locale locale = new Locale("sv");
		SCBAPI api = new SCBAPI(locale);

		List<String> regions = new ArrayList<String>();
		regions.add("1263");

		List<String> types = new ArrayList<String>();
		types.add("01");
		types.add("02");

		List<Integer> years = new ArrayList<Integer>();
		years.add(2012);
		years.add(2013);

		// WORKS
		PopulationCollection collection4 = api.population().getPopulation();
		for (Population p : collection4.getPopulations()) {
			// System.out.println(p);
		}

		api.environment().getAreaForRegions(regions, types, years);
	}
}
