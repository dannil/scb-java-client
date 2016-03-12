/*
 * Copyright 2014 Daniel Nilsson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dannil.scbjavaclient.utility.requester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.github.dannil.scbjavaclient.utility.ListUtility;
import com.github.dannil.scbjavaclient.utility.QueryBuilder;

/**
 * Class which sends URL requests to the specified address, in this case the SCB API.
 * 
 * @author Daniel Nilsson
 */
public abstract class Requester {

	public abstract String doRequest(String address) throws IOException;

	private Map<String, String> requestProperties;

	protected Requester() {
		this.requestProperties = new HashMap<String, String>();

		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = getClass().getClassLoader().getResourceAsStream("project.properties");

			// load a properties file
			prop.load(input);

			// gETRequester the property value and print it out

			String artifactId = prop.getProperty("artifactId");
			String version = prop.getProperty("version");
			String url = prop.getProperty("url");

			System.out.println(artifactId);
			System.out.println(version);
			System.out.println(url);

			this.requestProperties.put("Accept", "application/json");
			this.requestProperties.put("Content-Type", "application/json; charset=utf-8");

			StringBuilder builder = new StringBuilder(64);
			builder.append(artifactId + "/" + version);
			builder.append(" ");
			builder.append("(" + url + ")");
			builder.append(", ");
			builder.append(System.getProperty("os.name"));

			this.requestProperties.put("User-Agent", builder.toString());
			// requestProperties.put();
			// requestProperties.put();

		} catch (IOException ex) {
			ex.printStackTrace();
		}

	}

	public void setRequestProperties(URLConnection urlConnection, String... props) {
		for (String prop : props) {
			urlConnection.addRequestProperty(prop, this.requestProperties.get(prop));
		}
	}

	protected HttpURLConnection prepareConnection(String address) throws IOException {
		URL url = new URL(address);

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		setRequestProperties(connection, "Accept", "Content-Type", "User-Agent");

		return connection;
	}

	protected String getResponse(HttpURLConnection httpUrlConnection) throws IOException {
		StringBuilder builder = new StringBuilder(32);

		try (BufferedReader br = new BufferedReader(new InputStreamReader(httpUrlConnection.getInputStream(), "utf-8"))) {
			// Handle UTF-8 byte order mark (BOM)
			br.mark(4);

			// Checks if the stream contains a BOM. If it doesn't, reset the
			// stream pointer to the location specified by br.mark()
			if ('\uFEFF' != br.read()) {
				br.reset();
			}

			String line;
			while ((line = br.readLine()) != null) {
				builder.append(line);
			}
		}

		httpUrlConnection.disconnect();

		return builder.toString();
	}

	// /**
	// * Perform a GETRequester request to the specified address.
	// *
	// * @param address
	// * the address to perform request to
	// * @return the response from this request as a string
	// * @throws IOException
	// * if the address isn't a valid URL format
	// */
	// public String doGet(String address) throws IOException {
	// StringBuilder builder = new StringBuilder();
	// URL url = new URL(address);
	//
	// HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	//
	// connection.setDoInput(true);
	// connection.setRequestMethod("GETRequester");
	//
	// setRequestProperties(connection, "Accept", "Content-Type", "User-Agent");
	//
	// try (BufferedReader br = new BufferedReader(new
	// InputStreamReader(connection.getInputStream(), "utf-8"))) {
	// // Handle UTF-8 byte order mark (BOM)
	// br.mark(4);
	//
	// // Checks if the stream contains a BOM. If it doesn't, reset the
	// // stream pointer to the location specified by br.mark()
	// if ('\uFEFF' != br.read()) {
	// br.reset();
	// }
	//
	// String line;
	// while ((line = br.readLine()) != null) {
	// builder.append(line);
	// }
	// }
	//
	// connection.disconnect();
	//
	// return builder.toString();
	// }
	//
	// /**
	// * Perform a POST request to the specified address and the specified query (payload).
	// *
	// * @param address
	// * the address to perform request to
	// * @param query
	// * the payload to send along
	// * @return the response from this request as a string
	// * @throws IOException
	// * if the address isn't a valid URL format
	// */
	// public static String doPost(String address, String query) throws IOException {
	// StringBuilder builder = new StringBuilder();
	// URL url = new URL(address);
	//
	// HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	//
	// connection.setDoInput(true);
	// connection.setDoOutput(true);
	// connection.setRequestMethod("POST");
	// connection.setRequestProperty("Accept", "application/json");
	// connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
	// connection.setRequestProperty("User-Agent",
	// "scb-java-client/VERSION-HERE (github.com/dannil/scb-java-client), " +
	// System.getProperty("os.name"));
	//
	// try (OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(),
	// "utf-8")) {
	// writer.write(query);
	// writer.close();
	// }
	//
	// try (BufferedReader br = new BufferedReader(new
	// InputStreamReader(connection.getInputStream(), "utf-8"))) {
	// // Handle UTF-8 byte order mark (BOM)
	// br.mark(4);
	//
	// // Checks if the stream contains a BOM. If it doesn't, reset the
	// // stream pointer to the location specified by br.mark()
	// if ('\uFEFF' != br.read()) {
	// br.reset();
	// }
	//
	// String line;
	// while ((line = br.readLine()) != null) {
	// builder.append(line);
	// }
	// }
	//
	// connection.disconnect();
	//
	// return builder.toString();
	// }
	//
	/**
	 * Return the available codes from the specified table.
	 *
	 * @param table
	 *            the table to fetch the codes from
	 * @return the available codes from the specified table
	 */
	public static String getCodes(String table) {
		try {
			Requester get = (GETRequester) RequesterFactory.getInstance("GETRequester");
			return get.doRequest(String.format("http://api.scb.se/OV0104/v1/doris/sv/ssd/%s", table));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public static void main(String[] args) throws IOException {
		// Requester poster = new Requester();
		// System.out.println(poster.doGet("http://google.com"));
		//
		// System.out.println(poster.post
		// .doRequest("http://api.scb.se/OV0104/v1/doris/en/ssd/BE/BE0001/BE0001T04Ar", null));

		Requester get = RequesterFactory.getInstance("GET");
		System.out.println(get.doRequest("http://google.com"));

		Map<String, Collection<?>> mappings = new HashMap<String, Collection<?>>();
		mappings.put("ContentsCode", ListUtility.toList("BE0701AB"));
		mappings.put("Region", Arrays.asList("0114"));

		QueryBuilder b = QueryBuilder.getInstance();

		Requester post = RequesterFactory.getInstance("POST");
		((POSTRequester) post).setPayload(b.build(mappings));
		System.out.println(post.doRequest("http://api.scb.se/OV0104/v1/doris/en/ssd/BE/BE0701/MedelAlderNY"));
	}
}
