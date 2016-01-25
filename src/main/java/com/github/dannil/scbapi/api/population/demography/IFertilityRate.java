package com.github.dannil.scbapi.api.population.demography;

import java.util.List;

public interface IFertilityRate {

	List<Object> getFertilityRate();

	List<Object> getFertilityRate(List<String> regions, List<Integer> genders, List<Integer> years);

}
