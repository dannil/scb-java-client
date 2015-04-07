package org.dannil.scbapi.api.environment.landandwaterarea;

import java.util.List;

import org.dannil.scbapi.model.environment.landandwaterarea.Area;
import org.dannil.scbapi.model.environment.landandwaterarea.Area.Type;

public interface AreaOperations {

	public List<Area> getArea();

	public List<Area> getArea(List<String> regions, List<Type> types, List<Integer> years);

}
