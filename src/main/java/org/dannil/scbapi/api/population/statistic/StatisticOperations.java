package org.dannil.scbapi.api.population.statistic;

import java.util.List;

import org.dannil.scbapi.model.population.statistic.Statistic;

public interface StatisticOperations {

	public List<Statistic> getPopulation();

	public List<Statistic> getPopulation(List<String> regions, List<String> relationshipStatuses, List<String> ages, List<Integer> genders, List<Integer> years);

}
