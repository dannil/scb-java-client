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

package com.github.dannil.scbjavaclient.api.population;

import java.util.Locale;

import com.github.dannil.scbjavaclient.api.AbstractContainerAPI;
import com.github.dannil.scbjavaclient.api.population.demography.DemographyAPI;
import com.github.dannil.scbjavaclient.api.population.statistic.StatisticAPI;

public class PopulationAPI extends AbstractContainerAPI {

	private DemographyAPI demographyApi;
	private StatisticAPI statisticApi;

	public PopulationAPI() {
		super();

		this.demographyApi = new DemographyAPI();
		super.apis.add(this.demographyApi);

		this.statisticApi = new StatisticAPI();
		super.apis.add(this.statisticApi);

		super.setLocale(Locale.getDefault());
	}

	public PopulationAPI(Locale locale) {
		this();

		super.setLocale(locale);
	}

	public DemographyAPI demography() {
		return this.demographyApi;
	}

	public StatisticAPI statistic() {
		return this.statisticApi;
	}

}
