package com.github.dannil.scbjavaclient.test;

import java.io.IOException;

import com.github.dannil.scbjavaclient.utility.requester.GETRequester;
import com.github.dannil.scbjavaclient.utility.requester.HttpRequester;
import com.github.dannil.scbjavaclient.utility.requester.RequestMethod;

public class TestHTTP {

	public static void main(String[] args) throws IOException {
		String url = "http://api.scb.se/OV0104/v1/doris/en/ssd/BE/";

		String response = HttpRequester.doGetRequest(url, RequestMethod.GET);
		System.out.println(response);

		GETRequester getRequester = new GETRequester();
		String res = getRequester.getResponse(url);
		System.out.println(res);
	}

}
