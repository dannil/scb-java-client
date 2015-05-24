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

package org.dannil.scbapi.utility;

import java.util.List;
import java.util.Map;

public class QueryBuilder<E, K> {

	public QueryBuilder() {

	}

	public String build(Map<E, List<K>> map) {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append("\"query\": [");
		int i = 0;
		for (E code : map.keySet()) {
			builder.append("{");
			builder.append("\"code\": \"" + code + "\",");
			builder.append("\"selection\": {");
			builder.append("\"filter\": \"item\",");
			builder.append("\"values\": [");
			List<K> values = map.get(code);
			for (int j = 0; j < values.size(); j++) {
				builder.append("\"" + values.get(j) + "\"");
				if (j != values.size() - 1) {
					builder.append(",");
				}
			}
			builder.append("]");
			builder.append("}");
			builder.append("}");
			if (i != map.keySet().size() - 1) {
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
