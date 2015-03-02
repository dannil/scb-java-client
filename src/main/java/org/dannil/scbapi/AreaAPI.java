package org.dannil.scbapi;

import java.util.Locale;

public final class AreaAPI extends AbstractAPI implements AreaOperations {

	public AreaAPI() {
		this.locale = Locale.getDefault();
	}

	public AreaAPI(Locale locale) {
		this();
		this.locale = locale;
	}

}
