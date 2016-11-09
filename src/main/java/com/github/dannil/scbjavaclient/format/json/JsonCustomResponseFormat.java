/*
 * Copyright 2016 Daniel Nilsson
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

package com.github.dannil.scbjavaclient.format.json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.dannil.scbjavaclient.exception.SCBClientParsingException;
import com.github.dannil.scbjavaclient.utility.StringUtility;
import com.github.dannil.scbjavaclient.validator.json.JsonValidator;

/**
 * <p>Class which encapsulates behavior for the custom JSON response format. Note that this class is
 * immutable; to change the containing JSON, a new class needs to be instantiated.</p>
 * 
 * @author Daniel Nilsson
 */
public final class JsonCustomResponseFormat implements IJsonResponseFormat {

	private JsonConverter converter;

	private JsonNode json;

	/**
	 * <p>Default constructor.</p>
	 * 
	 * @param json
	 *            the json to format
	 */
	public JsonCustomResponseFormat(String json) {
		this.converter = new JsonConverter();
		this.json = this.converter.toNode(json);
		this.json = format();
	}

	@Override
	public JsonNode format() {
		// Make sure the input is in the standardized non-conventional format
		if (isFormatted() || JsonValidator.isQuery(this.json)) {
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

	@Override
	public boolean isFormatted() {
		// Check if the node is correctly formatted
		return !(this.json.has("columns") || this.json.has("data") || this.json.has("comments") || !this.json.isArray());
	}

	/**
	 * <p>Converts the JSON string into a list of the specified class.</p>
	 * 
	 * @param clazz
	 *            the class to convert each JSON entry to
	 * @param <T>
	 *            the data type of the list
	 * @return a list of elements, which type is the specified class. Each element represents the
	 *         corresponding entry in the JSON
	 */
	public <T> List<T> toListOf(Class<T> clazz) {
		try {
			JavaType type = this.converter.getMapper().getTypeFactory().constructCollectionType(List.class, clazz);

			return this.converter.getMapper().readValue(this.json.toString(), type);
		} catch (IOException e) {
			throw new SCBClientParsingException(e);
		}
	}

	@Override
	public String toString() {
		return this.json.toString();
	}

}
