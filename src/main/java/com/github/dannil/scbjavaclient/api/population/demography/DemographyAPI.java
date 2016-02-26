/*
 * Copyright 2014 Daniel Nilsson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dannil.scbjavaclient.api.population.demography;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.github.dannil.scbjavaclient.api.AbstractAPI;
import com.github.dannil.scbjavaclient.model.population.demography.MeanAgeFirstChild;
import com.github.dannil.scbjavaclient.utility.JsonUtility;
import com.github.dannil.scbjavaclient.utility.ListUtility;

public class DemographyAPI extends AbstractAPI {

	public DemographyAPI() {
		super();
	}

	public DemographyAPI(Locale locale) {
		super(locale);
	}

	// public Collection<String> getRegions() {
	// return super.getRegions(getUrl());
	// }
	//
	// public Collection<Integer> getGenders() {
	// String response = RequestPoster.doGet(getUrl());
	//
	// ObjectMapper mapper = new ObjectMapper();
	// try {
	// JsonNode node = mapper.readTree(response);
	// Collection<JsonNode> nodes = node.findValues("values");
	// node = nodes.get(1);
	//
	// Collection<Integer> genders = new ArrayCollection<Integer>(node.size());
	// for (int i = 0; i < node.size(); i++) {
	// genders.add(node.get(i).asInt());
	// }
	// return genders;
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return null;
	// }
	//
	// public Collection<Integer> getYears() {
	// Collection<String> fetchedYears = super.getYears(getUrl());
	//
	// Collection<Integer> years = new ArrayCollection<Integer>(fetchedYears.size());
	// for (String fetchedYear : fetchedYears) {
	// years.add(Integer.valueOf(fetchedYear));
	// }
	// return years;
	// }

	public List<MeanAgeFirstChild> getMeanAgeFirstChild() {
		return this.getMeanAgeFirstChild(null, null, null);
	}

	public List<MeanAgeFirstChild> getMeanAgeFirstChild(Collection<String> regions, Collection<Integer> genders,
			Collection<Integer> years) {
		Map<String, Collection<?>> mappings = new HashMap<String, Collection<?>>();
		mappings.put("ContentsCode", ListUtility.toList("BE0701AB"));
		mappings.put("Region", regions);
		mappings.put("Kon", genders);
		mappings.put("Tid", years);

		String response = super.post("BE/BE0701/MedelAlderNY", super.queryBuilder.build(mappings));

		return JsonUtility.parseAverageAgeFirstChild(JsonUtility.getNode(response));
	}

	// public List<Object> getFertilityRate() {
	// return this.getFertilityRate(null, null, null);
	// }
	//
	// public List<Object> getFertilityRate(Collection<String> regions, Collection<Integer> genders,
	// Collection<Integer> years) {
	// Map<String, Collection<?>> mappings = new HashMap<String, Collection<?>>();
	// mappings.put("ContentsCode", ListUtility.toList("BE0701AA"));
	// mappings.put("Region", regions);
	// mappings.put("Kon", genders);
	// mappings.put("Tid", years);
	//
	// // String response = super.post("BE/BE0701/FruktsamhetSumNy",
	// // super.queryBuilder.build(mappings));
	//
	// // System.out.println(response);
	//
	// // TODO Implement parsing
	//
	// return null;
	// }

}
