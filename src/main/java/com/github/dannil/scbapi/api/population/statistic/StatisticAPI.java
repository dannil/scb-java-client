/*
Copyright 2014, 2015 Daniel Nilsson

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

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbapi.api.AbstractAPI;
import com.github.dannil.scbapi.model.population.Gender;
import com.github.dannil.scbapi.model.population.RelationshipStatus;
import com.github.dannil.scbapi.model.population.statistic.LiveBirth;
import com.github.dannil.scbapi.model.population.statistic.Population;
import com.github.dannil.scbapi.utility.JsonUtility;
import com.github.dannil.scbapi.utility.ListUtility;

public class StatisticAPI extends AbstractAPI implements StatisticOperations {

	public StatisticAPI() {
		super.locale = Locale.getDefault();
	}

	public StatisticAPI(Locale locale) {
		this();
		super.locale = locale;
	}

	@Override
	public void setLocale(Locale locale) {
		super.locale = locale;
	}

	// public List<String> getRegions() {
	// return super.getRegions(getUrl());
	// }

	// public List<Integer> getYears() {
	// List<String> fetchedYears = super.getYears(getUrl());
	//
	// List<Integer> years = new ArrayList<Integer>(fetchedYears.size());
	// for (String fetchedYear : fetchedYears) {
	// years.add(Integer.valueOf(fetchedYear));
	// }
	// return years;
	// }

	@Override
	public List<LiveBirth> getLiveBirths() {
		return this.getLiveBirths(null, null, null, null);
	}

	@Override
	public List<LiveBirth> getLiveBirths(List<String> regions, List<String> motherAges, List<Gender> genders, List<Integer> years) {
		Map<String, List<?>> mappings = new HashMap<String, List<?>>();
		mappings.put("ContentsCode", ListUtility.toList("BE0101E2"));
		mappings.put("Region", regions);
		mappings.put("AlderModer", motherAges);
		mappings.put("Kon", genders);
		mappings.put("Tid", years);

		String response = super.post(super.getBaseUrl() + "BE/BE0101/BE0101H/FoddaK", super.queryBuilder.build(mappings));

		// System.out.println(response);

		return JsonUtility.parseLiveBirths(JsonUtility.getNode(response));
	}

	@Override
	public List<Population> getPopulation() {
		return this.getPopulation(null, null, null, null, null);
	}

	@Override
	public List<Population> getPopulation(List<String> regions, List<RelationshipStatus> relationshipStatuses, List<String> ages, List<Gender> genders, List<Integer> years) {
		Map<String, List<?>> mappings = new HashMap<String, List<?>>();
		mappings.put("ContentsCode", ListUtility.toList("BE0101N1"));
		mappings.put("Region", regions);
		mappings.put("Civilstand", relationshipStatuses);
		mappings.put("Alder", ages);
		mappings.put("Kon", genders);
		mappings.put("Tid", years);

		String response = super.post(super.getBaseUrl() + "BE/BE0101/BE0101A/BefolkningNy", super.queryBuilder.build(mappings));

		// System.out.println(response);

		return JsonUtility.parsePopulation(JsonUtility.getNode(response));
	}

}
