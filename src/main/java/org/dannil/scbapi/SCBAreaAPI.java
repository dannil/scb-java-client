package org.dannil.scbapi;

import java.util.Locale;

public final class SCBAreaAPI extends AbstractSCBAPI implements ISCBAreaAPI {

	public SCBAreaAPI() {
		this.locale = Locale.getDefault();
	}

	public SCBAreaAPI(Locale locale) {
		this();
		this.locale = locale;
	}

}
