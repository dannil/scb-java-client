/*
 * Copyright 2014 Daniel Nilsson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dannil.scbjavaclient.utility;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.MissingNode;

/**
 * Utility class for converting JSON to Java objects
 * 
 * @author Daniel Nilsson
 */
public class JsonUtility {

	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
	}

	private JsonUtility() {

	}

	/**
	 * Parse the JSON string into a {@link JsonNode} object.
	 * 
	 * @param json
	 *            the JSON content
	 * 
	 * @return a {@link JsonNode} object
	 */
	public static JsonNode getNode(String json) {
		return getNode(json, null);
	}

	/**
	 * Parse the JSON string into a {@link JsonNode} object with the specified field as root field.
	 * 
	 * @param json
	 *            the JSON content
	 * @param field
	 *            the field in the JSON to become the root
	 * @return a {@link JsonNode} object with the specified field as root.
	 */
	public static JsonNode getNode(String json, String field) {
		try {
			JsonNode node = mapper.readTree(json);
			if (field != null) {
				return node.get(field);
			}
			return node;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return MissingNode.getInstance();
	}

	/**
	 * Converts the non-conventional JSON response from the SCB API into a more conventional format,
	 * wrapped in a {@link JsonNode}.
	 * 
	 * @param json
	 *            the json to format
	 * @return the formatted json
	 */
	public static JsonNode toConventionalJson(String json) {
		JsonNode node = getNode(json);

		JsonNode columns = node.get("columns");
		JsonNode data = node.get("data");

		List<String> codes = columns.findValuesAsText("code");

		List<Map<String, String>> entries = new ArrayList<Map<String, String>>();
		for (int i = 0; i < data.size(); i++) {
			Map<String, String> map = new HashMap<String, String>();

			JsonNode entry = data.get(i);

			// Get the key values and the value
			JsonNode keysNode = entry.get("key");
			JsonNode valuesNode = entry.get("values");

			for (int j = 0; j < keysNode.size(); j++) {
				String key = codes.get(j);

				// Lowercase first letter of key
				char c[] = key.toCharArray();
				c[0] = Character.toLowerCase(c[0]);
				key = new String(c);

				map.put(key, keysNode.get(j).asText());
			}
			map.put("value", valuesNode.get(0).asText());
			entries.add(map);
		}
		return mapper.convertValue(entries, JsonNode.class);
	}

	/**
	 * Converts the {@link JsonNode} into a list of the specified class.
	 * 
	 * @param <T>
	 *            the data type of the list
	 * @param clazz
	 *            the class to convert each JSON entry to
	 * @param node
	 *            the node to process
	 * @return a list of elements, which type is the specified class. Each element represents the
	 *         corresponding entry in the {@link JsonNode}
	 */
	public static <T> List<T> nodeToList(Class<?> clazz, JsonNode node) {
		try {
			JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, clazz);

			return mapper.readValue(node.toString(), type);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	// /**
	// * Parses the {@link JsonNode} into a list of keys and values with the help of the code input.
	// *
	// * @param node
	// * the node to parse
	// * @param codes
	// * the codes which should be parsed
	// * @return a list which contains the matching keys and values
	// */
	// private static List<Map<String, String>> genericParse(JsonNode node, List<String> codes) {
	// JsonNode columns = node.get("columns");
	// if (columns == null) {
	// throw new IllegalArgumentException("Non-existing element in JSON payload: \"columns\"");
	// }
	//
	// Map<String, Integer> mappings = generateMappings(columns.findValuesAsText("code"), codes);
	//
	// JsonNode data = node.get("data");
	//
	// List<JsonNode> keys = data.findValues("key");
	// List<JsonNode> values = data.findValues("values");
	//
	// List<Map<String, String>> contents = new ArrayList<Map<String, String>>();
	// for (int j = 0; j < keys.size(); j++) {
	// JsonNode keyAtPosition = keys.get(j);
	//
	// Map<String, String> keyContents = new HashMap<String, String>();
	// for (String code : codes) {
	// if (mappings.containsKey(code)) {
	// keyContents.put(code, keyAtPosition.get(mappings.get(code)).asText());
	// }
	// }
	//
	// JsonNode valueAtPosition = values.get(j);
	// String value = valueAtPosition.get(0).asText();
	// keyContents.put("Value", value);
	//
	// contents.add(keyContents);
	// }
	// return contents;
	// }

	// /**
	// * Parses the {@link JsonNode} into a list of
	// * {@link com.github.dannil.scbjavaclient.model.environment.landandwaterarea.Area Area}.
	// *
	// * @param node
	// * the node to parse
	// * @return a list of
	// * {@link com.github.dannil.scbjavaclient.model.environment.landandwaterarea.Area Area}
	// * objects
	// */
	// public static List<Area> parseAreas(JsonNode node) {
	// List<Map<String, String>> contents = genericParse(node, Area.getCodes());
	//
	// List<Area> areas = new ArrayList<Area>();
	// for (Map<String, String> map : contents) {
	// Area area = new Area(map.get("Region"), map.get("ArealTyp"),
	// ParseUtility.parseInteger(map.get("Tid")),
	// ParseUtility.parseDouble(map.get("Value")));
	// areas.add(area);
	// }
	// return areas;
	// }

	// /**
	// * Parses the {@link JsonNode} into a list of
	// * {@link com.github.dannil.scbjavaclient.model.population.demography.MeanAgeFirstChild
	// * MeanAgeFirstChild}.
	// *
	// * @param node
	// * the node to parse
	// * @return a list of
	// * {@link com.github.dannil.scbjavaclient.model.population.demography.MeanAgeFirstChild
	// * MeanAgeFirstChild} objects
	// */
	// public static List<MeanAgeFirstChild> parseAverageAgeFirstChild(JsonNode node) {
	// List<Map<String, String>> contents = genericParse(node, MeanAgeFirstChild.getCodes());
	//
	// List<MeanAgeFirstChild> averageAgeFirstChildren = new ArrayList<MeanAgeFirstChild>();
	// for (Map<String, String> map : contents) {
	//
	// MeanAgeFirstChild averageAgeFirstChild = new MeanAgeFirstChild();
	// averageAgeFirstChild.setRegion(map.get("Region"));
	// averageAgeFirstChild.setYear(ParseUtility.parseInteger(map.get("Tid")));
	// averageAgeFirstChild.setGender(ParseUtility.parseInteger(map.get("Kon")));
	// averageAgeFirstChild.setValue(ParseUtility.parseDouble(map.get("Value")));
	//
	// averageAgeFirstChildren.add(averageAgeFirstChild);
	// }
	// return averageAgeFirstChildren;
	// }

	// /**
	// * Parses the {@link JsonNode} into a list of
	// * {@link com.github.dannil.scbjavaclient.model.population.statistic.LiveBirth LiveBirth}.
	// *
	// * @param node
	// * the node to parse
	// * @return a list of
	// * {@link com.github.dannil.scbjavaclient.model.population.statistic.LiveBirth
	// * LiveBirth} objects
	// */
	// public static List<LiveBirth> parseLiveBirths(JsonNode node) {
	// List<Map<String, String>> contents = genericParse(node, LiveBirth.getCodes());
	//
	// List<LiveBirth> liveBirths = new ArrayList<LiveBirth>();
	// for (Map<String, String> map : contents) {
	//
	// LiveBirth liveBirth = new LiveBirth();
	// liveBirth.setRegion(map.get("Region"));
	// liveBirth.setYear(ParseUtility.parseInteger(map.get("Tid")));
	// liveBirth.setMotherAge(map.get("AlderModer"));
	// liveBirth.setGender(ParseUtility.parseInteger(map.get("Kon")));
	// liveBirth.setValue(ParseUtility.parseLong(map.get("Value")));
	//
	// liveBirths.add(liveBirth);
	// }
	// return liveBirths;
	// }

	// /**
	// * Parses the {@link JsonNode} into a list of
	// * {@link com.github.dannil.scbjavaclient.model.population.statistic.Population Population}.
	// *
	// * @param node
	// * the node to parse
	// * @return a list of
	// * {@link com.github.dannil.scbjavaclient.model.population.statistic.Population
	// * Population} objects
	// */
	// public static List<Population> parsePopulation(JsonNode node) {
	// List<Map<String, String>> contents = genericParse(node, Population.getCodes());
	//
	// List<Population> populations = new ArrayList<Population>();
	// for (Map<String, String> map : contents) {
	// Population population = new Population(map.get("Region"), map.get("Civilstand"),
	// map.get("Alder"),
	// ParseUtility.parseInteger(map.get("Kon")), ParseUtility.parseInteger(map.get("Tid")),
	// ParseUtility.parseLong(map.get("Value")));
	// populations.add(population);
	// }
	// return populations;
	// }

	// /**
	// * Generates the position for the input codes. Used by
	// * {@link JsonUtility#genericParse(JsonNode, List) genericParse(JsonNode, List)} to figure out
	// * the position for every key.
	// *
	// * @param inputCodes
	// * the input codes to calculated indexes for
	// * @param storedCodes
	// * the stored codes to match against the input codes
	// * @return a map which specifies what position (0-indexed) every key resides at
	// */
	// private static Map<String, Integer> generateMappings(List<String> inputCodes, List<String>
	// storedCodes) {
	// Map<String, Integer> mappings = new HashMap<String, Integer>();
	// int i = 0;
	// for (String input : inputCodes) {
	// if (storedCodes.contains(input)) {
	// mappings.put(input, i);
	// i++;
	// }
	// }
	// return mappings;
	// }

	/**
	 * Extracts the codes from the input.
	 *
	 * @param content
	 *            the input which should be parsed
	 * @return a list of codes for the input
	 */
	public static List<String> getCodes(String content) {
		JsonNode data = getNode(content);
		List<String> codes = data.findValuesAsText("code");

		return codes;
	}
}
