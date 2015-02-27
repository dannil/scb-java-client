package org.dannil.scbapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.dannil.scbapi.utility.QueryBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

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

	public void test() {
		WebResource webResource = Client.create().resource("http://api.scb.se/OV0104/v1/doris/" + this.locale.getLanguage() + "/ssd/EN/EN0106/BransleForbrTjKv07");

		QueryBuilder<String, String> queryBuilder = new QueryBuilder<String, String>();
		List<String> codes = new ArrayList<String>();
		List<List<String>> values = new ArrayList<List<String>>();

		codes.add("Bransle");
		codes.add("Tid");

		List<String> values1 = new ArrayList<String>();
		values1.add("koks");
		values1.add("prop");

		List<String> values2 = new ArrayList<String>();
		values2.add("2012k4");
		values2.add("2013k1");

		values.add(values1);
		values.add(values2);

		String query = queryBuilder.build(codes, values);

		System.out.println(query);

		ClientResponse response = webResource.accept("application/json").post(ClientResponse.class, query);

		String output = response.getEntity(String.class);
		System.out.println("New Output from Server .... \n");
		System.out.println(output);
	}

}
