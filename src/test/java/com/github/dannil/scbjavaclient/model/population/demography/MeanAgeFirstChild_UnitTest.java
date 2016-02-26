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

import org.junit.Test;

import com.github.dannil.scbjavaclient.model.population.demography.MeanAgeFirstChild;

public class MeanAgeFirstChild_UnitTest {

	@Test
	public final void createWithDefaultConstructor() {
		MeanAgeFirstChild avg = new MeanAgeFirstChild();

		assertNotNull(avg);
	}

	@Test
	public void setRegion() {
		MeanAgeFirstChild avg = new MeanAgeFirstChild();

		avg.setRegion("1263");

		assertEquals("1263", avg.getRegion());
	}

	@Test
	public void setGender() {
		MeanAgeFirstChild avg = new MeanAgeFirstChild();

		avg.setGender(1);

		assertEquals(Integer.valueOf(1), avg.getGender());
	}

	@Test
	public void setYear() {
		MeanAgeFirstChild avg = new MeanAgeFirstChild();

		avg.setYear(1996);

		assertEquals(Integer.valueOf(1996), avg.getYear());
	}

	@Test
	public void setValue() {
		MeanAgeFirstChild avg = new MeanAgeFirstChild();

		avg.setValue(34.56);

		assertEquals(Double.valueOf(34.56), avg.getValue());
	}

	@Test
	public void getCodes() {
		assertNotNull(MeanAgeFirstChild.getCodes());
	}

	@Test
	public void equals() {
		MeanAgeFirstChild avg = new MeanAgeFirstChild();
		MeanAgeFirstChild avg2 = new MeanAgeFirstChild();

		assertEquals(avg, avg2);
	}

	@Test
	public void equalsItself() {
		MeanAgeFirstChild avg = new MeanAgeFirstChild();

		assertEquals(avg, avg);
	}

	@Test
	public void equalsItselfWithValues() {
		MeanAgeFirstChild avg = new MeanAgeFirstChild("1263", 2, 1996, 34.56);
		MeanAgeFirstChild avg2 = new MeanAgeFirstChild("1263", 2, 1996, 34.56);

		assertEquals(avg, avg2);
	}

	@Test
	public void notEqualsNull() {
		MeanAgeFirstChild avg = new MeanAgeFirstChild();

		assertNotEquals(avg, null);
	}

	@Test
	public void notEqualsIncompatibleObject() {
		MeanAgeFirstChild avg = new MeanAgeFirstChild();

		assertNotEquals(avg, new Object());
	}

	@Test
	public void notEqualsRegion() {
		MeanAgeFirstChild avg = new MeanAgeFirstChild("1263", 2, 1996, 34.56);
		MeanAgeFirstChild avg2 = new MeanAgeFirstChild("1267", 2, 1996, 34.56);

		assertNotEquals(avg, avg2);
	}

	@Test
	public void notEqualsGender() {
		MeanAgeFirstChild avg = new MeanAgeFirstChild("1263", 2, 1996, 34.56);
		MeanAgeFirstChild avg2 = new MeanAgeFirstChild("1263", 1, 1996, 34.56);

		assertNotEquals(avg, avg2);
	}

	@Test
	public void notEqualsYear() {
		MeanAgeFirstChild avg = new MeanAgeFirstChild("1263", 2, 1996, 34.56);
		MeanAgeFirstChild avg2 = new MeanAgeFirstChild("1263", 2, 2002, 34.56);

		assertNotEquals(avg, avg2);
	}

	@Test
	public void notEqualsAverageAge() {
		MeanAgeFirstChild avg = new MeanAgeFirstChild("1263", 2, 1996, 34.56);
		MeanAgeFirstChild avg2 = new MeanAgeFirstChild("1263", 2, 1996, 65.43);

		assertNotEquals(avg, avg2);
	}

	@Test
	public void equalsHashCode() {
		MeanAgeFirstChild avg = new MeanAgeFirstChild("1263", 2, 1996, 34.56);
		MeanAgeFirstChild avg2 = new MeanAgeFirstChild("1263", 2, 1996, 34.56);

		assertEquals(avg.hashCode(), avg2.hashCode());
	}

	@Test
	public void equalsHashCodeNullValues() {
		MeanAgeFirstChild avg = new MeanAgeFirstChild();
		MeanAgeFirstChild avg2 = new MeanAgeFirstChild();

		assertEquals(avg.hashCode(), avg2.hashCode());
	}

	@Test
	public void convertToStringNullValues() {
		MeanAgeFirstChild avg = new MeanAgeFirstChild();

		assertNotNull(avg.toString());
	}

	@Test
	public void convertToString() {
		MeanAgeFirstChild avg = new MeanAgeFirstChild("1263", 2, 1996, 34.56);

		assertTrue(avg.toString().contains("1263"));
		assertTrue(avg.toString().contains("2"));
		assertTrue(avg.toString().contains("1996"));
		assertTrue(avg.toString().contains("34.56"));
	}

}
