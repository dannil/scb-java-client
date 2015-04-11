package org.dannil.scbapi.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.dannil.scbapi.utility.JsonUtility;
import org.dannil.scbapi.utility.RequestPoster;

import com.fasterxml.jackson.databind.JsonNode;

public abstract class AbstractAPI {

	protected Locale locale;

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public List<String> getRegions(String url) {
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

	public List<String> getYears(String url) {
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
