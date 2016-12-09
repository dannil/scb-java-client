package com.github.dannil.scbjavaclient.format.json;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;

public class JsonAPIConfigTableFormat implements IJsonTableFormat {

	private JsonNode json;

	private Map<String, Collection<String>> inputs;

	/**
	 * <p>Default constructor.</p>
	 * 
	 * @param json
	 *            the json to format
	 */
	public JsonAPIConfigTableFormat(String json) {
		this.json = new JsonConverter().toNode(json);
	}

	@Override
	public Map<String, Collection<String>> getInputs() {
		if (this.inputs != null) {
			return this.inputs;
		}

		this.inputs = new HashMap<String, Collection<String>>();

		Iterator<Entry<String, JsonNode>> nodes = this.json.fields();
		while (nodes.hasNext()) {
			Entry<String, JsonNode> entry = nodes.next();

			Collection<String> values = new ArrayList<>();
			values.add(entry.getValue().asText());

			this.inputs.put(entry.getKey(), values);
		}

		return this.inputs;
	}

	@Override
	public List<String> getCodes() {
		List<String> codes = new ArrayList<>(getInputs().keySet());
		if (!codes.isEmpty()) {
			return codes;
		}
		return Collections.emptyList();
	}

	@Override
	public List<String> getValues(String code) {
		Map<String, Collection<String>> fetchedInputs = getInputs();
		if (fetchedInputs.containsKey(code)) {
			return new ArrayList<>(fetchedInputs.get(code));
		}
		return Collections.emptyList();
	}

	@Override
	public String toString() {
		return this.json.toString();
	}

}
