package com.github.dannil.scbjavaclient.utility.requester;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbjavaclient.client.SCBClient;
import com.github.dannil.scbjavaclient.client.population.name.PopulationNameStatisticsClient;
import com.github.dannil.scbjavaclient.exception.SCBClientException;
import com.github.dannil.scbjavaclient.exception.SCBClientTooManyRequestsException;
import com.github.dannil.scbjavaclient.model.population.NumberOfChildrenBornWithFirstName;
import com.github.dannil.scbjavaclient.test.model.RemoteIntegrationTestSuite;
import com.github.dannil.scbjavaclient.test.utility.Config;

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

	@Test
	public void tooManyRequests() throws InterruptedException {
		PopulationNameStatisticsClient client = new SCBClient().population().nameStatistics();

		List<List<NumberOfChildrenBornWithFirstName>> childrenWithFirstNames = new ArrayList<List<NumberOfChildrenBornWithFirstName>>();

		List<String> names = Arrays.asList("AdinaK");
		List<Integer> years = Arrays.asList(2002);

		SCBClientException e = null;
		while (e == null) {
			try {
				childrenWithFirstNames.add(client.getNumberOfChildrenBornWithFirstName(names, years));
			} catch (SCBClientTooManyRequestsException e1) {
				e = e1;
			}
		}

		assertNotNull(e);
		assertTrue(e instanceof SCBClientTooManyRequestsException);

		System.out.println(Config.getTimerMs() * 10);

		// Make sure the other tests don't fail due to this test making too many requests
		Thread.sleep(Math.min(Config.getTimerMs() * 10, 10000));
	}
}
