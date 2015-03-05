package org.dannil.scbapi.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.dannil.scbapi.api.environment.EnvironmentAPI;
import org.dannil.scbapi.api.population.PopulationAPI;
import org.dannil.scbapi.utility.QueryBuilder;
import org.dannil.scbapi.utility.RequestPoster;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ArrayListMultimap;

public final class SCBAPI extends AbstractContainerAPI {

	private PopulationAPI populationApi;
	private EnvironmentAPI environmentApi;

	public SCBAPI() {
		super.apis = new ArrayList<AbstractAPI>();

		this.populationApi = new PopulationAPI();
		super.apis.add(this.populationApi);

		this.environmentApi = new EnvironmentAPI();
		super.apis.add(this.environmentApi);

		super.setLocale(Locale.getDefault());
	}

	public SCBAPI(Locale locale) {
		this();

		super.setLocale(locale);
	}

	public final Map<String, String> getRegionMappings() {
		String response = RequestPoster.doGet("http://api.scb.se/OV0104/v1/doris/" + this.locale.getLanguage() + "/ssd/BE/BE0101/BE0101A/BefolkningNy");
		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(response);
			List<JsonNode> valueNodes = node.findValues("values");
			List<JsonNode> valueTextNodes = node.findValues("valueTexts");

			JsonNode values = valueNodes.get(0);
			JsonNode valueTexts = valueTextNodes.get(0);

			Map<String, String> map = new Hashtable<String, String>();
			for (int i = 0; i < values.size(); i++) {
				map.put(values.get(i).asText(), valueTexts.get(i).asText());
			}
			return map;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public final EnvironmentAPI environment() {
		return this.environmentApi;
	}

	public final PopulationAPI population() {
		return this.populationApi;
	}

	public void test() {
		QueryBuilder<String, String> queryBuilder = new QueryBuilder<String, String>();

		ArrayListMultimap<String, String> map = ArrayListMultimap.create();
		map.put("Bransle", "koks");
		map.put("Bransle", "prop");
		map.put("Tid", "2012k4");
		map.put("Tid", "2013k1");

		String query = queryBuilder.build(map);
		String response = RequestPoster.doPost("http://api.scb.se/OV0104/v1/doris/" + this.locale.getLanguage() + "/ssd/EN/EN0106/BransleForbrTjKv07", query);

		System.out.println(response);
	}
}
