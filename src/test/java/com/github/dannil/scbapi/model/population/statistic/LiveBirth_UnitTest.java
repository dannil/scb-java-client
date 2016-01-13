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

package com.github.dannil.scbapi.model.population.statistic;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbapi.model.population.Gender;

@RunWith(JUnit4.class)
public class LiveBirth_UnitTest {

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

		liveBirth.setGender(Gender.MAN);

		assertEquals(Gender.MAN, liveBirth.getGender());
	}

	@Test
	public void setYear() {
		LiveBirth liveBirth = new LiveBirth();

		liveBirth.setYear(1996);

		assertEquals(Integer.valueOf(1996), liveBirth.getYear());
	}

	@Test
	public void setAmount() {
		LiveBirth liveBirth = new LiveBirth();

		liveBirth.setAmount(12345L);

		assertEquals(Long.valueOf(12345L), liveBirth.getAmount());
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
		LiveBirth liveBirth = new LiveBirth("1263", "tot", Gender.MAN, 2002, 12345L);
		LiveBirth liveBirth2 = new LiveBirth("1263", "tot", Gender.MAN, 2002, 12345L);

		assertEquals(liveBirth, liveBirth2);
	}

	@Test
	public void notEqualsNull() {
		LiveBirth liveBirth = new LiveBirth();

		assertFalse(liveBirth.equals(null));
	}

	@Test
	public void notEqualsIncompatibleObject() {
		LiveBirth liveBirth = new LiveBirth();

		assertFalse(liveBirth.equals(new Object()));
	}

	@Test
	public void notEqualsRegion() {
		LiveBirth liveBirth = new LiveBirth("1263", "21", Gender.MAN, 2002, 12345L);
		LiveBirth liveBirth2 = new LiveBirth("1267", "21", Gender.MAN, 2002, 12345L);

		assertFalse(liveBirth.equals(liveBirth2));
	}

	@Test
	public void notEqualsMotherAge() {
		LiveBirth liveBirth = new LiveBirth("1263", "21", Gender.MAN, 2002, 12345L);
		LiveBirth liveBirth2 = new LiveBirth("1263", "tot", Gender.MAN, 2002, 12345L);

		assertFalse(liveBirth.equals(liveBirth2));
	}

	@Test
	public void notEqualsGender() {
		LiveBirth liveBirth = new LiveBirth("1263", "tot", Gender.MAN, 2002, 12345L);
		LiveBirth liveBirth2 = new LiveBirth("1263", "tot", Gender.WOMAN, 2002, 12345L);

		assertFalse(liveBirth.equals(liveBirth2));
	}

	@Test
	public void notEqualsYear() {
		LiveBirth liveBirth = new LiveBirth("1263", "21", Gender.MAN, 1996, 12345L);
		LiveBirth liveBirth2 = new LiveBirth("1263", "21", Gender.MAN, 2002, 12345L);

		assertFalse(liveBirth.equals(liveBirth2));
	}

	@Test
	public void notEqualsAmount() {
		LiveBirth liveBirth = new LiveBirth("1263", "tot", Gender.MAN, 2002, 12345L);
		LiveBirth liveBirth2 = new LiveBirth("1263", "tot", Gender.MAN, 2002, 54321L);

		assertFalse(liveBirth.equals(liveBirth2));
	}

	@Test
	public void equalsHashCode() {
		LiveBirth liveBirth = new LiveBirth("1263", "tot", Gender.MAN, 2002, 12345L);
		LiveBirth liveBirth2 = new LiveBirth("1263", "tot", Gender.MAN, 2002, 12345L);

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
		LiveBirth liveBirth = new LiveBirth("1263", "tot", Gender.MAN, 2002, 12345L);

		assertTrue(liveBirth.toString().contains("1263"));
		assertTrue(liveBirth.toString().contains("tot"));
		assertTrue(liveBirth.toString().contains("1"));
		assertTrue(liveBirth.toString().contains("2002"));
		assertTrue(liveBirth.toString().contains("12345"));
	}

}