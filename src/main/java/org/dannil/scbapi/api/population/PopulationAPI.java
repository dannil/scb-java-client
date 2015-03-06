package org.dannil.scbapi.api.population;

import java.util.Locale;

import org.dannil.scbapi.api.AbstractContainerAPI;

public final class PopulationAPI extends AbstractContainerAPI {

	private StatisticAPI statistic;

	public PopulationAPI() {
		this.statistic = new StatisticAPI();
		super.apis.add(this.statistic);

		super.setLocale(Locale.getDefault());
	}

	public PopulationAPI(Locale locale) {
		this();

		super.setLocale(locale);
	}

	public StatisticAPI statistic() {
		return this.statistic;
	}

}
