package com.github.dannil.scbjavaclient.utility.requester;

import static org.junit.Assert.assertNull;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbjavaclient.exception.SCBClientException;
import com.github.dannil.scbjavaclient.test.model.RemoteIntegrationTestSuite;

@RunWith(JUnit4.class)
public class AbstractRequester_IntegrationTest extends RemoteIntegrationTestSuite {

	private static class DummyGETRequester extends GETRequester {

		public DummyGETRequester() {
			super();
			super.client = HttpClientBuilder.create().disableRedirectHandling().build();
		}

	}

	@Test(expected = SCBClientException.class)
	public void unhandledHttpStatusCode() {
		AbstractRequester abs = new DummyGETRequester();

		HttpGet get = new HttpGet("http://java.net");
		HttpResponse response = abs.getResponse(get);

		assertNull(response);
	}

}
