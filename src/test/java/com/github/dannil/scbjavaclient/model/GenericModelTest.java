/*
 * Copyright 2016 Daniel Nilsson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under
 * the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package com.github.dannil.scbjavaclient.model;

import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GenericModelTest {

	private String json;

	@Before
	public void setup() {
		this.json = "{\"columns\":[{\"code\":\"Region\",\"text\":\"region\",\"type\":\"d\"},{\"code\":\"Civilstand\",\"text\":\"civilst\u00E5nd\",\"type\":\"d\"},{\"code\":\"Alder\",\"text\":\"\u00E5lder\",\"type\":\"d\"},{\"code\":\"Tid\",\"text\":\"\u00E5r\",\"type\":\"t\"},{\"code\":\"BE0101N1\",\"text\":\"Folkm\u00E4ngd\",\"type\":\"c\"}],\"comments\":[],\"data\":[{\"key\":[\"00\",\"OG\",\"45\",\"2011\"],\"values\":[\"48403\"]},{\"key\":[\"00\",\"OG\",\"45\",\"2012\"],\"values\":[\"47619\"]},{\"key\":[\"00\",\"OG\",\"50\",\"2011\"],\"values\":[\"34868\"]},{\"key\":[\"00\",\"OG\",\"50\",\"2012\"],\"values\":[\"36454\"]},{\"key\":[\"00\",\"G\",\"45\",\"2011\"],\"values\":[\"68640\"]},{\"key\":[\"00\",\"G\",\"45\",\"2012\"],\"values\":[\"69184\"]},{\"key\":[\"00\",\"G\",\"50\",\"2011\"],\"values\":[\"60262\"]},{\"key\":[\"00\",\"G\",\"50\",\"2012\"],\"values\":[\"61902\"]},{\"key\":[\"01\",\"OG\",\"45\",\"2011\"],\"values\":[\"10833\"]},{\"key\":[\"01\",\"OG\",\"45\",\"2012\"],\"values\":[\"10339\"]},{\"key\":[\"01\",\"OG\",\"50\",\"2011\"],\"values\":[\"7893\"]},{\"key\":[\"01\",\"OG\",\"50\",\"2012\"],\"values\":[\"8255\"]},{\"key\":[\"01\",\"G\",\"45\",\"2011\"],\"values\":[\"16031\"]},{\"key\":[\"01\",\"G\",\"45\",\"2012\"],\"values\":[\"16121\"]},{\"key\":[\"01\",\"G\",\"50\",\"2011\"],\"values\":[\"13103\"]},{\"key\":[\"01\",\"G\",\"50\",\"2012\"],\"values\":[\"13966\"]},{\"key\":[\"0114\",\"OG\",\"45\",\"2011\"],\"values\":[\"227\"]},{\"key\":[\"0114\",\"OG\",\"45\",\"2012\"],\"values\":[\"202\"]},{\"key\":[\"0114\",\"OG\",\"50\",\"2011\"],\"values\":[\"127\"]},{\"key\":[\"0114\",\"OG\",\"50\",\"2012\"],\"values\":[\"139\"]},{\"key\":[\"0114\",\"G\",\"45\",\"2011\"],\"values\":[\"344\"]},{\"key\":[\"0114\",\"G\",\"45\",\"2012\"],\"values\":[\"326\"]},{\"key\":[\"0114\",\"G\",\"50\",\"2011\"],\"values\":[\"265\"]},{\"key\":[\"0114\",\"G\",\"50\",\"2012\"],\"values\":[\"266\"]}]}";

	}

	@Test
	public void getEntries() {
		GenericModel model = new GenericModel(this.json);
		Collection<Map<String, Object>> entries = model.getEntries();

		for (Map<String, Object> entry : entries) {
			String toString = entry.toString();

			assertTrue(toString.contains("region"));
			assertTrue(toString.contains("civilstand"));
			assertTrue(toString.contains("alder"));
			assertTrue(toString.contains("tid"));
		}
	}

	@Test
	public void getEntriesFiltered() {
		GenericModel model = new GenericModel(this.json);

		Map<String, String> inputs = new HashMap<>();
		inputs.put("region", "01");
		inputs.put("alder", "50");

		Collection<Map<String, Object>> entries = model.getEntries(inputs);

		for (Map<String, Object> entry : entries) {
			String toString = entry.toString();

			assertTrue(toString.contains("region"));
			assertTrue(toString.contains("01"));
			assertTrue(toString.contains("alder"));
			assertTrue(toString.contains("50"));
			assertTrue(toString.contains("civilstand"));
			assertTrue(toString.contains("tid"));
		}
	}

	@Test
	public void getEntriesKeyAndValue() {
		GenericModel model = new GenericModel(this.json);

		Collection<Map<String, Object>> entries = model.getEntries("civilstand", "OG");

		for (Map<String, Object> entry : entries) {
			String toString = entry.toString();

			assertTrue(toString.contains("civilstand"));
			assertTrue(toString.contains("OG"));
			assertTrue(toString.contains("region"));
			assertTrue(toString.contains("alder"));
			assertTrue(toString.contains("tid"));
		}
	}

	@Test
	public void toStringNotEmpty() {
		GenericModel model = new GenericModel(this.json);
		String toString = model.toString();

		assertTrue(toString.contains("region"));
		assertTrue(toString.contains("00"));
		assertTrue(toString.contains("01"));
		assertTrue(toString.contains("0114"));

		assertTrue(toString.contains("civilstand"));
		assertTrue(toString.contains("G"));
		assertTrue(toString.contains("OG"));

		assertTrue(toString.contains("alder"));
		assertTrue(toString.contains("45"));
		assertTrue(toString.contains("50"));

		assertTrue(toString.contains("tid"));
		assertTrue(toString.contains("2011"));
		assertTrue(toString.contains("2012"));
	}

}
