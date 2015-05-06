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

package org.dannil.scbapi.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.dannil.scbapi.utility.JsonUtility;
import org.dannil.scbapi.utility.RequestPoster;

import com.fasterxml.jackson.databind.JsonNode;

public abstract class AbstractAPI {

	protected Locale locale;

	protected void setLocale(Locale locale) {
		this.locale = locale;
	}

	protected List<String> getRegions(String url) {
		String content = RequestPoster.doGet(url);

		JsonNode contentAsJsonNode = JsonUtility.getNode(content);

		List<String> codes = contentAsJsonNode.findValuesAsText("code");
		List<JsonNode> values = contentAsJsonNode.findValues("values");

		JsonNode jsonRegions = values.get(codes.indexOf("Region"));

		List<String> regions = new ArrayList<String>(jsonRegions.size());
		for (int j = 0; j < jsonRegions.size(); j++) {
			regions.add(jsonRegions.get(j).asText());
		}
		return regions;
	}

	protected List<String> getYears(String url) {
		String content = RequestPoster.doGet(url);

		JsonNode contentAsJsonNode = JsonUtility.getNode(content);

		List<String> codes = contentAsJsonNode.findValuesAsText("code");
		List<JsonNode> values = contentAsJsonNode.findValues("values");

		JsonNode jsonYears = values.get(codes.indexOf("Tid"));

		List<String> years = new ArrayList<String>(jsonYears.size());
		for (int j = 0; j < jsonYears.size(); j++) {
			years.add(jsonYears.get(j).asText());
		}
		return years;
	}

}
