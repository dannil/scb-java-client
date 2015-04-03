package org.dannil.scbapi.utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dannil.scbapi.model.environment.landandwaterarea.Area;
import org.dannil.scbapi.model.population.statistic.Statistic;
import org.dannil.scbapi.model.population.statistic.Statistic.Gender;
import org.dannil.scbapi.model.population.statistic.Statistic.RelationshipStatus;

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
		JsonNode columns = node.get("columns");
		List<String> codes = columns.findValuesAsText("code");

		Map<String, Integer> mappings = new HashMap<String, Integer>();
		int i = 0;
		for (String code : codes) {
			for (String stored : Statistic.getCodes()) {
				if (code.equals(stored)) {
					mappings.put(code, i);
					i++;
				}
			}
		}

		JsonNode data = node.get("data");

		List<JsonNode> keys = data.findValues("key");
		List<JsonNode> values = data.findValues("values");

		List<Statistic> statistics = new ArrayList<Statistic>();
		for (int j = 0; j < keys.size(); j++) {
			JsonNode keyAtPosition = keys.get(j);

			String region = (mappings.get("Region") != null ? keyAtPosition.get(mappings.get("Region")).asText() : null);
			RelationshipStatus relationshipStatus = RelationshipStatus.of((mappings.get("Civilstand") != null ? keyAtPosition.get(mappings.get("Civilstand")).asText() : null));
			String age = (mappings.get("Alder") != null ? keyAtPosition.get(mappings.get("Alder")).asText() : null);
			Gender gender = Gender.of((mappings.get("Kon") != null ? keyAtPosition.get(mappings.get("Kon")).asInt() : null));
			Integer year = (mappings.get("Tid") != null ? keyAtPosition.get(mappings.get("Tid")).asInt() : null);

			JsonNode valueAtPosition = values.get(j);
			final Long amount = valueAtPosition.get(0).asLong();

			Statistic s = new Statistic(region, relationshipStatus, age, gender, year, amount);
			statistics.add(s);
		}
		return statistics;
	}
}
