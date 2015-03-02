package org.dannil.scbapi.test;

import java.util.ArrayList;
import java.util.List;

import org.dannil.scbapi.SCBAPI;
import org.dannil.scbapi.model.Population;
import org.dannil.scbapi.model.PopulationCollection;

public class Test2 {

	public static void main(String[] args) {
		SCBAPI api = new SCBAPI();

		PopulationCollection c = api.population().getPopulationForRegion("1263");
		for (Population p : c.getPopulations()) {
			System.out.println(p);
		}

		System.out.println();

		List<Integer> years = new ArrayList<Integer>();
		years.add(2002);
		years.add(2004);
		PopulationCollection c1 = c.getPopulationForYears(years);
		for (Population p : c1.getPopulations()) {
			System.out.println(p);
		}
	}

}
