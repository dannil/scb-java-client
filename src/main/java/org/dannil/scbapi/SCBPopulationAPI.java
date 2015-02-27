package org.dannil.scbapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.dannil.scbapi.model.PopulationCollection;
import org.dannil.scbapi.model.QueryBuilder;

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

		WebResource webResource = this.client.resource("http://api.scb.se/OV0104/v1/doris/" + this.locale.getLanguage() + "/ssd/BE/BE0101/BE0101A/BefolkningNy");
		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
		String output = response.getEntity(String.class);

		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(output);
			List<JsonNode> nodes = node.findValues("values");
			node = nodes.get(nodes.size() - 1);
			System.out.println("Nodes value: " + node.toString());

			Integer[] years = new Integer[node.size()];
			for (int i = 0; i < years.length; i++) {
				years[i] = node.get(i).asInt();
				System.out.println(years[i]);
			}

			return this.getPopulationForYears(years);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}

	public final PopulationCollection getPopulationForRegion(String region) {
		String[] regions = new String[1];
		regions[0] = region;
		return this.getPopulationForRegions(regions);
	}

	public final PopulationCollection getPopulationForRegions(String[] regions) {
		WebResource webResource = this.client.resource("http://api.scb.se/OV0104/v1/doris/" + this.locale.getLanguage() + "/ssd/BE/BE0101/BE0101A/BefolkningNy");

		QueryBuilder queryBuilder = new QueryBuilder();
		List<Object[]> values = new ArrayList<Object[]>();
		values.add(new String[] { "BE0101N1" });
		values.add(regions);
		String query = queryBuilder.build(new String[] { "ContentsCode", "Region" }, values);

		System.out.println(query);

		ClientResponse response = webResource.accept("application/json").post(ClientResponse.class, query);

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
		Integer[] years = new Integer[1];
		years[0] = year;
		return this.getPopulationForYears(years);
	}

	public final PopulationCollection getPopulationBetweenYears(int startYear, int endYear) {
		Integer[] years = new Integer[endYear - startYear + 1];
		for (int i = 0; i < years.length; i++) {
			years[i] = startYear + i;
			System.out.println(years[i]);
		}
		return this.getPopulationForYears(years);
	}

	public final PopulationCollection getPopulationForYears(Integer[] years) {
		WebResource webResource = this.client.resource("http://api.scb.se/OV0104/v1/doris/" + this.locale.getLanguage() + "/ssd/BE/BE0101/BE0101A/BefolkningNy");

		QueryBuilder queryBuilder = new QueryBuilder();
		List<Object[]> values = new ArrayList<Object[]>();
		values.add(new String[] { "BE0101N1" });
		values.add(years);
		String query = queryBuilder.build(new String[] { "ContentsCode", "Tid" }, values);

		System.out.println(query);

		ClientResponse response = webResource.accept("application/json").post(ClientResponse.class, query);

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
