package com.github.dannil.scbjavaclient.utility.requester;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Request implements Closeable {

	private URL url;

	private HttpURLConnection connection;

	private RequestMethod requestMethod;

	// public Request() {
	// // TODO Auto-generated constructor stub
	// }

	public Request(String url) {
		try {
			this.url = new URL(url);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Request(URL url) {
		this.url = url;
	}

	public RequestMethod getRequestMethod() {
		return this.requestMethod;
	}

	public void setRequestMethod(RequestMethod requestMethod) {
		this.requestMethod = requestMethod;
	}

	public Response doRequest() {
		try {
			this.connection = (HttpURLConnection) this.url.openConnection();
			this.connection.setRequestMethod(this.requestMethod.name());

			Response response = new Response();
			response.setStatusCode(this.connection.getResponseCode());

			InputStream inputStream = null;
			if (response.getStatusCode() >= 200 && response.getStatusCode() < 400) {
				inputStream = this.connection.getInputStream();
			} else {
				inputStream = this.connection.getErrorStream();
			}
			response.setBody(getBodyFromStream(inputStream));
		} catch (Exception e) {

		}

	}

	private String getBodyFromStream(InputStream inputStream) throws IOException {
		StringBuilder builder = new StringBuilder(64);
		try (BufferedReader br = new BufferedReader(new InputStreamReader(this.connection.getInputStream(), "utf-8"))) {
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
	}

	@Override
	public void close() throws IOException {
		this.connection.disconnect();
	}
}
