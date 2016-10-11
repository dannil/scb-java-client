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

package com.github.dannil.scbjavaclient.model.population.statistic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbjavaclient.model.Value;

@RunWith(JUnit4.class)
public class LiveBirth_UnitTest {

	private String testContentsCode;

	private List<Value<Long>> values;

	@Before
	public void setup() {
		this.testContentsCode = "TESTCONTENTSCODE";
		this.values = new ArrayList<Value<Long>>();

		Value<Long> value = new Value<Long>(12345L, "TESTCONTENTSCODE", "Test contents code");
		this.values.add(value);
	}

	@Test
	public final void createWithDefaultConstructor() {
		LiveBirth liveBirth = new LiveBirth();

		assertNotNull(liveBirth);
	}

	@Test
	public void setRegion() {
		LiveBirth liveBirth = new LiveBirth();

		liveBirth.setRegion("1263");

		assertEquals("1263", liveBirth.getRegion());
	}

	@Test
	public void setMotherAge() {
		LiveBirth liveBirth = new LiveBirth();

		liveBirth.setMotherAge("tot");

		assertEquals("tot", liveBirth.getMotherAge());
	}

	@Test
	public void setGender() {
		LiveBirth liveBirth = new LiveBirth();

		liveBirth.setGender(1);

		assertEquals(Integer.valueOf(1), liveBirth.getGender());
	}

	@Test
	public void setYear() {
		LiveBirth liveBirth = new LiveBirth();

		liveBirth.setYear(1996);

		assertEquals(Integer.valueOf(1996), liveBirth.getYear());
	}

	@Test
	public void setValues() {
		LiveBirth liveBirth = new LiveBirth();

		liveBirth.setValues(this.values);

		assertNotNull(liveBirth.getValues());
	}

	@Test
	public void getCodes() {
		assertNotNull(LiveBirth.getCodes());
	}

	@Test
	public void equals() {
		LiveBirth liveBirth = new LiveBirth();
		LiveBirth liveBirth2 = new LiveBirth();

		assertEquals(liveBirth, liveBirth2);
	}

	@Test
	public void equalsItself() {
		LiveBirth liveBirth = new LiveBirth();

		assertEquals(liveBirth, liveBirth);
	}

	@Test
	public void equalsItselfWithValues() {
		LiveBirth liveBirth = new LiveBirth("1263", "tot", 1, 2002, this.values);
		LiveBirth liveBirth2 = new LiveBirth("1263", "tot", 1, 2002, this.values);

		assertEquals(liveBirth, liveBirth2);
	}

	@Test
	public void notEqualsNull() {
		LiveBirth liveBirth = new LiveBirth();

		assertNotEquals(liveBirth, null);
	}

	@Test
	public void notEqualsIncompatibleObject() {
		LiveBirth liveBirth = new LiveBirth();

		assertNotEquals(liveBirth, new Object());
	}

	@Test
	public void notEqualsRegion() {
		LiveBirth liveBirth = new LiveBirth("1263", "tot", 1, 2002, this.values);
		LiveBirth liveBirth2 = new LiveBirth("1267", "tot", 1, 2002, this.values);

		assertNotEquals(liveBirth, liveBirth2);
	}

	@Test
	public void notEqualsMotherAge() {
		LiveBirth liveBirth = new LiveBirth("1263", "tot", 1, 2002, this.values);
		LiveBirth liveBirth2 = new LiveBirth("1263", "21", 1, 2002, this.values);

		assertNotEquals(liveBirth, liveBirth2);
	}

	@Test
	public void notEqualsGender() {
		LiveBirth liveBirth = new LiveBirth("1263", "tot", 1, 2002, this.values);
		LiveBirth liveBirth2 = new LiveBirth("1263", "tot", 2, 2002, this.values);

		assertNotEquals(liveBirth, liveBirth2);
	}

	@Test
	public void notEqualsYear() {
		LiveBirth liveBirth = new LiveBirth("1263", "tot", 1, 2002, this.values);
		LiveBirth liveBirth2 = new LiveBirth("1263", "tot", 1, 1996, this.values);

		assertNotEquals(liveBirth, liveBirth2);
	}

	@Test
	public void notEqualsAmount() {
		LiveBirth liveBirth = new LiveBirth("1263", "tot", 1, 2002, this.values);
		LiveBirth liveBirth2 = new LiveBirth("1263", "tot", 1, 2002, this.values);
		liveBirth2.setValue(this.testContentsCode, 54321L);

		assertNotEquals(liveBirth, liveBirth2);
	}

	@Test
	public void equalsHashCode() {
		LiveBirth liveBirth = new LiveBirth("1263", "tot", 1, 2002, this.values);
		LiveBirth liveBirth2 = new LiveBirth("1263", "tot", 1, 2002, this.values);

		assertEquals(liveBirth.hashCode(), liveBirth2.hashCode());
	}

	@Test
	public void equalsHashCodeNullValues() {
		LiveBirth liveBirth = new LiveBirth();
		LiveBirth liveBirth2 = new LiveBirth();

		assertEquals(liveBirth.hashCode(), liveBirth2.hashCode());
	}

	@Test
	public void convertToStringNullValues() {
		LiveBirth liveBirth = new LiveBirth();

		assertNotNull(liveBirth.toString());
	}

	@Test
	public void convertToString() {
		LiveBirth liveBirth = new LiveBirth("1263", "tot", 1, 2002, this.values);

		assertTrue(liveBirth.toString().contains("1263"));
		assertTrue(liveBirth.toString().contains("tot"));
		assertTrue(liveBirth.toString().contains("1"));
		assertTrue(liveBirth.toString().contains("2002"));
		assertTrue(liveBirth.toString().contains("12345"));
	}

}