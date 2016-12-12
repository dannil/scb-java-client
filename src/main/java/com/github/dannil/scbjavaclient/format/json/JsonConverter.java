/*
 * Copyright 2016 Daniel Nilsson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.github.dannil.scbjavaclient.format.json;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dannil.scbjavaclient.exception.SCBClientParsingException;

/**
 * <p>Class which encapsulates methods for converting JSON.</p>
 * 
 * @since 0.1.0
 */
public class JsonConverter {

	private ObjectMapper mapper;

	/**
	 * <p>Default constructor. Initializes the
	 * {@link com.fasterxml.jackson.databind.ObjectMapper ObjectMapper} needed for
	 * converting objects.</p>
	 */
	public JsonConverter() {
		this.mapper = new ObjectMapper();
	}

	/**
	 * <p>Getter for mapper.</p>
	 * 
	 * @return the mapper
	 */
	public ObjectMapper getMapper() {
		return this.mapper;
	}

	/**
	 * <p>Parse the JSON string into a {@link JsonNode} object.</p>
	 * 
	 * @param json
	 *            the JSON content
	 * 
	 * @return a {@link JsonNode} object
	 */
	public JsonNode toNode(String json) {
		return toNode(json, null);
	}

	/**
	 * <p>Parse the JSON string into a {@link JsonNode} object with the specified field as
	 * root field.</p>
	 * 
	 * @param json
	 *            the JSON content
	 * @param field
	 *            the field in the JSON to become the root
	 * @return a {@link JsonNode} object with the specified field as root.
	 */
	public JsonNode toNode(String json, String field) {
		try {
			JsonNode node = this.mapper.readTree(json);
			if (field != null) {
				return node.get(field);
			}
			return node;
		} catch (IOException e) {
			throw new SCBClientParsingException(e);
		}
	}
}
