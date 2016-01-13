/*
Copyright 2016 Daniel Nilsson

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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.github.dannil.scbapi.model.Gender;

@RunWith(JUnit4.class)
public class LiveBirth_UnitTest {

	@Test
	public final void createWithDefaultConstructor() {
		LiveBirth liveBirth = new LiveBirth();

		assertNotNull(liveBirth);
	}

	@Test
	public final void getCodes() {
		assertNotNull(LiveBirth.getCodes());
	}

	@Test
	public final void equals() {
		LiveBirth LiveBirth = new LiveBirth();
		LiveBirth LiveBirth2 = new LiveBirth();

		assertTrue(LiveBirth.equals(LiveBirth2));
	}

	@Test
	public final void equalsItself() {
		LiveBirth LiveBirth = new LiveBirth();

		assertTrue(LiveBirth.equals(LiveBirth));
	}

	@Test
	public final void notEqualsNull() {
		LiveBirth LiveBirth = new LiveBirth();

		assertFalse(LiveBirth.equals(null));
	}

	@Test
	public final void notEqualsIncompatibleObject() {
		LiveBirth LiveBirth = new LiveBirth();

		assertFalse(LiveBirth.equals(new Object()));
	}

	@Test
	public final void equalsItselfWithValues() {
		LiveBirth liveBirth = new LiveBirth("1263", "tot", Gender.MAN, 2002, 12345L);
		LiveBirth liveBirth2 = new LiveBirth("1263", "tot", Gender.MAN, 2002, 12345L);

		assertTrue(liveBirth.equals(liveBirth2));
	}

}