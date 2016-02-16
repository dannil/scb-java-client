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

package com.github.dannil.scbapi.utility;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class Localization_UnitTest {
	
	@Test
	public void createWithConstructor() {
		Localization localization = new Localization(new Locale("sv", "SE"));
		
		assertEquals(new Locale("sv", "SE"), localization.getLanguage());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void createWithConstructorNullArgument() {
		Localization localization = new Localization(null);
		
		assertNull(localization);
	}
	
	@Test
	public void getString() {
		Localization localization = new Localization(new Locale("sv", "SE"));
		
		assertEquals("TestSvenska", localization.getString("test"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void getStringNullArgument() {
		Localization localization = new Localization(new Locale("sv", "SE"));
		
		String s = localization.getString(null);
		
		assertNull(s);
	}
	
	@Test
	public void getStringFallback() {
		Localization localization = new Localization(new Locale("sv", "SE"));
		
		assertNotEquals(new Locale("en", "US"), localization.getLanguage());
		assertEquals("UniqueEnglish", localization.getString("unique"));
	}
	
	@Test
	public void setLanguage() {
		Localization localization = new Localization(new Locale("sv", "SE"));
		
		assertEquals("TestSvenska", localization.getString("test"));
		localization.setLanguage(new Locale("en", "US"));
		assertEquals("TestEnglish", localization.getString("test"));
	}

}
