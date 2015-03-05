package org.dannil.scbapi.api.population;

import java.util.ArrayList;
import java.util.Locale;

import org.dannil.scbapi.api.AbstractAPI;
import org.dannil.scbapi.api.AbstractContainerAPI;

public final class PopulationAPI extends AbstractContainerAPI {

	private StatisticsAPI statistics;

	public PopulationAPI() {
		super.apis = new ArrayList<AbstractAPI>();

		this.statistics = new StatisticsAPI();
		super.apis.add(this.statistics);

		super.setLocale(Locale.getDefault());
	}

	public PopulationAPI(Locale locale) {
		this();

		super.setLocale(locale);
	}

	public StatisticsAPI statistics() {
		return this.statistics;
	}

}
