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

package com.github.dannil.scbjavaclient.client.population.name;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PopulationNameStatisticsClientTest {

	@Test
	public void createWithLocaleConstructor() {
		Locale locale = new Locale("sv", "SE");
		PopulationNameStatisticsClient client = new PopulationNameStatisticsClient(locale);

		assertEquals(locale, client.getLocale());
	}

	@Test
	public void getUrl() {
		Locale locale = new Locale("sv", "SE");
		PopulationNameStatisticsClient client = new PopulationNameStatisticsClient(locale);

		assertEquals("http://api.scb.se/OV0104/v1/doris/sv/ssd/BE/BE0001/", client.getUrl());
	}

}
