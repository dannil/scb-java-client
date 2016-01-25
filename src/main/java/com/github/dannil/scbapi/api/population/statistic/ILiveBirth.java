package com.github.dannil.scbapi.api.population.statistic;

import java.util.List;

import com.github.dannil.scbapi.model.population.statistic.LiveBirth;

public interface ILiveBirth {

	List<LiveBirth> getLiveBirths();

	List<LiveBirth> getLiveBirths(List<String> regions, List<String> motherAge, List<Integer> genders, List<Integer> years);

}
