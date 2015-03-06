package org.dannil.scbapi.api.environment;

import java.util.Locale;

import org.dannil.scbapi.api.AbstractContainerAPI;

public final class EnvironmentAPI extends AbstractContainerAPI {

	private LandAndWaterAreasAPI landAndWaterAreas;

	public EnvironmentAPI() {
		this.landAndWaterAreas = new LandAndWaterAreasAPI();
		super.apis.add(this.landAndWaterAreas);
	}

	public EnvironmentAPI(Locale locale) {
		this();

		super.setLocale(locale);
	}

	public LandAndWaterAreasAPI landAndWaterAreas() {
		return this.landAndWaterAreas;
	}

}
