package org.dannil.scbapi.api.population.statistic;

import java.util.List;

import org.dannil.scbapi.model.population.statistic.Statistic;
import org.dannil.scbapi.model.population.statistic.Statistic.Gender;
import org.dannil.scbapi.model.population.statistic.Statistic.RelationshipStatus;

public interface StatisticOperations {

	public List<Statistic> getPopulation();

	public List<Statistic> getPopulation(List<String> regions, List<RelationshipStatus> relationshipStatuses, List<String> ages, List<Gender> genders, List<Integer> years);

}
