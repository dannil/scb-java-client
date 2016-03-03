package com.github.dannil.scbjavaclient.client.population;

import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbjavaclient.client.SCBClient;

@RunWith(JUnit4.class)
public class PopulationClient_IntegrationTest {

	private PopulationClient populationClient;

	@Before
	public void setup() {
		this.populationClient = new SCBClient().population();
	}

	@Test
	public void getNumberOfChildrenBornWithFirstName() {
		assertNotEquals(0, this.populationClient.getNumberOfChildrenBornWithFirstName().size());
	}

}
