package org.dannil.scbapi.model.population;

import java.util.ArrayList;
import java.util.List;

import org.dannil.scbapi.api.population.StatisticsOperations;

import com.fasterxml.jackson.databind.JsonNode;

public final class StatisticsCollection implements StatisticsOperations {

	// TODO

	private List<Statistics> populations;

	private StatisticsCollection() {
		this.populations = new ArrayList<Statistics>();
	}

	public StatisticsCollection(JsonNode node) {
		this();

		JsonNode data = node.get("data");

		List<JsonNode> keys = data.findValues("key");
		List<JsonNode> values = data.findValues("values");

		for (int i = 0; i < keys.size(); i++) {
			JsonNode keyAtPosition = keys.get(i);
			final String region = keyAtPosition.get(0).asText();
			final Integer year = keyAtPosition.get(1).asInt();

			JsonNode valueAtPosition = values.get(i);
			final Long amount = valueAtPosition.get(0).asLong();

			Statistics p = new Statistics(region, year, amount);
			this.populations.add(p);
		}
	}

	public StatisticsCollection getPopulation() {
		return this;
	}

	public StatisticsCollection getPopulation(List<String> regions, List<Integer> years) {
		final StatisticsCollection c = new StatisticsCollection();
		for (Statistics p : this.populations) {
			if (regions == null && years == null) {
				return this;
			} else if (regions == null) {
				for (Integer year : years) {
					if (p.getYear().equals(year)) {
						c.add(p);
					}
				}
			} else if (years == null) {
				for (String region : regions) {
					if (p.getRegion().equals(region)) {
						c.add(p);
					}
				}
			} else {
				for (String region : regions) {
					for (Integer year : years) {
						if (p.getRegion().equals(region) && p.getYear().equals(year)) {
							c.add(p);
						}
					}
				}
			}
		}
		return c;
	}

	public void add(Statistics p) {
		this.populations.add(p);
	}

	public List<Statistics> getPopulations() {
		return this.populations;
	}

	public void setPopulations(List<Statistics> populations) {
		this.populations = populations;
	}

}
