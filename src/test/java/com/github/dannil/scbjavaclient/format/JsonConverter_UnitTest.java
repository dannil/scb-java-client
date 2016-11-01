package com.github.dannil.scbjavaclient.format;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.fasterxml.jackson.databind.JsonNode;
import com.github.dannil.scbjavaclient.exception.SCBClientParsingException;

@RunWith(JUnit4.class)
public class JsonConverter_UnitTest {

	private String json;

	private JsonConverter converter;

	@Before
	public void setup() {
		this.json = "{\"query\": [{\"code\": \"ContentsCode\",\"selection\": {\"filter\": \"item\",\"values\": [\"MI0802AA\"]}}],\"response\": {\"format\": \"json\"}}";

		this.converter = new JsonConverter();
	}

	@Test
	public void getNodeField() {
		JsonNode node = this.converter.toNode(this.json, "query");

		String comparison = "[{\"code\": \"ContentsCode\",\"selection\": {\"filter\": \"item\",\"values\": [\"MI0802AA\"]}}]";

		assertEquals(node.toString().replaceAll("\\s+", ""), comparison.replaceAll("\\s+", ""));
	}

	@Test(expected = SCBClientParsingException.class)
	public void getNodeInvalidJson() {
		JsonNode node = this.converter.toNode("hello world");

		assertNull(node);
	}

}
