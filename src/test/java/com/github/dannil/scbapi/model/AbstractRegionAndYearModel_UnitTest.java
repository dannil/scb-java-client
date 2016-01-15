package com.github.dannil.scbapi.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class AbstractRegionAndYearModel_UnitTest {

	// Dummy class which doesn't override AbstractRegionAndYearModel equals
	// method. This makes us able thoroughly test the equals method.
	public class DummyClass extends AbstractRegionAndYearModel<String, Integer> {

		public DummyClass() {
			super();
		}

		public DummyClass(String region, Integer year) {
			super(region, year);
		}

	}

	// Tests the superclass
	@Test
	public void superEqualsItself() {
		AbstractRegionAndYearModel<String, Integer> dummy = new DummyClass();

		assertEquals(dummy, dummy);
	}

	// Tests the superclass
	@Test
	public void superNotEqualsNull() {
		AbstractRegionAndYearModel<String, Integer> dummy = new DummyClass();

		assertNotEquals(dummy, null);
	}

	// Tests the superclass
	@Test
	public void superNotEqualsIncompatibleObject() {
		AbstractRegionAndYearModel<String, Integer> dummy = new DummyClass();

		assertNotEquals(dummy, new Object());
	}

}
