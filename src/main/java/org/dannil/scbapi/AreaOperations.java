package org.dannil.scbapi;

import java.util.List;

import org.dannil.scbapi.model.AreaCollection;

public interface AreaOperations {

	public AreaCollection getArea();

	public AreaCollection getArea(List<String> regions, List<String> types, List<Integer> years);

}
