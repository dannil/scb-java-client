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

package com.github.dannil.scbjavaclient.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Class which sends URL requests to the specified address, in this case the SCB API.
 * 
 * @author Daniel Nilsson
 */
public class RequestPoster {

	private RequestPoster() {

	}

	/**
	 * Perform a GET request to the specified address.
	 * 
	 * @param address
	 *            the address to perform request to
	 * @return the response from this request as a string
	 * @throws IOException
	 *             if the address isn't a valid URL format
	 */
	public static String doGet(String address) throws IOException {
		StringBuilder builder = new StringBuilder();
		URL url = new URL(address);

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setDoInput(true);
		connection.setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
		connection.setRequestProperty("User-Agent",
				"scb-java-client/VERSION-HERE (github.com/dannil/scb-java-client), " + System.getProperty("os.name"));

		try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
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

		connection.disconnect();

		return builder.toString();
	}

	/**
	 * Perform a POST request to the specified address and the specified query (payload).
	 * 
	 * @param address
	 *            the address to perform request to
	 * @param query
	 *            the payload to send along
	 * @return the response from this request as a string
	 * @throws IOException
	 *             if the address isn't a valid URL format
	 */
	public static String doPost(String address, String query) throws IOException {
		StringBuilder builder = new StringBuilder();
		URL url = new URL(address);

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		connection.setDoInput(true);
		connection.setDoOutput(true);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Accept", "application/json");
		connection.setRequestProperty("Content-Type", "application/json; charset=utf-8");
		connection.setRequestProperty("User-Agent",
				"scb-java-client/VERSION-HERE (github.com/dannil/scb-java-client), " + System.getProperty("os.name"));

		try (OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream(), "utf-8")) {
			writer.write(query);
			writer.close();
		}

		try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"))) {
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

		connection.disconnect();

		return builder.toString();
	}

	/**
	 * Return the available codes from the specified table.
	 * 
	 * @param table
	 *            the table to fetch the codes from
	 * @return the available codes from the specified table
	 */
	public static String getCodes(String table) {
		try {
			return doGet(String.format("http://api.scb.se/OV0104/v1/doris/sv/ssd/%s", table));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
