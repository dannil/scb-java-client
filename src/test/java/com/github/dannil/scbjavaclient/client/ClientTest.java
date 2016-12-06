package com.github.dannil.scbjavaclient.client;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ClientTest {

	private static class DummyContainerClient extends ContainerClient {

		public DummyContainerClient(Locale locale) {
			super(locale);
		}

	}

	@Test
	public void createWithLocaleConstructor() {
		Locale locale = new Locale("sv", "SE");
		ContainerClient client = new DummyContainerClient(locale);

		assertEquals(locale, client.getLocale());
	}

}
