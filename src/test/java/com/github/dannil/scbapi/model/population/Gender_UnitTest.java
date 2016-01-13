package com.github.dannil.scbapi.model.population;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Gender_UnitTest {

	@Test
	public final void genderValues() {
		assertNotNull(Gender.values());
	}

	@Test
	public final void genderValueOf() {
		Gender gender = Gender.valueOf("MAN");

		assertNotNull(gender);
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
