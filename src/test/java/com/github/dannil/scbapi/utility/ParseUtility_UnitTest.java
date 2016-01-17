/*
Copyright 2016 Daniel Nilsson

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License. 
 */

package com.github.dannil.scbapi.utility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ParseUtility_UnitTest {

	@Test
	public void parseInteger() {
		assertEquals(Integer.valueOf(42), ParseUtility.parseInteger("42"));
	}

	@Test
	public void parseIntegerNullDefault() {
		assertEquals(null, ParseUtility.parseInteger("helloworld", null));
	}

	@Test
	public void parseIntegerOverloaded() {
		assertEquals(Integer.valueOf(42), ParseUtility.parseInteger("42", -1));
	}

	@Test
	public void parseIntegerInvalidInput() {
		assertEquals(Integer.valueOf(-1), ParseUtility.parseInteger("helloworld", -1));
	}

	@Test
	public void parseLong() {
		assertEquals(Long.valueOf(123456789123456789L), ParseUtility.parseLong("123456789123456789"));
	}

	@Test
	public void parseLongNullDefault() {
		assertEquals(null, ParseUtility.parseLong("helloworld", null));
	}

	@Test
	public void parseLongOverloaded() {
		assertEquals(Long.valueOf(123456789123456789L), ParseUtility.parseLong("123456789123456789", -1L));
	}

	@Test
	public void parseLongInvalidInput() {
		assertEquals(Long.valueOf(-1), ParseUtility.parseLong("helloworld", -1L));
	}

	@Test
	public void parseDouble() {
		assertEquals(Double.valueOf(0.123456789), ParseUtility.parseDouble("0.123456789"));
	}

	@Test
	public void parseDoubleNullDefault() {
		assertEquals(null, ParseUtility.parseDouble("helloworld", null));
	}

	@Test
	public void parseDoubleOverloaded() {
		assertEquals(Double.valueOf(0.123456789), ParseUtility.parseDouble("0.123456789", 0.00));
	}

	@Test
	public void parseDoubleInvalidInput() {
		assertEquals(Double.valueOf(0.00), ParseUtility.parseDouble("helloworld", 0.00));
	}

}
