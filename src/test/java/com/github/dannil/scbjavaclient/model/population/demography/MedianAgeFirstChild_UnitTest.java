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

import com.github.dannil.scbjavaclient.model.population.demography.MedianAgeFirstChild;

public class MedianAgeFirstChild_UnitTest {

	@Test
	public final void createWithDefaultConstructor() {
		MedianAgeFirstChild avg = new MedianAgeFirstChild();

		assertNotNull(avg);
	}

	@Test
	public void setRegion() {
		MedianAgeFirstChild avg = new MedianAgeFirstChild();

		avg.setRegion("1263");

		assertEquals("1263", avg.getRegion());
	}

	@Test
	public void setGender() {
		MedianAgeFirstChild avg = new MedianAgeFirstChild();

		avg.setGender(1);

		assertEquals(Integer.valueOf(1), avg.getGender());
	}

	@Test
	public void setYear() {
		MedianAgeFirstChild avg = new MedianAgeFirstChild();

		avg.setYear(1996);

		assertEquals(Integer.valueOf(1996), avg.getYear());
	}

	@Test
	public void setValue() {
		MedianAgeFirstChild avg = new MedianAgeFirstChild();

		avg.setValue(34.56);

		assertEquals(Double.valueOf(34.56), avg.getValue());
	}

	@Test
	public void getCodes() {
		assertNotNull(MedianAgeFirstChild.getCodes());
	}

	@Test
	public void equals() {
		MedianAgeFirstChild avg = new MedianAgeFirstChild();
		MedianAgeFirstChild avg2 = new MedianAgeFirstChild();

		assertEquals(avg, avg2);
	}

	@Test
	public void equalsItself() {
		MedianAgeFirstChild avg = new MedianAgeFirstChild();

		assertEquals(avg, avg);
	}

	@Test
	public void equalsItselfWithValues() {
		MedianAgeFirstChild avg = new MedianAgeFirstChild("1263", 2, 1996, 34.56);
		MedianAgeFirstChild avg2 = new MedianAgeFirstChild("1263", 2, 1996, 34.56);

		assertEquals(avg, avg2);
	}

	@Test
	public void notEqualsNull() {
		MedianAgeFirstChild avg = new MedianAgeFirstChild();

		assertNotEquals(avg, null);
	}

	@Test
	public void notEqualsIncompatibleObject() {
		MedianAgeFirstChild avg = new MedianAgeFirstChild();

		assertNotEquals(avg, new Object());
	}

	@Test
	public void notEqualsRegion() {
		MedianAgeFirstChild avg = new MedianAgeFirstChild("1263", 2, 1996, 34.56);
		MedianAgeFirstChild avg2 = new MedianAgeFirstChild("1267", 2, 1996, 34.56);

		assertNotEquals(avg, avg2);
	}

	@Test
	public void notEqualsGender() {
		MedianAgeFirstChild avg = new MedianAgeFirstChild("1263", 2, 1996, 34.56);
		MedianAgeFirstChild avg2 = new MedianAgeFirstChild("1263", 1, 1996, 34.56);

		assertNotEquals(avg, avg2);
	}

	@Test
	public void notEqualsYear() {
		MedianAgeFirstChild avg = new MedianAgeFirstChild("1263", 2, 1996, 34.56);
		MedianAgeFirstChild avg2 = new MedianAgeFirstChild("1263", 2, 2002, 34.56);

		assertNotEquals(avg, avg2);
	}

	@Test
	public void notEqualsAverageAge() {
		MedianAgeFirstChild avg = new MedianAgeFirstChild("1263", 2, 1996, 34.56);
		MedianAgeFirstChild avg2 = new MedianAgeFirstChild("1263", 2, 1996, 65.43);

		assertNotEquals(avg, avg2);
	}

	@Test
	public void equalsHashCode() {
		MedianAgeFirstChild avg = new MedianAgeFirstChild("1263", 2, 1996, 34.56);
		MedianAgeFirstChild avg2 = new MedianAgeFirstChild("1263", 2, 1996, 34.56);

		assertEquals(avg.hashCode(), avg2.hashCode());
	}

	@Test
	public void equalsHashCodeNullValues() {
		MedianAgeFirstChild avg = new MedianAgeFirstChild();
		MedianAgeFirstChild avg2 = new MedianAgeFirstChild();

		assertEquals(avg.hashCode(), avg2.hashCode());
	}

	@Test
	public void convertToStringNullValues() {
		MedianAgeFirstChild avg = new MedianAgeFirstChild();

		assertNotNull(avg.toString());
	}

	@Test
	public void convertToString() {
		MedianAgeFirstChild avg = new MedianAgeFirstChild("1263", 2, 1996, 34.56);

		assertTrue(avg.toString().contains("1263"));
		assertTrue(avg.toString().contains("2"));
		assertTrue(avg.toString().contains("1996"));
		assertTrue(avg.toString().contains("34.56"));
	}

}
