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

package com.github.dannil.scbjavaclient.utility;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Class for handling localization for the clients.
 * 
 * @author Daniel Nilsson
 */
public class Localization {

	private Locale fallbackLocale;

	private ResourceBundle bundle;

	/**
	 * Overloaded constructor.
	 * 
	 * @param locale
	 *            the locale for this localization instance
	 */
	public Localization(Locale locale) {
		this.fallbackLocale = new Locale("en", "US");

		this.bundle = ResourceBundle.getBundle("language", locale);
	}

	/**
	 * Getter for the language for this localization instance. This is the same as the locale
	 * specified in {@link Localization#getLanguage() getLanguage()}.
	 * 
	 * @return the language for this localization instance.
	 */
	public Locale getLanguage() {
		return this.bundle.getLocale();
	}

	/**
	 * Setter for the language for this localization instance.
	 * 
	 * @param locale
	 *            the locale
	 */
	public void setLanguage(Locale locale) {
		this.bundle = ResourceBundle.getBundle("language", locale);
	}

	/**
	 * Returns the translation for the specified key. If it can't find the key in the current
	 * specified language's localization file, it attempts to use the fallback locale's localization
	 * file as the translation source.
	 * 
	 * @param key
	 *            the key to get the translation for
	 * @return the translated string
	 */
	public String getString(String key) {
		String s;
		try {
			s = this.bundle.getString(key);
		} catch (MissingResourceException e2) {
			s = ResourceBundle.getBundle("language", this.fallbackLocale).getString(key);
		}
		return s;
	}

	/**
	 * Returns a formatted translation for the specified key.
	 * 
	 * @param key
	 *            the key to get the translation for
	 * @param variables
	 *            the variables which shall be inserted into the translation
	 * @return the translated string
	 */
	public String getString(String key, Object[] variables) {
		MessageFormat formatter = new MessageFormat("");
		formatter.setLocale(getLanguage());

		formatter.applyPattern(getString(key));
		String output = formatter.format(variables);

		return output;

		// return s;
	}

}
