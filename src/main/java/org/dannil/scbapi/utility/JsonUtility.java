package org.dannil.scbapi.utility;

import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtility {

	public static final JsonNode getNode(String json) {
		return getNode(json, null);
	}

	public static final JsonNode getNode(String json, String field) {
		try {
			ObjectMapper mapper = new ObjectMapper();
			JsonNode node = mapper.readTree(json);
			if (field != null) {
				return node.get(field);
			}
			return node;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
