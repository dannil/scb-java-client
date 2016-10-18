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

package com.github.dannil.scbjavaclient.model.population.demography;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.github.dannil.scbjavaclient.model.ValueNode;

public class FertilityRate_UnitTest {

	private String testContentsCode;

	private List<ValueNode<Double>> valueNodes;

	@Before
	public void setup() {
		this.testContentsCode = "TESTCONTENTSCODE";
		this.valueNodes = new ArrayList<ValueNode<Double>>();

		ValueNode<Double> value = new ValueNode<Double>(34.56d, "TESTCONTENTSCODE", "Test contents code");
		this.valueNodes.add(value);
	}

	@Test
	public final void createWithDefaultConstructor() {
		FertilityRate rate = new FertilityRate();

		assertNotNull(rate);
	}

	@Test
	public void setRegion() {
		FertilityRate rate = new FertilityRate();

		rate.setRegion("1263");

		assertEquals("1263", rate.getRegion());
	}

	@Test
	public void setGender() {
		FertilityRate rate = new FertilityRate();

		rate.setGender(1);

		assertEquals(Integer.valueOf(1), rate.getGender());
	}

	@Test
	public void setYear() {
		FertilityRate rate = new FertilityRate();

		rate.setYear(1996);

		assertEquals(Integer.valueOf(1996), rate.getYear());
	}

	@Test
	public void setValues() {
		FertilityRate rate = new FertilityRate();

		rate.setValues(this.valueNodes);

		assertNotNull(rate.getValues());
	}

	@Test
	public void getInputs() {
		assertNotNull(FertilityRate.getInputs());
	}

	@Test
	public void equals() {
		FertilityRate rate = new FertilityRate();
		FertilityRate rate2 = new FertilityRate();

		assertEquals(rate, rate2);
	}

	@Test
	public void equalsItself() {
		FertilityRate rate = new FertilityRate();

		assertEquals(rate, rate);
	}

	@Test
	public void equalsItselfWithValues() {
		FertilityRate rate = new FertilityRate("1263", 2, 1996, this.valueNodes);
		FertilityRate rate2 = new FertilityRate("1263", 2, 1996, this.valueNodes);

		assertEquals(rate, rate2);
	}

	@Test
	public void notEqualsNull() {
		FertilityRate rate = new FertilityRate();

		assertNotEquals(rate, null);
	}

	@Test
	public void notEqualsIncompatibleObject() {
		FertilityRate rate = new FertilityRate();

		assertNotEquals(rate, new Object());
	}

	@Test
	public void notEqualsRegion() {
		FertilityRate rate = new FertilityRate("1263", 2, 1996, this.valueNodes);
		FertilityRate rate2 = new FertilityRate("1267", 2, 1996, this.valueNodes);

		assertNotEquals(rate, rate2);
	}

	@Test
	public void notEqualsGender() {
		FertilityRate rate = new FertilityRate("1263", 2, 1996, this.valueNodes);
		FertilityRate rate2 = new FertilityRate("1263", 1, 1996, this.valueNodes);

		assertNotEquals(rate, rate2);
	}

	@Test
	public void notEqualsYear() {
		FertilityRate rate = new FertilityRate("1263", 2, 1996, this.valueNodes);
		FertilityRate rate2 = new FertilityRate("1263", 2, 2002, this.valueNodes);

		assertNotEquals(rate, rate2);
	}

	@Test
	public void notEqualsValues() {
		FertilityRate rate = new FertilityRate("1263", 2, 1996, this.valueNodes);
		FertilityRate rate2 = new FertilityRate("1263", 2, 1996, this.valueNodes);
		rate2.setValue(this.testContentsCode, 65.43d);

		assertNotEquals(rate, rate2);
	}

	@Test
	public void equalsHashCode() {
		FertilityRate rate = new FertilityRate("1263", 2, 1996, this.valueNodes);
		FertilityRate rate2 = new FertilityRate("1263", 2, 1996, this.valueNodes);

		assertEquals(rate.hashCode(), rate2.hashCode());
	}

	@Test
	public void equalsHashCodeNullValues() {
		FertilityRate rate = new FertilityRate();
		FertilityRate rate2 = new FertilityRate();

		assertEquals(rate.hashCode(), rate2.hashCode());
	}

	@Test
	public void convertToStringNullValues() {
		FertilityRate rate = new FertilityRate();

		assertNotNull(rate.toString());
	}

	@Test
	public void convertToString() {
		FertilityRate rate = new FertilityRate("1263", 2, 1996, this.valueNodes);

		assertTrue(rate.toString().contains("1263"));
		assertTrue(rate.toString().contains("2"));
		assertTrue(rate.toString().contains("1996"));
		assertTrue(rate.toString().contains("34.56"));
	}

}
