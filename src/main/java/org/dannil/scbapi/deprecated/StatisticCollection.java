//package org.dannil.scbapi.deprecated;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.dannil.scbapi.api.population.StatisticOperations;
//import org.dannil.scbapi.model.population.Statistic;
//
//import com.fasterxml.jackson.databind.JsonNode;
//
//public final class StatisticCollection implements StatisticOperations {
//
//	// TODO
//
//	private List<Statistic> populations;
//
//	private StatisticCollection() {
//		this.populations = new ArrayList<Statistic>();
//	}
//
//	public StatisticCollection(JsonNode node) {
//		this();
//
//		JsonNode data = node.get("data");
//
//		List<JsonNode> keys = data.findValues("key");
//		List<JsonNode> values = data.findValues("values");
//
//		for (int i = 0; i < keys.size(); i++) {
//			JsonNode keyAtPosition = keys.get(i);
//			final String region = keyAtPosition.get(0).asText();
//			final Integer year = keyAtPosition.get(1).asInt();
//
//			JsonNode valueAtPosition = values.get(i);
//			final Long amount = valueAtPosition.get(0).asLong();
//
//			Statistic p = new Statistic(region, year, amount);
//			this.populations.add(p);
//		}
//	}
//
//	public StatisticCollection getPopulation() {
//		return this;
//	}
//
//	public StatisticCollection getPopulation(List<String> regions, List<Integer> years) {
//		final StatisticCollection c = new StatisticCollection();
//		for (Statistic p : this.populations) {
//			if (regions == null && years == null) {
//				return this;
//			} else if (regions == null) {
//				for (Integer year : years) {
//					if (p.getYear().equals(year)) {
//						c.add(p);
//					}
//				}
//			} else if (years == null) {
//				for (String region : regions) {
//					if (p.getRegion().equals(region)) {
//						c.add(p);
//					}
//				}
//			} else {
//				for (String region : regions) {
//					for (Integer year : years) {
//						if (p.getRegion().equals(region) && p.getYear().equals(year)) {
//							c.add(p);
//						}
//					}
//				}
//			}
//		}
//		return c;
//	}
//
//	public void add(Statistic p) {
//		this.populations.add(p);
//	}
//
//	public List<Statistic> getPopulations() {
//		return this.populations;
//	}
//
//	public void setPopulations(List<Statistic> populations) {
//		this.populations = populations;
//	}
//
// }
