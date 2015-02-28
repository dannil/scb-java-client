package org.dannil.scbapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.dannil.scbapi.utility.QueryBuilder;
import org.dannil.scbapi.utility.RequestPoster;

import com.google.common.collect.ArrayListMultimap;
import com.sun.jersey.api.client.Client;
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
		WebResource resource = Client.create().resource("http://api.scb.se/OV0104/v1/doris/" + this.locale.getLanguage() + "/ssd/EN/EN0106/BransleForbrTjKv07");

		QueryBuilder<String, String> queryBuilder = new QueryBuilder<String, String>();

		ArrayListMultimap<String, String> map = ArrayListMultimap.create();
		map.put("Bransle", "koks");
		map.put("Bransle", "prop");
		map.put("Tid", "2012k4");
		map.put("Tid", "2013k1");

		String query = queryBuilder.build(map);
		String response = RequestPoster.makePostRequest(resource, query);

		System.out.println(response);
	}
}
