package com.github.dannil.scbjavaclient.format;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface IJsonTableFormat {

	/**
	 * <p>
	 * Extracts the codes and their respective values from the JSON.
	 * </p>
	 * 
	 * @return a collection of all codes and their respective values
	 */
	Map<String, Collection<String>> getInputs();

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
