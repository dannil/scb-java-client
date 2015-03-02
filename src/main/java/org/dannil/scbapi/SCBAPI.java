package org.dannil.scbapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.dannil.scbapi.utility.QueryBuilder;
import org.dannil.scbapi.utility.RequestPoster;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ArrayListMultimap;

public final class SCBAPI extends AbstractAPI {

	private List<AbstractAPI> apis;

	private PopulationAPI populationApi;
	private AreaAPI areaApi;

	public SCBAPI() {
		this.apis = new ArrayList<AbstractAPI>();

		this.populationApi = new PopulationAPI();
		this.apis.add(this.populationApi);

		this.areaApi = new AreaAPI();
		this.apis.add(this.areaApi);

		setLocale(Locale.getDefault());
	}

	public SCBAPI(Locale locale) {
		this();

		setLocale(locale);
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

	public final AreaAPI area() {
		return this.areaApi;
	}

	public final PopulationAPI population() {
		return this.populationApi;
	}

	@Override
	public final void setLocale(Locale locale) {
		this.locale = locale;

		for (AbstractAPI api : this.apis) {
			api.setLocale(this.locale);
		}
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
