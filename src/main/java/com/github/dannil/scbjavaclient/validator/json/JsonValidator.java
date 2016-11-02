package com.github.dannil.scbjavaclient.validator.json;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * <p>
 * Class which contains operations for validating and confirming JSON.
 * </p>
 * 
 * @author Daniel Nilsson
 */
public final class JsonValidator {

	/**
	 * <p>
	 * Private constructor to prevent instantiation.
	 * </p>
	 */
	private JsonValidator() {

	}

	/**
	 * <p>
	 * Checks if the JSON is a query.
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
}
