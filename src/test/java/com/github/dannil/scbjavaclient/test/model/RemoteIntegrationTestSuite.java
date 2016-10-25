/*
 * Copyright 2016 Daniel Nilsson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.dannil.scbjavaclient.test.model;

import org.junit.Before;

import com.github.dannil.scbjavaclient.test.utility.Config;

public abstract class RemoteIntegrationTestSuite {

	protected RemoteIntegrationTestSuite() {

	}

	@Before
	public void setupTimer() throws InterruptedException {
		// Due to constraints set by SCB, we can only do 10 calls every 10
		// seconds, so we need an artificial timer which handles this.
		Thread.sleep(Config.getTimerMs());
	}

}
