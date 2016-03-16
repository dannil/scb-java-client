package com.github.dannil.scbjavaclient.test;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class TestHTTP {

	public static void main(String[] args) throws IOException {
		String baseUrl = "http://api.scb.se/OV0104/v1/doris/en/ssd/";
		String address = "BE/BE0701/FruktsamhetSumNy";

		String full = baseUrl + address;

		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = client.execute(new HttpGet(
				"http://api.scb.se/OV0104/v1/doris/en/ssd/HE/HE0103/HE0103B/BefolkningAlder"));
		int statusCode = response.getStatusLine().getStatusCode();
		System.out.println(statusCode);

		// System.out.println(get("http://api.scb.se/OV0104/v1/doris/en/ssd/HE/HE0103/HE0103B/BefolkningAlder"));
		//
		// List<String> regions = Arrays.asList("1263");
		// List<Integer> genders = Arrays.asList(1, 2);
		// List<Integer> years = Arrays.asList(2002);
		//
		// Map<String, Collection<?>> mappings = new HashMap<String, Collection<?>>();
		// mappings.put("ContentsCode", ListUtility.toList("BE0701AA"));
		// mappings.put("Region", regions);
		// mappings.put("Kon", genders);
		// mappings.put("Tid", years);
		//
		// System.out.println(post(full, QueryBuilder.getInstance().build(mappings)));
	}

	// public static String get(String url) throws IOException {
	// OkHttpClient client = new OkHttpClient();
	//
	// Request request = new Request.Builder().url(url).build();
	//
	// Response response = client.newCall(request).execute();
	// return response.body().string();
	// }
	//
	// public static String post(String url, String json) throws IOException {
	// MediaType JSON = MediaType.parse("application/json; charset=utf-8");
	//
	// OkHttpClient client = new OkHttpClient();
	//
	// RequestBody body = RequestBody.create(JSON, json);
	// Request request = new Request.Builder().url(url).post(body).build();
	// Response response = client.newCall(request).execute();
	// return response.body().string();
	// }

}
