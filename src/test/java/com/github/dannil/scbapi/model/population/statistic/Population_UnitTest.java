/*
Copyright 2014 Daniel Nilsson

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
import com.github.dannil.scbapi.model.population.RelationshipStatus;

@RunWith(JUnit4.class)
public class Population_UnitTest {

	@Test
	public final void createWithDefaultConstructor() {
		Population population = new Population();

		assertNotNull(population);
	}

	@Test
	public final void setRegion() {
		Population population = new Population();

		population.setRegion("1267");

		assertNotNull(population.getRegion());
	}

	@Test
	public final void getRegion() {
		Population population = new Population();

		population.setRegion("1267");

		assertEquals("1267", population.getRegion());
	}

	@Test
	public final void setRelationshipStatus() {
		Population population = new Population();

		population.setRelationshipStatus(RelationshipStatus.MARRIED);

		assertNotNull(population.getRelationshipStatus());
	}

	@Test
	public final void getRelationshipStatus() {
		Population population = new Population();

		population.setRelationshipStatus(RelationshipStatus.MARRIED);

		assertEquals(RelationshipStatus.MARRIED, population.getRelationshipStatus());
	}

	@Test
	public final void setAge() {
		Population population = new Population();

		population.setAge("20");

		assertNotNull(population.getAge());
	}

	@Test
	public final void getAge() {
		Population population = new Population();

		population.setAge("20");

		assertEquals("20", population.getAge());
	}

	@Test
	public final void setGender() {
		Population population = new Population();

		population.setGender(Gender.MAN);

		assertNotNull(population.getGender());
	}

	@Test
	public final void getGender() {
		Population population = new Population();

		population.setGender(Gender.MAN);

		assertEquals(Gender.MAN, population.getGender());
	}

	@Test
	public final void setYear() {
		Population population = new Population();

		population.setYear(2011);

		assertNotNull(population.getYear());
	}

	@Test
	public final void getYear() {
		Population population = new Population();

		population.setYear(2011);

		assertEquals(Integer.valueOf(2011), population.getYear());
	}

	@Test
	public final void setAmount() {
		Population population = new Population();

		population.setAmount(12345L);

		assertNotNull(population.getAmount());
	}

	@Test
	public final void getAmount() {
		Population population = new Population();

		population.setAmount(12345L);

		assertEquals(Long.valueOf(12345L), population.getAmount());
	}

	@Test
	public final void getCodes() {
		assertNotNull(Population.getCodes());
	}

	@Test
	public final void equals() {
		Population population = new Population();
		Population population2 = new Population();

		assertTrue(population.equals(population2));
	}

	@Test
	public final void equalsItself() {
		Population population = new Population();

		assertTrue(population.equals(population));
	}

	@Test
	public final void notEqualsNull() {
		Population population = new Population();

		assertFalse(population.equals(null));
	}

	@Test
	public final void notEqualsIncompatibleObject() {
		Population population = new Population();

		assertFalse(population.equals(new Object()));
	}

	@Test
	public final void equalsItselfWithValues() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertTrue(population.equals(population2));
	}

	@Test
	public final void notEqualsOnRegion() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setRegion("1452");

		assertFalse(population.equals(population2));
	}

	@Test
	public final void notEqualsOnFirstNullRegion() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population.setRegion(null);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertFalse(population.equals(population2));
	}

	@Test
	public final void notEqualsOnSecondNullRegion() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setRegion(null);

		assertFalse(population.equals(population2));
	}

	@Test
	public final void notEqualsOnRelationshipStatus() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setRelationshipStatus(RelationshipStatus.DIVORCED);

		assertFalse(population.equals(population2));
	}

	@Test
	public final void notEqualsOnFirstNullRelationshipStatus() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population.setRelationshipStatus(null);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertFalse(population.equals(population2));
	}

	@Test
	public final void notEqualsOnSecondNullRelationshipStatus() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setRelationshipStatus(null);

		assertFalse(population.equals(population2));
	}

	@Test
	public final void notEqualsOnAge() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setAge("56");

		assertFalse(population.equals(population2));
	}

	@Test
	public final void notEqualsOnFirstNullAge() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population.setAge(null);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertFalse(population.equals(population2));
	}

	@Test
	public final void notEqualsOnSecondNullAge() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setAge(null);

		assertFalse(population.equals(population2));
	}

	@Test
	public final void notEqualsOnGender() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setGender(Gender.WOMAN);

		assertFalse(population.equals(population2));
	}

	@Test
	public final void notEqualsOnFirstNullGender() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population.setGender(null);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertFalse(population.equals(population2));
	}

	@Test
	public final void notEqualsOnSecondNullGender() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setGender(null);

		assertFalse(population.equals(population2));
	}

	@Test
	public final void notEqualsOnYear() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setYear(1999);

		assertFalse(population.equals(population2));
	}

	@Test
	public final void notEqualsOnFirstNullYear() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population.setYear(null);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertFalse(population.equals(population2));
	}

	@Test
	public final void notEqualsOnSecondNullYear() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setYear(null);

		assertFalse(population.equals(population2));
	}

	@Test
	public final void notEqualsOnAmount() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setAmount(54321L);

		assertFalse(population.equals(population2));
	}

	@Test
	public final void notEqualsOnFirstNullAmount() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population.setAmount(null);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertFalse(population.equals(population2));
	}

	@Test
	public final void notEqualsOnSecondNullAmount() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setAmount(null);

		assertFalse(population.equals(population2));
	}

	@Test
	public final void equalsHashCode() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertEquals(population.hashCode(), population2.hashCode());
	}

	@Test
	public final void equalsHashCodeNullValues() {
		Population population = new Population();
		Population population2 = new Population();

		assertEquals(population.hashCode(), population2.hashCode());
	}

	@Test
	public final void convertToString() {
		Population population = new Population();

		assertNotNull(population.toString());
	}

	@Test
	public final void convertToStringNullValues() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertNotNull(population.toString());
	}

	@Test
	public final void relationshipStatusValues() {
		assertNotNull(RelationshipStatus.values());
	}

	@Test
	public final void genderValues() {
		assertNotNull(Gender.values());
	}

	@Test
	public final void relationshipStatusValueOf() {
		RelationshipStatus status = RelationshipStatus.valueOf("UNMARRIED");

		assertNotNull(status);
	}

	@Test
	public final void genderValueOf() {
		Gender gender = Gender.valueOf("MAN");

		assertNotNull(gender);
	}

	@Test
	public final void convertValueToRelationshipStatus() {
		RelationshipStatus status = RelationshipStatus.of("OG");

		assertNotNull(status);
	}

	@Test(expected = IllegalArgumentException.class)
	public final void illegalArgumentForType() {
		RelationshipStatus.of("ABC");
	}

	@Test
	public final void convertValueToGender() {
		Gender gender = Gender.of(1);

		assertNotNull(gender);
	}

	@Test(expected = IllegalArgumentException.class)
	public final void illegalArgumentForGender() {
		Gender.of(-1);
	}

}