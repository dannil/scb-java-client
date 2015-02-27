package org.dannil.scbapi.test;

import org.dannil.scbapi.SCBAPI;
import org.dannil.scbapi.model.Population;
import org.dannil.scbapi.model.PopulationCollection;

public class Test {

	public static void main(String[] args) {

		SCBAPI api = new SCBAPI();

		PopulationCollection collection = api.population().getPopulationBetweenYears(2001, 2003);
		for (Population p : collection.getPopulations()) {
			// System.out.println(p);
		}

		PopulationCollection collection2 = api.population().getPopulationForRegions(new String[] { "1265", "1267" });
		for (Population p : collection2.getPopulations()) {
			// System.out.println(p);
		}

		PopulationCollection collection3 = api.population().getPopulation();
		for (Population p : collection3.getPopulations()) {
			System.out.println(p);
		}
	}

}
