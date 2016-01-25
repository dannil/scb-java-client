package com.github.dannil.scbapi.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AbstractModel_UnitTest {

	// Dummy class which doesn't override AbstractModel equals
	// method. This makes us able thoroughly test the equals method.
	public class DummyClass extends AbstractModel<Long> {

		public DummyClass() {

		}

		public DummyClass(Long value) {
			super(value);
		}

	}

	// Tests the superclass
	@Test
	public void superEqualsItself() {
		AbstractModel<Long> dummy = new DummyClass();

		assertEquals(dummy, dummy);
	}

	// Tests the superclass
	@Test
	public void superNotEqualsNull() {
		AbstractModel<Long> dummy = new DummyClass();

		assertNotEquals(dummy, null);
	}

	// Tests the superclass
	@Test
	public void superNotEqualsIncompatibleObject() {
		AbstractModel<Long> dummy = new DummyClass();

		assertNotEquals(dummy, new Object());
	}

}
