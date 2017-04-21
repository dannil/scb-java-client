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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;

/**
 * <p>Class which encapsulates behavior for the custom JSON response format. Note that
 * this class is immutable; to change the containing JSON, a new class needs to be
 * instantiated.</p>
 *
 * @since 0.1.0
 */
public final class JsonCustomResponseFormat {

    private List<Map<String, Object>> entries;

    private JsonConverter converter;

    private JsonNode json;

    /**
     * <p>Private constructor.</p>
     */
    private JsonCustomResponseFormat() {
        this.converter = new JsonConverter();
    }

    /**
     * <p>Default constructor.</p>
     *
     * @param json
     *            the JSON to format
     */
    public JsonCustomResponseFormat(String json) {
        this();
        this.entries = new ArrayList<>();
        this.json = this.converter.toNode(json);
        this.json = this.converter.convertValue(getEntries(), JsonNode.class);
    }

    /**
     * <p>Retrieves all the entries.</p>
     *
     * @return all the entries
     */
    public List<Map<String, Object>> getEntries() {
        if (!this.entries.isEmpty()) {
            return this.entries;
        }
        JsonNode columns = this.json.get("columns");
        JsonNode data = this.json.get("data");

        List<String> contentCodes = new ArrayList<>();
        List<String> contentCodesTexts = new ArrayList<>();

        List<String> codes = columns.findValuesAsText("code");
        List<String> texts = columns.findValuesAsText("text");

        for (int i = 0; i < data.size(); i++) {
            Map<String, Object> map = new HashMap<>();

            JsonNode entry = data.get(i);

            // Sort out the content codes
            List<String> types = columns.findValuesAsText("type");
            for (int l = 0; l < codes.size(); l++) {
                if ("c".equals(types.get(l))) {
                    contentCodes.add(codes.get(l));
                    contentCodesTexts.add(texts.get(l));
                }
            }

            // Get the key values and the value
            JsonNode keysNode = entry.get("key");
            JsonNode valuesNode = entry.get("values");

            Map<String, String> variables = new HashMap<>();
            for (int j = 0; j < keysNode.size(); j++) {
                variables.put(codes.get(j), keysNode.get(j).asText());
            }
            map.put("Variables", variables);

            List<Map<String, String>> values = new ArrayList<>();
            for (int k = 0; k < valuesNode.size(); k++) {
                Map<String, String> valuesContents = new HashMap<>();
                valuesContents.put("Value", valuesNode.get(k).asText());
                valuesContents.put("Code", contentCodes.get(k));
                valuesContents.put("Text", contentCodesTexts.get(k));
                values.add(valuesContents);
            }
            map.put("Values", values);

            this.entries.add(map);
        }
        return this.entries;
    }

    /**
     * <p>Converts the JSON string into a list of the specified class.</p>
     *
     * @param clazz
     *            the class to convert each JSON entry to
     * @param <T>
     *            the data type of the list
     * @return a list of elements, which type is the specified class. Each element
     *         represents the corresponding entry in the JSON
     */
    public <T> List<T> toListOf(Class<T> clazz) {
        return this.converter.toListOf(this.json.toString(), clazz);
    }

    @Override
    public String toString() {
        return this.json.toString();
    }

}
