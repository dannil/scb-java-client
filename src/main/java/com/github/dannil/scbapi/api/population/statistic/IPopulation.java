package com.github.dannil.scbapi.api.population.statistic;

import java.util.List;

import com.github.dannil.scbapi.model.population.statistic.Population;

public interface IPopulation {

	List<Population> getPopulation();

	List<Population> getPopulation(List<String> regions, List<String> relationshipStatuses, List<String> ages, List<Integer> genders, List<Integer> years);

}
