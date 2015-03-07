package org.dannil.scbapi.api.environment.landandwaterarea;

import java.util.List;

import org.dannil.scbapi.model.environment.landandwaterarea.Area;

public interface AreaOperations {

	public List<Area> getArea();

	public List<Area> getArea(List<String> regions, List<String> types, List<Integer> years);

}
