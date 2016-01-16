package com.github.dannil.scbapi.api;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SCBAPI_UnitTest {

	@Test
	public void createWithLocaleConstructor() {
		Locale locale = new Locale("sv", "SE");
		SCBAPI api = new SCBAPI(locale);

		assertEquals(locale, api.getLocale());
	}

}
