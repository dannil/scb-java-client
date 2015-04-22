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
		Map<String, Integer> mappings = generateMappings(node.get("columns").findValuesAsText("code"), Area.getCodes());

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

	public static final List<Statistic> oldParseStatistics(JsonNode node) {
		Map<String, Integer> mappings = generateMappings(node.get("columns").findValuesAsText("code"), Statistic.getCodes());

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

	private static final List<Map<String, String>> genericParse(JsonNode node, List<String> codes) {
		Map<String, Integer> mappings = generateMappings(node.get("columns").findValuesAsText("code"), codes);

		JsonNode data = node.get("data");

		List<JsonNode> keys = data.findValues("key");
		List<JsonNode> values = data.findValues("values");

		List<Map<String, String>> contents = new ArrayList<Map<String, String>>();
		for (int j = 0; j < keys.size(); j++) {
			JsonNode keyAtPosition = keys.get(j);

			Map<String, String> keyContents = new HashMap<String, String>();
			for (String code : codes) {
				if (mappings.containsKey(code)) {
					keyContents.put(code, keyAtPosition.get(mappings.get(code)).asText());
				}
			}

			JsonNode valueAtPosition = values.get(j);
			String value = valueAtPosition.get(0).asText();
			keyContents.put("Value", value);

			contents.add(keyContents);
		}
		return contents;
	}

	public static final List<Statistic> parseStatistics(JsonNode node) {
		List<Map<String, String>> contents = genericParse(node, Statistic.getCodes());

		List<Statistic> statistics = new ArrayList<Statistic>();
		for (Map<String, String> map : contents) {
			Statistic statistic = new Statistic(map.get("Region"), RelationshipStatus.of(map.get("Civilstand")), map.get("Alder"), Gender.of(ParseUtility.parseInteger(map.get("Kon"), null)),
					ParseUtility.parseInteger(map.get("Tid"), null), ParseUtility.parseLong(map.get("Value"), null));
			statistics.add(statistic);
		}
		return statistics;
	}

	private static final Map<String, Integer> generateMappings(List<String> inputCodes, List<String> storedCodes) {
		Map<String, Integer> mappings = new HashMap<String, Integer>();
		int i = 0;
		for (String input : inputCodes) {
			if (inputCodes.contains(input)) {
				mappings.put(input, i);
				i++;
			}
		}
		return mappings;
	}

	public static final List<String> getCodes(String content) {
		JsonNode data = getNode(content);
		List<String> codes = data.findValuesAsText("code");

		return codes;
	}
}
