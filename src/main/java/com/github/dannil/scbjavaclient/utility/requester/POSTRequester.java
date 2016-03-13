package com.github.dannil.scbjavaclient.utility.requester;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;

public class POSTRequester extends AbstractRequester {

	private String payload;

	public String getPayload() {
		return this.payload;
	}

	public void setPayload(String payload) {
		this.payload = payload;
	}

	@Override
	public String doRequest(String address) throws IOException {
		if (this.payload == null) {
			throw new IllegalStateException("Payload is null");
		}

		HttpURLConnection httpUrlConnection = super.prepareConnection(address);

		httpUrlConnection.setDoInput(true);
		httpUrlConnection.setDoOutput(true);
		httpUrlConnection.setRequestMethod("POST");

		try (OutputStreamWriter writer = new OutputStreamWriter(httpUrlConnection.getOutputStream(), "utf-8")) {
			writer.write(this.payload);
			writer.close();
		}

		String response = super.getResponse(httpUrlConnection);
		return response;
		// throw new UnsupportedOperationException();
	}

}
