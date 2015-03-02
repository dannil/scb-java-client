package org.dannil.scbapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.dannil.scbapi.model.PopulationCollection;
import org.dannil.scbapi.utility.JsonUtility;
import org.dannil.scbapi.utility.ListUtility;
import org.dannil.scbapi.utility.QueryBuilder;
import org.dannil.scbapi.utility.RequestPoster;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ArrayListMultimap;

public final class SCBPopulationAPI extends AbstractSCBAPI implements ISCBPopulationAPI {

	public SCBPopulationAPI() {
		this.locale = Locale.getDefault();
	}

	public SCBPopulationAPI(Locale locale) {
		this();
		this.locale = locale;
	}

	public final List<Integer> getAvailableYears() {
		String response = RequestPoster.doGet("http://api.scb.se/OV0104/v1/doris/" + this.locale.getLanguage() + "/ssd/BE/BE0101/BE0101A/BefolkningNy");

		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(response);
			List<JsonNode> nodes = node.findValues("values");
			node = nodes.get(nodes.size() - 1);

			List<Integer> years = new ArrayList<Integer>(node.size());
			for (int i = 0; i < node.size(); i++) {
				years.add(node.get(i).asInt());
			}
			return years;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public final PopulationCollection getPopulation() {
		QueryBuilder<String, String> queryBuilder = new QueryBuilder<String, String>();

		ArrayListMultimap<String, String> map = ArrayListMultimap.create();
		map.put("ContentsCode", "BE0101N1");

		List<Integer> years = this.getAvailableYears();
		for (Integer year : years) {
			map.put("Tid", year.toString());
		}

		String query = queryBuilder.build(map);
		String response = RequestPoster.doPost("http://api.scb.se/OV0104/v1/doris/" + this.locale.getLanguage() + "/ssd/BE/BE0101/BE0101A/BefolkningNy", query);

		return new PopulationCollection(JsonUtility.getNode(response, "data"));
	}

	public final PopulationCollection getPopulationForYear(int year) {
		return this.getPopulationForYears(ListUtility.toList(year));
	}

	public final PopulationCollection getPopulationBetweenYears(int startYear, int endYear) {
		int size = endYear - startYear + 1;
		List<Integer> years = new ArrayList<Integer>(size);
		for (int i = 0; i < size; i++) {
			years.add(startYear + i);
		}
		return this.getPopulationForYears(years);
	}

	public final PopulationCollection getPopulationForYears(List<Integer> years) {
		return this.getPopulationForRegions(null, years);
	}

	public final PopulationCollection getPopulationForRegion(String region) {
		return this.getPopulationForRegions(ListUtility.toList(region));
	}

	public final PopulationCollection getPopulationForRegion(String region, List<Integer> years) {
		return this.getPopulationForRegions(ListUtility.toList(region), years);
	}

	public final PopulationCollection getPopulationForRegion(String region, Integer year) {
		return this.getPopulationForRegions(ListUtility.toList(region), ListUtility.toList(year));
	}

	public final PopulationCollection getPopulationForRegions(List<String> regions) {
		return this.getPopulationForRegions(regions, null);
	}

	public final PopulationCollection getPopulationForRegions(List<String> regions, List<Integer> years) {
		QueryBuilder<String, String> queryBuilder = new QueryBuilder<String, String>();

		ArrayListMultimap<String, String> map = ArrayListMultimap.create();
		map.put("ContentsCode", "BE0101N1");
		if (regions != null) {
			for (String region : regions) {
				map.put("Region", region);
			}
		}
		if (years != null) {
			for (Integer year : years) {
				map.put("Tid", year.toString());
			}
		}

		String query = queryBuilder.build(map);
		String response = RequestPoster.doPost("http://api.scb.se/OV0104/v1/doris/" + this.locale.getLanguage() + "/ssd/BE/BE0101/BE0101A/BefolkningNy", query);
		return new PopulationCollection(JsonUtility.getNode(response, "data"));
	}

}
