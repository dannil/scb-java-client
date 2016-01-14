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
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbapi.model.population.Gender;
import com.github.dannil.scbapi.model.population.RelationshipStatus;

@RunWith(JUnit4.class)
public class Population_UnitTest {

	@Test
	public void createWithDefaultConstructor() {
		Population population = new Population();

		assertNotNull(population);
	}

	@Test
	public void setRegion() {
		Population population = new Population();

		population.setRegion("1267");

		assertNotNull(population.getRegion());
	}

	@Test
	public void getRegion() {
		Population population = new Population();

		population.setRegion("1267");

		assertEquals("1267", population.getRegion());
	}

	@Test
	public void setRelationshipStatus() {
		Population population = new Population();

		population.setRelationshipStatus(RelationshipStatus.MARRIED);

		assertNotNull(population.getRelationshipStatus());
	}

	@Test
	public void getRelationshipStatus() {
		Population population = new Population();

		population.setRelationshipStatus(RelationshipStatus.MARRIED);

		assertEquals(RelationshipStatus.MARRIED, population.getRelationshipStatus());
	}

	@Test
	public void setAge() {
		Population population = new Population();

		population.setAge("20");

		assertNotNull(population.getAge());
	}

	@Test
	public void getAge() {
		Population population = new Population();

		population.setAge("20");

		assertEquals("20", population.getAge());
	}

	@Test
	public void setGender() {
		Population population = new Population();

		population.setGender(Gender.MAN);

		assertNotNull(population.getGender());
	}

	@Test
	public void getGender() {
		Population population = new Population();

		population.setGender(Gender.MAN);

		assertEquals(Gender.MAN, population.getGender());
	}

	@Test
	public void setYear() {
		Population population = new Population();

		population.setYear(2011);

		assertNotNull(population.getYear());
	}

	@Test
	public void getYear() {
		Population population = new Population();

		population.setYear(2011);

		assertEquals(Integer.valueOf(2011), population.getYear());
	}

	@Test
	public void setAmount() {
		Population population = new Population();

		population.setAmount(12345L);

		assertNotNull(population.getAmount());
	}

	@Test
	public void getAmount() {
		Population population = new Population();

		population.setAmount(12345L);

		assertEquals(Long.valueOf(12345L), population.getAmount());
	}

	@Test
	public void getCodes() {
		assertNotNull(Population.getCodes());
	}

	@Test
	public void equals() {
		Population population = new Population();
		Population population2 = new Population();

		assertEquals(population, population2);
	}

	@Test
	public void equalsItself() {
		Population population = new Population();

		assertEquals(population, population);
	}

	@Test
	public void notEqualsNull() {
		Population population = new Population();

		assertNotEquals(population, null);
	}

	@Test
	public void notEqualsIncompatibleObject() {
		Population population = new Population();

		assertNotEquals(population, new Object());
	}

	@Test
	public void equalsItselfWithValues() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertEquals(population, population2);
	}

	@Test
	public void notEqualsOnRegion() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setRegion("1452");

		assertNotEquals(population, population2);
	}

	@Test
	public void notEqualsOnFirstNullRegion() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population.setRegion(null);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertNotEquals(population, population2);
	}

	@Test
	public void notEqualsOnSecondNullRegion() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setRegion(null);

		assertNotEquals(population, population2);
	}

	@Test
	public void notEqualsOnRelationshipStatus() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setRelationshipStatus(RelationshipStatus.DIVORCED);

		assertNotEquals(population, population2);
	}

	@Test
	public void notEqualsOnFirstNullRelationshipStatus() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population.setRelationshipStatus(null);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertNotEquals(population, population2);
	}

	@Test
	public void notEqualsOnSecondNullRelationshipStatus() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setRelationshipStatus(null);

		assertNotEquals(population, population2);
	}

	@Test
	public void notEqualsOnAge() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setAge("56");

		assertNotEquals(population, population2);
	}

	@Test
	public void notEqualsOnFirstNullAge() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population.setAge(null);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertNotEquals(population, population2);
	}

	@Test
	public void notEqualsOnSecondNullAge() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setAge(null);

		assertNotEquals(population, population2);
	}

	@Test
	public void notEqualsOnGender() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setGender(Gender.WOMAN);

		assertNotEquals(population, population2);
	}

	@Test
	public void notEqualsOnFirstNullGender() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population.setGender(null);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertNotEquals(population, population2);
	}

	@Test
	public void notEqualsOnSecondNullGender() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setGender(null);

		assertNotEquals(population, population2);
	}

	@Test
	public void notEqualsOnYear() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setYear(1999);

		assertNotEquals(population, population2);
	}

	@Test
	public void notEqualsOnFirstNullYear() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population.setYear(null);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertNotEquals(population, population2);
	}

	@Test
	public void notEqualsOnSecondNullYear() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setYear(null);

		assertNotEquals(population, population2);
	}

	@Test
	public void notEqualsOnAmount() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setAmount(54321L);

		assertNotEquals(population, population2);
	}

	@Test
	public void notEqualsOnFirstNullAmount() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population.setAmount(null);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertNotEquals(population, population2);
	}

	@Test
	public void notEqualsOnSecondNullAmount() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		population2.setAmount(null);

		assertNotEquals(population, population2);
	}

	@Test
	public void equalsHashCode() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);
		Population population2 = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertEquals(population.hashCode(), population2.hashCode());
	}

	@Test
	public void equalsHashCodeNullValues() {
		Population population = new Population();
		Population population2 = new Population();

		assertEquals(population.hashCode(), population2.hashCode());
	}

	@Test
	public void convertToStringNullValues() {
		Population population = new Population();

		assertNotNull(population.toString());
	}

	@Test
	public void convertToString() {
		Population population = new Population("1267", RelationshipStatus.MARRIED, "20", Gender.MAN, 2011, 12345L);

		assertNotNull(population.toString());
	}

}