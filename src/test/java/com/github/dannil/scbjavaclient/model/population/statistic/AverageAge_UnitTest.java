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

import com.github.dannil.scbjavaclient.model.ValueNode;

public class AverageAge_UnitTest {

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
		AverageAge avg = new AverageAge();

		assertNotNull(avg);
	}

	@Test
	public void setRegion() {
		AverageAge avg = new AverageAge();

		avg.setRegion("1263");

		assertEquals("1263", avg.getRegion());
	}

	@Test
	public void setGender() {
		AverageAge avg = new AverageAge();

		avg.setGender("1");

		assertEquals("1", avg.getGender());
	}

	@Test
	public void setYear() {
		AverageAge avg = new AverageAge();

		avg.setYear(1996);

		assertEquals(Integer.valueOf(1996), avg.getYear());
	}

	@Test
	public void setValues() {
		AverageAge avg = new AverageAge();

		avg.setValues(this.valueNodes);

		assertNotNull(avg.getValues());
	}

	@Test
	public void getCodes() {
		assertNotNull(AverageAge.getCodes());
	}

	@Test
	public void equals() {
		AverageAge avg = new AverageAge();
		AverageAge avg2 = new AverageAge();

		assertEquals(avg, avg2);
	}

	@Test
	public void equalsItself() {
		AverageAge avg = new AverageAge();

		assertEquals(avg, avg);
	}

	@Test
	public void equalsItselfWithValues() {
		AverageAge avg = new AverageAge("1263", "2", 1996, this.valueNodes);
		AverageAge avg2 = new AverageAge("1263", "2", 1996, this.valueNodes);

		assertEquals(avg, avg2);
	}

	@Test
	public void notEqualsNull() {
		AverageAge avg = new AverageAge();

		assertNotEquals(avg, null);
	}

	@Test
	public void notEqualsIncompatibleObject() {
		AverageAge avg = new AverageAge();

		assertNotEquals(avg, new Object());
	}

	@Test
	public void notEqualsRegion() {
		AverageAge avg = new AverageAge("1263", "2", 1996, this.valueNodes);
		AverageAge avg2 = new AverageAge("1267", "2", 1996, this.valueNodes);

		assertNotEquals(avg, avg2);
	}

	@Test
	public void notEqualsGender() {
		AverageAge avg = new AverageAge("1263", "2", 1996, this.valueNodes);
		AverageAge avg2 = new AverageAge("1263", "1", 1996, this.valueNodes);

		assertNotEquals(avg, avg2);
	}

	@Test
	public void notEqualsYear() {
		AverageAge avg = new AverageAge("1263", "2", 1996, this.valueNodes);
		AverageAge avg2 = new AverageAge("1263", "2", 2002, this.valueNodes);

		assertNotEquals(avg, avg2);
	}

	@Test
	public void notEqualsValues() {
		AverageAge avg = new AverageAge("1263", "2", 1996, this.valueNodes);
		AverageAge avg2 = new AverageAge("1263", "2", 1996, this.valueNodes);
		avg2.setValue(this.testContentsCode, 65.43d);

		assertNotEquals(avg, avg2);
	}

	@Test
	public void equalsHashCode() {
		AverageAge avg = new AverageAge("1263", "2", 1996, this.valueNodes);
		AverageAge avg2 = new AverageAge("1263", "2", 1996, this.valueNodes);

		assertEquals(avg.hashCode(), avg2.hashCode());
	}

	@Test
	public void equalsHashCodeNullValues() {
		AverageAge avg = new AverageAge();
		AverageAge avg2 = new AverageAge();

		assertEquals(avg.hashCode(), avg2.hashCode());
	}

	@Test
	public void convertToStringNullValues() {
		AverageAge avg = new AverageAge();

		assertNotNull(avg.toString());
	}

	@Test
	public void convertToString() {
		AverageAge avg = new AverageAge("1263", "2", 1996, this.valueNodes);

		assertTrue(avg.toString().contains("1263"));
		assertTrue(avg.toString().contains("2"));
		assertTrue(avg.toString().contains("1996"));
		assertTrue(avg.toString().contains("34.56"));
	}

}
