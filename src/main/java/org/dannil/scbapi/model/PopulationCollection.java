package org.dannil.scbapi.model;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonNode;

public final class PopulationCollection {

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

	public void add(Population p) {
		this.populations.add(p);
	}

	public PopulationCollection getPopulationForRegion(String regionCode) {
		final PopulationCollection c = new PopulationCollection();
		for (Population p : this.populations) {
			if (p.getRegion().equals(regionCode)) {
				c.add(p);
			}
		}
		return c;
	}

	public PopulationCollection getPopulationForYear(Long year) {
		return null;
	}

	public List<Population> getPopulations() {
		return this.populations;
	}

	public void setPopulations(List<Population> populations) {
		this.populations = populations;
	}

}
