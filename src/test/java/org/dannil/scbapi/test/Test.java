package org.dannil.scbapi.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.dannil.scbapi.SCBAPI;
import org.dannil.scbapi.model.Population;
import org.dannil.scbapi.model.PopulationCollection;

public class Test {

	public static void main(String[] args) {

		SCBAPI api = new SCBAPI(new Locale("sv"));

		PopulationCollection collection = api.population().getPopulationBetweenYears(2001, 2003);
		for (Population p : collection.getPopulations()) {
			System.out.println(p);
		}

		// WORKS
		List<String> regions = new ArrayList<String>();
		regions.add("1265");
		regions.add("1267");
		PopulationCollection collection2 = api.population().getPopulationForRegions(regions);
		for (Population p : collection2.getPopulations()) {
			System.out.println(p);
		}

		// WORKS
		List<Integer> years = new ArrayList<Integer>();
		years.add(2001);
		years.add(2002);
		PopulationCollection collection3 = api.population().getPopulationForYears(years);
		for (Population p : collection3.getPopulations()) {
			System.out.println(p);
		}

		// WORKS
		PopulationCollection collection4 = api.population().getPopulation();
		for (Population p : collection4.getPopulations()) {
			System.out.println(p);
		}

		api.test();
	}

}
