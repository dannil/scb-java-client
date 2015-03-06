package org.dannil.scbapi.utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.dannil.scbapi.model.Area;
import org.dannil.scbapi.model.population.Statistic;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtility {

	public static final JsonNode getNode(String json) {
		return getNode(json, null);
	}

	public static final JsonNode getNode(String json, String field) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(json);
			if (field != null) {
				return node.get(field);
			}
			return node;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static final List<Area> parseAreas(JsonNode json) {
		JsonNode data = json.get("data");

		List<JsonNode> keys = data.findValues("key");
		List<JsonNode> values = data.findValues("values");

		List<Area> areas = new ArrayList<Area>();
		for (int i = 0; i < keys.size(); i++) {
			String region = null;
			String type = null;
			Integer year = null;

			JsonNode keyAtPosition = keys.get(i);
			if (keyAtPosition.size() < 3) {
				region = keyAtPosition.get(0).asText();
				year = keyAtPosition.get(1).asInt();
			} else {
				region = keyAtPosition.get(0).asText();
				type = keyAtPosition.get(1).asText();
				year = keyAtPosition.get(2).asInt();
			}

			JsonNode valueAtPosition = values.get(i);
			final Double squareKm = valueAtPosition.get(0).asDouble();

			Area a = new Area(region, type, year, squareKm);
			areas.add(a);
		}
		return areas;
	}

	public static final List<Statistic> parseStatistic(JsonNode node) {
		JsonNode data = node.get("data");

		List<JsonNode> keys = data.findValues("key");
		List<JsonNode> values = data.findValues("values");

		List<Statistic> statistics = new ArrayList<Statistic>();
		for (int i = 0; i < keys.size(); i++) {
			JsonNode keyAtPosition = keys.get(i);
			final String region = keyAtPosition.get(0).asText();
			final Integer year = keyAtPosition.get(1).asInt();

			JsonNode valueAtPosition = values.get(i);
			final Long amount = valueAtPosition.get(0).asLong();

			Statistic s = new Statistic(region, year, amount);
			statistics.add(s);
		}
		return statistics;
	}
}
