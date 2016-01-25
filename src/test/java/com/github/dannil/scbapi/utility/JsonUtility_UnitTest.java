package com.github.dannil.scbapi.utility;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.dannil.scbapi.model.population.statistic.LiveBirth;

@RunWith(JUnit4.class)
public class JsonUtility_UnitTest {

	private String json;

	public JsonUtility_UnitTest() {
		this.json = "{\"query\": [{\"code\": \"ContentsCode\",\"selection\": {\"filter\": \"item\",\"values\": [\"MI0802AA\"]}}],\"response\": {\"format\": \"json\"}}";
	}

	@Test
	public void callPrivateConstructor() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
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
	public void getNodeInvalidJson() {
		JsonNode node = JsonUtility.getNode("hello world");

		assertEquals(null, node);
	}

	@Test(expected = IllegalArgumentException.class)
	public void genericParseWithoutColumns() {
		JsonNode node = JsonUtility.getNode(this.json);

		List<LiveBirth> liveBirths = JsonUtility.parseLiveBirths(node);

		assertEquals(null, liveBirths);
	}

}
