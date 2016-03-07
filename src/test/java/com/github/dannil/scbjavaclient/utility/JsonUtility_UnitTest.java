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

package com.github.dannil.scbjavaclient.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.MissingNode;
import com.github.dannil.scbjavaclient.model.population.statistic.Population;

@RunWith(JUnit4.class)
public class JsonUtility_UnitTest {

	private String json;

	public JsonUtility_UnitTest() {
		this.json = "{\"query\": [{\"code\": \"ContentsCode\",\"selection\": {\"filter\": \"item\",\"values\": [\"MI0802AA\"]}}],\"response\": {\"format\": \"json\"}}";
	}

	@Test
	public void callPrivateConstructor() throws InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Constructor<?>[] cons = JsonUtility.class.getDeclaredConstructors();
		cons[0].setAccessible(true);
		cons[0].newInstance();
		cons[0].setAccessible(false);

		assertFalse(cons[0].isAccessible());
	}

	@Test
	public void getNodeField() {
		JsonNode node = JsonUtility.getNode(this.json, "query");

		String comparison = "[{\"code\": \"ContentsCode\",\"selection\": {\"filter\": \"item\",\"values\": [\"MI0802AA\"]}}]";

		assertEquals(node.toString().replaceAll("\\s+", ""), comparison.replaceAll("\\s+", ""));
	}

	@Test
	public void jsonToListNonConventionalJson() {
		String nonConventionalJson = "{\"columns\":[{\"code\":\"Region\",\"text\":\"region\",\"type\":\"d\"},{\"code\":\"Civilstand\",\"text\":\"maritalstatus\",\"type\":\"d\"},{\"code\":\"Alder\",\"text\":\"age\",\"type\":\"d\"},{\"code\":\"Tid\",\"text\":\"year\",\"type\":\"t\"},{\"code\":\"BE0101N1\",\"text\":\"Population\",\"type\":\"c\"}],\"comments\":[],\"data\":[{\"key\":[\"00\",\"OG\",\"45\",\"2011\"],\"values\":[\"48403\"]}]}";

		JsonNode node = JsonUtility.getNode(nonConventionalJson);

		List<Population> convertedPopulations = JsonUtility.jsonToListOf(node, Population.class);

		Population p = new Population("00", "OG", "45", null, 2011, Long.valueOf(48403));
		List<Population> staticPopulations = Arrays.asList(p);

		assertEquals(convertedPopulations, staticPopulations);
	}

	@Test
	public void jsonToListOfInvalidJson() {
		JsonNode node = JsonUtility.getNode(this.json);

		List<Population> populations = JsonUtility.jsonToListOf(node, Population.class);

		assertNull(populations);
	}

	@Test
	public void getNodeInvalidJson() {
		JsonNode node = JsonUtility.getNode("hello world");

		assertEquals(MissingNode.getInstance(), node);
	}

}
