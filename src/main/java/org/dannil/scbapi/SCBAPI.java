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

	// public void test() {
	// WebResource webResource =
	// Client.create().resource("http://api.scb.se/OV0104/v1/doris/" +
	// this.locale.getLanguage() + "/ssd/EN/EN0106/BransleForbrTjKv07");
	//
	// QueryBuilder queryBuilder = new QueryBuilder();
	// List<Object[]> values = new ArrayList<Object[]>();
	// values.add(new String[] { "koks" });
	// values.add(new String[] { "2012k4", "2013k1" });
	// String query = queryBuilder.build(new String[] { "Bransle", "Tid" },
	// values);
	//
	// System.out.println(query);
	//
	// ClientResponse response =
	// webResource.accept("application/json").post(ClientResponse.class, query);
	//
	// String output = response.getEntity(String.class);
	// System.out.println("New Output from Server .... \n");
	// System.out.println(output);
	// }

}
