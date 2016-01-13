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

import java.util.Locale;

import com.github.dannil.scbapi.api.environment.EnvironmentAPI;
import com.github.dannil.scbapi.api.population.PopulationAPI;

public class SCBAPI extends AbstractContainerAPI {

	private PopulationAPI populationApi;
	private EnvironmentAPI environmentApi;

	public SCBAPI() {
		this.populationApi = new PopulationAPI();
		super.apis.add(this.populationApi);

		this.environmentApi = new EnvironmentAPI();
		super.apis.add(this.environmentApi);

		super.setLocale(Locale.getDefault());
	}

	public SCBAPI(Locale locale) {
		this();

		super.setLocale(locale);
	}

	public EnvironmentAPI environment() {
		return this.environmentApi;
	}

	public PopulationAPI population() {
		return this.populationApi;
	}

	public void test() {
		// QueryBuilder<String, String> queryBuilder = new QueryBuilder<String,
		// String>();
		//
		// ArrayListMultimap<String, String> map = ArrayListMultimap.create();
		// map.put("Bransle", "koks");
		// map.put("Bransle", "prop");
		// map.put("Tid", "2012k4");
		// map.put("Tid", "2013k1");
		//
		// String query = queryBuilder.build(map);
		// String response =
		// RequestPoster.doPost("http://api.scb.se/OV0104/v1/doris/" +
		// this.locale.getLanguage() + "/ssd/EN/EN0106/BransleForbrTjKv07",
		// query);
		//
		// System.out.println(response);
	}
}
