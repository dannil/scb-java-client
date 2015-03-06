package org.dannil.scbapi.api.population;

import java.util.List;

import org.dannil.scbapi.model.population.StatisticCollection;

public interface StatisticOperations {

	public StatisticCollection getPopulation();

	public StatisticCollection getPopulation(List<String> regions, List<Integer> years);

}
