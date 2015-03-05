package org.dannil.scbapi.model;

import java.util.ArrayList;
import java.util.List;

import org.dannil.scbapi.api.environment.AreaOperations;

import com.fasterxml.jackson.databind.JsonNode;

public final class AreaCollection implements AreaOperations {

	private List<Area> areas;

	private AreaCollection() {
		this.areas = new ArrayList<Area>();
	}

	public AreaCollection(JsonNode node) {
		this();

		JsonNode data = node.get("data");

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
		return this;
	}

	@Override
	public AreaCollection getArea(List<String> regions, List<String> types, List<Integer> years) {
		final AreaCollection c = new AreaCollection();
		for (Area a : c.getAreas()) {
			if (regions == null && types == null && years == null) {
				return this;
			} else if (regions == null && types == null) {
				for (Integer year : years) {
					if (a.getYear().equals(year)) {
						c.add(a);
					}
				}
			} else if (regions == null && years == null) {
				for (String type : types) {
					if (a.getType() == type) {
						c.add(a);
					}
				}
			} else if (types == null && years == null) {
				for (String region : regions) {
					if (a.getRegion().equals(region)) {
						c.add(a);
					}
				}
			} else if (regions == null) {
				for (String type : types) {
					for (Integer year : years) {
						if (a.getType() == type && a.getYear().equals(year)) {
							c.add(a);
						}
					}
				}
			} else if (types == null) {
				for (String region : regions) {
					for (Integer year : years) {
						if (a.getRegion().equals(region) && a.getYear().equals(year)) {
							c.add(a);
						}
					}
				}
			} else if (years == null) {
				for (String region : regions) {
					for (String type : types) {
						if (a.getRegion().equals(region) && a.getType() == type) {
							c.add(a);
						}
					}
				}
			} else {
				for (String region : regions) {
					for (String type : types) {
						for (Integer year : years) {
							if (a.getRegion().equals(region) && a.getType() == type && a.getYear().equals(year)) {
								c.add(a);
							}
						}
					}
				}
			}
		}
		return c;
	}

	public void add(Area a) {
		this.areas.add(a);
	}

	public List<Area> getAreas() {
		return this.areas;
	}

}
