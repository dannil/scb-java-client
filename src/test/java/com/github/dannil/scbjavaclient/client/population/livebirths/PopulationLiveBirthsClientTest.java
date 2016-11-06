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

package com.github.dannil.scbjavaclient.client.population.livebirths;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbjavaclient.client.SCBClient;

@RunWith(JUnit4.class)
public class PopulationLiveBirthsClientTest {

	private PopulationLiveBirthsClient populationLiveBirthsClient;

	@Before
	public void setup() {
		Locale locale = new Locale("sv", "SE");
		this.populationLiveBirthsClient = new SCBClient(locale).population().liveBirths();
	}

	@Test
	public void getUrl() {
		assertEquals("http://api.scb.se/OV0104/v1/doris/sv/ssd/BE/BE0101/BE0101H/",
				this.populationLiveBirthsClient.getUrl());
	}

}
