package org.dannil.scbapi.api.population;

import java.util.List;

import org.dannil.scbapi.model.population.Statistic;

public interface StatisticOperations {

	public List<Statistic> getPopulation();

	public List<Statistic> getPopulation(List<String> regions, List<Integer> years);

}
