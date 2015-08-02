/*
Copyright 2014 Daniel Nilsson

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

package com.github.dannil.scbapi.utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dannil.scbapi.model.environment.landandwaterarea.Area;
import com.github.dannil.scbapi.model.environment.landandwaterarea.Area.Type;
import com.github.dannil.scbapi.model.population.statistic.Statistic;
import com.github.dannil.scbapi.model.population.statistic.Statistic.Gender;
import com.github.dannil.scbapi.model.population.statistic.Statistic.RelationshipStatus;

public class JsonUtility {

	public static JsonNode getNode(String json) {
		return getNode(json, null);
	}

	public static JsonNode getNode(String json, String field) {
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

	private static List<Map<String, String>> genericParse(JsonNode node, List<String> codes) {
		JsonNode columns = node.get("columns");
		if (columns == null) {
			throw new NullPointerException("Non-existing element in the JSON: \"columns\"");
		}

		Map<String, Integer> mappings = generateMappings(columns.findValuesAsText("code"), codes);

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

	public static List<Area> parseAreas(JsonNode node) {
		List<Map<String, String>> contents = genericParse(node, Area.getCodes());

		List<Area> areas = new ArrayList<Area>();
		for (Map<String, String> map : contents) {
			Area area = new Area(map.get("Region"), Type.of(map.get("ArealTyp")), ParseUtility.parseInteger(map.get("Tid"), null), ParseUtility.parseDouble(map.get("Value"), null));
			areas.add(area);
		}
		return areas;
	}

	public static List<Statistic> parseStatistics(JsonNode node) {
		List<Map<String, String>> contents = genericParse(node, Statistic.getCodes());

		List<Statistic> statistics = new ArrayList<Statistic>();
		for (Map<String, String> map : contents) {
			Statistic statistic = new Statistic(map.get("Region"), RelationshipStatus.of(map.get("Civilstand")), map.get("Alder"), Gender.of(ParseUtility.parseInteger(map.get("Kon"), null)),
					ParseUtility.parseInteger(map.get("Tid"), null), ParseUtility.parseLong(map.get("Value"), null));
			statistics.add(statistic);
		}
		return statistics;
	}

	private static Map<String, Integer> generateMappings(List<String> inputCodes, List<String> storedCodes) {
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

	public static List<String> getCodes(String content) {
		JsonNode data = getNode(content);
		List<String> codes = data.findValuesAsText("code");

		return codes;
	}
}
