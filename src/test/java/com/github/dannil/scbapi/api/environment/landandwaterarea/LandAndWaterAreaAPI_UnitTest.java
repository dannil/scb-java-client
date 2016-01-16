package com.github.dannil.scbapi.api.environment.landandwaterarea;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class LandAndWaterAreaAPI_UnitTest {

	@Test
	public void createWithLocaleConstructor() {
		Locale locale = new Locale("sv", "SE");
		LandAndWaterAreaAPI api = new LandAndWaterAreaAPI(locale);

		assertEquals(locale, api.getLocale());
	}

}
