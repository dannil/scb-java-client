package com.github.dannil.scbjavaclient.utility.requester;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

import com.github.dannil.scbjavaclient.exception.SCBClientException;
import com.github.dannil.scbjavaclient.exception.SCBClientTooManyRequestsException;
import com.github.dannil.scbjavaclient.exception.SCBClientUrlNotFoundException;

public class HttpRequester {

	public static String doGetRequest(String url, RequestMethod method) {

		StringBuffer result = new StringBuffer();

		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(url);

			// add request header
			request.addHeader("User-Agent", "");
			HttpResponse response = client.execute(request);

			int statusCode = response.getStatusLine().getStatusCode();
			switch (statusCode) {
				case 200:
					break;

				case 404:
					throw new SCBClientUrlNotFoundException(url);

				case 429:
					throw new SCBClientTooManyRequestsException(url);
			}

			System.out.println("Response Code : " + response.getStatusLine().getStatusCode());

			BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

			String line = "";
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
		} catch (IOException e) {
			throw new SCBClientException(e);
		}
		return result.toString();
	}
}
