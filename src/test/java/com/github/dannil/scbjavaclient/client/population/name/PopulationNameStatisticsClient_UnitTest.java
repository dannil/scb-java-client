package com.github.dannil.scbjavaclient.client.population.name;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class PopulationNameStatisticsClient_UnitTest {

	@Test
	public void createWithLocaleConstructor() {
		Locale locale = new Locale("sv", "SE");
		PopulationNameStatisticsClient client = new PopulationNameStatisticsClient(locale);

		assertEquals(locale, client.getLocale());
	}

}
