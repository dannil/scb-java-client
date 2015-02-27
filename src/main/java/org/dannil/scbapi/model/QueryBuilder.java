package org.dannil.scbapi.model;

public final class QueryBuilder<E> {

	public QueryBuilder() {

	}

	public final String buildQuery(String table, String code, E[] data) {
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
		builder.append("\"code\": \"Tid\",");
		builder.append("\"selection\": {");
		builder.append("\"filter\": \"item\",");
		builder.append("\"values\": [");

		for (E dataObj : data) {
			if (dataObj != data[data.length - 1]) {
				builder.append("\"" + dataObj + "\",");
			} else {
				builder.append("\"" + dataObj + "\"");
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
