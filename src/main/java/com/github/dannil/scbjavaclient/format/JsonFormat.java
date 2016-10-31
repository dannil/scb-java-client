package com.github.dannil.scbjavaclient.format;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

// TODO Add docs here
public interface JsonFormat {

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

	/**
	 * <p>
	 * Extracts the values for a code from the JSON.
	 * </p>
	 * 
	 * @param code
	 *            the code
	 * @return a list of values
	 * @throws IllegalArgumentException
	 *             if the JSON doesn't contain the code
	 */
	List<String> getValues(String code) throws IllegalArgumentException;

	/**
	 * <p>
	 * Extracts the codes from the JSON.
	 * </p>
	 * 
	 * @return a list of codes
	 * @throws IllegalArgumentException
	 *             if the JSON doesn't contain codes
	 */
	List<String> getCodes() throws IllegalArgumentException;

}
