package com.github.dannil.scbjavaclient.format;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dannil.scbjavaclient.exception.SCBClientParsingException;

public class JsonConverter {

	private ObjectMapper mapper;

	public JsonConverter() {
		this.mapper = new ObjectMapper();
	}

	public ObjectMapper getMapper() {
		return this.mapper;
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
	public JsonNode toNode(String json) {
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
