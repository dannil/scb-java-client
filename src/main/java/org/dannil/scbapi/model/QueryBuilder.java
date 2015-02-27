package org.dannil.scbapi.model;

public final class QueryBuilder<E> {

	public QueryBuilder() {

	}

	public final String buildQuery(String table, String code, E[] values) {
		StringBuilder builder = new StringBuilder();
		builder.append("{");
		builder.append("\"query\": [");
		builder.append("{");
		builder.append("\"code\": \"ContentsCode\",");
		builder.append("\"selection\": {");
		builder.append("\"filter\": \"item\",");
		builder.append("\"values\": [");
		builder.append("\"" + table + "\"");
		builder.append("]");
		builder.append("}");
		builder.append("},");
		builder.append("{");
		builder.append("\"code\": \"" + code + "\",");
		builder.append("\"selection\": {");
		builder.append("\"filter\": \"item\",");
		builder.append("\"values\": [");

		for (int i = 0; i < values.length; i++) {
			builder.append("\"" + values[i] + "\"");
			if (i != values.length - 1) {
				builder.append(",");
			}
		}

		builder.append("]");
		builder.append("}");
		builder.append("}");
		builder.append("],");
		builder.append("\"response\": {");
		builder.append("\"format\": \"json\"");
		builder.append("}");
		builder.append("}");

		return builder.toString();
	}

}
