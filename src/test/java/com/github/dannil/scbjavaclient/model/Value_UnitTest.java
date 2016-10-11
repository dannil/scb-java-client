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
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Value_UnitTest {

	@Test
	public void equalsCopyConstructor() {
		Value<Double> value1 = new Value<Double>(11.22d, "TESTCODE", "TESTTEXT");
		Value<Double> value2 = new Value<Double>(value1);

		assertEquals(value1, value2);
	}

	@Test
	public final void createWithDefaultConstructor() {
		Value<Double> value = new Value<Double>();

		assertNotNull(value);
	}

	@Test
	public void setValue() {
		Value<Double> value = new Value<Double>();

		value.setValue(11.22d);

		assertEquals(Double.valueOf(11.22d), value.getValue());
	}

	@Test
	public void setCode() {
		Value<Double> value = new Value<Double>();

		value.setCode("TESTCODE");

		assertEquals("TESTCODE", value.getCode());
	}

	@Test
	public void setText() {
		Value<Double> value = new Value<Double>();

		value.setText("TESTTEXT");

		assertEquals("TESTTEXT", value.getText());
	}

	@Test
	public void equals() {
		Value<Double> value = new Value<Double>();
		Value<Double> value2 = new Value<Double>();

		assertEquals(value, value2);
	}

	@Test
	public void equalsItself() {
		Value<Double> value = new Value<Double>();

		assertEquals(value, value);
	}

	@Test
	public void equalsItselfWithValues() {
		Value<Double> value = new Value<Double>(11.22d, "TESTCODE", "TESTTEXT");
		Value<Double> value2 = new Value<Double>(11.22d, "TESTCODE", "TESTTEXT");

		assertEquals(value, value2);
	}

	@Test
	public void notEqualsNull() {
		Value<Double> value = new Value<Double>();

		assertNotEquals(value, null);
	}

	@Test
	public void notEqualsIncompatibleObject() {
		Value<Double> value = new Value<Double>();

		assertNotEquals(value, new Object());
	}

	@Test
	public void notEqualsValue() {
		Value<Double> value = new Value<Double>(11.22d, "TESTCODE", "TESTTEXT");
		Value<Double> value2 = new Value<Double>(55.66d, "TESTCODE", "TESTTEXT");

		assertNotEquals(value, value2);
	}

	@Test
	public void notEqualsCode() {
		Value<Double> value = new Value<Double>(11.22d, "TESTCODE", "TESTTEXT");
		Value<Double> value2 = new Value<Double>(11.22d, "ANOTHERTESTCODENOTEQUAL", "TESTTEXT");

		assertNotEquals(value, value2);
	}

	@Test
	public void notEqualsText() {
		Value<Double> value = new Value<Double>(11.22d, "TESTCODE", "TESTTEXT");
		Value<Double> value2 = new Value<Double>(11.22d, "TESTCODE", "ANOTHERTESTTEXTNOTEQUAL");

		assertNotEquals(value, value2);
	}

	@Test
	public void equalsHashCode() {
		Value<Double> value = new Value<Double>(11.22d, "TESTCODE", "TESTTEXT");
		Value<Double> value2 = new Value<Double>(11.22d, "TESTCODE", "TESTTEXT");

		assertEquals(value.hashCode(), value2.hashCode());
	}

	@Test
	public void equalsHashCodeNullValues() {
		Value<Double> value = new Value<Double>();
		Value<Double> value2 = new Value<Double>();

		assertEquals(value.hashCode(), value2.hashCode());
	}

	@Test
	public void convertToStringNullValues() {
		Value<Double> value = new Value<Double>();

		assertNotNull(value.toString());
	}

	@Test
	public void convertToString() {
		Value<Double> value = new Value<Double>(11.22d, "TESTCODE", "TESTTEXT");

		assertTrue(value.toString().contains("11.22"));
		assertTrue(value.toString().contains("TESTCODE"));
		assertTrue(value.toString().contains("TESTTEXT"));
	}

}
