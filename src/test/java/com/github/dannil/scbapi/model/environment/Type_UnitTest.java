package com.github.dannil.scbapi.model.environment;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Type_UnitTest {

	@Test
	public final void typeValues() {
		assertNotNull(Type.values());
	}

	@Test
	public final void typeValueOf() {
		Type type = Type.valueOf("LANDAREA");

		assertNotNull(type);
	}

	@Test
	public final void convertValueToType() {
		Type type = Type.of("01");

		assertNotNull(type);
	}

	@Test(expected = IllegalArgumentException.class)
	public final void illegalArgumentForType() {
		Type.of("ABC");
	}

}
