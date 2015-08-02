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

package com.github.dannil.scbapi.api.population;

import java.util.Locale;

import com.github.dannil.scbapi.api.AbstractContainerAPI;
import com.github.dannil.scbapi.api.population.demography.DemographyAPI;
import com.github.dannil.scbapi.api.population.statistic.StatisticAPI;

public class PopulationAPI extends AbstractContainerAPI {

	private DemographyAPI demography;
	private StatisticAPI statistic;

	public PopulationAPI() {
		this.demography = new DemographyAPI();
		super.apis.add(this.demography);

		this.statistic = new StatisticAPI();
		super.apis.add(this.statistic);

		super.setLocale(Locale.getDefault());
	}

	public PopulationAPI(Locale locale) {
		this();

		super.setLocale(locale);
	}

	public DemographyAPI demography() {
		return this.demography;
	}

	public StatisticAPI statistic() {
		return this.statistic;
	}

}
