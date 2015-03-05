package org.dannil.scbapi.api.population;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.dannil.scbapi.api.AbstractAPI;

public final class PopulationAPI extends AbstractAPI {

	private List<AbstractAPI> apis;

	private StatisticsAPI statistics;

	public PopulationAPI() {
		this.apis = new ArrayList<AbstractAPI>();

		this.statistics = new StatisticsAPI();
		this.apis.add(this.statistics);

		setLocale(Locale.getDefault());
	}

	public PopulationAPI(Locale locale) {
		this();

		setLocale(locale);
	}

	@Override
	public final void setLocale(Locale locale) {
		this.locale = locale;

		for (AbstractAPI api : this.apis) {
			api.setLocale(this.locale);
		}
	}

	public StatisticsAPI statistics() {
		return this.statistics;
	}

}
