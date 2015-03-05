package org.dannil.scbapi.api;

import java.util.List;
import java.util.Locale;

public abstract class AbstractContainerAPI extends AbstractAPI {

	protected List<AbstractAPI> apis;

	@Override
	public final void setLocale(Locale locale) {
		this.locale = locale;

		for (AbstractAPI api : this.apis) {
			api.setLocale(this.locale);
		}
	}

}
