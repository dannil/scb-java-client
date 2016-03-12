package com.github.dannil.scbjavaclient.utility.requester;

import java.io.IOException;
import java.net.HttpURLConnection;

public class GETRequester extends Requester {

	public GETRequester() {
		super();
	}

	@Override
	public String doRequest(String address) throws IOException {
		HttpURLConnection httpUrlConnection = super.prepareConnection(address);

		httpUrlConnection.setDoInput(true);
		httpUrlConnection.setRequestMethod("GET");

		String response = super.getResponse(httpUrlConnection);
		return response;
	}

}
