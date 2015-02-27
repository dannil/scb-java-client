package org.dannil.scbapi.utility;

import java.util.List;

public final class QueryBuilder<E, K> {

	public QueryBuilder() {

	}

	public final String build(List<E> codes, List<List<K>> values) {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append("\"query\": [");
		for (int i = 0; i < codes.size(); i++) {
			builder.append("{");
			builder.append("\"code\": \"" + codes.get(i) + "\",");
			builder.append("\"selection\": {");
			builder.append("\"filter\": \"item\",");
			builder.append("\"values\": [");
			List<K> data = values.get(i);
			for (int j = 0; j < data.size(); j++) {
				builder.append("\"" + data.get(j) + "\"");
				if (j != data.size() - 1) {
					builder.append(",");
				}
			}
			builder.append("]");
			builder.append("}");
			builder.append("}");
			if (i != codes.size() - 1) {
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
