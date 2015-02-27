package org.dannil.scbapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.dannil.scbapi.model.PopulationCollection;
import org.dannil.scbapi.utility.ListUtility;
import org.dannil.scbapi.utility.QueryBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public final class SCBPopulationAPI extends AbstractSCBAPI {

	private Client client;

	public SCBPopulationAPI() {
		this.client = Client.create();
	}

	public SCBPopulationAPI(Locale locale) {
		this();
		this.locale = locale;
	}

	public final PopulationCollection getPopulation() {
		WebResource resource = this.client.resource("http://api.scb.se/OV0104/v1/doris/" + this.locale.getLanguage() + "/ssd/BE/BE0101/BE0101A/BefolkningNy");
		ClientResponse response = resource.accept("application/json").get(ClientResponse.class);
		String output = response.getEntity(String.class);

		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(output);
			List<JsonNode> nodes = node.findValues("values");
			node = nodes.get(nodes.size() - 1);
			System.out.println("Nodes value: " + node.toString());

			List<Integer> years = new ArrayList<Integer>(node.size());
			for (int i = 0; i < node.size(); i++) {
				years.add(node.get(i).asInt());
			}

			return this.getPopulationForYears(years);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public final PopulationCollection getPopulationForRegion(String region) {
		return this.getPopulationForRegions(ListUtility.toList(region));
	}

	public final PopulationCollection getPopulationForRegions(List<String> regions) {
		WebResource resource = this.client.resource("http://api.scb.se/OV0104/v1/doris/" + this.locale.getLanguage() + "/ssd/BE/BE0101/BE0101A/BefolkningNy");

		QueryBuilder<String, String> queryBuilder = new QueryBuilder<String, String>();
		List<String> codes = new ArrayList<String>();
		List<List<String>> values = new ArrayList<List<String>>();

		codes.add("ContentsCode");
		codes.add("Region");

		List<String> table = new ArrayList<String>();
		table.add("BE0101N1");

		values.add(table);
		values.add(regions);

		String query = queryBuilder.build(codes, values);

		System.out.println(query);

		ClientResponse response = resource.accept("application/json").post(ClientResponse.class, query);

		String output = response.getEntity(String.class);
		System.out.println("Output from Server .... \n");
		System.out.println(output);

		// For some reason we get a question-mark in the beginning of the
		// response so we need to drop that to ensure valid JSON
		String result = output.substring(1, output.length());
		System.out.println("Modified result .... \n");
		System.out.println(result);

		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(result);
			return new PopulationCollection(node.get("data"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
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
		WebResource resource = this.client.resource("http://api.scb.se/OV0104/v1/doris/" + this.locale.getLanguage() + "/ssd/BE/BE0101/BE0101A/BefolkningNy");

		QueryBuilder<String, String> queryBuilder = new QueryBuilder<String, String>();
		List<String> codes = new ArrayList<String>();
		List<List<String>> values = new ArrayList<List<String>>();

		codes.add("ContentsCode");
		codes.add("Tid");

		List<String> table = new ArrayList<String>();
		table.add("BE0101N1");

		values.add(table);

		// Convert the years to strings
		List<String> stringYears = new ArrayList<String>(years.size());
		for (Integer year : years) {
			stringYears.add(String.valueOf(year));
		}
		values.add(stringYears);

		String query = queryBuilder.build(codes, values);

		System.out.println(query);

		ClientResponse response = resource.accept("application/json").post(ClientResponse.class, query);

		String output = response.getEntity(String.class);
		System.out.println("Output from Server .... \n");
		System.out.println(output);

		// For some reason we get a question-mark in the beginning of the
		// response so we need to drop that to ensure valid JSON
		String result = output.substring(1, output.length());
		System.out.println("Modified result .... \n");
		System.out.println(result);

		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(result);
			return new PopulationCollection(node.get("data"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
