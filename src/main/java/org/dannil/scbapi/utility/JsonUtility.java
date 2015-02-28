package org.dannil.scbapi.utility;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtility {

	public static final JsonNode getNode(String json, String field) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(json);
			return node.get("data");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
