package org.dannil.scbapi.model;

import java.util.ArrayList;
import java.util.List;

import org.dannil.scbapi.ISCBPopulationAPI;

import com.fasterxml.jackson.databind.JsonNode;

public final class PopulationCollection implements ISCBPopulationAPI {

	// TODO

	private List<Population> populations;

	private PopulationCollection() {
		this.populations = new ArrayList<Population>();
	}

	public PopulationCollection(JsonNode data) {
		this();

		List<JsonNode> keys = data.findValues("key");
		List<JsonNode> values = data.findValues("values");

		for (int i = 0; i < keys.size(); i++) {
			JsonNode keyAtPosition = keys.get(i);
			final String region = keyAtPosition.get(0).asText();
			final Integer year = keyAtPosition.get(1).asInt();

			JsonNode valueAtPosition = values.get(i);
			final Long amount = valueAtPosition.get(0).asLong();

			Population p = new Population(region, year, amount);
			this.populations.add(p);
		}
	}

	@Override
	public PopulationCollection getPopulation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PopulationCollection getPopulationForRegion(String region) {
		final PopulationCollection c = new PopulationCollection();
		for (Population p : this.populations) {
			if (p.getRegion().equals(region)) {
				c.add(p);
			}
		}
		return c;
	}

	@Override
	public PopulationCollection getPopulationForRegion(String region, List<Integer> years) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PopulationCollection getPopulationForRegion(String region, Integer year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PopulationCollection getPopulationForRegions(List<String> regions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PopulationCollection getPopulationForRegions(List<String> regions, List<Integer> years) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PopulationCollection getPopulationForYear(int year) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PopulationCollection getPopulationBetweenYears(int startYear, int endYear) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PopulationCollection getPopulationForYears(List<Integer> years) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(Population p) {
		this.populations.add(p);
	}

	public List<Population> getPopulations() {
		return this.populations;
	}

	public void setPopulations(List<Population> populations) {
		this.populations = populations;
	}

}
