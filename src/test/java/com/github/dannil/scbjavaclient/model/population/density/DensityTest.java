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

package com.github.dannil.scbjavaclient.model.population.density;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.github.dannil.scbjavaclient.model.ValueNode;

public class DensityTest {

	private String testContentsCode;

	private List<ValueNode<Double>> values;
	private List<ValueNode<Double>> values2;

	@Before
	public void setup() {
		this.testContentsCode = "TESTCONTENTSCODE";

		this.values = new ArrayList<ValueNode<Double>>();
		this.values2 = new ArrayList<ValueNode<Double>>();

		ValueNode<Double> value = new ValueNode<Double>(123.45d, this.testContentsCode, "Test contents code");
		this.values.add(value);

		// Copy previous value node into new object
		ValueNode<Double> value2 = new ValueNode<Double>(value.getValue(), value.getCode(), value.getText());
		this.values2.add(value2);
	}

	@Test
	public void createWithDefaultConstructor() {
		Density density = new Density();

		assertNotNull(density);
	}

	@Test
	public void setRegion() {
		Density density = new Density();

		density.setRegion("1263");

		assertEquals("1263", density.getRegion());
	}

	@Test
	public void setSex() {
		Density density = new Density();

		density.setSex("2");

		assertEquals("2", density.getSex());
	}

	@Test
	public void setYear() {
		Density density = new Density();

		density.setYear(1996);

		assertEquals(Integer.valueOf(1996), density.getYear());
	}

	@Test
	public void setValues() {
		Density density = new Density();

		density.setValues(this.values);

		assertNotNull(density.getValues());
	}

	@Test
	public void getInputs() {
		assertNotNull(Density.getInputs());
	}

	@Test
	public void equals() {
		Density density = new Density();
		Density density2 = new Density();

		assertEquals(density, density2);
	}

	@Test
	public void equalsItself() {
		Density density = new Density();

		assertEquals(density, density);
	}

	@Test
	public void equalsItselfWithValues() {
		Density density = new Density("1263", "2", 1996, this.values);
		Density density2 = new Density("1263", "2", 1996, this.values2);

		assertEquals(density, density2);
	}

	@Test
	public void notEqualsNull() {
		Density density = new Density();

		assertNotEquals(density, null);
	}

	@Test
	public void notEqualsIncompatibleObject() {
		Density density = new Density();

		assertNotEquals(density, new Object());
	}

	@Test
	public void notEqualsRegion() {
		Density density = new Density("1263", "2", 1996, this.values);
		Density density2 = new Density("1267", "2", 1996, this.values2);

		assertNotEquals(density, density2);
	}

	@Test
	public void notEqualsSex() {
		Density density = new Density("1263", "2", 1996, this.values);
		Density density2 = new Density("1263", "1", 1996, this.values2);

		assertNotEquals(density, density2);
	}

	@Test
	public void notEqualsYear() {
		Density density = new Density("1263", "2", 1996, this.values);
		Density density2 = new Density("1263", "2", 2002, this.values2);

		assertNotEquals(density, density2);
	}

	@Test
	public void notEqualsValues() {
		Density density = new Density("1263", "2", 1996, this.values);
		Density density2 = new Density("1263", "2", 1996, this.values2);
		density2.setValue(this.testContentsCode, 18.11d);

		assertNotEquals(density, density2);
	}

	@Test
	public void equalsHashCode() {
		Density density = new Density("1263", "2", 1996, this.values);
		Density density2 = new Density("1263", "2", 1996, this.values2);

		assertEquals(density.hashCode(), density2.hashCode());
	}

	@Test
	public void equalsHashCodeNullValues() {
		Density density = new Density();
		Density density2 = new Density();

		assertEquals(density.hashCode(), density2.hashCode());
	}

	@Test
	public void convertToStringNullValues() {
		Density density = new Density();

		assertNotNull(density.toString());
	}

	@Test
	public void convertToString() {
		Density density = new Density("1263", "2", 1996, this.values);

		assertTrue(density.toString().contains("1263"));
		assertTrue(density.toString().contains("2"));
		assertTrue(density.toString().contains("1996"));
		assertTrue(density.toString().contains("123.45"));
	}

}
