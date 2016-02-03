package com.github.dannil.scbapi.test.junk;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dannil.scbapi.api.AbstractAPI;
import com.github.dannil.scbapi.api.SCBAPI;
import com.github.dannil.scbapi.model.environment.landandwaterarea.Area;
import com.github.dannil.scbapi.utility.ListUtility;
import com.github.dannil.scbapi.utility.RequestPoster;

public class Junk {

	public static void main(String[] args) {

		class DummyAPI extends AbstractAPI {

			public void exec() {
				Map<String, List<?>> mappings = new HashMap<String, List<?>>();
				mappings.put("ContentsCode", ListUtility.toList("000000C5"));
				mappings.put("Sektor", ListUtility.toList("2"));
				mappings.put("Yrke2012", ListUtility.toList("0210"));
				mappings.put("Kon", ListUtility.toList("1+2"));
				mappings.put("Tid", ListUtility.toList("2014"));

				String response = super.post("AM/AM0110/AM0110A/LoneSpridSektorYrk4A", super.queryBuilder.build(mappings));
				System.out.println(response);
			}

		}

		DummyAPI api = new DummyAPI();
		api.exec();

		SCBAPI t = new SCBAPI();
		Collection<Area> c1 = t.environment().landAndWaterArea().getArea();
		for (Area a : c1) {
			System.out.println(a);
		}
	}

	public Map<String, String> getRegionMappings() throws IOException {
		String response = RequestPoster.doGet("http://api.scb.se/OV0104/v1/doris/" + new Locale("sv", "SE").getLanguage() + "/ssd/BE/BE0101/BE0101A/BefolkningNy");
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

	public void test() {
		// QueryBuilder<String, String> queryBuilder = new QueryBuilder<String,
		// String>();
		//
		// ArrayListMultimap<String, String> map = ArrayListMultimap.create();
		// map.put("Bransle", "koks");
		// map.put("Bransle", "prop");
		// map.put("Tid", "2012k4");
		// map.put("Tid", "2013k1");
		//
		// String query = queryBuilder.build(map);
		// String response =
		// RequestPoster.doPost("http://api.scb.se/OV0104/v1/doris/" +
		// this.locale.getLanguage() + "/ssd/EN/EN0106/BransleForbrTjKv07",
		// query);
		//
		// System.out.println(response);
	}

}
