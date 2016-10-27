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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dannil.scbjavaclient.exception.SCBClientParsingException;

/**
 * <p>
 * Utility class for converting JSON to Java objects.
 * </p>
 * 
 * @author Daniel Nilsson
 */
public final class JsonUtility {

	private static ObjectMapper mapper;

	static {
		mapper = new ObjectMapper();
	}

	/**
	 * <p>
	 * Private constructor to prevent instantiation.
	 * </p>
	 */
	private JsonUtility() {

	}

	/**
	 * <p>
	 * Parse the JSON string into a {@link JsonNode} object.
	 * </p>
	 * 
	 * @param json
	 *            the JSON content
	 * 
	 * @return a {@link JsonNode} object
	 */
	public static JsonNode toNode(String json) {
		return toNode(json, null);
	}

	/**
	 * <p>
	 * Parse the JSON string into a {@link JsonNode} object with the specified field as root field.
	 * </p>
	 * 
	 * @param json
	 *            the JSON content
	 * @param field
	 *            the field in the JSON to become the root
	 * @return a {@link JsonNode} object with the specified field as root.
	 */
	public static JsonNode toNode(String json, String field) {
		try {
			JsonNode node = mapper.readTree(json);
			if (field != null) {
				return node.get(field);
			}
			return node;
		} catch (IOException e) {
			throw new SCBClientParsingException(e);
		}
	}

	/**
	 * <p>
	 * Converts the non-conventional JSON response from the SCB API into a more conventional format,
	 * wrapped in a {@link JsonNode}.
	 * </p>
	 * 
	 * @param json
	 *            the json to format
	 * @return the formatted json
	 */
	public static JsonNode toConventionalJson(String json) {
		JsonNode node = toNode(json);

		// Make sure the input is in the standardized non-conventional format
		if (isConventionalJson(node) || isQuery(node)) {
			return node;
		}

		JsonNode columns = node.get("columns");
		JsonNode data = node.get("data");

		List<String> contentCodes = new ArrayList<String>();
		List<String> contentCodesTexts = new ArrayList<String>();

		List<String> codes = columns.findValuesAsText("code");
		List<String> texts = columns.findValuesAsText("text");

		List<Map<String, Object>> entries = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < data.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();

			JsonNode entry = data.get(i);

			// Get the key values and the value
			JsonNode keysNode = entry.get("key");
			JsonNode valuesNode = entry.get("values");

			for (int j = 0; j < keysNode.size(); j++) {
				String key = StringUtility.lowerCaseFirstLetter(codes.get(j));
				map.put(key, keysNode.get(j).asText());
			}

			// Sort out the content codes
			List<String> types = columns.findValuesAsText("type");
			for (int l = 0; l < codes.size(); l++) {
				if (types.get(l).equals("c")) {
					contentCodes.add(codes.get(l));
					contentCodesTexts.add(texts.get(l));
				}
			}

			List<Map<String, String>> values = new ArrayList<Map<String, String>>(valuesNode.size());
			for (int k = 0; k < valuesNode.size(); k++) {
				Map<String, String> contents = new HashMap<String, String>();

				contents.put("value", valuesNode.get(k).asText());
				contents.put("code", contentCodes.get(k));
				contents.put("text", contentCodesTexts.get(k));

				values.add(contents);
			}
			map.put("values", values);

			entries.add(map);
		}
		return mapper.convertValue(entries, JsonNode.class);
	}

	/**
	 * <p>
	 * Checks if the node is formatted as the specified conventional format.
	 * </p>
	 * 
	 * @param node
	 *            the node to check
	 * @return true if the node is formatted as conventional format
	 */
	public static boolean isConventionalJson(JsonNode node) {
		// Check if the node is correctly formatted
		return !(node.has("columns") || node.has("data") || node.has("comments") || !node.isArray());
	}

	/**
	 * <p>
	 * Checks if the node is a query.
	 * </p>
	 * 
	 * @param node
	 *            the node to check
	 * @return true if the node is a query
	 */
	public static boolean isQuery(JsonNode node) {
		// Check if the node is actually a query
		return node.has("query");
	}

	/**
	 * <p>
	 * Converts the {@link JsonNode} into a list of the specified class.
	 * </p>
	 * 
	 * @param node
	 *            the node to process
	 * @param clazz
	 *            the class to convert each JSON entry to
	 * 
	 * @param <T>
	 *            the data type of the list
	 * @return a list of elements, which type is the specified class. Each element represents the
	 *         corresponding entry in the {@link JsonNode}
	 */
	public static <T> List<T> jsonToListOf(JsonNode node, Class<T> clazz) {
		return jsonToListOf(node.toString(), clazz);
	}

	/**
	 * <p>
	 * Converts the JSON string into a list of the specified class.
	 * </p>
	 * 
	 * @param json
	 *            the json to process
	 * @param clazz
	 *            the class to convert each JSON entry to
	 * 
	 * @param <T>
	 *            the data type of the list
	 * @return a list of elements, which type is the specified class. Each element represents the
	 *         corresponding entry in the JSON
	 */
	public static <T> List<T> jsonToListOf(String json, Class<T> clazz) {
		try {
			JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, clazz);

			return mapper.readValue(toConventionalJson(json).toString(), type);
		} catch (IOException e) {
			throw new SCBClientParsingException(e);
		}
	}

	/**
	 * <p>
	 * Extracts the codes and their respective values from the JSON.
	 * </p>
	 * 
	 * @param json
	 *            the JSON which should be parsed
	 * @return a collection of all codes and their respective values
	 */
	public static Map<String, Collection<String>> getInputs(String json) {
		Map<String, Collection<String>> inputs = new HashMap<String, Collection<String>>();

		JsonNode node = JsonUtility.toNode(json, "variables");
		if (node == null) {
			throw new SCBClientParsingException();
		}
		for (int i = 0; i < node.size(); i++) {
			JsonNode child = node.get(i);
			List<String> values = new ArrayList<String>();
			JsonNode valuesNode = child.get("values");
			for (int j = 0; j < valuesNode.size(); j++) {
				values.add(valuesNode.get(j).asText());
			}
			inputs.put(child.get("code").asText(), values);
		}
		return inputs;
	}

	/**
	 * <p>
	 * Extracts the values for a code from the JSON.
	 * </p>
	 * 
	 * @param json
	 *            the json
	 * @param code
	 *            the code
	 * @return a list of values
	 * @throws IllegalArgumentException
	 *             if the JSON doesn't contain the code
	 */
	public static List<String> getValues(String json, String code) throws IllegalArgumentException {
		Map<String, Collection<String>> inputs = getInputs(json);
		if (!inputs.containsKey(code)) {
			throw new IllegalArgumentException();
		}
		return (List<String>) inputs.get(code);
	}

	/**
	 * <p>
	 * Extracts the codes from the JSON.
	 * </p>
	 *
	 * @param json
	 *            the json which should be parsed
	 * @return a list of codes
	 */
	public static List<String> getCodes(String json) {
		return new ArrayList<String>(getInputs(json).keySet());
	}

}
