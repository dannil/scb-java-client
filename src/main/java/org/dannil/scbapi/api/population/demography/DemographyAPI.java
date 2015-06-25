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

package org.dannil.scbapi.api.population.demography;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.dannil.scbapi.api.AbstractAPI;
import org.dannil.scbapi.model.population.demography.AverageAgeFirstChild;
import org.dannil.scbapi.utility.ListUtility;
import org.dannil.scbapi.utility.QueryBuilder;
import org.dannil.scbapi.utility.RequestPoster;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DemographyAPI extends AbstractAPI implements DemographyOperations {

	public DemographyAPI() {
		super.locale = Locale.getDefault();
	}

	public DemographyAPI(Locale locale) {
		this();
		super.locale = locale;
	}

	@Override
	public void setLocale(Locale locale) {
		super.locale = locale;
	}

	private String getUrl() {
		return "http://api.scb.se/OV0104/v1/doris/" + super.locale.getLanguage() + "/ssd/BE/BE0701/MedelAlderNY";
	}

	public List<String> getRegions() {
		return super.getRegions(getUrl());
	}

	public List<Integer> getGenders() {
		String response = RequestPoster.doGet(getUrl());

		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(response);
			List<JsonNode> nodes = node.findValues("values");
			node = nodes.get(1);

			List<Integer> genders = new ArrayList<Integer>(node.size());
			for (int i = 0; i < node.size(); i++) {
				genders.add(node.get(i).asInt());
			}
			return genders;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Integer> getYears() {
		List<String> fetchedYears = super.getYears(getUrl());

		List<Integer> years = new ArrayList<Integer>(fetchedYears.size());
		for (String fetchedYear : fetchedYears) {
			years.add(Integer.valueOf(fetchedYear));
		}
		return years;
	}

	@Override
	public List<AverageAgeFirstChild> getAverageAgeFirstChild() {
		return this.getAverageAgeFirstChild(null, null, null);
	}

	@Override
	public List<AverageAgeFirstChild> getAverageAgeFirstChild(List<String> regions, List<Integer> genders, List<Integer> years) {
		Map<String, List<?>> mappings = new HashMap<String, List<?>>();
		mappings.put("ContentsCode", ListUtility.toList("BE0701AB"));
		mappings.put("Region", regions);
		mappings.put("Kon", genders);
		mappings.put("Tid", years);

		QueryBuilder builder = new QueryBuilder(mappings);

		String query = builder.build();
		String response = RequestPoster.doPost(getUrl(), query);

		// TODO Implement parsing method for returning model for
		// averageAgeFirstChild
		return null;
	}

}
