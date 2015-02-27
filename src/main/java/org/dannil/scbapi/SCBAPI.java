package org.dannil.scbapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class SCBAPI extends AbstractSCBAPI {

	private List<AbstractSCBAPI> apis;

	private SCBPopulationAPI populationApi;

	public SCBAPI() {
		this.apis = new ArrayList<AbstractSCBAPI>();
		this.locale = new Locale("en");

		this.populationApi = new SCBPopulationAPI(this.locale);
		this.apis.add(this.populationApi);
	}

	public SCBAPI(Locale locale) {
		this();
		this.locale = locale;

		setLocaleForAPIs();
	}

	private void setLocaleForAPIs() {
		for (AbstractSCBAPI api : this.apis) {
			api.setLocale(this.locale);
		}
	}

	public final SCBPopulationAPI population() {
		return this.populationApi;
	}

}
