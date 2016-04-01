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

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AbstractYearAndValueModel_UnitTest {

	// Dummy class which doesn't override the equals
	// method. This enables us to thoroughly test the equals method.
	public class DummyClass extends AbstractYearAndValueModel<Integer, Long> {

		public DummyClass() {
			super();
		}

		@Override
		public String toString() {
			return "Dummy";
		}

	}

	// Tests the superclass
	@Test
	public void superEqualsItself() {
		AbstractYearAndValueModel<Integer, Long> dummy = new DummyClass();

		assertEquals(dummy, dummy);
	}

	// Tests the superclass
	@Test
	public void superNotEqualsNull() {
		AbstractYearAndValueModel<Integer, Long> dummy = new DummyClass();

		assertNotEquals(dummy, null);
	}

	// Tests the superclass
	@Test
	public void superNotEqualsIncompatibleObject() {
		AbstractYearAndValueModel<Integer, Long> dummy = new DummyClass();

		assertNotEquals(dummy, new Object());
	}

}
