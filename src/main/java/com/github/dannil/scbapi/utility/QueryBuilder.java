/*
Copyright 2014 Daniel Nilsson

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

package com.github.dannil.scbapi.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;

public class QueryBuilder {

	private static QueryBuilder builder;

	private static Object lock = new Object();

	public static QueryBuilder getInstance() {
		// Synchronized instance
		synchronized (lock) {
			if (builder == null) {
				builder = new QueryBuilder();
			}
			return builder;
		}
	}

	private QueryBuilder() {

	}

	private List<?> filterValue(List<?> entry, Object value) {
		List<Object> filteredValues = new ArrayList<Object>();
		for (Object o : entry) {
			if (!Objects.equals(o, value)) {
				filteredValues.add(o);
			}
		}
		return filteredValues;
	}

	public String build(Map<String, List<?>> inputMap) {
		// Filter out null values
		Map<String, List<?>> filteredMap = new HashMap<String, List<?>>();

		for (Entry<String, List<?>> entry : inputMap.entrySet()) {
			if (entry.getValue() != null) {
				filteredMap.put(entry.getKey(), filterValue(entry.getValue(), null));
			}
		}

		// Approximate a good initial capacity for the string buffer
		int size = Math.max(44 + (80 * filteredMap.size()), 256);
		StringBuilder builder = new StringBuilder(size);

		// Construct the query
		builder.append("{\"query\": [");
		int i = 0;
		for (Entry<String, List<?>> entry : filteredMap.entrySet()) {
			builder.append("{\"code\": \"" + entry.getKey() + "\",\"selection\": {\"filter\": \"item\",\"values\": [");
			List<?> values = entry.getValue();
			for (int j = 0; j < values.size(); j++) {
				builder.append("\"" + values.get(j) + "\"");
				if (j != values.size() - 1) {
					builder.append(',');
				}
			}
			builder.append("]}}");
			if (i != filteredMap.size() - 1) {
				builder.append(',');
			}
			i++;
		}
		builder.append("],\"response\": {\"format\": \"json\"}}");

		return builder.toString();
	}
}
