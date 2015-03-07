package org.dannil.scbapi.api.population;

import java.util.Locale;

import org.dannil.scbapi.api.AbstractContainerAPI;
import org.dannil.scbapi.api.population.demography.DemographyAPI;
import org.dannil.scbapi.api.population.statistic.StatisticAPI;

public final class PopulationAPI extends AbstractContainerAPI {

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
