package org.dannil.scbapi.utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dannil.scbapi.model.environment.landandwaterarea.Area;
import org.dannil.scbapi.model.environment.landandwaterarea.Area.Type;
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

	public static final List<Area> parseAreas(JsonNode node) {
		JsonNode columns = node.get("columns");
		List<String> codes = columns.findValuesAsText("code");

		List<String> storedCodes = Area.getCodes();
		Map<String, Integer> mappings = new HashMap<String, Integer>();
		int i = 0;
		for (String code : codes) {
			for (String stored : storedCodes) {
				if (code.equals(stored)) {
					mappings.put(code, i);
					i++;
				}
			}
		}

		JsonNode data = node.get("data");

		List<JsonNode> keys = data.findValues("key");
		List<JsonNode> values = data.findValues("values");

		List<Area> areas = new ArrayList<Area>();
		for (int j = 0; j < keys.size(); j++) {
			JsonNode keyAtPosition = keys.get(j);

			String region = (mappings.get("Region") != null ? keyAtPosition.get(mappings.get("Region")).asText() : null);
			Type type = (mappings.get("ArealTyp") != null ? Type.of(keyAtPosition.get(mappings.get("ArealTyp")).asText()) : null);
			Integer year = (mappings.get("Tid") != null ? keyAtPosition.get(mappings.get("Tid")).asInt() : null);

			JsonNode valueAtPosition = values.get(j);
			final Double squareKm = valueAtPosition.get(0).asDouble();

			Area a = new Area(region, type, year, squareKm);
			areas.add(a);
		}
		return areas;
	}

	public static final List<Statistic> parseStatistic(JsonNode node) {
		JsonNode columns = node.get("columns");
		List<String> codes = columns.findValuesAsText("code");

		List<String> storedCodes = Statistic.getCodes();
		Map<String, Integer> mappings = new HashMap<String, Integer>();
		int i = 0;
		for (String code : codes) {
			for (String stored : storedCodes) {
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
			RelationshipStatus relationshipStatus = (mappings.get("Civilstand") != null ? RelationshipStatus.of(keyAtPosition.get(mappings.get("Civilstand")).asText()) : null);
			String age = (mappings.get("Alder") != null ? keyAtPosition.get(mappings.get("Alder")).asText() : null);
			Gender gender = (mappings.get("Kon") != null ? Gender.of(keyAtPosition.get(mappings.get("Kon")).asInt()) : null);
			Integer year = (mappings.get("Tid") != null ? keyAtPosition.get(mappings.get("Tid")).asInt() : null);

			JsonNode valueAtPosition = values.get(j);
			final Long amount = valueAtPosition.get(0).asLong();

			Statistic s = new Statistic(region, relationshipStatus, age, gender, year, amount);
			statistics.add(s);
		}
		return statistics;
	}

	public static final List<String> getCodes(String table) {
		String content = RequestPoster.doGet(String.format("http://api.scb.se/OV0104/v1/doris/en/ssd/%s", table));

		JsonNode data = getNode(content);
		List<String> codes = data.findValuesAsText("code");

		return codes;
	}
}
