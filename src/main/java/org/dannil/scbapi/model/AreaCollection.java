package org.dannil.scbapi.model;

import java.util.ArrayList;
import java.util.List;

import org.dannil.scbapi.AreaOperations;

import com.fasterxml.jackson.databind.JsonNode;

public final class AreaCollection implements AreaOperations {

	private List<Area> areas;

	private AreaCollection() {
		this.areas = new ArrayList<Area>();
	}

	public AreaCollection(JsonNode data) {
		this();

		List<JsonNode> keys = data.findValues("key");
		List<JsonNode> values = data.findValues("values");

		for (int i = 0; i < keys.size(); i++) {
			String region = null;
			String type = null;
			Integer year = null;

			JsonNode keyAtPosition = keys.get(i);
			if (keyAtPosition.size() < 3) {
				region = keyAtPosition.get(0).asText();
				year = keyAtPosition.get(1).asInt();
			} else {
				region = keyAtPosition.get(0).asText();
				type = keyAtPosition.get(1).asText();
				year = keyAtPosition.get(2).asInt();
			}

			JsonNode valueAtPosition = values.get(i);
			final Double squareKm = valueAtPosition.get(0).asDouble();

			Area a = new Area(region, type, year, squareKm);
			this.areas.add(a);
		}
	}

	@Override
	public AreaCollection getArea() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AreaCollection getArea(List<String> regions, List<String> types, List<Integer> years) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Area> getAreas() {
		return this.areas;
	}

}
