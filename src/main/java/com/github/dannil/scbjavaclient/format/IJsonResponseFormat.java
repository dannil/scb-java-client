package com.github.dannil.scbjavaclient.format;

import com.fasterxml.jackson.databind.JsonNode;

// TODO Add docs here
public interface IJsonResponseFormat {

	/**
	 * <p>
	 * Formats the JSON according to the specified implementing format.
	 * </p>
	 * 
	 * @return a formatted {@link com.fasterxml.jackson.databind.JsonNode JsonNode}
	 */
	JsonNode format();

	/**
	 * <p>
	 * Checks if the JSON is formatted as the specified format.
	 * </p>
	 * 
	 * @return true if the JSON is formatted as the implementing format
	 */
	boolean isFormatted();

	// /**
	// * Getter for JSON.
	// *
	// * @return the json
	// */
	// JsonNode getJson();

}
