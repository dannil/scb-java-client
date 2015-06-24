/*
Copyright 2014, 2015 Daniel Nilsson

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

package org.dannil.scbapi.utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class QueryBuilder {

	private Map<String, List<?>> map;

	public QueryBuilder(Map<String, List<?>> map) {
		this.map = map;
	}

	private void filter() {
		Map<String, List<?>> map = new HashMap<String, List<?>>();

		for (Entry<String, List<?>> entry : this.map.entrySet()) {
			if (entry.getKey() != null && entry.getValue() != null) {
				List<Object> values = new ArrayList<Object>();
				for (Object o : entry.getValue()) {
					if (o != null) {
						values.add(o);
					}
				}
				map.put(entry.getKey(), values);
			}
		}

		this.map = map;
	}

	public String build() {
		filter();

		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append("\"query\": [");
		int i = 0;
		for (Entry<String, List<?>> entry : this.map.entrySet()) {
			builder.append("{");
			builder.append("\"code\": \"" + entry.getKey() + "\",");
			builder.append("\"selection\": {");
			builder.append("\"filter\": \"item\",");
			builder.append("\"values\": [");
			List<?> values = entry.getValue();
			for (int j = 0; j < values.size(); j++) {
				builder.append("\"" + values.get(j) + "\"");
				if (j != values.size() - 1) {
					builder.append(",");
				}
			}
			builder.append("]");
			builder.append("}");
			builder.append("}");
			if (i != this.map.keySet().size() - 1) {
				builder.append(",");
			}
			i++;
		}
		builder.append("],");
		builder.append("\"response\": {");
		builder.append("\"format\": \"json\"");
		builder.append("}");
		builder.append("}");

		return builder.toString();
	}

}
