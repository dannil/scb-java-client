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

package com.github.dannil.scbapi.api;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.dannil.scbapi.utility.JsonUtility;
import com.github.dannil.scbapi.utility.Localization;
import com.github.dannil.scbapi.utility.QueryBuilder;
import com.github.dannil.scbapi.utility.RequestPoster;

public class AbstractAPI {

	private static final Logger LOGGER = Logger.getLogger(AbstractAPI.class.getName());

	protected Locale locale;

	protected QueryBuilder queryBuilder;

	protected AbstractAPI() {
		this.locale = Locale.getDefault();

		this.queryBuilder = QueryBuilder.getInstance();
	}

	protected AbstractAPI(Locale locale) {
		this();
		this.locale = locale;

		Localization.setLanguage(locale);
	}

	public Locale getLocale() {
		return this.locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;

		Localization.setLanguage(locale);
	}

	protected String getBaseUrl() {
		return "http://api.scb.se/OV0104/v1/doris/" + this.locale.getLanguage() + "/ssd/";
	}

	// TODO Improve method
	protected String get(String address) {
		try {
			String response = RequestPoster.doGet(getBaseUrl() + address);

			return response;
		} catch (FileNotFoundException e) {
			// 404, call the API again with the fallback language

			try {
				return RequestPoster.doGet(toFallbackUrl(getBaseUrl() + address));
			} catch (IOException e1) {
				e1.printStackTrace();

				return "UNHANDLED";
			}
		} catch (IOException e) {
			// Handle all other cases
			e.printStackTrace();

			return "IOException";
		}
	}

	// TODO Improve method
	protected String post(String address, String query) {
		try {
			String response = RequestPoster.doPost(getBaseUrl() + address, query);

			LOGGER.log(Level.INFO, query);

			return response;
		} catch (FileNotFoundException e) {
			// 404, call the API again with the fallback language

			try {
				LOGGER.log(Level.INFO, query);

				return RequestPoster.doPost(toFallbackUrl(getBaseUrl() + address), query);
			} catch (IOException e1) {
				e1.printStackTrace();

				return "UNHANDLED";
			}
		} catch (IOException e) {
			// Handle all other cases
			e.printStackTrace();

			return "IOException";
		}
	}

	// TODO Maybe should be in a separate utility class?
	private String toFallbackUrl(String url) {
		String internalAddress = url;

		// Some tables only support Swedish so we need to fall back to
		// Swedish if this is the case
		Locale fallback = new Locale("sv", "SE");

		int start = internalAddress.indexOf(this.locale.getLanguage(), internalAddress.indexOf("doris"));
		int end = start + this.locale.getLanguage().length();

		StringBuilder builder = new StringBuilder(internalAddress);
		builder.replace(start, end, fallback.getLanguage());

		return builder.toString();
	}

	public List<String> getRegions(String url) {
		String content = get(url);

		JsonNode contentAsJsonNode = JsonUtility.getNode(content);

		List<String> codes = contentAsJsonNode.findValuesAsText("code");
		List<JsonNode> values = contentAsJsonNode.findValues("values");

		int position = codes.indexOf("Region");
		if (position < 0) {
			throw new UnsupportedOperationException(Localization.getString("regions_is_not_supported_for_url", url));
		}

		JsonNode jsonRegions = values.get(position);

		List<String> regions = new ArrayList<String>(jsonRegions.size());
		for (int j = 0; j < jsonRegions.size(); j++) {
			regions.add(jsonRegions.get(j).asText());
		}

		return regions;
	}

	protected List<String> getYears(String url) {
		String content = get(url);

		JsonNode contentAsJsonNode = JsonUtility.getNode(content);

		List<String> codes = contentAsJsonNode.findValuesAsText("code");
		List<JsonNode> values = contentAsJsonNode.findValues("values");

		int position = codes.indexOf("Tid");
		if (position < 0) {
			throw new UnsupportedOperationException(Localization.getString("years_is_not_supported_for_url", url));
		}

		JsonNode jsonYears = values.get(position);

		List<String> years = new ArrayList<String>(jsonYears.size());
		for (int j = 0; j < jsonYears.size(); j++) {
			years.add(jsonYears.get(j).asText());
		}

		return years;
	}

}
