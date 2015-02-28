package org.dannil.scbapi.utility;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.dannil.scbapi.model.PopulationCollection;

public class JsonParser {

	public static final Object parseJson(Object parseTo, String json) {
		if (parseTo instanceof PopulationCollection) {
			return parseToPopulationCollection(json);
		}
		return null;
	}

	private static final PopulationCollection parseToPopulationCollection(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(json);
			return new PopulationCollection(node.get("data"));
		} catch (IOException e) {
			throw new RuntimeException();
		}
	}
}
