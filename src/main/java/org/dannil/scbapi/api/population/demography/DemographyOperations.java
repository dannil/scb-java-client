package org.dannil.scbapi.api.population.demography;

import java.util.List;

import org.dannil.scbapi.model.population.demography.AverageAgeFirstChild;

public interface DemographyOperations {

	public List<AverageAgeFirstChild> getAverageAgeFirstChild();

	public List<AverageAgeFirstChild> getAverageAgeFirstChild(List<String> regions, List<Integer> genders, List<Integer> years);

}
