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

package com.github.dannil.scbjavaclient.client;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SCBClient_UnitTest {

	@Test
	public void createWithLocaleConstructor() {
		Locale locale = new Locale("sv", "SE");
		SCBClient client = new SCBClient(locale);

		assertEquals(locale, client.getLocale());
	}

	@Test
	public void getRawData() {
		Locale locale = new Locale("sv", "SE");
		SCBClient client = new SCBClient(locale);

		Map<String, Collection<?>> payload = new HashMap<String, Collection<?>>();
		payload.put("ContentsCode", Arrays.asList("BE0101N1"));
		payload.put("Region", Arrays.asList("00", "01", "0114"));
		payload.put("Civilstand", Arrays.asList("OG", "G"));
		payload.put("Alder", Arrays.asList(45, 50));
		payload.put("Tid", Arrays.asList(2011, 2012));

		String response = client.getRawData("BE/BE0101/BE0101A/BefolkningNy", payload);

		assertTrue(response.contains("Region"));
		assertTrue(response.contains("Civilstand"));
		assertTrue(response.contains("Alder"));
		assertTrue(response.contains("Tid"));
	}

	@Test
	public void setLocalizationLanguage() {
		Locale locale = new Locale("sv", "SE");
		SCBClient client = new SCBClient(locale);

		Locale localizationLocale = new Locale("en", "US");
		client.setLocalizationLanguage(localizationLocale);

		assertEquals(localizationLocale, client.localization.getLanguage());
	}

}
