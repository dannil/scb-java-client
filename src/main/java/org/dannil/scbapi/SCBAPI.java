package org.dannil.scbapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public final class SCBAPI {

	private List<AbstractSCBAPI> apis;
	private Locale locale;

	private SCBPopulationAPI populationApi;

	public SCBAPI() {
		this.apis = new ArrayList<AbstractSCBAPI>();
		this.locale = new Locale("en");

		this.populationApi = new SCBPopulationAPI();
		this.apis.add(this.populationApi);

		setLocaleForAPIs();
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

	public final void test() {
		Client client = Client.create();

		WebResource webResource = client.resource("http://api.scb.se/OV0104/v1/doris/sv/ssd/BE/BE0101/BE0101A/BefolkningNy");

		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		String output = response.getEntity(String.class);

		System.out.println("Output from Server .... \n");
		System.out.println(output);
	}

	public final SCBPopulationAPI population() {
		return this.populationApi;
	}

}
