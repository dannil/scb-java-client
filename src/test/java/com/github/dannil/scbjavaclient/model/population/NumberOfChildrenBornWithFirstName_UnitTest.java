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

package com.github.dannil.scbjavaclient.model.population;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class NumberOfChildrenBornWithFirstName_UnitTest {

	@Test
	public final void createWithDefaultConstructor() {
		NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName();

		assertNotNull(nbrChildren);
	}

	@Test
	public void setFirstname() {
		NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName();

		nbrChildren.setFirstname("Adrian");

		assertEquals("Adrian", nbrChildren.getFirstname());
	}

	@Test
	public void setYear() {
		NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName();

		nbrChildren.setYear(2010);

		assertEquals(Integer.valueOf(2010), nbrChildren.getYear());
	}

	@Test
	public void setValue() {
		NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName();

		nbrChildren.setValue("15");

		assertEquals("15", nbrChildren.getValue());
	}

	@Test
	public void getCodes() {
		assertNotNull(NumberOfChildrenBornWithFirstName.getCodes());
	}

	@Test
	public void equals() {
		NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName();
		NumberOfChildrenBornWithFirstName nbrChildren2 = new NumberOfChildrenBornWithFirstName();

		assertEquals(nbrChildren, nbrChildren2);
	}

	@Test
	public void equalsItself() {
		NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName();

		assertEquals(nbrChildren, nbrChildren);
	}

	@Test
	public void equalsItselfWithValues() {
		NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName("Adrian", 2010, "15");
		NumberOfChildrenBornWithFirstName nbrChildren2 = new NumberOfChildrenBornWithFirstName("Adrian", 2010, "15");

		assertEquals(nbrChildren, nbrChildren2);
	}

	@Test
	public void notEqualsNull() {
		NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName();

		assertNotEquals(nbrChildren, null);
	}

	@Test
	public void notEqualsIncompatibleObject() {
		NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName();

		assertNotEquals(nbrChildren, new Object());
	}

	@Test
	public void notEqualsFirstname() {
		NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName("Adrian", 2010, "15");
		NumberOfChildrenBornWithFirstName nbrChildren2 = new NumberOfChildrenBornWithFirstName("Bob", 2010, "15");

		assertNotEquals(nbrChildren, nbrChildren2);
	}

	@Test
	public void notEqualsYear() {
		NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName("Adrian", 2010, "15");
		NumberOfChildrenBornWithFirstName nbrChildren2 = new NumberOfChildrenBornWithFirstName("Adrian", 2005, "15");

		assertNotEquals(nbrChildren, nbrChildren2);
	}

	@Test
	public void notEqualsValue() {
		NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName("Adrian", 2010, "15");
		NumberOfChildrenBornWithFirstName nbrChildren2 = new NumberOfChildrenBornWithFirstName("Adrian", 2010, "30");

		assertNotEquals(nbrChildren, nbrChildren2);
	}

	@Test
	public void equalsHashCode() {
		NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName("Adrian", 2010, "15");
		NumberOfChildrenBornWithFirstName nbrChildren2 = new NumberOfChildrenBornWithFirstName("Adrian", 2010, "15");

		assertEquals(nbrChildren.hashCode(), nbrChildren2.hashCode());
	}

	@Test
	public void equalsHashCodeNullValues() {
		NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName();
		NumberOfChildrenBornWithFirstName nbrChildren2 = new NumberOfChildrenBornWithFirstName();

		assertEquals(nbrChildren.hashCode(), nbrChildren2.hashCode());
	}

	@Test
	public void convertToStringNullValues() {
		NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName();

		assertNotNull(nbrChildren.toString());
	}

	@Test
	public void convertToString() {
		NumberOfChildrenBornWithFirstName nbrChildren = new NumberOfChildrenBornWithFirstName("Adrian", 2010, "15");

		assertTrue(nbrChildren.toString().contains("Adrian"));
		assertTrue(nbrChildren.toString().contains("2010"));
		assertTrue(nbrChildren.toString().contains("15"));
	}

}
