package org.dannil.scbapi.api.environment;

import java.util.List;

import org.dannil.scbapi.model.Area;

public interface AreaOperations {

	public List<Area> getArea();

	public List<Area> getArea(List<String> regions, List<String> types, List<Integer> years);

}
