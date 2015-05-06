/*
Copyright 2014 Daniel Nilsson

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

package org.dannil.scbapi.utility;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

public class RequestPoster {

	public static final String doGet(String address) {
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(address);
		Response response = target.request().get();
		String result = response.readEntity(String.class);

		return result;
	}

	public static final String doPost(String address, String query) {
		System.out.println("Query: " + query);

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(address);
		Response response = target.request().post(Entity.json(query));
		String result = response.readEntity(String.class);

		// For some reason we get a question-mark in the beginning of the
		// response so we need to drop that to ensure valid JSON; this
		// occurs with different request clients so it's definitely a
		// problem on the server side
		return result.substring(1, result.length());
	}

	public static final String getCodes(String table) {
		return doGet(String.format("http://api.scb.se/OV0104/v1/doris/en/ssd/%s", table));
	}

}
