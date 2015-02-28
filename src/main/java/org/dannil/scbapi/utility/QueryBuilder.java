package org.dannil.scbapi.utility;

import java.util.List;

import com.google.common.collect.ArrayListMultimap;

public final class QueryBuilder<E, K> {

	public QueryBuilder() {

	}

	public final String build(ArrayListMultimap<E, K> map) {
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
		}
		builder.append("],");
		builder.append("\"response\": {");
		builder.append("\"format\": \"json\"");
		builder.append("}");
		builder.append("}");

		return builder.toString();
	}

}
