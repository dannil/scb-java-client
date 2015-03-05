package org.dannil.scbapi.api.environment;

import java.util.Locale;

import org.dannil.scbapi.api.AbstractContainerAPI;

public final class EnvironmentAPI extends AbstractContainerAPI {

	private LandAndWaterAreaAPI landAndWaterArea;

	public EnvironmentAPI() {
		this.landAndWaterArea = new LandAndWaterAreaAPI();
		super.apis.add(this.landAndWaterArea);
	}

	public EnvironmentAPI(Locale locale) {
		this();

		super.setLocale(locale);
	}

	public LandAndWaterAreaAPI landAndWater() {
		return this.landAndWaterArea;
	}

}
