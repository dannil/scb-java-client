package org.dannil.scbapi;

import java.util.List;

import org.dannil.scbapi.model.AverageAgeFirstChild;

public interface DemographyOperations {

	public List<AverageAgeFirstChild> getAverageAgeFirstChild();

	public List<AverageAgeFirstChild> getAverageAgeFirstChild(List<String> regions, List<Integer> genders, List<Integer> years);

}
