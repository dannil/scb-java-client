/*
Copyright 2014 Daniel Nilsson

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

package com.github.dannil.scbapi.api.population.statistic;

import java.util.List;

import com.github.dannil.scbapi.model.population.Gender;
import com.github.dannil.scbapi.model.population.RelationshipStatus;
import com.github.dannil.scbapi.model.population.statistic.LiveBirth;
import com.github.dannil.scbapi.model.population.statistic.Population;

public interface StatisticOperations {

	List<LiveBirth> getLiveBirths();

	List<LiveBirth> getLiveBirths(List<String> regions, List<String> motherAge, List<Gender> genders, List<Integer> years);

	List<Population> getPopulation();

	List<Population> getPopulation(List<String> regions, List<RelationshipStatus> relationshipStatuses, List<String> ages, List<Gender> genders, List<Integer> years);

}
