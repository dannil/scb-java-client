package com.github.dannil.scbapi.utility;

import java.util.Locale;
import java.util.ResourceBundle;

public class Localization {

	private static ResourceBundle bundle;

	public static void setLanguage(Locale locale) {
		bundle = ResourceBundle.getBundle("language", locale);
	}

	public static String getString(String key) {
		String s = bundle.getString(key);
		if (s == null) {
			s = ResourceBundle.getBundle("language", new Locale("en", "US")).getString(key);
		}
		return s;
	}
}
