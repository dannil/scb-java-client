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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * <p>Class which encapsulates behavior for the JSON API table format. Note that this
 * class is immutable; to change the containing JSON, a new class needs to be
 * instantiated.</p>
 * 
 * @author Daniel Nilsson
 */
public class JsonAPITableFormat implements IJsonTableFormat {

	private JsonNode json;

	private Map<String, Collection<String>> inputs;

	/**
	 * <p>Default constructor.</p>
	 * 
	 * @param json
	 *            the json to format
	 */
	public JsonAPITableFormat(String json) {
		this.json = new JsonConverter().toNode(json);
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
	public List<String> getCodes() {
		List<String> codes = new ArrayList<String>(getInputs().keySet());
		if (!codes.isEmpty()) {
			return codes;
		}
		return null;
	}

	@Override
	public List<String> getValues(String code) {
		Map<String, Collection<String>> inputs = getInputs();
		if (inputs.containsKey(code)) {
			return new ArrayList<String>(inputs.get(code));
		}
		return null;
	}

	@Override
	public String toString() {
		return this.json.toString();
	}

}
