package org.dannil.scbapi.api.population.statistic;

import java.util.List;

import org.dannil.scbapi.model.population.statistic.PopulationStatistic;

public interface StatisticOperations {

	public List<PopulationStatistic> getPopulation();

	public List<PopulationStatistic> getPopulation(List<String> regions, List<Integer> years);

}
