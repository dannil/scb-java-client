package org.dannil.scbapi.model;

import java.util.List;

public final class QueryBuilder {

	public QueryBuilder() {

	}

	public final String build(String[] codes, List<Object[]> values) {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append("\"query\": [");
		for (int i = 0; i < codes.length; i++) {
			builder.append("{");
			builder.append("\"code\": \"" + codes[i] + "\",");
			builder.append("\"selection\": {");
			builder.append("\"filter\": \"item\",");
			builder.append("\"values\": [");
			Object[] data = values.get(i);
			for (int k = 0; k < data.length; k++) {
				builder.append("\"" + data[k] + "\"");
				if (k != data.length - 1) {
					builder.append(",");
				}
			}
			builder.append("]");
			builder.append("}");
			builder.append("}");
			if (i != codes.length - 1) {
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
