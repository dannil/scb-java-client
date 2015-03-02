package org.dannil.scbapi;

import java.util.Locale;

public final class EnvironmentAPI extends AbstractAPI implements EnvironmentOperations {

	public EnvironmentAPI() {
		this.locale = Locale.getDefault();
	}

	public EnvironmentAPI(Locale locale) {
		this();
		this.locale = locale;
	}

}
