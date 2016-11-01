package com.github.dannil.scbjavaclient.format;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonAPITableFormat implements IJsonTableFormat {

	private JsonConverter converter;

	private JsonNode json;

	private Map<String, Collection<String>> inputs;

	/**
	 * Default constructor.
	 * 
	 * @param json
	 *            the json to format
	 */
	public JsonAPITableFormat(String json) {
		this.converter = new JsonConverter();
		this.json = this.converter.toNode(json);
	}

	@Override
	public Map<String, Collection<String>> getInputs() {
		if (this.inputs != null) {
			return this.inputs;
		}

		JsonNode variables = this.json.get("variables");

		Map<String, Collection<String>> inputs = new HashMap<String, Collection<String>>();
		for (int i = 0; i < variables.size(); i++) {
			JsonNode entry = variables.get(i);
			List<String> values = new ArrayList<String>();
			JsonNode valuesNode = entry.get("values");
			for (int j = 0; j < valuesNode.size(); j++) {
				values.add(valuesNode.get(j).asText());
			}
			inputs.put(entry.get("code").asText(), values);
		}

		this.inputs = inputs;

		return inputs;
	}

	@Override
	public List<String> getCodes() throws IllegalArgumentException {
		List<String> codes = new ArrayList<String>(getInputs().keySet());
		if (codes.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return codes;
	}

	@Override
	public List<String> getValues(String code) throws IllegalArgumentException {
		Map<String, Collection<String>> inputs = getInputs();
		if (!inputs.containsKey(code)) {
			throw new IllegalArgumentException();
		}
		return new ArrayList<String>(inputs.get(code));
	}

}
