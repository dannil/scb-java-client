/*
 * Copyright 2017 Daniel Nilsson
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
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.dannil.scbjavaclient.format.ITableFormat;

/**
 * <p>Class which encapsulates behavior for the JSON API config table format. Note that
 * this class is immutable; to change the containing JSON, a new class needs to be
 * instantiated.</p>
 *
 * @since 0.2.0
 */
public class JsonAPIConfigTableFormat implements ITableFormat {

    private JsonNode json;

    private Map<String, Collection<String>> inputs;

    /**
     * <p>Default constructor.</p>
     *
     * @param json
     *            the JSON to format
     */
    public JsonAPIConfigTableFormat(String json) {
        super();
        this.json = new JsonConverter().toNode(json);
    }

    @Override
    public Map<String, Collection<String>> getPairs() {
        if (this.inputs != null) {
            return this.inputs;
        }
        this.inputs = new HashMap<>();
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
    public String toString() {
        return this.json.toString();
    }

}
