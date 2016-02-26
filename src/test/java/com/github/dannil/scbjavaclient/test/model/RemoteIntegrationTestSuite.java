package com.github.dannil.scbjavaclient.test.model;

import org.junit.Before;

import com.github.dannil.scbjavaclient.test.utility.Config;

public abstract class RemoteIntegrationTestSuite {

	protected RemoteIntegrationTestSuite() {

	}

	@Before
	public void setup() throws InterruptedException {
		// Due to constraints set by SCB, we can only do 10 calls every 10
		// seconds, so we need an artificial timer which handles this.
		Thread.sleep(Config.getTimerMs());
	}

}
