package org.dannil.scbapi;

import java.io.IOException;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;
import org.dannil.scbapi.model.Population;
import org.dannil.scbapi.model.PopulationCollection;
import org.dannil.scbapi.model.QueryBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public final class SCBAPI {

	private Client client;

	public SCBAPI() {
		this.client = Client.create();
	}

	public final void test() {
		Client client = Client.create();

		WebResource webResource = client.resource("http://api.scb.se/OV0104/v1/doris/sv/ssd/BE/BE0101/BE0101A/BefolkningNy");

		ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);

		String output = response.getEntity(String.class);

		System.out.println("Output from Server .... \n");
		System.out.println(output);
	}

	public final PopulationCollection getPopulationForRegion(String region) {
		// TODO

		return null;
	}

	public final PopulationCollection getPopulationForRegions(String[] regions) {
		// TODO

		return null;
	}

	public final PopulationCollection getPopulationForYear(long year) {
		// TODO

		return null;
	}

	public final PopulationCollection getPopulationForRegions(long[] years) {
		// TODO

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
		WebResource webResource = this.client.resource("http://api.scb.se/OV0104/v1/doris/sv/ssd/BE/BE0101/BE0101A/BefolkningNy");

		// TODO Refactor this code into a query builder class so it can be
		// applied to all operations

		QueryBuilder<Integer> builder = new QueryBuilder<Integer>();
		String query = builder.buildQuery("BE0101N1", years);

		System.out.println(query);

		ClientResponse response = webResource.accept("application/json").post(ClientResponse.class, query);

		String output = response.getEntity(String.class);

		// For some reason we get a question-mark in the beginning of the
		// response so we need to drop that to ensure valid JSON
		String result = output.substring(1, output.length());

		System.out.println("Output from Server .... \n");
		System.out.println(output);

		System.out.println(result);

		ObjectMapper mapper = new ObjectMapper();
		try {
			JsonNode node = mapper.readTree(result);
			System.out.println("Printing data: " + node.get("data"));

			PopulationCollection collection = new PopulationCollection(node.get("data"));
			for (Population p : collection.getPopulations()) {
				System.out.println(p.toString());
			}

			PopulationCollection collection2 = collection.getPopulationForRegion("00");
			for (Population p : collection2.getPopulations()) {
				System.out.println(p.toString());
			}

			return new PopulationCollection(node.get("data"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return null;
	}
}
