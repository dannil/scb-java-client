package org.dannil.scbapi.api.population;

import java.util.List;

import org.dannil.scbapi.model.population.StatisticsCollection;

public interface StatisticsOperations {

	public StatisticsCollection getPopulation();

	public StatisticsCollection getPopulation(List<String> regions, List<Integer> years);

}
