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

package com.github.dannil.scbjavaclient.format;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.dannil.scbjavaclient.exception.SCBClientParsingException;
import com.github.dannil.scbjavaclient.utility.StringUtility;

// /**
// * <p>
// * Utility class for converting the specified JSON to Java objects and vice versa. Also contains
// * operations to retrieve values from the JSON.
// * </p>
// *
// * @author Daniel Nilsson
// */
public final class JsonConventionalFormat implements JsonFormat {

	private JsonConverter converter;

	private JsonNode json;

	/**
	 * <p>
	 * Default constructor.
	 * </p>
	 * 
	 * @param json
	 *            the json to format
	 */
	public JsonConventionalFormat(String json) {
		this.converter = new JsonConverter();
		this.json = this.converter.toNode(json);
		this.json = format();
	}

	@Override
	public JsonNode format() {
		// Make sure the input is in the standardized non-conventional format
		if (isFormatted() || isQuery(this.json)) {
			return this.json;
		}

		JsonNode columns = this.json.get("columns");
		JsonNode data = this.json.get("data");

		List<String> contentCodes = new ArrayList<String>();
		List<String> contentCodesTexts = new ArrayList<String>();

		List<String> codes = columns.findValuesAsText("code");
		List<String> texts = columns.findValuesAsText("text");

		List<Map<String, Object>> entries = new ArrayList<Map<String, Object>>();
		for (int i = 0; i < data.size(); i++) {
			Map<String, Object> map = new HashMap<String, Object>();

			JsonNode entry = data.get(i);

			// Sort out the content codes
			List<String> types = columns.findValuesAsText("type");
			for (int l = 0; l < codes.size(); l++) {
				if (types.get(l).equals("c")) {
					contentCodes.add(codes.get(l));
					contentCodesTexts.add(texts.get(l));
				}
			}

			// Get the key values and the value
			JsonNode keysNode = entry.get("key");
			JsonNode valuesNode = entry.get("values");

			for (int j = 0; j < keysNode.size(); j++) {
				String key = StringUtility.lowerCaseFirstLetter(codes.get(j));
				map.put(key, keysNode.get(j).asText());
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
		return this.converter.getMapper().convertValue(entries, JsonNode.class);
	}

	// /**
	// * <p>
	// * Converts the non-conventional JSON response from the SCB API into a more conventional
	// format,
	// * wrapped in a {@link JsonNode}.
	// * </p>
	// *
	// * @param json
	// * the json to format
	// * @return the formatted json
	// */
	// public JsonNode toConventionalJson(String json) {
	// JsonNode node = toNode(json);
	//
	// // Make sure the input is in the standardized non-conventional format
	// if (isConventionalJson(node) || isQuery(node)) {
	// return node;
	// }
	//
	// JsonNode columns = node.get("columns");
	// JsonNode data = node.get("data");
	//
	// List<String> contentCodes = new ArrayList<String>();
	// List<String> contentCodesTexts = new ArrayList<String>();
	//
	// List<String> codes = columns.findValuesAsText("code");
	// List<String> texts = columns.findValuesAsText("text");
	//
	// List<Map<String, Object>> entries = new ArrayList<Map<String, Object>>();
	// for (int i = 0; i < data.size(); i++) {
	// Map<String, Object> map = new HashMap<String, Object>();
	//
	// JsonNode entry = data.get(i);
	//
	// // Sort out the content codes
	// List<String> types = columns.findValuesAsText("type");
	// for (int l = 0; l < codes.size(); l++) {
	// if (types.get(l).equals("c")) {
	// contentCodes.add(codes.get(l));
	// contentCodesTexts.add(texts.get(l));
	// }
	// }
	//
	// // Get the key values and the value
	// JsonNode keysNode = entry.get("key");
	// JsonNode valuesNode = entry.get("values");
	//
	// for (int j = 0; j < keysNode.size(); j++) {
	// String key = StringUtility.lowerCaseFirstLetter(codes.get(j));
	// map.put(key, keysNode.get(j).asText());
	// }
	//
	// List<Map<String, String>> values = new ArrayList<Map<String, String>>(valuesNode.size());
	// for (int k = 0; k < valuesNode.size(); k++) {
	// Map<String, String> contents = new HashMap<String, String>();
	// contents.put("value", valuesNode.get(k).asText());
	// contents.put("code", contentCodes.get(k));
	// contents.put("text", contentCodesTexts.get(k));
	// values.add(contents);
	// }
	// map.put("values", values);
	//
	// entries.add(map);
	// }
	// return this.mapper.convertValue(entries, JsonNode.class);
	// }

	@Override
	public boolean isFormatted() {
		// Check if the node is correctly formatted
		return !(this.json.has("columns") || this.json.has("data") || this.json.has("comments") || !this.json.isArray());
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

	// /**
	// * <p>
	// * Converts the {@link JsonNode} into a list of the specified class.
	// * </p>
	// *
	// * @param node
	// * the node to process
	// * @param clazz
	// * the class to convert each JSON entry to
	// *
	// * @param <T>
	// * the data type of the list
	// * @return a list of elements, which type is the specified class. Each
	// * element represents the corresponding entry in the {@link JsonNode}
	// */
	// public <T> List<T> toListOf(Class<T> clazz) {
	// try {
	// JavaType type = this.mapper.getTypeFactory().constructCollectionType(List.class, clazz);
	//
	// this.mapper.r
	//
	// this.json.
	//
	// return this.mapper.readValue(toConventionalJson(), type);
	// } catch (IOException e) {
	// throw new SCBClientParsingException(e);
	// }
	// }

	/**
	 * <p>
	 * Converts the JSON string into a list of the specified class.
	 * </p>
	 * 
	 * // * @param json
	 * // * the json to process
	 * 
	 * @param clazz
	 *            the class to convert each JSON entry to
	 * 
	 * @param <T>
	 *            the data type of the list
	 * @return a list of elements, which type is the specified class. Each
	 *         element represents the corresponding entry in the JSON
	 */
	public <T> List<T> toListOf(Class<T> clazz) {
		try {
			JavaType type = this.converter.getMapper().getTypeFactory().constructCollectionType(List.class, clazz);

			return this.converter.getMapper().readValue(this.json.toString(), type);
		} catch (IOException e) {
			throw new SCBClientParsingException(e);
		}
	}

	/**
	 * <p>
	 * Extracts the codes and their respective values from the JSON.
	 * </p>
	 * 
	 * @return a collection of all codes and their respective values
	 */
	public Map<String, Collection<String>> getInputs() {
		if (this.json == null) {
			throw new SCBClientParsingException();
		}

		Map<String, Collection<String>> inputs = new HashMap<String, Collection<String>>();
		for (int i = 0; i < this.json.size(); i++) {
			JsonNode child = this.json.get(i);
			List<String> values = new ArrayList<String>();
			JsonNode valuesNode = child.get("values");
			for (int j = 0; j < valuesNode.size(); j++) {
				values.add(valuesNode.get(j).asText());
			}
			inputs.put(child.get("code").asText(), values);
		}
		return inputs;
	}

	@Override
	public List<String> getValues(String code) throws IllegalArgumentException {
		Map<String, Collection<String>> inputs = getInputs();
		if (!inputs.containsKey(code)) {
			throw new IllegalArgumentException();
		}
		return new ArrayList<String>(inputs.get(code));
	}

	@Override
	public List<String> getCodes() throws IllegalArgumentException {
		List<String> codes = new ArrayList<String>(getInputs().keySet());
		if (codes.size() == 0) {
			throw new IllegalArgumentException();
		}
		return codes;
	}

	// public JsonNode getJson() {
	// return this.json;
	// }

}
