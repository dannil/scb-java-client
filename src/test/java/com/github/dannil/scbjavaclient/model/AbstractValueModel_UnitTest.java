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

package com.github.dannil.scbjavaclient.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AbstractValueModel_UnitTest {

	private List<Value<Long>> values;

	// Dummy class which doesn't override the equals
	// method. This enables us to thoroughly test the equals method.
	public class DummyClass extends AbstractValueModel<Long> {

		public DummyClass() {

		}

		public DummyClass(List<Value<Long>> values) {
			super(values);
		}

		@Override
		public String toString() {
			return "Dummy";
		}

	}

	@Before
	public void setup() {
		this.values = new ArrayList<Value<Long>>();

		Value<Long> value1 = new Value<Long>(12345L, "TESTCODE", "TESTTEXT");
		Value<Long> value2 = new Value<Long>(54321L, "ANOTHERTESTCODE", "ANOTHERTESTTEXT");
		this.values.add(value1);
		this.values.add(value2);
	}

	@Test
	public void getValue() {
		DummyClass dm = new DummyClass(this.values);

		assertNotNull(dm.getValue("TESTCODE"));
	}

	@Test
	public void getValueNoMatchingKey() {
		DummyClass dm = new DummyClass(this.values);

		assertNull(dm.getValue("THISTESTCODEDOESNTEXIST"));
	}

	@Test
	public void setValue() {
		DummyClass dm = new DummyClass(this.values);

		dm.setValue("TESTCODE", 98765L);

		assertEquals(Long.valueOf(98765L), dm.getValue("TESTCODE").getValue());
	}

	@Test
	public void setValueNoMatchingKey() {
		DummyClass dm = new DummyClass(this.values);

		dm.setValue("THISTESTCODEDOESNTEXIST", 56789L);

		assertEquals(dm.getValues(), this.values);
	}

	// Tests the superclass
	@Test
	public void superEqualsItself() {
		AbstractValueModel<Long> dummy = new DummyClass();

		assertEquals(dummy, dummy);
	}

	// Tests the superclass
	@Test
	public void superNotEqualsNull() {
		AbstractValueModel<Long> dummy = new DummyClass();

		assertNotEquals(dummy, null);
	}

	// Tests the superclass
	@Test
	public void superNotEqualsIncompatibleObject() {
		AbstractValueModel<Long> dummy = new DummyClass();

		assertNotEquals(dummy, new Object());
	}

}
