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
public class AbstractValueModelTest {

	private List<ValueNode<Long>> valueNodes;

	// Dummy class which doesn't override the equals
	// method. This enables us to thoroughly test the equals method.
	public class DummyClass extends AbstractValueModel<Long> {

		public DummyClass() {

		}

		public DummyClass(List<ValueNode<Long>> values) {
			super(values);
		}

		@Override
		public String toString() {
			return "Dummy";
		}

	}

	@Before
	public void setup() {
		this.valueNodes = new ArrayList<ValueNode<Long>>();

		ValueNode<Long> value1 = new ValueNode<Long>(12345L, "TESTCODE", "TESTTEXT");
		ValueNode<Long> value2 = new ValueNode<Long>(54321L, "ANOTHERTESTCODE", "ANOTHERTESTTEXT");
		this.valueNodes.add(value1);
		this.valueNodes.add(value2);
	}

	@Test
	public void getValue() {
		DummyClass dm = new DummyClass(this.valueNodes);

		assertNotNull(dm.getValue("TESTCODE"));
	}

	@Test
	public void getValueNoMatchingKey() {
		DummyClass dm = new DummyClass(this.valueNodes);

		assertNull(dm.getValue("THISTESTCODEDOESNTEXIST"));
	}

	@Test
	public void setValue() {
		DummyClass dm = new DummyClass(this.valueNodes);

		dm.setValue("TESTCODE", 98765L);

		assertEquals(Long.valueOf(98765L), dm.getValue("TESTCODE").getValue());
	}

	@Test
	public void setValueNoMatchingKey() {
		DummyClass dm = new DummyClass(this.valueNodes);

		dm.setValue("THISTESTCODEDOESNTEXIST", 56789L);

		assertEquals(dm.getValues(), this.valueNodes);
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
